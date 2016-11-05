package com.example.a38633.newsapp.mvp.ui.fragment;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.base.BaseFragment;
import com.example.a38633.newsapp.bean.NewsChannelTable;
import com.example.a38633.newsapp.mvp.contract.NewsMainContract;
import com.example.a38633.newsapp.mvp.model.NewsMainModel;
import com.example.a38633.newsapp.mvp.presenter.NewsMainPresenter;

import java.util.List;

/**
 * Created by 38633 on 2016/11/4.
 */

public class VideoMainFragment extends BaseFragment<NewsMainPresenter,NewsMainModel> implements NewsMainContract.View {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_video_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine) {

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}
