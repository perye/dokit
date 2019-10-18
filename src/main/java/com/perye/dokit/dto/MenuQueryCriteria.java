package com.perye.dokit.dto;

import com.perye.dokit.annotation.Query;
import lombok.Data;

@Data
public class MenuQueryCriteria {

    // 多字段模糊
    @Query(blurry = "name,path,component")
    private String blurry;
}
