package com.android.zhufeng.fm.tasks;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/28
 * Email: vhly@163.com
 */

/**
 * TaskCallback 异步任务执行成功之后，由 onPostExecute 来回调
 */
public interface TaskCallback {

    /**
     * 当异步任务执行成功，进行回调
     * @param result
     */
    void onTaskFinished(TaskResult result);

}
