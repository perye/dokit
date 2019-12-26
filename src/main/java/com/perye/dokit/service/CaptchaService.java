package com.perye.dokit.service;

import com.perye.dokit.entity.Captcha;
import com.perye.dokit.dto.CaptchaDto;
import com.perye.dokit.query.CaptchaQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface CaptchaService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(CaptchaQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<CaptchaDto>
    */
    List<CaptchaDto> queryAll(CaptchaQueryCriteria criteria);

    /**
    * 根据ID查询
    * @param id ID
    * @return CaptchaDto
    */
    CaptchaDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return CaptchaDto
    */
    CaptchaDto create(Captcha resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(Captcha resources);

    /**
    * 删除
    * @param id /
    */
    void delete(Long id);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<CaptchaDto> all, HttpServletResponse response) throws IOException;

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);
}
