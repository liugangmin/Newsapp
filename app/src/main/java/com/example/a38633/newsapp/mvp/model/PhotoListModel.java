package com.example.a38633.newsapp.mvp.model;

import com.example.a38633.newsapp.baserx.RxSchedulers;
import com.example.a38633.newsapp.bean.GirlData;
import com.example.a38633.newsapp.bean.PhotoGirl;
import com.example.a38633.newsapp.mvp.contract.PhotoListContract;
import com.example.a38633.newsapp.networks.HostType;
import com.example.a38633.newsapp.networks.RetrofitManager;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by 38633 on 2016/11/5.
 */
public class PhotoListModel implements PhotoListContract.Model{
    @Override
    public Observable<List<PhotoGirl>> getPhotosListData(int size, int page) {
        return RetrofitManager.getDelfult(HostType.GANK_GIRL_PHOTO)
                .getPhotoList(RetrofitManager.getCacheControl(),size, page)
                .map(new Func1<GirlData, List<PhotoGirl>>() {
                    @Override
                    public List<PhotoGirl> call(GirlData girlData) {
                        return girlData.getResults();
                    }
                })
                .compose(RxSchedulers.<List<PhotoGirl>>io_main());
    }
}
