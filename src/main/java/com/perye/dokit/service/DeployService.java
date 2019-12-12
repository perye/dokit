package com.perye.dokit.service;

import com.perye.dokit.dto.DeployDto;
import com.perye.dokit.dto.DeployQueryCriteria;
import com.perye.dokit.entity.Deploy;
import com.perye.dokit.entity.DeployHistory;
import org.springframework.data.domain.Pageable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public interface DeployService {

    /**
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Object queryAll(DeployQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部数据
     * @param criteria 条件
     * @return /
     */
    Object queryAll(DeployQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    DeployDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    DeployDto create(Deploy resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Deploy resources);

    /**
     * 删除
     * @param id /
     */
    void delete(Long id);

    void deploy(String fileSavePath, Long appId);

    String serverStatus(Deploy resources);

    String startServer(Deploy resources);

    String stopServer(Deploy resources);

    String serverReduction(DeployHistory resources);
}
