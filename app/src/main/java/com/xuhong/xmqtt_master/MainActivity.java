package com.xuhong.xmqtt_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xuhong.xmqttlib.api.xMAndroidClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        xMAndroidClient client = new xMAndroidClient.Builder(this)
                .setServerUri("120.79.82.119")
                .setClientID("xuhong")
                .setPort(1883)
                .setReConnect(true)
                .creat();
        client.startConnect();
        client.subTopic("what");
    }
}
