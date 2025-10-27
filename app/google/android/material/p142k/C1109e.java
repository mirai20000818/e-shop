package custom.google.android.material.p142k;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* renamed from: b.e.a.a.k.e */
/* loaded from: classes.dex */
public class C1109e implements C1103a.c {
    public static final Parcelable.Creator<C1109e> CREATOR = new a();

    /* renamed from: b */
    public final long f5614b;

    /* renamed from: b.e.a.a.k.e$a */
    public static class a implements Parcelable.Creator<C1109e> {
        @Override // android.os.Parcelable.Creator
        public C1109e createFromParcel(Parcel parcel) {
            return new C1109e(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public C1109e[] newArray(int i) {
            return new C1109e[i];
        }
    }

    public C1109e(long j) {
        this.f5614b = j;
    }

    /* renamed from: a */
    public boolean m3996a(long j) {
        return j >= this.f5614b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1109e) && this.f5614b == ((C1109e) obj).f5614b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f5614b)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f5614b);
    }
}
