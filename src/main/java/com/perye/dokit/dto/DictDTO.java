package com.perye.dokit.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DictDTO implements Serializable {

    private Long id;

    // 字典名称
    private String name;

    // 字典名称
    private String remark;
}
