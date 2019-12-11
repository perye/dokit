package com.perye.dokit.service;

import com.perye.dokit.dto.AppDTO;
import com.perye.dokit.dto.AppQueryCriteria;
import com.perye.dokit.entity.App;
import org.springframework.data.domain.Pageable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public interface AppService {

    /**
     * queryAll 分页
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(AppQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll 不分页
     * @param criteria
     * @return
     */
    public Object queryAll(AppQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    AppDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    AppDTO create(App resources);

    /**
     * update
     * @param resources
     */
    void update(App resources);

    /**
     * delete
     * @param id
     */
    void delete(String id);
}
