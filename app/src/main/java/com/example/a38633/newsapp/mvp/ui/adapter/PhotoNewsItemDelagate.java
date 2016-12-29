package com.example.a38633.newsapp.mvp.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.bean.NewsPhotoDetail;
import com.example.a38633.newsapp.bean.NewsSummary;
import com.example.a38633.newsapp.mvp.ui.activity.NewsPhotoDetailActivity;
import com.example.a38633.newsapp.app.AppContext;
import com.example.a38633.newsapp.utils.DisplayUtil;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 38633 on 2016/10/30.
 */

public class PhotoNewsItemDelagate implements ItemViewDelegate<NewsSummary> {
    private Context mContext;
    public PhotoNewsItemDelagate(Context context){
        mContext = context;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_news_photo;
    }

    @Override
    public boolean isForViewType(NewsSummary item, int position) {
        return TextUtils.isEmpty(item.getDigest());
    }

    @Override
    public void convert(ViewHolder holder, final NewsSummary newsSummary, int position) {
        String title = newsSummary.getTitle();
        String ptime = newsSummary.getPtime();
        holder.setText(R.id.news_summary_title_tv,title);
        holder.setText(R.id.news_summary_ptime_tv,ptime);
        setImageView(holder,newsSummary);
        holder.setOnClickListener(R.id.ll_root, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsPhotoDetailActivity.startAction(mContext,getPhotoDetail(newsSummary));
            }
        });

    }
    @SuppressLint("StringFormatInvalid")
    private void setImageView(ViewHolder holder,NewsSummary newsSummary){
        int PhotoThreeHeight =  DisplayUtil.dip2px(90);
        int PhotoTwoHeight =  DisplayUtil.dip2px(120);
        int PhotoOneHeight =  DisplayUtil.dip2px(150);

        String imgScrLeft = null;
        String imgScrMiddle = null;
        String imgScrRight = null;
        LinearLayout  news_summary_photo_tv_group=holder.getView(R.id.news_summary_photo_iv_group);
        ViewGroup.LayoutParams layoutParams = null;
        layoutParams = news_summary_photo_tv_group.getLayoutParams();

        if (newsSummary.getAds() != null){
            List<NewsSummary.AdsBean> adsBeanList = newsSummary.getAds();
            int size = adsBeanList.size();
            if (size>=3){
                imgScrLeft = adsBeanList.get(0).getImgsrc();
                imgScrMiddle = adsBeanList.get(1).getImgsrc();
                imgScrRight = adsBeanList.get(2).getImgsrc();
                layoutParams.height = PhotoThreeHeight;
                holder.setText(R.id.news_summary_title_tv, AppContext.getInstance().getString(R.string.photo_collections,adsBeanList.get(0).getTitle()));
            }else if (size >= 2){
                imgScrLeft = adsBeanList.get(0).getImgsrc();
                imgScrMiddle = adsBeanList.get(1).getImgsrc();

                layoutParams.height = PhotoTwoHeight;
            }else if (size >= 1){
                imgScrLeft = adsBeanList.get(0).getImgsrc();
                layoutParams.height = PhotoOneHeight;
            }

        }else if (newsSummary.getImgextra() != null){
            int size = newsSummary.getImgextra().size();

            if (size>=3){
                imgScrLeft = newsSummary.getImgextra().get(0).getImgsrc();
                imgScrMiddle = newsSummary.getImgextra().get(1).getImgsrc();
                imgScrRight = newsSummary.getImgextra().get(2).getImgsrc();
                layoutParams.height = PhotoOneHeight;
            }else if (size >= 2){
                imgScrLeft = newsSummary.getImgextra().get(0).getImgsrc();
                imgScrMiddle = newsSummary.getImgextra().get(1).getImgsrc();

                layoutParams.height = PhotoTwoHeight;
            }else if (size >= 1){
                imgScrLeft = newsSummary.getImgextra().get(0).getImgsrc();
                layoutParams.height = PhotoThreeHeight;
            }

        }else {
            imgScrLeft = newsSummary.getImgsrc();
            layoutParams.height = PhotoOneHeight;
        }
        setPhotoImageView(holder,imgScrLeft,imgScrMiddle,imgScrRight);
        news_summary_photo_tv_group.setLayoutParams(layoutParams);
}
    private void setPhotoImageView(ViewHolder holder,String imgScrLeft,String imgScrMiddle,String imgScrRight){
        if (imgScrLeft != null){
            holder.setVisible(R.id.news_summary_photo_iv_left,true);
            ImageView view = holder.getView(R.id.news_summary_photo_iv_left);
            Glide.with(mContext).load(imgScrLeft)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.ic_image_loading)
                    .error(R.drawable.ic_empty_picture)
                    .crossFade().into(view);
        }else {
            holder.setVisible(R.id.news_summary_photo_iv_left,false);
        }
        if (imgScrMiddle != null){
            holder.setVisible(R.id.news_summary_photo_iv_middle,true);
            ImageView view = holder.getView(R.id.news_summary_photo_iv_middle);
            Glide.with(mContext).load(imgScrMiddle)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.ic_image_loading)
                    .error(R.drawable.ic_empty_picture)
                    .crossFade().into(view);
        }else {
            holder.setVisible(R.id.news_summary_photo_iv_middle,false);
        }
        if (imgScrRight != null){
            holder.setVisible(R.id.news_summary_photo_iv_right,true);
            ImageView view = holder.getView(R.id.news_summary_photo_iv_right);
            Glide.with(mContext).load(imgScrRight)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.ic_image_loading)
                    .error(R.drawable.ic_empty_picture)
                    .crossFade().into(view);
        }else {
            holder.setVisible(R.id.news_summary_photo_iv_right,false);
        }
    }
    private NewsPhotoDetail getPhotoDetail(NewsSummary newsSummary) {
        NewsPhotoDetail newsPhotoDetail = new NewsPhotoDetail();
        newsPhotoDetail.setTitle(newsSummary.getTitle());
        setPictures(newsSummary, newsPhotoDetail);
        return newsPhotoDetail;
    }
    private void setPictures(NewsSummary newsSummary, NewsPhotoDetail newsPhotoDetail) {
        List<NewsPhotoDetail.Picture> pictureList = new ArrayList<>();
        if (newsSummary.getAds() != null) {
            for (NewsSummary.AdsBean entity : newsSummary.getAds()) {
                setValuesAndAddToList(pictureList, entity.getTitle(), entity.getImgsrc());
            }
        } else if (newsSummary.getImgextra() != null) {
            for (NewsSummary.ImgextraBean entity : newsSummary.getImgextra()) {
                setValuesAndAddToList(pictureList, null, entity.getImgsrc());
            }
        } else {
            setValuesAndAddToList(pictureList, null, newsSummary.getImgsrc());
        }

        newsPhotoDetail.setPictures(pictureList);
    }
    private void setValuesAndAddToList(List<NewsPhotoDetail.Picture> pictureList, String title, String imgsrc) {
        NewsPhotoDetail.Picture picture = new NewsPhotoDetail.Picture();
        if (title != null) {
            picture.setTitle(title);
        }
        picture.setImgSrc(imgsrc);

        pictureList.add(picture);
    }
}
