package com.perye.dokit.repository;

import com.perye.dokit.entity.Deploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 11:25 下午
 */
public interface DeployRepository extends JpaRepository<Deploy, Long>, JpaSpecificationExecutor<Deploy> {
}
