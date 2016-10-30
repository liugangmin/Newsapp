package com.example.a38633.newsapp.mvp.presenter;

import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.bean.NewsSummary;
import com.example.a38633.newsapp.mvp.contract.NewsListContract;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by 38633 on 2016/10/29.
 */

public class NewsListPresenter extends NewsListContract.Presenter {
    @Override
    public void getNewsListDataRequest(String type, String id, int starPage) {
        mRxMannager.add(mModel.getNewsListData(type,id,starPage).subscribe(new Subscriber<List<NewsSummary>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading("加载中");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<NewsSummary> newsSummaries) {
                mView.returnNewsListData(newsSummaries);
                mView.stopLoading();
            }
        }));
    }

    @Override
    protected void onStart() {
        mRxMannager.on(AppConstant.NEWS_LIST_TO_TOP, new Action1<Object>() {
            @Override
            public void call(Object o) {
                mView.scrolltoTop();
            }
        });

    }
}
