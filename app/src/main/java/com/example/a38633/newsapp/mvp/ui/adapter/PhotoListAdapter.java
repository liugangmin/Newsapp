package com.example.a38633.newsapp.mvp.ui.adapter;

import android.content.Context;

import com.example.a38633.newsapp.bean.PhotoGirl;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by 38633 on 2016/11/5.
 */

public class PhotoListAdapter extends MultiItemTypeAdapter {
    public PhotoListAdapter(Context context, List<PhotoGirl> datas) {
        super(context, datas);
    }
    public void changeData(List<PhotoGirl> photoGirls){
        mDatas = photoGirls;
        notifyDataSetChanged();
    }
    public void addData(List<PhotoGirl> photoGirls){
        if (mDatas!= null){
            mDatas.addAll(photoGirls);
            notifyDataSetChanged();
        }else {
            changeData(photoGirls);
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
