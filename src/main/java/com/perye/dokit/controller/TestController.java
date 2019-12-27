package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.entity.Test;
import com.perye.dokit.service.TestService;
import com.perye.dokit.query.TestQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Api(tags = "test管理")
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

    @Log("查询test")
    @ApiOperation("查询test")
    @GetMapping()
    @PreAuthorize("@dokit.check('test:list')")
    public ResponseEntity<Object> getTests(TestQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(testService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增test")
    @ApiOperation("新增test")
    @PostMapping
    @PreAuthorize("@dokit.check('test:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Test resources){
        return new ResponseEntity<>(testService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改test")
    @ApiOperation("修改test")
    @PutMapping
    @PreAuthorize("@dokit.check('test:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Test resources){
    testService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除test")
    @ApiOperation("删除test")
    @PreAuthorize("@dokit.check('test:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Integer[] ids) {
    testService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
