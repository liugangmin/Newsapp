package com.example.a38633.newsapp.mvp.presenter;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.baserx.RxSubscriber;
import com.example.a38633.newsapp.bean.NewsDetail;
import com.example.a38633.newsapp.mvp.contract.NewsDtailContract;
import com.example.a38633.newsapp.utils.ToastUtil;

/**
 * Created by 38633 on 2016/11/2.
 */

public class NewsDetailPresenter extends NewsDtailContract.Presenter {
    @Override
    public void getOneNewsDataRequest(String postId) {
       mRxMannager.add(mModel.getOneNewsData(postId).subscribe(new RxSubscriber<NewsDetail>(context) {
            @Override
            protected void _onNext(NewsDetail newsDetail) {
                mView.returnOneNewsData(newsDetail);
            }

            @Override
            protected void _onError(String message) {
                ToastUtil.showToastWithImg(message, R.drawable.ic_wrong);
            }
        }));
    }

    @Override
    protected void onStart() {

    }
}
