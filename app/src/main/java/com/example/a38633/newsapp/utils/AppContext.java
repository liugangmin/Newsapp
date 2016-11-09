package com.example.a38633.newsapp.utils;

import android.content.Context;

/**
 * Created by 38633 on 2016/10/22.
 */

public class AppContext {
    private static Context mContext ;
    public static void getContext(Context context){
       mContext=context;

    }
    private AppContext(){

    }
    public static void init(Context context) {
        mContext = context;
    }
    public static Context getInstance(){
        if (mContext == null){
            throw new NullPointerException("the context is null，from my own Exception");
        }
        return mContext;
    }
}
