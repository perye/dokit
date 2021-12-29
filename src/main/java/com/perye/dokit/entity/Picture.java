package com.perye.dokit.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * sm.ms图床
 */
@Data
@Entity
@Table(name = "tool_picture")
public class Picture implements Serializable {

    @Id
    @Column(name = "picture_id")
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "文件名")
    private String filename;

    @ApiModelProperty(value = "图片url")
    private String url;

    @ApiModelProperty(value = "图片大小")
    private String size;

    @ApiModelProperty(value = "图片高")
    private String height;

    @ApiModelProperty(value = "图片宽")
    private String width;

    @Column(name = "delete_url")
    @ApiModelProperty(value = "用于删除的url")
    private String delete;

    @ApiModelProperty(value = "创建者")
    private String username;

    @CreationTimestamp
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    // 用于检测文件是否重复
    private String md5Code;

    @Override
    public String toString() {
        return "Picture{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
