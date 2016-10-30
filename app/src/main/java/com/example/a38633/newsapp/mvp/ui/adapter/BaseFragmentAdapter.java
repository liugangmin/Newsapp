package com.example.a38633.newsapp.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.a38633.newsapp.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 38633 on 2016/10/28.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private List<String> mTitles;
    public BaseFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }
    public BaseFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> mTitles) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mTitles= mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return !CollectionUtils.isNullEmpty(mTitles)? mTitles.get(position):"";
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
