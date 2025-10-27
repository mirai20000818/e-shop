package custom.google.android.material.mng2;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: b.e.a.a.a0.a */
/* loaded from: classes.dex */
public class C1065a implements InputFilter {

    /* renamed from: b */
    public int f5399b;

    public C1065a(int i) {
        this.f5399b = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.f5399b) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
