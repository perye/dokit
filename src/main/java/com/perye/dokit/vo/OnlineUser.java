package com.perye.dokit.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OnlineUser {

    private String userName;

    private String browser;

    private String ip;

    private String address;

    private Date createTime;

    private Date lastAccessTime;

}
