package com.perye.dokit.mapstruct;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.DictDto;
import com.perye.dokit.entity.Dict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDto, Dict> {

}
