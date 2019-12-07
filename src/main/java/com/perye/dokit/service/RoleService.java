package com.perye.dokit.service;

import com.perye.dokit.dto.RoleDTO;
import com.perye.dokit.dto.RoleQueryCriteria;
import com.perye.dokit.dto.RoleSmallDTO;
import com.perye.dokit.entity.Role;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface RoleService {

    RoleDTO findById(long id);

    RoleDTO create(Role resources);

    void update(Role resources);

    void delete(Long id);

    List<RoleSmallDTO> findByUsers_Id(Long id);

    Integer findByRoles(Set<Role> roles);

    void updateMenu(Role resources, RoleDTO roleDTO);

    void untiedMenu(Long id);

    Object queryAll(Pageable pageable);

    Object queryAll(RoleQueryCriteria criteria, Pageable pageable);

    List<RoleDTO> queryAll(RoleQueryCriteria criteria);

}

