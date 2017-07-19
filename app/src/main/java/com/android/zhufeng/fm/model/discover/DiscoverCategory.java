package com.android.zhufeng.fm.model.discover;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/29
 * Email: vhly@163.com
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 发现的大分类
 */
public class DiscoverCategory implements Comparable<DiscoverCategory>{
    /*
      "id": 3,
      "name": "book",
      "title": "有声小说",
      "isChecked": false,
      "orderNum": 1,
      "coverPath": "http://fdfs.xmcdn.com/group8/M07/17/A0/wKgDYFVxM-fQsucFAAAFRHjovdg062.png",
      "selectedSwitch": false,
      "isFinished": true,
      "contentType": "album"
     */

    private int id;
    private String name;
    private String title;
    private boolean checked;
    private int orderNum;
    private String coverPath;
    private boolean selectedSwitch;
    private boolean finished;
    private String contentType;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {

            id = json.getInt("id");
            name = json.optString("name");
            title = json.getString("title");
            checked = json.optBoolean("isChecked");
            orderNum = json.getInt("orderNum");
            coverPath = json.getString("coverPath");
            selectedSwitch = json.optBoolean("selectedSwitch");
            finished = json.optBoolean("isFinished");
            contentType = json.optString("contentType");
        }
    }

    @Override
    public int compareTo(DiscoverCategory another) {
        int ret = 0;

        if (another != null) {
            ret = orderNum - another.orderNum;
        }

        return ret;
    }

    public boolean isChecked() {
        return checked;
    }

    public String getContentType() {
        return contentType;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public boolean isSelectedSwitch() {
        return selectedSwitch;
    }

    public String getTitle() {
        return title;
    }
}
