package com.perye.dokit.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 邮件配置类，数据存覆盖式存入数据存
 */
@Entity
@Data
@Table(name = "email_config")
public class EmailConfig implements Serializable {

    @Id
    private Long id;

    // 邮件服务器SMTP地址
    @NotBlank
    private String host;

    // 邮件服务器SMTP端口
    @NotBlank
    private String port;

    // 发件者用户名，默认为发件人邮箱前缀
    @NotBlank
    private String user;

    @NotBlank
    private String pass;

    // 收件人
    @NotBlank
    @Column(name = "from_user")
    private String fromUser;
}

