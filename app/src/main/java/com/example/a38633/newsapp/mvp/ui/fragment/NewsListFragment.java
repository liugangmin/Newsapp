package com.example.a38633.newsapp.mvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.base.BaseFragment;
import com.example.a38633.newsapp.bean.NewsSummary;
import com.example.a38633.newsapp.mvp.contract.NewsListContract;
import com.example.a38633.newsapp.mvp.model.NewsListModel;
import com.example.a38633.newsapp.mvp.presenter.NewsListPresenter;
import com.example.a38633.newsapp.mvp.ui.LoadOnSxollListener;
import com.example.a38633.newsapp.mvp.ui.adapter.NewsItemDelagate;
import com.example.a38633.newsapp.mvp.ui.adapter.NewsListAdapter;
import com.example.a38633.newsapp.mvp.ui.adapter.PhotoNewsItemDelagate;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by 38633 on 2016/10/29.
 */

public class NewsListFragment extends BaseFragment<NewsListPresenter,NewsListModel> implements NewsListContract.View {
    @Bind(R.id.rc)
    RecyclerView mRc;
    @Bind(R.id.srl)
    SwipeRefreshLayout mSrl;

    private NewsListAdapter mNewsListAdapter;
    private List<NewsSummary> datas = new ArrayList<>();
    private LoadOnSxollListener mLoadOnSxollListener;


    private String mNewsId;
    private String mNewsType;
    private int mStartPage = 0;

    @Override
    protected int getLayoutResource() {
    return R.layout.fragment_news_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        if (getArguments() != null){
            mNewsId = getArguments().getString(AppConstant.NEWS_ID);
            mNewsType = getArguments().getString(AppConstant.NEWS_TYPE);
        }

        mSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){


            @Override
            public void onRefresh() {
                mStartPage = 0;
                mPresenter.getNewsListDataRequest11(mNewsType,mNewsId,mStartPage);

            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRc.setLayoutManager(layoutManager);
        mRc.setItemAnimator(new DefaultItemAnimator());
        mNewsListAdapter = new NewsListAdapter(getActivity(),datas);
        mNewsListAdapter.addItemViewDelegate(new NewsItemDelagate(getContext()));
        mNewsListAdapter.addItemViewDelegate(new PhotoNewsItemDelagate(getContext()));
        mRc.setAdapter(mNewsListAdapter);
        mLoadOnSxollListener = new LoadOnSxollListener(layoutManager) {
            @Override
            public void loadMore() {
                mPresenter.getNewsListDataRequest(mNewsType,mNewsId,mStartPage);

            }
        };
        mRc.addOnScrollListener(mLoadOnSxollListener);
        if (mNewsListAdapter.getSize() <= 0){
            mStartPage = 0 ;
            mPresenter.getNewsListDataRequest(mNewsType,mNewsId,mStartPage);
        }







    }

    @Override
    public void returnNewsListData(List<NewsSummary> newsSummaries) {
        if (newsSummaries != null){
            mStartPage += 20;
            if (newsSummaries.size() > 0){
                mNewsListAdapter.addData(newsSummaries);
            }
        }
        mLoadOnSxollListener.setLoading(false);
        mSrl.setRefreshing(false);
    }

    @Override
    public void returnNewsListDataall(List<NewsSummary> newsSummaries) {

            if (newsSummaries != null){
                mStartPage += 20;
                if (newsSummaries.size() > 0){
                    mNewsListAdapter.changeData(newsSummaries);
                }
            }
            mLoadOnSxollListener.setLoading(false);
            mSrl.setRefreshing(false);

    }


    @Override
    public void scrolltoTop() {
        mRc.smoothScrollToPosition(0);
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
