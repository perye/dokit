package com.perye.dokit.service;

import com.perye.dokit.dto.DictDTO;
import com.perye.dokit.dto.DictQueryCriteria;
import com.perye.dokit.entity.Dict;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DictService {

    Map<String,Object> queryAll(DictQueryCriteria dict, Pageable pageable);

    List<DictDTO> queryAll(DictQueryCriteria dict);

    DictDTO findById(Long id);

    DictDTO create(Dict resources);

    void update(Dict resources);

    void delete(Long id);

    void download(List<DictDTO> queryAll, HttpServletResponse response) throws IOException;

}
