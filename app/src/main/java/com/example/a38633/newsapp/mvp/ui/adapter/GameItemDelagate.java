package com.example.a38633.newsapp.mvp.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.bean.GameData;
import com.example.a38633.newsapp.mvp.ui.activity.GameDetailActivity;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by 38633 on 2016/11/6.
 */

public class GameItemDelagate implements ItemViewDelegate<GameData> {
    private Context mContext;

    public GameItemDelagate(Context context) {
        mContext = context;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_game_list;
    }

    @Override
    public boolean isForViewType(GameData item, int position) {
        return !TextUtils.isEmpty(item.getType());
    }

    @Override
    public void convert(final ViewHolder holder, final GameData gameData, int position) {
        String title = gameData.getTitle();
        if (title == null) {
            title = gameData.getTitle();

        }
        String creattime = gameData.getCreate_time();
        holder.setText(R.id.games_tv, title);
        holder.setText(R.id.game_times, creattime);
        if (gameData.getImg().size() > 0) {
            ImageView view = holder.getView(R.id.games_iv);
            Glide.with(mContext).load(gameData.getImg().get(0).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.ic_image_loading)
                    .error(R.drawable.ic_empty_picture)
                    .crossFade().into(view);
            holder.setOnClickListener(R.id.game_root, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GameDetailActivity.startAction(mContext,gameData.getUrl(),gameData.getTitle());
                }
            });
        }


    }
}
