package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.query.AppQueryCriteria;
import com.perye.dokit.entity.App;
import com.perye.dokit.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@Api(tags = "应用管理")
@RestController
@RequestMapping("/api/app")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService){
        this.appService = appService;
    }

    @Log("导出应用数据")
    @ApiOperation("导出应用数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@dokit.check('app:list')")
    public void download(HttpServletResponse response, AppQueryCriteria criteria) throws IOException {
        appService.download(appService.queryAll(criteria), response);
    }

    @Log("查询应用")
    @ApiOperation(value = "查询应用")
    @GetMapping
    @PreAuthorize("@dokit.check('app:list')")
    public ResponseEntity<Object> getApps(AppQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(appService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增应用")
    @ApiOperation(value = "新增应用")
    @PostMapping
    @PreAuthorize("@dokit.check('app:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody App resources){
        return new ResponseEntity<>(appService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改应用")
    @ApiOperation(value = "修改应用")
    @PutMapping
    @PreAuthorize("@dokit.check('app:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody App resources){
        appService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除应用")
    @ApiOperation(value = "删除应用")
    @DeleteMapping
    @PreAuthorize("@dokit.check('app:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        appService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
