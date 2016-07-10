package com.qianfeng.toplevel.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hao on 2016/7/8.
 * 分类里面的攻略fragment上面栏目
 */
public class ColumnBean implements Serializable {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean  implements Serializable{
        /**
         * author : 灰姑娘
         * banner_image_url : http://img03.liwushuo.com/image/160608/qojypq4pe.jpg-w300
         * banner_webp_url : http://img03.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp
         * category : 美护
         * cover_image_url : http://img01.liwushuo.com/image/160630/lxqy971sn.jpg-w720
         * cover_webp_url : http://img01.liwushuo.com/image/160630/lxqy971sn.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1462501946
         * description : 好看就行。——玛丽莲·赫本·千颂伊
         * id : 23
         * order : 0
         * post_published_at : 1467860400
         * status : 0
         * subtitle : 更新至第42期
         * title : 靠脸吃饭
         * updated_at : 1467968200
         */

        private List<ColumnsBean> columns;

        public List<ColumnsBean> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnsBean> columns) {
            this.columns = columns;
        }

        public static class ColumnsBean implements Serializable{
            private String author;
            private String banner_image_url;
            private int id;
            private String subtitle;
            private String title;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
