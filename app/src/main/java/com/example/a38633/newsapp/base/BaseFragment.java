package com.example.a38633.newsapp.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a38633.newsapp.utils.TUtil;

/**
 * Created by 38633 on 2016/10/22.
 */

public abstract class BaseFragment<T extends BasePresenter,E extends BaseModel>extends Fragment{
    protected View mRootView;
    public T mPresenter;
    public E mModel;
    public Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){
            mRootView = inflater.inflate(getLayoutResource(),container,false);
        }
        mPresenter = TUtil.get(this,0);
        mModel = TUtil.get(this,1);
        if (mPresenter != null){
            mPresenter.context = this.getActivity();
        }
        initPresenter();
        initView();
        return mRootView;
    }
    protected abstract int getLayoutResource();
    protected abstract void initPresenter();
    protected abstract void initView();

}
