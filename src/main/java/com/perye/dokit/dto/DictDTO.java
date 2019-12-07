package com.perye.dokit.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class DictDTO{

    private Long id;

    // 字典名称
    private String name;

    // 字典名称
    private String remark;

    private Timestamp createTime;
}
