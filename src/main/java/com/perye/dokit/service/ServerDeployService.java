package com.perye.dokit.service;

import com.perye.dokit.dto.ServerDeployDTO;
import com.perye.dokit.dto.ServerDeployQueryCriteria;
import com.perye.dokit.entity.ServerDeploy;
import org.springframework.data.domain.Pageable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public interface ServerDeployService {

    /**
     * queryAll 分页
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(ServerDeployQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll 不分页
     * @param criteria
     * @return
     */
    public Object queryAll(ServerDeployQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    ServerDeployDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    ServerDeployDTO create(ServerDeploy resources);

    /**
     * update
     * @param resources
     */
    void update(ServerDeploy resources);

    /**
     * delete
     * @param id
     */
    void delete(String id);
}
