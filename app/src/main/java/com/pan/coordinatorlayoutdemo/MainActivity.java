package com.pan.coordinatorlayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by panda on 2018/6/6
 **/
public class MainActivity extends AppCompatActivity {
    private String[] categories = {
            "FloatingActionButton和SnackBar配合的demo",
            "自定义Behavior，实现隐藏和消息，不依赖系统控件",
            "自定义Behavior，实现隐藏和消息，依赖AppBarLayout",
            "AppBarLayout 4种flags的效果",
            "Nest方式实现，系统和自定义效果",
            "dependency方式实现",
            "列表滚动跟随",
            "头部TabLayout",
            "CollapsingToolbarLayout的使用示例"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends BaseAdapter implements View.OnClickListener {

        @Override
        public int getCount() {
            return categories.length;
        }

        @Override
        public Object getItem(int position) {
            return categories[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Button button = null;
            if (convertView == null) {
                button = new Button(parent.getContext());
            } else {
                button = (Button) convertView;
            }

            button.setAllCaps(false);
            button.setText(getItem(position) + "");
            button.setId(position);
            button.setOnClickListener(this);
            return button;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case 0:
                    startActivity(new Intent(MainActivity.this, FloatingActionButtonSnackBar.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, CustomActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, CustomActivity2.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, AppBarLayoutFlagTest.class));
                    break;
                case 4:
                    startActivity(new Intent(MainActivity.this, NestedActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(MainActivity.this, FollowingDemo.class));
                    break;
                case 6:
                    startActivity(new Intent(MainActivity.this, ScrollDemo.class));
                    break;
                case 7:
                    startActivity(new Intent(MainActivity.this, TabLayoutTopActivity.class));
                    break;
                case 8:
                    startActivity(new Intent(MainActivity.this, CollapsingToolbarDemo.class));
                    break;
            }
        }
    }
}
