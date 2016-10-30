package com.example.a38633.newsapp.app;

import android.app.Application;
import android.content.Context;

import com.example.a38633.newsapp.utils.AppContext;

/**
 * Created by 38633 on 2016/10/22.
 */

public class App extends Application{
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
        AppContext.init(this);
    }
    public static Context getContext(){
        return mAppContext;
    }
}
