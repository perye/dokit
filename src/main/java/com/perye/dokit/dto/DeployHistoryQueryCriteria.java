package com.perye.dokit.dto;

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
    @Query(blurry = "appName,ip,deployUser,deployId")
    private String blurry;



    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> deployDate;

}
