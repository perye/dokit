package com.perye.dokit.service.impl;

import com.perye.dokit.dto.DictDTO;
import com.perye.dokit.dto.DictQueryCriteria;
import com.perye.dokit.entity.Dict;
import com.perye.dokit.mapper.DictMapper;
import com.perye.dokit.repository.DictRepository;
import com.perye.dokit.service.DictService;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.QueryHelp;
import com.perye.dokit.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "dict")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl implements DictService {

    private final DictRepository dictRepository;

    private final DictMapper dictMapper;

    public DictServiceImpl(DictRepository dictRepository, DictMapper dictMapper) {
        this.dictRepository = dictRepository;
        this.dictMapper = dictMapper;
    }

    @Override
    @Cacheable
    public Object queryAll(DictQueryCriteria dict, Pageable pageable){
        Page<Dict> page = dictRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, dict, cb), pageable);
        return PageUtil.toPage(page.map(dictMapper::toDto));
    }

    @Override
    @Cacheable(key = "#p0")
    public DictDTO findById(Long id) {
        Dict dict = dictRepository.findById(id).orElseGet(Dict::new);
        ValidationUtil.isNull(dict.getId(),"Dict","id",id);
        return dictMapper.toDto(dict);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public DictDTO create(Dict resources) {
        return dictMapper.toDto(dictRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Dict resources) {
        Dict dict = dictRepository.findById(resources.getId()).orElseGet(Dict::new);
        ValidationUtil.isNull( dict.getId(),"Dict","id",resources.getId());
        resources.setId(dict.getId());
        dictRepository.save(resources);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictRepository.deleteById(id);
    }
}
