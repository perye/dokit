package com.perye.dokit.config;

import com.perye.dokit.utils.SecurityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "dokit")
public class DokitPermissionConfig {

    public Boolean check(String ...permissions){
        // 如果是匿名访问的，就放行
        String anonymous = "anonymous";
        if (Arrays.asList(permissions).contains(anonymous)) {
            return true;
        }
        List<String> dokitPermissions = SecurityUtils.getUserDetails().getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        List<String> list = Arrays.stream(permissions).filter(dokitPermissions::contains).collect(Collectors.toList());
        return dokitPermissions.contains("admin") || list.size() != 0;
    }

}
