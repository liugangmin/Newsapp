package com.example.a38633.newsapp.mvp.ui.adapter;

import android.content.Context;

import com.example.a38633.newsapp.bean.NewsSummary;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by 38633 on 2016/10/30.
 */

public class NewsListAdapter extends MultiItemTypeAdapter<NewsSummary> {
    public NewsListAdapter(Context context, List<NewsSummary> datas) {
        super(context, datas);
    }
    public void changeData(List<NewsSummary> newsSummaries){
        mDatas = newsSummaries;
        notifyDataSetChanged();
    }
    public void addData(List<NewsSummary> newsSummaries){
        if (mDatas!= null){
            mDatas.addAll(newsSummaries);
            notifyDataSetChanged();
        }else {
            changeData(newsSummaries);
        }
    }
    public int getSize(){
        if (mDatas != null){
            return mDatas.size();
        }else {
            return 0;
        }
    }
}
