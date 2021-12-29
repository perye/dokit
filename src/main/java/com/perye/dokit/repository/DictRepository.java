package com.perye.dokit.repository;

import com.perye.dokit.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor<Dict> {

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteByIdIn(Set<Long> ids);

    /**
     * 查询
     *
     * @param ids /
     * @return /
     */
    List<Dict> findByIdIn(Set<Long> ids);

}
