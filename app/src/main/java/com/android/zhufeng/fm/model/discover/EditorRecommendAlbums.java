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
public class EditorRecommendAlbums {

    private String title;

    private boolean hasMore;

    private List<AlbumRecommend> list;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            title = json.getString("title");
            hasMore = json.optBoolean("hasMore");
            JSONArray array = json.optJSONArray("list");
            if (array != null) {
                int len = array.length();
                if (len > 0) {
                    list = new LinkedList<AlbumRecommend>();
                    for (int i = 0; i < len; i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        AlbumRecommend album = new AlbumRecommend();
                        album.parseJSON(jsonObject);
                        list.add(album);
                    }
                }
            }
        }
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public List<AlbumRecommend> getList() {
        return list;
    }

    public String getTitle() {
        return title;
    }
}
