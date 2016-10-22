package com.example.a38633.newsapp.base;

import android.content.Context;

/**
 * Created by 38633 on 2016/10/22.
 */

public abstract class BasePresenter<T,E> {
    public Context context;
    public T mView;
    public E mModel;

    public void setVM(T v,E m){
        mView = v;
        mModel = m;
        onStart();
    }
    protected abstract void onStart();
}
