package com.example.a38633.newsapp.bean;

import java.util.List;

/**
 * Created by 38633 on 2016/11/6.
 */

public class GameData {
    /**
     * id : 16858
     * type : 1
     * source_id : 15
     * template_id : 5
     * title : 龙凤呈祥《三国群英传》饰品雕琢
     * img : [{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/01/17e38f299724dd798c1ac664a3139b5c.jpg"}]
     * url : /toutiao/detail/16858?create_time=1478388574
     * status : 1
     * create_time : 11月05日 23:29
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
    /**
     * url : http://img.storage.17wanba.org.cn/shouyou/2016/06/01/17e38f299724dd798c1ac664a3139b5c.jpg
     */

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
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
