package com.perye.dokit.service;

import com.perye.dokit.dto.PictureQueryCriteria;
import com.perye.dokit.entity.Picture;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

@CacheConfig(cacheNames = "picture")
public interface PictureService {

    /**
     * 查询图片
     * @param criteria 条件参数
     * @param pageable 分页参数
     * @return Object
     */
    @Cacheable
    Object queryAll(PictureQueryCriteria criteria, Pageable pageable);

    /**
     * 上传图片
     * @param file 文件
     * @param username 用户名
     * @return
     */
    @CacheEvict(allEntries = true)
    Picture upload(MultipartFile file, String username);

    /**
     * 根据ID查询
     * @param id 文件ID
     * @return
     */
    @Cacheable(key = "#p0")
    Picture findById(Long id);

    /**
     * 删除图片
     * @param picture 图片实体
     */
    @CacheEvict(allEntries = true)
    void delete(Picture picture);

    /**
     * 删除图片
     * @param ids 文件ID数组
     */
    @CacheEvict(allEntries = true)
    void deleteAll(Long[] ids);
}

