package com.garhorne.inventoryquery;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public abstract class BaseActivty extends AppCompatActivity {

    private Toolbar toolbar;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        initContentView(getLayout());
        initToolbar(this);
        setBackIcon();
        //initViews(savedInstanceState);
    }

    //protected abstract void initViews(Bundle savedInstanceState);

    private void initContentView(int layoutResId){
        /*ViewGroup viewGroup = (ViewGroup)findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(linearLayout);
        LayoutInflater.from(this).inflate(layoutResId,linearLayout,true);*/
        linearLayout = (LinearLayout)findViewById(R.id.linear_layout);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layoutResId,null);
        linearLayout.addView(view);
    }

    /*@Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID,linearLayout,true);
        //LayoutInflater.from(this).inflate(layoutResID,frameLayout,true);
    }*/

    private void initToolbar(AppCompatActivity activity){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
    }

    protected abstract int getLayout();

    private void setBackIcon(){
        if (getToolbar() != null && isShowBack()){
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null){
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
                default:
                    break;
        }
        return true;
    }

    protected boolean isShowBack() {
        return true;
    }

    private Toolbar getToolbar() {
        return (Toolbar)findViewById(R.id.toolbar);
    }


}
