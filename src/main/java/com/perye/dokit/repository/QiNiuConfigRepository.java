package com.perye.dokit.repository;

import com.perye.dokit.entity.QiniuConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QiNiuConfigRepository extends JpaRepository<QiniuConfig,Long> {

    @Modifying
    @Query(value = "update QiniuConfig set type = ?1")
    void update(String type);
}
