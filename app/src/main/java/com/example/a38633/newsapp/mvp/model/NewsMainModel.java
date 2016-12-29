package com.example.a38633.newsapp.mvp.model;

import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.bean.NewsChannelTable;
import com.example.a38633.newsapp.bean.NewsChannelTableMannager;
import com.example.a38633.newsapp.mvp.contract.NewsMainContract;
import com.example.a38633.newsapp.utils.ACache;
import com.example.a38633.newsapp.app.AppContext;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by 38633 on 2016/10/28.
 */

public class NewsMainModel implements NewsMainContract.Model {
    @Override
    public Observable<List<NewsChannelTable>> loadMineNewsChannels() {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>(){

            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {


               ArrayList<NewsChannelTable> newsChannelTablelist = (ArrayList<NewsChannelTable>) ACache.get(AppContext.getInstance()).getAsObject(AppConstant.CHANNEL_MINE);

             //   if (newsChannelTablelist == null){
                    newsChannelTablelist = (ArrayList<NewsChannelTable>) NewsChannelTableMannager.loadNewsChannelsStatic();
                    ACache.get(AppContext.getInstance()).put(AppConstant.CHANNEL_MINE,newsChannelTablelist);

             //   }

                subscriber.onNext(newsChannelTablelist);
                subscriber.onCompleted();
            }
        });
    }
}
