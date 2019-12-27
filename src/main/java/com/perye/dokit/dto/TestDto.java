package com.perye.dokit.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;



@Data
public class TestDto implements Serializable {
    // id
    private Integer id;
    // 邮箱
    private String email;
    // 用户名
    private String username;
    // 创建时间
    private Timestamp createTime;
}
