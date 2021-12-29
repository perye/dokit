package com.perye.dokit.controller;

import com.perye.dokit.service.MonitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "系统-服务监控管理")
@RequestMapping("/api/monitor")
public class MonitorController {

    private final MonitorService serverService;

    @GetMapping
    @ApiOperation("查询服务监控")
    @PreAuthorize("@dokit.check('monitor:list')")
    public ResponseEntity<Object> query(){
        return new ResponseEntity<>(serverService.getServers(), HttpStatus.OK);
    }
}
