package com.qianfeng.toplevel.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hao on 2016/7/8.
 *  分类里面的攻略fragment和，品类，风格，以及对象的url
 */
public class StrategyBean  implements Serializable{

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * channels : [{"cover_image_url":"http://img03.liwushuo.com/image/160624/hbd7w1sf4.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160414/kwzqtscoa.png-pw144","id":111,"items_count":1150,"name":"礼物","order":10,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/duk8guejk.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/58kdnthsn.png-pw144","id":112,"items_count":597,"name":"家居","order":9,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/axk8i901f.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160414/6eutomjeo.png-pw144","id":110,"items_count":691,"name":"穿搭","order":8,"status":0},{"cover_image_url":"http://img02.liwushuo.com/image/160624/ayjeuhtji.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160414/abuv6vssc.png-pw144","id":2,"items_count":569,"name":"美物","order":7,"status":0},{"cover_image_url":"http://img02.liwushuo.com/image/160624/x5vlfqcn4.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/5al9xhwg1.png-pw144","id":116,"items_count":196,"name":"饰品","order":6,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/1kx5seb62.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/58vv7n29y.png-pw144","id":118,"items_count":494,"name":"美食","order":5,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/otqmww3av.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/5dgflkj6g.png-pw144","id":117,"items_count":198,"name":"鞋包","order":5,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/38778o4e0.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/fb7e1012t.png-pw144","id":113,"items_count":523,"name":"美护","order":4,"status":0},{"cover_image_url":"http://img02.liwushuo.com/image/160624/s69ub7yiq.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/59hgqd1x8.png-pw144","id":121,"items_count":214,"name":"数码","order":4,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/2ky6x596q.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/u4r2a9q72.png-pw144","id":3,"items_count":89,"name":"手工","order":3,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/d1xtmp1ig.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/i69bjp6bm.png-pw144","id":119,"items_count":51,"name":"母婴","order":0,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160624/y3aqzhu9v.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/t9t9hzntc.png-pw144","id":122,"items_count":66,"name":"爱动漫","order":0,"status":0},{"cover_image_url":"http://img02.liwushuo.com/image/160624/ym66pnx98.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/3ziqypz1f.png-pw144","id":123,"items_count":31,"name":"爱运动","order":0,"status":0},{"cover_image_url":"http://img03.liwushuo.com/image/160606/ad06sqrix.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/6pdxbaqz2.png-pw144","id":124,"items_count":22,"name":"爱读书","order":0,"status":0},{"cover_image_url":"http://img01.liwushuo.com/image/160624/xxvb0a8aj.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/voku467wc.png-pw144","id":129,"items_count":157,"name":"海淘","order":0,"status":0}]
         * id : 5
         * name : 品类
         * order : 6
         * status : 0
         */

        private List<ChannelGroupsBean> channel_groups;

        public List<ChannelGroupsBean> getChannel_groups() {
            return channel_groups;
        }

        public void setChannel_groups(List<ChannelGroupsBean> channel_groups) {
            this.channel_groups = channel_groups;
        }

        public static class ChannelGroupsBean implements Serializable {
            private int id;
            private String name;
            /**
             * cover_image_url : http://img03.liwushuo.com/image/160624/hbd7w1sf4.png
             * group_id : 5
             * icon_url : http://img01.liwushuo.com/image/160414/kwzqtscoa.png-pw144
             * id : 111
             * items_count : 1150
             * name : 礼物
             * order : 10
             * status : 0
             */

            private List<ChannelsBean> channels;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ChannelsBean> getChannels() {
                return channels;
            }

            public void setChannels(List<ChannelsBean> channels) {
                this.channels = channels;
            }

            public static class ChannelsBean implements Serializable {
                private String cover_image_url;
                private int group_id;
                private int id;
                private int items_count;
                private String name;

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getItems_count() {
                    return items_count;
                }

                public void setItems_count(int items_count) {
                    this.items_count = items_count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
