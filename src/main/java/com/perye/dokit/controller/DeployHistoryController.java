package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.query.DeployHistoryQueryCriteria;
import com.perye.dokit.service.DeployHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Api(tags = "部署历史管理")
@RestController
@RequestMapping("/api/deployHistory")
public class DeployHistoryController {

    private final DeployHistoryService deployhistoryService;

    public DeployHistoryController(DeployHistoryService deployHistoryService) {
        this.deployhistoryService = deployHistoryService;
    }

    @Log("导出部署历史数据")
    @ApiOperation("导出部署历史数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@dokit.check('deployHistory:list')")
    public void download(HttpServletResponse response, DeployHistoryQueryCriteria criteria) throws IOException {
        deployhistoryService.download(deployhistoryService.queryAll(criteria), response);
    }

    @Log("查询部署历史管理")
    @ApiOperation(value = "查询部署历史管理")
    @GetMapping
    @PreAuthorize("@dokit.check('deployHistory:list')")
    public ResponseEntity<Object> getDeployHistorys(DeployHistoryQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(deployhistoryService.queryAll(criteria,pageable),HttpStatus.OK);
    }


    @Log("删除部署历史管理")
    @ApiOperation(value = "删除部署历史管理")
    @DeleteMapping
    @PreAuthorize("@dokit.check('deployHistory:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<String> ids){
        deployhistoryService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
