package com.perye.dokit.dto;

import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;



@Data
public class CaptchaDto implements Serializable {
    // id
    // 处理精度丢失问题
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    // 验证码类型
    private Integer type;
    // 字体名字
    private String fontName;
    // 字体风格
    private Integer fontStyle;
    // 字体大小
    private Integer fontSize;
    // 宽度
    private Integer width;
    // 高度
    private Integer height;
    // 位数
    private Integer len;
}
