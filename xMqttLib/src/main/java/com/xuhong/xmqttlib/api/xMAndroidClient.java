package com.xuhong.xmqttlib.api;

import android.content.Context;

import com.xuhong.xmqttlib.listener.xMQTTClientListener;
import com.xuhong.xmqttlib.xMLogUtils.xMLogUtils;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.List;

/**
 * 项目名： xMQTT-master
 * 包名名： com.xuhong.xmqttlib.api
 * 创建者: xuhong  GitHub-> https://github.com/xuhongv
 * 创建时间: 2017/12/22.
 * 描述：TOMO
 */

public class xMAndroidClient implements IMqttActionListener, MqttCallback {


    //MqttAndroidClient
    private MqttAndroidClient mqttAndroidClient;

    private MqttConnectOptions mqttConnectOptions;


    //上下文
    private Context mContext;


    //本地的ID，设备唯一识别码
    private String clientID = null;
    //是否重连
    private boolean isAutoReConnect = true;
    //是否清除缓存
    private boolean isClearSession = true;
    //连接的用户名
    private String userName = null;
    //连接的用户名密码
    private char[] userPaw = null;
    //设置连接的超时时间
    private int connectionTimeout = 30;
    //设置心跳时间
    private int keepAliveTimes = 30;


    //服务器地址
    private String serverUri = "tcp://iot.eclipse.org";
    //端口
    private int port = 1883;


    //订阅质量, 默认1
    private int quality = 1;

    //成功连接了的标志
    private boolean isConnected = false;

    private xMAndroidClient(Context mContext) {
        this.mContext = mContext;
    }


    private xMQTTClientListener clientListener;


    @Override
    public void onSuccess(IMqttToken asyncActionToken) {
        isConnected = true;
        xMLogUtils.e("startConnect succeed");
    }

    @Override
    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
        xMLogUtils.e("onFailure:" + exception);
    }

    @Override
    public void connectionLost(Throwable cause) {
        xMLogUtils.e("connectionLost:" + cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        xMLogUtils.e("messageArrived topic:" + topic);
        xMLogUtils.e("messageArrived message:" + message.toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        xMLogUtils.e("deliveryComplete:" + token.toString());
    }

    /******************************************************下面是对外的方法******************************************************************************/


    /**
     * @return 是否成功连接服务器
     */
    public boolean startConnect() {

        mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(this.isAutoReConnect);
        mqttConnectOptions.setCleanSession(isClearSession);
        mqttConnectOptions.setUserName(userName);
        mqttConnectOptions.setPassword(userPaw);
        mqttConnectOptions.setConnectionTimeout(connectionTimeout);
        mqttConnectOptions.setKeepAliveInterval(keepAliveTimes);
        mqttAndroidClient = new MqttAndroidClient(mContext, "tcp://" + this.serverUri + ":" + port, this.clientID);

        try {
            xMLogUtils.e("startConnect ....");
            xMLogUtils.e("startConnect :" + mqttAndroidClient.getServerURI());
            mqttAndroidClient.connect(mqttConnectOptions, null, this);
            mqttAndroidClient.setCallback(this);
            return true;
        } catch (MqttException e) {
            e.printStackTrace();
            xMLogUtils.e("startConnect error:" + e);
            return false;
        }
    }

    /**
     * @return 是否成功断开连接
     */
    public boolean disConnect() {
        if (null != mqttAndroidClient) {
            try {
                mqttAndroidClient.disconnect();
                return true;
            } catch (MqttException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /**
     * 关闭连接，释放资源
     */
    public void close() {
        if (null != mqttAndroidClient) {
            mqttAndroidClient.close();
        }
    }


    /**
     * @param topic 订阅主题 , 质量为1
     * @return
     */
    public boolean subTopic(String topic) {
        if (null != mqttAndroidClient && isConnected) {
            xMLogUtils.d("mqttAndroidClient is not null !");
            try {
                mqttAndroidClient.subscribe(topic, 1);
                return true;
            } catch (MqttException e) {
                e.printStackTrace();
                return false;
            }
        }
        xMLogUtils.d("mqttAndroidClient is null or isConnected is disEnable!");
        return false;
    }

    /**
     * 执行上次的订阅质量
     *
     * @param topic 订阅主题
     * @return
     */
    public boolean subTopicLastQos(String topic) {
        if (null != mqttAndroidClient) {
            try {
                mqttAndroidClient.subscribe(topic, this.quality);
                return true;
            } catch (MqttException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /**
     * @param topic 订阅的主题
     * @param qos   质量
     * @return
     */
    public boolean subTopic(String topic, int qos) {
        if (null != mqttAndroidClient) {
            try {
                mqttAndroidClient.subscribe(topic, qos);
                this.quality = qos;
                return true;
            } catch (MqttException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    public void pushMessWithTopic(String topic, String message) {

        if (null != mqttAndroidClient) {
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setPayload(message.getBytes());
            try {
                mqttAndroidClient.publish(topic, mqttMessage);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param clientListener 设置回调事件
     */
    public void setClientListener(xMQTTClientListener clientListener) {
        if (clientListener != null) {
            this.clientListener = clientListener;
        }
    }

    /**
     * @return 获取ClientID
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * @return 是否设置重连
     */
    public boolean isAutoReConnect() {
        return isAutoReConnect;
    }


    public static class Builder {

        private xMAndroidClient mAndroidClient;

        private Context mContext;


        public Builder(Context mContext) {
            mAndroidClient = new xMAndroidClient(mContext);
        }


        public xMAndroidClient creat() {
            return mAndroidClient;
        }

        /**
         * @param clientID 安卓客户端ID
         * @return
         */
        public Builder setClientID(String clientID) {
            mAndroidClient.clientID = clientID;
            return this;
        }

        /**
         * @param uri 服务器地址，默认：tcp://iot.eclipse.org
         * @return
         */
        public Builder setServerUri(String uri) {
            mAndroidClient.serverUri = uri;
            return this;
        }

        /**
         * @param port 端口号，默认1883
         * @return
         */
        public Builder setPort(int port) {
            mAndroidClient.port = port;
            return this;
        }

        /**
         * @param isReConnect 设置重连，默认
         * @return
         */
        public Builder setReConnect(boolean isReConnect) {
            mAndroidClient.isAutoReConnect = isReConnect;
            return this;
        }

        /**
         * @param clientListener 设置监听
         * @return
         */
        public Builder setClientListener(xMQTTClientListener clientListener) {
            if (clientListener != null) {
                mAndroidClient.clientListener = clientListener;
            }
            return this;
        }
    }
}
