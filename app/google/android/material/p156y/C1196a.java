package custom.google.android.material.p156y;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.p007b.p008a.C0052a;
import custom.google.android.material.mng1.AnimationUtils;

/* renamed from: b.e.a.a.y.a */
/* loaded from: classes.dex */
public class C1196a extends AbstractC1204i {

    /* renamed from: d */
    public final TextWatcher f6117d;

    /* renamed from: e */
    public final View.OnFocusChangeListener f6118e;

    /* renamed from: f */
    public final TextInputLayout.InterfaceC3066f f6119f;

    /* renamed from: g */
    public final TextInputLayout.InterfaceC3067g f6120g;

    /* renamed from: h */
    public AnimatorSet f6121h;

    /* renamed from: i */
    public ValueAnimator f6122i;

    /* renamed from: b.e.a.a.y.a$a */
    public class a implements TextWatcher {
        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            if ((r5.length() > 0) != false) goto L14;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void afterTextChanged(android.text.Editable r5) {
            /*
                r4 = this;
                b.e.a.a.y.a r0 = p078b.p126e.p127a.p128a.p156y.C1196a.this
                com.google.android.material.textfield.TextInputLayout r0 = r0.f6166a
                java.lang.CharSequence r0 = r0.getSuffixText()
                if (r0 == 0) goto Lb
                return
            Lb:
                b.e.a.a.y.a r0 = p078b.p126e.p127a.p128a.p156y.C1196a.this
                com.google.android.material.textfield.TextInputLayout r1 = r0.f6166a
                boolean r1 = r1.hasFocus()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L23
                int r5 = r5.length()
                if (r5 <= 0) goto L1f
                r5 = 1
                goto L20
            L1f:
                r5 = 0
            L20:
                if (r5 == 0) goto L23
                goto L24
            L23:
                r2 = 0
            L24:
                r0.m4220b(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p156y.C1196a.a.afterTextChanged(android.text.Editable):void");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: b.e.a.a.y.a$b */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            C1196a.this.m4220b((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z);
        }
    }

    /* renamed from: b.e.a.a.y.a$c */
    public class c implements TextInputLayout.InterfaceC3066f {
        public c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
        
            if ((r0.getText().length() > 0) != false) goto L11;
         */
        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC3066f
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo4221a(com.google.android.material.textfield.TextInputLayout r5) {
            /*
                r4 = this;
                android.widget.EditText r0 = r5.getEditText()
                boolean r1 = r0.hasFocus()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L1c
                android.text.Editable r1 = r0.getText()
                int r1 = r1.length()
                if (r1 <= 0) goto L18
                r1 = 1
                goto L19
            L18:
                r1 = 0
            L19:
                if (r1 == 0) goto L1c
                goto L1d
            L1c:
                r2 = 0
            L1d:
                r5.setEndIconVisible(r2)
                r5.setEndIconCheckable(r3)
                b.e.a.a.y.a r5 = p078b.p126e.p127a.p128a.p156y.C1196a.this
                android.view.View$OnFocusChangeListener r5 = r5.f6118e
                r0.setOnFocusChangeListener(r5)
                b.e.a.a.y.a r5 = p078b.p126e.p127a.p128a.p156y.C1196a.this
                android.text.TextWatcher r5 = r5.f6117d
                r0.removeTextChangedListener(r5)
                b.e.a.a.y.a r5 = p078b.p126e.p127a.p128a.p156y.C1196a.this
                android.text.TextWatcher r5 = r5.f6117d
                r0.addTextChangedListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p156y.C1196a.c.mo4221a(com.google.android.material.textfield.TextInputLayout):void");
        }
    }

    /* renamed from: b.e.a.a.y.a$d */
    public class d implements TextInputLayout.InterfaceC3067g {

        /* renamed from: b.e.a.a.y.a$d$a */
        public class a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ EditText f6127b;

            public a(EditText editText) {
                this.f6127b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6127b.removeTextChangedListener(C1196a.this.f6117d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC3067g
        /* renamed from: a */
        public void mo4222a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new a(editText));
            if (editText.getOnFocusChangeListener() == C1196a.this.f6118e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* renamed from: b.e.a.a.y.a$e */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = C1196a.this.f6166a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            C1196a.this.f6166a.m6213p();
        }
    }

    /* renamed from: b.e.a.a.y.a$f */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C1196a.this.f6168c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public C1196a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6117d = new a();
        this.f6118e = new b();
        this.f6119f = new c();
        this.f6120g = new d();
    }

    /* renamed from: a */
    public final ValueAnimator m4217a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new f());
        return ofFloat;
    }

    @Override // p078b.p126e.p127a.p128a.p156y.AbstractC1204i
    /* renamed from: a */
    public void mo4218a() {
        this.f6166a.setEndIconDrawable(C0052a.m373c(this.f6167b, R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f6166a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.f6166a.setEndIconOnClickListener(new e());
        this.f6166a.m6192a(this.f6119f);
        this.f6166a.m6193a(this.f6120g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new C1199d(this));
        ValueAnimator m4217a = m4217a(0.0f, 1.0f);
        this.f6121h = new AnimatorSet();
        this.f6121h.playTogether(ofFloat, m4217a);
        this.f6121h.addListener(new C1197b(this));
        this.f6122i = m4217a(1.0f, 0.0f);
        this.f6122i.addListener(new C1198c(this));
    }

    @Override // p078b.p126e.p127a.p128a.p156y.AbstractC1204i
    /* renamed from: a */
    public void mo4219a(boolean z) {
        if (this.f6166a.getSuffixText() == null) {
            return;
        }
        m4220b(z);
    }

    /* renamed from: b */
    public final void m4220b(boolean z) {
        boolean z2 = this.f6166a.m6205h() == z;
        if (z && !this.f6121h.isRunning()) {
            this.f6122i.cancel();
            this.f6121h.start();
            if (z2) {
                this.f6121h.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.f6121h.cancel();
        this.f6122i.start();
        if (z2) {
            this.f6122i.end();
        }
    }
}
