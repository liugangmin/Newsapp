package com.example.a38633.newsapp.mvp.contract;

import com.example.a38633.newsapp.base.BaseModel;
import com.example.a38633.newsapp.base.BasePresenter;
import com.example.a38633.newsapp.base.BaseView;
import com.example.a38633.newsapp.bean.GameData;

import rx.Observable;

/**
 * Created by 38633 on 2016/11/8.
 */

public interface GameDtailContract {
    interface Model extends BaseModel{
        Observable<GameData> getGameData(String id);
    }
    interface View extends BaseView{
        void returnGameData (GameData gameData);
    }
    abstract static class presenter extends BasePresenter<View,Model>{
        public abstract void getGameResquest(String id);

    }
}
