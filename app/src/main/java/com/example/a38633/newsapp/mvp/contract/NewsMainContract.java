package com.example.a38633.newsapp.mvp.contract;

import com.example.a38633.newsapp.base.BaseModel;
import com.example.a38633.newsapp.base.BasePresenter;
import com.example.a38633.newsapp.base.BaseView;
import com.example.a38633.newsapp.bean.NewsChannelTable;

import java.util.List;

import rx.Observable;

/**
 * Created by 38633 on 2016/10/28.
 */

public interface NewsMainContract {
    interface Model extends BaseModel{
        Observable<List<NewsChannelTable>> loadMineNewsChannels();
    }
    interface View extends BaseView{
        void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine);
    }
    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void loadMineNewsChannelsRequest();
    }
}
