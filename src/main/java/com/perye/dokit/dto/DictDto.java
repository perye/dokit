package com.perye.dokit.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
public class DictDto implements Serializable {
    private Long id;

    // 字典名称
    private String name;

    // 字典名称
    private String remark;

    private List<DictDetailDto> dictDetails;

    private Timestamp createTime;
}
