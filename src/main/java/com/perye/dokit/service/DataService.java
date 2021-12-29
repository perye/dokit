package com.perye.dokit.service;

import com.perye.dokit.dto.UserDto;
import com.perye.dokit.entity.Dept;

import java.util.List;

/**
 * 数据权限服务类
 */
public interface DataService {

    /**
     * 获取数据权限
     * @param user /
     * @return /
     */
    List<Long> getDeptIds(UserDto user);

}
