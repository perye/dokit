package com.perye.dokit.dto;

import lombok.Data;
    import com.perye.dokit.annotation.Query;

@Data
public class TestQueryCriteria{

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String email;
}
