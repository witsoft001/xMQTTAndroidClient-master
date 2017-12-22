package com.xuhong.xmqttlib.api;

/**
 * 项目名： xMQTT-master
 * 包名名： com.xuhong.xmqttlib.api
 * 创建者: xuhong  GitHub-> https://github.com/xuhongv
 * 创建时间: 2017/12/22.
 * 描述：服务器配置信息
 */

public class TargetInf {


    //服务器地址
    private String serverUri = "tcp://iot.eclipse.org";

    //端口
    private int port = 1883;


    private TargetInf() {
    }

    public String getServerUri() {
        return serverUri;
    }

    public int getPort() {
        return port;
    }


    public static class Builder {

        private TargetInf mTargetInf;

        public Builder() {
            mTargetInf = new TargetInf();
        }

        public TargetInf creat() {
            return mTargetInf;
        }

        public Builder setServerUri(String uri) {
            mTargetInf.serverUri = uri;
            return this;
        }

        public Builder setPort(int port) {
            mTargetInf.port = port;
            return this;
        }

    }


}
