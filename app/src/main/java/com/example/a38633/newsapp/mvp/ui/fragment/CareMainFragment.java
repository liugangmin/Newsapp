package com.example.a38633.newsapp.mvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.base.BaseFragment;
import com.example.a38633.newsapp.bean.GameData;
import com.example.a38633.newsapp.mvp.contract.GameListContract;
import com.example.a38633.newsapp.mvp.model.GameListMModel;
import com.example.a38633.newsapp.mvp.presenter.GameListPresenter;
import com.example.a38633.newsapp.mvp.ui.adapter.GameItemDelagate;
import com.example.a38633.newsapp.mvp.ui.adapter.GameListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 38633 on 2016/11/4.
 */

public class CareMainFragment extends BaseFragment<GameListPresenter, GameListMModel> implements GameListContract.View {

    @Bind(R.id.game_rec)
    RecyclerView mGameRec;
    @Bind(R.id.game_toolbar)
    Toolbar mGameToolbar;
    @Bind(R.id.game_ref)
    SwipeRefreshLayout mGameRef;
    private GameListAdapter mGameListAdapter;
    private List<GameData> datas = new ArrayList<>();


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_care_main;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);

    }

    @Override
    protected void initView() {
        mGameRef.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getGameListDataRequest();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mGameRec.setLayoutManager(manager);
        mGameListAdapter = new GameListAdapter(getActivity(),datas);
        mGameListAdapter.addItemViewDelegate(new GameItemDelagate(getContext()));
        mGameRec.setAdapter(mGameListAdapter);

        if (mGameListAdapter.getSize() <= 0){
            mPresenter.getGameListDataRequest();
        }

    }

    @Override
    public void returnGameListData(List<GameData> gameDatas) {
        if (gameDatas != null){

            if (gameDatas.size() > 0){
                mGameListAdapter.addData(gameDatas);
            }
        }

        mGameRef.setRefreshing(false);

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



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}