package custom.google.android.material.mng3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: b.e.a.a.b.f */
/* loaded from: classes.dex */
public class C1076f<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    public C1077g f5433a;

    /* renamed from: b */
    public int f5434b;

    /* renamed from: c */
    public int f5435c;

    public C1076f() {
        this.f5434b = 0;
        this.f5435c = 0;
    }

    public C1076f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5434b = 0;
        this.f5435c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c
    /* renamed from: a */
    public boolean mo2389a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo3891b(coordinatorLayout, (CoordinatorLayout) v, i);
        if (this.f5433a == null) {
            this.f5433a = new C1077g(v);
        }
        C1077g c1077g = this.f5433a;
        c1077g.f5437b = c1077g.f5436a.getTop();
        c1077g.f5438c = c1077g.f5436a.getLeft();
        this.f5433a.m3898a();
        int i2 = this.f5434b;
        if (i2 != 0) {
            C1077g c1077g2 = this.f5433a;
            if (c1077g2.f5441f && c1077g2.f5439d != i2) {
                c1077g2.f5439d = i2;
                c1077g2.m3898a();
            }
            this.f5434b = 0;
        }
        int i3 = this.f5435c;
        if (i3 == 0) {
            return true;
        }
        C1077g c1077g3 = this.f5433a;
        if (c1077g3.f5442g && c1077g3.f5440e != i3) {
            c1077g3.f5440e = i3;
            c1077g3.m3898a();
        }
        this.f5435c = 0;
        return true;
    }

    /* renamed from: b */
    public void mo3891b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m2372c(v, i);
    }

    /* renamed from: j */
    public int m3897j() {
        C1077g c1077g = this.f5433a;
        if (c1077g != null) {
            return c1077g.f5439d;
        }
        return 0;
    }

    /* renamed from: a */
    public boolean m3896a(int i) {
        C1077g c1077g = this.f5433a;
        if (c1077g != null) {
            if (!c1077g.f5441f || c1077g.f5439d == i) {
                return false;
            }
            c1077g.f5439d = i;
            c1077g.m3898a();
            return true;
        }
        this.f5434b = i;
        return false;
    }
}
