package com.jeil.emarket.components.pickerview.date.p219d;

import java.util.List;
import com.jeil.emarket.components.pickerview.date.p216a.C2106a;
import com.jeil.emarket.components.pickerview.p220l.p223c.InterfaceC2134b;

/* renamed from: b.f.a.c.w.k.d.k */

public class C2126k implements InterfaceC2134b {


    public final  C2128m f8706a;

    public C2126k(C2128m c2128m) {
        this.f8706a = c2128m;
    }

    @Override // p078b.p159f.p160a.p190c.p214w.p220l.p223c.InterfaceC2134b

    public void mo4719a(int i) {
        C2128m c2128m = this.f8706a;
        if (c2128m.f8713f == null) {
            return;
        }
        int min = !c2128m.f8711d ? Math.min(c2128m.f8709b.getCurrentItem(), ((List) this.f8706a.f8713f.get(i)).size() - 1) : 0;
        C2128m c2128m2 = this.f8706a;
        c2128m2.f8709b.setAdapter(new C2106a((List) c2128m2.f8713f.get(i)));
        this.f8706a.f8709b.setCurrentItem(min);
        C2128m c2128m3 = this.f8706a;
        if (c2128m3.f8714g != null) {
            c2128m3.f8716i.mo4719a(min);
        }
    }
}
