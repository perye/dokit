package com.perye.dokit.service;

import com.perye.dokit.dto.DictDetailDto;
import com.perye.dokit.query.DictDetailQueryCriteria;
import com.perye.dokit.entity.DictDetail;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface DictDetailService {

    /**
     * 创建
     * @param resources /
     */
    void create(DictDetail resources);

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
    Map<String,Object> queryAll(DictDetailQueryCriteria criteria, Pageable pageable);

    /**
     * 根据字典名称获取字典详情
     * @param name 字典名称
     * @return /
     */
    List<DictDetailDto> getDictByName(String name);
}
