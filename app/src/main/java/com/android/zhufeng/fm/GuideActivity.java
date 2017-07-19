package com.android.zhufeng.fm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import com.android.zhufeng.fm.adapters.GuideAdapter;
import com.android.zhufeng.fm.util.PackageUtil;

import java.util.ArrayList;

/**
 * 教程页
 */
public class GuideActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);

        ViewPager pager = (ViewPager) findViewById(R.id.guide_view_pager);
        if (pager != null) {

            ArrayList<Integer> images = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                // TODO 换成更好看的图片
                images.add(R.mipmap.ic_launcher);
            }
            GuideAdapter adapter = new GuideAdapter(this, images);

            // 设置Adapter的 内部按钮的点击事件

            adapter.setGoOnClickListener(this);

            pager.setAdapter(adapter);

        }

        /////////////////////////////////////
        // 设置SharedPreferences ，只要教程出来，就设置

        SharedPreferences sp =
                getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);

        String versionName = PackageUtil.getPackageVersionName(this);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString(Constants.SP_KEY_GUIDE_LAST_SHOW_VER, versionName);

        editor.commit();


    }

    @Override
    public void onClick(View v) {
        startMain();
    }

    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        startMain();
    }
}
