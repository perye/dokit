package com.perye.dokit.service;

import com.perye.dokit.dto.DatabaseDto;
import com.perye.dokit.query.DatabaseQueryCriteria;
import com.perye.dokit.entity.Database;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

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
    List<DatabaseDto> queryAll(DatabaseQueryCriteria criteria);

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
     * @param ids /
     */
    void delete(Set<String> ids);


    /**
     * 测试连接数据库
     * @param resources
     * @return
     */
    boolean testConnection(Database resources);

    /**
     * 导出数据
     * @param queryAll /
     * @param response /
     */
    void download(List<DatabaseDto> queryAll, HttpServletResponse response) throws IOException;
}
