package com.perye.dokit.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.perye.dokit.dto.LocalStorageDTO;
import com.perye.dokit.dto.LocalStorageQueryCriteria;
import com.perye.dokit.entity.LocalStorage;
import com.perye.dokit.exception.BadRequestException;
import com.perye.dokit.mapper.LocalStorageMapper;
import com.perye.dokit.repository.LocalStorageRepository;
import com.perye.dokit.service.LocalStorageService;
import com.perye.dokit.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

@Service
@CacheConfig(cacheNames = "localStorage")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LocalStorageServiceImpl implements LocalStorageService {

    private final LocalStorageRepository localStorageRepository;

    private final LocalStorageMapper localStorageMapper;

    @Value("${file.path}")
    private String path;

    @Value("${file.maxSize}")
    private long maxSize;

    public LocalStorageServiceImpl(LocalStorageRepository localStorageRepository, LocalStorageMapper localStorageMapper) {
        this.localStorageRepository = localStorageRepository;
        this.localStorageMapper = localStorageMapper;
    }

    @Override
    @Cacheable
    public Object queryAll(LocalStorageQueryCriteria criteria, Pageable pageable){
        Page<LocalStorage> page = localStorageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(localStorageMapper::toDto));
    }

    @Override
    @Cacheable
    public Object queryAll(LocalStorageQueryCriteria criteria){
        return localStorageMapper.toDto(localStorageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable(key = "#p0")
    public LocalStorageDTO findById(Long id){
        LocalStorage localStorage = localStorageRepository.findById(id).orElseGet(LocalStorage::new);
        ValidationUtil.isNull(localStorage.getId(),"LocalStorage","id",id);
        return localStorageMapper.toDto(localStorage);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public LocalStorageDTO create(String name, MultipartFile multipartFile) {
        FileUtil.checkSize(maxSize, multipartFile.getSize());
        String suffix = FileUtil.getExtensionName(multipartFile.getOriginalFilename());
        // 可自行选择方式
//        String type = FileUtil.getFileTypeByMimeType(suffix);
        String type = FileUtil.getFileType(suffix);
        File file = FileUtil.upload(multipartFile, path + type +  File.separator);
        if(ObjectUtil.isNull(file)){
            throw new BadRequestException("上传失败");
        }
        try {
            name = StringUtils.isBlank(name) ? FileUtil.getFileNameNoEx(multipartFile.getOriginalFilename()) : name;
            LocalStorage localStorage = new LocalStorage(
                    file.getName(),
                    name,
                    suffix,
                    file.getPath(),
                    type,
                    FileUtil.getSize(multipartFile.getSize()),
                    SecurityUtils.getUsername()
            );
            return localStorageMapper.toDto(localStorageRepository.save(localStorage));
        }catch (Exception e){
            FileUtil.del(file);
            throw e;
        }
    }


    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(LocalStorage resources) {
        LocalStorage localStorage = localStorageRepository.findById(resources.getId()).orElseGet(LocalStorage::new);
        ValidationUtil.isNull( localStorage.getId(),"LocalStorage","id",resources.getId());
        localStorage.copy(resources);
        localStorageRepository.save(localStorage);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        LocalStorage storage = localStorageRepository.findById(id).orElseGet(LocalStorage::new);
        FileUtil.del(storage.getPath());
        localStorageRepository.delete(storage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            LocalStorage storage = localStorageRepository.findById(id).get();
            FileUtil.del(storage.getPath());
            localStorageRepository.delete(storage);
        }
    }
}

