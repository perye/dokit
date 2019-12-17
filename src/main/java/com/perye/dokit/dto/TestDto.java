package com.perye.dokit.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;



@Data
public class TestDto implements Serializable {
    // id
    private Integer id;
    // createTime
    private Timestamp createtime;
    // username
    private String username;
}
