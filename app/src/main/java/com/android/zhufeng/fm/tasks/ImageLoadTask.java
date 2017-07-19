package com.android.zhufeng.fm.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.android.zhufeng.fm.cache.FileCache;
import com.android.zhufeng.fm.client.HttpUtil;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/31
 * Email: vhly@163.com
 */

/**
 * 下载图片
 */
public class ImageLoadTask extends AsyncTask<String, Integer, Bitmap> {

    /**
     * 当前任务要设置的目标
     */
    private ImageView imageView;
    private String url;

    public ImageLoadTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap ret = null;

        if (params != null && params.length > 0) {
            url = params[0];

            byte[] data = FileCache.getInstance().loadFile(url);

            if (data == null) {
                data = HttpUtil.doGet(url);
                // 存文件
                FileCache.getInstance().saveFile(url, data);
            }

            // 1. 文件缓存
            // 2. 图片二次采样
            // 3. 内存缓存

            if (data != null) {
                // TODO 保存文件
                // TODO 转换图片 bitmap
                ret = BitmapFactory.decodeByteArray(data, 0, data.length);

                data = null;
            }
        }

        return ret;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            if (imageView != null) {
                Object tag = imageView.getTag();
                if (tag != null) {
                    if (tag instanceof String) {
                        String str = (String) tag;

                        if (str.equals(url)) {
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                }

            }
        }
    }
}
