package com.perye.dokit.service;

import com.perye.dokit.dto.DeptDTO;
import com.perye.dokit.dto.DeptQueryCriteria;
import com.perye.dokit.entity.Dept;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Set;

@CacheConfig(cacheNames = "dept")
public interface DeptService {

    /**
     * queryAll
     * @param criteria
     * @return
     */
    @Cacheable
    List<DeptDTO> queryAll(DeptQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    DeptDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    DeptDTO create(Dept resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Dept resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * buildTree
     * @param deptDTOS
     * @return
     */
    @Cacheable
    Object buildTree(List<DeptDTO> deptDTOS);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable
    List<Dept> findByPid(long pid);

    Set<Dept> findByRoleIds(Long id);
}
