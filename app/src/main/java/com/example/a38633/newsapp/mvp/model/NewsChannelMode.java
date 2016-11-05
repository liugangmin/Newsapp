package com.example.a38633.newsapp.mvp.model;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.app.App;
import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.baserx.RxSchedulers;
import com.example.a38633.newsapp.bean.NewsChannelTable;
import com.example.a38633.newsapp.bean.NewsChannelTableMannager;
import com.example.a38633.newsapp.mvp.contract.NewsChnnelContract;
import com.example.a38633.newsapp.networks.ApiConstans;
import com.example.a38633.newsapp.utils.ACache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by 38633 on 2016/11/4.
 */

public class NewsChannelMode implements NewsChnnelContract.Model{
    @Override
    public Observable<List<NewsChannelTable>> lodeMineNewsChannels() {

        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTableList = (ArrayList<NewsChannelTable>) ACache.get(App.getContext()).getAsObject(AppConstant.CHANNEL_MINE);
                if(newsChannelTableList==null){
                    newsChannelTableList= (ArrayList<NewsChannelTable>) NewsChannelTableMannager.loadNewsChannelsStatic();
                }
                subscriber.onNext(newsChannelTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }

    @Override
    public Observable<List<NewsChannelTable>> lodeMoreNewsChannels() {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTableList = (ArrayList<NewsChannelTable>) ACache.get(App.getContext()).getAsObject(AppConstant.CHANNEL_MORE);
                if(newsChannelTableList==null) {
                    List<String> channelName = Arrays.asList(App.getContext().getResources().getStringArray(R.array.news_channel_name));
                    List<String> channelId = Arrays.asList(App.getContext().getResources().getStringArray(R.array.news_channel_id));
                    newsChannelTableList = new ArrayList<>();
                    for (int i = 0; i < channelName.size(); i++) {
                        NewsChannelTable entity = new NewsChannelTable(channelName.get(i), channelId.get(i)
                                , ApiConstans.getType(channelId.get(i)), i <= 5, i, false);
                        newsChannelTableList.add(entity);
                    }
                }
                subscriber.onNext(newsChannelTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }

    @Override
    public Observable<String> swapDb(final ArrayList<NewsChannelTable> newsChannelTableList,int fromPosition, int toPosition) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                ACache.get(App.getContext()).put(AppConstant.CHANNEL_MINE,newsChannelTableList);
                subscriber.onNext("");
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<String>io_main());

    }

    @Override
    public Observable<String> updateDb(final ArrayList<NewsChannelTable> mineChannelTableList,final ArrayList<NewsChannelTable> moreChannelTableList) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                ACache.get(App.getContext()).put(AppConstant.CHANNEL_MINE,mineChannelTableList);
                ACache.get(App.getContext()).put(AppConstant.CHANNEL_MORE,moreChannelTableList);
                subscriber.onNext("");
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<String>io_main());
    }
}
