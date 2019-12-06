package com.perye.dokit.service;

import com.perye.dokit.dto.JobDTO;
import com.perye.dokit.dto.JobQueryCriteria;
import com.perye.dokit.entity.Job;
import org.springframework.data.domain.Pageable;

public interface JobService {

    JobDTO findById(Long id);

    JobDTO create(Job resources);

    void update(Job resources);

    void delete(Long id);

    Object queryAll(JobQueryCriteria criteria, Pageable pageable);
}
