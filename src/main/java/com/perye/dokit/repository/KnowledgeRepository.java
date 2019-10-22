package com.perye.dokit.repository;

import com.perye.dokit.entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Long>, JpaSpecificationExecutor {

    /**
     * 查询记录
     * @param text
     * @return
     */
    Knowledge findByText(String text);

    /**
     * 最近查询
     * @return
     */
    @Query(value = "select text from knowledge order by update_time desc limit 10", nativeQuery = true)
    List<String> findListByUpdateTime();

    /**
     * 热门查询
     * @return
     */
    @Query(value = "select text from knowledge order by `count` desc limit 10", nativeQuery = true)
    List<String> findListByCount();

}
