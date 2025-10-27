package com.jeil.emarket.components.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;
import com.google.android.material.internal.FlowLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.ShopCategoryFilter;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.widget.layout2.LinearLayoutCompat1;


public class ShopAttributes extends LinearLayoutCompat {

    /* renamed from: q */
    public List<LinearLayoutCompat1> f12283q;

    /* renamed from: r */
    public List<ShopCategoryFilter.Attribute> f12284r;

    public ShopAttributes(Context context) {
        super(context);
        this.f12283q = new ArrayList();
        this.f12284r = new ArrayList();
    }

    public ShopAttributes(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12283q = new ArrayList();
        this.f12284r = new ArrayList();
    }


    public  void m6954a(LinearLayoutCompat1 linearLayoutCompat1, List list, int i, View view) {
        MutableLiveData<Integer> mutableLiveData;
        int i2;
        if (linearLayoutCompat1.f8419q.getValue().intValue() == 0) {
            m6958c(((ShopCategoryFilter.Attribute) list.get(i)).f12420id);
            mutableLiveData = linearLayoutCompat1.f8419q;
            i2 = 1;
        } else {
            if (linearLayoutCompat1.f8419q.getValue().intValue() != 1) {
                return;
            }
            mutableLiveData = linearLayoutCompat1.f8419q;
            i2 = 0;
        }
        mutableLiveData.setValue( i2);
    }

    @SuppressLint({"SetTextI18n"})

    public void m6955a(String str, ViewGroup viewGroup, Context context, String str2) {
        int m170a;
        int m170a2;
        TextView textView = new TextView(context);
        textView.setText(str + ":");
        textView.setTextSize(1, 12.0f);
        if (str2.equals("color")) {
            m170a = Util.dp2px(context, 5);
            m170a2 = Util.dp2px(context, 11);
        } else {
            m170a = Util.dp2px(context, 5);
            m170a2 = Util.dp2px(context, 9);
        }
        textView.setPadding(m170a, m170a2, Util.dp2px(context, 9), 0);
        textView.setMinWidth(Util.dp2px(context, 70));
        viewGroup.addView(textView);
    }


    public void m6956a(List<Integer> list) {
        for (int i = 0; i < this.f12283q.size(); i++) {
            if (!list.contains(Integer.valueOf(this.f12283q.get(i).f8420r))) {
                this.f12283q.get(i).f8419q.setValue( 0);
            }
        }
    }


    public void m6957a(final List<ShopCategoryFilter.Attribute> list, BaseActivity activityC1391g1) {
        this.f12284r = list;
        Context context = getContext();
        int i = 1;
        setOrientation(LinearLayoutCompat.VERTICAL);
        removeAllViews();
        List<ShopCategoryFilter.Attribute> list2 = this.f12284r;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        int size = list.size() - 1;
        while (size >= 0) {
            LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
            linearLayoutCompat.setPadding(0, Util.dp2px(context, i), 0, Util.dp2px(context, i));
            String str = list.get(size).name;
            Resources resources = context.getResources();
            int i2 = R.string.color;
            if (str.equals(resources.getString(R.string.color))) {
                m6955a(list.get(size).name, linearLayoutCompat, context, "color");
            } else {
                m6955a(list.get(size).name, linearLayoutCompat, context, "label");
            }
            @SuppressLint("RestrictedApi") FlowLayout flowLayout = new FlowLayout(context);
            int i3 = 0;
            while (i3 < list.get(size).items.size()) {
                final LinearLayoutCompat1 linearLayoutCompat1 = new LinearLayoutCompat1(activityC1391g1);
                if (list.get(size).name.equals(context.getResources().getString(i2))) {
                    linearLayoutCompat1.m4638a(list.get(size).items.get(i3), list.get(size).f12420id, list.get(size).name, "color");
                } else {
                    linearLayoutCompat1.m4638a(list.get(size).items.get(i3), list.get(size).f12420id, list.get(size).name, "label");
                    linearLayoutCompat1.setPadding(Util.dp2px(context, 3), Util.dp2px(context, 5), Util.dp2px(context, 3), Util.dp2px(context, 5));
                }
                int finalSize = size;
                linearLayoutCompat1.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.i0.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ShopAttributes.this.m6954a(linearLayoutCompat1, list, finalSize, view);
                    }
                });
                flowLayout.addView(linearLayoutCompat1);
                this.f12283q.add(linearLayoutCompat1);
                i3++;
                i2 = R.string.color;
            }
            linearLayoutCompat.addView(flowLayout);
            addView(linearLayoutCompat, 0);
            size--;
            i = 1;
        }
    }

    
    public void m6958c(int i) {
        for (int i2 = 0; i2 < this.f12283q.size(); i2++) {
            if (this.f12283q.get(i2).f8420r == i) {
                this.f12283q.get(i2).f8419q.setValue( 0);
            }
        }
    }

    /* renamed from: h */
    public void m6959h() {
        for (int i = 0; i < this.f12283q.size(); i++) {
            this.f12283q.get(i).f8419q.setValue( 0);
        }
    }
}
