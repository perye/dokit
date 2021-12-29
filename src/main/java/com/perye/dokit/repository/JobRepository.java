package com.perye.dokit.repository;

import com.perye.dokit.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

    /**
     * 根据名称查询
     * @param name 名称
     * @return /
     */
    Job findByName(String name);


    /**
     * 根据Id删除
     * @param ids /
     */
    void deleteAllByIdIn(Set<Long> ids);

}
