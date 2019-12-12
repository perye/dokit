package com.perye.dokit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class DeptDto implements Serializable {

    // ID
    private Long id;

    // 名称
    private String name;

    @NotNull
    private Boolean enabled;

    // 上级部门
    private Long pid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeptDto> children;

    public String getLabel() {
        return name;
    }

    private Timestamp createTime;
}
