package com.android.zhufeng.fm.util;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/31
 * Email: vhly@163.com
 */

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 未捕获异常 处理器
 */
public class UncaughtExceptionHandlerImpl implements Thread.UncaughtExceptionHandler {
    /**
     * 获取文件路径用的
     */
    private Context context;

    public UncaughtExceptionHandlerImpl(Context context) {
        this.context = context;
    }

    /**
     * 当某一个线程发生了未捕获异常的时候，回调这个方法
     * @param thread
     * @param ex
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // TODO 将异常信息，保存到文件中，下次启动，获取，并且上传服务器
        if (context != null) {

            File filesDir = context.getFilesDir();

            String state = Environment.getExternalStorageState();

            if(state.equals(Environment.MEDIA_MOUNTED)){
                filesDir = context.getExternalFilesDir(null);
            }

            File logFile = new File(filesDir, "app.log");

            FileWriter fw = null;

            PrintWriter pw = null;

            try {
                fw = new FileWriter(logFile);
                pw = new PrintWriter(fw);

                ex.printStackTrace(pw);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                StreamUtil.close(pw);
                StreamUtil.close(fw);
            }

        }

        System.exit(1);

    }
}
