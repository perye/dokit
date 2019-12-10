package com.perye.dokit.service.impl;

import com.perye.dokit.entity.Test;
import com.perye.dokit.utils.ValidationUtil;
import com.perye.dokit.utils.FileUtil;
import com.perye.dokit.repository.TestRepository;
import com.perye.dokit.service.TestService;
import com.perye.dokit.dto.TestDTO;
import com.perye.dokit.dto.TestQueryCriteria;
import com.perye.dokit.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
@CacheConfig(cacheNames = "test")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    private final TestMapper testMapper;

    public TestServiceImpl(TestRepository testRepository, TestMapper testMapper) {
        this.testRepository = testRepository;
        this.testMapper = testMapper;
    }

    @Override
    @Cacheable
    public Map<String,Object> queryAll(TestQueryCriteria criteria, Pageable pageable){
        Page<Test> page = testRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(testMapper::toDto));
    }

    @Override
    @Cacheable
    public List<TestDTO> queryAll(TestQueryCriteria criteria){
        return testMapper.toDto(testRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable(key = "#p0")
    public TestDTO findById(Integer id) {
        Test test = testRepository.findById(id).orElseGet(Test::new);
        ValidationUtil.isNull(test.getId(),"Test","id",id);
        return testMapper.toDto(test);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public TestDTO create(Test resources) {
        return testMapper.toDto(testRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Test resources) {
        Test test = testRepository.findById(resources.getId()).orElseGet(Test::new);
        ValidationUtil.isNull( test.getId(),"Test","id",resources.getId());
        test.copy(resources);
        testRepository.save(test);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        testRepository.deleteById(id);
    }

    @Override
    public void download(List<TestDTO> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TestDTO test : all) {
        Map<String,Object> map = new LinkedHashMap<>();
                    map.put(" 用户名", test.getUsername());
                    map.put("邮箱", test.getEmail());
        list.add(map);
        }
        FileUtil.downloadExcel(list, response);
        }

 }