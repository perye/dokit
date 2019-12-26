package com.perye.dokit.service;

import com.perye.dokit.dto.DictDetailDto;
import com.perye.dokit.query.DictDetailQueryCriteria;
import com.perye.dokit.entity.DictDetail;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface DictDetailService {

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    DictDetailDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    DictDetailDto create(DictDetail resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(DictDetail resources);

    /**
     * 删除
     * @param id /
     */
    void delete(Long id);

    /**
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map queryAll(DictDetailQueryCriteria criteria, Pageable pageable);
}
