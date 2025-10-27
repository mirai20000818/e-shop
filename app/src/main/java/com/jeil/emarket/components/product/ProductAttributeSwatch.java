package com.jeil.emarket.components.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.components.GradientScrollLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.widget.layout2.LinearLayoutCompat1;
import com.jeil.emarket.interf.InterfaceVariableProduct;


public class ProductAttributeSwatch extends LinearLayoutCompat {

    /* renamed from: q */
    public Product f12279q;

    /* renamed from: r */
    public List<LinearLayoutCompat1> f12280r;

    /* renamed from: s */
    public InterfaceVariableProduct f12281s;

    /* renamed from: t */
    public Product.VariableProduct f12282t;

    public ProductAttributeSwatch(Context context) {
        super(context);
        this.f12280r = new ArrayList();
    }

    public ProductAttributeSwatch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12280r = new ArrayList();
    }

    
    public  void m6947a(LinearLayoutCompat1 linearLayoutCompat1, List list, View view) {
        MutableLiveData<Integer> mutableLiveData;
        int i;
        if (linearLayoutCompat1.f8419q.getValue() != null) {
            if (linearLayoutCompat1.f8419q.getValue().intValue() == 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    ((LinearLayoutCompat1) list.get(i2)).f8419q.setValue( 0);
                }
                mutableLiveData = linearLayoutCompat1.f8419q;
                i = 1;
            } else {
                if (linearLayoutCompat1.f8419q.getValue().intValue() != 1) {
                    return;
                }
                mutableLiveData = linearLayoutCompat1.f8419q;
                i = 0;
            }
            mutableLiveData.setValue( i);
            m6953h();
        }
    }

    
    public void m6948a(InterfaceVariableProduct interfaceVariableProduct) {
        this.f12281s = interfaceVariableProduct;
    }

    
    public void m6949a(Product.VariableProduct variableProduct) {
        this.f12282t = variableProduct;
        InterfaceVariableProduct interfaceVariableProduct = this.f12281s;
        if (interfaceVariableProduct != null) {
            interfaceVariableProduct.mo4598a(variableProduct);
        }
    }

    
    public void m6950a(Product product, BaseActivity activityC1391g1, boolean z) {
        int i;
        Product product2;
        int i2;
        int i3;
        Map<java.lang.String, java.lang.String> map;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        int i6;
        int m170a;
        int m170a2;
        Map<Integer, Integer> map2;
        BaseActivity activityC1391g12 = activityC1391g1;
        this.f12279q = product;
        Context context = getContext();
        int i7 = 1;
        setOrientation(LinearLayoutCompat.VERTICAL);
        int i8 = z ? 30 : 15;
        List<Product.VariableAttribute> list = product.variableAttributes;
        int i9 = 0;
        if (list == null || list.isEmpty()) {
            i = i8;
            product2 = product;
            i2 = 0;
        } else {
            List<Product.VariableAttribute> list2 = product.variableAttributes;
            int size = list2.size() + 0;
            int size2 = list2.size() - 1;
            while (size2 >= 0) {
                LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
                linearLayoutCompat.setPadding(i9, Util.dp2px(context, i7), i9, Util.dp2px(context, i7));
                m6951a(list2.get(size2).name, linearLayoutCompat, context);
                if (list2.get(size2).name.equals(context.getResources().getString(R.string.color))) {
                    for (int i10 = 0; i10 < list2.get(size2).items.size(); i10++) {
                        if (list2.get(size2).items.get(i10).image == null || list2.get(size2).items.get(i10).image.isEmpty()) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                Product.VariableProduct variableProduct = this.f12282t;
                if (variableProduct != null && (map2 = variableProduct.match) != null) {
                    Iterator<Integer> it = map2.keySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().intValue() == list2.get(size2).f12409id) {
                            i4 = size2;
                            break;
                        }
                    }
                }
                i4 = -1;
                GradientScrollLayout gradientScrollLayout = new GradientScrollLayout(context);
                final ArrayList arrayList = new ArrayList();
                int i11 = 0;
                while (i11 < list2.get(size2).items.size()) {
                    LinearLayoutCompat1 linearLayoutCompat1 = new LinearLayoutCompat1(activityC1391g12);
                    int i12 = size;
                    if (list2.get(size2).name.equals(context.getResources().getString(R.string.color))) {
                        linearLayoutCompat1.m4637a(list2.get(size2).items.get(i11), list2.get(size2).f12409id, z2 ? "color" : "image");
                        if (i11 == list2.get(size2).items.size() - 1) {
                            m170a = Util.dp2px(context, 2);
                            m170a2 = Util.dp2px(context, i8);
                            i6 = 0;
                        } else {
                            i6 = 0;
                            m170a = Util.dp2px(context, 2);
                            m170a2 = Util.dp2px(context, 2);
                        }
                        linearLayoutCompat1.setPadding(m170a, i6, m170a2, i6);
                        i5 = i8;
                        z3 = z2;
                    } else {
                        linearLayoutCompat1.m4637a(list2.get(size2).items.get(i11), list2.get(size2).f12409id, "label");
                        if (i11 == list2.get(size2).items.size() - 1) {
                            z3 = z2;
                            i5 = i8;
                            linearLayoutCompat1.setPadding(Util.dp2px(context, 3), Util.dp2px(context, 4), Util.dp2px(context, i8), Util.dp2px(context, 4));
                        } else {
                            i5 = i8;
                            z3 = z2;
                            linearLayoutCompat1.setPadding(Util.dp2px(context, 3), Util.dp2px(context, 4), Util.dp2px(context, 3), Util.dp2px(context, 4));
                        }
                    }
                    gradientScrollLayout.m6824a(linearLayoutCompat1);
                    arrayList.add(linearLayoutCompat1);
                    i11++;
                    activityC1391g12 = activityC1391g1;
                    z2 = z3;
                    size = i12;
                    i8 = i5;
                }
                int i13 = i8;
                int i14 = size;
                for (int i15 = 0; i15 < arrayList.size(); i15++) {
                    final LinearLayoutCompat1 linearLayoutCompat12 = (LinearLayoutCompat1) arrayList.get(i15);
                    linearLayoutCompat12.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.i0.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ProductAttributeSwatch.this.m6947a(linearLayoutCompat12, arrayList, view);
                        }
                    });
                    if (i4 > -1 && linearLayoutCompat12.f8422t == ((Integer) Objects.requireNonNull(this.f12282t.match.get(Integer.valueOf(list2.get(size2).f12409id)))).intValue()) {
                        linearLayoutCompat12.f8419q.setValue( 1);
                    }
                    this.f12280r.add(linearLayoutCompat12);
                }
                linearLayoutCompat.addView(gradientScrollLayout);
                addView(linearLayoutCompat, 0);
                size2--;
                activityC1391g12 = activityC1391g1;
                size = i14;
                i8 = i13;
                i7 = 1;
                i9 = 0;
            }
            i = i8;
            i2 = size;
            product2 = product;
        }
        List<Product.CustomAttribute> list3 = product2.customAttributes;
        if (list3 != null && !list3.isEmpty()) {
            List<Product.CustomAttribute> list4 = product2.customAttributes;
            i2 = list4.size() + i2;
            int i16 = 1;
            int size3 = list4.size() - 1;
            while (size3 >= 0) {
                if (list4.get(size3).isVariable) {
                    LinearLayoutCompat linearLayoutCompat2 = new LinearLayoutCompat(context);
                    linearLayoutCompat2.setPadding(0, Util.dp2px(context, i16), 0, Util.dp2px(context, i16));
                    m6951a(list4.get(size3).name, linearLayoutCompat2, context);
                    Product.VariableProduct variableProduct2 = this.f12282t;
                    if (variableProduct2 != null && (map = variableProduct2.customMatch) != null) {
                        Iterator<java.lang.String> it2 = map.keySet().iterator();
                        while (it2.hasNext()) {
                            if (list4.get(size3).name.equals(it2.next())) {
                                i3 = size3;
                                break;
                            }
                        }
                    }
                    i3 = -1;
                    GradientScrollLayout gradientScrollLayout2 = new GradientScrollLayout(context);
                    final ArrayList arrayList2 = new ArrayList();
                    for (int i17 = 0; i17 < list4.get(size3).items.size(); i17++) {
                        LinearLayoutCompat1 linearLayoutCompat13 = new LinearLayoutCompat1(activityC1391g1);
                        linearLayoutCompat13.m4636a(list4.get(size3).items.get(i17), list4.get(size3).name);
                        if (i17 == list4.get(size3).items.size() - 1) {
                            linearLayoutCompat13.setPadding(Util.dp2px(context, 3), Util.dp2px(context, 4), Util.dp2px(context, i), Util.dp2px(context, 4));
                        } else {
                            linearLayoutCompat13.setPadding(Util.dp2px(context, 3), Util.dp2px(context, 4), Util.dp2px(context, 3), Util.dp2px(context, 4));
                        }
                        gradientScrollLayout2.m6824a(linearLayoutCompat13);
                        arrayList2.add(linearLayoutCompat13);
                    }
                    for (int i18 = 0; i18 < arrayList2.size(); i18++) {
                        final LinearLayoutCompat1 linearLayoutCompat14 = (LinearLayoutCompat1) arrayList2.get(i18);
                        linearLayoutCompat14.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.i0.i
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ProductAttributeSwatch.this.m6952b(linearLayoutCompat14, arrayList2, view);
                            }
                        });
                        if (i3 > -1 && linearLayoutCompat14.f8423u.equals(this.f12282t.customMatch.get(list4.get(size3).name))) {
                            linearLayoutCompat14.f8419q.setValue( 1);
                        }
                        this.f12280r.add(linearLayoutCompat14);
                    }
                    linearLayoutCompat2.addView(gradientScrollLayout2);
                    addView(linearLayoutCompat2, 0);
                }
                size3--;
                i16 = 1;
            }
        }
        int i19 = i2;
        m6953h();
        if (i19 != 1 || this.f12280r.size() <= 0) {
            return;
        }
        for (LinearLayoutCompat1 linearLayoutCompat15 : this.f12280r) {
            if (linearLayoutCompat15.f8419q.getValue() != null && linearLayoutCompat15.f8419q.getValue().intValue() == -1) {
                this.f12280r.remove(linearLayoutCompat15);
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    
    public void m6951a(java.lang.String str, ViewGroup viewGroup, Context context) {
        TextView textView = new TextView(context);
        textView.setText(str + ":");
        textView.setTextSize(1, 12.0f);
        textView.setPadding(Util.dp2px(context, 5), Util.dp2px(context, 14), Util.dp2px(context, 9), 0);
        textView.setMinWidth(Util.dp2px(context, 72));
        viewGroup.addView(textView);
    }


    public  void m6952b(LinearLayoutCompat1 linearLayoutCompat1, List list, View view) {
        MutableLiveData<Integer> mutableLiveData;
        int i;
        if (linearLayoutCompat1.f8419q.getValue() != null) {
            if (linearLayoutCompat1.f8419q.getValue().intValue() == 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    ((LinearLayoutCompat1) list.get(i2)).f8419q.setValue( 0);
                }
                mutableLiveData = linearLayoutCompat1.f8419q;
                i = 1;
            } else {
                if (linearLayoutCompat1.f8419q.getValue().intValue() != 1) {
                    return;
                }
                mutableLiveData = linearLayoutCompat1.f8419q;
                i = 0;
            }
            mutableLiveData.setValue( i);
            m6953h();
        }
    }

    /* renamed from: h */
    public void m6953h() {
        InterfaceVariableProduct interfaceVariableProduct;
        Integer num;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f12280r.size(); i++) {
            if (((Integer) Objects.requireNonNull(this.f12280r.get(i).f8419q.getValue())).intValue() == 1) {
                if (this.f12280r.get(i).f8420r > 0) {
                    hashMap.put(CustomString.m3159a(new StringBuilder(), this.f12280r.get(i).f8420r, ""), Integer.valueOf(this.f12280r.get(i).f8422t));
                }
                if (!this.f12280r.get(i).f8421s.isEmpty()) {
                    hashMap2.put(this.f12280r.get(i).f8421s, this.f12280r.get(i).f8423u);
                }
            }
            if (this.f12280r.get(i).f8420r > 0 && !arrayList.contains(java.lang.String.valueOf(this.f12280r.get(i).f8420r))) {
                arrayList.add(this.f12280r.get(i).f8420r + "");
            }
            if (!this.f12280r.get(i).f8421s.isEmpty() && !arrayList.contains(this.f12280r.get(i).f8421s)) {
                arrayList2.add(this.f12280r.get(i).f8421s);
            }
        }
        Product.VariableProduct variableProduct = null;
        if (hashMap.size() == 0 && hashMap2.size() == 0) {
            for (int i2 = 0; i2 < this.f12280r.size(); i2++) {
                this.f12280r.get(i2).f8419q.setValue( 0);
            }
            InterfaceVariableProduct interfaceVariableProduct2 = this.f12281s;
            if (interfaceVariableProduct2 != null) {
                interfaceVariableProduct2.mo4598a(null);
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < this.f12280r.size(); i3++) {
            if (this.f12280r.get(i3).f8420r > 0 && hashMap.containsKey(java.lang.String.valueOf(this.f12280r.get(i3).f8420r)) && Objects.equals(hashMap.get(java.lang.String.valueOf(this.f12280r.get(i3).f8420r)), Integer.valueOf(this.f12280r.get(i3).f8422t))) {
                this.f12280r.get(i3).f8419q.setValue( 1);
            }
            if (!this.f12280r.get(i3).f8421s.isEmpty() && hashMap2.containsKey(this.f12280r.get(i3).f8421s) && Objects.equals(hashMap2.get(this.f12280r.get(i3).f8421s), this.f12280r.get(i3).f8423u)) {
                this.f12280r.get(i3).f8419q.setValue( 1);
            }
        }
        for (int i4 = 0; i4 < this.f12279q.variableProducts.size(); i4++) {
            Map<Integer, Integer> map = this.f12279q.variableProducts.get(i4).match;
            Map<java.lang.String, java.lang.String> map2 = this.f12279q.variableProducts.get(i4).customMatch;
            HashMap hashMap3 = new HashMap(map);
            for (Integer num2 : map.keySet()) {
                if (!arrayList.contains(java.lang.String.valueOf(num2))) {
                    hashMap3.remove(num2);
                }
            }
            HashMap hashMap4 = new HashMap(map2);
            for (java.lang.String str : map2.keySet()) {
                if (!arrayList2.contains(str)) {
                    hashMap4.remove(str);
                }
            }
            int i5 = 0;
            for (Object str2 : hashMap.keySet()) {
                if (!hashMap3.containsKey(Integer.valueOf(Integer.parseInt((java.lang.String) str2))) || !Objects.equals(hashMap3.get(Integer.valueOf(Integer.parseInt((java.lang.String) str2))), hashMap.get(str2))) {
                    i5++;
                }
            }
            if (i5 <= 1) {
                for (Object str3 : hashMap2.keySet()) {
                    if (!hashMap4.containsKey(str3) || !Objects.equals(hashMap4.get(str3), hashMap2.get(str3))) {
                        i5++;
                    }
                }
                if (i5 <= 1) {
                    if (hashMap.size() == hashMap3.size() && hashMap2.size() == hashMap4.size() && i5 == 0) {
                        variableProduct = this.f12279q.variableProducts.get(i4);
                    }
                    HashMap hashMap5 = new HashMap();
                    HashMap hashMap6 = new HashMap();
                    if (hashMap2.size() + hashMap.size() != 1 || i5 != 1) {
                        for (Integer num3 : map.keySet()) {
                            if (!hashMap5.containsKey(num3) || !Objects.equals(hashMap5.get(num3), map.get(num3))) {
                                hashMap5.put(num3, map.get(num3));
                            }
                        }
                        for (java.lang.String str4 : map2.keySet()) {
                            if (!hashMap6.containsKey(str4) || !Objects.equals(hashMap6.get(str4), map2.get(str4))) {
                                hashMap6.put(str4, map2.get(str4));
                            }
                        }
                    } else if (hashMap.size() > 0) {
                        Iterator it = hashMap.keySet().iterator();
                        while (it.hasNext()) {
                            try {
                                num = Integer.valueOf(Integer.parseInt((java.lang.String) it.next()));
                            } catch (Exception unused) {
                                num = 0;
                            }
                            if (map.containsKey(num) && (!hashMap5.containsKey(num) || !Objects.equals(hashMap5.get(num), map.get(num)))) {
                                hashMap5.put(num, map.get(num));
                            }
                        }
                    } else {
                        for (Object str5 : hashMap2.keySet()) {
                            if (map2.containsKey(str5) && (!hashMap6.containsKey(str5) || !Objects.equals(hashMap6.get(str5), map2.get(str5)))) {
                                hashMap6.put(str5, map2.get(str5));
                            }
                        }
                    }
                    for (int i6 = 0; i6 < this.f12280r.size(); i6++) {
                        if (this.f12280r.get(i6).f8420r > 0 && hashMap5.containsKey(Integer.valueOf(this.f12280r.get(i6).f8420r)) && Objects.equals(hashMap5.get(Integer.valueOf(this.f12280r.get(i6).f8420r)), Integer.valueOf(this.f12280r.get(i6).f8422t)) && ((Integer) Objects.requireNonNull(this.f12280r.get(i6).f8419q.getValue())).intValue() == -1) {
                            this.f12280r.get(i6).f8419q.setValue( 0);
                        }
                        if (!this.f12280r.get(i6).f8421s.isEmpty() && hashMap6.containsKey(this.f12280r.get(i6).f8421s) && Objects.equals(hashMap6.get(this.f12280r.get(i6).f8421s), this.f12280r.get(i6).f8423u) && ((Integer) Objects.requireNonNull(this.f12280r.get(i6).f8419q.getValue())).intValue() == -1) {
                            this.f12280r.get(i6).f8419q.setValue( 0);
                        }
                    }
                }
            }
        }
        if (variableProduct != null && (interfaceVariableProduct = this.f12281s) != null) {
            interfaceVariableProduct.mo4598a(variableProduct);
            return;
        }
        if (this.f12281s != null) {
            int size = arrayList.size();
            int i7 = 0;
            for (int i8 = 0; i8 < this.f12279q.customAttributes.size(); i8++) {
                if (this.f12279q.customAttributes.get(i8).isVariable) {
                    i7++;
                }
            }
            if (size != hashMap.size() || i7 != hashMap2.size()) {
                this.f12281s.mo4598a(null);
                return;
            }
            Product.VariableProduct variableProduct2 = new Product.VariableProduct();
            variableProduct2.product = new Product();
            Product product = variableProduct2.product;
            Product product2 = this.f12279q;
            float f = product2.minPrice;
            product.salePrice = f;
            float f2 = product2.maxRegularPrice;
            if (f2 <= 0.0f) {
                f2 = f;
            }
            product.regularPrice = f2;
            variableProduct2.product.name = this.f12279q.name;
            for (Object str6 : hashMap2.keySet()) {
                StringBuilder sb = new StringBuilder();
                Product product3 = variableProduct2.product;
                sb.append(product3.name);
                sb.append(", ");
                sb.append((java.lang.String) hashMap2.get(str6));
                product3.name = sb.toString();
            }
            for (Object str7 : hashMap.keySet()) {
                int i9 = 0;
                while (true) {
                    if (i9 >= this.f12279q.variableAttributes.size()) {
                        break;
                    }
                    if (Integer.parseInt((java.lang.String) str7) == this.f12279q.variableAttributes.get(i9).f12409id) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= this.f12279q.variableAttributes.get(i9).items.size()) {
                                break;
                            }
                            if (((Integer) hashMap.get(str7)).intValue() == this.f12279q.variableAttributes.get(i9).items.get(i10).f12410id) {
                                StringBuilder sb2 = new StringBuilder();
                                Product product4 = variableProduct2.product;
                                sb2.append(product4.name);
                                sb2.append(", ");
                                sb2.append(this.f12279q.variableAttributes.get(i9).items.get(i10).name);
                                product4.name = sb2.toString();
                                break;
                            }
                            i10++;
                        }
                    } else {
                        i9++;
                    }
                }
            }
            Product product5 = variableProduct2.product;
            product5.image = null;
            product5.stock = 0;
            this.f12281s.mo4598a(variableProduct2);
        }
    }

    public void setAttributeItems(List<LinearLayoutCompat1> list) {
        for (LinearLayoutCompat1 linearLayoutCompat1 : this.f12280r) {
            linearLayoutCompat1.f8419q.setValue( (-1));
            for (LinearLayoutCompat1 linearLayoutCompat12 : list) {
                int i = linearLayoutCompat12.f8420r;
                if (i != 0 && i == linearLayoutCompat1.f8420r && linearLayoutCompat12.f8422t == linearLayoutCompat1.f8422t) {
                    linearLayoutCompat1.f8419q.setValue( linearLayoutCompat12.f8419q.getValue());
                }
                if (!linearLayoutCompat12.f8421s.isEmpty() && linearLayoutCompat12.f8421s.equals(linearLayoutCompat1.f8421s) && linearLayoutCompat12.f8423u.equals(linearLayoutCompat1.f8423u)) {
                    linearLayoutCompat1.f8419q.setValue( linearLayoutCompat12.f8419q.getValue());
                }
            }
        }
    }
}
