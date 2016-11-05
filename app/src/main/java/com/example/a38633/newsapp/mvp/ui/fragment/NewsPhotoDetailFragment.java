package com.example.a38633.newsapp.mvp.ui.fragment;

import android.view.View;
import android.widget.ProgressBar;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.base.BaseFragment;
import com.example.a38633.newsapp.baserx.RxSchedulers;
import com.example.a38633.newsapp.utils.PhotoLoadingUtils;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by 38633 on 2016/11/3.
 */

public class NewsPhotoDetailFragment extends BaseFragment {
    @Bind(R.id.photo_view)
    PhotoView photoView;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    private String mImgSrc;

    @Override
    protected int getLayoutResource() {
        return R.layout.news_photo_detail_fragment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            mImgSrc = getArguments().getString(AppConstant.PHOTO_DETAIL_IMGSRC);
        }
        initPhotoView();
        setPhotoViewClickEvent();

    }

    private void initPhotoView() {
        mRxMannager.add(Observable.timer(100, TimeUnit.MILLISECONDS) // 直接使用glide加载的话，activity切换动画时背景短暂为默认背景色
                .compose(RxSchedulers.<Long>io_main())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        PhotoLoadingUtils.displayBigPhoto(getContext(),photoView,mImgSrc);
                    }
                }));
    }

    private void setPhotoViewClickEvent() {
        photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float v, float v1) {
                mRxMannager.post(AppConstant.PHOTO_TAB_CLICK,"");
            }
        });
    }

}