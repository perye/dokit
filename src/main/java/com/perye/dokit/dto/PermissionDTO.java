package com.perye.dokit.dto;

import com.perye.dokit.base.BaseDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class PermissionDTO  extends BaseDTO {

    private Long id;

    private String name;

    private Long pid;

    private String alias;

    private List<PermissionDTO> children;

}
