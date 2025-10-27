package com.jeil.emarket.components.pickerview.date.p216a;

import com.jeil.emarket.components.pickerview.p220l.p221a.InterfaceC2131a;

/* renamed from: b.f.a.c.w.k.a.b */

public class C2107b implements InterfaceC2131a {

    
    public final int f8622a;


    public final int f8623b;

    public C2107b(int i, int i2) {
        this.f8622a = i;
        this.f8623b = i2;
    }

    @Override // p078b.p159f.p160a.p190c.p214w.p220l.p221a.InterfaceC2131a
    
    public int mo4715a() {
        return (this.f8623b - this.f8622a) + 1;
    }

    @Override // p078b.p159f.p160a.p190c.p214w.p220l.p221a.InterfaceC2131a
    public Object getItem(int i) {
        if (i < 0 || i >= mo4715a()) {
            return 0;
        }
        return Integer.valueOf(this.f8622a + i);
    }
}
