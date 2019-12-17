package com.perye.dokit.entity;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author perye
* @date 2019-12-17
*/
@Entity
@Data
@Table(name="test")
public class Test implements Serializable {

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** createTime */
    @Column(name = "createTime",nullable = false)
    @NotNull
    @CreationTimestamp
    private Timestamp createtime;

    /** username */
    @Column(name = "username",nullable = false)
    @NotBlank
    private String username;

    public void copy(Test source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
