package com.perye.dokit.mapstruct;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.dto.UserDto;
import com.perye.dokit.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDto, User> {

}

