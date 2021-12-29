package com.perye.dokit.utils;

/**
 * 关于缓存的Key 集合
 */
public interface CacheKey {
    /**
     * 内置 用户、岗位、应用、菜单、角色 相关key
     */
    String USER_MODIFY_TIME_KEY = "user:modify:time:key:";
    String APP_MODIFY_TIME_KEY = "app:modify:time:key:";
    String JOB_MODIFY_TIME_KEY = "job:modify:time:key:";
    String MENU_MODIFY_TIME_KEY = "menu:modify:time:key:";
    String ROLE_MODIFY_TIME_KEY = "role:modify:time:key:";
    String DEPT_MODIFY_TIME_KEY = "dept:modify:time:key:";

    /**
     * 用户
     */
    String USER_ID = "user::id:";

    String USER_NAME = "user::username:";

    /**
     * 数据
     */

    String DATE_USER = "data::user:";

    /**
     * 菜单
     */
    String MENU_USER = "menu::user:";

    /**
     * 角色授权
     */
    String ROLE_AUTH = "role::auth:";

    /**
     * 角色信息
     */
    String ROLE_ID = "role::id:";
}