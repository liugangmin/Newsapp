package com.example.a38633.newsapp.mvp.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.bean.PhotoGirl;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by 38633 on 2016/11/5.
 */

public class PhotoItemDelagate implements ItemViewDelegate<PhotoGirl> {
    private Context mContext;
    public PhotoItemDelagate(Context context){mContext = context;}
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_photo_list;
    }

    @Override
    public boolean isForViewType(PhotoGirl item, int position) {
        return  !TextUtils.isEmpty(item.getDesc());
    }

    @Override
    public void convert(final ViewHolder holder, final PhotoGirl photoGirl, int position) {
        ImageView view = holder.getView(R.id.photo_iv_left);


        Glide.with(mContext).load(photoGirl.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(view);


//        holder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NewsDetailActivity.startAction(context, holder.getView(R.id.photo_iv_left), photoGirl.get_id(), photoGirl.getUrl());
//            }
 //       });
    }
}
