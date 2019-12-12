package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.DatabaseDto;
import com.perye.dokit.entity.Database;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DatabaseMapper extends BaseMapper<DatabaseDto, Database> {

}
