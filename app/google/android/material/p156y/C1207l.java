package custom.google.android.material.p156y;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;
import androidx.appcompat.widget.C0094d;
import androidx.appcompat.widget.C0114l0;

/* renamed from: b.e.a.a.y.l */
/* loaded from: classes.dex */
public class C1207l extends C0094d {

    /* renamed from: e */
    public final C0114l0 f6196e;

    /* renamed from: f */
    public final AccessibilityManager f6197f;

    /* renamed from: g */
    public final Rect f6198g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1207l(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            int r3 = com.google.android.material.R$attr.autoCompleteTextViewStyle
            r6 = 0
            android.content.Context r8 = p078b.p126e.p127a.p128a.p157z.p158a.C1210a.m4263a(r8, r9, r3, r6)
            r7.<init>(r8, r9, r3)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.f6198g = r8
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialAutoCompleteTextView
            int r4 = com.google.android.material.R$style.Widget_AppCompat_AutoCompleteTextView
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            android.content.res.TypedArray r9 = p078b.p126e.p127a.p128a.p147p.C1157o.m4125b(r0, r1, r2, r3, r4, r5)
            int r0 = com.google.android.material.R$styleable.MaterialAutoCompleteTextView_android_inputType
            boolean r0 = r9.hasValue(r0)
            r1 = 0
            if (r0 == 0) goto L35
            int r0 = com.google.android.material.R$styleable.MaterialAutoCompleteTextView_android_inputType
            int r0 = r9.getInt(r0, r6)
            if (r0 != 0) goto L35
            r7.setKeyListener(r1)
        L35:
            java.lang.String r0 = "accessibility"
            java.lang.Object r0 = r8.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r0 = (android.view.accessibility.AccessibilityManager) r0
            r7.f6197f = r0
            a.b.e.l0 r0 = new a.b.e.l0
            int r2 = androidx.appcompat.R$attr.listPopupWindowStyle
            r0.<init>(r8, r1, r2)
            r7.f6196e = r0
            a.b.e.l0 r8 = r7.f6196e
            r0 = 1
            r8.m608a(r0)
            a.b.e.l0 r8 = r7.f6196e
            r8.f798t = r7
            r0 = 2
            android.widget.PopupWindow r8 = r8.f779F
            r8.setInputMethodMode(r0)
            a.b.e.l0 r8 = r7.f6196e
            android.widget.ListAdapter r0 = r7.getAdapter()
            r8.mo607a(r0)
            a.b.e.l0 r8 = r7.f6196e
            b.e.a.a.y.k r0 = new b.e.a.a.y.k
            r0.<init>(r7)
            r8.f800v = r0
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p156y.C1207l.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* renamed from: a */
    public final TextInputLayout m4260a() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final <T extends ListAdapter & Filterable> void m4261a(Object obj) {
        int i = Build.VERSION.SDK_INT;
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout m4260a = m4260a();
        return (m4260a == null || !m4260a.m6208k()) ? super.getHint() : m4260a.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout m4260a = m4260a();
        if (m4260a != null && m4260a.m6208k() && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout m4260a = m4260a();
            int i3 = 0;
            if (adapter != null && m4260a != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                int min = Math.min(adapter.getCount(), Math.max(0, this.f6196e.m614h()) + 15);
                View view = null;
                int i4 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i3) {
                        view = null;
                        i3 = itemViewType;
                    }
                    view = adapter.getView(max, view, m4260a);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i4 = Math.max(i4, view.getMeasuredWidth());
                }
                Drawable m612c = this.f6196e.m612c();
                if (m612c != null) {
                    m612c.getPadding(this.f6198g);
                    Rect rect = this.f6198g;
                    i4 += rect.left + rect.right;
                }
                i3 = m4260a.getEndIconView().getMeasuredWidth() + i4;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i3), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f6196e.mo607a(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f6197f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f6196e.mo440e();
        }
    }
}
