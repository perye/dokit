package com.perye.dokit.dto;

import com.perye.dokit.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;

    @Query(type = Query.Type.GREATER_THAN,propName = "updateTime")
    private Timestamp startTime;

    @Query(type = Query.Type.LESS_THAN,propName = "updateTime")
    private Timestamp endTime;
}
