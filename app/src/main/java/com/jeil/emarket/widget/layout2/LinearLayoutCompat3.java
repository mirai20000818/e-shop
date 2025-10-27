package com.jeil.emarket.widget.layout2;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.ImageDialog3;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;

import java.util.List;

/* renamed from: b.f.a.c.i0.p */

public class LinearLayoutCompat3 extends LinearLayoutCompat {

    /* renamed from: q */
    public BaseActivity f8432q;

    /* renamed from: r */
    public ImageDialog3 f8433r;

    /* renamed from: s */
    public java.lang.String f8434s;

    public LinearLayoutCompat3(BaseActivity activityC1391g1, java.lang.String str) {
        super(activityC1391g1);
        this.f8432q = activityC1391g1;
        this.f8434s = str;
    }

    
    public final void m4648a(java.lang.String str, TableLayout tableLayout, java.lang.String str2) {
        TableRow tableRow = new TableRow(this.f8432q);
        TextView textView = new TextView(this.f8432q);
        TextView textView2 = new TextView(this.f8432q);
        int i = (BaseActivity.anInt2 * 10) / 8;
        if (!str.isEmpty()) {
            textView.setText(str);
            textView.setLineSpacing(Util.dp2px(getContext(), 5), 1.0f);
            textView.setTextSize(1, 12.0f);
            textView.setMinWidth(Util.dp2px(getContext(), 90));
            textView.setPadding(i, i, i, i);
        }
        textView2.setText(str2.trim());
        textView2.setTextColor(getResources().getColor(R.color.dark));
        textView2.setLineSpacing(Util.dp2px(getContext(), 5), 1.0f);
        textView2.setTextSize(1, 12.0f);
        textView2.setPadding(i, i, i, i);
        View view = new View(this.f8432q);
        view.setBackgroundColor(getResources().getColor(R.color.border));
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (!str.isEmpty()) {
            tableRow.addView(textView, new TableRow.LayoutParams(-2, -1));
            tableRow.addView(view, new TableRow.LayoutParams(Util.dp2px((Context) this.f8432q, 1), -1));
        }
        tableRow.addView(textView2, layoutParams);
        tableRow.setBackgroundResource(R.drawable.bd_rect_thin);
        tableLayout.addView(tableRow);
    }

    /* JADX WARN: Code restructure failed: missing block: B:217:0x04ca, code lost:
    
        if (r2 == r1.indexOf(">" + r12 + ".")) goto L254;
     */
    @android.annotation.SuppressLint({"SetTextI18n", "CheckResult"})
    
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4649a(java.lang.String r24, androidx.appcompat.widget.LinearLayoutCompat r25) {
        /*
            Method dump skipped, instructions count: 1627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p190c.p207i0.C2058p.m4649a(java.lang.String, androidx.appcompat.widget.LinearLayoutCompat):void");
    }

    public void setItem(ProductDetail productDetail) {
        java.lang.String str = null;
        java.lang.String str2;
        setOrientation(LinearLayoutCompat.VERTICAL);
        TableLayout tableLayout = new TableLayout(this.f8432q);
        tableLayout.setBackgroundResource(R.drawable.bd_rect_thin);
        tableLayout.setShrinkAllColumns(true);
        if (productDetail != null && productDetail.data != null) {
            m4648a(this.f8432q.getString(R.string.product_id), tableLayout, CustomString.m3159a(new StringBuilder(), productDetail.data.f12407id, ""));
            java.lang.String str3 = productDetail.data.categoryName;
            if (str3 != null && !str3.isEmpty()) {
                m4648a(this.f8432q.getString(R.string.category_name_desc), tableLayout, productDetail.data.categoryName);
            }
            if (productDetail.data.weight > 0.0f) {
                m4648a(this.f8432q.getString(R.string.product_weight), tableLayout, productDetail.data.weight + "(kg)");
            }
            java.lang.String str4 = productDetail.data.brand;
            if (str4 != null && !str4.isEmpty()) {
                m4648a(this.f8432q.getString(R.string.brand), tableLayout, productDetail.data.brand);
            }
            if (this.f8434s.equals("customer") && productDetail.data.guaranteeDays > 0) {
                m4648a(this.f8432q.getString(R.string.guarantee_day), tableLayout, productDetail.data.guaranteeDays + this.f8432q.getString(R.string.day_unit));
            }
            int i = 0;
            while (true) {
                List<Product.Attribute> list = productDetail.data.attributes;
                if (list == null || i >= list.size()) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; productDetail.data.attributes.get(i).items != null && i2 < productDetail.data.attributes.get(i).items.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(productDetail.data.attributes.get(i).items.get(i2));
                }
                m4648a(productDetail.data.attributes.get(i).name, tableLayout, sb.toString());
                i++;
            }
            int i3 = 0;
            while (true) {
                List<Product.CustomAttribute> list2 = productDetail.data.customAttributes;
                if (list2 == null || i3 >= list2.size()) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                for (int i4 = 0; productDetail.data.customAttributes.get(i3).items != null && i4 < productDetail.data.customAttributes.get(i3).items.size(); i4++) {
                    if (i4 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(productDetail.data.customAttributes.get(i3).items.get(i4).name);
                }
                m4648a(productDetail.data.customAttributes.get(i3).name, tableLayout, sb2.toString());
                i3++;
            }
            int i5 = 0;
            while (true) {
                List<Product.EditableAttribute> list3 = productDetail.data.editableAttributes;
                if (list3 == null || i5 >= list3.size()) {
                    break;
                }
                Product.EditableAttribute editableAttribute = productDetail.data.editableAttributes.get(i5);
                List<java.lang.String> list4 = editableAttribute.value;
                if (list4 != null && editableAttribute.name != null && editableAttribute.type != null && editableAttribute.unit != null && list4.size() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    if (!editableAttribute.type.equals("range") || editableAttribute.value.size() <= 1) {
                        str = editableAttribute.value.get(0);
                    } else if (editableAttribute.value.get(0) == null || editableAttribute.value.get(0).isEmpty() || editableAttribute.value.get(1) == null || editableAttribute.value.get(1).isEmpty()) {
                        sb3.append(editableAttribute.value.get(1));
                        str2 = getResources().getString(R.string.below);
                        sb3.append(str2);
                        sb3.append(editableAttribute.unit);
                        m4648a(editableAttribute.name, tableLayout, sb3.toString());
                    } else {
                        sb3.append(editableAttribute.value.get(0));
                        sb3.append(" ~ ");
                        str = editableAttribute.value.get(1);
                    }
                    str2 = str;
                    sb3.append(str2);
                    sb3.append(editableAttribute.unit);
                    m4648a(editableAttribute.name, tableLayout, sb3.toString());
                }
                i5++;
            }
            java.lang.String str5 = productDetail.data.approvedCode;
            if (str5 != null && !str5.isEmpty()) {
                m4648a("", tableLayout, productDetail.data.approvedCode);
            }
        }
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f8432q);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, 0, 0, Util.dp2px((Context) this.f8432q, 3));
        linearLayoutCompat.setLayoutParams(c0541a);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        m4649a(productDetail.data.description, linearLayoutCompat);
        LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
        setLayoutParams(c0541a2);
        removeAllViews();
        c0541a2.setMargins(0, Util.dp2px(getContext(), 2) / 10, 0, Util.dp2px(getContext(), 3));
        tableLayout.setPadding(1, 1, 1, 1);
        addView(tableLayout, c0541a2);
        addView(linearLayoutCompat);
    }

    public void setItem(java.lang.String str) {
        setOrientation(LinearLayoutCompat.VERTICAL);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f8432q);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, 0, 0, Util.dp2px((Context) this.f8432q, 3));
        linearLayoutCompat.setLayoutParams(c0541a);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        m4649a(str, linearLayoutCompat);
        LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
        setLayoutParams(c0541a2);
        removeAllViews();
        c0541a2.setMargins(0, Util.dp2px(getContext(), 2) / 10, 0, Util.dp2px(getContext(), 3));
        addView(linearLayoutCompat);
    }

    
    public  void m4647a(int i, View view) {
        this.f8433r.m4882a(i);
        ImageDialog3 dialogC2269y2 = this.f8433r;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }
}
