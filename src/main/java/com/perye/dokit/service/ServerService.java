package com.perye.dokit.service;

import com.perye.dokit.dto.ServerDto;
import com.perye.dokit.dto.ServerQueryCriteria;
import com.perye.dokit.entity.Server;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 4:07 下午
 */
public interface ServerService {

    /**
     * 查询数据分页
     * @param criteria 条件参数
     * @param pageable 分页参数
     * @return Map<String,Object>
     */
    Map<String,Object> queryAll(ServerQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     * @param criteria 条件参数
     * @return List<ServerDTO>
     */
    List<ServerDto> queryAll(ServerQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ServerDTO
     */
    ServerDto findById(Integer id);

    /**
     * 创建服务监控
     * @param resources /
     * @return /
     */
    ServerDto create(Server resources);

    /**
     * 编辑服务监控
     * @param resources /
     */
    void update(Server resources);

    /**
     * 删除
     * @param id /
     */
    void delete(Set<Integer> id);

}
