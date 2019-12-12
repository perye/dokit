package com.perye.dokit.dto;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Data
public class DeployDto implements Serializable {

    /**
     * 部署编号
     */
    private String id;

    private AppDto app;

    /**
     * 服务器
     */
    private Set<ServerDeployDto> deploys;

    private String servers;

    /**
     * 服务状态
     */
    private String status;

    private Timestamp createTime;

    public String getServers() {
        if(CollectionUtil.isNotEmpty(deploys)){
            return deploys.stream().map(ServerDeployDto::getName).collect(Collectors.joining(","));
        }
        return servers;
    }

}
