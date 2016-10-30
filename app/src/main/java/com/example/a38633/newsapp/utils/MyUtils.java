package com.example.a38633.newsapp.utils;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 38633 on 2016/10/28.
 */

public class MyUtils {
    public static void dynamicSetTabLayoutMode(TabLayout tabLayout){
        int tabwidth = calculateTabwidth(tabLayout);
        int screenwidth = getScteenwith();
        if (tabwidth <= screenwidth){
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        }else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }
    public static int calculateTabwidth(TabLayout tabLayout){
        int tabwidth = 0;
        for(int i = 0 ;i<tabLayout.getChildCount();i++){
            final View view = tabLayout.getChildAt(i);
            view.measure(0,0);
            tabwidth += view.getMeasuredWidth();
        }
        return tabwidth;
    }
    public static int getScteenwith(){
        return AppContext.getInstance().getResources().getDisplayMetrics().widthPixels;
    }
    public static View getRootView(Activity context){
        return ((ViewGroup)context.findViewById(android.R.id.content)).getChildAt(0);
    }
}
