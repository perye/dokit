package com.perye.dokit.controller;

import cn.hutool.core.lang.Dict;
import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.RoleQueryCriteria;
import com.perye.dokit.dto.RoleSmallDTO;
import com.perye.dokit.entity.Role;
import com.perye.dokit.exception.BadRequestException;
import com.perye.dokit.service.RoleService;
import com.perye.dokit.utils.SecurityUtils;
import com.perye.dokit.utils.ThrowableUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "系统：角色管理")
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    private static final String ENTITY_NAME = "role";

    @ApiOperation("获取单个role")
    @GetMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('roles:list')")
    public ResponseEntity getRoles(@PathVariable Long id){
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @ApiOperation("返回全部的角色")
    @GetMapping(value = "/all")
    @PreAuthorize("@dokit.check('roles:list','user:add','user:edit')")
    public ResponseEntity getAll(@PageableDefault(value = 2000, sort = {"level"}, direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(roleService.queryAll(pageable),HttpStatus.OK);
    }

    @Log("查询角色")
    @ApiOperation("查询角色")
    @GetMapping
    @PreAuthorize("@dokit.check('roles:list')")
    public ResponseEntity getRoles(RoleQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(roleService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @ApiOperation("获取用户级别")
    @GetMapping(value = "/level")
    public ResponseEntity getLevel(){
        List<Integer> levels = roleService.findByUsers_Id(SecurityUtils.getUserId()).stream().map(RoleSmallDTO::getLevel).collect(Collectors.toList());
        return new ResponseEntity<>(Dict.create().set("level", Collections.min(levels)),HttpStatus.OK);
    }

    @Log("新增角色")
    @ApiOperation("新增角色")
    @PostMapping
    @PreAuthorize("@dokit.check('roles:add')")
    public ResponseEntity create(@Validated @RequestBody Role resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity<>(roleService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改角色")
    @ApiOperation("修改角色")
    @PutMapping
    @PreAuthorize("@dokit.check('roles:edit')")
    public ResponseEntity update(@Validated(Role.Update.class) @RequestBody Role resources){
        roleService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("修改角色菜单")
    @ApiOperation("修改角色菜单")
    @PutMapping(value = "/menu")
    @PreAuthorize("@dokit.check('roles:edit')")
    public ResponseEntity updateMenu(@RequestBody Role resources){
        roleService.updateMenu(resources,roleService.findById(resources.getId()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除角色")
    @ApiOperation("删除角色")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('roles:del')")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            roleService.delete(id);
        }catch (Throwable e){
            ThrowableUtil.throwForeignKeyException(e, "该角色存在用户关联，请取消关联后再试");
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}

