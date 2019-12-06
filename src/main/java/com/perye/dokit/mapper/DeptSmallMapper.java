package com.perye.dokit.mapper;

import com.perye.dokit.dto.DeptSmallDTO;
import com.perye.dokit.entity.Dept;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptSmallMapper extends EntityMapper<DeptSmallDTO, Dept> {

}
