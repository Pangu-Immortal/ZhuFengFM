package com.zhufengfm.qihao.zhufengfm;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.zhufengfm.qihao.zhufengfm.model.CategoryTagMenu;
import com.zhufengfm.qihao.zhufengfm.parsers.DataParser;
import com.zhufengfm.qihao.zhufengfm.tasks.TaskCallback;
import com.zhufengfm.qihao.zhufengfm.tasks.TaskResult;
import com.zhufengfm.qihao.zhufengfm.tasks.impl.CategoryTagMenuTask;

import org.json.JSONObject;

import java.util.List;

public class SplashActivity extends FragmentActivity implements TaskCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 启动扉页 没有标题

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);


    }


    @Override
    protected void onResume() {
        super.onResume();

        // 启动扉页，进行网络检查与网络请求，下载数据
        // 最终显示主界面

        CategoryTagMenuTask task = new CategoryTagMenuTask(this);


    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int taskId = result.taskId;

            Object data = result.data;

            if (taskId == TaskConstants.TASK_CATEGORY_TAG_MENU) {
                // TODO 获取 category_tag_menu 的数据

                if (data != null) {
                    if (data instanceof JSONObject) {
                        JSONObject json = (JSONObject) data;

                        List<CategoryTagMenu> categoryTagMenuList = DataParser.parseCategoryTagMenuResult(json);

                        // TODO 存储 CategoryTagMenu


                    }
                }

                // TODO 处理之后，判断教程的启动


            }


        }
    }
}
