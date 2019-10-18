package com.perye.dokit.service;

import com.perye.dokit.dto.DictDTO;
import com.perye.dokit.dto.DictQueryCriteria;
import com.perye.dokit.entity.Dict;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

@CacheConfig(cacheNames = "dict")
public interface DictService {

    /**
     * 查询
     * @param dict
     * @param pageable
     * @return
     */
    @Cacheable
    Object queryAll(DictQueryCriteria dict, Pageable pageable);

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    DictDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    DictDTO create(Dict resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Dict resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
