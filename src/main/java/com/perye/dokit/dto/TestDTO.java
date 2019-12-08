package com.perye.dokit.dto;

import lombok.Data;
import java.io.Serializable;



@Data
public class TestDTO implements Serializable {
    // id
    private Integer id;
    //  用户名
    private String username;
    // 邮箱
    private String email;
}