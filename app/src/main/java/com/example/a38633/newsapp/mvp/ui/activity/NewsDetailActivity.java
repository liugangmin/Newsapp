package com.example.a38633.newsapp.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.app.AppConstant;
import com.example.a38633.newsapp.base.BaseActivity;
import com.example.a38633.newsapp.baserx.RxSchedulers;
import com.example.a38633.newsapp.bean.NewsDetail;
import com.example.a38633.newsapp.mvp.contract.NewsDtailContract;
import com.example.a38633.newsapp.mvp.model.NewsDtialModle;
import com.example.a38633.newsapp.mvp.presenter.NewsDetailPresenter;
import com.example.a38633.newsapp.utils.TimeUtil;
import com.example.a38633.newsapp.utils.URLImageGetter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;

import static com.example.a38633.newsapp.R.id.fab;
import static com.example.a38633.newsapp.R.id.toolbar;

/**
 * Created by 38633 on 2016/11/2.
 */

public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter, NewsDtialModle> implements NewsDtailContract.View {

    @Bind(R.id.news_detail_photo_iv)
    ImageView mNewsDetailPhotoIv;
    @Bind(R.id.mask_view)
    View mMaskView;
    @Bind(toolbar)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout mAppBar;
    @Bind(R.id.news_detail_from_tv)
    TextView mNewsDetailFromTv;
    @Bind(R.id.news_detail_body_tv)
    TextView mNewsDetailBodyTv;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Bind(fab)
    FloatingActionButton mFab;
    private String postId;
    private URLImageGetter mURLImageGetter;
    private String mNewsTitle;
    private String mShareLink;
    public static void startAction(Context mcontext,View view,String postId,String imgUrl){
        Intent intent = new Intent(mcontext,NewsDetailActivity.class);
        intent.putExtra(AppConstant.NEWS_POST_ID,postId);
        intent.putExtra(AppConstant.NEWS_IMG_RES,imgUrl);
        Log.d("here", "startAction: 1");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation((Activity) mcontext,view,AppConstant.TRANSITION_ANIMATION_NEWS_PHOTOS);
            Log.d("here", "startAction: 2");
            //mcontext.startActivity(intent,options.toBundle());
            mcontext.startActivity(intent);
        }else {
            ActivityOptionsCompat options = ActivityOptionsCompat
                    .makeScaleUpAnimation(view,view.getWidth()/2,view.getHeight()/2,0,0);
            Log.d("here", "startAction: 3");
            ActivityCompat.startActivity((Activity) mcontext,intent,options.toBundle());
        }
    }

    @Override
    protected int getLayoutId() {
        Log.d("here", "getLayoutId: ");
        return R.layout.news_detail_activity;
    }


    @Override
    protected void initView() {
        Log.d("here", "initView: ");
        postId = getIntent().getStringExtra(AppConstant.NEWS_POST_ID);
        mPresenter.getOneNewsDataRequest(postId);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
        mToolbar.inflateMenu(R.menu.news_detail);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_web_view:
                    //    NewsBrowserActivity.startAction(NewsDetailActivity.this, mShareLink, mNewsTitle);
                        break;
                    case R.id.action_browser:
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        if (canBrowse(intent)) {
                            Uri uri = Uri.parse(mShareLink);
                            intent.setData(uri);
                            startActivity(intent);
                        }
                        break;
                }
                return true;
            }
        });
        //分享
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mShareLink == null) {
                    mShareLink = "";
                }
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, "分享内容");
                startActivity(Intent.createChooser(intent, getTitle()));
            }
        });


    }


    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mMoldel);

    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public void returnOneNewsData(NewsDetail newsDetail) {
        mShareLink = newsDetail.getShareLink();
        mNewsTitle = newsDetail.getTitle();
        String newsSource = newsDetail.getSource();
        String newsTime = TimeUtil.formatDate(newsDetail.getPtime());
        String newsBody = newsDetail.getBody();
        String NewsImgSrc = getImgSrcs(newsDetail);

        setToolBarLayout(mNewsTitle);
        //mNewsDetailTitleTv.setText(newsTitle);
        mNewsDetailFromTv.setText(getString(R.string.news_from,newsSource,newsTime));
        setNewsDetailPhotoIv(NewsImgSrc);
        setNewsDetailBodyTv(newsDetail, newsBody);

    }
    private void setToolBarLayout(String newsTitle){
        mToolbarLayout.setTitle(newsTitle);
        mToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        mToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.primary_text_white));
    }
    private void setNewsDetailPhotoIv(String imgSrc){
        Glide.with(this).load(imgSrc)
                .fitCenter()
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(mNewsDetailPhotoIv);
    }
    private void setNewsDetailBodyTv(final NewsDetail newsDetail,final String newsBody){
        mRxMannager.add(Observable.timer(500, TimeUnit.MILLISECONDS)
                .compose(RxSchedulers.<Long>io_main())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        mProgressBar.setVisibility(View.GONE);
                        mFab.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        setBody(newsDetail, newsBody);
                    }
                }));

    }
    private void setBody(NewsDetail newsDetail, String newsBody) {
        int imgTotal = newsDetail.getImg().size();
        if (isShowBody(newsBody, imgTotal)) {
//              mNewsDetailBodyTv.setMovementMethod(LinkMovementMethod.getInstance());//加这句才能让里面的超链接生效,实测经常卡机崩溃
            mURLImageGetter = new URLImageGetter(mNewsDetailBodyTv, newsBody, imgTotal);
            mNewsDetailBodyTv.setText(Html.fromHtml(newsBody, mURLImageGetter, null));
        } else {
            mNewsDetailBodyTv.setText(Html.fromHtml(newsBody));
        }
    }
    private boolean isShowBody(String newsBody, int imgTotal) {
        return imgTotal >= 2 && newsBody != null;
    }

    private String getImgSrcs(NewsDetail newsDetail) {
        List<NewsDetail.ImgBean> imgSrcs = newsDetail.getImg();
        String imgSrc;
        if (imgSrcs != null && imgSrcs.size() > 0) {
            imgSrc = imgSrcs.get(0).getSrc();
        } else {
            imgSrc = getIntent().getStringExtra(AppConstant.NEWS_IMG_RES);
        }
        return imgSrc;
    }

    private boolean canBrowse(Intent intent) {
        return intent.resolveActivity(getPackageManager()) != null && mShareLink != null;
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
