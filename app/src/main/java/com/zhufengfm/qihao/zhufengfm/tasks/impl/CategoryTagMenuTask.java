package com.zhufengfm.qihao.zhufengfm.tasks.impl;

import com.longfeisun.app.zhufengfm.TaskConstants;
import com.longfeisun.app.zhufengfm.clients.ClientDiscoverAPI;
import com.longfeisun.app.zhufengfm.tasks.BaseTask;
import com.longfeisun.app.zhufengfm.tasks.TaskCallback;
import com.longfeisun.app.zhufengfm.tasks.TaskResult;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * category_tag_menu </br>
 * 这个任务支持一个参数，参数的内容，是 type 的值，目前 只可以写 user
 */
public class CategoryTagMenuTask extends BaseTask {

    public CategoryTagMenuTask(TaskCallback callback) {
        super(callback);

    }

    @Override
    protected TaskResult doInBackground(String... params) {

        // TaskResult 必须创建 用来描述任务类型 以及数据

        TaskResult ret = new TaskResult();

        ret.taskId = TaskConstants.TASK_CATEGORY_TAG_MENU;

        ////////////////////////////////////////////


        String type = null;

        if (params != null && params.length > 0) {
            type = params[0];
        }

        String str = ClientDiscoverAPI.getCategoryTagMenu(type);

        if (str != null) {
            try {
                ret.data = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
}
