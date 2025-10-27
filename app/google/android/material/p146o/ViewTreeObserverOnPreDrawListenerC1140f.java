package custom.google.android.material.p146o;

import android.view.ViewTreeObserver;

/* renamed from: b.e.a.a.o.f */
/* loaded from: classes.dex */
public class ViewTreeObserverOnPreDrawListenerC1140f implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b */
    public final /* synthetic */ C1138d f5771b;

    public ViewTreeObserverOnPreDrawListenerC1140f(C1138d c1138d) {
        this.f5771b = c1138d;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        C1138d c1138d = this.f5771b;
        float rotation = c1138d.f5759x.getRotation();
        if (c1138d.f5752q == rotation) {
            return true;
        }
        c1138d.f5752q = rotation;
        c1138d.mo4067l();
        return true;
    }
}
