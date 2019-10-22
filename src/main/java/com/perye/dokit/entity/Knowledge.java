package com.perye.dokit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 知识图谱
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "knowledge")
public class Knowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private int count;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public Knowledge(String text, int count, Date updateTime) {
        this.text = text;
        this.count = count;
        this.updateTime = updateTime;
    }
}
