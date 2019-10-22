package com.perye.dokit.service.impl;

import com.perye.dokit.entity.Knowledge;
import com.perye.dokit.repository.KnowledgeRepository;
import com.perye.dokit.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeRepository knowledgeRepository;

    @Override
    public void saveKnowledge(String text) {
        //先判断数据库有没有该记录
        Knowledge knowledge = knowledgeRepository.findByText(text);
        if (knowledge == null) {
            knowledgeRepository.save(new Knowledge(text, 1, new Date()));
        } else {
            knowledge.setCount(knowledge.getCount() + 1);
            knowledge.setUpdateTime(new Date());
            knowledgeRepository.save(knowledge);
        }
    }

    @Override
    public List<String> findListByUpdateTime() {
        return knowledgeRepository.findListByUpdateTime();
    }

    @Override
    public List<String> findListByCount() {
        return knowledgeRepository.findListByCount();
    }
}
