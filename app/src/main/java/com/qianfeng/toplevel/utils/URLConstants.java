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
   public static  final  String DETAILS_START="http://api.liwushuo.com/v2/posts_v2/";
    public static  final  String DETAILS_END="?show_baichuan=0";
//    这是攻略详情的头 尾
//    http://api.liwushuo.com/v2/posts_v2/1044314?show_baichuan=0
//    得到点击事件的攻略详情页

//    热门的url
    public static final String URL_HOT="http://api.liwushuo.com/v2/items?gender=1&limit=20&offset=0&generation=2";

//    这是第一栏广告的点击事件
    public static final String BANNER_START="http://api.liwushuo.com/v2/collections/";
    public static final String BANNER_END="/posts?limit=20&offset=01";

//    http://api.liwushuo.com/v2/collections/323/posts?limit=20&offset=01

    public static final String URL_SINGLE="http://api.liwushuo.com/v2/item_categories/tree";
//这是分类里面的那个单品的fragment的url


    public static final String  STRATEGY_TOP="http://api.liwushuo.com/v2/columns?limit=20&offset=0";
//  分类里面的攻略fragment上面栏目的url
//    http://api.liwushuo.com/v2/columns?limit=20&offset=0

    public static final String STRATEGY_BOTTOM="http://api.liwushuo.com/v2/channel_groups/all";
//    分类里面的攻略fragment和，品类，风格，以及对象的url
//   http://api.liwushuo.com/v2/channel_groups/all
}
