package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.ServerDeployQueryCriteria;
import com.perye.dokit.entity.ServerDeploy;
import com.perye.dokit.service.ServerDeployService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 11:33 下午
 */
@Api(tags = "服务器部署管理")
@RestController
@RequestMapping("/api/serverDeploy")
public class ServerDeployController {

    @Autowired
    private ServerDeployService serverDeployService;

    @Log("查询Server")
    @ApiOperation(value = "查询Server")
    @GetMapping
    @PreAuthorize("@dokit.check('serverDeploy:list')")
    public ResponseEntity getServers(ServerDeployQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(serverDeployService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Server")
    @ApiOperation(value = "新增Server")
    @PostMapping
    @PreAuthorize("@dokit.check('serverDeploy:add')")
    public ResponseEntity create(@Validated @RequestBody ServerDeploy resources){
        return new ResponseEntity(serverDeployService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Server")
    @ApiOperation(value = "修改Server")
    @PutMapping
    @PreAuthorize("@dokit.check('serverDeploy:edit')")
    public ResponseEntity update(@Validated @RequestBody ServerDeploy resources){
        serverDeployService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Server")
    @ApiOperation(value = "删除Server")
    @DeleteMapping(value = "/{id:.+}")
    @PreAuthorize("@dokit.check('serverDeploy:del')")
    public ResponseEntity delete(@PathVariable String id){
        serverDeployService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
