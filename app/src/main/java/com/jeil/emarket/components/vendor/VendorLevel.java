package com.jeil.emarket.components.vendor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.custom.font.CredValue;

@SuppressLint({"AppCompatCustomView"})

public class VendorLevel extends LinearLayout {


    public int f12326b;


    public int f12327c;


    public int f12328d;


    public int f12329e;

    public VendorLevel(Context context) {
        super(context);
        this.f12326b = 0;
        this.f12327c = 0;
        this.f12328d = 0;
        this.f12329e = 40;
    }

    public VendorLevel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12326b = 0;
        this.f12327c = 0;
        this.f12328d = 0;
        this.f12329e = 40;
        m6979a(context, attributeSet);
    }

    public VendorLevel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12326b = 0;
        this.f12327c = 0;
        this.f12328d = 0;
        this.f12329e = 40;
        m6979a(context, attributeSet);
    }


    public void m6978a(int i, Context context) {
        int i2;
        this.f12327c = CredValue.m5616a(i);
        int i3 = 0;
        while (true) {
            int[] iArr = CredValue.f10442a;
            if (i3 >= iArr.length) {
                i2 = 0;
                break;
            } else {
                if (iArr[i3] > i) {
                    i2 = i3 % 5;
                    break;
                }
                i3++;
            }
        }
        if (i2 == 0 && i > 0) {
            i2 = 5;
        }
        this.f12328d = i2;
        int i4 = R.drawable.bitmap_level1;
        int i5 = this.f12327c;
        if (i5 == 2) {
            i4 = R.drawable.bitmap_level2;
        } else if (i5 == 3) {
            i4 = R.drawable.bitmap_level3;
        } else if (i5 == 4) {
            i4 = R.drawable.bitmap_level4;
        }
        removeAllViews();
        for (int i6 = 0; i6 < 5; i6++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(Util.getDrawable(getResources(), i4, (Resources.Theme) null));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int i7 = this.f12329e;
            imageView.setLayoutParams(new LinearLayout.LayoutParams(i7 - 2, i7));
            if (i6 >= this.f12328d) {
                imageView.setAlpha(0.3f);
            }
            addView(imageView);
        }
    }


    public void m6979a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VendorLevel);
            this.f12326b = obtainStyledAttributes.getInteger(R.styleable.VendorLevel_point, 0);
            this.f12329e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.VendorLevel_size, 40);
            obtainStyledAttributes.recycle();
            m6978a(this.f12326b, context);
        }
    }

    public void setMedalSize(int i) {
        this.f12329e = i;
    }
}
