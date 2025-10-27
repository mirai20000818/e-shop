package com.jeil.emarket.components.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.activities.intro.SettingActivity;
import com.jeil.emarket.activities.intro.SetupActivity;
import com.jeil.emarket.components.CircleImageView;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ShopCategoryFilter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.viewmodel.UserVM;


public class ColorSwatch extends LinearLayoutCompat {

    /* renamed from: q */
    public RelativeLayout f12277q;

    /* renamed from: r */
    public View f12278r;

    public ColorSwatch(Context context) {
        super(context);
    }
    @SuppressLint("ResourceType")
    public ColorSwatch(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorSwatch);
        int color = obtainStyledAttributes.getColor(0, BaseActivity.color);
        final int color2 = obtainStyledAttributes.getColor(1, 1);
        setGravity(16);
        this.f12277q = new RelativeLayout(context);
        CircleImageView circleImageView = new CircleImageView(context);
        int m170a = Util.dp2px(context, 7) / 2;
        circleImageView.setPadding(m170a, m170a, m170a, m170a);
        circleImageView.setImageDrawable(getResources().getDrawable(R.drawable.bg_white_circle));
        circleImageView.setBackground(getResources().getDrawable(R.drawable.bd_grey_circle));
        circleImageView.setInsetLength(Util.dp2px(context, 1));
        circleImageView.setBorderColor(getResources().getColor(R.color.white));
        circleImageView.setBorderWidth(m170a);
        circleImageView.setFillColor(color);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.dp2px(context, 36), Util.dp2px(context, 36));
        int m170a2 = Util.dp2px(context, 2);
        layoutParams.setMargins(m170a2, m170a2, 0, m170a2);
        this.f12277q.addView(circleImageView, layoutParams);
        addView(this.f12277q);
        this.f12278r = new View(context);
        this.f12278r.setBackgroundResource(R.drawable.bg_circle_outline_primary);
        this.f12278r.setVisibility(View.GONE);
        this.f12277q.addView(this.f12278r, new RelativeLayout.LayoutParams(Util.dp2px(context, 15), Util.dp2px(context, 15)));
        if (color2 == UserVM.sharedPreferences.getInt("color_scheme", 1)) {
            m6945h();
        }
        setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.i0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColorSwatch.this.m6942a(context, color2, view);
            }
        });
    }


    public  void m6942a(Context context, int i, View view) {
        if (getParent() instanceof LinearLayoutCompat) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) getParent();
            for (int i2 = 0; i2 < linearLayoutCompat.getChildCount(); i2++) {
                View childAt = linearLayoutCompat.getChildAt(i2);
                if (childAt instanceof ColorSwatch) {
                    ((ColorSwatch) childAt).m6946i();
                }
            }
        }
        m6945h();
        if (context instanceof SettingActivity) {
            ((SettingActivity) context).f11736O = i;
        } else if (context instanceof SetupActivity) {
            ((SetupActivity) context).f11739I = i;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m6943a(Context context, Product.VariableAttribute.Item item, java.lang.String str) {
        int parseColor;
        java.lang.String str2;
        setGravity(16);
        this.f12277q = new RelativeLayout(context);
        CircleImageView circleImageView = new CircleImageView(context);
        java.lang.String str3 = item.color;
        if (str3 != null && !str3.isEmpty()) {
            int m170a = Util.dp2px(context, 7) / 2;
            circleImageView.setPadding(m170a, m170a, m170a, m170a);
            circleImageView.setImageDrawable(getResources().getDrawable(R.drawable.bg_white_circle));
            if (!str.equals("image") || (str2 = item.image) == null || str2.isEmpty()) {
                circleImageView.setBackground(getResources().getDrawable(R.drawable.bd_grey_circle));
                circleImageView.setInsetLength(Util.dp2px(context, 1));
                circleImageView.setBorderColor(getResources().getColor(R.color.white));
                circleImageView.setBorderWidth(m170a);
                if (item.color.startsWith("rgb")) {
                    java.lang.String str4 = item.color;
                    java.lang.String[] split = str4.substring(4, str4.length() - 1).split(", ");
                    if (split.length == 3) {
                        try {
                            circleImageView.setFillColor(Color.rgb(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                        } catch (Exception unused) {
                            parseColor = Color.rgb(0, 0, 0);
                        }
                    }
                } else if (item.color.length() == 4 || item.color.length() == 7) {
                    if (item.color.length() == 4) {
                        StringBuilder m3163a = CustomString.format("");
                        m3163a.append(item.color.charAt(0));
                        m3163a.append(item.color.charAt(1));
                        m3163a.append(item.color.charAt(1));
                        m3163a.append(item.color.charAt(2));
                        m3163a.append(item.color.charAt(2));
                        m3163a.append(item.color.charAt(3));
                        m3163a.append(item.color.charAt(3));
                        item.color = m3163a.toString();
                    }
                    parseColor = Color.parseColor(item.color);
                    circleImageView.setFillColor(parseColor);
                }
                Util.toast(context, context.getString(R.string.invalid_color), "default", 0, 0);
            } else {
                circleImageView.setBackground(getResources().getDrawable(R.drawable.bd_grey_circle));
                circleImageView.setInsetLength(Util.dp2px(context, 1));
                circleImageView.setBorderColor(getResources().getColor(R.color.white));
                circleImageView.setBorderWidth(m170a);
                Glide.with(context).load(Util.m306b(item.image, "xss")).diskCacheStrategy(DiskCacheStrategy.ALL).into((ImageView) circleImageView);
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.dp2px(context, 36), Util.dp2px(context, 36));
        int m170a2 = Util.dp2px(context, 2);
        layoutParams.setMargins(m170a2, m170a2, 0, m170a2);
        this.f12277q.addView(circleImageView, layoutParams);
        addView(this.f12277q);
        this.f12278r = new View(context);
        this.f12278r.setBackgroundResource(R.drawable.bg_circle_outline_primary);
        this.f12278r.setVisibility(View.GONE);
        this.f12277q.addView(this.f12278r, new RelativeLayout.LayoutParams(Util.dp2px(context, 15), Util.dp2px(context, 15)));
    }

    /* renamed from: h */
    public void m6945h() {
        this.f12278r.setVisibility(View.VISIBLE);
    }


    public void m6946i() {
        this.f12278r.setVisibility(View.GONE);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m6944a(Context context, ShopCategoryFilter.Attribute.AttributeItem attributeItem) {
        int parseColor;
        setGravity(16);
        this.f12277q = new RelativeLayout(context);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        java.lang.String str = attributeItem.color;
        if (str != null && !str.isEmpty()) {
            appCompatImageView.setBackground(getResources().getDrawable(R.drawable.bd_grey_circle));
            int m170a = Util.dp2px(context, 7) / 2;
            appCompatImageView.setPadding(m170a, m170a, m170a, m170a);
            appCompatImageView.setImageResource(R.drawable.bg_white_circle);
            java.lang.String str2 = attributeItem.image;
            if (str2 == null || str2.isEmpty()) {
                if (attributeItem.color.startsWith("rgb")) {
                    java.lang.String str3 = attributeItem.color;
                    java.lang.String[] split = str3.substring(4, str3.length() - 1).split(", ");
                    if (split.length == 3) {
                        try {
                            appCompatImageView.setImageTintList(ColorStateList.valueOf(Color.rgb(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]))));
                        } catch (Exception unused) {
                            parseColor = Color.rgb(0, 0, 0);
                        }
                    }
                } else if (attributeItem.color.length() == 4 || attributeItem.color.length() == 7) {
                    if (attributeItem.color.length() == 4) {
                        StringBuilder m3163a = CustomString.format("");
                        m3163a.append(attributeItem.color.charAt(0));
                        m3163a.append(attributeItem.color.charAt(1));
                        m3163a.append(attributeItem.color.charAt(1));
                        m3163a.append(attributeItem.color.charAt(2));
                        m3163a.append(attributeItem.color.charAt(2));
                        m3163a.append(attributeItem.color.charAt(3));
                        m3163a.append(attributeItem.color.charAt(3));
                        attributeItem.color = m3163a.toString();
                    }
                    parseColor = Color.parseColor(attributeItem.color);
                    appCompatImageView.setImageTintList(ColorStateList.valueOf(parseColor));
                }
                Util.toast(context, context.getString(R.string.invalid_color), "default", 0, 0);
            } else {
                Glide.with(context).load(Util.m306b(attributeItem.image, "xss")).diskCacheStrategy(DiskCacheStrategy.ALL).into((ImageView) appCompatImageView);
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.dp2px(context, 30), Util.dp2px(context, 30));
        int m170a2 = Util.dp2px(context, 2);
        layoutParams.setMargins(m170a2, m170a2, (m170a2 * 3) / 2, m170a2);
        this.f12277q.addView(appCompatImageView, layoutParams);
        addView(this.f12277q);
        this.f12278r = new View(context);
        this.f12278r.setBackgroundResource(R.drawable.bg_circle_outline_primary);
        this.f12278r.setVisibility(View.GONE);
        this.f12277q.addView(this.f12278r, new RelativeLayout.LayoutParams(Util.dp2px(context, 15), Util.dp2px(context, 15)));
    }
}
