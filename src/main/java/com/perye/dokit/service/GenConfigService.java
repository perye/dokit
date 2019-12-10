package com.perye.dokit.service;

import com.perye.dokit.entity.GenConfig;

public interface GenConfigService {

    GenConfig find(String tableName);

    GenConfig update(String tableName, GenConfig genConfig);
}
