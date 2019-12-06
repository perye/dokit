package com.perye.dokit.repository;

import com.perye.dokit.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {

    Permission findByName(String name);

    List<Permission> findByPid(long pid);
}
