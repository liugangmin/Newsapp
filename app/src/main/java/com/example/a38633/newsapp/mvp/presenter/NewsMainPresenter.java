package com.example.a38633.newsapp.mvp.presenter;
import android.util.Log;

import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.bean.NewsChannelTable;
import com.example.a38633.newsapp.mvp.contract.NewsMainContract;
import java.util.List;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by 38633 on 2016/10/28.
 */

public class NewsMainPresenter extends NewsMainContract.Presenter {
    @Override
    public void lodeMineNewsChannelsRequest() {
        mRxMannager.add(mModel.lodeMineNewsChannels().subscribe(new Subscriber<List<NewsChannelTable>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<NewsChannelTable> newsChannelTables) {
                Log.d("here", "onNext: " + newsChannelTables.size());
                mView.returnMineNewsChannels(newsChannelTables);

            }
        }));
    }

    @Override
    protected void onStart() {
        mRxMannager.on(AppConstant.NEWS_CHANNEL_CHANGED, new Action1<List<NewsChannelTable>>() {
            @Override
            public void call(List<NewsChannelTable> newsChannelTables) {
                if (newsChannelTables !=null){
                    mView.returnMineNewsChannels(newsChannelTables);
                }
            }
        });

    }
}
