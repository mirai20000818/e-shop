package custom.google.android.material.p154w;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import custom.google.android.material.p157z.p158a.C1210a;

/* renamed from: b.e.a.a.w.d */
/* loaded from: classes.dex */
public class C1192d extends FrameLayout {

    /* renamed from: g */
    public static final View.OnTouchListener f6101g = new a();

    /* renamed from: b */
    public int f6102b;

    /* renamed from: c */
    public final float f6103c;

    /* renamed from: d */
    public final float f6104d;

    /* renamed from: e */
    public ColorStateList f6105e;

    /* renamed from: f */
    public PorterDuff.Mode f6106f;

    /* renamed from: b.e.a.a.w.d$a */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public C1192d(Context context) {
        this(context, null);
    }

    public C1192d(Context context, AttributeSet attributeSet) {
        super(C1210a.m4263a(context, attributeSet, 0, 0), attributeSet);
        Drawable m342e;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
            ViewCompat.m1270a(this, obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
        }
        this.f6102b = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
        this.f6103c = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        setBackgroundTintList(Util.m197a(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
        setBackgroundTintMode(Util.m201a(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.f6104d = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f6101g);
        setFocusable(true);
        if (getBackground() == null) {
            float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(Util.m166a(Util.m174a((View) this, R$attr.colorSurface), Util.m174a((View) this, R$attr.colorOnSurface), getBackgroundOverlayColorAlpha()));
            if (this.f6105e != null) {
                m342e = Util.m342e(gradientDrawable);
                ColorStateList colorStateList = this.f6105e;
                int i = Build.VERSION.SDK_INT;
                m342e.setTintList(colorStateList);
            } else {
                m342e = Util.m342e(gradientDrawable);
            }
            ViewCompat.setBackground(this, m342e);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f6104d;
    }

    public int getAnimationMode() {
        return this.f6102b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f6103c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.m1261H(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setAnimationMode(int i) {
        this.f6102b = i;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f6105e != null) {
            drawable = Util.m342e(drawable.mutate());
            ColorStateList colorStateList = this.f6105e;
            int i = Build.VERSION.SDK_INT;
            drawable.setTintList(colorStateList);
            PorterDuff.Mode mode = this.f6106f;
            int i2 = Build.VERSION.SDK_INT;
            drawable.setTintMode(mode);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f6105e = colorStateList;
        if (getBackground() != null) {
            Drawable m342e = Util.m342e(getBackground().mutate());
            int i = Build.VERSION.SDK_INT;
            m342e.setTintList(colorStateList);
            PorterDuff.Mode mode = this.f6106f;
            int i2 = Build.VERSION.SDK_INT;
            m342e.setTintMode(mode);
            if (m342e != getBackground()) {
                super.setBackgroundDrawable(m342e);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f6106f = mode;
        if (getBackground() != null) {
            Drawable m342e = Util.m342e(getBackground().mutate());
            int i = Build.VERSION.SDK_INT;
            m342e.setTintMode(mode);
            if (m342e != getBackground()) {
                super.setBackgroundDrawable(m342e);
            }
        }
    }

    public void setOnAttachStateChangeListener(InterfaceC1190b interfaceC1190b) {
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f6101g);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(InterfaceC1191c interfaceC1191c) {
    }
}
