package com.perye.dokit.service;

import com.perye.dokit.dto.UserDTO;
import com.perye.dokit.entity.Role;
import com.perye.dokit.repository.RoleRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "role")
public class JwtPermissionService {

    private final RoleRepository roleRepository;

    public JwtPermissionService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    /**
     * key的名称如有修改，请同步修改 UserServiceImpl 中的 update 方法
     * @param user 用户信息
     * @return Collection
     */
    @Cacheable(key = "'loadPermissionByUser:' + #p0.username")
    public Collection<GrantedAuthority> mapToGrantedAuthorities(UserDTO user) {

        System.out.println("--------------------loadPermissionByUser:" + user.getUsername() + "---------------------");

        Set<Role> roles = roleRepository.findByUsers_Id(user.getId());

        return roles.stream().flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
    }
}

