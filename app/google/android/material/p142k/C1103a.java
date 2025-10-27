package custom.google.android.material.p142k;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: b.e.a.a.k.a */
/* loaded from: classes.dex */
public final class C1103a implements Parcelable {
    public static final Parcelable.Creator<C1103a> CREATOR = new a();

    /* renamed from: b */
    public final C1122r f5584b;

    /* renamed from: c */
    public final C1122r f5585c;

    /* renamed from: d */
    public final c f5586d;

    /* renamed from: e */
    public C1122r f5587e;

    /* renamed from: f */
    public final int f5588f;

    /* renamed from: g */
    public final int f5589g;

    /* renamed from: b.e.a.a.k.a$a */
    public static class a implements Parcelable.Creator<C1103a> {
        @Override // android.os.Parcelable.Creator
        public C1103a createFromParcel(Parcel parcel) {
            return new C1103a((C1122r) parcel.readParcelable(C1122r.class.getClassLoader()), (C1122r) parcel.readParcelable(C1122r.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (C1122r) parcel.readParcelable(C1122r.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        public C1103a[] newArray(int i) {
            return new C1103a[i];
        }
    }

    /* renamed from: b.e.a.a.k.a$b */
    public static final class b {

        /* renamed from: e */
        public static final long f5590e = C1130z.m4038a(C1122r.m4021a(1900, 0).f5686g);

        /* renamed from: f */
        public static final long f5591f = C1130z.m4038a(C1122r.m4021a(2100, 11).f5686g);

        /* renamed from: a */
        public long f5592a;

        /* renamed from: b */
        public long f5593b;

        /* renamed from: c */
        public Long f5594c;

        /* renamed from: d */
        public c f5595d;

        public b(C1103a c1103a) {
            this.f5592a = f5590e;
            this.f5593b = f5591f;
            this.f5595d = new C1109e(Long.MIN_VALUE);
            this.f5592a = c1103a.f5584b.f5686g;
            this.f5593b = c1103a.f5585c.f5686g;
            this.f5594c = Long.valueOf(c1103a.f5587e.f5686g);
            this.f5595d = c1103a.f5586d;
        }
    }

    /* renamed from: b.e.a.a.k.a$c */
    public interface c extends Parcelable {
    }

    public /* synthetic */ C1103a(C1122r c1122r, C1122r c1122r2, c cVar, C1122r c1122r3, a aVar) {
        this.f5584b = c1122r;
        this.f5585c = c1122r2;
        this.f5587e = c1122r3;
        this.f5586d = cVar;
        if (c1122r3 != null && c1122r.f5681b.compareTo(c1122r3.f5681b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (c1122r3 != null && c1122r3.f5681b.compareTo(c1122r2.f5681b) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f5589g = c1122r.m4026b(c1122r2) + 1;
        this.f5588f = (c1122r2.f5683d - c1122r.f5683d) + 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public c m3984e() {
        return this.f5586d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1103a)) {
            return false;
        }
        C1103a c1103a = (C1103a) obj;
        return this.f5584b.equals(c1103a.f5584b) && this.f5585c.equals(c1103a.f5585c) && Util.m317b(this.f5587e, c1103a.f5587e) && this.f5586d.equals(c1103a.f5586d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5584b, this.f5585c, this.f5587e, this.f5586d});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5584b, 0);
        parcel.writeParcelable(this.f5585c, 0);
        parcel.writeParcelable(this.f5587e, 0);
        parcel.writeParcelable(this.f5586d, 0);
    }
}
