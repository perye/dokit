package com.perye.dokit.entity;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

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
    @Column(name = "id")
    private String id;

    /**
     * 应用编号
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * IP列表
     */
    @Column(name = "ip")
    private String ip;

    public void copy(Deploy source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
