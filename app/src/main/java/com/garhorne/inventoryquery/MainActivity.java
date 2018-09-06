package com.garhorne.inventoryquery;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivty {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] TitleList;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        /*viewPager = (ViewPager)findViewById(R.id.mainactvity_viewpager);
        tabLayout = (TabLayout)findViewById(R.id.mainactivity_tablayout);
        if (viewPager != null){
            Log.d("TAG1","viewpager不为空");
        }else {
            Log.d("TAG1","viewpager为空");
        }
        initData();
        initTab();*/
    }

    /*@Override
    protected void initViews(Bundle savedInstanceState) {
        viewPager = (ViewPager)findViewById(R.id.mainactvity_viewpager);
        tabLayout = (TabLayout)findViewById(R.id.mainactivity_tablayout);
        if (viewPager != null){
            Log.d("TAG1","viewpager不为空");
        }else {
            Log.d("TAG1","viewpager为空");
        }
        initData();
        initTab();
    }*/

    private void initViews() {
        viewPager = (ViewPager)findViewById(R.id.mainactvity_viewpager);
        tabLayout = (TabLayout)findViewById(R.id.mainactivity_tablayout);
        initData();
        initTab();
    }

    private void initData() {
        Resources res = getResources();
        TitleList = res.getStringArray(R.array.tablayout);
    }

    private void initTab() {
        fragmentList = new ArrayList<Fragment>();

        fragmentList.add(new HomeFragment());
        fragmentList.add(new RecordFragment());
        fragmentList.add(new UserFragment());

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),fragmentList,TitleList);

        /*if (viewPager != null){
            viewPager.setAdapter(myAdapter);
            Log.d("TAG","viewpager不为空");
            if (tabLayout != null){
                tabLayout.setupWithViewPager(viewPager);
                Log.d("TAG","tablayout不为空");
            }else {
                Log.d("TAG","tablayout为空");
            }
        }else {
            Log.d("TAG","viewpager为空");
        }*/
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0;i<3;i++){
            tabLayout.getTabAt(i).setText(TitleList[i]);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isShowBack() {
        return false;
    }
}
