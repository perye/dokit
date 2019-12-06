package com.perye.dokit.mapper;

import com.perye.dokit.dto.DictDetailDTO;
import com.perye.dokit.entity.DictDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends EntityMapper<DictDetailDTO, DictDetail> {

}
