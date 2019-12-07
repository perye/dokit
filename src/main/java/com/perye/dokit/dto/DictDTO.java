package com.perye.dokit.dto;

import com.perye.dokit.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DictDTO extends BaseDTO {

    private Long id;

    // 字典名称
    private String name;

    // 字典名称
    private String remark;
}
