package com.xuhong.xmqttlib.listener;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * 项目名： xMQTT-master
 * 包名名： com.xuhong.xmqttlib.listener
 * 创建者: xuhong  GitHub-> https://github.com/xuhongv
 * 创建时间: 2017/12/22.
 * 描述：TOMO
 */

public interface xMQTTClientListener {

    //成功连接服务器回调
    void onSuccessConnect(IMqttToken asyncActionToken);

    //失败连接服务器回调
    void onFailureConnect(IMqttToken asyncActionToken, Throwable exception);

    //成功订阅主题回调
    void onSuccessSubTopic(String topic);

    //成功接收到服务器的信息回调
    void MessageArrived(String topic, MqttMessage message);


}
