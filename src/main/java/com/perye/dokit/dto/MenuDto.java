package com.perye.dokit.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class MenuDto implements Serializable {

    private Long id;

    private Integer type;

    private String permission;

    private String name;

    private Long sort;

    private String path;

    private String component;

    private Long pid;

    private Boolean iFrame;

    private Boolean cache;

    private Boolean hidden;

    private String componentName;

    private String icon;

    private List<MenuDto> children;

    private Timestamp createTime;

}
