package com.jeil.emarket.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;


@SuppressLint({"AppCompatCustomView"})

public class GradientScrollLayout extends FrameLayout {

    
    public LinearLayoutCompat f12025b;

    
    public LinearLayoutCompat f12026c;

    
    public LinearLayoutCompat f12027d;

    public GradientScrollLayout(Context context) {
        super(context);
        m6823a(context);
    }

    public GradientScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6823a(context);
    }

    public GradientScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6823a(context);
    }


    public void m6823a(Context context) {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f12025b = new LinearLayoutCompat(context);
        horizontalScrollView.setScrollBarSize(0);
        horizontalScrollView.addView(this.f12025b);
        this.f12026c = new LinearLayoutCompat(context);
        this.f12026c.setLayoutParams(new FrameLayout.LayoutParams(Util.dp2px(context, 30), -1));
        this.f12026c.setBackgroundResource(R.drawable.grad_white_left_right);
        this.f12026c.setVisibility(View.GONE);
        this.f12027d = new LinearLayoutCompat(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Util.dp2px(context, 30), -1);
        layoutParams.gravity = 8388613;
        this.f12027d.setLayoutParams(layoutParams);
        this.f12027d.setBackgroundResource(R.drawable.grad_white_right_left);
        this.f12026c.setVisibility(View.GONE);
        if (Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: b.f.a.c.a
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    GradientScrollLayout.this.m6825a(view, i, i2, i3, i4);
                }
            });
        }
        addView(horizontalScrollView);
        addView(this.f12026c);
        addView(this.f12027d);
    }


    public void m6824a(View view) {
        this.f12025b.addView(view);
    }


    public  void m6825a(View view, int i, int i2, int i3, int i4) {
        if (view.canScrollHorizontally(-1)) {
            this.f12026c.setVisibility(View.VISIBLE);
        } else {
            this.f12026c.setVisibility(View.GONE);
        }
        if (view.canScrollHorizontally(1)) {
            this.f12027d.setVisibility(View.VISIBLE);
        } else {
            this.f12027d.setVisibility(View.GONE);
        }
    }

    public LinearLayoutCompat getLeftLayout() {
        return this.f12026c;
    }

    public LinearLayoutCompat getRightLayout() {
        return this.f12027d;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.f12025b.removeAllViews();
    }
}
