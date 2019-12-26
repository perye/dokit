package com.perye.dokit.query;

import com.perye.dokit.annotation.Query;
import lombok.Data;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 3:59 下午
 */
@Data
public class ServerQueryCriteria{

    @Query(blurry = "name,address")
    private String blurry;
}
