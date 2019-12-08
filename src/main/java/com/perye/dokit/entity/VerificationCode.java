package com.perye.dokit.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification_code")
public class VerificationCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    // 使用场景，自己定义
    private String scenes;

    // true 为有效，false 为无效，验证时状态+时间+具体的邮箱或者手机号
    private Boolean status = true;


    // 类型 ：phone 和 email
    @NotBlank
    private String type;

    // 具体的phone与email
    @NotBlank
    private String value;


    public VerificationCode(String code, String scenes, @NotBlank String type, @NotBlank String value) {
        this.code = code;
        this.scenes = scenes;
        this.type = type;
        this.value = value;
    }
}
