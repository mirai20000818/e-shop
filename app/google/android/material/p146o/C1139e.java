package custom.google.android.material.p146o;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* renamed from: b.e.a.a.o.e */
/* loaded from: classes.dex */
public class C1139e implements TypeEvaluator<Float> {

    /* renamed from: a */
    public FloatEvaluator f5770a = new FloatEvaluator();

    public C1139e(C1138d c1138d) {
    }

    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Float f2, Float f3) {
        float floatValue = this.f5770a.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
