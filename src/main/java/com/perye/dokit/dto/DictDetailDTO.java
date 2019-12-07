package com.perye.dokit.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class DictDetailDTO{

    private Long id;

    // 字典标签
    private String label;

    // 字典值
    private String value;

    // 排序
    private String sort;

    private Timestamp createTime;
}
