package com.perye.dokit.service;

import com.perye.dokit.entity.GenConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface GenConfigService {

    GenConfig find();

    GenConfig update(GenConfig genConfig);
}
