package custom.google.android.material.p140j.p141e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import custom.google.android.material.p137g.C1094a;
import custom.google.android.material.p140j.C1100c;
import custom.google.android.material.p140j.InterfaceC1101d;

/* renamed from: b.e.a.a.j.e.a */
/* loaded from: classes.dex */
public class C1102a extends C1094a implements InterfaceC1101d {

    /* renamed from: q */
    public final C1100c f5583q;

    @Override // p078b.p126e.p127a.p128a.p140j.InterfaceC1101d
    /* renamed from: a */
    public void mo3968a() {
        this.f5583q.m3973a();
    }

    @Override // p078b.p126e.p127a.p128a.p140j.C1100c.a
    /* renamed from: a */
    public void mo3969a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // p078b.p126e.p127a.p128a.p140j.InterfaceC1101d
    /* renamed from: b */
    public void mo3970b() {
        this.f5583q.m3975b();
    }

    @Override // p078b.p126e.p127a.p128a.p140j.C1100c.a
    /* renamed from: c */
    public boolean mo3971c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        C1100c c1100c = this.f5583q;
        if (c1100c != null) {
            c1100c.m3974a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f5583q.f5573g;
    }

    @Override // p078b.p126e.p127a.p128a.p140j.InterfaceC1101d
    public int getCircularRevealScrimColor() {
        return this.f5583q.m3977c();
    }

    @Override // p078b.p126e.p127a.p128a.p140j.InterfaceC1101d
    public InterfaceC1101d.e getRevealInfo() {
        return this.f5583q.m3978d();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        C1100c c1100c = this.f5583q;
        return c1100c != null ? c1100c.m3979e() : super.isOpaque();
    }

    @Override // p078b.p126e.p127a.p128a.p140j.InterfaceC1101d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        C1100c c1100c = this.f5583q;
        c1100c.f5573g = drawable;
        c1100c.f5568b.invalidate();
    }

    @Override // p078b.p126e.p127a.p128a.p140j.InterfaceC1101d
    public void setCircularRevealScrimColor(int i) {
        C1100c c1100c = this.f5583q;
        c1100c.f5571e.setColor(i);
        c1100c.f5568b.invalidate();
    }

    @Override // p078b.p126e.p127a.p128a.p140j.InterfaceC1101d
    public void setRevealInfo(InterfaceC1101d.e eVar) {
        this.f5583q.m3976b(eVar);
    }
}
