package custom.google.android.material.internal;

import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import custom.google.android.material.p139i.C1097b;
import custom.google.android.material.p150s.AbstractC1170d;
import custom.google.android.material.p150s.C1168b;

/* renamed from: b.e.a.a.p.m */
/* loaded from: classes.dex */
public class C1155m {

    /* renamed from: c */
    public float f5912c;

    /* renamed from: e */
    public WeakReference<b> f5914e;

    /* renamed from: f */
    public C1168b f5915f;

    /* renamed from: a */
    public final TextPaint f5910a = new TextPaint(1);

    /* renamed from: b */
    public final AbstractC1170d f5911b = new a();

    /* renamed from: d */
    public boolean f5913d = true;

    /* renamed from: b.e.a.a.p.m$b */
    public interface b {
    }

    public C1155m(b bVar) {
        this.f5914e = new WeakReference<>(null);
        this.f5914e = new WeakReference<>(bVar);
    }

    /* renamed from: a */
    public float m4119a(String str) {
        if (!this.f5913d) {
            return this.f5912c;
        }
        this.f5912c = str == null ? 0.0f : this.f5910a.measureText((CharSequence) str, 0, str.length());
        this.f5913d = false;
        return this.f5912c;
    }

    /* renamed from: b.e.a.a.p.m$a */
    public class a extends AbstractC1170d {
        public a() {
        }

        @Override // p078b.p126e.p127a.p128a.p150s.AbstractC1170d
        /* renamed from: a */
        public void mo4120a(int i) {
            C1155m c1155m = C1155m.this;
            c1155m.f5913d = true;
            b bVar = c1155m.f5914e.get();
            if (bVar != null) {
                C1097b c1097b = (C1097b) bVar;
                c1097b.m3963q();
                c1097b.invalidateSelf();
            }
        }

        @Override // p078b.p126e.p127a.p128a.p150s.AbstractC1170d
        /* renamed from: a */
        public void mo4121a(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            C1155m c1155m = C1155m.this;
            c1155m.f5913d = true;
            b bVar = c1155m.f5914e.get();
            if (bVar != null) {
                C1097b c1097b = (C1097b) bVar;
                c1097b.m3963q();
                c1097b.invalidateSelf();
            }
        }
    }
}
