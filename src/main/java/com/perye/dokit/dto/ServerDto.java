package com.perye.dokit.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 3:58 下午
 */
@Data
public class ServerDto implements Serializable {

    // 编号
    private Integer id;

    // 名称
    private String name;

    // IP地址
    private String address;

    // 访问端口
    private Integer port;

    // 状态
    private String state;

    // CPU使用率
    private Float cpuRate;

    // CPU内核数
    private Integer cpuCore;

    // 内存总数
    private Float memTotal;

    // 内存使用量
    private Float memUsed;

    // 磁盘总量
    private Float diskTotal;

    // 磁盘使用量
    private Float diskUsed;

    // 交换区总量
    private Float swapTotal;

    // 交换区使用量
    private Float swapUsed;

    // 排序
    private Integer sort;
}
