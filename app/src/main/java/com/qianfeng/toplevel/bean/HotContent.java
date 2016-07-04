package com.qianfeng.toplevel.bean;

import java.util.List;

/**
 * Created by hao on 2016/7/3.
 * 这是热门的里面的商品购买界面的实体类
 *
 */
public class HotContent {

    /**
     * authentic : null
     * brand_id : null
     * brand_order : null
     * category_id : 6
     * comments_count : 44
     * cover_image_url : http://img02.liwushuo.com/image/150820/ulxc1vf2u_w.jpg-w720
     * cover_webp_url : http://img02.liwushuo.com/image/150820/ulxc1vf2u_w.jpg?imageView2/2/w/720/q/85/format/webp
     * created_at : 1420530735
     * description : 如此清新的马卡龙色，轻盈的机身，饱满的音色，用这样的耳机听歌根本停不下来好吗！
     * detail_html : <!doctype html>
     <html>
     <head>
     <meta charset="UTF-8">
     <meta name="renderer" content="webkit">
     <meta name="format-detection" content="telephone=no">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="apple-mobile-web-app-capable" content="yes">
     <meta name="apple-mobile-web-app-status-bar-style" content="black">
     <meta id="vp" name="viewport" content="width=device-width, user-scalable=no,maximum-scale=1.0,initial-scale=1">
     <title>商品详情</title>
     <link rel="stylesheet" type="text/css" href="http://static.liwushuo.com/static/web/apps/liwushuo/css/item_52ca5da.css">
     <script>
     var API_ENDPOINT = "http://api.liwushuo.com";
     var ITEM_ID = "1008503";
     </script>

     </head>
     <body>
     <div class="detail-container">
     <p><img src="http://gw.alicdn.com/imgextra/i3/1900879942/TB2M426bpXXXXb2XpXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i3/1900879942/TB25a.PbpXXXXbyXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i3/1900879942/TB2Ko3KbpXXXXczXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i4/1900879942/TB2D5AGbpXXXXbXXpXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i2/1900879942/TB2oU.LbpXXXXcgXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i4/1900879942/TB2QVZSbpXXXXXMXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i4/1900879942/TB2L_ILbpXXXXcpXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i1/1900879942/TB2llISbpXXXXXUXpXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i1/1900879942/TB2RHoIbpXXXXX2XpXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i4/1900879942/TB2yOUNbpXXXXbCXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i1/1900879942/TB2tNsNbpXXXXbLXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i2/1900879942/TB22W.SbpXXXXXKXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i3/1900879942/TB2mGUQbpXXXXaOXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i4/1900879942/TB2Pb.LbpXXXXcIXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /><img src="http://gw.alicdn.com/imgextra/i1/1900879942/TB2mK3QbpXXXXazXXXXXXXXXXXX-1900879942.jpg_620x10000q60.jpg" alt="" /></p>
     </div>

     <div class="recommond-container">
     <div class="cross">
     <span class="cross-line"></span>
     <span class="cross-text">你可能也喜欢</span>
     </div>
     <div id="itemList"></div>
     </div>

     <script>
     window.onload = function () {
     var imgs = document.getElementsByTagName('img');
     for (var i = 0, l = imgs.length; i < l; i++) {
     (function (i) {
     var width = imgs[i].naturalWidth;
     var height = imgs[i].naturalHeight;
     if (width < 2 || height < 2) {
     imgs[i].style.display = "none";
     }
     })(i);
     }
     }
     </script>
     <script type="text/javascript">var require,define;!function(e){function r(e,r){function t(){clearTimeout(a)}if(!(e in u)){u[e]=!0;var i=document.createElement("script");if(r){var a=setTimeout(r,require.timeout);i.onerror=function(){clearTimeout(a),r()},"onload"in i?i.onload=t:i.onreadystatechange=function(){("loaded"==this.readyState||"complete"==this.readyState)&&t()}}return i.type="text/javascript",i.src=e,n.appendChild(i),i}}function t(e,t,n){var a=i[e]||(i[e]=[]);a.push(t);var o,u=s[e]||{},f=u.pkg;o=f?c[f].url:u.url||e,r(o,n&&function(){n(e)})}var n=document.getElementsByTagName("head")[0],i={},a={},o={},u={},s={},c={};define=function(e,r){a[e]=r;var t=i[e];if(t){for(var n=0,o=t.length;o>n;n++)t[n]();delete i[e]}},require=function(e){if(e&&e.splice)return require.async.apply(this,arguments);e=require.alias(e);var r=o[e];if(r)return r.exports;var t=a[e];if(!t)throw"[ModJS] Cannot find module `"+e+"`";r=o[e]={exports:{}};var n="function"==typeof t?t.apply(r,[require,r.exports,r]):t;return n&&(r.exports=n),r.exports},require.async=function(r,n,i){function o(e){for(var r=0,n=e.length;n>r;r++){var c=e[r];if(c in a){var f=s[c];f&&"deps"in f&&o(f.deps)}else if(!(c in l)){l[c]=!0,p++,t(c,u,i);var f=s[c];f&&"deps"in f&&o(f.deps)}}}function u(){if(0==p--){for(var t=[],i=0,a=r.length;a>i;i++)t[i]=require(r[i]);n&&n.apply(e,t)}}"string"==typeof r&&(r=[r]);for(var c=0,f=r.length;f>c;c++)r[c]=require.alias(r[c]);var l={},p=0;o(r),u()},require.resourceMap=function(e){var r,t;t=e.res;for(r in t)t.hasOwnProperty(r)&&(s[r]=t[r]);t=e.pkg;for(r in t)t.hasOwnProperty(r)&&(c[r]=t[r])},require.loadJs=function(e){r(e)},require.loadCss=function(e){if(e.content){var r=document.createElement("style");r.type="text/css",r.styleSheet?r.styleSheet.cssText=e.content:r.innerHTML=e.content,n.appendChild(r)}else if(e.url){var t=document.createElement("link");t.href=e.url,t.rel="stylesheet",t.type="text/css",n.appendChild(t)}},require.alias=function(e){return e},require.timeout=5e3}(this);</script>
     <script type="text/javascript" src="http://static.liwushuo.com/static/web/components/jquery/jquery_d107a7d.js"></script>
     <script type="text/javascript" src="http://static.liwushuo.com/static/web/pkg/lib_27487aa.js"></script>
     <script type="text/javascript" src="http://static.liwushuo.com/static/web/scripts/util/request_5010967.js"></script>
     <script type="text/javascript" src="http://static.liwushuo.com/static/web/apps/liwushuo/js/gift_ec54b2f.js"></script>
     <script type="text/javascript" src="http://static.liwushuo.com/static/web/apps/liwushuo/js/item/detail_06a406d.js"></script>


     <script>
     var $ = require('web/components/jquery/jquery.js');
     $(function() {
     $('.detail-container').find('*').each(function() {
     this.style = '';
     });
     });
     </script>


     <script>
     require("liwushuo/item/detail");
     </script>

     </body>
     </html>
     * editor_id : 1024
     * favorited : false
     * favorites_count : 7101
     * id : 1008503
     * image_urls : ["http://img03.taobaocdn.com/bao/uploaded/i3/TB1ANFyGVXXXXa4XFXXXXXXXXXX_!!0-item_pic.jpg_480x480q60.jpg","http://img02.taobaocdn.com/imgextra/i2/1900879942/TB2dg8wbFXXXXbJXXXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img01.taobaocdn.com/imgextra/i1/1900879942/TB24o0BbFXXXXXsXXXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img01.taobaocdn.com/imgextra/i1/1900879942/TB2JgJrbFXXXXboXpXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img02.taobaocdn.com/imgextra/i2/1900879942/TB2w_XtbFXXXXXKXpXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img02.liwushuo.com/image/150106/vz7x30md9_w.jpg-w720","http://img03.liwushuo.com/image/150820/ulxc1vf2u_w.jpg-w720"]
     * liked : false
     * likes_count : 7101
     * name : EARSCI·可爱马卡龙耳机
     * post_ids : []
     * price : 89.00
     * purchase_id : 36608653720
     * purchase_status : 1
     * purchase_type : 1
     * purchase_url : http://s.click.taobao.com/t?sche=liwushuo&e=m%3D2%26s%3Dc2ZNIvVYUzkcQipKwQzePOeEDrYVVa64XoO8tOebS%2BdRAdhuF14FMV2OSScXP6CTMMgx22UI05atgmtnxDX9deVMA5qBABUs5mPg1WiM1P5OS0OzHKBZzW1e2y4p13L5og5Ew63SjO%2F9wWM5M0Fl%2B%2Bm0YLyAQYk5USwYGlubnWs%3D
     * shares_count : 239
     * source : {"button_title":"去淘宝购买","name":"淘宝","page_title":"商品详情","type":"taobao"}
     * subcategory_id : 40
     * updated_at : 1420530735
     * url : http://www.liwushuo.com/items/1008503
     * webp_urls : ["http://img03.taobaocdn.com/bao/uploaded/i3/TB1ANFyGVXXXXa4XFXXXXXXXXXX_!!0-item_pic.jpg_480x480q60.jpg","http://img02.taobaocdn.com/imgextra/i2/1900879942/TB2dg8wbFXXXXbJXXXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img01.taobaocdn.com/imgextra/i1/1900879942/TB24o0BbFXXXXXsXXXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img01.taobaocdn.com/imgextra/i1/1900879942/TB2JgJrbFXXXXboXpXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img02.taobaocdn.com/imgextra/i2/1900879942/TB2w_XtbFXXXXXKXpXXXXXXXXXX-1900879942.jpg_480x480q60.jpg","http://img02.liwushuo.com/image/150106/vz7x30md9_w.jpg?imageView2/2/w/720/q/85/format/webp","http://img03.liwushuo.com/image/150820/ulxc1vf2u_w.jpg?imageView2/2/w/720/q/85/format/webp"]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int category_id;
        private int comments_count;
        private String cover_image_url;
        private String cover_webp_url;
        private String description;
        private String detail_html;
        private boolean favorited;
        private int favorites_count;
        private int id;
        private boolean liked;
        private int likes_count;
        private String name;
        private String price;
        private String purchase_id;
        private String purchase_url;
        private int shares_count;
        /**
         * button_title : 去淘宝购买
         * name : 淘宝
         * page_title : 商品详情
         * type : taobao
         */

        private SourceBean source;
        private int subcategory_id;
        private String url;
        private List<String> image_urls;
        private List<?> post_ids;
        private List<String> webp_urls;

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getCover_image_url() {
            return cover_image_url;
        }

        public void setCover_image_url(String cover_image_url) {
            this.cover_image_url = cover_image_url;
        }

        public String getCover_webp_url() {
            return cover_webp_url;
        }

        public void setCover_webp_url(String cover_webp_url) {
            this.cover_webp_url = cover_webp_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDetail_html() {
            return detail_html;
        }

        public void setDetail_html(String detail_html) {
            this.detail_html = detail_html;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public int getFavorites_count() {
            return favorites_count;
        }

        public void setFavorites_count(int favorites_count) {
            this.favorites_count = favorites_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPurchase_id() {
            return purchase_id;
        }

        public void setPurchase_id(String purchase_id) {
            this.purchase_id = purchase_id;
        }

        public String getPurchase_url() {
            return purchase_url;
        }

        public void setPurchase_url(String purchase_url) {
            this.purchase_url = purchase_url;
        }

        public int getShares_count() {
            return shares_count;
        }

        public void setShares_count(int shares_count) {
            this.shares_count = shares_count;
        }

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public int getSubcategory_id() {
            return subcategory_id;
        }

        public void setSubcategory_id(int subcategory_id) {
            this.subcategory_id = subcategory_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getImage_urls() {
            return image_urls;
        }

        public void setImage_urls(List<String> image_urls) {
            this.image_urls = image_urls;
        }

        public List<?> getPost_ids() {
            return post_ids;
        }

        public void setPost_ids(List<?> post_ids) {
            this.post_ids = post_ids;
        }

        public List<String> getWebp_urls() {
            return webp_urls;
        }

        public void setWebp_urls(List<String> webp_urls) {
            this.webp_urls = webp_urls;
        }

        public static class SourceBean {
            private String button_title;
            private String name;
            private String page_title;
            private String type;

            public String getButton_title() {
                return button_title;
            }

            public void setButton_title(String button_title) {
                this.button_title = button_title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPage_title() {
                return page_title;
            }

            public void setPage_title(String page_title) {
                this.page_title = page_title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
