package ${package}.mapper;

import com.perye.dokit.base.BaseMapper;
import ${package}.entity.${className};
import ${package}.dto.${className}DTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ${className}Mapper extends BaseMapper<${className}DTO, ${className}> {

}
