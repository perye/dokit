package com.perye.dokit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
public class JobDTO{

    // ID
    private Long id;

    private Long sort;

    // 名称
    private String name;

    // 状态
    private Boolean enabled;

    private DeptDTO dept;

    // 如果分公司存在相同部门，则显示上级部门名称
    private String deptSuperiorName;

    public JobDTO(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    private Timestamp createTime;
}
