package com.android.zhufeng.fm.model;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/28
 * Email: vhly@163.com
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 分类与Tag集合，一个分类包含了多个Tag
 */
public class CategoryTagMenu {

    private int id;

    private String name;

    private String title;

    private String intro;
    /**
     * 对应 is_display
     */
    private boolean display;

    private String coverPath;

    private List<String> tagList;


    /**
     * 所有实体类都会包含这个名称的方法，用于解析JSON
     * @param jsonObject
     */
    public void parseJSON(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            id = jsonObject.getInt("id");
            name = jsonObject.getString("name");
            // 必须存在的内容
            title = jsonObject.getString("title");
            // 可选内容
            intro = jsonObject.optString("intro");
            display = jsonObject.getBoolean("is_display");

            coverPath = jsonObject.getString("cover_path");

            JSONArray array = jsonObject.optJSONArray("tag_list");

            if (array != null) {
                int len = array.length();

                tagList = new LinkedList<String>();

                for (int i = 0; i < len; i++) {

                    tagList.add(array.getString(i));

                }
            }

        }
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public boolean isDisplay() {
        return display;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public List<String> getTagList() {
        return tagList;
    }
}
