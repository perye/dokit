package com.perye.dokit.service;

import com.perye.dokit.dto.DeployHistoryDTO;
import com.perye.dokit.dto.DeployHistoryQueryCriteria;
import com.perye.dokit.entity.DeployHistory;
import org.springframework.data.domain.Pageable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public interface DeployHistoryService {

    /**
     * queryAll 分页
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(DeployHistoryQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll 不分页
     * @param criteria
     * @return
     */
    public Object queryAll(DeployHistoryQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    DeployHistoryDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    DeployHistoryDTO create(DeployHistory resources);

    /**
     * delete
     * @param id
     */
    void delete(String id);
}
