package com.jeil.emarket.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: b.f.a.c.v */

public class ViewGroupEx extends ViewGroup {
    public ViewGroupEx(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != View.GONE) {
                childAt.layout(0, 0, i3 - i, i4 - i2);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            int measuredWidth = childAt.getMeasuredWidth();
            i3++;
            i5 = childAt.getMeasuredHeight();
            i4 = measuredWidth;
        }
        setMeasuredDimension(i4, i5);
    }

    public void setView(View view) {
        if (getChildCount() != 0) {
            removeViewAt(0);
        }
        addView(view, 0);
    }
}
