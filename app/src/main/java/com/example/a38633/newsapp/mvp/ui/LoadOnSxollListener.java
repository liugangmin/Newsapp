package com.example.a38633.newsapp.mvp.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by 38633 on 2016/10/31.
 */

public abstract class LoadOnSxollListener extends RecyclerView.OnScrollListener {
    private LinearLayoutManager mLinearLayoutManager;

    public LoadOnSxollListener(LinearLayoutManager linearLayoutManager){
        mLinearLayoutManager = linearLayoutManager;
    }
    private boolean loading = false;
    public void setLoading(boolean loading){
        this.loading = loading;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int totalNumofItems = mLinearLayoutManager.getItemCount();
        int lastVisableItem = mLinearLayoutManager.findLastVisibleItemPosition();
        if (!loading && (lastVisableItem>totalNumofItems - 3) && dy >0){
            loadMore();
            loading = true;
        }
    }
    public abstract void loadMore();
}
