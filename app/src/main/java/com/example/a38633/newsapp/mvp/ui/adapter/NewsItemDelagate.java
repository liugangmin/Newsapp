package com.example.a38633.newsapp.mvp.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.bean.NewsSummary;
import com.example.a38633.newsapp.mvp.ui.activity.NewsDetailActivity;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by 38633 on 2016/10/30.
 */

public class NewsItemDelagate implements ItemViewDelegate<NewsSummary> {
    private Context mContext;

    public NewsItemDelagate(Context context){mContext = context;}
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_news;
    }

    @Override
    public boolean isForViewType(NewsSummary item, int position) {
        return  !TextUtils.isEmpty(item.getDigest());
    }
    @Override
    public void convert(final ViewHolder holder, final NewsSummary newsSummary, int position) {
        String title = newsSummary.getTitle();
        if (title == null){
            title = newsSummary.getTitle();
        }
        String ptime = newsSummary.getPtime();
        String digest = newsSummary.getDigest();

        holder.setText(R.id.news_summary_title_tv,title);
        holder.setText(R.id.news_summary_ptime_tv,ptime);
        holder.setText(R.id.news_summary_digest_tv,ptime);
        ImageView view = holder.getView(R.id.news_summary_photo_iv);
        Glide.with(mContext).load(newsSummary.getImgsrc())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(view);

        holder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailActivity.startAction(mContext,holder.getView(R.id.news_summary_photo_iv),newsSummary.getPostid(),newsSummary.getImgsrc());
            }
        });
    }

}
