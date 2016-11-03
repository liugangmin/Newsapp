package com.example.a38633.newsapp.mvp.contract;

import com.example.a38633.newsapp.base.BaseModel;
import com.example.a38633.newsapp.base.BasePresenter;
import com.example.a38633.newsapp.base.BaseView;
import com.example.a38633.newsapp.bean.NewsDetail;

import rx.Observable;

/**
 * Created by 38633 on 2016/11/2.
 */

public interface NewsDtailContract {

         interface Model extends BaseModel {
            //请求获取新闻
            Observable<NewsDetail> getOneNewsData(String postId);
        }

        interface View extends BaseView {
            //返回获取的新闻
            void returnOneNewsData(NewsDetail newsDetail);
        }
        abstract static class Presenter extends BasePresenter<View, Model> {
            //发起获取单条新闻请求
            public abstract void getOneNewsDataRequest(String postId);
        }


}
