package com.android.zhufeng.fm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;

import com.android.zhufeng.fm.model.CategoryTagMenu;
import com.android.zhufeng.fm.parsers.DataParser;
import com.android.zhufeng.fm.tasks.TaskCallback;
import com.android.zhufeng.fm.tasks.TaskResult;
import com.android.zhufeng.fm.tasks.impl.CategoryTagMenuTask;
import com.android.zhufeng.fm.util.MyLog;
import com.android.zhufeng.fm.util.PackageUtil;
import com.android.zhufeng.fm.util.UncaughtExceptionHandlerImpl;

import org.json.JSONObject;

import java.util.List;

/**
 * 启动扉页，程序入口点
 */
public class SplashActivity extends FragmentActivity implements TaskCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 启动扉页没有标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        // 为当前线程，设置 未捕获异常 得处理器
        // 这个处理器就是用来保存未捕获异常得日志信息；
        UncaughtExceptionHandlerImpl handler = new UncaughtExceptionHandlerImpl(getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 启动扉页，进行网络检查与网络请求，下载数据
        // 最终显示主界面
        MyLog.d("Splash", "3 / 0");
        CategoryTagMenuTask task = new CategoryTagMenuTask(this);
        task.execute();
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int taskId = result.taskId;
            Object data = result.data;
            if (taskId == Constants.TASK_CATEGORY_TAG_MENU) {
                // TODO 获取 category_tag_menu的数据
                if (data != null) {
                    if (data instanceof JSONObject) {
                        JSONObject json = (JSONObject) data;
                        Log.d("SplashActivity", "json " + json.toString());
                        List<CategoryTagMenu> categoryTagMenuList = DataParser.parseCategoryTagMenuResult(json);
                        // TODO 存储CategoryTagMenu

                    }
                }
                // TODO 处理之后，判断教程的启动
                SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
                // 获取上一次的版本号
                final String lastVer = sp.getString(Constants.SP_KEY_GUIDE_LAST_SHOW_VER, null);
                final String versionName = PackageUtil.getPackageVersionName(this);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        //execute the task
                        Intent intent = null;
                        if (!versionName.equals(lastVer)) {
                            // TODO 显示教程
                            intent = new Intent(SplashActivity.this, GuideActivity.class);
                        } else {
                            // TODO 显示主界面
                            intent = new Intent(SplashActivity.this, MainActivity.class);
                        }
                        startActivity(intent);
                    }
                }, 3 * 1000);
                finish();
            }
        }
    }
}
