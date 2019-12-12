package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.LocalStorageDto;
import com.perye.dokit.entity.LocalStorage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends BaseMapper<LocalStorageDto, LocalStorage> {

}
