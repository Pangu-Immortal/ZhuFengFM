package com.android.zhufeng.fm.model.discover;

import android.util.Log;

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

//    private int orderNum;

    private String title;

    private String subtitle;

    private String coverPath;

    private String contentType;

    private String url;

    private String sharePic;

    private boolean enableShare;

    private long contentUpdatedAt;

//    private boolean isHot;
//
//    private boolean isExternalUrl;

    public void parseJSON(JSONObject json) throws JSONException {
        /*
        {
    "id": 140,
    "title": "商城",
    "subtitle": "特价优惠中",
    "coverPath": "http://fdfs.xmcdn.com/group7/M08/9C/6E/wKgDWldsp1HwZJRSAABMGZ-IIaY612.jpg",
    "contentType": "html5.mall",
    "url": "https://wap.koudaitong.com/v2/showcase/homepage?alias=nq65b1t2",
    "sharePic": "",
    "enableShare": false,
    "isExternalUrl": true,
    "contentUpdatedAt": 0
}
         */
        if (json != null) {
            Log.e("Sprint", json.toString());
            id = json.getInt("id");
            //orderNum = json.getInt("orderNum");
            title = json.getString("title");
            subtitle = json.getString("subtitle");
            coverPath = json.getString("coverPath");
            contentType = json.getString("contentType");
            url = json.getString("url");
            sharePic = json.getString("sharePic");
            enableShare = json.getBoolean("enableShare");
            contentUpdatedAt = json.getLong("contentUpdatedAt");
//            isHot = json.optBoolean("isHot");
//            isExternalUrl = json.optBoolean("isExternalUrl");
        }
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
