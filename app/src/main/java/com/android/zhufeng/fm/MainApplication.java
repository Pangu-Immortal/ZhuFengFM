package com.android.zhufeng.fm;

import android.app.Application;
import com.android.zhufeng.fm.cache.FileCache;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/31
 * Email: vhly@163.com
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FileCache.createInstance(getApplicationContext());

    }
}
