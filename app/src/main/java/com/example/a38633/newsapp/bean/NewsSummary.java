package com.example.a38633.newsapp.bean;

import java.util.List;

/**
 * Created by 38633 on 2016/10/23.
 */

public class NewsSummary {
    /**
     * postid : PHOT23BA1000100A
     * hasCover : false
     * hasHead : 1
     * replyCount : 31754
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : 9IG74V5H00963VRO_C42KSCJBbjjikeupdateDoc
     * title : 上海街头现"食物分享冰箱" 可免费拿取
     * order : 1
     * priority : 350
     * lmodify : 2016-10-23 14:32:19
     * boardid : photoview_bbs
     * ads : [{"title":"上海街头现\"食物分享冰箱\" 可免费拿取","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/cd1ab77ded5a4505acd7abac052f154920161023133354.jpeg","subtitle":"","url":"00AP0001|2207041"},{"title":"福建公开宣判11名电信诈骗犯 千人围观","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/8897c02e0752483fb599db52ff9310f820161023081323.jpeg","subtitle":"","url":""},{"title":"武汉近200名女青年在食堂与官兵相亲","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/fba90e816a624e878ccffd682efcda4620161023072358.jpeg","subtitle":"","url":""},{"title":"伊拉克基尔库克市多处遇袭至少24人死亡","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/85a942d1654544e197c71103c616cf9720161023093511.jpeg","subtitle":"","url":""},{"title":"一周精选：深圳工人画美国特朗普面具","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/fa4bb23f673540028e6d202a14dac68120161022085232.jpeg","subtitle":"","url":"19BR0001|2206044"}]
     * photosetID : 00AP0001|2207041
     * imgsum : 10
     * template : normal1
     * votecount : 29832
     * skipID : 00AP0001|2207041
     * alias : Top News
     * skipType : photoset
     * cid : C1348646712614
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/f896f0245af3458fb05737887d2c401d20161023133353.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/e5079efd08d7407485195c8e454174eb20161023133353.jpeg"}]
     * source : 网易原创
     * ename : androidnews
     * tname : 头条
     * imgsrc : http://cms-bucket.nosdn.127.net/cd1ab77ded5a4505acd7abac052f154920161023133354.jpeg
     * ptime : 2016-10-23 13:33:58
     */


        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private int imgsum;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        /**
         * title : 上海街头现"食物分享冰箱" 可免费拿取
         * tag : photoset
         * imgsrc : http://cms-bucket.nosdn.127.net/cd1ab77ded5a4505acd7abac052f154920161023133354.jpeg
         * subtitle :
         * url : 00AP0001|2207041
         */

        private List<AdsBean> ads;
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/f896f0245af3458fb05737887d2c401d20161023133353.jpeg
         */

        private List<ImgextraBean> imgextra;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class AdsBean {
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean {
            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
}

