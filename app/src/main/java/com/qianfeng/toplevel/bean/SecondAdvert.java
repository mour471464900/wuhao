package com.qianfeng.toplevel.bean;

import java.util.List;

/**
 * Created by hao on 2016/6/28.
 */
public class SecondAdvert {

    private DataBean data;

    @Override
    public String toString() {
        return "SecondAdvert{" +
                "data=" + data +
                '}';
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ad_monitors : []
         * id : 43
         * image_url : http://img01.liwushuo.com/image/160517/8xb020ll2.jpg-w720
         * target_url : liwushuo:///page?type=dailylucky
         * webp_url : http://img01.liwushuo.com/image/160517/8xb020ll2.jpg?imageView2/2/w/720/q/85/format/webp
         */

        private List<SecondaryBannersBean> secondary_banners;

        @Override
        public String toString() {
            return "DataBean{" +
                    "secondary_banners=" + secondary_banners +
                    '}';
        }

        public List<SecondaryBannersBean> getSecondary_banners() {
            return secondary_banners;
        }

        public void setSecondary_banners(List<SecondaryBannersBean> secondary_banners) {
            this.secondary_banners = secondary_banners;
        }

        public static class SecondaryBannersBean {
            private int id;
            private String image_url;
            private String target_url;
            private String webp_url;
            private List<?> ad_monitors;

            @Override
            public String toString() {
                return "SecondaryBannersBean{" +
                        "id=" + id +
                        ", image_url='" + image_url + '\'' +
                        ", target_url='" + target_url + '\'' +
                        ", webp_url='" + webp_url + '\'' +
                        ", ad_monitors=" + ad_monitors +
                        '}';
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }
        }
    }
}
