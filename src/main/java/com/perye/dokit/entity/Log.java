package com.perye.dokit.entity;

import com.perye.dokit.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "log")
@NoArgsConstructor
public class Log  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 操作用户
    private String username;

    // 描述
    private String description;

    // 方法名
    private String method;

    // 参数
    @Column(columnDefinition = "text")
    private String params;

    // 日志类型
    @Column(name = "log_type")
    private String logType;

    // 请求ip
    @Column(name = "request_ip")
    private String requestIp;

    @Column(name = "address")
    private String address;

    // 请求耗时
    private Long time;

    // 异常详细
    @Column(name = "exception_detail", columnDefinition = "text")
    private byte[] exceptionDetail;

    // 创建日期
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}

