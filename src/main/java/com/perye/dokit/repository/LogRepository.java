package com.perye.dokit.repository;

import com.perye.dokit.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 日志
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Long>, JpaSpecificationExecutor {

    /**
     * 获取一个时间段的IP记录
     * @param date1
     * @param date2
     * @return
     */
    @Query(value = "select count(*) from (select request_ip FROM log where create_time between ?1 and ?2 GROUP BY request_ip) as s)",nativeQuery = true)
    Long findIp(String date1, String date2);

    /**
     * 根据id查看异常详情
     *
     * @param id
     * @return
     */
    @Query(value = "select exception_detail from log where id = ?1", nativeQuery = true)
    String findExceptionById(Long id);

}
