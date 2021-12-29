package com.perye.dokit.entity;

import com.perye.dokit.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@Table(name="mnt_deploy")
public class Deploy extends BaseEntity implements Serializable {

    /**
     * 部署编号
     */
    @Id
    @Column(name = "deploy_id")
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_id")
    @ApiModelProperty(value = "应用编号")
    private App app;

    @ManyToMany
    @ApiModelProperty(name = "服务器", hidden = true)
    @JoinTable(name = "mnt_deploy_server",
            joinColumns = {@JoinColumn(name = "deploy_id",referencedColumnName = "deploy_id")},
            inverseJoinColumns = {@JoinColumn(name = "server_id",referencedColumnName = "server_id")})
    private Set<ServerDeploy> deploys;

    public void copy(Deploy source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
