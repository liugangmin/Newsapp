package com.example.a38633.newsapp.base;

/**
 * Created by 38633 on 2016/10/22.
 */

public interface BaseView {
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);

}
