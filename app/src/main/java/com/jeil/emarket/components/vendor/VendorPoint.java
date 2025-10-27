package com.jeil.emarket.components.vendor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;

import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.activities.baseactivity.BaseActivity;

@SuppressLint({"AppCompatCustomView"})

public class VendorPoint extends LinearLayoutCompat {

    /* renamed from: q */
    public float f12330q;

    /* renamed from: r */
    public TextView f12331r;

    /* renamed from: s */
    public ImageView f12332s;

    public VendorPoint(Context context) {
        super(context);
        this.f12330q = 0.0f;
    }

    public VendorPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12330q = 0.0f;
        m6981a(context, attributeSet);
    }

    public VendorPoint(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12330q = 0.0f;
        m6981a(context, attributeSet);
    }

    @SuppressLint({"DefaultLocale"})
    
    public void m6980a(float f, float f2) {
        java.lang.String valueOf = java.lang.String.valueOf((float) (Math.floor(10.0f * f) / 10.0d));
        this.f12330q = f;
        this.f12332s.setVisibility(f == f2 ? View.GONE : View.VISIBLE);
        if (f != f2) {
            this.f12332s.setImageDrawable(Util.getDrawable(getResources(), f > f2 ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down, (Resources.Theme) null));
            this.f12332s.setImageTintList(ColorStateList.valueOf(getResources().getColor(f >= 4.5f ? BaseActivity.color : R.color.black)));
        } else if (f != 0.0f) {
            valueOf = CustomString.append(valueOf, " =");
        } else {
            ((LinearLayoutCompat.LayoutParams) this.f12331r.getLayoutParams()).setMargins(Util.dp2px(getContext(), 10), 0, Util.dp2px(getContext(), 8), 0);
        }
        this.f12331r.setTextColor(getResources().getColor(f >= 4.5f ? BaseActivity.color : R.color.dark));
        this.f12331r.setText(valueOf);
    }

    
    public void m6981a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VendorLevel);
            this.f12330q = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
            this.f12331r = new TextView(context);
            this.f12331r.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            this.f12331r.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            this.f12331r.setTextSize(1, 14.0f);
            this.f12331r.setText("0.0");
            this.f12331r.setTextColor(getResources().getColor(this.f12330q >= 4.5f ? BaseActivity.anInt2 : R.color.black));
            ((LinearLayoutCompat.LayoutParams) this.f12331r.getLayoutParams()).setMargins(Util.dp2px(getContext(), 10), 0, 0, 0);
            addView(this.f12331r);
            this.f12332s = new ImageView(context);
            this.f12332s.setImageDrawable(Util.getDrawable(getResources(), R.drawable.ic_arrow_up, (Resources.Theme) null));
            BaseActivity activityC1391g1 = (BaseActivity) context;
            int m4299b = activityC1391g1.m4299b(3);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ((LinearLayout.LayoutParams) c0541a).width = activityC1391g1.m4299b(12);
            ((LinearLayout.LayoutParams) c0541a).height = activityC1391g1.m4299b(12);
            c0541a.setMargins(m4299b, 0, m4299b, 0);
            this.f12332s.setLayoutParams(c0541a);
            addView(this.f12332s);
            setGravity(17);
        }
    }
}
