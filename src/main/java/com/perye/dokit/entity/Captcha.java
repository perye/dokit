package com.perye.dokit.entity;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
* @author perye
* @date 2019-12-17
*/
@Entity
@Data
@Table(name="captcha")
public class Captcha implements Serializable {

    /** id */
    @Id
    @Column(name = "id")
    private Long id;

    /** 验证码类型 */
    @Column(name = "type",nullable = false)
    @NotNull
    private Integer type;

    /** 字体名字 */
    @Column(name = "font_name")
    private String fontName;

    /** 字体风格 */
    @Column(name = "font_style")
    private Integer fontStyle;

    /** 字体大小 */
    @Column(name = "font_size")
    private Integer fontSize;

    /** 宽度 */
    @Column(name = "width")
    private Integer width;

    /** 高度 */
    @Column(name = "height")
    private Integer height;

    /** 位数 */
    @Column(name = "len")
    private Integer len;

    public void copy(Captcha source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
