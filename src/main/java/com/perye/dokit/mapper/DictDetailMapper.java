package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.DictDetailDto;
import com.perye.dokit.entity.DictDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {DictSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetailDto, DictDetail> {

}
