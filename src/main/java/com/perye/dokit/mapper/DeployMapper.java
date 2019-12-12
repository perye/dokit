package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.DeployDto;
import com.perye.dokit.entity.Deploy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Mapper(componentModel = "spring",uses = {AppMapper.class, ServerDeployMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeployMapper extends BaseMapper<DeployDto, Deploy> {

}
