package com.example.a38633.newsapp.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 38633 on 2016/11/9.
 */

public class GameDetailActivity extends BaseActivity {
    @Bind(R.id.game_toolbar)
    Toolbar mGameToolbar;
    @Bind(R.id.game_app_bar)
    AppBarLayout mGameAppBar;
    @Bind(R.id.game_webview)
    WebView mGameWebview;
    private static final String baseUrl="http://shouyoutoutiao.app.17wanba.com/";
    private String url;
    private String title;

    public static void startAction(Context context, String url ,String title){
        Intent intent = new Intent(context,GameDetailActivity.class);
        intent.putExtra(AppConstant.GAME_DETAIL,url);
        intent.putExtra(AppConstant.GAME_TITLE,title);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.game_detail_activity;
    }

    @Override
    protected void initView() {
        url = getIntent().getStringExtra(AppConstant.GAME_DETAIL);
        title = getIntent().getStringExtra(AppConstant.GAME_TITLE);
        mGameToolbar.setTitle(title);
        mGameToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
        mGameWebview.getSettings().setJavaScriptEnabled(true);  //设置WebView支持javascript
        mGameWebview.getSettings().setUseWideViewPort(true);//设置是当前html界面自适应屏幕
        mGameWebview.getSettings().setSupportZoom(true); //设置支持缩放
        mGameWebview.getSettings().setBuiltInZoomControls(true);//显示缩放控件
        mGameWebview.getSettings().setLoadWithOverviewMode(true);
        mGameWebview.getSettings().setDefaultTextEncodingName("utf-8");
        mGameWebview.requestFocus();
        mGameWebview.loadUrl(baseUrl+url);

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
