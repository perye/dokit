package com.perye.dokit.dto;

import com.perye.dokit.annotation.Query;
import lombok.Data;

@Data
public class QuartzJobQueryCriteria {
    @Query(type = Query.Type.INNER_LIKE)
    private String jobName;

    @Query
    private Boolean isSuccess;
}
