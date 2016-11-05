package com.example.a38633.newsapp.mvp.presenter;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.baserx.RxSubscriber;
import com.example.a38633.newsapp.bean.PhotoGirl;
import com.example.a38633.newsapp.mvp.contract.PhotoListContract;

import java.util.List;

/**
 * Created by 38633 on 2016/11/5.
 */

public class PhotoListPresenter extends PhotoListContract.Presenter{
    @Override
    public void getPhotosListDataRequest(int size, int page) {
        mRxMannager.add(mModel.getPhotosListData(size,page).subscribe(new RxSubscriber<List<PhotoGirl>>(context,false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(context.getString(R.string.loading));
            }
            @Override
            protected void _onNext(List<PhotoGirl> photoGirls) {
                mView.returnPhotosListData(photoGirls);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    protected void onStart() {

    }
}
