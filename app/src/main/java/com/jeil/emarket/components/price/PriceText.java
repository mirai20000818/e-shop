package com.jeil.emarket.components.price;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;

import com.jeil.emarket.components.textview.TextView;



public class PriceText extends LinearLayoutCompat {

    /* renamed from: q */
    public TextView f12261q;

    /* renamed from: r */
    public TextView f12262r;

    /* renamed from: s */
    public boolean f12263s;

    /* renamed from: t */
    public boolean f12264t;

    /* renamed from: u */
    public boolean f12265u;

    /* renamed from: v */
    public String f12266v;

    public PriceText(Context context) {
        super(context);
        this.f12263s = false;
        this.f12264t = false;
        this.f12265u = true;
        this.f12266v = "kpw";
        m6932a(context, (AttributeSet) null);
    }

    public PriceText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12263s = false;
        this.f12264t = false;
        this.f12265u = true;
        this.f12266v = "kpw";
        m6932a(context, attributeSet);
    }


    public final void m6932a(Context context, AttributeSet attributeSet) {
        setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.f12261q = new TextView(context);
        this.f12261q.setTextColor(getResources().getColor(R.color.kpw));
        this.f12261q.setSingleLine(true);
        this.f12262r = new TextView(context);
        this.f12262r.setTextColor(getResources().getColor(R.color.light));
        this.f12262r.setText(R.string.won);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        c0541a.setMargins(Util.dp2px(context, 2), -1, 0, 0);
        this.f12262r.setLayoutParams(c0541a);
        m6934b(context, attributeSet);
        addView(this.f12261q);
        addView(this.f12262r);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6933a(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            r7.f12266v = r8
            if (r8 != 0) goto L5
            return
        L5:
            java.lang.String r0 = "kpf"
            boolean r1 = r8.equals(r0)
            r2 = 0
            if (r1 == 0) goto L16
            com.jeil.emarket.components.textview.TextView r1 = r7.f12262r
            r3 = 8
            r1.setVisibility(r3)
            goto L1b
        L16:
            com.jeil.emarket.components.textview.TextView r1 = r7.f12262r
            r1.setVisibility(r2)
        L1b:
            r1 = -1
            int r3 = r8.hashCode()
            r4 = -143157629(0xfffffffff7779683, float:-5.02168E33)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L44
            r2 = 106401(0x19fa1, float:1.491E-40)
            if (r3 == r2) goto L3c
            r0 = 106418(0x19fb2, float:1.49123E-40)
            if (r3 == r0) goto L32
            goto L4d
        L32:
            java.lang.String r0 = "kpw"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4d
            r1 = 2
            goto L4d
        L3c:
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4d
            r1 = 1
            goto L4d
        L44:
            java.lang.String r0 = "discountTotal"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4d
            r1 = 0
        L4d:
            if (r1 == 0) goto L68
            if (r1 == r6) goto L5e
            if (r1 == r5) goto L54
            goto L78
        L54:
            com.jeil.emarket.components.textview.TextView r8 = r7.f12261q
            android.content.res.Resources r0 = r7.getResources()
            r1 = 2131034235(0x7f05007b, float:1.7678982E38)
            goto L71
        L5e:
            com.jeil.emarket.components.textview.TextView r8 = r7.f12261q
            android.content.res.Resources r0 = r7.getResources()
            r1 = 2131034234(0x7f05007a, float:1.767898E38)
            goto L71
        L68:
            com.jeil.emarket.components.textview.TextView r8 = r7.f12261q
            android.content.res.Resources r0 = r7.getResources()
            r1 = 2131034388(0x7f050114, float:1.7679292E38)
        L71:
            int r0 = r0.getColor(r1)
            r8.setTextColor(r0)
        L78:
            if (r9 == 0) goto L95
            com.jeil.emarket.components.textview.TextView r8 = r7.f12261q
            int r9 = r8.getPaintFlags()
            r9 = r9 | 16
            r8.setPaintFlags(r9)
            com.jeil.emarket.components.textview.TextView r8 = r7.f12261q
            android.content.res.Resources r9 = r7.getResources()
            r0 = 2131034334(0x7f0500de, float:1.7679183E38)
            int r9 = r9.getColor(r0)
            r8.setTextColor(r9)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.price.PriceText.m6933a(java.lang.String, boolean):void");
    }


    @SuppressLint("ResourceType")
    public void m6934b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PriceText);
            setCurrency(obtainStyledAttributes.getString(0));
            m6935e(0, obtainStyledAttributes.getDimensionPixelSize(4, getResources().getDimensionPixelSize(R.dimen.font_13)));
            m6936f(0, obtainStyledAttributes.getDimensionPixelSize(5, getResources().getDimensionPixelSize(R.dimen.font_13)));
            this.f12263s = obtainStyledAttributes.getBoolean(2, false);
            setPrice(obtainStyledAttributes.getString(3));
            obtainStyledAttributes.recycle();
        }
    }

    
    public void m6935e(int i, int i2) {
        float f = i2;
        this.f12261q.setTextSize(i, f);
        this.f12262r.setTextSize(i, f * 0.8f);
    }

    /* renamed from: f */
    public void m6936f(int i, int i2) {
        this.f12262r.setTextSize(i, i2);
    }

    public void setCurrency(String str) {
        m6933a(str, false);
    }

    public void setHidePriceNumber(boolean z) {
        this.f12265u = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0061, code lost:
    
        if (r7 <= (-50.0f)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0063, code lost:
    
        r11 = java.lang.String.valueOf((int) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0089, code lost:
    
        if (r7 >= 50.0f) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00b5, code lost:
    
        if (r7 <= (-50.0f)) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPrice(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.price.PriceText.setPrice(java.lang.String):void");
    }

    public void setTextSize(int i) {
        m6935e(1, i);
    }
}
