package com.perye.dokit.service.impl;

import com.perye.dokit.dto.RoleSmallDto;
import com.perye.dokit.dto.UserDto;
import com.perye.dokit.entity.Dept;
import com.perye.dokit.enums.DataScopeEnum;
import com.perye.dokit.service.DataService;
import com.perye.dokit.service.DeptService;
import com.perye.dokit.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 数据权限服务实现
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "data")
public class DataServiceImpl implements DataService {

    private final RoleService roleService;
    private final DeptService deptService;

    /**
     * 用户角色改变时需清理缓存
     * @param user /
     * @return /
     */
    @Override
    @Cacheable(key = "'user:' + #p0.id")
    public List<Long> getDeptIds(UserDto user) {
        // 用于存储部门id
        Set<Long> deptIds = new HashSet<>();
        // 查询用户角色
        List<RoleSmallDto> roleSet = roleService.findByUsersId(user.getId());
        // 获取对应的部门ID
        for (RoleSmallDto role : roleSet) {
            DataScopeEnum dataScopeEnum = DataScopeEnum.find(role.getDataScope());
            switch (Objects.requireNonNull(dataScopeEnum)) {
                case THIS_LEVEL:
                    deptIds.add(user.getDept().getId());
                    break;
                case CUSTOMIZE:
                    deptIds.addAll(getCustomize(deptIds, role));
                    break;
                default:
                    break;
            }
        }
        return new ArrayList<>(deptIds);
    }

    /**
     * 获取自定义的数据权限
     *
     * @param deptIds 部门ID
     * @param role    角色
     * @return 数据权限ID
     */
    public Set<Long> getCustomize(Set<Long> deptIds, RoleSmallDto role) {
        Set<Dept> depts = deptService.findByRoleId(role.getId());
        for (Dept dept : depts) {
            deptIds.add(dept.getId());
            List<Dept> deptChildren = deptService.findByPid(dept.getId());
            if (deptChildren != null && deptChildren.size() != 0) {
                deptIds.addAll(deptService.getDeptChildren(dept.getId(), deptChildren));
            }
        }
        return deptIds;
    }

}