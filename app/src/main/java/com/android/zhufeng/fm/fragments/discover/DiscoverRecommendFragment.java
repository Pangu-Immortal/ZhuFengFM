package com.android.zhufeng.fm.fragments.discover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.android.zhufeng.fm.Constants;
import com.android.zhufeng.fm.R;
import com.android.zhufeng.fm.adapters.DiscoverRecommendAdapter;
import com.android.zhufeng.fm.model.DiscoverRecommend;
import com.android.zhufeng.fm.parsers.DataParser;
import com.android.zhufeng.fm.tasks.TaskCallback;
import com.android.zhufeng.fm.tasks.TaskResult;
import com.android.zhufeng.fm.tasks.impl.DiscoverRecommendTask;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/29
 * Email: vhly@163.com
 */
public class DiscoverRecommendFragment extends Fragment implements AdapterView.OnItemClickListener, TaskCallback {

    private DiscoverRecommendAdapter adapter;

    public DiscoverRecommendFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_discover_recommend, container, false);

        ListView listView = (ListView) ret.findViewById(R.id.discover_recommend_list);

        if (listView != null) {

            // TODO 设置实际数据的 Adapter
            /////
            adapter = new DiscoverRecommendAdapter(getActivity());
            listView.setAdapter(adapter);
        }

        return ret;
    }

    @Override
    public void onResume() {
        super.onResume();

        DiscoverRecommendTask task =
                new DiscoverRecommendTask(this);
        task.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentActivity activity = getActivity();

        if (parent instanceof ListView) {
            ListView listView = (ListView) parent;
            int headerViewsCount = listView.getHeaderViewsCount();

            // 调整因为 HeaderView导致的偏移
            position -= headerViewsCount;

            int footerViewsCount = listView.getFooterViewsCount();

            if (footerViewsCount > 0) {
                // 数据的个数
                if (position >= 30) {
                    // 点的不是数据，因为
                } else {

                }
            } else {
                // 点到数据上了
            }


        }

        Toast.makeText(activity, "点击 " + position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {

            int taskId = result.taskId;

            Object data = result.data;

            if(taskId == Constants.TASK_DISCOVER_RECOMMEND){

                if (data != null) {
                    if (data instanceof JSONObject){
                        JSONObject json = (JSONObject) data;
                        DiscoverRecommend discoverRecommend = DataParser.parseDiscoverRecommend(json);

                        adapter.setRecommend(discoverRecommend);

                    }
                }

            }

        }
    }
}
