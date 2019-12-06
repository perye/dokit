package com.perye.dokit.service;

import com.perye.dokit.dto.LogQueryCriteria;
import com.perye.dokit.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

/**
 * 日志
 */
public interface LogService {

    Object queryAll(LogQueryCriteria criteria, Pageable pageable);

    Object queryAllByUser(LogQueryCriteria criteria, Pageable pageable);

    @Async
    void save(String username, String ip, ProceedingJoinPoint joinPoint, Log log);

    /**
     * 查询异常详情
     * @param id 日志ID
     * @return Object
     */
    Object findByErrDetail(Long id);

}
