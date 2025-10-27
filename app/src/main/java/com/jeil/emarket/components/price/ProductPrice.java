package com.jeil.emarket.components.price;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;
import com.google.android.material.internal.FlowLayout;
import com.jeil.emarket.components.textview.TextView;



public class ProductPrice extends LinearLayoutCompat {

    /* renamed from: q */
    public Context f12267q;

    /* renamed from: r */
    public String f12268r;

    /* renamed from: s */
    public PriceText f12269s;

    /* renamed from: t */
    public PriceText f12270t;

    /* renamed from: u */
    public FlowLayout f12271u;

    /* renamed from: v */
    public PriceText f12272v;

    /* renamed from: w */
    public PriceText f12273w;

    /* renamed from: x */
    public TextView f12274x;

    /* renamed from: y */
    public int f12275y;

    /* renamed from: z */
    public int f12276z;

    @SuppressLint({"RestrictedApi"})
    public ProductPrice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12268r = "kpw";
        this.f12267q = context;
        setOrientation(LinearLayoutCompat.HORIZONTAL);
        setGravity(16);
        this.f12269s = new PriceText(context);
        this.f12269s.setPrice("0");
        this.f12269s.setPadding(0, Util.dp2px(context, 3), 0, Util.dp2px(context, 3));
        this.f12270t = new PriceText(context);
        this.f12270t.setPrice("0");
        this.f12270t.setPadding(0, Util.dp2px(context, 3), 0, Util.dp2px(context, 3));
        this.f12271u = new FlowLayout(context);
        this.f12271u.setPadding(0, Util.dp2px(context, 3), 0, Util.dp2px(context, 3));
        this.f12272v = new PriceText(context);
        this.f12273w = new PriceText(context);
        this.f12274x = new TextView(context);
        this.f12274x.setText("~");
        this.f12274x.setPadding(5, 0, 5, 0);
        this.f12271u.addView(this.f12273w);
        this.f12271u.addView(this.f12274x);
        this.f12271u.addView(this.f12272v);
        setStyle(context, attributeSet);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-2, -2, 17.0f);
        addView(this.f12270t);
        addView(this.f12269s);
        addView(this.f12271u, c0541a);
    }
    @SuppressLint("ResourceType")

    public void setStyle(Context context, AttributeSet attributeSet) {
        int i = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProductPrice);
            String string = obtainStyledAttributes.getString(4);
            String string2 = obtainStyledAttributes.getString(3);
            String string3 = obtainStyledAttributes.getString(7);
            String string4 = obtainStyledAttributes.getString(8);
            this.f12268r = obtainStyledAttributes.getString(0);
            this.f12275y = obtainStyledAttributes.getInt(6, 13);
            if (string == null || string2 == null) {
                setPtSalePrice(string4);
            } else {
                m6938a(string, string2);
            }
            if (string3 != null) {
                setRegularPrice(string3);
            }
            String string5 = obtainStyledAttributes.getString(5);
            if (string5 != null && string5.equals("vertical")) {
                setOrientation(LinearLayoutCompat.VERTICAL);
            }
            String string6 = obtainStyledAttributes.getString(2);
            if (string6 != null) {
                if (!string6.equals("center")) {
                    if (string6.equals("center_horizontal")) {
                        setGravity(1);
                    } else {
                        i = string6.equals("center_vertical") ? 16 : 17;
                    }
                }
                setGravity(i);
            }
            obtainStyledAttributes.recycle();
        }
    }


    public void m6938a(String str, String str2) {
        if (str.equals(str2)) {
            setPtSalePrice(str);
            return;
        }
        this.f12273w.setCurrency(this.f12268r);
        this.f12273w.setPrice(str);
        this.f12273w.setVisibility(View.VISIBLE);
        PriceText priceText = this.f12273w;
        int i = this.f12276z;
        if (i == 0) {
            i = this.f12275y;
        }
        priceText.setTextSize(i);
        this.f12274x.setVisibility(View.VISIBLE);
        TextView textView = this.f12274x;
        int i2 = this.f12276z;
        if (i2 == 0) {
            i2 = this.f12275y;
        }
        textView.setTextSize(i2);
        this.f12272v.setCurrency(this.f12268r);
        this.f12272v.setPrice(str2);
        PriceText priceText2 = this.f12272v;
        int i3 = this.f12276z;
        if (i3 == 0) {
            i3 = this.f12275y;
        }
        priceText2.setTextSize(i3);
        this.f12271u.setVisibility(View.VISIBLE);
        this.f12270t.setVisibility(View.GONE);
        this.f12269s.setVisibility(View.GONE);
    }


    public void m6939a(boolean z) {
        this.f12269s.setVisibility(z ? View.VISIBLE : View.GONE);
    }


    public void m6940b(boolean z) {
        this.f12270t.setVisibility(z ? View.VISIBLE : View.GONE);
    }


    public void m6941c(boolean z) {
        setGravity(80);
        this.f12270t.setPadding(0, Util.dp2px(this.f12267q, 3), Util.dp2px(getContext(), 8) / (z ? 2 : 1), Util.dp2px(this.f12267q, 3));
        this.f12269s.setPadding(0, Util.dp2px(this.f12267q, 3), Util.dp2px(getContext(), 8), Util.dp2px(this.f12267q, 3));
        PriceText priceText = this.f12269s;
        int i = this.f12276z;
        if (i == 0) {
            i = this.f12275y;
        }
        priceText.setTextSize((int) (i * 0.88f));
        this.f12269s.m6933a(this.f12268r, true);
    }

    public void setCurrency(String str) {
        this.f12268r = str;
    }

    public void setFlVariableSingleLine(boolean z) {
        PriceText priceText = this.f12272v;
        if (priceText != null) {
            priceText.setVisibility(z ? View.GONE : View.VISIBLE);
        }
        removeView(this.f12271u);
        addView(this.f12271u, new LinearLayoutCompat.LayoutParams(-2, -2, 16.0f));
    }

    public void setHidePriceNumber(boolean z) {
        this.f12270t.setHidePriceNumber(z);
        this.f12273w.setHidePriceNumber(z);
        this.f12272v.setHidePriceNumber(z);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f12270t.setPadding(i, i2, i3, i4);
        this.f12269s.setPadding(i, i2, i3, i4);
    }

    public void setPtSalePrice(String str) {
        this.f12270t.setCurrency(this.f12268r);
        PriceText priceText = this.f12270t;
        if (str == null) {
            str = "0";
        }
        priceText.setPrice(str);
        this.f12270t.setTextSize(this.f12275y);
        this.f12269s.m6933a(this.f12268r, true);
        this.f12271u.setVisibility(View.GONE);
        this.f12270t.setVisibility(View.VISIBLE);
        this.f12269s.setVisibility(View.GONE);
    }

    public void setRegularPrice(String str) {
        Context context;
        this.f12269s.m6933a(this.f12268r, true);
        PriceText priceText = this.f12269s;
        if (str == null) {
            str = "0";
        }
        priceText.setPrice(str);
        PriceText priceText2 = this.f12269s;
        int i = this.f12276z;
        if (i == 0) {
            i = this.f12275y;
        }
        priceText2.setTextSize(i);
        if (this.f12276z != 0 && (context = this.f12267q) != null) {
            this.f12270t.setPadding(0, Util.dp2px(context, 3), Util.dp2px(this.f12267q, 8), Util.dp2px(this.f12267q, 3));
        }
        this.f12271u.setVisibility(View.GONE);
        this.f12270t.setVisibility(View.VISIBLE);
        this.f12269s.setVisibility(View.VISIBLE);
    }

    public void setRegularPriceSize(int i) {
        this.f12276z = i;
    }

    public void setTextSize(int i) {
        this.f12275y = i;
    }
}
