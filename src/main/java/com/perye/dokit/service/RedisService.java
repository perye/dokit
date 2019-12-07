package com.perye.dokit.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RedisService {

    /**
     * findById
     * @param key 键
     * @return /
     */
    Page findByKey(String key, Pageable pageable);

    /**
     * 查询验证码的值
     * @param key 键
     * @return /
     */
    String getCodeVal(String key);

    /**
     * 保存验证码
     * @param key 键
     * @param val 值
     */
    void saveCode(String key, Object val);

    /**
     * delete
     * @param key 键
     */
    void delete(String key);

    /**
     * 清空缓存
     */
    void deleteAll();
}

