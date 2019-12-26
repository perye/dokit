package com.perye.dokit.query;

import com.perye.dokit.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MenuQueryCriteria {

    // 多字段模糊
    @Query(blurry = "name,path,component")
    private String blurry;


    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
