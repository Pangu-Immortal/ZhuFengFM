package com.android.zhufeng.fm.model.discover;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/29
 * Email: vhly@163.com
 */
public class DiscoverTab {

    /**
     * 显示在 DiscoverFragment 上面的 Tab 标题
     */
    private String title;

    /**
     * 内容的描述，代码判断的时候用的。
     */
    private String contentType;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {

            title = json.getString("title");

            contentType = json.getString("contentType");

        }
    }

    public String getContentType() {
        return contentType;
    }

    public String getTitle() {
        return title;
    }
}
