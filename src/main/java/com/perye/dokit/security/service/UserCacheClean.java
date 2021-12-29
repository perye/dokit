package com.perye.dokit.security.service;

import com.perye.dokit.service.impl.UserDetailsServiceImpl;
import com.perye.dokit.utils.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 用于清理 用户登录信息缓存，为防止Spring循环依赖与安全考虑 ，单独构成工具类
 */
@Component
public class UserCacheClean {


    /**
     * 清理特定用户缓存信息<br>
     * 用户信息变更时
     *
     * @param userName
     */
    public void cleanUserCache(String userName) {
        if (StringUtils.isNotEmpty(userName)) {
            UserDetailsServiceImpl.userDtoCache.remove(userName);
        }
    }

    /**
     * 清理所有用户的缓存信息<br>
     * ,如发生角色授权信息变化，可以简便的全部失效缓存
     */
    public void cleanAll() {
        UserDetailsServiceImpl.userDtoCache.clear();
    }
}