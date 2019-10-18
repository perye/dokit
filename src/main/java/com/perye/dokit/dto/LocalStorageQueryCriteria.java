package com.perye.dokit.dto;

import com.perye.dokit.annotation.Query;
import lombok.Data;

@Data
public class LocalStorageQueryCriteria{

    // 模糊
    @Query(blurry = "name,suffix,type,operate,size")
    private String blurry;
}
