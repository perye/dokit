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
public interface LogRepository extends JpaRepository<Log, Long>, JpaSpecificationExecutor<Log> {

    /**
     * 获取一个时间段的IP记录
     */
    @Query(value = "select count(*) from (select request_ip FROM log where create_time between ?1 and ?2 GROUP BY request_ip) as s",nativeQuery = true)
    Long findIp(String date1, String date2);


    @Query(value = "select l FROM Log l where l.id = ?1")
    Log findExceptionById(Long id);

}
