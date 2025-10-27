package com.jeil.emarket.components.pickerview.date.p216a;

import java.util.List;
import com.jeil.emarket.components.pickerview.p220l.p221a.InterfaceC2131a;

/* renamed from: b.f.a.c.w.k.a.a */

public class C2106a<T> implements InterfaceC2131a {


    public final List<T> f8621a;

    public C2106a(List<T> list) {
        this.f8621a = list;
    }

    @Override // p078b.p159f.p160a.p190c.p214w.p220l.p221a.InterfaceC2131a

    public int mo4715a() {
        return this.f8621a.size();
    }

    @Override // p078b.p159f.p160a.p190c.p214w.p220l.p221a.InterfaceC2131a
    public Object getItem(int i) {
        return (i < 0 || i >= this.f8621a.size()) ? "" : this.f8621a.get(i);
    }
}
