package com.jeil.emarket.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.components.textview.TextView;
import java.util.Objects;


/* renamed from: b.f.a.c.r */

public class ProductAdapterLinearLayoutCompat extends LinearLayoutCompat {

    /* renamed from: q */
    public TextView f8560q;

    /* renamed from: r */
    public TextView f8561r;

    public ProductAdapterLinearLayoutCompat(Context context) {
        super(context);
        m4693a(context, (AttributeSet) null);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m4693a(Context context, AttributeSet attributeSet) {
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, 0, 0, Util.dp2px(getContext(), 15));
        setLayoutParams(c0541a);
        this.f8560q = new TextView(context);
        this.f8560q.setTextSize(1, 12.5f);
        this.f8561r = new TextView(context);
        this.f8561r.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -2));
        this.f8561r.setTextSize(1, 12.5f);
        this.f8561r.setTextColor(getResources().getColor(R.color.dark));
        this.f8561r.setLineSpacing(Util.dp2px(getContext(), 8), 1.0f);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RowTextForm);
            this.f8560q.setLayoutParams(new LinearLayoutCompat.LayoutParams(obtainStyledAttributes.getDimensionPixelSize(R.styleable.RowTextForm_rtf_width, -1) == -1 ? -2 : obtainStyledAttributes.getDimensionPixelSize(R.styleable.RowTextForm_rtf_width, -1), -2));
            setLabelText(obtainStyledAttributes.getString(R.styleable.RowTextForm_rtf_label_text));
            setMainText(obtainStyledAttributes.getString(R.styleable.RowTextForm_rtf_text));
        }
        addView(this.f8560q);
        addView(this.f8561r);
    }

    public String getText() {
        return ((CharSequence) Objects.requireNonNull(this.f8561r.getText())).toString();
    }

    public void setLabelText(String str) {
        this.f8560q.setText(str);
    }

    public void setLabelWidth(int i) {
        this.f8560q.setLayoutParams(new LinearLayoutCompat.LayoutParams((int) getResources().getDimension(i), -2));
    }

    public void setMainText(String str) {
        this.f8561r.setText(str);
    }
}
