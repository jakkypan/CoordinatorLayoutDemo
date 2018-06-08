package com.pan.coordinatorlayoutdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 不依赖appbarlayout，单独的实现随着listview滚动跟随着消失
 *
 * Created by panda on 2018/6/6
 **/
public class CustomActivity extends AppCompatActivity {
    private int moveY = 0;
    private int max = 0;

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_content);

        final CustomTransparentLinearLayout linearLayout = findViewById(R.id.transparent);

        rv.setLayoutManager(new LinearLayoutManager(this));

        max = dip2px(this, 56);

        List<String> data = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            data.add("item" + i);
        }
        rv.setAdapter(new MyAdapter(this, data));
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && moveY > -max) {
                    moveY -= dy;
                    linearLayout.setTranslationY(moveY);
                } else if (dy < 0 && moveY < 0) {
                    moveY -= dy;
                    if (moveY > 0) {
                        moveY = 0;
                    }
                    linearLayout.setTranslationY(moveY);
                }
            }
        });
    }

}
