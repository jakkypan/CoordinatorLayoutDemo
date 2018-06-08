package com.pan.coordinatorlayoutdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by panda on 2018/6/6
 **/
public class CustomVisibleBehavior extends CoordinatorLayout.Behavior {
    public CustomVisibleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof CustomTransparentLinearLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int delta = (int) dependency.getTranslationY();
        child.setTranslationY(-delta);
        return true;
    }
}
