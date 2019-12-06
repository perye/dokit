package ${package}.repository;

import ${package}.entity.${className};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ${className}Repository extends JpaRepository<${className}, ${pkColumnType}>, JpaSpecificationExecutor<${className}> {
<#if columns??>
    <#list columns as column>
        <#if column.columnKey = 'UNI'>

    ${className} findBy${column.capitalColumnName}(${column.columnType} ${column.columnName});
        </#if>
    </#list>
</#if>
}
