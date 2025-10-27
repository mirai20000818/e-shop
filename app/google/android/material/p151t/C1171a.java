package custom.google.android.material.p151t;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;
import custom.google.android.material.p153v.InterfaceC1188n;

/* renamed from: b.e.a.a.t.a */
/* loaded from: classes.dex */
public class C1171a extends Drawable implements InterfaceC1188n, TintAwareDrawable {

    /* renamed from: b */
    public a f5965b;

    /* renamed from: b.e.a.a.t.a$a */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a */
        public C1181g f5966a;

        /* renamed from: b */
        public boolean f5967b;

        public a(a aVar) {
            this.f5966a = (C1181g) aVar.f5966a.f5989b.newDrawable();
            this.f5967b = aVar.f5967b;
        }

        public a(C1181g c1181g) {
            this.f5966a = c1181g;
            this.f5967b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C1171a(new a(this));
        }
    }

    public C1171a(a aVar) {
        this.f5965b = aVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a aVar = this.f5965b;
        if (aVar.f5967b) {
            aVar.f5966a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5965b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5965b.f5966a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f5965b = new a(this.f5965b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f5965b.f5966a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f5965b.f5966a.setState(iArr)) {
            onStateChange = true;
        }
        boolean m4141a = C1172b.m4141a(iArr);
        a aVar = this.f5965b;
        if (aVar.f5967b == m4141a) {
            return onStateChange;
        }
        aVar.f5967b = m4141a;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5965b.f5966a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5965b.f5966a.setColorFilter(colorFilter);
    }

    @Override // p078b.p126e.p127a.p128a.p153v.InterfaceC1188n
    public void setShapeAppearanceModel(C1185k c1185k) {
        C1181g c1181g = this.f5965b.f5966a;
        c1181g.f5989b.f6012a = c1185k;
        c1181g.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        this.f5965b.f5966a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f5965b.f5966a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f5965b.f5966a.setTintMode(mode);
    }
}
