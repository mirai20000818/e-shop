package custom.google.android.material.p138h;

import android.R;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.C0103g;

/* renamed from: b.e.a.a.h.a */
/* loaded from: classes.dex */
public class C1095a extends C0103g {

    /* renamed from: g */
    public static final int f5495g = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: h */
    public static final int[][] f5496h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e */
    public ColorStateList f5497e;

    /* renamed from: f */
    public boolean f5498f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1095a(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            int r3 = com.google.android.material.R$attr.checkboxStyle
            int r0 = p078b.p126e.p127a.p128a.p138h.C1095a.f5495g
            android.content.Context r8 = p078b.p126e.p127a.p128a.p157z.p158a.C1210a.m4263a(r8, r9, r3, r0)
            r7.<init>(r8, r9, r3)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialCheckBox
            int r4 = p078b.p126e.p127a.p128a.p138h.C1095a.f5495g
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            android.content.res.TypedArray r9 = p078b.p126e.p127a.p128a.p147p.C1157o.m4125b(r0, r1, r2, r3, r4, r5)
            int r0 = com.google.android.material.R$styleable.MaterialCheckBox_buttonTint
            boolean r0 = r9.hasValue(r0)
            if (r0 == 0) goto L2f
            int r0 = com.google.android.material.R$styleable.MaterialCheckBox_buttonTint
            android.content.res.ColorStateList r8 = p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.m197a(r8, r9, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r7.setButtonTintList(r8)
        L2f:
            int r8 = com.google.android.material.R$styleable.MaterialCheckBox_useMaterialThemeColors
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f5498f = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p138h.C1095a.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f5497e == null) {
            int[] iArr = new int[f5496h.length];
            int m174a = Util.m174a((View) this, R$attr.colorControlActivated);
            int m174a2 = Util.m174a((View) this, R$attr.colorSurface);
            int m174a3 = Util.m174a((View) this, R$attr.colorOnSurface);
            iArr[0] = Util.m166a(m174a2, m174a, 1.0f);
            iArr[1] = Util.m166a(m174a2, m174a3, 0.54f);
            iArr[2] = Util.m166a(m174a2, m174a3, 0.38f);
            iArr[3] = Util.m166a(m174a2, m174a3, 0.38f);
            this.f5497e = new ColorStateList(f5496h, iArr);
        }
        return this.f5497e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5498f) {
            int i = Build.VERSION.SDK_INT;
            if (getButtonTintList() == null) {
                setUseMaterialThemeColors(true);
            }
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f5498f = z;
        ColorStateList materialThemeColorsTintList = z ? getMaterialThemeColorsTintList() : null;
        int i = Build.VERSION.SDK_INT;
        setButtonTintList(materialThemeColorsTintList);
    }
}
