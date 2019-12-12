package com.perye.dokit.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JobSmallDto implements Serializable {

    // ID
    private Long id;

    // 名称
    private String name;
}
