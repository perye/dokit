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
public class DeployQueryCriteria{

    /**
     * 模糊
     */
    @Query(type = Query.Type.INNER_LIKE, propName = "name", joinName = "app")
    private String appName;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

}
