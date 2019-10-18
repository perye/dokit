package com.perye.dokit.service;

import com.perye.dokit.dto.MenuDTO;
import com.perye.dokit.dto.MenuQueryCriteria;
import com.perye.dokit.dto.RoleSmallDTO;
import com.perye.dokit.entity.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CacheConfig(cacheNames = "menu")
public interface MenuService {

    /**
     * queryAll
     * @param criteria
     * @return
     */
    @Cacheable
    List<MenuDTO> queryAll(MenuQueryCriteria criteria);

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    MenuDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    MenuDTO create(Menu resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Menu resources);

    /**
     * getDeleteMenus
     * @param menuList
     * @param menuSet
     * @return
     */
    Set<Menu> getDeleteMenus(List<Menu> menuList, Set<Menu> menuSet);

    /**
     * permission tree
     * @return
     */
    @Cacheable(key = "'tree'")
    Object getMenuTree(List<Menu> menus);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
    List<Menu> findByPid(long pid);

    /**
     * build Tree
     * @param menuDTOS
     * @return
     */
    Map buildTree(List<MenuDTO> menuDTOS);

    /**
     * findByRoles
     * @param roles
     * @return
     */
    List<MenuDTO> findByRoles(List<RoleSmallDTO> roles);

    /**
     * buildMenus
     * @param byRoles
     * @return
     */
    Object buildMenus(List<MenuDTO> byRoles);

    Menu findOne(Long id);

    /**
     * delete
     * @param menuSet
     */
    @CacheEvict(allEntries = true)
    void delete(Set<Menu> menuSet);
}

