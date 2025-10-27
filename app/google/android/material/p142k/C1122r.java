package custom.google.android.material.p142k;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* renamed from: b.e.a.a.k.r */
/* loaded from: classes.dex */
public final class C1122r implements Comparable<C1122r>, Parcelable {
    public static final Parcelable.Creator<C1122r> CREATOR = new a();

    /* renamed from: b */
    public final Calendar f5681b;

    /* renamed from: c */
    public final int f5682c;

    /* renamed from: d */
    public final int f5683d;

    /* renamed from: e */
    public final int f5684e;

    /* renamed from: f */
    public final int f5685f;

    /* renamed from: g */
    public final long f5686g;

    /* renamed from: h */
    public String f5687h;

    /* renamed from: b.e.a.a.k.r$a */
    public static class a implements Parcelable.Creator<C1122r> {
        @Override // android.os.Parcelable.Creator
        public C1122r createFromParcel(Parcel parcel) {
            return C1122r.m4021a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public C1122r[] newArray(int i) {
            return new C1122r[i];
        }
    }

    public C1122r(Calendar calendar) {
        calendar.set(5, 1);
        this.f5681b = C1130z.m4041a(calendar);
        this.f5682c = this.f5681b.get(2);
        this.f5683d = this.f5681b.get(1);
        this.f5684e = this.f5681b.getMaximum(7);
        this.f5685f = this.f5681b.getActualMaximum(5);
        this.f5686g = this.f5681b.getTimeInMillis();
    }

    /* renamed from: a */
    public static C1122r m4021a(int i, int i2) {
        Calendar m4045c = C1130z.m4045c();
        m4045c.set(1, i);
        m4045c.set(2, i2);
        return new C1122r(m4045c);
    }

    /* renamed from: b */
    public static C1122r m4022b(long j) {
        Calendar m4045c = C1130z.m4045c();
        m4045c.setTimeInMillis(j);
        return new C1122r(m4045c);
    }

    /* renamed from: f */
    public static C1122r m4023f() {
        return new C1122r(C1130z.m4043b());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1122r c1122r) {
        return this.f5681b.compareTo(c1122r.f5681b);
    }

    /* renamed from: a */
    public long m4025a(int i) {
        Calendar m4041a = C1130z.m4041a(this.f5681b);
        m4041a.set(5, i);
        return m4041a.getTimeInMillis();
    }

    /* renamed from: b */
    public int m4026b(C1122r c1122r) {
        if (!(this.f5681b instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (c1122r.f5682c - this.f5682c) + ((c1122r.f5683d - this.f5683d) * 12);
    }

    /* renamed from: b */
    public C1122r m4027b(int i) {
        Calendar m4041a = C1130z.m4041a(this.f5681b);
        m4041a.add(2, i);
        return new C1122r(m4041a);
    }

    /* renamed from: c */
    public String m4028c(Context context) {
        if (this.f5687h == null) {
            this.f5687h = DateUtils.formatDateTime(context, this.f5681b.getTimeInMillis() - TimeZone.getDefault().getOffset(r0), 36);
        }
        return this.f5687h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public int m4029e() {
        int firstDayOfWeek = this.f5681b.get(7) - this.f5681b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f5684e : firstDayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1122r)) {
            return false;
        }
        C1122r c1122r = (C1122r) obj;
        return this.f5682c == c1122r.f5682c && this.f5683d == c1122r.f5683d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5682c), Integer.valueOf(this.f5683d)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5683d);
        parcel.writeInt(this.f5682c);
    }
}
