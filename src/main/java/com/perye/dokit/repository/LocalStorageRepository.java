package com.perye.dokit.repository;

import com.perye.dokit.entity.LocalStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocalStorageRepository extends JpaRepository<LocalStorage, Long>, JpaSpecificationExecutor<LocalStorage> {
}
