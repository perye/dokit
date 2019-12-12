package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.RoleSmallDto;
import com.perye.dokit.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends BaseMapper<RoleSmallDto, Role> {

}
