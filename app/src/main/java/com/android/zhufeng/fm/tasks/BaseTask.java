package com.android.zhufeng.fm.tasks;

import android.os.AsyncTask;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/28
 * Email: vhly@163.com
 */

/**
 * BaseTask 抽象的异步任务
 */
public abstract class BaseTask extends AsyncTask<String, Integer, TaskResult> {

    private TaskCallback callback;

    public BaseTask(TaskCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPostExecute(TaskResult taskResult) {
        if (callback != null) {
            callback.onTaskFinished(taskResult);
        }
    }
}
