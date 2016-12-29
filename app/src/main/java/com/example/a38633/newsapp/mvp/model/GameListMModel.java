package com.example.a38633.newsapp.mvp.model;

import com.example.a38633.newsapp.bean.GameApi;
import com.example.a38633.newsapp.bean.GameData;
import com.example.a38633.newsapp.mvp.contract.GameListContract;
import com.example.a38633.newsapp.networks.HostType;
import com.example.a38633.newsapp.networks.RetrofitManager;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by 38633 on 2016/11/6.
 */

public class GameListMModel implements GameListContract.Model {
    @Override
    public Observable<List<GameData>> getGameListData() {
        return RetrofitManager.getDelfult(HostType.GAMEEE_NEWS_MY)
                .getGame(RetrofitManager.getCacheControl())
                .map(new Func1<GameApi, List<GameData>>() {
                    @Override
                    public List<GameData> call(GameApi gameApi) {
                        return gameApi.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
