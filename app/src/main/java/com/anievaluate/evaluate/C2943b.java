package com.anievaluate.evaluate;

/* renamed from: b.g.a.b */
/* loaded from: classes.dex */
public class C2943b implements InterfaceC2951j<Number> {
    @Override // p078b.p268g.p269a.InterfaceC2951j
    public Number evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(((number2.floatValue() - floatValue) * f) + floatValue);
    }
}
