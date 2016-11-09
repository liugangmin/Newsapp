package com.example.a38633.newsapp.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.a38633.newsapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 38633 on 2016/11/4.
 */

public class VideoMainFragment extends Fragment {

    @Bind(R.id.jy_webview)
    WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_main, container, false);
        ButterKnife.bind(this, view);
        mWebView.getSettings().setJavaScriptEnabled(true);  //设置WebView支持javascript
        mWebView.getSettings().setUseWideViewPort(true);//设置是当前html界面自适应屏幕
        mWebView.getSettings().setSupportZoom(true); //设置支持缩放
        mWebView.getSettings().setBuiltInZoomControls(true);//显示缩放控件
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        mWebView.requestFocus();
        mWebView.loadUrl("http://jy.xhu.edu.cn/"); //加载西华大学就业信息


        return view;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
