package com.android.zhufeng.fm.model.discover;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/30
 * Email: vhly@163.com
 */
public class Sprint {

    private int id;

    private int orderNum;

    private String title;

    private String subtitle;

    private String coverPath;

    private String contentType;

    private String url;

    private String sharePic;

    private boolean enableShare;

    private long contentUpdatedAt;

    private boolean isHot;

    private boolean isExternalUrl;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {

            id = json.getInt("id");
            orderNum = json.getInt("orderNum");
            title = json.getString("title");
            subtitle = json.getString("subtitle");
            coverPath = json.getString("coverPath");
            contentType = json.getString("contentType");
            url = json.getString("url");
            sharePic = json.getString("sharePic");
            enableShare = json.getBoolean("enableShare");
            contentUpdatedAt = json.getLong("contentUpdatedAt");
            isHot = json.optBoolean("isHot");
            isExternalUrl = json.optBoolean("isExternalUrl");
        }
    }

    public boolean isExternalUrl() {
        return isExternalUrl;
    }

    public boolean isHot() {
        return isHot;
    }

    public String getContentType() {
        return contentType;
    }

    public long getContentUpdatedAt() {
        return contentUpdatedAt;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public boolean isEnableShare() {
        return enableShare;
    }

    public int getId() {
        return id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getSharePic() {
        return sharePic;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
