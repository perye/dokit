package com.perye.dokit.service;

import com.perye.dokit.dto.ServerAccountDTO;
import com.perye.dokit.dto.ServerAccountQueryCriteria;
import com.perye.dokit.entity.ServerAccount;
import org.springframework.data.domain.Pageable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public interface ServerAccountService {

    /**
     * queryAll 分页
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(ServerAccountQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll 不分页
     * @param criteria
     * @return
     */
    public Object queryAll(ServerAccountQueryCriteria criteria);

    /**
     *  findById
     * @param id
     * @return
     */
    ServerAccountDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    ServerAccountDTO create(ServerAccount resources);

    /**
     * update
     * @param resources
     */
    void update(ServerAccount resources);

    /**
     * delete
     * @param id
     */
    void delete(String id);
}
