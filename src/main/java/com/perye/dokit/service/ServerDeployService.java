package com.perye.dokit.service;

import com.perye.dokit.dto.ServerDeployDto;
import com.perye.dokit.query.ServerDeployQueryCriteria;
import com.perye.dokit.entity.ServerDeploy;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

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
    List<ServerDeployDto> queryAll(ServerDeployQueryCriteria criteria);

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
     * @param ids /
     */
    void delete(Set<Long> ids);

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

    /**
     * 导出数据
     * @param queryAll /
     * @param response /
     */
    void download(List<ServerDeployDto> queryAll, HttpServletResponse response) throws IOException;

}
