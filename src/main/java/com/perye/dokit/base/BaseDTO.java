package com.perye.dokit.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
public class BaseDTO implements Serializable {

    private Boolean isDelete;

    private Timestamp createTime;

    private Timestamp updateTime;

    @Override
    public String toString() {
        return "BaseDTO{" +
                "isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
