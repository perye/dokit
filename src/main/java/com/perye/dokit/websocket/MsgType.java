package com.perye.dokit.websocket;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
public enum MsgType {
    /** 连接 */
    CONNECT,
    /** 关闭 */
    CLOSE,
    /** 信息 */
    INFO,
    /** 错误 */
    ERROR
}
