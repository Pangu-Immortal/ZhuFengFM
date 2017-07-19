package com.android.zhufeng.fm.tasks;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/28
 * Email: vhly@163.com
 */

/**
 * 异步任务结果的抽象的描述，用于区分结果属于哪一个Task
 */
public class TaskResult {
    /**
     * 异步任务的标示
     */
    public int taskId;

    /**
     * 异步任务内部获取的数据
     */
    public Object data;
}
