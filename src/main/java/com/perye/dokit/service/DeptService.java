package com.perye.dokit.service;

import com.perye.dokit.dto.DeptDTO;
import com.perye.dokit.dto.DeptQueryCriteria;
import com.perye.dokit.entity.Dept;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DeptService {

    List<DeptDTO> queryAll(DeptQueryCriteria criteria);

    DeptDTO findById(Long id);

    DeptDTO create(Dept resources);

    void update(Dept resources);

    void delete(Long id);

    Object buildTree(List<DeptDTO> deptDTOS);

    List<Dept> findByPid(long pid);

    Set<Dept> findByRoleIds(Long id);

    void download(List<DeptDTO> queryAll, HttpServletResponse response) throws IOException;

}
