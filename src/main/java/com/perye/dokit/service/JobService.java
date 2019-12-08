package com.perye.dokit.service;

import com.perye.dokit.dto.JobDTO;
import com.perye.dokit.dto.JobQueryCriteria;
import com.perye.dokit.entity.Job;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface JobService {

    JobDTO findById(Long id);

    JobDTO create(Job resources);

    void update(Job resources);

    void delete(Long id);

    Map<String,Object> queryAll(JobQueryCriteria criteria, Pageable pageable);

    List<JobDTO> queryAll(JobQueryCriteria criteria);

    void download(List<JobDTO> queryAll, HttpServletResponse response) throws IOException;
}
