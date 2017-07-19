package com.android.zhufeng.fm.data;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/29
 * Email: vhly@163.com
 */

import com.android.zhufeng.fm.model.discover.DiscoverCategory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 公共数据存储区
 */
public class DataStore {
    private static DataStore ourInstance;

    public static DataStore getInstance() {

        if (ourInstance == null) {
            ourInstance = new DataStore();
        }

        return ourInstance;
    }

    public static void release(){
        ourInstance = null;
    }


    private List<DiscoverCategory> discoverCategories;


    private DataStore() {
        discoverCategories = new LinkedList<DiscoverCategory>();
    }

    public void setDiscoverCategories(List<DiscoverCategory> categories){
        if(categories != null && !categories.isEmpty()){
            discoverCategories.clear();
            discoverCategories.addAll(categories);
            Collections.sort(discoverCategories);
        }
    }

    /**
     * 获取已经加载过的分类列表
     * @return
     */
    public List<DiscoverCategory> getDiscoverCategories() {
        return discoverCategories;
    }
}
