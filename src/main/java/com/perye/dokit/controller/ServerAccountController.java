package com.perye.dokit.controller;


import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.ServerAccountQueryCriteria;
import com.perye.dokit.entity.ServerAccount;
import com.perye.dokit.service.ServerAccountService;
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
 * @date 2019/12/10
 */
@Api(tags = "服务器账号管理")
@RestController
@RequestMapping("/api/serverAccount")
public class ServerAccountController {

    @Autowired
    private com.perye.dokit.service.ServerAccountService  ServerAccountService;

    @Log("查询ServerAccount")
    @ApiOperation(value = "查询ServerAccount")
    @GetMapping
    @PreAuthorize("@dokit.check('serverAccount:list')")
    public ResponseEntity getServerAccounts(ServerAccountQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(ServerAccountService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ServerAccount")
    @ApiOperation(value = "新增ServerAccount")
    @PostMapping
    @PreAuthorize("@dokit.check('serverAccount:add')")
    public ResponseEntity create(@Validated @RequestBody ServerAccount resources){
        return new ResponseEntity(ServerAccountService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ServerAccount")
    @ApiOperation(value = "修改ServerAccount")
    @PutMapping
    @PreAuthorize("@dokit.check('serverAccount:edit')")
    public ResponseEntity update(@Validated @RequestBody ServerAccount resources){
        ServerAccountService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ServerAccount")
    @ApiOperation(value = "删除ServerAccount")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('serverAccount:del')")
    public ResponseEntity delete(@PathVariable String id){
        ServerAccountService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
