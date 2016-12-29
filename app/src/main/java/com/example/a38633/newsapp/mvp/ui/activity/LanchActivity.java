package com.example.a38633.newsapp.mvp.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 38633 on 2016/11/10.
 */

public class LanchActivity extends BaseActivity {
    @Bind(R.id.lach_igmview)
    ImageView mLachIgmview;
    @Bind(R.id.lauth_textview)
    TextView mLauthTextview;
    @Bind(R.id.design_text)
    TextView mDesignText;

    @Override
    protected int getLayoutId() {
        return R.layout.lauch_activity;
    }

    @Override
    protected void initView() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.lach_donghua);
        mLachIgmview.startAnimation(animation);
        mLauthTextview.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               MainActivity.startAction(LanchActivity.this);
                finish();
            }
        },2000);



    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initView();
    }
}
