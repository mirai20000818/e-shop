package custom.google.android.material.p146o;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import custom.google.android.material.mng1.AnimationUtils;
import custom.google.android.material.mng1.C1059e;
import custom.google.android.material.mng1.TypeEvaluator1;
import custom.google.android.material.mng1.ObjAniManager;
import custom.google.android.material.internal.C1153k;
import custom.google.android.material.p151t.C1172b;
import custom.google.android.material.p152u.InterfaceC1174b;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;

/* renamed from: b.e.a.a.o.d */
/* loaded from: classes.dex */
public class C1138d {

    /* renamed from: E */
    public static final TimeInterpolator f5725E = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;

    /* renamed from: F */
    public static final int[] f5726F = {R.attr.state_pressed, R.attr.state_enabled};

    /* renamed from: G */
    public static final int[] f5727G = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: H */
    public static final int[] f5728H = {R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: I */
    public static final int[] f5729I = {R.attr.state_hovered, R.attr.state_enabled};

    /* renamed from: J */
    public static final int[] f5730J = {R.attr.state_enabled};

    /* renamed from: K */
    public static final int[] f5731K = new int[0];

    /* renamed from: D */
    public ViewTreeObserver.OnPreDrawListener f5735D;

    /* renamed from: a */
    public C1185k f5736a;

    /* renamed from: b */
    public C1181g f5737b;

    /* renamed from: c */
    public Drawable f5738c;

    /* renamed from: d */
    public Drawable f5739d;

    /* renamed from: e */
    public boolean f5740e;

    /* renamed from: g */
    public float f5742g;

    /* renamed from: h */
    public float f5743h;

    /* renamed from: i */
    public float f5744i;

    /* renamed from: j */
    public int f5745j;

    /* renamed from: l */
    public ObjAniManager f5747l;

    /* renamed from: m */
    public ObjAniManager f5748m;

    /* renamed from: n */
    public Animator f5749n;

    /* renamed from: o */
    public ObjAniManager f5750o;

    /* renamed from: p */
    public ObjAniManager f5751p;

    /* renamed from: q */
    public float f5752q;

    /* renamed from: s */
    public int f5754s;

    /* renamed from: u */
    public ArrayList<Animator.AnimatorListener> f5756u;

    /* renamed from: v */
    public ArrayList<Animator.AnimatorListener> f5757v;

    /* renamed from: w */
    public ArrayList<e> f5758w;

    /* renamed from: x */
    public final FloatingActionButton f5759x;

    /* renamed from: y */
    public final InterfaceC1174b f5760y;

    /* renamed from: f */
    public boolean f5741f = true;

    /* renamed from: r */
    public float f5753r = 1.0f;

    /* renamed from: t */
    public int f5755t = 0;

    /* renamed from: z */
    public final Rect f5761z = new Rect();

    /* renamed from: A */
    public final RectF f5732A = new RectF();

    /* renamed from: B */
    public final RectF f5733B = new RectF();

    /* renamed from: C */
    public final Matrix f5734C = new Matrix();

    /* renamed from: k */
    public final C1153k f5746k = new C1153k();

    /* renamed from: b.e.a.a.o.d$a */
    public class a extends TypeEvaluator1 {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            C1138d.this.f5753r = f;
            matrix.getValues(this.f5386a);
            matrix2.getValues(this.f5387b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f5387b;
                float f2 = fArr[i];
                float[] fArr2 = this.f5386a;
                fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
            }
            this.f5388c.setValues(this.f5387b);
            return this.f5388c;
        }
    }

    /* renamed from: b.e.a.a.o.d$b */
    public class b extends h {
        public b(C1138d c1138d) {
            super(null);
        }

        @Override // p078b.p126e.p127a.p128a.p146o.C1138d.h
        /* renamed from: a */
        public float mo4069a() {
            return 0.0f;
        }
    }

    /* renamed from: b.e.a.a.o.d$c */
    public class c extends h {
        public c() {
            super(null);
        }

        @Override // p078b.p126e.p127a.p128a.p146o.C1138d.h
        /* renamed from: a */
        public float mo4069a() {
            C1138d c1138d = C1138d.this;
            return c1138d.f5742g + c1138d.f5743h;
        }
    }

    /* renamed from: b.e.a.a.o.d$d */
    public class d extends h {
        public d() {
            super(null);
        }

        @Override // p078b.p126e.p127a.p128a.p146o.C1138d.h
        /* renamed from: a */
        public float mo4069a() {
            C1138d c1138d = C1138d.this;
            return c1138d.f5742g + c1138d.f5744i;
        }
    }

    /* renamed from: b.e.a.a.o.d$e */
    public interface e {
    }

    /* renamed from: b.e.a.a.o.d$f */
    public interface f {
    }

    /* renamed from: b.e.a.a.o.d$g */
    public class g extends h {
        public g() {
            super(null);
        }

        @Override // p078b.p126e.p127a.p128a.p146o.C1138d.h
        /* renamed from: a */
        public float mo4069a() {
            return C1138d.this.f5742g;
        }
    }

    /* renamed from: b.e.a.a.o.d$h */
    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public boolean f5766a;

        /* renamed from: b */
        public float f5767b;

        /* renamed from: c */
        public float f5768c;

        public /* synthetic */ h(C1136b c1136b) {
        }

        /* renamed from: a */
        public abstract float mo4069a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1138d.this.m4056b((int) this.f5768c);
            this.f5766a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f5766a) {
                C1181g c1181g = C1138d.this.f5737b;
                this.f5767b = c1181g == null ? 0.0f : c1181g.f5989b.f6026o;
                this.f5768c = mo4069a();
                this.f5766a = true;
            }
            C1138d c1138d = C1138d.this;
            float f = this.f5767b;
            c1138d.m4056b((int) ((valueAnimator.getAnimatedFraction() * (this.f5768c - f)) + f));
        }
    }

    public C1138d(FloatingActionButton floatingActionButton, InterfaceC1174b interfaceC1174b) {
        this.f5759x = floatingActionButton;
        this.f5760y = interfaceC1174b;
        this.f5746k.m4117a(f5726F, m4049a(new d()));
        this.f5746k.m4117a(f5727G, m4049a(new c()));
        this.f5746k.m4117a(f5728H, m4049a(new c()));
        this.f5746k.m4117a(f5729I, m4049a(new c()));
        this.f5746k.m4117a(f5730J, m4049a(new g()));
        this.f5746k.m4117a(f5731K, m4049a(new b(this)));
        this.f5752q = this.f5759x.getRotation();
    }

    /* renamed from: a */
    public float mo4047a() {
        throw null;
    }

    /* renamed from: a */
    public final AnimatorSet m4048a(ObjAniManager objAniManager, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f5759x, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        objAniManager.m3872a("opacity").m3874a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f5759x, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        objAniManager.m3872a("scale").m3874a(ofFloat2);
        if (Build.VERSION.SDK_INT == 26) {
            ofFloat2.setEvaluator(new C1139e(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f5759x, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        objAniManager.m3872a("scale").m3874a(ofFloat3);
        if (Build.VERSION.SDK_INT == 26) {
            ofFloat3.setEvaluator(new C1139e(this));
        }
        arrayList.add(ofFloat3);
        m4052a(f4, this.f5734C);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f5759x, new C1059e(), new a(), new Matrix(this.f5734C));
        objAniManager.m3872a("iconScale").m3874a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        Util.m230a(animatorSet, (List<Animator>) arrayList);
        return animatorSet;
    }

    /* renamed from: a */
    public final ValueAnimator m4049a(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f5725E);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    /* renamed from: a */
    public final void m4050a(float f2) {
        this.f5753r = f2;
        Matrix matrix = this.f5734C;
        m4052a(f2, matrix);
        this.f5759x.setImageMatrix(matrix);
    }

    /* renamed from: a */
    public void mo4051a(float f2, float f3, float f4) {
        throw null;
    }

    /* renamed from: a */
    public final void m4052a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.f5759x.getDrawable() == null || this.f5754s == 0) {
            return;
        }
        RectF rectF = this.f5732A;
        RectF rectF2 = this.f5733B;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.f5754s;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.f5754s;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    /* renamed from: a */
    public void mo4054a(Rect rect) {
        int sizeDimension = this.f5740e ? (this.f5745j - this.f5759x.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.f5741f ? mo4047a() + this.f5744i : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* renamed from: a */
    public void mo4055a(int[] iArr) {
        throw null;
    }

    /* renamed from: b */
    public void m4056b(float f2) {
        C1181g c1181g = this.f5737b;
        if (c1181g != null) {
            C1181g.b bVar = c1181g.f5989b;
            if (bVar.f6026o != f2) {
                bVar.f6026o = f2;
                c1181g.m4171i();
            }
        }
    }

    /* renamed from: b */
    public boolean m4057b() {
        return this.f5759x.getVisibility() == 0 ? this.f5755t == 1 : this.f5755t != 2;
    }

    /* renamed from: c */
    public boolean m4058c() {
        return this.f5759x.getVisibility() != 0 ? this.f5755t == 2 : this.f5755t != 1;
    }

    /* renamed from: d */
    public void mo4059d() {
        throw null;
    }

    /* renamed from: e */
    public void mo4060e() {
        throw null;
    }

    /* renamed from: f */
    public void m4061f() {
        ArrayList<e> arrayList = this.f5758w;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            if (it.hasNext()) {
                ((FloatingActionButton.C3057c) it.next()).m6176a();
                throw null;
            }
        }
    }

    /* renamed from: g */
    public void m4062g() {
        ArrayList<e> arrayList = this.f5758w;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            if (it.hasNext()) {
                ((FloatingActionButton.C3057c) it.next()).m6177b();
                throw null;
            }
        }
    }

    /* renamed from: h */
    public boolean mo4063h() {
        throw null;
    }

    /* renamed from: i */
    public boolean mo4064i() {
        throw null;
    }

    /* renamed from: j */
    public final boolean m4065j() {
        return ViewCompat.m1256C(this.f5759x) && !this.f5759x.isInEditMode();
    }

    /* renamed from: k */
    public final boolean m4066k() {
        return !this.f5740e || this.f5759x.getSizeDimension() >= this.f5745j;
    }

    /* renamed from: l */
    public void mo4067l() {
        throw null;
    }

    /* renamed from: m */
    public final void m4068m() {
        InterfaceC1174b interfaceC1174b;
        Drawable drawable;
        Rect rect = this.f5761z;
        mo4054a(rect);
        Util.m215a(this.f5739d, (Object) "Didn't initialize content background");
        if (mo4064i()) {
            drawable = new InsetDrawable(this.f5739d, rect.left, rect.top, rect.right, rect.bottom);
            interfaceC1174b = this.f5760y;
        } else {
            interfaceC1174b = this.f5760y;
            drawable = this.f5739d;
        }
        ((FloatingActionButton.C3056b) interfaceC1174b).m6175a(drawable);
        InterfaceC1174b interfaceC1174b2 = this.f5760y;
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        FloatingActionButton.C3056b c3056b = (FloatingActionButton.C3056b) interfaceC1174b2;
        FloatingActionButton.this.f11405m.set(i, i2, i3, i4);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        int i5 = floatingActionButton.f11402j;
        floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i4 + i5);
    }

    /* renamed from: a */
    public void mo4053a(ColorStateList colorStateList) {
        Drawable drawable = this.f5738c;
        if (drawable != null) {
            ColorStateList m4140a = C1172b.m4140a(colorStateList);
            int i = Build.VERSION.SDK_INT;
            drawable.setTintList(m4140a);
        }
    }
}
