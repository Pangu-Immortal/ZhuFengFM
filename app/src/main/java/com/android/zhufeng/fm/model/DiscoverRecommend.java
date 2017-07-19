package com.android.zhufeng.fm.model;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/30
 * Email: vhly@163.com
 */

import com.android.zhufeng.fm.model.discover.DiscoverColumns;
import com.android.zhufeng.fm.model.discover.EditorRecommendAlbums;
import com.android.zhufeng.fm.model.discover.HotRecommends;
import com.android.zhufeng.fm.model.discover.SpecialColumn;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public class DiscoverRecommend {

    private EditorRecommendAlbums editorRecommendAlbums;

    private SpecialColumn specialColumn;

    private DiscoverColumns discoverColumns;

    private HotRecommends hotRecommends;

    public DiscoverColumns getDiscoverColumns() {
        return discoverColumns;
    }

    public EditorRecommendAlbums getEditorRecommendAlbums() {
        return editorRecommendAlbums;
    }

    public HotRecommends getHotRecommends() {
        return hotRecommends;
    }

    public SpecialColumn getSpecialColumn() {
        return specialColumn;
    }

    public void parseJSON(JSONObject json) throws JSONException {

        if (json != null) {

            JSONObject object =
                    json.getJSONObject("discoveryColumns");

            discoverColumns = new DiscoverColumns();
            discoverColumns.parseJSON(object);

            object = json.getJSONObject("editorRecommendAlbums");
            editorRecommendAlbums = new EditorRecommendAlbums();
            editorRecommendAlbums.parseJSON(object);

            object = json.getJSONObject("hotRecommends");
            hotRecommends = new HotRecommends();
            hotRecommends.parseJSON(object);

            object = json.getJSONObject("specialColumn");
            specialColumn = new SpecialColumn();
            specialColumn.parseJSON(object);


        }

    }
}
