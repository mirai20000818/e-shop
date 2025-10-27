package custom.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: b.e.a.a.p.l */
/* loaded from: classes.dex */
public final class C1154l {

    /* renamed from: n */
    public static final int f5893n;

    /* renamed from: o */
    public static boolean f5894o;

    /* renamed from: p */
    public static Constructor<StaticLayout> f5895p;

    /* renamed from: q */
    public static Object f5896q;

    /* renamed from: a */
    public CharSequence f5897a;

    /* renamed from: b */
    public final TextPaint f5898b;

    /* renamed from: c */
    public final int f5899c;

    /* renamed from: e */
    public int f5901e;

    /* renamed from: l */
    public boolean f5908l;

    /* renamed from: d */
    public int f5900d = 0;

    /* renamed from: f */
    public Layout.Alignment f5902f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g */
    public int f5903g = Integer.MAX_VALUE;

    /* renamed from: h */
    public float f5904h = 0.0f;

    /* renamed from: i */
    public float f5905i = 1.0f;

    /* renamed from: j */
    public int f5906j = f5893n;

    /* renamed from: k */
    public boolean f5907k = true;

    /* renamed from: m */
    public TextUtils.TruncateAt f5909m = null;

    /* renamed from: b.e.a.a.p.l$a */
    public static class a extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.Throwable r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Error thrown initializing StaticLayout "
                java.lang.StringBuilder r0 = p078b.p079a.p080a.p081a.C0660a.m3163a(r0)
                java.lang.String r1 = r3.getMessage()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p147p.C1154l.a.<init>(java.lang.Throwable):void");
        }
    }

    static {
        f5893n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public C1154l(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f5897a = charSequence;
        this.f5898b = textPaint;
        this.f5899c = i;
        this.f5901e = charSequence.length();
    }

    /* renamed from: a */
    public StaticLayout m4118a() {
        if (this.f5897a == null) {
            this.f5897a = "";
        }
        int max = Math.max(0, this.f5899c);
        CharSequence charSequence = this.f5897a;
        if (this.f5903g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f5898b, max, this.f5909m);
        }
        this.f5901e = Math.min(charSequence.length(), this.f5901e);
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            if (!f5894o) {
                try {
                    boolean z = this.f5908l && i >= 23;
                    int i2 = Build.VERSION.SDK_INT;
                    f5896q = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                    f5895p = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, TextDirectionHeuristic.class, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
                    f5895p.setAccessible(true);
                    f5894o = true;
                } catch (Exception e2) {
                    throw new a(e2);
                }
            }
            try {
                Constructor<StaticLayout> constructor = f5895p;
                Util.m214a(constructor);
                Object obj = f5896q;
                Util.m214a(obj);
                return constructor.newInstance(charSequence, Integer.valueOf(this.f5900d), Integer.valueOf(this.f5901e), this.f5898b, Integer.valueOf(max), this.f5902f, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f5907k), null, Integer.valueOf(max), Integer.valueOf(this.f5903g));
            } catch (Exception e3) {
                throw new a(e3);
            }
        }
        if (this.f5908l && this.f5903g == 1) {
            this.f5902f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f5900d, this.f5901e, this.f5898b, max);
        obtain.setAlignment(this.f5902f);
        obtain.setIncludePad(this.f5907k);
        obtain.setTextDirection(this.f5908l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f5909m;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f5903g);
        if (this.f5904h != 0.0f || this.f5905i != 1.0f) {
            obtain.setLineSpacing(this.f5904h, this.f5905i);
        }
        if (this.f5903g > 1) {
            obtain.setHyphenationFrequency(this.f5906j);
        }
        return obtain.build();
    }
}
