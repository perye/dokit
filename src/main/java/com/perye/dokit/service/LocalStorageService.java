package com.perye.dokit.service;

import com.perye.dokit.dto.LocalStorageDTO;
import com.perye.dokit.dto.LocalStorageQueryCriteria;
import com.perye.dokit.entity.LocalStorage;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface LocalStorageService {

    /**
     * queryAll 分页
     * @param criteria 条件参数
     * @param pageable 分页参数
     * @return Object
     */
    Object queryAll(LocalStorageQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll 不分页
     * @param criteria 条件参数
     * @return Object
     */
    Object queryAll(LocalStorageQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return LocalStorageDTO
     */
    LocalStorageDTO findById(Long id);

    /**
     * create
     * @param name 文件名称
     * @param file 文件资源
     * @return LocalStorageDTO
     */
    LocalStorageDTO create(String name, MultipartFile file);

    /**
     * update
     * @param resources 资源实体
     */
    void update(LocalStorage resources);

    /**
     * delete
     * @param id 文件ID
     */
    void delete(Long id);

    /**
     * 多文件删除
     * @param ids 文件数组
     */
    void deleteAll(Long[] ids);
}
