package com.xuhong.xmqttlib.xMLogUtils;

import android.util.Log;

/**
 * 项目名： xMQTT-master
 * 包名名： com.xuhong.xmqttlib.xMLogUtils
 * 创建者: xuhong  GitHub-> https://github.com/xuhongv
 * 创建时间: 2017/12/22.
 * 描述：TOMO
 */

public class xMLogUtils {


    private static boolean isLog = true;

    private static final String TAG = "xMQTTLogs";

    public static void i(String tag, String msg) {
        if (isLog) {
            Log.i(tag, msg);
        }
    }

    public static void i(String msg) {
        if (isLog) {
            Log.i(TAG, msg);
        }
    }


    public static void d(String tag, String msg) {
        if (isLog) {
            Log.d(tag, msg);
        }
    }

    public static void d(String msg) {
        if (isLog) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isLog) {
            Log.e(tag, msg);
        }
    }

    public static void e(String msg) {
        if (isLog) {
            Log.e(TAG, msg);
        }
    }

    public static void setOpenLog(boolean isLog) {
        xMLogUtils.isLog = isLog;
    }
}
