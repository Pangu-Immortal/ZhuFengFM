package com.android.zhufeng.fm.tasks.impl;

import com.android.zhufeng.fm.Constants;
import com.android.zhufeng.fm.client.ClientDiscoverAPI;
import com.android.zhufeng.fm.tasks.BaseTask;
import com.android.zhufeng.fm.tasks.TaskCallback;
import com.android.zhufeng.fm.tasks.TaskResult;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/31
 * Email: vhly@163.com
 */

/**
 * 获取 发现 －》推荐部分的网络数据
 */
public class DiscoverRecommendTask extends BaseTask {

    public DiscoverRecommendTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret = new TaskResult();

        ret.taskId = Constants.TASK_DISCOVER_RECOMMEND;

        String str = ClientDiscoverAPI.getDiscoverRecommends();

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
