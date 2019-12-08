package com.perye.dokit.service;

import com.perye.dokit.dto.LogQueryCriteria;
import com.perye.dokit.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 日志
 */
public interface LogService {

    Object queryAll(LogQueryCriteria criteria, Pageable pageable);

    List<Log> queryAll(LogQueryCriteria criteria);

    Object queryAllByUser(LogQueryCriteria criteria, Pageable pageable);

    @Async
    void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log);

    /**
     * 查询异常详情
     *
     * @param id 日志ID
     * @return Object
     */
    Object findByErrDetail(Long id);

    void download(List<Log> queryAll, HttpServletResponse response) throws IOException;


}
