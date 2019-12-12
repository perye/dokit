package com.perye.dokit.service;

import com.perye.dokit.dto.TestDto;
import com.perye.dokit.entity.Test;
import com.perye.dokit.dto.TestQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface TestService {

    /**
    * 查询数据分页
    * @param criteria 条件参数
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(TestQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<TestDTO>
    */
    List<TestDto> queryAll(TestQueryCriteria criteria);

    /**
    * 根据ID查询
    * @param id ID
    * @return TestDTO
    */
    TestDto findById(Integer id);


    TestDto create(Test resources);


    void update(Test resources);

    void delete(Integer id);

    void download(List<TestDto> all, HttpServletResponse response) throws IOException;
}
