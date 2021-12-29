package com.perye.dokit.service.impl;

import com.perye.dokit.config.bean.LoginProperties;
import com.perye.dokit.dto.UserDto;
import com.perye.dokit.exception.BadRequestException;
import com.perye.dokit.exception.EntityNotFoundException;
import com.perye.dokit.service.DataService;
import com.perye.dokit.service.RoleService;
import com.perye.dokit.service.UserService;
import com.perye.dokit.vo.JwtUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service("userDetailsService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    private final RoleService roleService;

    private final DataService dataService;

    private final LoginProperties loginProperties;

    public void setEnableCache(boolean enableCache) {
        this.loginProperties.setCacheEnable(enableCache);
    }

    /**
     * 用户信息缓存
     */
    public static Map<String, JwtUserDto> userDtoCache = new ConcurrentHashMap<>();

    @Override
    public JwtUserDto loadUserByUsername(String username) {
        boolean searchDb = true;
        JwtUserDto jwtUserDto = null;
        if (loginProperties.isCacheEnable() && userDtoCache.containsKey(username)) {
            jwtUserDto = userDtoCache.get(username);
            searchDb = false;
        }
        if (searchDb) {
            UserDto user;
            try {
                user = userService.findByName(username);
            } catch (EntityNotFoundException e) {
                // SpringSecurity会自动转换UsernameNotFoundException为BadCredentialsException
                throw new UsernameNotFoundException("", e);
            }
            if (user == null) {
                throw new UsernameNotFoundException("");
            } else {
                if (!user.getEnabled()) {
                    throw new BadRequestException("账号未激活");
                }
                jwtUserDto = new JwtUserDto(
                        user,
                        dataService.getDeptIds(user),
                        roleService.mapToGrantedAuthorities(user)
                );
                userDtoCache.put(username, jwtUserDto);
            }

        }
        return jwtUserDto;
    }
}

