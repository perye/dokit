package com.perye.dokit.entity;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 11:23 下午
 */
@Entity
@Data
@Table(name="mnt_server")
public class ServerDeploy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ip;

    private Integer port;

    private String account;

    private String password;

    @CreationTimestamp
    private Timestamp createTime;

    public void copy(ServerDeploy source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
