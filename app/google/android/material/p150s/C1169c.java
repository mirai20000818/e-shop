package custom.google.android.material.p150s;

import android.graphics.Typeface;
import android.text.TextPaint;

/* renamed from: b.e.a.a.s.c */
/* loaded from: classes.dex */
public class C1169c extends AbstractC1170d {

    /* renamed from: a */
    public final /* synthetic */ TextPaint f5962a;

    /* renamed from: b */
    public final /* synthetic */ AbstractC1170d f5963b;

    /* renamed from: c */
    public final /* synthetic */ C1168b f5964c;

    public C1169c(C1168b c1168b, TextPaint textPaint, AbstractC1170d abstractC1170d) {
        this.f5964c = c1168b;
        this.f5962a = textPaint;
        this.f5963b = abstractC1170d;
    }

    @Override // p078b.p126e.p127a.p128a.p150s.AbstractC1170d
    /* renamed from: a */
    public void mo4120a(int i) {
        this.f5963b.mo4120a(i);
    }

    @Override // p078b.p126e.p127a.p128a.p150s.AbstractC1170d
    /* renamed from: a */
    public void mo4121a(Typeface typeface, boolean z) {
        this.f5964c.m4136a(this.f5962a, typeface);
        this.f5963b.mo4121a(typeface, z);
    }
}
