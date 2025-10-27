package custom.google.android.material.p142k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import com.google.android.material.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import custom.google.android.material.p153v.C1175a;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;

/* renamed from: b.e.a.a.k.b */
/* loaded from: classes.dex */
public final class C1105b {

    /* renamed from: a */
    public final Rect f5598a;

    /* renamed from: b */
    public final ColorStateList f5599b;

    /* renamed from: c */
    public final ColorStateList f5600c;

    /* renamed from: d */
    public final ColorStateList f5601d;

    /* renamed from: e */
    public final int f5602e;

    /* renamed from: f */
    public final C1185k f5603f;

    public C1105b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, C1185k c1185k, Rect rect) {
        Util.m164a(rect.left);
        Util.m164a(rect.top);
        Util.m164a(rect.right);
        Util.m164a(rect.bottom);
        this.f5598a = rect;
        this.f5599b = colorStateList2;
        this.f5600c = colorStateList;
        this.f5601d = colorStateList3;
        this.f5602e = i;
        this.f5603f = c1185k;
    }

    /* renamed from: a */
    public static C1105b m3985a(Context context, int i) {
        if (!(i != 0)) {
            throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList m197a = Util.m197a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList m197a2 = Util.m197a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList m197a3 = Util.m197a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        C1185k m4185a = C1185k.m4175a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new C1175a(0)).m4185a();
        obtainStyledAttributes.recycle();
        return new C1105b(m197a, m197a2, m197a3, dimensionPixelSize, m4185a, rect);
    }

    /* renamed from: a */
    public void m3986a(TextView textView) {
        C1181g c1181g = new C1181g();
        C1181g c1181g2 = new C1181g();
        c1181g.setShapeAppearanceModel(this.f5603f);
        c1181g2.setShapeAppearanceModel(this.f5603f);
        c1181g.m4156a(this.f5600c);
        c1181g.m4154a(this.f5602e, this.f5601d);
        textView.setTextColor(this.f5599b);
        int i = Build.VERSION.SDK_INT;
        RippleDrawable rippleDrawable = new RippleDrawable(this.f5599b.withAlpha(30), c1181g, c1181g2);
        Rect rect = this.f5598a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
