package com.perye.dokit.service;

import com.perye.dokit.dto.DeptSmallDto;
import com.perye.dokit.dto.JobSmallDto;
import com.perye.dokit.dto.UserDto;
import com.perye.dokit.exception.BadRequestException;
import com.perye.dokit.security.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    private final JwtPermissionServiceImpl permissionService;

    public JwtUserDetailsServiceImpl(UserService userService, JwtPermissionServiceImpl permissionService) {
        this.userService = userService;
        this.permissionService = permissionService;
    }
    @Override
    public UserDetails loadUserByUsername(String username){

        UserDto user = userService.findByName(username);
        if (user == null) {
            throw new BadRequestException("账号不存在");
        } else {
            return createJwtUser(user);
        }
    }

    public UserDetails createJwtUser(UserDto user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),
                user.getPhone(),
                Optional.ofNullable(user.getDept()).map(DeptSmallDto::getName).orElse(null),
                Optional.ofNullable(user.getJob()).map(JobSmallDto::getName).orElse(null),
                permissionService.mapToGrantedAuthorities(user),
                user.getEnabled(),
                user.getCreateTime(),
                user.getLastPasswordResetTime()
        );
    }
}

