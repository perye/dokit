package com.perye.dokit.service;

import com.perye.dokit.dto.PictureQueryCriteria;
import com.perye.dokit.entity.Picture;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    Object queryAll(PictureQueryCriteria criteria, Pageable pageable);

    Picture upload(MultipartFile file, String username);

    Picture findById(Long id);

    void delete(Picture picture);

    void deleteAll(Long[] ids);
}

