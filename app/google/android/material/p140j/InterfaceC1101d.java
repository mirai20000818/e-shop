package custom.google.android.material.p140j;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: b.e.a.a.j.d */
/* loaded from: classes.dex */
public interface InterfaceC1101d extends C1100c.a {

    /* renamed from: b.e.a.a.j.d$b */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b */
        public static final TypeEvaluator<e> f5576b = new b();

        /* renamed from: a */
        public final e f5577a = new e(null);

        @Override // android.animation.TypeEvaluator
        public e evaluate(float f, e eVar, e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            this.f5577a.m3982a(Util.m158a(eVar3.f5580a, eVar4.f5580a, f), Util.m158a(eVar3.f5581b, eVar4.f5581b, f), Util.m158a(eVar3.f5582c, eVar4.f5582c, f));
            return this.f5577a;
        }
    }

    /* renamed from: b.e.a.a.j.d$c */
    public static class c extends Property<InterfaceC1101d, e> {

        /* renamed from: a */
        public static final Property<InterfaceC1101d, e> f5578a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        public e get(InterfaceC1101d interfaceC1101d) {
            return interfaceC1101d.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(InterfaceC1101d interfaceC1101d, e eVar) {
            interfaceC1101d.setRevealInfo(eVar);
        }
    }

    /* renamed from: b.e.a.a.j.d$d */
    public static class d extends Property<InterfaceC1101d, Integer> {

        /* renamed from: a */
        public static final Property<InterfaceC1101d, Integer> f5579a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        public Integer get(InterfaceC1101d interfaceC1101d) {
            return Integer.valueOf(interfaceC1101d.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(InterfaceC1101d interfaceC1101d, Integer num) {
            interfaceC1101d.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* renamed from: b.e.a.a.j.d$e */
    public static class e {

        /* renamed from: a */
        public float f5580a;

        /* renamed from: b */
        public float f5581b;

        /* renamed from: c */
        public float f5582c;

        public e() {
        }

        public e(float f, float f2, float f3) {
            this.f5580a = f;
            this.f5581b = f2;
            this.f5582c = f3;
        }

        public /* synthetic */ e(a aVar) {
        }

        /* renamed from: a */
        public void m3982a(float f, float f2, float f3) {
            this.f5580a = f;
            this.f5581b = f2;
            this.f5582c = f3;
        }

        /* renamed from: a */
        public void m3983a(e eVar) {
            float f = eVar.f5580a;
            float f2 = eVar.f5581b;
            float f3 = eVar.f5582c;
            this.f5580a = f;
            this.f5581b = f2;
            this.f5582c = f3;
        }
    }

    /* renamed from: a */
    void mo3968a();

    /* renamed from: b */
    void mo3970b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
