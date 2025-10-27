package custom.google.android.material.p156y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$dimen;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import custom.google.android.material.mng1.AnimationUtils;

/* renamed from: b.e.a.a.y.j */
/* loaded from: classes.dex */
public final class C1205j {

    /* renamed from: a */
    public final Context f6169a;

    /* renamed from: b */
    public final TextInputLayout f6170b;

    /* renamed from: c */
    public LinearLayout f6171c;

    /* renamed from: d */
    public int f6172d;

    /* renamed from: e */
    public FrameLayout f6173e;

    /* renamed from: f */
    public Animator f6174f;

    /* renamed from: g */
    public final float f6175g;

    /* renamed from: h */
    public int f6176h;

    /* renamed from: i */
    public int f6177i;

    /* renamed from: j */
    public CharSequence f6178j;

    /* renamed from: k */
    public boolean f6179k;

    /* renamed from: l */
    public TextView f6180l;

    /* renamed from: m */
    public CharSequence f6181m;

    /* renamed from: n */
    public int f6182n;

    /* renamed from: o */
    public ColorStateList f6183o;

    /* renamed from: p */
    public CharSequence f6184p;

    /* renamed from: q */
    public boolean f6185q;

    /* renamed from: r */
    public TextView f6186r;

    /* renamed from: s */
    public int f6187s;

    /* renamed from: t */
    public ColorStateList f6188t;

    /* renamed from: u */
    public Typeface f6189u;

    /* renamed from: b.e.a.a.y.j$a */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ int f6190a;

        /* renamed from: b */
        public final /* synthetic */ TextView f6191b;

        /* renamed from: c */
        public final /* synthetic */ int f6192c;

        /* renamed from: d */
        public final /* synthetic */ TextView f6193d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.f6190a = i;
            this.f6191b = textView;
            this.f6192c = i2;
            this.f6193d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            C1205j c1205j = C1205j.this;
            c1205j.f6176h = this.f6190a;
            c1205j.f6174f = null;
            TextView textView2 = this.f6191b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.f6192c == 1 && (textView = C1205j.this.f6180l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f6193d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f6193d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f6193d;
            if (textView != null) {
                textView.setVisibility(View.VISIBLE);
            }
        }
    }

    public C1205j(TextInputLayout textInputLayout) {
        this.f6169a = textInputLayout.getContext();
        this.f6170b = textInputLayout;
        this.f6175g = this.f6169a.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    /* renamed from: a */
    public final int m4241a(boolean z, int i, int i2) {
        return z ? this.f6169a.getResources().getDimensionPixelSize(i) : i2;
    }

    /* renamed from: a */
    public final TextView m4242a(int i) {
        if (i == 1) {
            return this.f6180l;
        }
        if (i != 2) {
            return null;
        }
        return this.f6186r;
    }

    /* renamed from: a */
    public void m4243a() {
        if ((this.f6171c == null || this.f6170b.getEditText() == null) ? false : true) {
            EditText editText = this.f6170b.getEditText();
            boolean m351f = Util.m351f(this.f6169a);
            LinearLayout linearLayout = this.f6171c;
            int m4241a = m4241a(m351f, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.m1316s(editText));
            int m4241a2 = m4241a(m351f, R$dimen.material_helper_text_font_1_3_padding_top, this.f6169a.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top));
            int m4241a3 = m4241a(m351f, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.m1315r(editText));
            int i = Build.VERSION.SDK_INT;
            linearLayout.setPaddingRelative(m4241a, m4241a2, m4241a3, 0);
        }
    }

    /* renamed from: a */
    public void m4245a(ColorStateList colorStateList) {
        this.f6183o = colorStateList;
        TextView textView = this.f6180l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* renamed from: a */
    public void m4246a(TextView textView, int i) {
        if (this.f6171c == null && this.f6173e == null) {
            this.f6171c = new LinearLayout(this.f6169a);
            this.f6171c.setOrientation(LinearLayoutCompat.HORIZONTAL);
            this.f6170b.addView(this.f6171c, -1, -2);
            this.f6173e = new FrameLayout(this.f6169a);
            this.f6171c.addView(this.f6173e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f6170b.getEditText() != null) {
                m4243a();
            }
        }
        if (i == 0 || i == 1) {
            this.f6173e.setVisibility(View.VISIBLE);
            this.f6173e.addView(textView);
        } else {
            this.f6171c.addView(textView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        this.f6171c.setVisibility(View.VISIBLE);
        this.f6172d++;
    }

    /* renamed from: a */
    public final void m4247a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* renamed from: a */
    public void m4248a(CharSequence charSequence) {
        this.f6181m = charSequence;
        TextView textView = this.f6180l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* renamed from: a */
    public final boolean m4250a(TextView textView, CharSequence charSequence) {
        return ViewCompat.m1256C(this.f6170b) && this.f6170b.isEnabled() && !(this.f6177i == this.f6176h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    /* renamed from: b */
    public void m4251b() {
        Animator animator = this.f6174f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: b */
    public void m4252b(int i) {
        this.f6182n = i;
        TextView textView = this.f6180l;
        if (textView != null) {
            this.f6170b.m6189a(textView, i);
        }
    }

    /* renamed from: b */
    public void m4253b(ColorStateList colorStateList) {
        this.f6188t = colorStateList;
        TextView textView = this.f6186r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* renamed from: b */
    public void m4254b(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f6171c == null) {
            return;
        }
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        if (!z || (frameLayout = this.f6173e) == null) {
            this.f6171c.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        this.f6172d--;
        LinearLayout linearLayout = this.f6171c;
        if (this.f6172d == 0) {
            linearLayout.setVisibility(View.GONE);
        }
    }

    /* renamed from: c */
    public void m4255c(int i) {
        this.f6187s = i;
        TextView textView = this.f6186r;
        if (textView != null) {
            Util.m337d(textView, i);
        }
    }

    /* renamed from: c */
    public boolean m4256c() {
        return (this.f6177i != 1 || this.f6180l == null || TextUtils.isEmpty(this.f6178j)) ? false : true;
    }

    /* renamed from: d */
    public int m4257d() {
        TextView textView = this.f6180l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* renamed from: e */
    public void m4258e() {
        this.f6178j = null;
        m4251b();
        if (this.f6176h == 1) {
            this.f6177i = (!this.f6185q || TextUtils.isEmpty(this.f6184p)) ? 0 : 2;
        }
        m4244a(this.f6176h, this.f6177i, m4250a(this.f6180l, (CharSequence) null));
    }

    /* renamed from: a */
    public final void m4249a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, i3 == i ? 1.0f : 0.0f);
            ofFloat.setDuration(167L);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            list.add(ofFloat);
            if (i3 == i) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f6175g, 0.0f);
                ofFloat2.setDuration(217L);
                ofFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                list.add(ofFloat2);
            }
        }
    }

    /* renamed from: a */
    public final void m4244a(int i, int i2, boolean z) {
        TextView m4242a;
        TextView m4242a2;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f6174f = animatorSet;
            ArrayList arrayList = new ArrayList();
            m4249a(arrayList, this.f6185q, this.f6186r, 2, i, i2);
            m4249a(arrayList, this.f6179k, this.f6180l, 1, i, i2);
            Util.m230a(animatorSet, (List<Animator>) arrayList);
            animatorSet.addListener(new a(i2, m4242a(i), i, m4242a(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (m4242a2 = m4242a(i2)) != null) {
                m4242a2.setVisibility(View.VISIBLE);
                m4242a2.setAlpha(1.0f);
            }
            if (i != 0 && (m4242a = m4242a(i)) != null) {
                m4242a.setVisibility(4);
                if (i == 1) {
                    m4242a.setText((CharSequence) null);
                }
            }
            this.f6176h = i2;
        }
        this.f6170b.m6219v();
        this.f6170b.m6194a(z);
        this.f6170b.m6184B();
    }
}
