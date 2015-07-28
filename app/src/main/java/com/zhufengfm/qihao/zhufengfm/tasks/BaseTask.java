package com.zhufengfm.qihao.zhufengfm.tasks;

/**
 * Created by qihao on 2015/7/28.
 */

import android.os.AsyncTask;

/**
 *BaseTask抽象的异步任务
 */
public abstract class BaseTask extends AsyncTask<String,Integer,TaskResult> {
    private TaskCallback callback;

    public BaseTask(TaskCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPostExecute(TaskResult taskResult) {
        if (callback!=null){
            callback.onFinished(taskResult);

        }
    }
}
