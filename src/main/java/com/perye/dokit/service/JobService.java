package com.perye.dokit.service;

import com.perye.dokit.dto.JobDTO;
import com.perye.dokit.dto.JobQueryCriteria;
import com.perye.dokit.entity.Job;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

@CacheConfig(cacheNames = "job")
public interface JobService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    JobDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    JobDTO create(Job resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Job resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * queryAll
     * @param criteria
     * @param pageable
     * @return
     */
    Object queryAll(JobQueryCriteria criteria, Pageable pageable);
}