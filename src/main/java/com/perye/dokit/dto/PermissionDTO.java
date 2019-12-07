package com.perye.dokit.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class PermissionDTO{

    private Long id;

    private String name;

    private Long pid;

    private String alias;

    private List<PermissionDTO> children;

    private Timestamp createTime;

}
