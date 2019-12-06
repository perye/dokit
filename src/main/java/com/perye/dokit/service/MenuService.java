package com.perye.dokit.service;

import com.perye.dokit.dto.MenuDTO;
import com.perye.dokit.dto.MenuQueryCriteria;
import com.perye.dokit.dto.RoleSmallDTO;
import com.perye.dokit.entity.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MenuService {

    List<MenuDTO> queryAll(MenuQueryCriteria criteria);

    MenuDTO findById(long id);

    MenuDTO create(Menu resources);

    void update(Menu resources);

    Set<Menu> getDeleteMenus(List<Menu> menuList, Set<Menu> menuSet);

    Object getMenuTree(List<Menu> menus);

    List<Menu> findByPid(long pid);

    Map<String,Object> buildTree(List<MenuDTO> menuDTOS);

    List<MenuDTO> findByRoles(List<RoleSmallDTO> roles);

    Object buildMenus(List<MenuDTO> byRoles);

    Menu findOne(Long id);

    void delete(Set<Menu> menuSet);
}

