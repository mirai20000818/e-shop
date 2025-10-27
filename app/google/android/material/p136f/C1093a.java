package custom.google.android.material.p136f;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import custom.google.android.material.p151t.C1171a;
import custom.google.android.material.p151t.C1172b;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;
import custom.google.android.material.p153v.InterfaceC1188n;

/* renamed from: b.e.a.a.f.a */
/* loaded from: classes.dex */
public class C1093a {

    /* renamed from: t */
    public static final boolean f5469t;

    /* renamed from: a */
    public final MaterialButton f5470a;

    /* renamed from: b */
    public C1185k f5471b;

    /* renamed from: c */
    public int f5472c;

    /* renamed from: d */
    public int f5473d;

    /* renamed from: e */
    public int f5474e;

    /* renamed from: f */
    public int f5475f;

    /* renamed from: g */
    public int f5476g;

    /* renamed from: h */
    public int f5477h;

    /* renamed from: i */
    public PorterDuff.Mode f5478i;

    /* renamed from: j */
    public ColorStateList f5479j;

    /* renamed from: k */
    public ColorStateList f5480k;

    /* renamed from: l */
    public ColorStateList f5481l;

    /* renamed from: m */
    public Drawable f5482m;

    /* renamed from: n */
    public boolean f5483n = false;

    /* renamed from: o */
    public boolean f5484o = false;

    /* renamed from: p */
    public boolean f5485p = false;

    /* renamed from: q */
    public boolean f5486q;

    /* renamed from: r */
    public LayerDrawable f5487r;

    /* renamed from: s */
    public int f5488s;

    static {
        int i = Build.VERSION.SDK_INT;
        f5469t = true;
    }

    public C1093a(MaterialButton materialButton, C1185k c1185k) {
        this.f5470a = materialButton;
        this.f5471b = c1185k;
    }

    /* renamed from: a */
    public final InsetDrawable m3905a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f5472c, this.f5474e, this.f5473d, this.f5475f);
    }

    /* renamed from: a */
    public final C1181g m3906a(boolean z) {
        LayerDrawable layerDrawable = this.f5487r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (C1181g) (f5469t ? (LayerDrawable) ((InsetDrawable) this.f5487r.getDrawable(0)).getDrawable() : this.f5487r).getDrawable(!z ? 1 : 0);
    }

    /* renamed from: a */
    public InterfaceC1188n m3907a() {
        LayerDrawable layerDrawable = this.f5487r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (InterfaceC1188n) (this.f5487r.getNumberOfLayers() > 2 ? this.f5487r.getDrawable(2) : this.f5487r.getDrawable(1));
    }

    /* renamed from: a */
    public void m3909a(TypedArray typedArray) {
        this.f5472c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.f5473d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.f5474e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f5475f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R$styleable.MaterialButton_cornerRadius)) {
            this.f5476g = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
            m3910a(this.f5471b.m4178a(this.f5476g));
            this.f5485p = true;
        }
        this.f5477h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.f5478i = Util.m201a(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f5479j = Util.m197a(this.f5470a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.f5480k = Util.m197a(this.f5470a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.f5481l = Util.m197a(this.f5470a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.f5486q = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        this.f5488s = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        int m1316s = ViewCompat.m1316s(this.f5470a);
        int paddingTop = this.f5470a.getPaddingTop();
        int m1315r = ViewCompat.m1315r(this.f5470a);
        int paddingBottom = this.f5470a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            this.f5484o = true;
            this.f5470a.setSupportBackgroundTintList(this.f5479j);
            this.f5470a.setSupportBackgroundTintMode(this.f5478i);
        } else {
            m3913d();
        }
        MaterialButton materialButton = this.f5470a;
        int i = m1316s + this.f5472c;
        int i2 = paddingTop + this.f5474e;
        int i3 = m1315r + this.f5473d;
        int i4 = paddingBottom + this.f5475f;
        int i5 = Build.VERSION.SDK_INT;
        materialButton.setPaddingRelative(i, i2, i3, i4);
    }

    /* renamed from: b */
    public C1181g m3911b() {
        return m3906a(false);
    }

    /* renamed from: c */
    public final C1181g m3912c() {
        return m3906a(true);
    }

    /* renamed from: d */
    public final void m3913d() {
        Drawable m3905a;
        MaterialButton materialButton = this.f5470a;
        C1181g c1181g = new C1181g(this.f5471b);
        c1181g.m4155a(this.f5470a.getContext());
        ColorStateList colorStateList = this.f5479j;
        int i = Build.VERSION.SDK_INT;
        c1181g.setTintList(colorStateList);
        PorterDuff.Mode mode = this.f5478i;
        if (mode != null) {
            int i2 = Build.VERSION.SDK_INT;
            c1181g.setTintMode(mode);
        }
        c1181g.m4154a(this.f5477h, this.f5480k);
        C1181g c1181g2 = new C1181g(this.f5471b);
        c1181g2.setTint(0);
        c1181g2.m4153a(this.f5477h, this.f5483n ? Util.m174a((View) this.f5470a, R$attr.colorSurface) : 0);
        if (f5469t) {
            this.f5482m = new C1181g(this.f5471b);
            Drawable drawable = this.f5482m;
            int i3 = Build.VERSION.SDK_INT;
            drawable.setTint(-1);
            this.f5487r = new RippleDrawable(C1172b.m4140a(this.f5481l), m3905a(new LayerDrawable(new Drawable[]{c1181g2, c1181g})), this.f5482m);
            m3905a = this.f5487r;
        } else {
            this.f5482m = new C1171a(new C1171a.a(new C1181g(this.f5471b)));
            Drawable drawable2 = this.f5482m;
            ColorStateList m4140a = C1172b.m4140a(this.f5481l);
            int i4 = Build.VERSION.SDK_INT;
            drawable2.setTintList(m4140a);
            this.f5487r = new LayerDrawable(new Drawable[]{c1181g2, c1181g, this.f5482m});
            m3905a = m3905a(this.f5487r);
        }
        materialButton.setInternalBackground(m3905a);
        C1181g m3911b = m3911b();
        if (m3911b != null) {
            m3911b.m4152a(this.f5488s);
        }
    }

    /* renamed from: e */
    public final void m3914e() {
        C1181g m3911b = m3911b();
        C1181g m3912c = m3912c();
        if (m3911b != null) {
            m3911b.m4154a(this.f5477h, this.f5480k);
            if (m3912c != null) {
                m3912c.m4153a(this.f5477h, this.f5483n ? Util.m174a((View) this.f5470a, R$attr.colorSurface) : 0);
            }
        }
    }

    /* renamed from: a */
    public void m3910a(C1185k c1185k) {
        this.f5471b = c1185k;
        if (m3911b() != null) {
            C1181g m3911b = m3911b();
            m3911b.f5989b.f6012a = c1185k;
            m3911b.invalidateSelf();
        }
        if (m3912c() != null) {
            C1181g m3912c = m3912c();
            m3912c.f5989b.f6012a = c1185k;
            m3912c.invalidateSelf();
        }
        if (m3907a() != null) {
            m3907a().setShapeAppearanceModel(c1185k);
        }
    }

    /* renamed from: a */
    public final void m3908a(int i, int i2) {
        int m1316s = ViewCompat.m1316s(this.f5470a);
        int paddingTop = this.f5470a.getPaddingTop();
        int m1315r = ViewCompat.m1315r(this.f5470a);
        int paddingBottom = this.f5470a.getPaddingBottom();
        int i3 = this.f5474e;
        int i4 = this.f5475f;
        this.f5475f = i2;
        this.f5474e = i;
        if (!this.f5484o) {
            m3913d();
        }
        int i5 = Build.VERSION.SDK_INT;
        this.f5470a.setPaddingRelative(m1316s, (paddingTop + i) - i3, m1315r, (paddingBottom + i2) - i4);
    }
}
