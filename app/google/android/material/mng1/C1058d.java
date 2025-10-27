package custom.google.android.material.mng1;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* renamed from: b.e.a.a.a.d */
/* loaded from: classes.dex */
public class C1058d extends Property<Drawable, Integer> {

    /* renamed from: b */
    public static final Property<Drawable, Integer> f5383b = new C1058d();

    /* renamed from: a */
    public final WeakHashMap<Drawable, Integer> f5384a;

    public C1058d() {
        super(Integer.class, "drawableAlphaCompat");
        this.f5384a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    public Integer get(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public void set(Drawable drawable, Integer num) {
        int i = Build.VERSION.SDK_INT;
        drawable.setAlpha(num.intValue());
    }
}
