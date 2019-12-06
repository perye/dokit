package com.perye.dokit.service;

import com.perye.dokit.dto.PermissionDTO;
import com.perye.dokit.dto.PermissionQueryCriteria;
import com.perye.dokit.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService {

    PermissionDTO findById(long id);

    PermissionDTO create(Permission resources);

    void update(Permission resources);

    void delete(Set<Permission> permissions);

    Object getPermissionTree(List<Permission> permissions);

    List<Permission> findByPid(long pid);

    Object buildTree(List<PermissionDTO> permissionDTOS);

    List<PermissionDTO> queryAll(PermissionQueryCriteria criteria);

    Set<Permission> getDeletePermission(List<Permission> permissions, Set<Permission> permissionSet);
}

