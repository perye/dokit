package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.PermissionDTO;
import com.perye.dokit.dto.PermissionQueryCriteria;
import com.perye.dokit.entity.Permission;
import com.perye.dokit.exception.BadRequestException;
import com.perye.dokit.mapper.PermissionMapper;
import com.perye.dokit.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Api(tags = "系统：权限管理")
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    private final PermissionMapper permissionMapper;

    private static final String ENTITY_NAME = "permission";

    public PermissionController(PermissionService permissionService, PermissionMapper permissionMapper) {
        this.permissionService = permissionService;
        this.permissionMapper = permissionMapper;
    }

    @ApiOperation("返回全部的权限，新增角色时下拉选择")
    @GetMapping(value = "/tree")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE','PERMISSION_EDIT','ROLES_SELECT','ROLES_ALL')")
    public ResponseEntity getTree(){
        return new ResponseEntity<>(permissionService.getPermissionTree(permissionService.findByPid(0L)),HttpStatus.OK);
    }

    @Log("查询权限")
    @ApiOperation("查询权限")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT')")
    public ResponseEntity getPermissions(PermissionQueryCriteria criteria){
        List<PermissionDTO> permissionDTOS = permissionService.queryAll(criteria);
        return new ResponseEntity<>(permissionService.buildTree(permissionDTOS),HttpStatus.OK);
    }

    @Log("新增权限")
    @ApiOperation("新增权限")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Permission resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity<>(permissionService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改权限")
    @ApiOperation("修改权限")
    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_EDIT')")
    public ResponseEntity update(@Validated(Permission.Update.class) @RequestBody Permission resources){
        permissionService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除权限")
    @ApiOperation("删除权限")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        List<Permission> permissions = permissionService.findByPid(id);
        Set<Permission> permissionSet = new HashSet<>();
        permissionSet.add(permissionMapper.toEntity(permissionService.findById(id)));
        permissionSet = permissionService.getDeletePermission(permissions, permissionSet);
        permissionService.delete(permissionSet);
        return new ResponseEntity(HttpStatus.OK);
    }
}

