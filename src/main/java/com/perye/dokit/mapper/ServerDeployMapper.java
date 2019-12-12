package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.ServerDeployDto;
import com.perye.dokit.entity.ServerDeploy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerDeployMapper extends BaseMapper<ServerDeployDto, ServerDeploy> {

}
