package com.perye.dokit.query;

import com.perye.dokit.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Data
public class DeployHistoryQueryCriteria{

    /**
     * 精确
     */
    @Query(blurry = "appName,ip,deployUser")
    private String blurry;

    @Query
    private Long deployId;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> deployDate;

}
