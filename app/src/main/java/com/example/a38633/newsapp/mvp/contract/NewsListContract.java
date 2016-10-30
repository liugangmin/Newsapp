package com.example.a38633.newsapp.mvp.contract;

import com.example.a38633.newsapp.base.BaseModel;
import com.example.a38633.newsapp.base.BasePresenter;
import com.example.a38633.newsapp.base.BaseView;
import com.example.a38633.newsapp.bean.NewsSummary;

import java.util.List;

import rx.Observable;

/**
 * Created by 38633 on 2016/10/29.
 */

public interface NewsListContract {
    interface Model extends BaseModel{
        Observable <List<NewsSummary>> getNewsListData(String type ,final String id,int starPage);
    }
    interface View extends BaseView{
        void returnNewsListData(List<NewsSummary> newsSummaries);
        void scrolltoTop();
    }
    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getNewsListDataRequest(String type,final String id,int starPage);
    }
}
