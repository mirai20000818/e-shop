package com.jeil.emarket.components.pickerview.date.p219d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.jeil.emarket.components.button.CustomButton;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Objects;
import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2109a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2110b;

/* renamed from: b.f.a.c.w.k.d.j */

public class ViewOnClickListenerC2125j extends Pickerview_layout_base implements View.OnClickListener {

    
    public C2130o f8705k;

    public ViewOnClickListenerC2125j(C2108a c2108a) {
        super(c2108a.f8635L);
        this.f8694c = c2108a;
        Context context = c2108a.f8635L;
        m4723c();
        m4722b();
        ((Window) Objects.requireNonNull(this.f8701j.getWindow())).setDimAmount(0.75f);
        InterfaceC2109a interfaceC2109a = this.f8694c.f8657g;
        if (interfaceC2109a == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f8693b);
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
        LinearLayout linearLayout = (LinearLayout) m4720a(R.id.timepicker);
        linearLayout.setBackgroundColor(this.f8694c.f8640Q);
        C2108a c2108a2 = this.f8694c;
        this.f8705k = new C2130o(linearLayout, c2108a2.f8667q, c2108a2.f8634K, c2108a2.f8641R);
        if (this.f8694c.f8655e != null) {
            this.f8705k.f8744w = new InterfaceC2110b() { // from class: b.f.a.c.w.k.d.c
                @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2110b
                
                public final void mo4717a() {
                    ViewOnClickListenerC2125j.this.m4730f();
                }
            };
        }
        C2130o c2130o = this.f8705k;
        C2108a c2108a3 = this.f8694c;
        c2130o.m4742a(c2108a3.f8669s, c2108a3.f8670t);
        m4729e();
        m4731g();
        C2130o c2130o2 = this.f8705k;
        C2108a c2108a4 = this.f8694c;
        c2130o2.m4741a(c2108a4.f8674x, c2108a4.f8675y, c2108a4.f8676z, c2108a4.f8624A, c2108a4.f8625B, c2108a4.f8626C);
        C2130o c2130o3 = this.f8705k;
        C2108a c2108a5 = this.f8694c;
        c2130o3.m4746b(c2108a5.f8627D, c2108a5.f8628E, c2108a5.f8629F, c2108a5.f8630G, c2108a5.f8631H, c2108a5.f8632I);
        this.f8705k.m4749d(this.f8694c.f8649Z);
        this.f8705k.m4744a(this.f8694c.f8651a0);
        this.f8705k.m4747b(this.f8694c.f8673w);
        this.f8705k.m4748c(this.f8694c.f8644U);
        this.f8705k.m4739a(this.f8694c.f8648Y);
        this.f8705k.m4735a(this.f8694c.f8645V);
        this.f8705k.m4752g(this.f8694c.f8642S);
        this.f8705k.m4751f(this.f8694c.f8643T);
    }

    
    public final void m4729e() {
        C2108a c2108a;
        Calendar calendar;
        C2108a c2108a2 = this.f8694c;
        if (c2108a2.f8669s == null || c2108a2.f8670t == null) {
            c2108a = this.f8694c;
            calendar = c2108a.f8669s;
            if (calendar == null && (calendar = c2108a.f8670t) == null) {
                return;
            }
        } else {
            Calendar calendar2 = c2108a2.f8668r;
            if (calendar2 != null && calendar2.getTimeInMillis() >= this.f8694c.f8669s.getTimeInMillis() && this.f8694c.f8668r.getTimeInMillis() <= this.f8694c.f8670t.getTimeInMillis()) {
                return;
            }
            c2108a = this.f8694c;
            calendar = c2108a.f8669s;
        }
        c2108a.f8668r = calendar;
    }

    /* renamed from: f */
    public  void m4730f() {
        try {
            this.f8694c.f8655e.m4718a(C2130o.f8721x.parse(this.f8705k.m4734a()));
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: g */
    public final void m4731g() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f8694c.f8668r;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
        } else {
            i = calendar2.get(1);
            i2 = this.f8694c.f8668r.get(2);
            i3 = this.f8694c.f8668r.get(5);
            i4 = this.f8694c.f8668r.get(11);
            i5 = this.f8694c.f8668r.get(12);
            calendar = this.f8694c.f8668r;
        }
        int i6 = calendar.get(13);
        int i7 = i5;
        int i8 = i2;
        int i9 = i4;
        int i10 = this.f8694c.f8672v;
        if (i10 != 0) {
            this.f8705k.f8733l = i10;
        }
        C2130o c2130o = this.f8705k;
        int i11 = this.f8694c.f8672v;
        c2130o.m4737a(i11 != 0 ? i11 : i, i8, i3, i9, i7, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            if (this.f8694c.f8652b != null) {
                try {
                    this.f8694c.f8652b.mo4267a(C2130o.f8721x.parse(this.f8705k.m4734a()), this.f8696e);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (str.equals("cancel") && (onClickListener = this.f8694c.f8654d) != null) {
            onClickListener.onClick(view);
        }
        m4721a();
    }
}
