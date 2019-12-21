package com.perye.dokit.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Data
public class DatabaseDto implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 数据库名称
     */
    private String name;

    /**
     * 数据库连接地址
     */
    private String jdbcUrl;

    /**
     * 数据库密码
     */
    private String pwd;

    /**
     * 用户名
     */
    private String userName;

    private Timestamp createTime;


}
