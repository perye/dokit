package com.perye.dokit.mapstruct;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.JobDTO;
import com.perye.dokit.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<JobDTO, Job> {

}
