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
public class ServerDeployDto implements Serializable {

    private Long id;

    private String name;

    private String ip;

    private Integer port;

    private String account;

    private String password;

    private Timestamp createTime;
}
