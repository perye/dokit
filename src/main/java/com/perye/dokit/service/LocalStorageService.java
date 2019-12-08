package com.perye.dokit.service;

import com.perye.dokit.dto.LocalStorageDTO;
import com.perye.dokit.dto.LocalStorageQueryCriteria;
import com.perye.dokit.entity.LocalStorage;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface LocalStorageService {

    Object queryAll(LocalStorageQueryCriteria criteria, Pageable pageable);

    List<LocalStorageDTO> queryAll(LocalStorageQueryCriteria criteria);

    LocalStorageDTO findById(Long id);

    LocalStorageDTO create(String name, MultipartFile file);

    void update(LocalStorage resources);

    void delete(Long id);

    void deleteAll(Long[] ids);

    void download(List<LocalStorageDTO> queryAll, HttpServletResponse response) throws IOException;

}
