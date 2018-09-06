package com.garhorne.inventoryquery;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {

    private List<Fragment> mfragmentList;
    private String[] mTitleList;

    public MyAdapter(FragmentManager fm,List<Fragment> fragmentList,String[] titleList) {
        super(fm);
        this.mfragmentList = fragmentList;
        this.mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList[position];
    }
}
