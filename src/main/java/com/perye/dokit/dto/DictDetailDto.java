package com.perye.dokit.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
public class DictDetailDto implements Serializable {
    private Long id;

    // 字典标签
    private String label;

    // 字典值
    private String value;

    // 排序
    private Integer sort;

    private DictSmallDto dict;

    private Timestamp createTime;
}
