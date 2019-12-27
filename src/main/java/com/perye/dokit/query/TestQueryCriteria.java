package com.perye.dokit.query;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;
import com.perye.dokit.annotation.Query;

@Data
public class TestQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 精确
    @Query
    private String email;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String username;
     /** BETWEEN */
     @Query(type = Query.Type.BETWEEN)
     private List<Timestamp> createTime;
}
