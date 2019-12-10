package com.perye.dokit.repository;

import com.perye.dokit.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 服务器信息
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 4:00 下午
 */
public interface ServerRepository extends JpaRepository<Server, Integer>, JpaSpecificationExecutor<Server> {
}
