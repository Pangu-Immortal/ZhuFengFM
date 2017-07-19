package com.android.zhufeng.fm;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/30
 * Email: vhly@163.com
 */

/**
 * 基础的Activity
 */
public class BaseActivity extends FragmentActivity {

    private TextView txtTitle;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        // TODO 进行公共的，一些控件的内容初始化

        // 只要调用了 super.setContentView 就可以findViewById了

        txtTitle = (TextView) findViewById(R.id.common_header_title);

    }

    /**
     * Activity设置标题的方法
     * @param title
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        if (txtTitle != null) {

            txtTitle.setText(title);

        }
    }

    /**
     * 获取 startActivity 之后，新的Activity 进入的动画<br/>
     * 默认时从右往左，如果定制不同的动画，重写这个方法即可。
     * @return
     */
    protected int getEnterAnimationId(){
        return R.anim.anim_slide_to_left;
    }

    /**
     * 启动Activity, 并且给启动de Activity 指定一个动画
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);

        overridePendingTransition(getEnterAnimationId(), 0);
    }

    protected int getExitAnimationId(){
        return R.anim.anim_drop_down;
    }

    @Override
    public void finish() {
        super.finish();

        int exitAnimationId = getExitAnimationId();

        if(exitAnimationId != 0) {

            overridePendingTransition(0, exitAnimationId);

        }
    }
}
