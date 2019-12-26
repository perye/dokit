package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.query.LocalStorageQueryCriteria;
import com.perye.dokit.entity.LocalStorage;
import com.perye.dokit.service.LocalStorageService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "工具：本地存储管理")
@RestController
@RequestMapping("/api/localStorage")
public class LocalStorageController {

    private final LocalStorageService localStorageService;

    public LocalStorageController(LocalStorageService localStorageService) {
        this.localStorageService = localStorageService;
    }
    @ApiOperation("查询文件")
    @GetMapping()
    @PreAuthorize("@dokit.check('storage:list')")
    public ResponseEntity<Object> getLocalStorages(LocalStorageQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(localStorageService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@dokit.check('storage:list')")
    public void download(HttpServletResponse response, LocalStorageQueryCriteria criteria) throws IOException {
        localStorageService.download(localStorageService.queryAll(criteria), response);
    }

    @ApiOperation("上传文件")
    @PostMapping()
    @PreAuthorize("@dokit.check('storage:add')")
    public ResponseEntity<Object> create(@RequestParam String name, @RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(localStorageService.create(name, file),HttpStatus.CREATED);
    }

    @ApiOperation("修改文件")
    @PutMapping()
    @PreAuthorize("@dokit.check('storage:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody LocalStorage resources){
        localStorageService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("多选删除")
    @DeleteMapping
    @ApiOperation("多选删除")
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        localStorageService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
