package ${package}.controller;

import com.perye.dokit.aop.log.Log;
import ${package}.entity.${className};
import ${package}.service.${className}Service;
import ${package}.dto.${className}QueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


@Api(tags = "${className}管理")
@RestController
@RequestMapping("/api/${changeClassName}")
public class ${className}Controller {

    private final ${className}Service ${changeClassName}Service;

    public ${className}Controller(${className}Service ${changeClassName}Service) {
        this.${changeClassName}Service = ${changeClassName}Service;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@dokit.check('${changeClassName}:list')")
    public void download(HttpServletResponse response, ${className}QueryCriteria criteria) throws IOException {
        ${changeClassName}Service.download(${changeClassName}Service.queryAll(criteria), response);
    }

    @Log("查询${className}")
    @ApiOperation("查询${className}")
    @GetMapping()
    @PreAuthorize("@dokit.check('${changeClassName}:list')")
    public ResponseEntity get${className}s(${className}QueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(${changeClassName}Service.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增${className}")
    @ApiOperation("新增${className}")
    @PostMapping
    @PreAuthorize("@dokit.check('${changeClassName}:add')")
    public ResponseEntity create(@Validated @RequestBody ${className} resources){
        return new ResponseEntity<>(${changeClassName}Service.create(resources),HttpStatus.CREATED);
    }

    @Log("修改${className}")
    @ApiOperation("修改${className}")
    @PutMapping
    @PreAuthorize("@dokit.check('${changeClassName}:edit')")
    public ResponseEntity update(@Validated @RequestBody ${className} resources){
    ${changeClassName}Service.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除${className}")
    @ApiOperation("删除${className}")
    @DeleteMapping(value = "/{${pkChangeColName}}")
    @PreAuthorize("@dokit.check('${changeClassName}:del')")
    public ResponseEntity delete(@PathVariable ${pkColumnType} ${pkChangeColName}){
    ${changeClassName}Service.delete(${pkChangeColName});
        return new ResponseEntity(HttpStatus.OK);
    }
}
