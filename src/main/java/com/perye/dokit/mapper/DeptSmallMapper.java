package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.DeptSmallDto;
import com.perye.dokit.entity.Dept;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptSmallMapper extends BaseMapper<DeptSmallDto, Dept> {

}
