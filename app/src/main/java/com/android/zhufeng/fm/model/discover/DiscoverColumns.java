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
public class DiscoverColumns {
    private String title;

    private List<Sprint> list;

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {

            title = json.getString("title");

            JSONArray array = json.optJSONArray("list");

            if (array != null) {

                int len = array.length();

                if (len > 0) {

                    list = new LinkedList<Sprint>();

                    for (int i = 0; i < len; i++) {
                        JSONObject jsonObject = array.getJSONObject(i);

                        Sprint sp = new Sprint();
                        sp.parseJSON(jsonObject);
                        list.add(sp);

                    }
                }

            }

        }
    }

    public List<Sprint> getList() {
        return list;
    }

    public String getTitle() {
        return title;
    }
}
