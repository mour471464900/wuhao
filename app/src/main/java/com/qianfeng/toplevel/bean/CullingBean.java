package com.qianfeng.toplevel.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by my on 2016/6/29.
 * 这是精选的实体类
 * 也是分类里面，的攻略分页的实体类
 */
public class CullingBean implements Serializable {

    private DataBean data;

    @Override
    public String toString() {
        return "CullingBean{" +
                "data=" + data +
                '}';
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements  Serializable{
        /**
         * next_url : http://api.liwushuo.com/v2/channels/101/items?generation=2&gender=1&limit=20&offset=20
         */

        private PagingBean paging;
        /**
         * ad_monitors : []
         * content_type : 1
         * content_url : http://www.liwushuo.com/posts/1044283/content
         * cover_image_url : http://img02.liwushuo.com/image/160628/xhofp4aoc.jpg-w720
         * cover_webp_url : http://img02.liwushuo.com/image/160628/xhofp4aoc.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1467201720
         *              1468339200
         * editor_id : 1058
         * feature_list : []
         * hidden_cover_image : false
         * id : 1044283
         * labels : []
         * liked : false
         * likes_count : 6040
         * published_at : 1467158400
         *                1468395790
         * share_msg : 生活中总是会有这样那样的困难和遗憾，让我们以为似乎生活就是这么的艰难。于是我们就会吹捧着“世界以痛吻我，我却报之以歌”的积极言论来安慰和鼓励自己要善良勇敢地面对世界。其实没有必要，生活也不是那些言论吹捧的那么不堪，至少，我们还有超甜蜜的美食陪伴我们啊！就算再不开心的时候，吃到如此香甜可口的零食，还是会心情变好一些嗷~小礼君觉得嘛，生活怎样完全取决于自己，眼界开阔些，心胸宽广些，会看见不一样的风景哦~就像那句话，“你对世界越功利，世界对你越神秘”。
         * short_title : 甜蜜零食
         * status : 0
         * template :
         * title : 第40期 | 会摔倒也总有甜蜜的鼓励，这就是生活啊！
         * type : post
         * updated_at : 1467104244
         * url : http://www.liwushuo.com/posts/1044283
         */

        private List<ItemsBean> items;



        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class PagingBean  implements Serializable{
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ItemsBean implements Serializable{
            private int content_type;
            private String content_url;
            private String cover_image_url;
            private String cover_webp_url;
            private long created_at;
            private int editor_id;
            private boolean hidden_cover_image;
            private int id;
            private boolean liked;
            private int likes_count;
            private int published_at;
            private String share_msg;
            private String short_title;
            private int status;
            private String template;
            private String title;
            private String type;
            private int updated_at;
            private String url;
            private List<?> ad_monitors;
            private List<?> feature_list;
            private List<?> labels;

            @Override
            public String toString() {
                return "ItemsBean{" +
                        "content_type=" + content_type +
                        ", content_url='" + content_url + '\'' +
                        ", cover_image_url='" + cover_image_url + '\'' +
                        ", cover_webp_url='" + cover_webp_url + '\'' +
                        ", created_at=" + created_at +
                        ", editor_id=" + editor_id +
                        ", hidden_cover_image=" + hidden_cover_image +
                        ", id=" + id +
                        ", liked=" + liked +
                        ", likes_count=" + likes_count +
                        ", published_at=" + published_at +
                        ", share_msg='" + share_msg + '\'' +
                        ", short_title='" + short_title + '\'' +
                        ", status=" + status +
                        ", template='" + template + '\'' +
                        ", title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", updated_at=" + updated_at +
                        ", url='" + url + '\'' +
                        ", ad_monitors=" + ad_monitors +
                        ", feature_list=" + feature_list +
                        ", labels=" + labels +
                        '}';
            }

            public int getContent_type() {
                return content_type;
            }

            public void setContent_type(int content_type) {
                this.content_type = content_type;
            }

            public String getContent_url() {
                return content_url;
            }

            public void setContent_url(String content_url) {
                this.content_url = content_url;
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

            public long getCreated_at() {
                return created_at;
            }

            public void setCreated_at(long created_at) {
                this.created_at = created_at;
            }

            public int getEditor_id() {
                return editor_id;
            }

            public void setEditor_id(int editor_id) {
                this.editor_id = editor_id;
            }

            public boolean isHidden_cover_image() {
                return hidden_cover_image;
            }

            public void setHidden_cover_image(boolean hidden_cover_image) {
                this.hidden_cover_image = hidden_cover_image;
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

            public int getPublished_at() {
                return published_at;
            }

            public void setPublished_at(int published_at) {
                this.published_at = published_at;
            }

            public String getShare_msg() {
                return share_msg;
            }

            public void setShare_msg(String share_msg) {
                this.share_msg = share_msg;
            }

            public String getShort_title() {
                return short_title;
            }

            public void setShort_title(String short_title) {
                this.short_title = short_title;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }

            public List<?> getFeature_list() {
                return feature_list;
            }

            public void setFeature_list(List<?> feature_list) {
                this.feature_list = feature_list;
            }

            public List<?> getLabels() {
                return labels;
            }

            public void setLabels(List<?> labels) {
                this.labels = labels;
            }
        }
    }
}
