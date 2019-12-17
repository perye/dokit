package com.perye.dokit.repository;

import com.perye.dokit.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface TestRepository extends JpaRepository<Test, Integer>, JpaSpecificationExecutor<Test> {
}
