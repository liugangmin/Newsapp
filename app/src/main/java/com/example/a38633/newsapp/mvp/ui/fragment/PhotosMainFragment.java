package com.example.a38633.newsapp.mvp.ui.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.base.BaseFragment;
import com.example.a38633.newsapp.bean.PhotoGirl;
import com.example.a38633.newsapp.mvp.contract.PhotoListContract;
import com.example.a38633.newsapp.mvp.model.PhotoListModel;
import com.example.a38633.newsapp.mvp.presenter.PhotoListPresenter;
import com.example.a38633.newsapp.mvp.ui.LoadOnSxollListener;
import com.example.a38633.newsapp.mvp.ui.adapter.PhotoItemDelagate;
import com.example.a38633.newsapp.mvp.ui.adapter.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by 38633 on 2016/11/4.
 */

public class PhotosMainFragment extends BaseFragment<PhotoListPresenter, PhotoListModel> implements PhotoListContract.View {
    @Bind(R.id.photo_toolbar)
    Toolbar mPhotoToolbar;
    @Bind(R.id.photo_fab)
    FloatingActionButton mPhotoFab;
    @Bind(R.id.photo_recview)
    RecyclerView mPhotoRecview;
    @Bind(R.id.refresh)
    SwipeRefreshLayout mSrl;
    private PhotoListAdapter adapter;
    private List<PhotoGirl> datas = new ArrayList<>();
    private LoadOnSxollListener mLoadOnSxollListener;
    private static int SIZE = 20;
    private int mStartPage = 1;
    public int size = 40;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_photo_main;

    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {

        mSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mStartPage = 0;
                mPresenter.getPhotosListDataRequest(size,mStartPage);
            }
        });
        GridLayoutManager Manager = new GridLayoutManager(getContext(),2);
        mPhotoRecview.setLayoutManager(Manager);
        adapter = new PhotoListAdapter(getActivity(),datas);
        adapter.addItemViewDelegate(new PhotoItemDelagate(getContext()));
        mPhotoRecview.setAdapter(adapter);
        mLoadOnSxollListener = new LoadOnSxollListener(Manager) {
            @Override
            public void loadMore() {
                mPresenter.getPhotosListDataRequest(size,mStartPage);

            }
        };
        mPhotoRecview.addOnScrollListener(mLoadOnSxollListener);
        if (adapter.getSize() <= 0){
            mStartPage = 0 ;
            mPresenter.getPhotosListDataRequest(size,mStartPage);
        }

    }


    @Override
    public void returnPhotosListData(List<PhotoGirl> photoGirls) {
        if (photoGirls != null){
            mStartPage += 20;
            if (photoGirls.size() > 0){
                adapter.addData(photoGirls);
            }
        }
        mLoadOnSxollListener.setLoading(false);
        mSrl.setRefreshing(false);

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
