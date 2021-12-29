package com.perye.dokit.security;

import cn.hutool.core.util.StrUtil;
import com.perye.dokit.config.bean.SecurityProperties;
import com.perye.dokit.security.service.UserCacheClean;
import com.perye.dokit.service.OnlineUserService;
import com.perye.dokit.utils.SpringContextHolder;
import com.perye.dokit.vo.OnlineUserDto;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/13
 */
public class TokenFilter extends GenericFilterBean {

    private static final Logger log = LoggerFactory.getLogger(TokenFilter.class);

    private final TokenProvider tokenProvider;
    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;
    private final UserCacheClean userCacheClean;

    /**
     * @param tokenProvider     Token
     * @param properties        JWT
     * @param onlineUserService 用户在线
     * @param userCacheClean    用户缓存清理工具
     */
    public TokenFilter(TokenProvider tokenProvider, SecurityProperties properties, OnlineUserService onlineUserService, UserCacheClean userCacheClean) {
        this.properties = properties;
        this.onlineUserService = onlineUserService;
        this.tokenProvider = tokenProvider;
        this.userCacheClean = userCacheClean;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = resolveToken(httpServletRequest);
        // 对于 Token 为空的不需要去查 Redis
        if (StrUtil.isNotBlank(token)) {
            OnlineUserDto onlineUserDto = null;
            boolean cleanUserCache = false;
            try {
                onlineUserDto = onlineUserService.getOne(properties.getOnlineKey() + token);
            } catch (ExpiredJwtException e) {
                log.error(e.getMessage());
                cleanUserCache = true;
            } finally {
                if (cleanUserCache || Objects.isNull(onlineUserDto)) {
                    userCacheClean.cleanUserCache(String.valueOf(tokenProvider.getClaims(token).get(TokenProvider.AUTHORITIES_KEY)));
                }
            }
            if (onlineUserDto != null && StringUtils.hasText(token)) {
                Authentication authentication = tokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // Token 续期
                tokenProvider.checkRenewal(token);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 初步检测Token
     *
     * @param request
     * @return
     */
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(properties.getHeader());
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(properties.getTokenStartWith())) {
            // 去掉令牌前缀
            return bearerToken.replace(properties.getTokenStartWith(), "");
        } else {
            log.debug("非法Token：{}", bearerToken);
        }
        return null;
    }
}
