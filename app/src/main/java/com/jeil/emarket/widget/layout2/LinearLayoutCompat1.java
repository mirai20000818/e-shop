package com.jeil.emarket.widget.layout2;

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.product.ColorSwatch;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ShopCategoryFilter;

/* renamed from: b.f.a.c.i0.n */

public class LinearLayoutCompat1 extends LinearLayoutCompat {

    /* renamed from: q */
    public MutableLiveData<Integer> f8419q;

    /* renamed from: r */
    public int f8420r;

    /* renamed from: s */
    public String f8421s;

    /* renamed from: t */
    public int f8422t;

    /* renamed from: u */
    public String f8423u;

    /* renamed from: v */
    public BaseActivity f8424v;

    public LinearLayoutCompat1(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f8419q = new MutableLiveData<>(0);
        this.f8420r = 0;
        this.f8421s = "";
        this.f8422t = 0;
        this.f8423u = "";
        this.f8424v = activityC1391g1;
    }


    public static  void m4633a(ButtonToggle buttonToggle, Integer num) {
        if (num.intValue() == -1) {
            buttonToggle.setAlpha(0.5f);
            buttonToggle.m6897e();
            return;
        }
        buttonToggle.setAlpha(1.0f);
        buttonToggle.m6897e();
        if (num.intValue() == 1) {
            buttonToggle.m6896d();
        }
    }


    public static  void m4634a(ColorSwatch colorSwatch, Integer num) {
        if (num.intValue() == -1) {
            colorSwatch.setAlpha(0.5f);
            colorSwatch.m6946i();
            return;
        }
        colorSwatch.setAlpha(1.0f);
        colorSwatch.m6946i();
        if (num.intValue() == 1) {
            colorSwatch.m6945h();
        }
    }


    public static  void m4635b(ColorSwatch colorSwatch, Integer num) {
        if (num.intValue() == -1) {
            colorSwatch.setAlpha(0.5f);
            return;
        }
        colorSwatch.setAlpha(1.0f);
        colorSwatch.m6946i();
        if (num.intValue() == 1) {
            colorSwatch.m6945h();
        }
    }


    public void m4636a(Product.CustomAttribute.Item item, String str) {
        this.f8421s = str;
        String str2 = item.name;
        this.f8423u = str2;
        m4639a(str2, "product");
    }


    public void m4637a(Product.VariableAttribute.Item item, int i, String str) {
        this.f8420r = i;
        this.f8423u = item.name;
        this.f8422t = item.f12410id;
        if (!str.equals("color") && !str.equals("image")) {
            m4639a(item.name, "product");
            return;
        }
        final ColorSwatch colorSwatch = new ColorSwatch(this.f8424v);
        colorSwatch.m6943a(getContext(), item, str);
        addView(colorSwatch);
        colorSwatch.m6946i();
        this.f8419q.observe(this.f8424v, new Observer() { // from class: b.f.a.c.i0.b
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LinearLayoutCompat1.m4634a(colorSwatch, (Integer) obj);
            }
        });
    }


    public void m4638a(ShopCategoryFilter.Attribute.AttributeItem attributeItem, int i, String str, String str2) {
        this.f8420r = i;
        this.f8421s = str;
        this.f8423u = attributeItem.name;
        this.f8422t = attributeItem.f12421id;
        if (!str2.equals("color")) {
            m4639a(attributeItem.name, "shop");
            return;
        }
        final ColorSwatch colorSwatch = new ColorSwatch(this.f8424v);
        colorSwatch.m6944a(getContext(), attributeItem);
        addView(colorSwatch);
        colorSwatch.m6946i();
        this.f8419q.observe(this.f8424v, new Observer() { // from class: b.f.a.c.i0.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LinearLayoutCompat1.m4635b(colorSwatch, (Integer) obj);
            }
        });
    }


    public void m4639a(String str, String str2) {
        int i;
        int m170a;
        BaseActivity activityC1391g1;
        int i2;
        final ButtonToggle buttonToggle = new ButtonToggle(this.f8424v);
        if (!str2.equals("shop")) {
            buttonToggle.setUnActiveBg(R.drawable.bd_white_ellipse);
        }
        buttonToggle.setText(str);
        if (str2.equals("shop")) {
            buttonToggle.m6893a(1, 10.0f);
            i = 13;
            m170a = Util.dp2px((Context) this.f8424v, 13);
            activityC1391g1 = this.f8424v;
            i2 = 6;
        } else {
            buttonToggle.m6893a(1, 11.0f);
            i = 19;
            m170a = Util.dp2px((Context) this.f8424v, 19);
            activityC1391g1 = this.f8424v;
            i2 = 9;
        }
        buttonToggle.m6894a(m170a, Util.dp2px((Context) activityC1391g1, i2), Util.dp2px((Context) this.f8424v, i), Util.dp2px((Context) this.f8424v, i2));
        addView(buttonToggle);
        this.f8419q.observe(this.f8424v, new Observer() { // from class: b.f.a.c.i0.c
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LinearLayoutCompat1.m4633a(buttonToggle, (Integer) obj);
            }
        });
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (getChildCount() > 0) {
            getChildAt(0).setOnClickListener(onClickListener);
        }
    }
}
