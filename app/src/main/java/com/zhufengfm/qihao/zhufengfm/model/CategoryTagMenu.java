package com.zhufengfm.qihao.zhufengfm.model;

/**
 * Created by Administrator on 2015/7/28.
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
     *
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

                if (tagList == null) {
                    tagList = new LinkedList<String>();
                } else {
                    tagList.clear();
                }

                for (int i = 0; i < len; i++) {
                    tagList.add(array.getString(i));
                }
            }

        }
    }


    ////////////////////////////////////////////

    // getter & setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    //////////////////////////////////////////////////
}
