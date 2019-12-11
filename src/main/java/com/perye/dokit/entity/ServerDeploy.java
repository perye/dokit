package com.perye.dokit.entity;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 11:23 下午
 */
@Entity
@Data
@Table(name="mnt_server")
public class ServerDeploy implements Serializable {

    /**
     * 服务器IP
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 服务器账号
     */
    @Column(name = "account_id")
    private String accountId;

    public void copy(ServerDeploy source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
