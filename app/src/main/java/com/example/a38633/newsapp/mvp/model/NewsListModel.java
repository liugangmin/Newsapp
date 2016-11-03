package com.example.a38633.newsapp.mvp.model;

import com.example.a38633.newsapp.bean.NewsSummary;
import com.example.a38633.newsapp.mvp.contract.NewsListContract;
import com.example.a38633.newsapp.networks.ApiConstans;
import com.example.a38633.newsapp.networks.HostType;
import com.example.a38633.newsapp.networks.RetrofitManager;
import com.example.a38633.newsapp.utils.TimeUtil;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by 38633 on 2016/10/29.
 */

public class NewsListModel implements NewsListContract.Model {
    @Override
    public Observable<List<NewsSummary>> getNewsListData(String type, final String id, final int startPage) {
        return RetrofitManager.getDelfult(HostType.NETEASE_NEWS_VIDEO).getNewsList(RetrofitManager.getCacheControl(),type,id,startPage)
                .flatMap(new Func1<Map<String, List<NewsSummary>>, Observable<NewsSummary>>() {
                    @Override
                    public Observable<NewsSummary> call(Map<String, List<NewsSummary>> map) {
                        if (id.endsWith(ApiConstans.HOUSE_ID)){
                            return Observable.from(map.get("北京"));
                        }
                        return Observable.from(map.get(id));
                    }

                }).map(new Func1<NewsSummary, NewsSummary>() {
                    @Override
                    public NewsSummary call(NewsSummary newsSummary) {
                        String ptime = TimeUtil.formatDate(newsSummary.getPtime());
                        newsSummary.setPtime(ptime);
                        return newsSummary;
                    }
                })
                .distinct()
                .toSortedList(new Func2<NewsSummary, NewsSummary, Integer>() {
                    @Override
                    public Integer call(NewsSummary newsSummary, NewsSummary newsSummary2) {
                        return newsSummary2.getPtime().compareTo(newsSummary.getPtime());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
