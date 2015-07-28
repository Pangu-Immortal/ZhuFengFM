package com.zhufengfm.qihao.zhufengfm.tasks;

import android.os.AsyncTask;

/**
 * Created by Administrator on 2015/7/28.
 */

/**
 * BaseTask 抽象的异步任务
 */
public abstract class BaseTask extends AsyncTask<String, Integer, TaskResult> {


    private TaskCallback callback;

    public BaseTask(TaskCallback callback){
        this.callback = callback;
    }


    @Override
    protected void onPostExecute(TaskResult taskResult) {
        if (callback != null) {
            callback.onTaskFinished(taskResult);
        }
    }
}
