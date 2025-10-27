package custom.google.android.material.p156y;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.p007b.p008a.C0052a;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import custom.google.android.material.mng1.AnimationUtils;
import custom.google.android.material.internal.C1156n;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;

/* renamed from: b.e.a.a.y.g */
/* loaded from: classes.dex */
public class C1202g extends AbstractC1204i {

    /* renamed from: q */
    public static final boolean f6137q;

    /* renamed from: d */
    public final TextWatcher f6138d;

    /* renamed from: e */
    public final View.OnFocusChangeListener f6139e;

    /* renamed from: f */
    public final TextInputLayout.C3065e f6140f;

    /* renamed from: g */
    public final TextInputLayout.InterfaceC3066f f6141g;

    /* renamed from: h */
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.InterfaceC3067g f6142h;

    /* renamed from: i */
    public boolean f6143i;

    /* renamed from: j */
    public boolean f6144j;

    /* renamed from: k */
    public long f6145k;

    /* renamed from: l */
    public StateListDrawable f6146l;

    /* renamed from: m */
    public C1181g f6147m;

    /* renamed from: n */
    public AccessibilityManager f6148n;

    /* renamed from: o */
    public ValueAnimator f6149o;

    /* renamed from: p */
    public ValueAnimator f6150p;

    /* renamed from: b.e.a.a.y.g$a */
    public class a extends C1156n {

        /* renamed from: b.e.a.a.y.g$a$a, reason: collision with other inner class name */
        public class RunnableC3397a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ AutoCompleteTextView f6152b;

            public RunnableC3397a(AutoCompleteTextView autoCompleteTextView) {
                this.f6152b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f6152b.isPopupShowing();
                C1202g.m4228a(C1202g.this, isPopupShowing);
                C1202g.this.f6143i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // p078b.p126e.p127a.p128a.p147p.C1156n, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView m4226a = C1202g.m4226a(C1202g.this.f6166a.getEditText());
            if (C1202g.this.f6148n.isTouchExplorationEnabled()) {
                if ((m4226a.getKeyListener() != null) && !C1202g.this.f6168c.hasFocus()) {
                    m4226a.dismissDropDown();
                }
            }
            m4226a.post(new RunnableC3397a(m4226a));
        }
    }

    /* renamed from: b.e.a.a.y.g$b */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C1202g.this.f6168c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: b.e.a.a.y.g$c */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            C1202g.this.f6166a.setEndIconActivated(z);
            if (z) {
                return;
            }
            C1202g.m4228a(C1202g.this, false);
            C1202g.this.f6143i = false;
        }
    }

    /* renamed from: b.e.a.a.y.g$d */
    public class d extends TextInputLayout.C3065e {
        public d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.C3065e, p000a.p030h.p042i.C0271a
        /* renamed from: a */
        public void mo1151a(View view, AccessibilityNodeInfoCompat c0281b) {
            boolean z;
            super.mo1151a(view, c0281b);
            if (!C1202g.m4230b(C1202g.this.f6166a.getEditText())) {
                c0281b.f1813a.setClassName(Spinner.class.getName());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                z = c0281b.f1813a.isShowingHintText();
            } else {
                Bundle m1209d = c0281b.m1209d();
                z = m1209d != null && (m1209d.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                c0281b.m1201a((CharSequence) null);
            }
        }

        @Override // p000a.p030h.p042i.C0271a
        /* renamed from: c */
        public void mo1156c(View view, AccessibilityEvent accessibilityEvent) {
            this.f1759a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView m4226a = C1202g.m4226a(C1202g.this.f6166a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && C1202g.this.f6148n.isTouchExplorationEnabled()) {
                if (C1202g.this.f6166a.getEditText().getKeyListener() != null) {
                    return;
                }
                C1202g.this.m4240d(m4226a);
            }
        }
    }

    /* renamed from: b.e.a.a.y.g$e */
    public class e implements TextInputLayout.InterfaceC3066f {
        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC3066f
        /* renamed from: a */
        public void mo4221a(TextInputLayout textInputLayout) {
            AutoCompleteTextView m4226a = C1202g.m4226a(textInputLayout.getEditText());
            C1202g.this.m4235b(m4226a);
            C1202g.this.m4233a(m4226a);
            C1202g.this.m4238c(m4226a);
            m4226a.setThreshold(0);
            m4226a.removeTextChangedListener(C1202g.this.f6138d);
            m4226a.addTextChangedListener(C1202g.this.f6138d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!C1202g.m4230b((EditText) m4226a)) {
                ViewCompat.m1305h(C1202g.this.f6168c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(C1202g.this.f6140f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: b.e.a.a.y.g$f */
    public class f implements TextInputLayout.InterfaceC3067g {

        /* renamed from: b.e.a.a.y.g$f$a */
        public class a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ AutoCompleteTextView f6159b;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.f6159b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6159b.removeTextChangedListener(C1202g.this.f6138d);
            }
        }

        public f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC3067g
        /* renamed from: a */
        public void mo4222a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == C1202g.this.f6139e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (C1202g.f6137q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* renamed from: b.e.a.a.y.g$g */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1202g.this.m4240d((AutoCompleteTextView) C1202g.this.f6166a.getEditText());
        }
    }

    /* renamed from: b.e.a.a.y.g$h */
    public class h implements View.OnTouchListener {

        /* renamed from: b */
        public final /* synthetic */ AutoCompleteTextView f6162b;

        public h(AutoCompleteTextView autoCompleteTextView) {
            this.f6162b = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (C1202g.this.m4239c()) {
                    C1202g.this.f6143i = false;
                }
                C1202g.this.m4240d(this.f6162b);
            }
            return false;
        }
    }

    /* renamed from: b.e.a.a.y.g$i */
    public class i implements AutoCompleteTextView.OnDismissListener {
        public i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            C1202g c1202g = C1202g.this;
            c1202g.f6143i = true;
            c1202g.f6145k = System.currentTimeMillis();
            C1202g.this.m4236b(false);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f6137q = true;
    }

    public C1202g(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6138d = new a();
        this.f6139e = new c();
        this.f6140f = new d(this.f6166a);
        this.f6141g = new e();
        this.f6142h = new f();
        this.f6143i = false;
        this.f6144j = false;
        this.f6145k = Long.MAX_VALUE;
    }

    /* renamed from: a */
    public static /* synthetic */ AutoCompleteTextView m4226a(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* renamed from: b */
    public static boolean m4230b(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* renamed from: a */
    public final ValueAnimator m4231a(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    @Override // p078b.p126e.p127a.p128a.p156y.AbstractC1204i
    /* renamed from: a */
    public boolean mo4234a(int i2) {
        return i2 != 0;
    }

    /* renamed from: b */
    public final void m4235b(AutoCompleteTextView autoCompleteTextView) {
        Drawable drawable;
        if (f6137q) {
            int boxBackgroundMode = this.f6166a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = this.f6147m;
            } else if (boxBackgroundMode != 1) {
                return;
            } else {
                drawable = this.f6146l;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
        }
    }

    /* renamed from: b */
    public final void m4236b(boolean z) {
        if (this.f6144j != z) {
            this.f6144j = z;
            this.f6150p.cancel();
            this.f6149o.start();
        }
    }

    @Override // p078b.p126e.p127a.p128a.p156y.AbstractC1204i
    /* renamed from: b */
    public boolean mo4237b() {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: c */
    public final void m4238c(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f6139e);
        if (f6137q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* renamed from: c */
    public final boolean m4239c() {
        long currentTimeMillis = System.currentTimeMillis() - this.f6145k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* renamed from: d */
    public final void m4240d(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (m4239c()) {
            this.f6143i = false;
        }
        if (this.f6143i) {
            this.f6143i = false;
            return;
        }
        if (f6137q) {
            boolean z = this.f6144j;
            boolean z2 = !z;
            if (z != z2) {
                this.f6144j = z2;
                this.f6150p.cancel();
                this.f6149o.start();
            }
        } else {
            this.f6144j = !this.f6144j;
            this.f6168c.toggle();
        }
        if (!this.f6144j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m4228a(C1202g c1202g, boolean z) {
        if (c1202g.f6144j != z) {
            c1202g.f6144j = z;
            c1202g.f6150p.cancel();
            c1202g.f6149o.start();
        }
    }

    /* renamed from: a */
    public final void m4233a(AutoCompleteTextView autoCompleteTextView) {
        LayerDrawable layerDrawable;
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.f6166a.getBoxBackgroundMode();
        C1181g boxBackground = this.f6166a.getBoxBackground();
        int m174a = Util.m174a((View) autoCompleteTextView, R$attr.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            int m174a2 = Util.m174a((View) autoCompleteTextView, R$attr.colorSurface);
            C1181g c1181g = new C1181g(boxBackground.f5989b.f6012a);
            int m166a = Util.m166a(m174a, m174a2, 0.1f);
            c1181g.m4156a(new ColorStateList(iArr, new int[]{m166a, 0}));
            if (f6137q) {
                c1181g.setTint(m174a2);
                ColorStateList colorStateList = new ColorStateList(iArr, new int[]{m166a, m174a2});
                C1181g c1181g2 = new C1181g(boxBackground.f5989b.f6012a);
                c1181g2.setTint(-1);
                layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, c1181g, c1181g2), boxBackground});
            } else {
                layerDrawable = new LayerDrawable(new Drawable[]{c1181g, boxBackground});
            }
            ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
            return;
        }
        if (boxBackgroundMode == 1) {
            int boxBackgroundColor = this.f6166a.getBoxBackgroundColor();
            int[] iArr2 = {Util.m166a(m174a, boxBackgroundColor, 0.1f), boxBackgroundColor};
            if (f6137q) {
                ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), boxBackground, boxBackground));
                return;
            }
            C1181g c1181g3 = new C1181g(boxBackground.f5989b.f6012a);
            c1181g3.m4156a(new ColorStateList(iArr, iArr2));
            LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{boxBackground, c1181g3});
            int m1316s = ViewCompat.m1316s(autoCompleteTextView);
            int paddingTop = autoCompleteTextView.getPaddingTop();
            int m1315r = ViewCompat.m1315r(autoCompleteTextView);
            int paddingBottom = autoCompleteTextView.getPaddingBottom();
            int i2 = Build.VERSION.SDK_INT;
            autoCompleteTextView.setBackground(layerDrawable2);
            int i3 = Build.VERSION.SDK_INT;
            autoCompleteTextView.setPaddingRelative(m1316s, paddingTop, m1315r, paddingBottom);
        }
    }

    /* renamed from: a */
    public final C1181g m4232a(float f2, float f3, float f4, int i2) {
        C1185k.b bVar = new C1185k.b();
        bVar.m4188d(f2);
        bVar.m4189e(f2);
        bVar.m4186b(f3);
        bVar.m4187c(f3);
        C1185k m4185a = bVar.m4185a();
        C1181g m4147a = C1181g.m4147a(this.f6167b, f4);
        m4147a.f5989b.f6012a = m4185a;
        m4147a.invalidateSelf();
        C1181g.b bVar2 = m4147a.f5989b;
        if (bVar2.f6020i == null) {
            bVar2.f6020i = new Rect();
        }
        m4147a.f5989b.f6020i.set(0, i2, 0, i2);
        m4147a.invalidateSelf();
        return m4147a;
    }

    @Override // p078b.p126e.p127a.p128a.p156y.AbstractC1204i
    /* renamed from: a */
    public void mo4218a() {
        float dimensionPixelOffset = this.f6167b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f6167b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f6167b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        C1181g m4232a = m4232a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        C1181g m4232a2 = m4232a(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f6147m = m4232a;
        this.f6146l = new StateListDrawable();
        this.f6146l.addState(new int[]{R.attr.state_above_anchor}, m4232a);
        this.f6146l.addState(new int[0], m4232a2);
        this.f6166a.setEndIconDrawable(C0052a.m373c(this.f6167b, f6137q ? R$drawable.mtrl_dropdown_arrow : R$drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f6166a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.f6166a.setEndIconOnClickListener(new g());
        this.f6166a.m6192a(this.f6141g);
        this.f6166a.m6193a(this.f6142h);
        this.f6150p = m4231a(67, 0.0f, 1.0f);
        this.f6149o = m4231a(50, 1.0f, 0.0f);
        this.f6149o.addListener(new C1203h(this));
        this.f6148n = (AccessibilityManager) this.f6167b.getSystemService("accessibility");
    }
}
