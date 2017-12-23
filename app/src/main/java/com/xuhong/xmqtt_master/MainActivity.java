package com.xuhong.xmqtt_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xuhong.xmqttlib.api.xMAndroidClient;
import com.xuhong.xmqttlib.listener.xMQTTClientListener;
import com.xuhong.xmqttlib.state.xMQTTCode;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity implements xMQTTClientListener {

    private xMAndroidClient client;

    private static final String TAG = "xMQTTSample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        client = new xMAndroidClient.Builder(this)
                .setServerUri("120.79.82.119")
                .setClientID("xuhong")
                .setPort(1883)
                .setReConnect(true)
                .creat();
        client.startConnect();
        client.setClientListener(this);

    }

    public void btnSub1(View view) {
        client.subTopic("/hello");
    }

    public void btnSub2(View view) {
        client.subTopic("/hi", 1);
    }

    public void btnPushMess1(View view) {
        client.publishMessage("/8266in", "你好8266！");
    }


    @Override
    public void onFailureMQTT(xMQTTCode code, String errorMessage) {

    }

    @Override
    public void onSuccessMQTT(xMQTTCode code, String topic, String message) {
        Log.e(TAG, "onSuccessMQTT:" + code);
    }

    @Override
    public void MessageArrived(String topic, MqttMessage message) {

    }











}
