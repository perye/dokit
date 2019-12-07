package com.perye.dokit.entity;

import com.perye.dokit.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="dict_detail")
public class DictDetail extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    // 字典标签
    @Column(name = "label",nullable = false)
    private String label;

    // 字典值
    @Column(name = "value",nullable = false)
    private String value;

    // 排序
    @Column(name = "sort")
    private String sort = "999";

    // 字典id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "dict_id")
    private Dict dict;

}
