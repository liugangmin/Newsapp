package com.example.a38633.newsapp.mvp.model;

import com.example.a38633.newsapp.baserx.RxSchedulers;
import com.example.a38633.newsapp.bean.NewsDetail;
import com.example.a38633.newsapp.mvp.contract.NewsDtailContract;
import com.example.a38633.newsapp.networks.HostType;
import com.example.a38633.newsapp.networks.RetrofitManager;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by 38633 on 2016/11/2.
 */

public class NewsDtialModle implements NewsDtailContract.Model {
    @Override
    public Observable<NewsDetail> getOneNewsData(final String postId) {
        return RetrofitManager.getDelfult(HostType.NETEASE_NEWS_VIDEO).getNewDetail(RetrofitManager.getCacheControl(), postId)
                .map(new Func1<Map<String, NewsDetail>, NewsDetail>() {
                    @Override
                    public NewsDetail call(Map<String, NewsDetail> map) {
                        NewsDetail newsDetail = map.get(postId);
                        changeNewsDetail(newsDetail);
                        return newsDetail;
                    }
                })
                .compose(RxSchedulers.<NewsDetail>io_main());
    }

    private void changeNewsDetail(NewsDetail newsDetail) {
        List<NewsDetail.ImgBean> imgSrcs = newsDetail.getImg();
        if (isChange(imgSrcs)) {
            String newsBody = newsDetail.getBody();
            newsBody = changeNewsBody(imgSrcs, newsBody);
            newsDetail.setBody(newsBody);
        }
    }
    private boolean isChange(List<NewsDetail.ImgBean> imgSrcs) {
        return imgSrcs != null && imgSrcs.size() >= 2;
    }

    private String changeNewsBody(List<NewsDetail.ImgBean> imgSrcs, String newsBody) {
        for (int i = 0; i < imgSrcs.size(); i++) {
            String oldChars = "<!--IMG#" + i + "-->";
            String newChars;
            if (i == 0) {
                newChars = "";
            } else {
                newChars = "<img src=\"" + imgSrcs.get(i).getSrc() + "\" />";
            }
            newsBody = newsBody.replace(oldChars, newChars);

        }
        return newsBody;
    }
}