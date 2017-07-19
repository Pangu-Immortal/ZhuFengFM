package com.android.zhufeng.fm.client;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/28
 * Email: vhly@163.com
 */

import java.io.UnsupportedEncodingException;

/**
 * 发现部分的API接口调用
 */
public final class ClientDiscoverAPI {

    public static final String SERVER_MOBILE = "http://mobile.ximalaya.com";

    private ClientDiscoverAPI() {

    }

    ////////////////////////////////////

    /**
     * 获取发现界面Tab的定义<br/>
     * 调用接口: http://mobile.ximalaya.com/mobile/discovery/v1/tabs?device=android
     * 不需要参数
     *
     * @return
     */
    public static String getDiscoverTabs() {
        String ret = null;
        // RESTful
        String url = SERVER_MOBILE + "/mobile/discovery/v1/tabs?device=android";

        byte[] bytes = HttpUtil.doGet(url);

        if (bytes != null) {
            try {
                ret = new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(bytes);
            }
        }

        return ret;
    }

    /**
     * 获取分类Tag菜单<br/>
     * 调用接口: http://mobile.ximalaya.com/m/category_tag_menu<br/>
     * 请求方法: GET<br/>
     *
     * @param type 可选 默认是 user
     * @return
     */
    public static String getCategoryTagMenu(String type) {
        String ret = null;
        String url = null;
        StringBuilder sb = new StringBuilder();
        sb.append(SERVER_MOBILE);
        sb.append("/m/category_tag_menu");
        if (type != null) {
            sb.append("?type=").append(type);
            sb.append("&device=android");
        }
        url = sb.toString();
        sb = null;

        byte[] data = HttpUtil.doGet(url);

        if (data != null) {
            try {
                ret = new String(data, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(data);
            }
        }

        return ret;
    }

    /**
     * 获取发现的分类<br/>
     * 调用的接口:<br/>
     * http://mobile.ximalaya.com/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2<br/>
     *
     * @return
     */
    public static String getDiscoverCategories() {
        String ret = null;

        String url =
                SERVER_MOBILE + "/mobile/discovery/v1/categories"
                        + "?device=android"
                        + "&picVersion=10"
                        + "&scale=2";

        byte[] bytes = HttpUtil.doGet(url);

        if (bytes != null) {

            try {
                ret = new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(bytes);
            }

        }


        return ret;
    }

    /**
     * 获取 发现 －》 推荐的内容<br/>
     * 调用接口: http://mobile.ximalaya.com/mobile/discovery/v1/recommends
     * 参数: <br/>
     * <ul>
     * <li>channel=and-f6</li>
     * <li>device=android</li>
     * <li>includeActivity=true</li>
     * <li>includeSpecial=true</li>
     * <li>scale=2</li>
     * <li>version=4.1.7.1</li>
     * </ul>
     *
     * @return
     */
    public static String getDiscoverRecommends() {
        String ret = null;

        String url =
                SERVER_MOBILE + "/mobile/discovery/v1/recommends"
                + "?channel=and-f6"
                + "&device=android"
                + "&includeActivity=true"
                + "&includeSpecial=true"
                + "&scale=2"
                + "&version=4.1.7.1"
                ;

        byte[] bytes = HttpUtil.doGet(url);

        if (bytes != null) {

            try {
                ret = new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(bytes);
            }

        }

        return ret;
    }
}
