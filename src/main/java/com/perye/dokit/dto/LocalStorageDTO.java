package com.perye.dokit.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class LocalStorageDTO implements Serializable {

    // ID
    private Long id;

    private String realName;

    // 文件名
    private String name;

    // 后缀
    private String suffix;

    // 类型
    private String type;

    // 大小
    private String size;

    // 操作人
    private String operate;

    // 创建日期
    private Timestamp createTime;

    // 修改日期
    private Timestamp updateTime;
}
