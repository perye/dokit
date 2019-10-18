package com.perye.dokit.mapper;

import com.perye.dokit.dto.LocalStorageDTO;
import com.perye.dokit.entity.LocalStorage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends EntityMapper<LocalStorageDTO, LocalStorage> {

}
