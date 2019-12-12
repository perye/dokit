package com.perye.dokit.repository;

import com.perye.dokit.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 11:23 下午
 */
public interface AppRepository extends JpaRepository<App, Long>, JpaSpecificationExecutor<App> {
}
