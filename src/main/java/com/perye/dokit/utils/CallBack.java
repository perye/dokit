package com.perye.dokit.utils;

/**
 * 针对某些初始化方法，在SpringContextHolder 初始化前时，<br>
 * 可提交一个 提交回调任务。<br>
 * 在SpringContextHolder 初始化后，进行回调使用
 */

public interface CallBack {
    /**
     * 回调执行方法
     */
    void executor();

    /**
     * 本回调任务名称
     */
    default String getCallBackName() {
        return Thread.currentThread().getId() + ":" + this.getClass().getName();
    }
}
