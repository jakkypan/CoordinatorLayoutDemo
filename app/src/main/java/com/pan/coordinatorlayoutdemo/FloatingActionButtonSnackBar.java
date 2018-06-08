package com.pan.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 2018/6/6
 **/
public class FloatingActionButtonSnackBar extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));

        List<String> data = new ArrayList<>();
        for(int i = 0; i < 50; i++)
        {
            data.add("item" + i);
        }
        rv.setAdapter(new MyAdapter(this, data));
    }

    public void clickMe(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(findViewById(R.id.contentView), "Snackbar", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}
