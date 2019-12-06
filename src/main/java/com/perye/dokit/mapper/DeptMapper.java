package com.perye.dokit.mapper;

import com.perye.dokit.dto.DeptDTO;
import com.perye.dokit.entity.Dept;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends EntityMapper<DeptDTO, Dept> {

}
