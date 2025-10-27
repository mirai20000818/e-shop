package com.jeil.emarket.components.pickerview.date.p219d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.textview.TextView;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2109a;
import com.anievaluate.evaluate.C2948g;

/* renamed from: b.f.a.c.w.k.d.h */

public class ViewOnClickListenerC2123h extends Pickerview_layout_base implements View.OnClickListener {

    
    public C2130o f8702k;

    /* renamed from: l */
    public C2130o f8703l;

    public ViewOnClickListenerC2123h(C2108a c2108a) {
        super(c2108a.f8635L);
        int i;
        this.f8694c = c2108a;
        Context context = c2108a.f8635L;
        m4723c();
        m4722b();
        ((Window) Objects.requireNonNull(this.f8701j.getWindow())).setDimAmount(0.7f);
        InterfaceC2109a interfaceC2109a = this.f8694c.f8657g;
        if (interfaceC2109a == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_date_range, this.f8693b);
            CustomButton customButton = (CustomButton) m4720a(R.id.cb_ok);
            CustomButton customButton2 = (CustomButton) m4720a(R.id.cb_cancel);
            customButton.setTag("submit");
            customButton2.setTag("cancel");
            customButton.setOnClickListener(this);
            customButton2.setOnClickListener(this);
            customButton.setText(TextUtils.isEmpty(this.f8694c.f8636M) ? context.getResources().getString(R.string.pickerview_submit) : this.f8694c.f8636M);
            customButton2.setText(TextUtils.isEmpty(this.f8694c.f8637N) ? context.getResources().getString(R.string.pickerview_cancel) : this.f8694c.f8637N);
        } else {
            interfaceC2109a.m4716a(LayoutInflater.from(context).inflate(this.f8694c.f8633J, this.f8693b));
        }
        final LinearLayout linearLayout = (LinearLayout) m4720a(R.id.timepicker);
        final LinearLayout linearLayout2 = (LinearLayout) m4720a(R.id.timepicker_end);
        linearLayout.setBackgroundColor(this.f8694c.f8640Q);
        linearLayout2.setBackgroundColor(this.f8694c.f8640Q);
        C2108a c2108a2 = this.f8694c;
        this.f8702k = new C2130o(linearLayout, c2108a2.f8667q, c2108a2.f8634K, c2108a2.f8641R);
        C2108a c2108a3 = this.f8694c;
        this.f8703l = new C2130o(linearLayout2, c2108a3.f8667q, c2108a3.f8634K, c2108a3.f8641R, c2108a3.f8658h);
        C2108a c2108a4 = this.f8694c;
        int i2 = c2108a4.f8671u;
        if (i2 != 0 && (i = c2108a4.f8672v) != 0 && i2 <= i) {
            this.f8702k.m4750e(i2);
            C2130o c2130o = this.f8702k;
            C2108a c2108a5 = this.f8694c;
            c2130o.f8733l = c2108a5.f8672v;
            this.f8703l.m4750e(c2108a5.f8671u);
            this.f8703l.f8733l = this.f8694c.f8672v;
        }
        C2108a c2108a6 = this.f8694c;
        Calendar calendar = c2108a6.f8669s;
        if (calendar == null || c2108a6.f8670t == null) {
            C2108a c2108a7 = this.f8694c;
            Calendar calendar2 = c2108a7.f8669s;
            if (calendar2 == null) {
                Calendar calendar3 = c2108a7.f8670t;
                if (calendar3 != null && calendar3.get(1) > 2100) {
                    throw new IllegalArgumentException("The endDate should not be later than 2100");
                }
            } else if (calendar2.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
        } else if (calendar.getTimeInMillis() > this.f8694c.f8670t.getTimeInMillis()) {
            throw new IllegalArgumentException("startDate can't be later than endDate");
        }
        m4727e();
        m4728f();
        C2130o c2130o2 = this.f8702k;
        C2108a c2108a8 = this.f8694c;
        c2130o2.m4741a(c2108a8.f8674x, c2108a8.f8675y, c2108a8.f8676z, c2108a8.f8624A, c2108a8.f8625B, c2108a8.f8626C);
        C2130o c2130o3 = this.f8702k;
        C2108a c2108a9 = this.f8694c;
        c2130o3.m4746b(c2108a9.f8627D, c2108a9.f8628E, c2108a9.f8629F, c2108a9.f8630G, c2108a9.f8631H, c2108a9.f8632I);
        this.f8702k.m4749d(this.f8694c.f8649Z);
        this.f8702k.m4744a(this.f8694c.f8651a0);
        this.f8702k.m4747b(this.f8694c.f8673w);
        this.f8702k.m4748c(this.f8694c.f8644U);
        this.f8702k.m4739a(this.f8694c.f8648Y);
        this.f8702k.m4735a(this.f8694c.f8645V);
        this.f8702k.m4752g(this.f8694c.f8642S);
        this.f8702k.m4751f(this.f8694c.f8643T);
        C2130o c2130o4 = this.f8703l;
        C2108a c2108a10 = this.f8694c;
        c2130o4.m4741a(c2108a10.f8674x, c2108a10.f8675y, c2108a10.f8676z, c2108a10.f8624A, c2108a10.f8625B, c2108a10.f8626C);
        C2130o c2130o5 = this.f8703l;
        C2108a c2108a11 = this.f8694c;
        c2130o5.m4746b(c2108a11.f8627D, c2108a11.f8628E, c2108a11.f8629F, c2108a11.f8630G, c2108a11.f8631H, c2108a11.f8632I);
        this.f8703l.m4749d(this.f8694c.f8649Z);
        this.f8703l.m4744a(this.f8694c.f8651a0);
        this.f8703l.m4747b(this.f8694c.f8673w);
        this.f8703l.m4748c(this.f8694c.f8644U);
        this.f8703l.m4739a(this.f8694c.f8648Y);
        this.f8703l.m4735a(this.f8694c.f8645V);
        this.f8703l.m4752g(this.f8694c.f8642S);
        this.f8703l.m4751f(this.f8694c.f8643T);
        final TextView textView = (TextView) m4720a(R.id.tv_start_date);
        final TextView textView2 = (TextView) m4720a(R.id.tv_end_date);
        textView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.w.k.d.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewOnClickListenerC2123h.this.m4725a(linearLayout, linearLayout2, textView, textView2, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.w.k.d.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewOnClickListenerC2123h.this.m4726b(linearLayout2, linearLayout, textView2, textView, view);
            }
        });
    }


    public  void m4725a(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        if (linearLayout.getVisibility() == 8) {
            linearLayout.setVisibility(View.VISIBLE);
            C2948g m5805a = C2948g.m5805a(linearLayout, "alpha", 0.0f, 1.0f);
            m5805a.m5807b(300L);
            m5805a.m5809c();
            linearLayout2.setVisibility(View.GONE);
            textView.setTextColor(this.f8694c.f8638O);
            textView2.setTextColor(this.f8694c.f8639P);
        }
    }

    
    public  void m4726b(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        if (linearLayout.getVisibility() == 8) {
            linearLayout2.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);
            C2948g m5805a = C2948g.m5805a(linearLayout, "alpha", 0.0f, 1.0f);
            m5805a.m5807b(300L);
            m5805a.m5809c();
            textView.setTextColor(this.f8694c.f8638O);
            textView2.setTextColor(this.f8694c.f8639P);
            if (this.f8694c.f8658h > 0) {
                try {
                    Date parse = C2130o.f8721x.parse(this.f8702k.m4734a());
                    int year = parse.getYear();
                    int month = parse.getMonth();
                    int date = parse.getDate();
                    Date date2 = this.f8694c.f8659i ? new Date(year, month, this.f8694c.f8658h + date) : new Date(year, this.f8694c.f8658h + month, date);
                    Calendar calendar = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar.setTime(parse);
                    calendar2.setTime(date2);
                    this.f8703l.m4742a(calendar, calendar2);
                    m4728f();
                    this.f8702k.m4737a(year + 1900, month, date, 0, 0, 0);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    
    public final void m4727e() {
        C2108a c2108a;
        Calendar calendar;
        C2130o c2130o = this.f8702k;
        C2108a c2108a2 = this.f8694c;
        c2130o.m4742a(c2108a2.f8669s, c2108a2.f8670t);
        C2130o c2130o2 = this.f8703l;
        C2108a c2108a3 = this.f8694c;
        c2130o2.m4742a(c2108a3.f8669s, c2108a3.f8670t);
        C2108a c2108a4 = this.f8694c;
        if (c2108a4.f8669s == null || c2108a4.f8670t == null) {
            c2108a = this.f8694c;
            calendar = c2108a.f8669s;
            if (calendar == null && (calendar = c2108a.f8670t) == null) {
                return;
            }
        } else {
            Calendar calendar2 = c2108a4.f8668r;
            if (calendar2 != null && calendar2.getTimeInMillis() >= this.f8694c.f8669s.getTimeInMillis() && this.f8694c.f8668r.getTimeInMillis() <= this.f8694c.f8670t.getTimeInMillis()) {
                return;
            }
            c2108a = this.f8694c;
            calendar = c2108a.f8669s;
        }
        c2108a.f8668r = calendar;
    }

    /* renamed from: f */
    public final void m4728f() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f8694c.f8669s;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
        } else {
            i = calendar2.get(1);
            i2 = this.f8694c.f8669s.get(2);
            i3 = this.f8694c.f8669s.get(5);
        }
        this.f8702k.m4737a(i, i2, i3, 0, 0, 0);
        Calendar calendar3 = this.f8694c.f8670t;
        if (calendar3 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i4 = calendar.get(1);
            i5 = calendar.get(2);
        } else {
            i4 = calendar3.get(1);
            i5 = this.f8694c.f8670t.get(2);
            calendar = this.f8694c.f8670t;
        }
        int i6 = calendar.get(5);
        this.f8703l.m4737a(i4, i5, i6, 0, 0, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (!str.equals("submit")) {
            if (str.equals("cancel")) {
                View.OnClickListener onClickListener = this.f8694c.f8654d;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                m4721a();
                return;
            }
            return;
        }
        if (this.f8694c.f8653c != null) {
            try {
                Date parse = C2130o.f8721x.parse(this.f8702k.m4734a());
                Date parse2 = C2130o.f8721x.parse(this.f8703l.m4734a());
                if (parse.getTime() - parse2.getTime() > 0) {
                    Util.toast(this.f8694c.f8635L, R.string.invalidate_time, "error");
                } else {
                    this.f8694c.f8653c.mo4696a(parse, parse2, this.f8696e);
                    m4721a();
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }
}
