package com.perye.dokit.repository;

import com.perye.dokit.entity.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlipayRepository extends JpaRepository<AlipayConfig,Long> {
}

