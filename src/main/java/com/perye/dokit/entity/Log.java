package com.perye.dokit.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "sys_log")
@NoArgsConstructor
public class Log implements Serializable {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 操作用户
    private String username;

    // 描述
    private String description;

    // 方法名
    private String method;

    // 参数
    private String params;

    // 日志类型
    private String logType;

    // 请求ip
    private String requestIp;

    private String address;

    private String browser;

    // 请求耗时
    private Long time;

    // 异常详细
    private byte[] exceptionDetail;

    // 创建日期
    @CreationTimestamp
    private Timestamp createTime;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}

