package com.perye.dokit.service;

import com.perye.dokit.vo.RedisVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface RedisService {

    /**
     * 根据KEY查询
     * @param key 键
     * @return /
     */
    Page findByKey(String key, Pageable pageable);

    /**
     * findById
     * @param key 键
     * @return /
     */
    List<RedisVo> findByKey(String key);

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
     * @param ids 键数组
     */
    void delete(Set<String> ids);

    /**
     * 导出数据
     * @param redisVos /
     * @param response /
     */
    void download(List<RedisVo> redisVos, HttpServletResponse response) throws IOException;
}

