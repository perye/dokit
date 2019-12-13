package com.perye.dokit.service;

import com.perye.dokit.dto.ServerDeployDto;
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
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Object queryAll(ServerDeployQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部数据
     * @param criteria 条件
     * @return /
     */
    Object queryAll(ServerDeployQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    ServerDeployDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    ServerDeployDto create(ServerDeploy resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(ServerDeploy resources);

    /**
     * 删除
     * @param id /
     */
    void delete(Long id);

    /**
     * 根据IP查询
     * @param ip /
     * @return /
     */
    ServerDeployDto findByIp(String ip);

    /**
     * 测试登录服务器
     * @param resources
     * @return
     */
    Boolean testConnect(ServerDeploy resources);

}
