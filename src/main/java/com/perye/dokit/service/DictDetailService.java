package com.perye.dokit.service;

import com.perye.dokit.dto.DictDetailDTO;
import com.perye.dokit.dto.DictDetailQueryCriteria;
import com.perye.dokit.entity.DictDetail;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface DictDetailService {

    DictDetailDTO findById(Long id);

    DictDetailDTO create(DictDetail resources);

    void update(DictDetail resources);

    void delete(Long id);

    Map queryAll(DictDetailQueryCriteria criteria, Pageable pageable);
}
