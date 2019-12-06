package com.perye.dokit.repository;

import com.perye.dokit.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.LinkedHashSet;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu> {

    Menu findByName(String name);

    Menu findByComponentName(String name);

    List<Menu> findByPid(long pid);

    LinkedHashSet<Menu> findByRoles_IdOrderBySortAsc(Long id);
}

