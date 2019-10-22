package com.perye.dokit.service;

import com.perye.dokit.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {

    /**
     * 保存查询
     * @param text
     */
    void saveKnowledge(String text);

    /**
     * 最新查询
     * @return
     */
    List<String> findListByUpdateTime();

    /**
     * 热门查询
     * @return
     */
    List<String> findListByCount();

}
