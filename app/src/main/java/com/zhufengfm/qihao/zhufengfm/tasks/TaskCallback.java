package com.zhufengfm.qihao.zhufengfm.tasks;

/**
 * Created by qihao on 2015/7/28.
 */

/**
 * TaskCallback 异步任务执行成功之后，由onPostExecute来回掉
 */
public interface TaskCallback {
    /**
     * 当异步任务执行成功 进行回掉
     * @param result
     */
    void onFinished(TaskResult result);
}
