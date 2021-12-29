package com.perye.dokit.dto;

import com.perye.dokit.base.BaseDTO;
import com.perye.dokit.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Getter
@Setter
public class DatabaseDto extends BaseDTO implements Serializable {

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


}
