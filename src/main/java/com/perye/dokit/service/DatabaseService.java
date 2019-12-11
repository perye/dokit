package com.perye.dokit.service;

import com.perye.dokit.dto.DatabaseDTO;
import com.perye.dokit.dto.DatabaseQueryCriteria;
import com.perye.dokit.entity.Database;
import org.springframework.data.domain.Pageable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public interface DatabaseService {

    /**
     * queryAll 分页
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(DatabaseQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll 不分页
     * @param criteria
     * @return
     */
    public Object queryAll(DatabaseQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    DatabaseDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    DatabaseDTO create(Database resources);

    /**
     * update
     * @param resources
     */
    void update(Database resources);

    /**
     * delete
     * @param id
     */
    void delete(String id);
}
