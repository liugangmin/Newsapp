package com.example.a38633.newsapp.mvp.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.base.BaseFragment;
import com.example.a38633.newsapp.bean.NewsChannelTable;
import com.example.a38633.newsapp.mvp.contract.NewsMainContract;
import com.example.a38633.newsapp.mvp.model.NewsMainModel;
import com.example.a38633.newsapp.mvp.presenter.NewsMainPresenter;
import com.example.a38633.newsapp.mvp.ui.activity.NewsChannelActivity;
import com.example.a38633.newsapp.mvp.ui.adapter.BaseFragmentAdapter;
import com.example.a38633.newsapp.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 38633 on 2016/10/28.
 */

public class NewsMainFragment extends BaseFragment<NewsMainPresenter,NewsMainModel> implements NewsMainContract.View {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabs)
    TabLayout mTabs;
    @Bind(R.id.add_channel_iv)
    ImageView mAddChannelIv;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;
    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @OnClick(R.id.add_channel_iv)
    public void clickAdd(){
        NewsChannelActivity.startAction(getContext());

    }
    private BaseFragmentAdapter mBaseFragmentAdapter;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_news_main;
    }

    @Override
    protected void initPresenter() {            ////////
        mPresenter.setVM(this,mModel);

    }

    @Override
    protected void initView() {
        mPresenter.loadMineNewsChannelsRequest();
    }//////

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine) {
        if (newsChannelsMine !=null){
            List<String> channelNames = new ArrayList<>();
            List<Fragment> fragmentList = new ArrayList<>();
            for (NewsChannelTable table:newsChannelsMine){
                channelNames.add(table.getNewsChannelName());
                fragmentList.add(createListFragments(table));
            }
            mBaseFragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(),fragmentList,channelNames);
            mViewPager.setAdapter(mBaseFragmentAdapter);
            mTabs.setupWithViewPager(mViewPager);
            MyUtils.dynamicSetTabLayoutMode(mTabs);
            setPageChangeListener();
        }

    }
    private Fragment createListFragments(NewsChannelTable table){
        NewsListFragment newsListFragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.NEWS_ID,table.getNewsChannelId());
        bundle.putString(AppConstant.NEWS_TYPE,table.getNewsChannelType());
        bundle.putInt(AppConstant.CHANNEL_POSITION,table.getNewsChannelIndex());
        newsListFragment.setArguments(bundle);
        return newsListFragment;

    }
    private  void setPageChangeListener(){
         mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
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
