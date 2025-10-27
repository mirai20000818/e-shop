package com.jeil.emarket.components.pickerview.date.p219d;

import java.util.List;
import com.jeil.emarket.components.pickerview.date.p216a.C2106a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2112d;
import com.jeil.emarket.components.pickerview.p220l.p223c.InterfaceC2134b;

/* renamed from: b.f.a.c.w.k.d.l */

public class C2127l implements InterfaceC2134b {


    public final  C2128m f8707a;

    public C2127l(C2128m c2128m) {
        this.f8707a = c2128m;
    }

    @Override // p078b.p159f.p160a.p190c.p214w.p220l.p223c.InterfaceC2134b

    public void mo4719a(int i) {
        C2128m c2128m = this.f8707a;
        if (c2128m.f8714g != null) {
            int min = Math.min(c2128m.f8708a.getCurrentItem(), this.f8707a.f8714g.size() - 1);
            int min2 = Math.min(i, ((List) this.f8707a.f8713f.get(min)).size() - 1);
            C2128m c2128m2 = this.f8707a;
            int min3 = c2128m2.f8711d ? 0 : Math.min(c2128m2.f8710c.getCurrentItem(), ((List) ((List) this.f8707a.f8714g.get(min)).get(min2)).size() - 1);
            C2128m c2128m3 = this.f8707a;
            c2128m3.f8710c.setAdapter(new C2106a((List) ((List) c2128m3.f8714g.get(c2128m3.f8708a.getCurrentItem())).get(min2)));
            this.f8707a.f8710c.setCurrentItem(min3);
            InterfaceC2112d interfaceC2112d = this.f8707a.f8717j;
        }
    }
}
