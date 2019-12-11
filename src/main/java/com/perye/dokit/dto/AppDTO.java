package com.perye.dokit.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Data
public class AppDTO implements Serializable {

    /**
     * 应用编号
     */
    private String id;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 端口
     */
    private int port;

    /**
     * 上传目录
     */
    private String uploadPath;

    /**
     * 部署目录
     */
    private String deployPath;

    /**
     * 备份目录
     */
    private String backupPath;

    /**
     * 启动脚本
     */
    private String startScript;

    /**
     * 部署脚本
     */
    private String deployScript;

}
