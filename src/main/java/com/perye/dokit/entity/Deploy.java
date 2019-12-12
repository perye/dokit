package com.perye.dokit.entity;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 10:59 下午
 */
@Entity
@Data
@Table(name="mnt_deploy")
public class Deploy implements Serializable {

    /**
     * 部署编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应用编号
     */
    @ManyToOne
    @JoinColumn(name = "app_id")
    private App app;

    /**
     * 服务器
     */
    @Column(name = "ip")
    @ManyToMany
    @JoinTable(name = "mnt_deploy_server", joinColumns = {@JoinColumn(name = "deploy_id",referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "server_id",referencedColumnName = "id")})
    private Set<ServerDeploy> deploys;

    @CreationTimestamp
    private Timestamp createTime;

    public void copy(Deploy source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
