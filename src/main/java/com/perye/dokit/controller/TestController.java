package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.entity.Test;
import com.perye.dokit.service.TestService;
import com.perye.dokit.dto.TestQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Api(tags = "genTest管理")
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@dokit.check('test:list')")
    public void download(HttpServletResponse response, TestQueryCriteria criteria) throws IOException {
        testService.download(testService.queryAll(criteria), response);
    }

    @Log("查询genTest")
    @ApiOperation("查询genTest")
    @GetMapping()
    @PreAuthorize("@dokit.check('test:list')")
    public ResponseEntity<Object> getTests(TestQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(testService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增genTest")
    @ApiOperation("新增genTest")
    @PostMapping
    @PreAuthorize("@dokit.check('test:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Test resources){
        return new ResponseEntity<>(testService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改genTest")
    @ApiOperation("修改genTest")
    @PutMapping
    @PreAuthorize("@dokit.check('test:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Test resources){
    testService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除genTest")
    @ApiOperation("删除genTest")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('test:del')")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
    testService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Log("多选删除genTest")
    @ApiOperation("多选删除genTest")
    @PreAuthorize("@dokit.check('test:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Integer[] ids) {
    testService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
