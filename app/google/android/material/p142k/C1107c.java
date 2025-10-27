package custom.google.android.material.p142k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: b.e.a.a.k.c */
/* loaded from: classes.dex */
public final class C1107c {

    /* renamed from: a */
    public final C1105b f5606a;

    /* renamed from: b */
    public final C1105b f5607b;

    /* renamed from: c */
    public final C1105b f5608c;

    /* renamed from: d */
    public final C1105b f5609d;

    /* renamed from: e */
    public final C1105b f5610e;

    /* renamed from: f */
    public final C1105b f5611f;

    /* renamed from: g */
    public final C1105b f5612g;

    /* renamed from: h */
    public final Paint f5613h;

    public C1107c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Util.m291b(context, R$attr.materialCalendarStyle, C1111g.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.f5606a = C1105b.m3985a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f5612g = C1105b.m3985a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f5607b = C1105b.m3985a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f5608c = C1105b.m3985a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList m197a = Util.m197a(context, obtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f5609d = C1105b.m3985a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f5610e = C1105b.m3985a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f5611f = C1105b.m3985a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        this.f5613h = new Paint();
        this.f5613h.setColor(m197a.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
