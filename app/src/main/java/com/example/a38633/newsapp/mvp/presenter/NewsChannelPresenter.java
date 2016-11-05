package com.example.a38633.newsapp.mvp.presenter;

import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.baserx.RxSubscriber;
import com.example.a38633.newsapp.bean.NewsChannelTable;
import com.example.a38633.newsapp.mvp.contract.NewsChnnelContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 38633 on 2016/11/4.
 */

public class NewsChannelPresenter extends NewsChnnelContract.Presenter {
    @Override
    public void lodeChannelsRequest() {
        mRxMannager.add(mModel.lodeMineNewsChannels().subscribe(new RxSubscriber<List<NewsChannelTable>>(context,false) {
            @Override
            protected void _onNext(List<NewsChannelTable> newsChannelTables) {
                mView.returnMineNewsChannels(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
        mRxMannager.add(mModel.lodeMoreNewsChannels().subscribe(new RxSubscriber<List<NewsChannelTable>>(context,false) {
            @Override
            protected void _onNext(List<NewsChannelTable> newsChannelTables) {
                mView.returnMoreNewsChannels(newsChannelTables);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }

    @Override
    public void onItemSwap(final ArrayList<NewsChannelTable> newsChannelTableList, int fromPosition, int toPosition) {
        mRxMannager.add( mModel.swapDb(newsChannelTableList,fromPosition,toPosition).subscribe(new RxSubscriber<String>(context,false) {
            @Override
            protected void _onNext(String s) {
                mRxMannager.post(AppConstant.NEWS_CHANNEL_CHANGED,newsChannelTableList);
            }

            @Override
            protected void _onError(String message) {

            }
        }));

    }

    @Override
    public void onItemAddOrRemove(final ArrayList<NewsChannelTable> mineChannelTableList, ArrayList<NewsChannelTable> moreChannelTableList) {
        mRxMannager.add(mModel.updateDb(mineChannelTableList,moreChannelTableList).subscribe(new RxSubscriber<String>(context,false) {
            @Override
            protected void _onNext(String s) {
                mRxMannager.post(AppConstant.NEWS_CHANNEL_CHANGED,mineChannelTableList);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }

    @Override
    protected void onStart() {

    }
}
