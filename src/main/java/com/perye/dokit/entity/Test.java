package com.perye.dokit.entity;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name="test")
public class Test implements Serializable {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //  用户名
    @Column(name = "username")
    private String username;

    // 邮箱
    @Column(name = "email")
    private String email;

    public void copy(Test source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}