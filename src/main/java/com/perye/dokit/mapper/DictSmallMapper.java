package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.DictSmallDto;
import com.perye.dokit.entity.Dict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/11
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictSmallMapper extends BaseMapper<DictSmallDto, Dict> {

}
