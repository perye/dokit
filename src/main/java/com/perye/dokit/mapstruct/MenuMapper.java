package com.perye.dokit.mapstruct;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.MenuDto;
import com.perye.dokit.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {

}
