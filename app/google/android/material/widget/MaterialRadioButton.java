package custom.google.android.material.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.jeil.emarket.R$styleable;

import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.AppCompatRadioButton;

import custom.google.android.material.internal.C1157o;
import custom.google.android.material.p157z.p158a.C1210a;

/* renamed from: b.e.a.a.r.a */
/* loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: g */
    public static final int f5939g = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h */
    public static final int[][] f5940h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e */
    public ColorStateList f5941e;

    /* renamed from: f */
    public boolean f5942f;

    public MaterialRadioButton(Context context) {
        this(context, null);
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(C1210a.m4263a(context, attributeSet, i, f5939g), attributeSet, i);
        Context context2 = getContext();
        TypedArray m4125b = C1157o.m4125b(context2, attributeSet, R$styleable.MaterialRadioButton, i, f5939g, new int[0]);
        if (m4125b.hasValue(R$styleable.MaterialRadioButton_buttonTint)) {
            ColorStateList m197a = Util.m197a(context2, m4125b, R$styleable.MaterialRadioButton_buttonTint);
            int i2 = Build.VERSION.SDK_INT;
            setButtonTintList(m197a);
        }
        this.f5942f = m4125b.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        m4125b.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f5941e == null) {
            int m174a = Util.m174a((View) this, R.attr.colorControlActivated);
            int m174a2 = Util.m174a((View) this, R.attr.colorOnSurface);
            int m174a3 = Util.m174a((View) this, R.attr.colorSurface);
            int[] iArr = new int[f5940h.length];
            iArr[0] = Util.m166a(m174a3, m174a, 1.0f);
            iArr[1] = Util.m166a(m174a3, m174a2, 0.54f);
            iArr[2] = Util.m166a(m174a3, m174a2, 0.38f);
            iArr[3] = Util.m166a(m174a3, m174a2, 0.38f);
            this.f5941e = new ColorStateList(f5940h, iArr);
        }
        return this.f5941e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5942f) {
            int i = Build.VERSION.SDK_INT;
            if (getButtonTintList() == null) {
                setUseMaterialThemeColors(true);
            }
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f5942f = z;
        ColorStateList materialThemeColorsTintList = z ? getMaterialThemeColorsTintList() : null;
        int i = Build.VERSION.SDK_INT;
        setButtonTintList(materialThemeColorsTintList);
    }
}
