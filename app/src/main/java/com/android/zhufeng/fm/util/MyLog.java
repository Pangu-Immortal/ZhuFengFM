package com.android.zhufeng.fm.util;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/31
 * Email: vhly@163.com
 */

import android.util.Log;
import com.android.zhufeng.fm.BuildConfig;

/**
 * 封装Android Log 工具，能够增加日志的开关
 */
public final class MyLog {

    /**
     * 日志的开关，在Release(发布软件包)的时候 关闭日志
     */
    private static final boolean ON = BuildConfig.DEBUG;

    /**
     * 通过变量  true, false 进行日志输出控制
     */
    private static final boolean DEBUG = true;

    private static final boolean INFO = true;

    private MyLog() {

    }

    public static void d(String tag, String msg) {
        if (ON) {
            if (DEBUG) {
                Log.d(tag, msg);
            }
        }
    }

    public static void i(String tag, String msg) {
        if (ON) {
            if (INFO) {
                Log.i(tag, msg);
            }
        }
    }

}
