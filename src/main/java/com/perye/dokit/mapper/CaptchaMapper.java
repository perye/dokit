package com.perye.dokit.mapper;

import com.perye.dokit.base.BaseMapper;
import com.perye.dokit.entity.Captcha;
import com.perye.dokit.dto.CaptchaDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CaptchaMapper extends BaseMapper<CaptchaDto, Captcha> {

}
