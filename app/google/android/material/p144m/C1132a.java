package custom.google.android.material.p144m;

import android.content.Context;
import com.google.android.material.R$attr;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: b.e.a.a.m.a */
/* loaded from: classes.dex */
public class C1132a {

    /* renamed from: a */
    public final boolean f5712a;

    /* renamed from: b */
    public final int f5713b;

    /* renamed from: c */
    public final int f5714c;

    /* renamed from: d */
    public final float f5715d;

    public C1132a(Context context) {
        this.f5712a = Util.m272a(context, R$attr.elevationOverlayEnabled, false);
        this.f5713b = Util.m171a(context, R$attr.elevationOverlayColor, 0);
        this.f5714c = Util.m171a(context, R$attr.colorSurface, 0);
        this.f5715d = context.getResources().getDisplayMetrics().density;
    }
}
