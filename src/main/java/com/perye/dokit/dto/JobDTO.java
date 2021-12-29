package com.perye.dokit.dto;

import com.perye.dokit.base.BaseDTO;
import com.perye.dokit.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
public class JobDTO extends BaseDTO implements Serializable {

    private Long id;

    private Integer jobSort;

    private String name;

    private Boolean enabled;

    public JobDTO(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }
}
