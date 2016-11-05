package com.example.a38633.newsapp.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 38633 on 2016/11/4.
 */

public interface OnItemClickListener<T>
{
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}