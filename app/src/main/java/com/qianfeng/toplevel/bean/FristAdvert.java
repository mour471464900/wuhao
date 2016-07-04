package com.qianfeng.toplevel.bean;

import java.util.List;

/**
 * Created by hao on 2016/6/28.
 */
public class FristAdvert {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FristAdvert{" +
                "data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * ad_monitors : []
         * channel : all
         * id : 638
         * image_url : http://img01.liwushuo.com/image/160628/i3tbqy0fi.jpg-w720
         * order : 1001
         * status : 0
         * target_id : 1044304
         * target_type : url
         * target_url : liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1044304
         * type : post
         * webp_url : http://img01.liwushuo.com/image/160628/i3tbqy0fi.jpg?imageView2/2/w/720/q/85/format/webp
         */

        private List<BannersBean> banners;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class BannersBean {
            private String channel;
            private int id;
            private String image_url;
            private int order;
            private int status;
            private int target_id;
            private String target_type;
            private String target_url;
            private String type;
            private String webp_url;
            private List<?> ad_monitors;

            @Override
            public String toString() {
                return "BannersBean{" +
                        "channel='" + channel + '\'' +
                        ", id=" + id +
                        ", image_url='" + image_url + '\'' +
                        ", order=" + order +
                        ", status=" + status +
                        ", target_id=" + target_id +
                        ", target_type='" + target_type + '\'' +
                        ", target_url='" + target_url + '\'' +
                        ", type='" + type + '\'' +
                        ", webp_url='" + webp_url + '\'' +
                        ", ad_monitors=" + ad_monitors +
                        '}';
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
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

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getTarget_id() {
                return target_id;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public String getTarget_type() {
                return target_type;
            }

            public void setTarget_type(String target_type) {
                this.target_type = target_type;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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
