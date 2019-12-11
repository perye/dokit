package com.perye.dokit.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Data
public class ServerDeployDTO implements Serializable {

    /**
     * 服务器IP
     */
    private String id;

    /**
     * 服务器账号
     */
    private String accountId;
}
