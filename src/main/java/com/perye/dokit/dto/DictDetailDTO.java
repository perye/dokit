package com.perye.dokit.dto;

import com.perye.dokit.base.BaseDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DictDetailDTO  extends BaseDTO {

    private Long id;

    // 字典标签
    private String label;

    // 字典值
    private String value;

    // 排序
    private String sort;
}
