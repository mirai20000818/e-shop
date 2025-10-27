package com.jeil.emarket.widget.layout2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.ShopFilter;

/* renamed from: b.f.a.c.i0.q */

public class LinearLayoutCompat4 extends LinearLayoutCompat {

    /* renamed from: q */
    public String f8435q;

    /* renamed from: r */
    public String f8436r;

    /* renamed from: s */
    public BaseActivity f8437s;

    /* renamed from: t */
    public View.OnClickListener f8438t;

    public LinearLayoutCompat4(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f8435q = "";
        this.f8436r = "";
        this.f8437s = activityC1391g1;
    }


    public  void m4650a(View view) {
        this.f8438t.onClick(view);
    }


    public void m4651a(String str, String str2) {
        this.f8435q = str;
        this.f8436r = str2;
        m4652h();
    }

    /* renamed from: h */
    public void m4652h() {
        MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this.f8437s);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f8437s);
        linearLayoutCompat.setBackgroundResource(R.drawable.bg_primary_round20);
        linearLayoutCompat.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        linearLayoutCompat.setPadding(Util.dp2px((Context) this.f8437s, 13), 0, Util.dp2px((Context) this.f8437s, 10), 0);
        linearLayoutCompat.setGravity(16);
        if (!this.f8435q.isEmpty()) {
            TextView textView = new TextView(this.f8437s);
            textView.setText(this.f8435q + ":");
            textView.setTextSize(1, 11.0f);
            textView.setPadding(0, Util.dp2px((Context) this.f8437s, 6), Util.dp2px((Context) this.f8437s, 3), Util.dp2px((Context) this.f8437s, 6));
            linearLayoutCompat.addView(textView);
        }
        TextView textView2 = new TextView(this.f8437s);
        textView2.setText(this.f8436r);
        textView2.setTextSize(1, 11.0f);
        textView2.setTextColor(getResources().getColor(R.color.dark));
        textView2.setPadding(0, Util.dp2px((Context) this.f8437s, 6), Util.dp2px((Context) this.f8437s, 2), Util.dp2px((Context) this.f8437s, 6));
        linearLayoutCompat.addView(textView2);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this.f8437s);
        appCompatImageView.setImageResource(R.drawable.ic_close);
        appCompatImageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this.f8437s, 15), Util.dp2px((Context) this.f8437s, 27)));
        appCompatImageView.setPadding(Util.dp2px((Context) this.f8437s, 4), Util.dp2px((Context) this.f8437s, 10), Util.dp2px((Context) this.f8437s, 4), Util.dp2px((Context) this.f8437s, 10));
        linearLayoutCompat.addView(appCompatImageView);
        materialRippleLayout.setRippleRoundedCorners(Util.dp2px((Context) this.f8437s, 20));
        materialRippleLayout.setRippleOverlay(true);
        materialRippleLayout.setRippleColor(getResources().getColor(R.color.ripple_light));
        materialRippleLayout.setDefaultRippleAlpha(10);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        c0541a.setMargins(Util.dp2px((Context) this.f8437s, 3), Util.dp2px((Context) this.f8437s, 3), Util.dp2px((Context) this.f8437s, 3), Util.dp2px((Context) this.f8437s, 3));
        materialRippleLayout.addView(linearLayoutCompat);
        addView(materialRippleLayout, c0541a);
        materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.i0.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinearLayoutCompat4.this.m4650a(view);
            }
        });
    }

    public void setItem(ShopFilter.Attribute attribute) {
        int i = attribute.f12424id;
        this.f8435q = attribute.name;
        this.f8436r = attribute.itemName;
        int i2 = attribute.item;
        m4652h();
    }

    public void setItem(String str) {
        this.f8436r = str;
        m4652h();
    }

    public void setOnRemoveListener(View.OnClickListener onClickListener) {
        this.f8438t = onClickListener;
    }
}
