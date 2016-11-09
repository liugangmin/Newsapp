package com.example.a38633.newsapp.mvp.model;

import android.util.Log;

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
//        return RetrofitManager.getDelfult(HostType.GAMEEE_NEWS_MY)
//                .getGameList(RetrofitManager.getCacheControl())
//                .flatMap(new Func1<Map<String, List<GameData>>, Observable<GameData>>() {
//                    @Override
//                    public Observable<GameData> call(Map<String, List<GameData>> stringListMap) {
//                        return Observable.from(stringListMap.get("data"));
//                    }
//                })
//                .map(new Func1<GameData, GameData>() {
//
//                    @Override
//                    public GameData call(GameData gameData) {
//                        Log.d("here", "call: " + gameData.getCreate_time());
//                        return gameData;
//                    }
//                })
//                .distinct()
//                .toSortedList(new Func2<GameData, GameData, Integer>() {
//                    @Override
//                    public Integer call(GameData gameData, GameData gameData2) {
//                        return gameData2.getCreate_time().compareTo(gameData.getCreate_time());
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
        return RetrofitManager.getDelfult(HostType.GAMEEE_NEWS_MY)
                .getGame(RetrofitManager.getCacheControl())
                .map(new Func1<GameApi, List<GameData>>() {
                    @Override
                    public List<GameData> call(GameApi gameApi) {
                        Log.d("here", "call: " + gameApi.getData().size());
                        return gameApi.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
