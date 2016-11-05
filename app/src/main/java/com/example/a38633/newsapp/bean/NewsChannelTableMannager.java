package com.example.a38633.newsapp.bean;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.networks.ApiConstans;
import com.example.a38633.newsapp.utils.AppContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 38633 on 2016/10/28.
 */

public class NewsChannelTableMannager {
    public static List<NewsChannelTable> loadNewsChannelsMine(){
        List<String> channelName = Arrays.asList(AppContext.getInstance().getResources().getStringArray(R.array.news_channel_name));
        List<String> channelId = Arrays.asList(AppContext.getInstance().getResources().getStringArray(R.array.news_channel_id));
        ArrayList<NewsChannelTable> newsChannelTables = new ArrayList<>();
        for (int i = 0;i<channelName.size();i++){
            NewsChannelTable entity = new NewsChannelTable(channelName.get(i),channelId.get(i), ApiConstans.getType(channelId.get(i))
            ,i <=5,i,false);
            newsChannelTables.add(entity);
        }
        return newsChannelTables;
    }


    public static List<NewsChannelTable> loadNewsChannelsStatic(){
        List<String> channelName = Arrays.asList(AppContext.getInstance().getResources().getStringArray(R.array.news_channel_name_static));
        List<String> channelId = Arrays.asList(AppContext.getInstance().getResources().getStringArray(R.array.news_channel_id_static));
        ArrayList<NewsChannelTable> newsChannelTables = new ArrayList<>();
        for (int i = 0;i<channelName.size();i++){
            NewsChannelTable entity = new NewsChannelTable(channelName.get(i),channelId.get(i), ApiConstans.getType(channelId.get(i))
                    ,i <=7,i,false);
            newsChannelTables.add(entity);
        }
        return newsChannelTables;

    }
}
