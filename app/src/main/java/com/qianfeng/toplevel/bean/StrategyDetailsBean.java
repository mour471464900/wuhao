package com.qianfeng.toplevel.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hao on 2016/7/2.
 * 这是攻略详情的页面
 */
public class StrategyDetailsBean implements Serializable {


    /**
     * ad_monitors : null
     * column : {"banner_image_url":"http://img01.liwushuo.com/image/160612/86tdgefue.jpg-w300","category":"家居","cover_image_url":"http://img01.liwushuo.com/image/160630/l6p3dtlua.jpg-w720","created_at":1465722215,"description":"既为理想生活日寻一物，也要每天空出8分钟认真生活，还懂得探究每一个家的细枝末节与美好。","id":49,"order":0,"status":0,"subtitle":"","title":"LIFE研究所","updated_at":1467366669}
     * comments_count : 13
     * content_html :
     * content_type : 1
     * content_url : http://www.liwushuo.com/posts/1044314/content
     * cover_image_url : http://img03.liwushuo.com/image/160701/dd5tc5632.jpg-w720
     * cover_webp_url : http://img03.liwushuo.com/image/160701/dd5tc5632.jpg?imageView2/2/w/720/q/85/format/webp
     * created_at : 1467428400
     * editor_id : 1145
     * feature_list : []
     * id : 1044314
     * item_ad_monitors : {"1060985":[],"1060986":[],"1060987":[],"1060988":[],"1060989":[],"1060990":[],"1060991":[],"1060992":[],"1060993":[]}
     * label_ids : []
     * liked : false
     * likes_count : 9907
     * published_at : 1467428400
     * share_msg : 分享自@礼物说—90 后生活方式指南
     * shares_count : 542
     * short_title :
     * status : 0
     * template :
     * title : 第26期｜8分钟生活，一碗高颜值的炸酱面
     * updated_at : 1467366647
     * url : http://www.liwushuo.com/posts/1044314
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * banner_image_url : http://img01.liwushuo.com/image/160612/86tdgefue.jpg-w300
         * category : 家居
         * cover_image_url : http://img01.liwushuo.com/image/160630/l6p3dtlua.jpg-w720
         * created_at : 1465722215
         * description : 既为理想生活日寻一物，也要每天空出8分钟认真生活，还懂得探究每一个家的细枝末节与美好。
         * id : 49
         * order : 0
         * status : 0
         * subtitle :
         * title : LIFE研究所
         * updated_at : 1467366669
         */

        private ColumnBean column;
        private int comments_count;
        private String content_html;
        private int content_type;
        private String content_url;
        private String cover_image_url;
        private String cover_webp_url;
        private int created_at;
        private int editor_id;
        private int id;
        private boolean liked;
        private int likes_count;
        private int published_at;
        private String share_msg;
        private int shares_count;
        private String short_title;
        private int status;
        private String template;
        private String title;
        private int updated_at;
        private String url;
        private List<?> feature_list;
        private List<?> label_ids;

        public ColumnBean getColumn() {
            return column;
        }

        public void setColumn(ColumnBean column) {
            this.column = column;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getContent_html() {
            return content_html;
        }

        public void setContent_html(String content_html) {
            this.content_html = content_html;
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

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getEditor_id() {
            return editor_id;
        }

        public void setEditor_id(int editor_id) {
            this.editor_id = editor_id;
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

        public int getShares_count() {
            return shares_count;
        }

        public void setShares_count(int shares_count) {
            this.shares_count = shares_count;
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

        public List<?> getFeature_list() {
            return feature_list;
        }

        public void setFeature_list(List<?> feature_list) {
            this.feature_list = feature_list;
        }

        public List<?> getLabel_ids() {
            return label_ids;
        }

        public void setLabel_ids(List<?> label_ids) {
            this.label_ids = label_ids;
        }

        public static class ColumnBean {
            private String banner_image_url;
            private String category;
            private String cover_image_url;
            private int created_at;
            private String description;
            private int id;
            private String title;
            private int updated_at;

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
