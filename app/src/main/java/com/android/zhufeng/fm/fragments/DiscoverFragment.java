package com.android.zhufeng.fm.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.zhufeng.fm.Constants;
import com.android.zhufeng.fm.R;
import com.android.zhufeng.fm.adapters.CommonFragmentPagerAdapter;
import com.android.zhufeng.fm.fragments.discover.DiscoverAnchorFragment;
import com.android.zhufeng.fm.fragments.discover.DiscoverCategoryFragment;
import com.android.zhufeng.fm.fragments.discover.DiscoverLiveFragment;
import com.android.zhufeng.fm.fragments.discover.DiscoverRankingFragment;
import com.android.zhufeng.fm.fragments.discover.DiscoverRecommendFragment;
import com.android.zhufeng.fm.model.discover.DiscoverTab;
import com.android.zhufeng.fm.parsers.DataParser;
import com.android.zhufeng.fm.tasks.TaskCallback;
import com.android.zhufeng.fm.tasks.TaskResult;
import com.android.zhufeng.fm.tasks.impl.DiscoverTabTask;

import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment implements View.OnClickListener, TabLayout.OnTabSelectedListener, TaskCallback {

    /**
     * 放子栏目的
     */
    private ViewPager pager;

    /**
     * 子栏目的Tab指示器，使用了 design support包的内容
     */
    private TabLayout tabBar;

    /**
     * Tab 信息
     */
    private List<DiscoverTab> tabTitles;

    private List<Fragment> subFragments;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabTitles = new LinkedList<DiscoverTab>();

        subFragments = new LinkedList<Fragment>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_discover, container, false);

        View btnSearch = ret.findViewById(R.id.discover_title_search);

        if (btnSearch != null) {
            btnSearch.setOnClickListener(this);
        }

        ////////////////////////////////

        tabBar = (TabLayout) ret.findViewById(R.id.discover_tab_bar);

        // TODO 因为Tab的设置是从网络来的，需要动态添加的

        tabBar.setOnTabSelectedListener(this);

        /////////////////////////////////////////

        pager = (ViewPager) ret.findViewById(R.id.discover_pager);

        // 设置Adapter
        // TODO 由于Tab动态设置的，所以 ViewPager Adapter 也需要动态设置

        // ViewPager 在滑动页面的时候，添加监听
        // 监听由 TabLayoutOnPageChangeListener 来完成
        // 从而实现 ViewPager滚动，上面的TabLayout跟随滚动Tab
        pager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabBar)
        );

        // 加载Tabs
        DiscoverTabTask task = new DiscoverTabTask(this);

        task.execute();

        return ret;
    }

    ///////////////////////////////////////////

    @Override
    public void onClick(View v) {

    }

    ///////////////////////////////////////////
    // TabLayout 的 Tab 选中的接口，使用规则 和 ActionBar Tab 一样

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        pager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        // TODO 进行刷新
    }

    //////////////////////////////////////////

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {

            int taskId = result.taskId;

            Object data = result.data;

            if (taskId == Constants.TASK_DISCOVER_TABS) {

                if (data != null) {
                    // 解析JSON

                    if (data instanceof JSONObject) {
                        JSONObject jsonObject = (JSONObject) data;
                        tabTitles = DataParser.parseDiscoverTabs(jsonObject);
                        updateTabs();
                    }

                } else {
                    // TODO 设置默认数据
                }

            }

        }
    }

    private void updateTabs() {
        if (tabTitles != null) {

            for (DiscoverTab tabTitle : tabTitles) {

                TabLayout.Tab tab = tabBar.newTab();

                tab.setText(tabTitle.getTitle());

                tabBar.addTab(tab);

                // 根据内容类型，来设置指定的Fragment
                String type = tabTitle.getContentType();

                if ("recommend".equals(type)) {
                    subFragments.add(new DiscoverRecommendFragment());
                } else if ("category".equals(type)) {
                    subFragments.add(new DiscoverCategoryFragment());
                } else if ("live".equals(type)) {
                    subFragments.add(new DiscoverLiveFragment());
                } else if ("ranking".equals(type)) {
                    subFragments.add(new DiscoverRankingFragment());
                } else if ("anchor".equals(type)) {
                    subFragments.add(new DiscoverAnchorFragment());
                }
            }

            CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(
                            getChildFragmentManager(),
                            subFragments);
            pager.setAdapter(adapter);

        }
    }

}
