package com.perye.dokit.service;

import com.perye.dokit.dto.JobDTO;
import com.perye.dokit.query.JobQueryCriteria;
import com.perye.dokit.entity.Job;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface JobService {

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    JobDTO findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    JobDTO create(Job resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Job resources);

    /**
     * 删除
     * @param ids /
     */
    void delete(Set<Long> ids);

    /**
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map<String,Object> queryAll(JobQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部数据
     * @param criteria /
     * @return /
     */
    List<JobDTO> queryAll(JobQueryCriteria criteria);

    /**
     * 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<JobDTO> queryAll, HttpServletResponse response) throws IOException;
}
