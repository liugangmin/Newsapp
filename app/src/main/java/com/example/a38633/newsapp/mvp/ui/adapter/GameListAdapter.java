package com.example.a38633.newsapp.mvp.ui.adapter;

import android.content.Context;

import com.example.a38633.newsapp.bean.GameData;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by 38633 on 2016/11/6.
 */

public class GameListAdapter extends MultiItemTypeAdapter<GameData> {
    public GameListAdapter(Context context, List<GameData> datas) {
        super(context, datas);
    }
    public void changeData(List<GameData> gameDatas){
        mDatas = gameDatas;
        notifyDataSetChanged();
    }
    public void addData(List<GameData> gameDatas){
        if (mDatas!= null){
            mDatas.addAll(gameDatas);
            notifyDataSetChanged();
        }else {
            changeData(gameDatas);
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
