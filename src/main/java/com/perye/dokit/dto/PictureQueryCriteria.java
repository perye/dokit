package com.perye.dokit.dto;

import com.perye.dokit.annotation.Query;
import lombok.Data;

/**
 * sm.ms图床
 */
@Data
public class PictureQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String filename;

    @Query(type = Query.Type.INNER_LIKE)
    private String username;
}
