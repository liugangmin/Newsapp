package com.example.a38633.newsapp.bean;

import java.util.List;

/**
 * Created by 38633 on 2016/11/8.
 */

public class GameApi {

    /**
     * ret : 0
     * data : [{"id":"25882","type":"1","source_id":"15","template_id":"5","title":"Oculus VR、SONY与HTC打响VR设备争夺战","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/07/14/40a6b8f73e02764fb64b98d44dbc010c.jpg"}],"url":"/toutiao/detail/25882?create_time=1478586612","status":"1","create_time":"39分钟前","time_length":"0","source_name":"一起玩吧"},{"id":"19295","type":"1","source_id":"15","template_id":"3","title":"《神秘传奇》萌宠养成你必须知道的三件事","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/13/3465da055c6e3f733aa377909fda5f96.jpg"}],"url":"/toutiao/detail/19295?create_time=1478574273","status":"1","create_time":"今天03:04","time_length":"0","source_name":"一起玩吧"},{"id":"22531","type":"1","source_id":"15","template_id":"5","title":"策略出奇迹《大武当之剑》竞技场PK抢先看","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/30/42871c88e737bb12f98651a8f19de64f.JPG"}],"url":"/toutiao/detail/22531?create_time=1478564225","status":"1","create_time":"今天00:17","time_length":"0","source_name":"一起玩吧"},{"id":"5105","type":"1","source_id":"19","template_id":"3","title":"称霸一方《魔灵觉醒》军团巅峰对决开启","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/04/27/3800ec7476f9bb8a24a144d3c4bb2504.JPEG"}],"url":"/toutiao/detail/5105?create_time=1478557057","status":"1","create_time":"11月07日 22:17","time_length":"0","source_name":"游戏多"},{"id":"730","type":"1","source_id":"15","template_id":"5","title":"创意的胜利 《六界》新颖玩法点燃智慧火花","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/03/23/4ffbb0160451de1cdd04eaefdcbfddaa.jpg"}],"url":"/toutiao/detail/730?create_time=1478547418","status":"1","create_time":"11月07日 19:36","time_length":"0","source_name":"一起玩吧"},{"id":"21791","type":"1","source_id":"15","template_id":"5","title":"游戏快速入门 《罗马时代：帝国OL》快速成长体验冷兵时代的魅力","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/06/27/a9e9f2818f6d505ff2d514290fc45faa.jpg"}],"url":"/toutiao/detail/21791?create_time=1478537774","status":"1","create_time":"11月07日 16:56","time_length":"0","source_name":"一起玩吧"},{"id":"30926","type":"1","source_id":"24","template_id":"5","title":"抓神兽？《口袋妖怪重制》野外奇遇之三神兽","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/08/02/e7cfa745a83bef628866676545beddf9.png"}],"url":"/toutiao/detail/30926?create_time=1478525745","status":"1","create_time":"11月07日 13:35","time_length":"0","source_name":"DoNews"},{"id":"11700","type":"1","source_id":"15","template_id":"5","title":"趣味休闲小游戏《跳跃吧！花滑熊》即将登陆","img":[{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/05/17/89543a2b86f90ca39b036b22f57ea5b5.jpg"}],"url":"/toutiao/detail/11700?create_time=1478509546","status":"1","create_time":"11月07日 09:05","time_length":"0","source_name":"一起玩吧"}]
     * flag : 0
     */

    private int ret;
    private int flag;
    /**
     * id : 25882
     * type : 1
     * source_id : 15
     * template_id : 5
     * title : Oculus VR、SONY与HTC打响VR设备争夺战
     * img : [{"url":"http://img.storage.17wanba.org.cn/shouyou/2016/07/14/40a6b8f73e02764fb64b98d44dbc010c.jpg"}]
     * url : /toutiao/detail/25882?create_time=1478586612
     * status : 1
     * create_time : 39分钟前
     * time_length : 0
     * source_name : 一起玩吧
     */

    private List<GameData> data;

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

    public List<GameData> getData() {
        return data;
    }

    public void setData(List<GameData> data) {
        this.data = data;
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

