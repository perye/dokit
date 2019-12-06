package com.perye.dokit.mapper;

import com.perye.dokit.dto.LogSmallDTO;
import com.perye.dokit.entity.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends EntityMapper<LogSmallDTO, Log> {

}
