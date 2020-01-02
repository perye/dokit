package com.perye.dokit.controller;

import com.perye.dokit.annotation.AnonymousAccess;
import com.perye.dokit.aop.log.Log;
import com.perye.dokit.entity.server.Server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务器监控
 *
 * @author perye
 * @email peryedev@gmail.com
 * @date 2020/1/2
 */
@RestController
@RequestMapping("/api/monitor/server")
@Api(tags = "监控:服务器监控")
public class ServerController{

    @GetMapping
    @PreAuthorize("@dokit.check('server:list')")
    @ApiOperation("查询服务器监控")
    @Log("查询服务器监控")
    public ResponseEntity<Object> get() throws Exception {
        Server server = new Server();
        server.copyTo();
        return new ResponseEntity<>(server,HttpStatus.OK);
    }

}
