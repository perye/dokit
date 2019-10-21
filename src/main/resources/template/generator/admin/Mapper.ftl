package ${package}.mapper;

import ${package}.entity.${className};
import ${package}.dto.${className}DTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ${className}Mapper extends EntityMapper<${className}DTO, ${className}> {

}
