package com.perye.dokit.service.impl;

import com.perye.dokit.entity.Captcha;
import com.perye.dokit.utils.ValidationUtil;
import com.perye.dokit.utils.FileUtil;
import com.perye.dokit.repository.CaptchaRepository;
import com.perye.dokit.service.CaptchaService;
import com.perye.dokit.dto.CaptchaDto;
import com.perye.dokit.query.CaptchaQueryCriteria;
import com.perye.dokit.mapper.CaptchaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
@CacheConfig(cacheNames = "captcha")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CaptchaServiceImpl implements CaptchaService {

    private final CaptchaRepository captchaRepository;

    private final CaptchaMapper captchaMapper;

    public CaptchaServiceImpl(CaptchaRepository captchaRepository, CaptchaMapper captchaMapper) {
        this.captchaRepository = captchaRepository;
        this.captchaMapper = captchaMapper;
    }

    @Override
    @Cacheable
    public Map<String,Object> queryAll(CaptchaQueryCriteria criteria, Pageable pageable){
        Page<Captcha> page = captchaRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(captchaMapper::toDto));
    }

    @Override
    @Cacheable
    public List<CaptchaDto> queryAll(CaptchaQueryCriteria criteria){
        return captchaMapper.toDto(captchaRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable(key = "#p0")
    public CaptchaDto findById(Long id) {
        Captcha captcha = captchaRepository.findById(id).orElseGet(Captcha::new);
        ValidationUtil.isNull(captcha.getId(),"Captcha","id",id);
        return captchaMapper.toDto(captcha);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public CaptchaDto create(Captcha resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId());
        return captchaMapper.toDto(captchaRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Captcha resources) {
        Captcha captcha = captchaRepository.findById(resources.getId()).orElseGet(Captcha::new);
        ValidationUtil.isNull( captcha.getId(),"Captcha","id",resources.getId());
        captcha.copy(resources);
        captchaRepository.save(captcha);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        captchaRepository.deleteById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            captchaRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<CaptchaDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (CaptchaDto captcha : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("验证码类型", captcha.getType());
            map.put("字体名字", captcha.getFontName());
            map.put("字体风格", captcha.getFontStyle());
            map.put("字体大小", captcha.getFontSize());
            map.put("宽度", captcha.getWidth());
            map.put("高度", captcha.getHeight());
            map.put("位数", captcha.getLen());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

 }
