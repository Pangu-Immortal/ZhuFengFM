package com.android.zhufeng.fm.model.discover;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/30
 * Email: vhly@163.com
 */
public class HotRecommend {

    private String title; // "听新闻",
    private String contentType; // "album",
    private boolean isFinished; // false,
    private int categoryId; // 1,
    private int count; // 822,
    private boolean hasMore; // true,

    private List<AlbumRecommend> list;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {

            title = json.getString("title");
            contentType = json.getString("contentType");
            isFinished = json.getBoolean("isFinished");
            categoryId = json.getInt("categoryId");
            count = json.getInt("count");
            hasMore = json.getBoolean("hasMore");

            list = new LinkedList<AlbumRecommend>();

            JSONArray array = json.optJSONArray("list");

            if (array != null) {

                int len = array.length();

                for (int i = 0; i < len; i++) {

                    JSONObject jsonObject = array.getJSONObject(i);

                    AlbumRecommend recommend = new AlbumRecommend();

                    recommend.parseJSON(jsonObject);

                    list.add(recommend);

                }

            }


        }
    }

    public List<AlbumRecommend> getList() {
        return list;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getContentType() {
        return contentType;
    }

    public int getCount() {
        return count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String getTitle() {
        return title;
    }


}
