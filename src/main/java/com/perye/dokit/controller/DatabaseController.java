package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.DatabaseQueryCriteria;
import com.perye.dokit.entity.Database;
import com.perye.dokit.service.DatabaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "数据库管理")
@RestController
@RequestMapping("/api/database")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @Log("查询Database")
    @ApiOperation(value = "查询Database")
    @GetMapping
    @PreAuthorize("@dokit.check('database:list')")
    public ResponseEntity getDatabases(DatabaseQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(databaseService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Database")
    @ApiOperation(value = "新增Database")
    @PostMapping
    @PreAuthorize("@dokit.check('database:add')")
    public ResponseEntity create(@Validated @RequestBody Database resources){
        return new ResponseEntity(databaseService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Database")
    @ApiOperation(value = "修改Database")
    @PutMapping
    @PreAuthorize("@dokit.check('database:edit')")
    public ResponseEntity update(@Validated @RequestBody Database resources){
        databaseService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Database")
    @ApiOperation(value = "删除Database")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('database:del')")
    public ResponseEntity delete(@PathVariable String id){
        databaseService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
