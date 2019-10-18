package com.perye.dokit.dto;

import com.perye.dokit.annotation.Query;
import lombok.Data;

@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;
}
