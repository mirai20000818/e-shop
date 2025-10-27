package custom.google.android.material.mng2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import androidx.constraintlayout.p027c.C0199d;
import androidx.core.view.ViewCompat;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1183i;

/* renamed from: b.e.a.a.a0.b */
/* loaded from: classes.dex */
public class C1066b extends ConstraintLayout {

    /* renamed from: u */
    public final Runnable f5400u;

    /* renamed from: v */
    public int f5401v;

    /* renamed from: w */
    public C1181g f5402w;

    /* renamed from: b.e.a.a.a0.b$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1066b.this.m3876c();
        }
    }

    public C1066b(Context context) {
        this(context, null);
    }

    public C1066b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1066b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        this.f5402w = new C1181g();
        C1181g c1181g = this.f5402w;
        c1181g.setShapeAppearanceModel(c1181g.f5989b.f6012a.m4179a(new C1183i(0.5f)));
        this.f5402w.m4156a(ColorStateList.valueOf(-1));
        ViewCompat.setBackground(this, this.f5402w);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i, 0);
        this.f5401v = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f5400u = new a();
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.m1288b());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f5400u);
            handler.post(this.f5400u);
        }
    }

    /* renamed from: b */
    public int m3875b() {
        return this.f5401v;
    }

    /* renamed from: c */
    public void m3876c() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        C0199d c0199d = new C0199d();
        c0199d.m1011a(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != R$id.circle_center && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int i4 = R$id.circle_center;
                int i5 = this.f5401v;
                if (!c0199d.f1386c.containsKey(Integer.valueOf(id))) {
                    c0199d.f1386c.put(Integer.valueOf(id), new C0199d.a());
                }
                C0199d.b bVar = c0199d.f1386c.get(Integer.valueOf(id)).f1390d;
                bVar.f1453x = i4;
                bVar.f1454y = i5;
                bVar.f1455z = f;
                f = (360.0f / (childCount - i)) + f;
            }
        }
        c0199d.m1012a((ConstraintLayout) this, true);
        setConstraintSet(null);
        requestLayout();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        m3876c();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f5400u);
            handler.post(this.f5400u);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f5402w.m4156a(ColorStateList.valueOf(i));
    }
}
