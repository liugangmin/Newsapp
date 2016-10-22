package com.example.a38633.newsapp.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a38633.newsapp.utils.TUtil;

/**
 * Created by 38633 on 2016/10/22.
 */

public abstract class BaseActivity<T extends BasePresenter,E extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public E mMoldel;
    public Context context;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter= TUtil.get(this,0);
        mMoldel = TUtil.get(this,1);
        if(mPresenter != null){
            mPresenter.context = this;
        }
        this.initPresenter();
        this.initView();
    }


    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initPresenter();

}
