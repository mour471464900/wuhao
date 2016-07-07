package com.qianfeng.toplevel.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hao on 2016/7/5.
 * 这是广告的跳转的实体类
 */
public class BannerListBean implements Serializable{


    /**
     * banner_image_url : http://img03.liwushuo.com/image/160704/tn3dbn56z.jpg-w300
     * banner_webp_url : http://img03.liwushuo.com/image/160704/tn3dbn56z.jpg?imageView2/2/w/300/q/85/format/webp
     * cover_image_url : http://img03.liwushuo.com/image/160704/kfjsawoi1.jpg-w720
     * cover_webp_url : http://img03.liwushuo.com/image/160704/kfjsawoi1.jpg?imageView2/2/w/720/q/85/format/webp
     * created_at : 1467620984
     * id : 323
     * paging : {"next_url":"http://api.liwushuo.com/v2/collections/323/posts?limit=20&offset=20"}
     * posts : [{"ad_monitors":[],"author":{"avatar_url":"http://img02.liwushuo.com/image/160615/8u74ha4ec.jpg","avatar_webp_url":null,"created_at":1465974279,"id":8,"nickname":"穿衣大队长"},"column":{"banner_image_url":"http://img01.liwushuo.com/image/160608/ygqtl238c.jpg-w300","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160630/uhwwy5j3l.jpg-w720","created_at":1462501669,"description":"做你的私人搭配师，每日搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":null,"status":0,"subtitle":"","title":"明天穿什么","updated_at":1467624516},"content_type":1,"content_url":"http://www.liwushuo.com/posts/1043393/content","cover_image_url":"http://img01.liwushuo.com/image/160519/u1jictrr5.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160519/u1jictrr5.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463702400,"editor_id":1134,"feature_list":[],"id":1043393,"label_ids":[],"liked":false,"likes_count":28074,"published_at":1463702400,"share_msg":"北鼻们，初夏刚刚来到，是不是已经按耐不住鸡冻的心情在网上订机票了？阳光沙滩如此美好，入手几件沙滩行头才是正经事。别琢磨身材够不够销魂，小礼君为你们奉上的泳装不仅仅是高白瘦专属的哦！快来用这些泳装妆点你的美好肉体，度过一个美好假日吧！","short_title":"","status":0,"template":"","title":"第16期 ｜ 阳光沙滩已备好，就差一件惊艳的泳衣了","type":"post","updated_at":1463454939,"url":"http://www.liwushuo.com/posts/1043393"},{"ad_monitors":[],"author":{"avatar_url":"http://img02.liwushuo.com/image/160617/hzkkl1ohn.jpg","avatar_webp_url":null,"created_at":1465802857,"id":1,"nickname":"小礼君"},"column":{"banner_image_url":"http://img03.liwushuo.com/image/160623/3ezltfrcw.jpg-w300","category":"穿搭","cover_image_url":"http://img01.liwushuo.com/image/160623/f4r9tut4d.jpg-w720","created_at":1466495336,"description":"人靠衣装美靠穿，不管春夏秋还是冬居家运动，每天都要穿出不同的美 ","id":58,"order":-1,"status":0,"subtitle":"已完结","title":"穿搭志","updated_at":1466679514},"content_type":1,"content_url":"http://www.liwushuo.com/posts/1001896/content","cover_image_url":"http://img02.liwushuo.com/image/150615/te9lzc297.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/150615/te9lzc297.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1435011787,"editor_id":null,"feature_list":[],"id":1001896,"label_ids":[],"liked":false,"likes_count":55992,"published_at":1432458540,"share_msg":"夏天，必然是要往海边走一趟的，扎进透彻海水里，怎一个爽字了得~小礼君从大家以往的评价中看到，我们的妹纸们还是蛮保守的嘛。既然你不愿意露腰，那小礼君就给大家推荐一些偏保守类型的连体泳衣。当然，保守不见得非要捂得严严实实，适当的露一点也是必要的。穿的美美，心情才会舒畅，让我们一起去海边吧！","short_title":"连体泳衣","status":0,"template":"","title":"保守派最爱的连体泳衣","type":"post","updated_at":1434356587,"url":"http://www.liwushuo.com/posts/1001896"},{"ad_monitors":[],"author":{"avatar_url":"http://img03.liwushuo.com/image/160617/hzkkl1ohn.jpg","avatar_webp_url":null,"created_at":1465802857,"id":1,"nickname":"小礼君"},"column":{"banner_image_url":"http://img01.liwushuo.com/image/160623/3ezltfrcw.jpg-w300","category":"穿搭","cover_image_url":"http://img02.liwushuo.com/image/160623/f4r9tut4d.jpg-w720","created_at":1466495336,"description":"人靠衣装美靠穿，不管春夏秋还是冬居家运动，每天都要穿出不同的美 ","id":58,"order":-1,"status":0,"subtitle":"已完结","title":"穿搭志","updated_at":1466679514},"content_type":1,"content_url":"http://www.liwushuo.com/posts/1001355/content","cover_image_url":"http://img01.liwushuo.com/image/150423/2syfzonh3.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/150423/2syfzonh3.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1430097351,"editor_id":null,"feature_list":[],"id":1001355,"label_ids":[],"liked":false,"likes_count":89045,"published_at":1430113538,"share_msg":"Hey,girls~夏天已经到了，你还要像往常一样继续做宅女吗？阳光、沙滩、海浪都在等着你！你只需要穿上泳衣，展示出自己美好的身材~ 什么？你还没备好泳衣吗？别担心，贴心如小礼君，已为你搜罗出最美最性感的泳装。快挑一件作为这个夏天的第一份礼送给自己吧。阳光沙滩是你的，这个夏天，也是你的！","short_title":"夏日泳衣辑","status":0,"template":"","title":"去海边？必须要带上的这件泳衣","type":"post","updated_at":1429787751,"url":"http://www.liwushuo.com/posts/1001355"},{"ad_monitors":[],"author":{"avatar_url":"http://img01.liwushuo.com/image/160617/hzkkl1ohn.jpg","avatar_webp_url":null,"created_at":1465802857,"id":1,"nickname":"小礼君"},"column":{"banner_image_url":"http://img03.liwushuo.com/image/160623/3ezltfrcw.jpg-w300","category":"穿搭","cover_image_url":"http://img01.liwushuo.com/image/160623/f4r9tut4d.jpg-w720","created_at":1466495336,"description":"人靠衣装美靠穿，不管春夏秋还是冬居家运动，每天都要穿出不同的美 ","id":58,"order":-1,"status":0,"subtitle":"已完结","title":"穿搭志","updated_at":1466679514},"content_type":1,"content_url":"http://www.liwushuo.com/posts/1001565/content","cover_image_url":"http://img01.liwushuo.com/image/150802/trh5oot9f.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/150802/trh5oot9f.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1432347838,"editor_id":null,"feature_list":[],"id":1001565,"label_ids":[],"liked":false,"likes_count":90472,"published_at":1432350033,"share_msg":"夏天，最惬意的生活不过于到海边吹吹风，到冰凉的海水里嬉戏打闹一下。小礼君一年能有一次到海边玩儿的机会就不错了，所以非常之珍惜，如果不穿件美美的泳衣，简直是对不起自己！真心羡慕那些住在海滨城市的妹子们啊~好了，不多说了，我要挑件泳衣，去阳台晒太阳了...（哭T_T）","short_title":"美貌泳衣","status":0,"template":"","title":"这么美的泳衣，你舍得下水吗","type":"post","updated_at":1432020238,"url":"http://www.liwushuo.com/posts/1001565"},{"ad_monitors":[],"author":{"avatar_url":"http://img03.liwushuo.com/image/160617/hzkkl1ohn.jpg","avatar_webp_url":null,"created_at":1465802857,"id":1,"nickname":"小礼君"},"column":{"banner_image_url":"http://img02.liwushuo.com/image/160623/3ezltfrcw.jpg-w300","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160623/f4r9tut4d.jpg-w720","created_at":1466495336,"description":"人靠衣装美靠穿，不管春夏秋还是冬居家运动，每天都要穿出不同的美 ","id":58,"order":-1,"status":0,"subtitle":"已完结","title":"穿搭志","updated_at":1466679514},"content_type":2,"content_url":"http://www.liwushuo.com/posts/1040158/content","cover_image_url":"http://img01.liwushuo.com/image/160328/kgb2vhxof.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160328/kgb2vhxof.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1460959200,"editor_id":1018,"feature_list":[9,6],"id":1040158,"label_ids":[],"liked":false,"likes_count":39121,"published_at":1460959200,"share_msg":"春天太适合出去游玩了不是吗？感受大自然的时光，最近也很多小伙伴选择去三亚、泰国、菲律宾这种海边的地方游玩，去沙滩怎么能没有泳衣呢？但是你们千万不能因为泳衣好看就乱买哦，一定要根据自己的身材去挑对泳衣啦，下面小礼君为你们选了一些，来看一下吧。","short_title":"比基尼","status":0,"template":"","title":"沙滩遮肉指南：教你如何按身材选泳衣","type":"post","updated_at":1459147593,"url":"http://www.liwushuo.com/posts/1040158"},{"ad_monitors":[],"author":{"avatar_url":"http://img03.liwushuo.com/image/160617/hzkkl1ohn.jpg","avatar_webp_url":null,"created_at":1465802857,"id":1,"nickname":"小礼君"},"column":{"banner_image_url":"http://img03.liwushuo.com/image/160623/3ezltfrcw.jpg-w300","category":"穿搭","cover_image_url":"http://img01.liwushuo.com/image/160623/f4r9tut4d.jpg-w720","created_at":1466495336,"description":"人靠衣装美靠穿，不管春夏秋还是冬居家运动，每天都要穿出不同的美 ","id":58,"order":-1,"status":0,"subtitle":"已完结","title":"穿搭志","updated_at":1466679514},"content_type":2,"content_url":"http://www.liwushuo.com/posts/1042389/content","cover_image_url":"http://img03.liwushuo.com/image/160415/p2a8xy4z6.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160415/p2a8xy4z6.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462068000,"editor_id":1058,"feature_list":[9],"id":1042389,"label_ids":[],"liked":false,"likes_count":31378,"published_at":1462154400,"share_msg":"眼看着就要到五一小长假啦，小伙伴们要跟男票去哪里玩耍呢？如果去海边的话一定要跟男票穿一样的情侣泳衣才够滋味哦~就算这次不去，以后还是要去的嘛，看到这么多美腻的情侣泳衣，想想跟男票一起穿的样子就开心得不得了啊~肯定是沙滩上的最美CP，肯定比阳光还耀眼~","short_title":"情侣泳衣","status":0,"template":"","title":"跟男票穿情侣泳衣，沙滩上你们比阳光还耀眼","type":"post","updated_at":1460716947,"url":"http://www.liwushuo.com/posts/1042389"},{"ad_monitors":[],"author":{"avatar_url":"http://img03.liwushuo.com/image/160617/hzkkl1ohn.jpg","avatar_webp_url":null,"created_at":1465802857,"id":1,"nickname":"小礼君"},"column":{"banner_image_url":"http://img03.liwushuo.com/image/160623/3ezltfrcw.jpg-w300","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160623/f4r9tut4d.jpg-w720","created_at":1466495336,"description":"人靠衣装美靠穿，不管春夏秋还是冬居家运动，每天都要穿出不同的美 ","id":58,"order":-1,"status":0,"subtitle":"已完结","title":"穿搭志","updated_at":1466679514},"content_type":1,"content_url":"http://www.liwushuo.com/posts/1002045/content","cover_image_url":"http://img02.liwushuo.com/image/150626/tgj4pq38d.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/150626/tgj4pq38d.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1435370400,"editor_id":null,"feature_list":[],"id":1002045,"label_ids":[],"liked":false,"likes_count":66177,"published_at":1435366800,"share_msg":"夏日是个露肉的季节，特别是去海边度假时，沙滩上的美好肉体让人艳羡，但是这对于身材不够完美的妹子来说，却是个苦恼。胸不够大？屁股不够翘？小腹有赘肉？面对这么不完美的自己，都不好意思穿泳衣了怎么办！表捉急，小礼君来为大家排忧解难，要小礼君说，除了令人羡慕的维密超模，拥有完美身材普通人再努力也难免被先天条件困住。那么，不如我们接受不完美的自己，在比基尼款式上耍心机，找到适合自己的比基尼，照样穿出完美身材！","short_title":"泳衣比基尼","status":0,"template":"","title":"根据身形挑泳衣，你选对了吗","type":"post","updated_at":1435312954,"url":"http://www.liwushuo.com/posts/1002045"},{"ad_monitors":[],"author":{"avatar_url":"http://img03.liwushuo.com/image/160617/hzkkl1ohn.jpg","avatar_webp_url":null,"created_at":1465802857,"id":1,"nickname":"小礼君"},"column":{"banner_image_url":"http://img02.liwushuo.com/image/160623/3ezltfrcw.jpg-w300","category":"穿搭","cover_image_url":"http://img02.liwushuo.com/image/160623/f4r9tut4d.jpg-w720","created_at":1466495336,"description":"人靠衣装美靠穿，不管春夏秋还是冬居家运动，每天都要穿出不同的美 ","id":58,"order":-1,"status":0,"subtitle":"已完结","title":"穿搭志","updated_at":1466679514},"content_type":2,"content_url":"http://www.liwushuo.com/posts/1041053/content","cover_image_url":"http://img03.liwushuo.com/image/160404/xdbfwe7p3.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160404/xdbfwe7p3.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1460255400,"editor_id":1021,"feature_list":[9],"id":1041053,"label_ids":[],"liked":false,"likes_count":31638,"published_at":1460255400,"share_msg":"春天到了，夏天还会远吗！又到了去海边浪一浪的季节啦，大秀身材的比基尼也该上场啦！小礼君已经为大家选好了各式各样的泳衣，无论你性感女神型，元气少女型，还是时尚运动型，在这里都能找到你爱的！阳光沙滩季，和闺蜜一起去海边吧～","short_title":"泳衣推荐","status":0,"template":"","title":"阳光海滩季，最靠谱泳衣指南送给她","type":"post","updated_at":1459740562,"url":"http://www.liwushuo.com/posts/1041053"}]
     * posts_count : 8
     * status : 1
     * subtitle : 女神的泳衣
     * title : 泳衣选得好，让男神追着跑
     * updated_at : 1467687506
     * url : http://www.liwushuo.com/collections/323
     */

    private DataBean data;

    @Override
    public String toString() {
        return "BannerListBean{" +
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
        private String banner_image_url;
        private String banner_webp_url;
        private String cover_image_url;
        private String cover_webp_url;
        private int created_at;
        private int id;
        /**
         * next_url : http://api.liwushuo.com/v2/collections/323/posts?limit=20&offset=20
         */

        private PagingBean paging;
        private int posts_count;
        private int status;
        private String subtitle;
        private String title;
        private int updated_at;
        private String url;
        /**
         * ad_monitors : []
         * author : {"avatar_url":"http://img02.liwushuo.com/image/160615/8u74ha4ec.jpg","avatar_webp_url":null,"created_at":1465974279,"id":8,"nickname":"穿衣大队长"}
         * column : {"banner_image_url":"http://img01.liwushuo.com/image/160608/ygqtl238c.jpg-w300","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160630/uhwwy5j3l.jpg-w720","created_at":1462501669,"description":"做你的私人搭配师，每日搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":null,"status":0,"subtitle":"","title":"明天穿什么","updated_at":1467624516}
         * content_type : 1
         * content_url : http://www.liwushuo.com/posts/1043393/content
         * cover_image_url : http://img01.liwushuo.com/image/160519/u1jictrr5.jpg-w720
         * cover_webp_url : http://img01.liwushuo.com/image/160519/u1jictrr5.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1463702400
         * editor_id : 1134
         * feature_list : []
         * id : 1043393
         * label_ids : []
         * liked : false
         * likes_count : 28074
         * published_at : 1463702400
         * share_msg : 北鼻们，初夏刚刚来到，是不是已经按耐不住鸡冻的心情在网上订机票了？阳光沙滩如此美好，入手几件沙滩行头才是正经事。别琢磨身材够不够销魂，小礼君为你们奉上的泳装不仅仅是高白瘦专属的哦！快来用这些泳装妆点你的美好肉体，度过一个美好假日吧！
         * short_title :
         * status : 0
         * template :
         * title : 第16期 ｜ 阳光沙滩已备好，就差一件惊艳的泳衣了
         * type : post
         * updated_at : 1463454939
         * url : http://www.liwushuo.com/posts/1043393
         */

        private List<PostsBean> posts;

        @Override
        public String toString() {
            return "DataBean{" +
                    "banner_image_url='" + banner_image_url + '\'' +
                    ", banner_webp_url='" + banner_webp_url + '\'' +
                    ", cover_image_url='" + cover_image_url + '\'' +
                    ", cover_webp_url='" + cover_webp_url + '\'' +
                    ", created_at=" + created_at +
                    ", id=" + id +
                    ", paging=" + paging +
                    ", posts_count=" + posts_count +
                    ", status=" + status +
                    ", subtitle='" + subtitle + '\'' +
                    ", title='" + title + '\'' +
                    ", updated_at=" + updated_at +
                    ", url='" + url + '\'' +
                    ", posts=" + posts +
                    '}';
        }

        public String getBanner_image_url() {
            return banner_image_url;
        }

        public void setBanner_image_url(String banner_image_url) {
            this.banner_image_url = banner_image_url;
        }

        public String getBanner_webp_url() {
            return banner_webp_url;
        }

        public void setBanner_webp_url(String banner_webp_url) {
            this.banner_webp_url = banner_webp_url;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public int getPosts_count() {
            return posts_count;
        }

        public void setPosts_count(int posts_count) {
            this.posts_count = posts_count;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public List<PostsBean> getPosts() {
            return posts;
        }

        public void setPosts(List<PostsBean> posts) {
            this.posts = posts;
        }

        public static class PagingBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class PostsBean  {
            /**
             * avatar_url : http://img02.liwushuo.com/image/160615/8u74ha4ec.jpg
             * avatar_webp_url : null
             * created_at : 1465974279
             * id : 8
             * nickname : 穿衣大队长
             */

            private AuthorBean author;
            /**
             * banner_image_url : http://img01.liwushuo.com/image/160608/ygqtl238c.jpg-w300
             * category : 穿搭
             * cover_image_url : http://img03.liwushuo.com/image/160630/uhwwy5j3l.jpg-w720
             * created_at : 1462501669
             * description : 做你的私人搭配师，每日搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。
             * id : 13
             * order : 0
             * post_published_at : null
             * status : 0
             * subtitle :
             * title : 明天穿什么
             * updated_at : 1467624516
             */

            private ColumnBean column;
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
            private String short_title;
            private int status;
            private String template;
            private String title;
            private String type;
            private int updated_at;
            private String url;
            private List<?> ad_monitors;
            private List<?> feature_list;
            private List<?> label_ids;

            @Override
            public String toString() {
                return "PostsBean{" +
                        "author=" + author +
                        ", column=" + column +
                        ", content_type=" + content_type +
                        ", content_url='" + content_url + '\'' +
                        ", cover_image_url='" + cover_image_url + '\'' +
                        ", cover_webp_url='" + cover_webp_url + '\'' +
                        ", created_at=" + created_at +
                        ", editor_id=" + editor_id +
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
                        ", label_ids=" + label_ids +
                        '}';
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public ColumnBean getColumn() {
                return column;
            }

            public void setColumn(ColumnBean column) {
                this.column = column;
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

            public List<?> getLabel_ids() {
                return label_ids;
            }

            public void setLabel_ids(List<?> label_ids) {
                this.label_ids = label_ids;
            }

            public static class AuthorBean {
                private String avatar_url;
                private Object avatar_webp_url;
                private int created_at;
                private int id;
                private String nickname;

                @Override
                public String toString() {
                    return "AuthorBean{" +
                            "avatar_url='" + avatar_url + '\'' +
                            ", avatar_webp_url=" + avatar_webp_url +
                            ", created_at=" + created_at +
                            ", id=" + id +
                            ", nickname='" + nickname + '\'' +
                            '}';
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public Object getAvatar_webp_url() {
                    return avatar_webp_url;
                }

                public void setAvatar_webp_url(Object avatar_webp_url) {
                    this.avatar_webp_url = avatar_webp_url;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }
            }

            public static class ColumnBean {
                private String banner_image_url;
                private String category;
                private String cover_image_url;
                private int created_at;
                private String description;
                private int id;
                private int order;
                private Object post_published_at;
                private int status;
                private String subtitle;
                private String title;
                private int updated_at;

                @Override
                public String toString() {
                    return "ColumnBean{" +
                            "banner_image_url='" + banner_image_url + '\'' +
                            ", category='" + category + '\'' +
                            ", cover_image_url='" + cover_image_url + '\'' +
                            ", created_at=" + created_at +
                            ", description='" + description + '\'' +
                            ", id=" + id +
                            ", order=" + order +
                            ", post_published_at=" + post_published_at +
                            ", status=" + status +
                            ", subtitle='" + subtitle + '\'' +
                            ", title='" + title + '\'' +
                            ", updated_at=" + updated_at +
                            '}';
                }

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

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public Object getPost_published_at() {
                    return post_published_at;
                }

                public void setPost_published_at(Object post_published_at) {
                    this.post_published_at = post_published_at;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
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

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }
            }
        }
    }
}
