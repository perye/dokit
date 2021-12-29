package com.perye.dokit.mapstruct;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.JobSmallDto;
import com.perye.dokit.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends BaseMapper<JobSmallDto, Job> {

}
