package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.RoleDto;
import com.perye.dokit.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {

}
