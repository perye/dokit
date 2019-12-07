package com.perye.dokit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.perye.dokit.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class DeptDTO  extends BaseDTO {

    // ID
    private Long id;

    // 名称
    private String name;

    @NotNull
    private Boolean enabled;

    // 上级部门
    private Long pid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeptDTO> children;

    public String getLabel() {
        return name;
    }
}
