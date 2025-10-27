package custom.google.android.material.mng1;

import android.animation.TypeEvaluator;

import com.jeil.emarket.custom.CustomString;

/* renamed from: b.e.a.a.a.b */
/* loaded from: classes.dex */
public class TypeEvaluatorManager implements TypeEvaluator<Integer> {

    /* renamed from: a */
    public static final TypeEvaluatorManager f5381a = new TypeEvaluatorManager();

    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f2 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float f3 = ((intValue2 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = (float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d);
        float pow6 = (float) Math.pow((intValue2 & 255) / 255.0f, 2.2d);
        float m3148a = CustomString.m3148a(f3, f2, f, f2);
        float m3148a2 = CustomString.m3148a(pow4, pow, f, pow);
        float m3148a3 = CustomString.m3148a(pow5, pow2, f, pow2);
        float m3148a4 = CustomString.m3148a(pow6, pow3, f, pow3);
        float pow7 = ((float) Math.pow(m3148a2, 0.45454545454545453d)) * 255.0f;
        float pow8 = ((float) Math.pow(m3148a3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(m3148a4, 0.45454545454545453d)) * 255.0f) | (Math.round(pow7) << 16) | (Math.round(m3148a * 255.0f) << 24) | (Math.round(pow8) << 8));
    }
}
