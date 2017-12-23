package com.xuhong.xmqttlib.state;

/**
 * 项目名： xMQTT-master
 * 包名名： com.xuhong.xmqttlib.state
 * 创建者: xuhong  GitHub-> https://github.com/xuhongv
 * 创建时间: 2017/12/23.
 * 描述：TOMO
 */

public enum xMQTTCode {
    /**
     * 连接服务器失败
     */
    CONNECT_FAIL,
    /**
     * 发布消息失败
     */
    PUBLISH_FAIL,

    /**
     * 订阅消息失败
     */
    SUB_FAIL,

    /**
     * 连接服务器成功
     */
    CONNECTED_SUCCEED,
    /**
     * 发布消息成功
     */
    PUBLISH_SUCCEED,
    /**
     * 订阅成功
     */
    SUB_SUCCEED,
    /**
     * 断开连接失败
     */
    DISCONNECTED_FAIL,
    /**
     * 断开连接成功
     */
    DISCONNECTED_SUCCEED
}
