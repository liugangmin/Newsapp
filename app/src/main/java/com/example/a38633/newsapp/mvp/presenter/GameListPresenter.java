package com.example.a38633.newsapp.mvp.presenter;

import android.util.Log;

import com.example.a38633.newsapp.bean.GameData;
import com.example.a38633.newsapp.mvp.contract.GameListContract;

import java.util.List;

import rx.Subscriber;

/**
 * Created by 38633 on 2016/11/6.
 */

public class GameListPresenter extends GameListContract.Presenter {
    @Override
    public void getGameListDataRequest() {
        mRxMannager.add(mModel.getGameListData().subscribe(new Subscriber<List<GameData>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<GameData> gameDatas) {
                Log.d("here", "onNext: " + gameDatas.size());
                mView.returnGameListData(gameDatas);
                mView.stopLoading();

            }
        }));
    }


    @Override
    protected void onStart() {

    }
}
