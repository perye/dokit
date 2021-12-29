package com.perye.dokit.controller;

import cn.hutool.core.lang.Dict;
import com.perye.dokit.annotation.Log;
import com.perye.dokit.dto.RoleDto;
import com.perye.dokit.query.RoleQueryCriteria;
import com.perye.dokit.dto.RoleSmallDto;
import com.perye.dokit.entity.Role;
import com.perye.dokit.exception.BadRequestException;
import com.perye.dokit.service.RoleService;
import com.perye.dokit.utils.SecurityUtils;
import com.perye.dokit.utils.ThrowableUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Api(tags = "系统：角色管理")
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    private static final String ENTITY_NAME = "role";

    @Log("导出角色数据")
    @ApiOperation("导出角色数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@dokit.check('role:list')")
    public void download(HttpServletResponse response, RoleQueryCriteria criteria) throws IOException {
        roleService.download(roleService.queryAll(criteria), response);
    }


    @ApiOperation("获取单个role")
    @GetMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('roles:list')")
    public ResponseEntity<Object> query(@PathVariable Long id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @ApiOperation("返回全部的角色")
    @GetMapping(value = "/all")
    @PreAuthorize("@dokit.check('roles:list','user:add','user:edit')")
    public ResponseEntity<Object> query(){
        return new ResponseEntity<>(roleService.queryAll(),HttpStatus.OK);
    }

    @Log("查询角色")
    @ApiOperation("查询角色")
    @GetMapping
    @PreAuthorize("@dokit.check('roles:list')")
    public ResponseEntity<Object> query(RoleQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(roleService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @ApiOperation("获取用户级别")
    @GetMapping(value = "/level")
    public ResponseEntity<Object> getLevel() {
        return new ResponseEntity<>(Dict.create().set("level", getLevels(null)), HttpStatus.OK);
    }

    @Log("新增角色")
    @ApiOperation("新增角色")
    @PostMapping
    @PreAuthorize("@dokit.check('roles:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Role resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        getLevels(resources.getLevel());
        roleService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改角色")
    @ApiOperation("修改角色")
    @PutMapping
    @PreAuthorize("@dokit.check('roles:edit')")
    public ResponseEntity<Object> update(@Validated(Role.Update.class) @RequestBody Role resources) {
        getLevels(resources.getLevel());
        roleService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("修改角色菜单")
    @ApiOperation("修改角色菜单")
    @PutMapping(value = "/menu")
    @PreAuthorize("@dokit.check('roles:edit')")
    public ResponseEntity<Object> updateMenu(@RequestBody Role resources) {
        RoleDto role = roleService.findById(resources.getId());
        getLevels(role.getLevel());
        roleService.updateMenu(resources, role);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除角色")
    @ApiOperation("删除角色")
    @DeleteMapping
    @PreAuthorize("@dokit.check('roles:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids) {
        for (Long id : ids) {
            RoleDto role = roleService.findById(id);
            getLevels(role.getLevel());
        }
        // 验证是否被用户关联
        roleService.verification(ids);
        roleService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 获取用户的角色级别
     *
     * @return /
     */
    private int getLevels(Integer level) {
        List<Integer> levels = roleService.findByUsersId(SecurityUtils.getCurrentUserId()).stream().map(RoleSmallDto::getLevel).collect(Collectors.toList());
        int min = Collections.min(levels);
        if (level != null) {
            if (level < min) {
                throw new BadRequestException("权限不足，你的角色级别：" + min + "，低于操作的角色级别：" + level);
            }
        }
        return min;
    }
}

