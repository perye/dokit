package com.perye.dokit.dto;

import com.perye.dokit.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
public class DictDto extends BaseDTO implements Serializable {

    private Long id;

    private List<DictDetailDto> dictDetails;

    private String name;

    private String description;

}
