package com.perye.dokit.service;

import com.perye.dokit.entity.AlipayConfig;
import com.perye.dokit.vo.TradeVo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "alipay")
public interface AlipayService {

    /**
     * 处理来自PC的交易请求
     * @param alipay 支付宝配置
     * @param trade 交易详情
     * @return String
     * @throws Exception 异常
     */
    String toPayAsPC(AlipayConfig alipay, TradeVo trade) throws Exception;

    /**
     * 处理来自手机网页的交易请求
     * @param alipay 支付宝配置
     * @param trade 交易详情
     * @return String
     * @throws Exception 异常
     */
    String toPayAsWeb(AlipayConfig alipay, TradeVo trade) throws Exception;

    /**
     * 查询配置
     * @return AlipayConfig
     */
    @Cacheable(key = "'1'")
    AlipayConfig find();

    /**
     * 更新配置
     * @param alipayConfig 支付宝配置
     * @return AlipayConfig
     */
    @CachePut(key = "'1'")
    AlipayConfig update(AlipayConfig alipayConfig);
}
