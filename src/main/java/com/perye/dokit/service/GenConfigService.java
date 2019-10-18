package com.perye.dokit.service;

import com.perye.dokit.entity.GenConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "genConfig")
public interface GenConfigService {

    /**
     * find
     * @return
     */
    @Cacheable(key = "'1'")
    GenConfig find();

    /**
     * update
     * @param genConfig
     * @return
     */
    @CacheEvict(allEntries = true)
    GenConfig update(GenConfig genConfig);
}
