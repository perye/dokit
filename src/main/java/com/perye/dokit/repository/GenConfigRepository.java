package com.perye.dokit.repository;

import com.perye.dokit.entity.GenConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenConfigRepository extends JpaRepository<GenConfig, Long> {

    /**
     * 查询表配置
     * @param tableName 表名
     * @return /
     */
    GenConfig findByTableName(String tableName);
}
