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
public class HotRecommends {
    private String title;

    private List<HotRecommend> list;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            title = json.getString("title");
            JSONArray array = json.optJSONArray("list");
            if (array != null) {
                int len = array.length();
                if (len > 0) {
                    list = new LinkedList<HotRecommend>();

                    for (int i = 0; i < len; i++) {
                        JSONObject object = array.getJSONObject(i);
                        HotRecommend recommend = new HotRecommend();
                        recommend.parseJSON(object);
                        list.add(recommend);
                    }

                }
            }
        }
    }

    public List<HotRecommend> getList() {
        return list;
    }

    public String getTitle() {
        return title;
    }
}
