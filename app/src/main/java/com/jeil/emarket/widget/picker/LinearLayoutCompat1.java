package com.jeil.emarket.widget.picker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.activities.baseactivity.BaseActivity;

/* renamed from: b.f.a.c.x.i */

public class LinearLayoutCompat1 extends LinearLayoutCompat {

    /* renamed from: q */
    public AppCompatImageView f8767q;

    /* renamed from: r */
    public MaterialRippleLayout f8768r;

    /* renamed from: s */
    public int f8769s;

    /* renamed from: t */
    public TextView f8770t;

    /* renamed from: u */
    public boolean f8771u;

    /* renamed from: v */
    public int f8772v;

    /* renamed from: w */
    public Drawable f8773w;

    /* renamed from: x */
    public Drawable f8774x;

    /* renamed from: y */
    public Drawable f8775y;

    public LinearLayoutCompat1(Context context) {
        super(context);
        this.f8769s = 0;
        this.f8771u = false;
        View inflate = LayoutInflater.from(context).inflate(R.layout.pickerview_area_item, (ViewGroup) this, false);
        setClickable(true);
        this.f8773w = getResources().getDrawable(R.drawable.ic_check_circle_2);
        this.f8774x = getResources().getDrawable(R.drawable.ic_circle);
        this.f8775y = getResources().getDrawable(R.drawable.ic_circle_minus);
        this.f8772v = getResources().getColor(BaseActivity.color);
        this.f8768r = (MaterialRippleLayout) inflate.findViewById(R.id.mrl_btn);
        this.f8770t = (TextView) inflate.findViewById(R.id.tv_content);
        this.f8767q = (AppCompatImageView) inflate.findViewById(R.id.iv_icon);
        this.f8767q.setClickable(true);
        addView(inflate);
    }

    public boolean getActiveStatus() {
        return this.f8771u;
    }

    public int getState() {
        return this.f8769s;
    }

    public String getText() {
        return this.f8770t.getText().toString();
    }

    /* renamed from: h */
    public void m4755h() {
        this.f8771u = true;
        this.f8770t.setTextColor(this.f8772v);
        this.f8767q.setBackgroundTintList(ColorStateList.valueOf(this.f8772v));
    }

    
    public void m4756i() {
        this.f8771u = false;
        this.f8770t.setTextColor(getResources().getColor(R.color.dark));
        this.f8767q.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark)));
    }

    public void setState(int i) {
        AppCompatImageView appCompatImageView;
        Drawable drawable;
        this.f8769s = i;
        if (i == 0) {
            appCompatImageView = this.f8767q;
            drawable = this.f8774x;
        } else if (i == 1) {
            appCompatImageView = this.f8767q;
            drawable = this.f8773w;
        } else {
            if (i != 2) {
                return;
            }
            appCompatImageView = this.f8767q;
            drawable = this.f8775y;
        }
        appCompatImageView.setBackground(drawable);
        this.f8767q.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark)));
    }

    public void setText(CharSequence charSequence) {
        this.f8770t.setText(charSequence);
    }
}
