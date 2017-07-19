package com.android.zhufeng.fm.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.zhufeng.fm.R;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/29
 * Email: vhly@163.com
 */

/**
 * 教程页的ViewPager 的适配器
 */
public class GuideAdapter extends PagerAdapter {

    private List<Integer> images;

    private Context context;

    private View.OnClickListener goOnClickListener;

    public GuideAdapter(Context context, List<Integer> images) {
        this.context = context;
        this.images = images;
    }

    public void setGoOnClickListener(View.OnClickListener goOnClickListener) {
        this.goOnClickListener = goOnClickListener;
    }

    @Override
    public int getCount() {
        int ret = 0;

        if (images != null) {
            ret = images.size();
        }

        return ret;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        // 对于FragmentPagerAdapter, o 是 Fragment
        // view 与 o 的判断就不能够直接 view == o
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret = null;

        int resId = images.get(position);

        if(position == images.size() - 1){
            // TODO 最后一个，设置布局，添加按钮
            FrameLayout frameLayout = new FrameLayout(context);

            ImageView imageView = new ImageView(context);

            imageView.setImageResource(resId);

            ViewGroup.LayoutParams lp1 =
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                    );

            imageView.setLayoutParams(lp1);

            frameLayout.addView(imageView);

            ////////////////////////////////////////

            Button btnGo = new Button(context);

            btnGo.setText(R.string.guide_start_main);

            // 第三个参数指定 控件在 FrameLayout 的哪个位置
            FrameLayout.LayoutParams lp2 =
                    new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM
                    );

            // TODO 需要进行记性适配
            lp2.bottomMargin = 80;

            btnGo.setLayoutParams(lp2);

            frameLayout.addView(btnGo);

            btnGo.setOnClickListener(goOnClickListener);
            // 代码创建的 Button 是没有ID的，通过 Tag可以
            // 进行按钮的区分；
            btnGo.setTag("Go");

            ret = frameLayout;

        }else{
            // TODO 直接是图片
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(resId);
            ret = imageView;
        }

        container.addView(ret);

        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object instanceof View){
            container.removeView((View)object);
        }
    }
}
