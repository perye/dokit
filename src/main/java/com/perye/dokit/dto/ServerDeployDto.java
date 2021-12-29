package com.perye.dokit.dto;

import com.perye.dokit.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Getter
@Setter
public class ServerDeployDto extends BaseEntity implements Serializable {

    private Long id;

    private String name;

    private String ip;

    private Integer port;

    private String account;

    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerDeployDto that = (ServerDeployDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
