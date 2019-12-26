package com.perye.dokit.query;

import com.perye.dokit.annotation.Query;
import lombok.Data;

@Data
public class DictQueryCriteria {

    // 多字段模糊
    @Query(blurry = "name,remark")
    private String blurry;
}

