package com.pan.coordinatorlayoutdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 这个是为了构建一个dependency view，来使得child view可以发生移动
 *
 * Created by panda on 2018/6/6
 **/
@CoordinatorLayout.DefaultBehavior(CustomTransparentLinearLayout.Behavior.class)
public class CustomTransparentLinearLayout extends LinearLayout {
    public CustomTransparentLinearLayout(Context context) {
        super(context);
    }

    public CustomTransparentLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public static class Behavior extends CoordinatorLayout.Behavior {
        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
            return dependency instanceof CustomTransparentLinearLayout;
        }
    }
}
