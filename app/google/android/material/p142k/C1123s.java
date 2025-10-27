package custom.google.android.material.p142k;

import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: b.e.a.a.k.s */
/* loaded from: classes.dex */
public class C1123s extends BaseAdapter {

    /* renamed from: g */
    public static final int f5688g = C1130z.m4045c().getMaximum(4);

    /* renamed from: b */
    public final C1122r f5689b;

    /* renamed from: c */
    public final InterfaceC1108d<?> f5690c;

    /* renamed from: d */
    public Collection<Long> f5691d;

    /* renamed from: e */
    public C1107c f5692e;

    /* renamed from: f */
    public final C1103a f5693f;

    public C1123s(C1122r c1122r, InterfaceC1108d<?> interfaceC1108d, C1103a c1103a) {
        this.f5689b = c1122r;
        this.f5690c = interfaceC1108d;
        this.f5693f = c1103a;
        this.f5691d = interfaceC1108d.m3995d();
    }

    /* renamed from: a */
    public int m4030a() {
        return this.f5689b.m4029e();
    }

    /* renamed from: a */
    public int m4031a(int i) {
        return m4030a() + (i - 1);
    }

    /* renamed from: a */
    public final void m4032a(TextView textView, long j) {
        C1105b c1105b;
        if (textView == null) {
            return;
        }
        boolean z = true;
        if (j >= ((C1109e) this.f5693f.f5586d).f5614b) {
            textView.setEnabled(true);
            Iterator<Long> it = this.f5690c.m3995d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else {
                    if (C1130z.m4038a(j) == C1130z.m4038a(it.next().longValue())) {
                        break;
                    }
                }
            }
            if (z) {
                c1105b = this.f5692e.f5607b;
            } else {
                long timeInMillis = C1130z.m4043b().getTimeInMillis();
                C1107c c1107c = this.f5692e;
                c1105b = timeInMillis == j ? c1107c.f5608c : c1107c.f5606a;
            }
        } else {
            textView.setEnabled(false);
            c1105b = this.f5692e.f5612g;
        }
        c1105b.m3986a(textView);
    }

    /* renamed from: b */
    public int m4034b() {
        return (this.f5689b.m4029e() + this.f5689b.f5685f) - 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return m4030a() + this.f5689b.f5685f;
    }

    @Override // android.widget.Adapter
    public Long getItem(int i) {
        if (i < this.f5689b.m4029e() || i > m4034b()) {
            return null;
        }
        C1122r c1122r = this.f5689b;
        int m4029e = (i - c1122r.m4029e()) + 1;
        Calendar m4041a = C1130z.m4041a(c1122r.f5681b);
        m4041a.set(5, m4029e);
        return Long.valueOf(m4041a.getTimeInMillis());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f5689b.f5684e;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            r6 = this;
            android.content.Context r0 = r9.getContext()
            b.e.a.a.k.c r1 = r6.f5692e
            if (r1 != 0) goto Lf
            b.e.a.a.k.c r1 = new b.e.a.a.k.c
            r1.<init>(r0)
            r6.f5692e = r1
        Lf:
            r0 = r8
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r8 != 0) goto L26
            android.content.Context r8 = r9.getContext()
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r8)
            int r0 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r8 = r8.inflate(r0, r9, r1)
            r0 = r8
            android.widget.TextView r0 = (android.widget.TextView) r0
        L26:
            int r8 = r6.m4030a()
            int r8 = r7 - r8
            if (r8 < 0) goto Lbf
            b.e.a.a.k.r r9 = r6.f5689b
            int r2 = r9.f5685f
            if (r8 < r2) goto L36
            goto Lbf
        L36:
            r2 = 1
            int r8 = r8 + r2
            r0.setTag(r9)
            android.content.res.Resources r9 = r0.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            java.util.Locale r9 = r9.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r9 = java.lang.String.format(r9, r4, r3)
            r0.setText(r9)
            b.e.a.a.k.r r9 = r6.f5689b
            long r8 = r9.m4025a(r8)
            b.e.a.a.k.r r3 = r6.f5689b
            int r3 = r3.f5683d
            b.e.a.a.k.r r4 = p078b.p126e.p127a.p128a.p142k.C1122r.m4023f()
            int r4 = r4.f5683d
            r5 = 24
            if (r3 != r4) goto L90
            java.util.Locale r3 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L82
            java.lang.String r4 = "MMMEd"
            android.icu.text.DateFormat r3 = p078b.p126e.p127a.p128a.p142k.C1130z.m4039a(r4, r3)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
            goto Lb5
        L82:
            java.text.DateFormat r3 = p078b.p126e.p127a.p128a.p142k.C1130z.m4040a(r3)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
            goto Lb5
        L90:
            java.util.Locale r3 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto La8
            java.lang.String r4 = "yMMMEd"
            android.icu.text.DateFormat r3 = p078b.p126e.p127a.p128a.p142k.C1130z.m4039a(r4, r3)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
            goto Lb5
        La8:
            java.text.DateFormat r3 = p078b.p126e.p127a.p128a.p142k.C1130z.m4040a(r3)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
        Lb5:
            r0.setContentDescription(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto Lc7
        Lbf:
            r8 = 8
            r0.setVisibility(r8)
            r0.setEnabled(r1)
        Lc7:
            java.lang.Long r7 = r6.getItem(r7)
            if (r7 != 0) goto Lce
            goto Ld5
        Lce:
            long r7 = r7.longValue()
            r6.m4032a(r0, r7)
        Ld5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p142k.C1123s.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* renamed from: a */
    public final void m4033a(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (C1122r.m4022b(j).equals(this.f5689b)) {
            Calendar m4041a = C1130z.m4041a(this.f5689b.f5681b);
            m4041a.setTimeInMillis(j);
            m4032a((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().m4031a(m4041a.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }
}
