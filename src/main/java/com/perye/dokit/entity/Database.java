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

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 10:55 下午
 */
@Entity
@Getter
@Setter
@Table(name="mnt_database")
public class Database extends BaseEntity implements Serializable {

    @Id
    @Column(name = "db_id")
    @ApiModelProperty(value = "ID", hidden = true)
    private String id;

    @ApiModelProperty(value = "数据库名称")
    private String name;

    @ApiModelProperty(value = "数据库连接地址")
    private String jdbcUrl;

    @ApiModelProperty(value = "数据库密码")
    private String pwd;

    @ApiModelProperty(value = "用户名")
    private String userName;

    public void copy(Database source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
