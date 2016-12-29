package com.example.a38633.newsapp.bean;

import java.util.List;

/**
 * Created by 38633 on 2016/12/28.
 */

public class Nsdfesf {
    /**
     * ret : 0
     * data : [{"id":"6916","type":"1","source_id":"15","template_id":"5","title":"女人手指尖的fashion：联想ZUK Z2 Pro","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/05/03/45b15c71185b53636f72d82a63047d14.jpg"}],"url":"/toutiao/detail/6916?create_time=1482913161","status":"1","create_time":"今天08:19","time_length":"0","source_name":"一起玩吧"},{"id":"20924","type":"1","source_id":"15","template_id":"5","title":"《圣魂》新英雄绝尘来袭：七进七出武神赵子龙","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/21/d9cf8e7112f8e07b281df15c681a6d50.jpg"}],"url":"/toutiao/detail/20924?create_time=1482817905","status":"1","create_time":"12月27日 05:51","time_length":"0","source_name":"一起玩吧"},{"id":"200","type":"1","source_id":"15","template_id":"5","title":"备好狗粮  《神威启示录》幼驯染五人组关系深扒","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/03/14/d3c54002d4e41bd78c58da84a32d4940.jpg"}],"url":"/toutiao/detail/200?create_time=1482812212","status":"1","create_time":"12月27日 04:16","time_length":"0","source_name":"一起玩吧"},{"id":"17371","type":"1","source_id":"15","template_id":"5","title":"苹果手握2157亿美元 蝉联美国公司现金持有量排行榜首","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/03/46b5d55293ab8dc055ba8143e183ac9c.jpg"}],"url":"/toutiao/detail/17371?create_time=1482714236","status":"1","create_time":"12月26日 01:03","time_length":"0","source_name":"一起玩吧"},{"id":"19522","type":"1","source_id":"16","template_id":"5","title":"联盟不服部落  《龙骑士传》手游特色详解","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/14/c65d7e921ed44b00d7bcbeedfb842b6d.jpg"}],"url":"/toutiao/detail/19522?create_time=1482655328","status":"1","create_time":"12月25日 08:42","time_length":"0","source_name":"搞趣"},{"id":"21916","type":"1","source_id":"15","template_id":"4","title":"《大梦幻》\u201c百尺竿头 更进一步\u201d快速升级指南","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/28/a2b63c8abcd9604cc370f118563b11a4.jpg"},{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/28/9a00e2ffa8d38f2f5375214aecaecd83.jpg"},{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/28/5b893232d6ca99e1dacae4d476060eae.jpg"}],"url":"/toutiao/detail/21916?create_time=1482638199","status":"1","create_time":"12月25日 03:56","time_length":"0","source_name":"一起玩吧"},{"id":"2942","type":"1","source_id":"15","template_id":"3","title":"《乖离性百万亚瑟王》联动EVA 引领IP合作新模式","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/04/15/0ea705ae79ee8fae48db0f08616be683.jpg"}],"url":"/toutiao/detail/2942?create_time=1482541961","status":"1","create_time":"12月24日 01:12","time_length":"0","source_name":"一起玩吧"},{"id":"29488","type":"1","source_id":"15","template_id":"5","title":"梦想永生 《梦幻启航》征途永不完结","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/07/28/8e3e18ae1b1bb97c01ea0cad21153248.jpg"}],"url":"/toutiao/detail/29488?create_time=1482502148","status":"1","create_time":"12月23日 14:09","time_length":"0","source_name":"一起玩吧"}]
     * flag : 0
     */

    private int ret;
    private int flag;
    private List<DataBean> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 6916
         * type : 1
         * source_id : 15
         * template_id : 5
         * title : 女人手指尖的fashion：联想ZUK Z2 Pro
         * img : [{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/05/03/45b15c71185b53636f72d82a63047d14.jpg"}]
         * url : /toutiao/detail/6916?create_time=1482913161
         * status : 1
         * create_time : 今天08:19
         * time_length : 0
         * source_name : 一起玩吧
         */

        private String id;
        private String type;
        private String source_id;
        private String template_id;
        private String title;
        private String url;
        private String status;
        private String create_time;
        private String time_length;
        private String source_name;
        private List<ImgBean> img;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSource_id() {
            return source_id;
        }

        public void setSource_id(String source_id) {
            this.source_id = source_id;
        }

        public String getTemplate_id() {
            return template_id;
        }

        public void setTemplate_id(String template_id) {
            this.template_id = template_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getTime_length() {
            return time_length;
        }

        public void setTime_length(String time_length) {
            this.time_length = time_length;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public static class ImgBean {
            /**
             * url : http://img.storage.17wanba.org.cn/shouyou/2016/05/03/45b15c71185b53636f72d82a63047d14.jpg
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
