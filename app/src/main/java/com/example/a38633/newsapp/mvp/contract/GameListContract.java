package com.example.a38633.newsapp.mvp.contract;

import com.example.a38633.newsapp.base.BaseModel;
import com.example.a38633.newsapp.base.BasePresenter;
import com.example.a38633.newsapp.base.BaseView;
import com.example.a38633.newsapp.bean.GameData;

import java.util.List;

import rx.Observable;

/**
 * Created by 38633 on 2016/11/6.
 */

public interface GameListContract {
    interface Model extends BaseModel {
        Observable<List<GameData>> getGameListData();
    }

    interface View extends BaseView {

        void returnGameListData(List<GameData> photoGirls);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void getGameListDataRequest();
    }
}
