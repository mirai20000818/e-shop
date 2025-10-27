package custom.google.android.material.p150s;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextPaint;
import android.util.TypedValue;

import com.jeil.emarket.custom.CustomString;
import com.google.android.material.R$styleable;

import androidx.core.content.p033c.AbstractC0227g;

/* renamed from: b.e.a.a.s.b */
/* loaded from: classes.dex */
public class C1168b {

    /* renamed from: a */
    public final ColorStateList f5946a;

    /* renamed from: b */
    public final ColorStateList f5947b;

    /* renamed from: c */
    public final java.lang.String f5948c;

    /* renamed from: d */
    public final int f5949d;

    /* renamed from: e */
    public final int f5950e;

    /* renamed from: f */
    public final float f5951f;

    /* renamed from: g */
    public final float f5952g;

    /* renamed from: h */
    public final float f5953h;

    /* renamed from: i */
    public final boolean f5954i;

    /* renamed from: j */
    public final float f5955j;

    /* renamed from: k */
    public float f5956k;

    /* renamed from: l */
    public final int f5957l;

    /* renamed from: m */
    public boolean f5958m = false;

    /* renamed from: n */
    public Typeface f5959n;

    public C1168b(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        this.f5956k = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.f5946a = Util.m197a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        Util.m197a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        Util.m197a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f5949d = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f5950e = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i2 = R$styleable.TextAppearance_fontFamily;
        i2 = obtainStyledAttributes.hasValue(i2) ? i2 : R$styleable.TextAppearance_android_fontFamily;
        this.f5957l = obtainStyledAttributes.getResourceId(i2, 0);
        this.f5948c = obtainStyledAttributes.getString(i2);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f5947b = Util.m197a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f5951f = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f5952g = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f5953h = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        int i3 = Build.VERSION.SDK_INT;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, R$styleable.MaterialTextAppearance);
        this.f5954i = obtainStyledAttributes2.hasValue(R$styleable.MaterialTextAppearance_android_letterSpacing);
        this.f5955j = obtainStyledAttributes2.getFloat(R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    /* renamed from: a */
    public Typeface m4132a(Context context) {
        if (this.f5958m) {
            return this.f5959n;
        }
        if (!context.isRestricted()) {
            try {
                this.f5959n = context.isRestricted() ? null : Util.m203a(context, this.f5957l, new TypedValue(), 0, (AbstractC0227g) null, (Handler) null, false, false);
                if (this.f5959n != null) {
                    this.f5959n = Typeface.create(this.f5959n, this.f5949d);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder m3163a = CustomString.format("Error loading font ");
                m3163a.append(this.f5948c);
                m3163a.toString();
            }
        }
        m4133a();
        this.f5958m = true;
        return this.f5959n;
    }

    /* renamed from: a */
    public final void m4133a() {
        java.lang.String str;
        if (this.f5959n == null && (str = this.f5948c) != null) {
            this.f5959n = Typeface.create(str, this.f5949d);
        }
        if (this.f5959n == null) {
            int i = this.f5950e;
            this.f5959n = i != 1 ? i != 2 ? i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.f5959n = Typeface.create(this.f5959n, this.f5949d);
        }
    }

    /* renamed from: a */
    public void m4134a(Context context, TextPaint textPaint, AbstractC1170d abstractC1170d) {
        m4138b(context, textPaint, abstractC1170d);
        ColorStateList colorStateList = this.f5946a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.f5953h;
        float f2 = this.f5951f;
        float f3 = this.f5952g;
        ColorStateList colorStateList2 = this.f5947b;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    /* renamed from: a */
    public void m4135a(Context context, AbstractC1170d abstractC1170d) {
        if (m4139b(context)) {
            m4132a(context);
        } else {
            m4133a();
        }
        if (this.f5957l == 0) {
            this.f5958m = true;
        }
        if (this.f5958m) {
            abstractC1170d.mo4121a(this.f5959n, true);
            return;
        }
        try {
            Util.m231a(context, this.f5957l, new a(abstractC1170d), (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.f5958m = true;
            abstractC1170d.mo4120a(1);
        } catch (Exception unused2) {
            StringBuilder m3163a = CustomString.format("Error loading font ");
            m3163a.append(this.f5948c);
            m3163a.toString();
            this.f5958m = true;
            abstractC1170d.mo4120a(-3);
        }
    }

    /* renamed from: a */
    public void m4136a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f5949d;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f5956k);
        int i2 = Build.VERSION.SDK_INT;
        if (this.f5954i) {
            textPaint.setLetterSpacing(this.f5955j);
        }
    }

    /* renamed from: b */
    public Typeface m4137b() {
        m4133a();
        return this.f5959n;
    }

    /* renamed from: b */
    public final boolean m4139b(Context context) {
        int i = this.f5957l;
        Typeface typeface = null;
        if (i != 0 && !context.isRestricted()) {
            typeface = Util.m203a(context, i, new TypedValue(), 0, (AbstractC0227g) null, (Handler) null, false, true);
        }
        return typeface != null;
    }

    /* renamed from: b.e.a.a.s.b$a */
    public class a extends AbstractC0227g {

        /* renamed from: a */
        public final /* synthetic */ AbstractC1170d f5960a;

        public a(AbstractC1170d abstractC1170d) {
            this.f5960a = abstractC1170d;
        }

        @Override // p000a.p030h.p032b.p033c.AbstractC0227g
        /* renamed from: a */
        public void mo704a(int i) {
            C1168b.this.f5958m = true;
            this.f5960a.mo4120a(i);
        }

        @Override // p000a.p030h.p032b.p033c.AbstractC0227g
        /* renamed from: a */
        public void mo705a(Typeface typeface) {
            C1168b c1168b = C1168b.this;
            c1168b.f5959n = Typeface.create(typeface, c1168b.f5949d);
            C1168b c1168b2 = C1168b.this;
            c1168b2.f5958m = true;
            this.f5960a.mo4121a(c1168b2.f5959n, false);
        }
    }

    /* renamed from: b */
    public void m4138b(Context context, TextPaint textPaint, AbstractC1170d abstractC1170d) {
        if (m4139b(context)) {
            m4136a(textPaint, m4132a(context));
        } else {
            m4136a(textPaint, m4137b());
            m4135a(context, new C1169c(this, textPaint, abstractC1170d));
        }
    }
}
