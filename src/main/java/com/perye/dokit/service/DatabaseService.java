package com.perye.dokit.service;

import com.perye.dokit.dto.DatabaseDto;
import com.perye.dokit.dto.DatabaseQueryCriteria;
import com.perye.dokit.entity.Database;
import org.springframework.data.domain.Pageable;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public interface DatabaseService {

    /**
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Object queryAll(DatabaseQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部
     * @param criteria 条件
     * @return /
     */
    Object queryAll(DatabaseQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    DatabaseDto findById(String id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    DatabaseDto create(Database resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Database resources);

    /**
     * 删除
     * @param id /
     */
    void delete(String id);


    /**
     * 测试连接数据库
     * @param resources
     * @return
     */
    boolean testConnection(Database resources);
}
