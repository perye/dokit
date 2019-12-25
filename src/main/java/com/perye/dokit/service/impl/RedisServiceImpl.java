package com.perye.dokit.service.impl;

import com.perye.dokit.config.SecurityProperties;
import com.perye.dokit.service.RedisService;
import com.perye.dokit.utils.FileUtil;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.StringUtils;
import com.perye.dokit.vo.RedisVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@SuppressWarnings({"unchecked","all"})
public class RedisServiceImpl implements RedisService {

    private final SecurityProperties properties;

    private final RedisTemplate redisTemplate;

    public RedisServiceImpl(RedisTemplate redisTemplate, SecurityProperties properties) {
        this.redisTemplate = redisTemplate;
        this.properties = properties;
    }

    @Value("${loginCode.expiration}")
    private Long expiration;

    @Override
    public Page<RedisVo> findByKey(String key, Pageable pageable) {
        // 不传值默认查询全部:*
        if (StringUtils.isEmpty(key)) {
            key = "*";
        }
        List<RedisVo> redisVos = findByKey(key);
        return new PageImpl<RedisVo>(
                PageUtil.toPage(pageable.getPageNumber(), pageable.getPageSize(), redisVos),
                pageable,
                redisVos.size());
    }

    @Override
    public List<RedisVo> findByKey(String key) {
        List<RedisVo> redisVos = new ArrayList<>();
        if(!"*".equals(key)){
            key = "*" + key + "*";
        }
        Set<String> keys = redisTemplate.keys(key);
        for (String s : keys) {
            // 过滤掉权限的缓存
            if (s.contains("role::loadPermissionByUser") || s.contains("user::loadUserByUsername") || s.contains(properties.getOnlineKey()) || s.contains(properties.getCodeKey())) {
                continue;
            }
            RedisVo redisVo = new RedisVo(s, Objects.requireNonNull(redisTemplate.opsForValue().get(s)).toString());
            redisVos.add(redisVo);
        }
        return redisVos;
    }

    @Override
    public void delete(Set<String> keys) {
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }


    @Override
    public String getCodeVal(String key) {
        try {
            return Objects.requireNonNull(redisTemplate.opsForValue().get(key)).toString();
        }catch (Exception e){
            return "";
        }
    }

    @Override
    public void saveCode(String key, Object val) {
        redisTemplate.opsForValue().set(key,val);
        redisTemplate.expire(key,expiration, TimeUnit.MINUTES);
    }

    @Override
    public void download(List<RedisVo> redisVos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (RedisVo redisVo : redisVos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("key", redisVo.getKey());
            map.put("value", redisVo.getValue());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}

