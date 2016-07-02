package com.qianfeng.toplevel.utils;

/**
 * Created by my on 2016/6/20.
 */
public class URLConstants {

    public static final String URL_BASE = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2";
    //    分类的数据
    public static final String URL_FIRSTCB = "http://api.liwushuo.com/v2/banners";
    //       第一栏广告的数据
    public static final String URL_SECONDCB = "http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=1";
//          第二栏广告的数据

    public static final String URL_CULLING = "http://api.liwushuo.com/v2/channels/101/items?gender=1&limit=20&offset=0&generation=2";
    //    精选的条目
    public static final String URL_START = "http://api.liwushuo.com/v2/channels/";
//    这是海淘以及其他界面的url的头
    public static final String URL_END = "/items?gender=1&limit=20&offset=0&generation=2";
//  这是海淘以及其他界面的url的尾部
//
}
