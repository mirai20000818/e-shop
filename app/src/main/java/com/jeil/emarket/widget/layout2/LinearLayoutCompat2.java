package com.jeil.emarket.widget.layout2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.interf.InterfaceVariableProduct;
import com.jeil.emarket.model.customer.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: b.f.a.c.i0.o */

public class LinearLayoutCompat2 extends LinearLayoutCompat {

    /* renamed from: q */
    public List<Product.VariableAttribute> f8425q;

    /* renamed from: r */
    public List<Product.CustomAttribute> f8426r;

    /* renamed from: s */
    public List<Product.VariableProduct> f8427s;

    /* renamed from: t */
    public Product.VariableProduct f8428t;

    /* renamed from: u */
    public Map<Integer, Integer> f8429u;

    /* renamed from: v */
    public Map<String, String> f8430v;

    /* renamed from: w */
    public InterfaceVariableProduct f8431w;

    public LinearLayoutCompat2(Context context) {
        super(context);
    }


    public void m4640a(BaseActivity activityC1391g1) {
        for (Product.VariableProduct variableProduct : this.f8427s) {
            if (variableProduct.match.equals(this.f8429u) && variableProduct.customMatch.equals(this.f8430v)) {
                if (this.f8431w != null) {
                    if (variableProduct.product != null) {
                        View findViewWithTag = findViewWithTag(Integer.valueOf(R.id.tv_stock));
                        if (variableProduct.product.stock > 0) {
                            if (findViewWithTag != null) {
                                findViewWithTag.setVisibility(View.GONE);
                            }
                        } else if (findViewWithTag == null) {
                            TextView textView = new TextView(activityC1391g1);
                            textView.setPadding(BaseActivity.anInt2 / 2, 0, 0, 0);
                            textView.setTextSize(1, 12.0f);
                            textView.setText(R.string.empty_stock);
                            textView.setTextColor(activityC1391g1.getResources().getColor(R.color.danger));
                            textView.setCompoundDrawablesWithIntrinsicBounds(activityC1391g1.getResources().getDrawable(R.drawable.ic_close_sm), (Drawable) null, (Drawable) null, (Drawable) null);
                            textView.setCompoundDrawablePadding(BaseActivity.anInt2 / 2);
                            textView.setTag(Integer.valueOf(R.id.tv_stock));
                            addView(textView);
                        } else {
                            findViewWithTag.setVisibility(View.VISIBLE);
                        }
                    }
                    this.f8431w.mo4598a(variableProduct);
                    return;
                }
                return;
            }
        }
        if (this.f8431w != null) {
            View findViewWithTag2 = findViewWithTag(Integer.valueOf(R.id.tv_stock));
            if (findViewWithTag2 == null) {
                TextView textView2 = new TextView(activityC1391g1);
                textView2.setPadding(BaseActivity.anInt2 / 2, 0, 0, 0);
                textView2.setTextSize(1, 12.0f);
                textView2.setText(R.string.empty_stock);
                textView2.setTextColor(activityC1391g1.getResources().getColor(R.color.danger));
                textView2.setCompoundDrawablesWithIntrinsicBounds(activityC1391g1.getResources().getDrawable(R.drawable.ic_close_sm), (Drawable) null, (Drawable) null, (Drawable) null);
                textView2.setCompoundDrawablePadding(BaseActivity.anInt2 / 2);
                textView2.setTag(Integer.valueOf(R.id.tv_stock));
                addView(textView2);
            } else {
                findViewWithTag2.setVisibility(View.VISIBLE);
            }
            this.f8431w.mo4598a(null);
        }
    }


    public void m4641a(InterfaceVariableProduct interfaceVariableProduct) {
        this.f8431w = interfaceVariableProduct;
    }

    /* JADX WARN: Multi-variable type inference failed */

    public  void m4643a(TextView textView, String[] strArr, Product.VariableAttribute variableAttribute, List list, BaseActivity activityC1391g1, BaseDialog2 baseDialog2, View view, int i) {
        textView.setText(strArr[i]);
        this.f8429u.put(Integer.valueOf(variableAttribute.f12409id), (Integer) list.get(i));
        m4640a(activityC1391g1);
        baseDialog2.startAni();
    }

    /* JADX WARN: Multi-variable type inference failed */

    public  void m4642a(TextView textView, String[] strArr, Product.CustomAttribute customAttribute, List list, BaseActivity activityC1391g1, BaseDialog2 baseDialog2, View view, int i) {
        textView.setText(strArr[i]);
        this.f8430v.put(customAttribute.name, (String) list.get(i));
        m4640a(activityC1391g1);
        baseDialog2.startAni();
    }


    public  void m4645a(final Product.VariableAttribute variableAttribute, List list, final BaseActivity activityC1391g1, final TextView textView, View view) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < variableAttribute.items.size(); i++) {
            if (list.contains(Integer.valueOf(variableAttribute.items.get(i).f12410id)) && !arrayList2.contains(Integer.valueOf(variableAttribute.items.get(i).f12410id))) {
                arrayList.add(variableAttribute.items.get(i).name);
                arrayList2.add(Integer.valueOf(variableAttribute.items.get(i).f12410id));
            }
        }
        final String[] strArr = new String[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            strArr[i2] = (String) arrayList.get(i2);
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(activityC1391g1, strArr, null, 80);
        baseDialog2.f8210H = textView.getText().toString();
        baseDialog2.f8209G = activityC1391g1.getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.c.i0.h
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i3) {
                LinearLayoutCompat2.this.m4643a(textView, strArr, variableAttribute, arrayList2, activityC1391g1, baseDialog2, view2, i3);
            }
        };
    }


    public  void m4644a(final Product.CustomAttribute customAttribute, List list, final BaseActivity activityC1391g1, final TextView textView, View view) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < customAttribute.items.size(); i++) {
            if (list.contains(customAttribute.items.get(i).name)) {
                arrayList.add(customAttribute.items.get(i).name);
                arrayList2.add(customAttribute.items.get(i).name);
            }
        }
        final String[] strArr = new String[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            strArr[i2] = (String) arrayList.get(i2);
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(activityC1391g1, strArr, null, 80);
        baseDialog2.f8210H = textView.getText().toString();
        baseDialog2.f8209G = activityC1391g1.getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.c.i0.f
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i3) {
                LinearLayoutCompat2.this.m4642a(textView, strArr, customAttribute, arrayList2, activityC1391g1, baseDialog2, view2, i3);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */

    public void m4646a(List<Product.VariableAttribute> list, List<Product.CustomAttribute> list2, List<Product.VariableProduct> list3, final BaseActivity activityC1391g1) {
        String str;
        int i;
        this.f8425q = new ArrayList(list == null ? new ArrayList<>() : list);
        this.f8426r = new ArrayList(list2 == null ? new ArrayList<>() : list2);
        this.f8427s = new ArrayList(list3 == null ? new ArrayList<>() : list3);
        setGravity(16);
        ViewGroup viewGroup = null;
        this.f8428t = null;
        if (list3 != null) {
            for (Product.VariableProduct variableProduct : list3) {
                if (variableProduct.product.stock > 0) {
                    this.f8428t = variableProduct;
                } else {
                    this.f8427s.remove(variableProduct);
                }
            }
        }
        removeAllViews();
        if (this.f8428t == null) {
            setVisibility(View.GONE);
            Util.toast(activityC1391g1, activityC1391g1.getString(R.string.cannot_cart), "default", 0, 0);
            return;
        }
        this.f8429u = new HashMap();
        this.f8430v = new HashMap();
        for (final Product.VariableAttribute variableAttribute : this.f8425q) {
            List<Product.VariableAttribute.Item> list4 = variableAttribute.items;
            if (list4 != null && list4.size() != 0) {
                View inflate = View.inflate(activityC1391g1, R.layout.item_select_variation, null);
                final TextView textView = (TextView) inflate.findViewById(R.id.tv_attribute);
                textView.setHint(variableAttribute.name);
                addView(inflate, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                Map<Integer, Integer> map = this.f8428t.match;
                if (map != null && map.size() > 0) {
                    if (this.f8428t.match.containsKey(Integer.valueOf(variableAttribute.f12409id))) {
                        for (Integer num : this.f8428t.match.keySet()) {
                            if (num.intValue() == variableAttribute.f12409id) {
                                i = ((Integer) Objects.requireNonNull(this.f8428t.match.get(num))).intValue();
                                break;
                            }
                        }
                    }
                    i = 0;
                    for (int i2 = 0; i2 < variableAttribute.items.size(); i2++) {
                        if (i == variableAttribute.items.get(i2).f12410id) {
                            textView.setText(variableAttribute.items.get(i2).name);
                        }
                    }
                }
                final ArrayList arrayList = new ArrayList();
                for (Product.VariableProduct variableProduct2 : this.f8427s) {
                    Map<Integer, Integer> map2 = variableProduct2.match;
                    if (map2 != null) {
                        Iterator<Integer> it = map2.keySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Integer next = it.next();
                                if (next.intValue() == variableAttribute.f12409id) {
                                    if (!arrayList.contains(variableProduct2.match.get(next))) {
                                        arrayList.add(variableProduct2.match.get(next));
                                        this.f8429u.put(next, Objects.requireNonNull(variableProduct2.match.get(next)));
                                    }
                                }
                            }
                        }
                    }
                }
                ((MaterialRippleLayout) inflate.findViewById(R.id.mrl_attribute)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.i0.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LinearLayoutCompat2.this.m4645a(variableAttribute, arrayList, activityC1391g1, textView, view);
                    }
                });
            }
        }
        for (final Product.CustomAttribute customAttribute : this.f8426r) {
            List<Product.CustomAttribute.Item> list5 = customAttribute.items;
            if (list5 != null && list5.size() != 0 && customAttribute.isVariable) {
                View inflate2 = View.inflate(activityC1391g1, R.layout.item_select_variation, viewGroup);
                final TextView textView2 = (TextView) inflate2.findViewById(R.id.tv_attribute);
                textView2.setHint(customAttribute.name);
                addView(inflate2, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                Map<String, String> map3 = this.f8428t.customMatch;
                if (map3 != null && map3.size() > 0) {
                    if (this.f8428t.customMatch.containsKey(customAttribute.name)) {
                        for (String str2 : this.f8428t.customMatch.keySet()) {
                            if (str2.equals(customAttribute.name)) {
                                str = this.f8428t.customMatch.get(str2);
                                break;
                            }
                        }
                    }
                    str = "";
                    for (int i3 = 0; i3 < customAttribute.items.size(); i3++) {
                        if (str != null && str.equals(customAttribute.items.get(i3).name)) {
                            textView2.setText(customAttribute.items.get(i3).name);
                        }
                    }
                }
                final ArrayList arrayList2 = new ArrayList();
                for (Product.VariableProduct variableProduct3 : this.f8427s) {
                    Map<String, String> map4 = variableProduct3.customMatch;
                    if (map4 != null) {
                        Iterator<String> it2 = map4.keySet().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                String next2 = it2.next();
                                if (next2.equals(customAttribute.name)) {
                                    arrayList2.add(variableProduct3.customMatch.get(next2));
                                    this.f8430v.put(next2, Objects.requireNonNull(variableProduct3.customMatch.get(next2)));
                                    break;
                                }
                            }
                        }
                    }
                }
                ((MaterialRippleLayout) inflate2.findViewById(R.id.mrl_attribute)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.i0.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LinearLayoutCompat2.this.m4644a(customAttribute, arrayList2, activityC1391g1, textView2, view);
                    }
                });
                viewGroup = null;
            }
        }
        InterfaceVariableProduct interfaceVariableProduct = this.f8431w;
        if (interfaceVariableProduct != null) {
            interfaceVariableProduct.mo4598a(this.f8428t);
        }
    }
}
