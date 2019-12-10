package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.ServerQueryCriteria;
import com.perye.dokit.entity.Server;
import com.perye.dokit.service.ServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 4:01 下午
 */
@Api(tags = "Server管理")
@RestController
@RequestMapping("/api/server")
public class ServerController {
    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping
    @Log("查询Server")
    @ApiOperation("查询Server")
    @PreAuthorize("@dokit.check('server:list')")
    public ResponseEntity getServers(ServerQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(serverService.queryAll(criteria,pageable), HttpStatus.OK);
    }

    @PostMapping
    @Log("新增Server")
    @ApiOperation("新增Server")
    @PreAuthorize("@dokit.check('server:add')")
    public ResponseEntity create(@Validated @RequestBody Server resources){
        return new ResponseEntity<>(serverService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改Server")
    @ApiOperation("修改Server")
    @PreAuthorize("@dokit.check('server:edit')")
    public ResponseEntity update(@Validated @RequestBody Server resources){
        serverService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    @Log("删除Server")
    @ApiOperation("删除Server")
    @PreAuthorize("@dokit.check('server:del')")
    public ResponseEntity delete(@PathVariable Integer id){
        serverService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
