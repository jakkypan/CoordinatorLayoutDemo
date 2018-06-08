package com.pan.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 2018/6/7
 **/
public abstract class ToolBarBaseActivity extends AppCompatActivity {
    public Toolbar mToolbarTb;
    public AppBarLayout.LayoutParams params;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        mToolbarTb = findViewById(R.id.tb_toolbar);
        if (mToolbarTb.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            params = (AppBarLayout.LayoutParams) mToolbarTb.getLayoutParams();
        }
        if (mToolbarTb!=null) {
            setSupportActionBar(mToolbarTb);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        RecyclerView rv = findViewById(R.id.rv_content);

        rv.setLayoutManager(new LinearLayoutManager(this));

        List<String> data = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            data.add("item" + i);
        }
        rv.setAdapter(new MyAdapter(this, data));
    }
}
