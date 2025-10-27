package com.jeil.emarket.components.pickerview;

import android.content.Context;
import android.view.View;

import java.util.Calendar;
import java.util.Date;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.custom.font.FontManager;

/* renamed from: b.f.a.c.w.h */

public class Picker4 {


    public Context f8614a;

    
    public ViewOnClickListenerC2123h f8615b;

    
    public InterfaceC2111c f8616c;

    public Picker4(Context context) {
        this.f8614a = context;
        InterfaceC2111c interfaceC2111c = new InterfaceC2111c() { // from class: b.f.a.c.w.e
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date, Date date2, View view) {
                Picker4.this.m4706a(date, date2, view);
            }
        };
        C2108a c2108a = new C2108a(2);
        c2108a.f8635L = context;
        c2108a.f8653c = interfaceC2111c;
        c2108a.f8667q = new boolean[]{true, true, true, false, false, false};
        c2108a.f8651a0 = false;
        c2108a.f8647X = FontManager.getFont(context, "font/cheonlima.ttf");
        c2108a.f8645V = 2.7f;
        c2108a.f8638O = this.f8614a.getResources().getColor(BaseActivity.color);
        c2108a.f8639P = this.f8614a.getResources().getColor(R.color.dark);
        c2108a.f8649Z = 3;
        this.f8615b = new ViewOnClickListenerC2123h(c2108a);
    }


    public void m4704a() {
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f8615b;
        if (viewOnClickListenerC2123h != null) {
            viewOnClickListenerC2123h.m4724d();
        }
    }


    public void m4705a(Calendar calendar) {
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f8615b;
        viewOnClickListenerC2123h.f8694c.f8670t = calendar;
        viewOnClickListenerC2123h.m4728f();
    }


    public  void m4706a(Date date, Date date2, View view) {
        InterfaceC2111c interfaceC2111c = this.f8616c;
        if (interfaceC2111c != null) {
            interfaceC2111c.mo4696a(date, date2, view);
        }
    }

    
    public void m4707b(Calendar calendar) {
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f8615b;
        viewOnClickListenerC2123h.f8694c.f8669s = calendar;
        viewOnClickListenerC2123h.m4728f();
    }

    
    public  void m4708b(Date date, Date date2, View view) {
        InterfaceC2111c interfaceC2111c = this.f8616c;
        if (interfaceC2111c != null) {
            interfaceC2111c.mo4696a(date, date2, view);
        }
    }

    
    public  void m4709c(Date date, Date date2, View view) {
        InterfaceC2111c interfaceC2111c = this.f8616c;
        if (interfaceC2111c != null) {
            interfaceC2111c.mo4696a(date, date2, view);
        }
    }

    public Picker4(Context context, int i) {
        this.f8614a = context;
        InterfaceC2111c interfaceC2111c = new InterfaceC2111c() { // from class: b.f.a.c.w.d
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date, Date date2, View view) {
                Picker4.this.m4708b(date, date2, view);
            }
        };
        C2108a c2108a = new C2108a(2);
        c2108a.f8635L = context;
        c2108a.f8653c = interfaceC2111c;
        c2108a.f8667q = new boolean[]{true, true, true, false, false, false};
        c2108a.f8651a0 = false;
        c2108a.f8658h = i;
        c2108a.f8647X = FontManager.getFont(context, "font/cheonlima.ttf");
        c2108a.f8645V = 2.7f;
        c2108a.f8638O = this.f8614a.getResources().getColor(BaseActivity.color);
        c2108a.f8639P = this.f8614a.getResources().getColor(R.color.dark);
        c2108a.f8649Z = 3;
        this.f8615b = new ViewOnClickListenerC2123h(c2108a);
    }

    public Picker4(Context context, int i, boolean z) {
        this.f8614a = context;
        InterfaceC2111c interfaceC2111c = new InterfaceC2111c() { // from class: b.f.a.c.w.c
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date, Date date2, View view) {
                Picker4.this.m4709c(date, date2, view);
            }
        };
        C2108a c2108a = new C2108a(2);
        c2108a.f8635L = context;
        c2108a.f8653c = interfaceC2111c;
        c2108a.f8667q = new boolean[]{true, true, true, false, false, false};
        c2108a.f8651a0 = false;
        c2108a.f8658h = i;
        c2108a.f8659i = z;
        c2108a.f8647X = FontManager.getFont(context, "font/cheonlima.ttf");
        c2108a.f8645V = 2.7f;
        c2108a.f8641R = 16;
        c2108a.f8638O = this.f8614a.getResources().getColor(BaseActivity.color);
        c2108a.f8639P = this.f8614a.getResources().getColor(R.color.dark);
        c2108a.f8649Z = 3;
        this.f8615b = new ViewOnClickListenerC2123h(c2108a);
    }
}
