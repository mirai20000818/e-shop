package com.jeil.emarket.components.pickerview;

import android.content.Context;
import android.view.View;

import java.util.Calendar;
import java.util.Date;
import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2125j;

/* renamed from: b.f.a.c.w.j */

public class PickerObj3 {


    public boolean f8617a;

    
    public ViewOnClickListenerC2125j f8618b;

    
    public InterfaceC2115g f8619c;

    
    public int f8620d;

    public PickerObj3(Context context) {
        this.f8617a = false;
        m4711a(context);
    }

    public PickerObj3(Context context, boolean z) {
        this.f8617a = false;
        this.f8617a = z;
        m4711a(context);
    }

    public PickerObj3(Context context, boolean z, int i) {
        this.f8617a = false;
        this.f8617a = z;
        this.f8620d = i;
        m4711a(context);
    }


    public void m4710a() {
        ViewOnClickListenerC2125j viewOnClickListenerC2125j = this.f8618b;
        if (viewOnClickListenerC2125j != null) {
            viewOnClickListenerC2125j.m4724d();
        }
    }


    public void m4711a(Context context) {
        int i = this.f8620d;
        InterfaceC2115g interfaceC2115g = new InterfaceC2115g() { // from class: b.f.a.c.w.f
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

            public final void mo4267a(Date date, View view) {
                PickerObj3.this.m4713a(date, view);
            }
        };
        C2108a c2108a = new C2108a(2);
        c2108a.f8672v = i;
        c2108a.f8635L = context;
        c2108a.f8652b = interfaceC2115g;
        c2108a.f8667q = this.f8617a ? new boolean[]{true, true, true, false, false, false} : new boolean[]{true, true, true, true, true, false};
        c2108a.f8644U = context.getResources().getColor(R.color.grey);
        c2108a.f8643T = context.getResources().getColor(R.color.dark);
        c2108a.f8649Z = 3;
        c2108a.f8645V = 2.7f;
        this.f8618b = new ViewOnClickListenerC2125j(c2108a);
    }


    public  void m4713a(Date date, View view) {
        InterfaceC2115g interfaceC2115g = this.f8619c;
        if (interfaceC2115g != null) {
            interfaceC2115g.mo4267a(date, view);
        }
    }

    
    public void m4714b(Date date) {
        if (this.f8618b != null) {
            if (date == null) {
                date = new Date();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            ViewOnClickListenerC2125j viewOnClickListenerC2125j = this.f8618b;
            viewOnClickListenerC2125j.f8694c.f8668r = calendar;
            viewOnClickListenerC2125j.m4731g();
        }
    }


    public void m4712a(Date date) {
        if (this.f8618b != null) {
            if (date == null) {
                date = new Date();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            ViewOnClickListenerC2125j viewOnClickListenerC2125j = this.f8618b;
            viewOnClickListenerC2125j.f8705k.m4742a(calendar, viewOnClickListenerC2125j.f8694c.f8670t);
            viewOnClickListenerC2125j.m4729e();
        }
    }
}
