package com.example.a38633.newsapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by 38633 on 2016/10/23.
 */

public class NetUtil {
    public static boolean isNetworkConncted(){
        if (AppContext.getInstance() != null){
            ConnectivityManager connectivityManager = (ConnectivityManager)AppContext.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
}
