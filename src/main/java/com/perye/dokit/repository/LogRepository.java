package com.perye.dokit.repository;

import com.perye.dokit.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 日志
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Long>, JpaSpecificationExecutor<Log> {

    /**
     * 根据日志类型删除信息
     * @param logType
     */
    @Query(value = "delete from sys_log where log_type = ?1", nativeQuery = true)
    @Modifying
    void deleteByLogType(String logType);

}
