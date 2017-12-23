package com.xuhong.xmqttlib.listener;

import com.xuhong.xmqttlib.state.xMQTTCode;

import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * 项目名： xMQTT-master
 * 包名名： com.xuhong.xmqttlib.listener
 * 创建者: xuhong  GitHub-> https://github.com/xuhongv
 * 创建时间: 2017/12/22.
 * 描述：TOMO
 */

public interface xMQTTClientListener {


    //所有失败回调
    void onFailureMQTT(xMQTTCode code, String errorMesage);

    //所有成功回调--> 包括成功连接服务器，成功订阅主题，成功推送消息
    void onSuccessMQTT(xMQTTCode code, String topic, String message);

    //成功接收到服务器的信息回调
    void MessageArrived(String topic, MqttMessage message);


}
