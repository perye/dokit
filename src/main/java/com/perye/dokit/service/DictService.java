package com.perye.dokit.service;

import com.perye.dokit.dto.DictDTO;
import com.perye.dokit.dto.DictQueryCriteria;
import com.perye.dokit.entity.Dict;
import org.springframework.data.domain.Pageable;

public interface DictService {

    Object queryAll(DictQueryCriteria dict, Pageable pageable);

    DictDTO findById(Long id);

    DictDTO create(Dict resources);

    void update(Dict resources);

    void delete(Long id);
}
