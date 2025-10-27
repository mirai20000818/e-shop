package custom.google.android.material.mng2;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* renamed from: b.e.a.a.a0.c */
/* loaded from: classes.dex */
public class C1067c implements Parcelable {
    public static final Parcelable.Creator<C1067c> CREATOR = new a();

    /* renamed from: b */
    public final int f5404b;

    /* renamed from: c */
    public int f5405c;

    /* renamed from: d */
    public int f5406d;

    /* renamed from: e */
    public int f5407e;

    /* renamed from: b.e.a.a.a0.c$a */
    public static class a implements Parcelable.Creator<C1067c> {
        @Override // android.os.Parcelable.Creator
        public C1067c createFromParcel(Parcel parcel) {
            return new C1067c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public C1067c[] newArray(int i) {
            return new C1067c[i];
        }
    }

    public C1067c() {
        this(0, 0, 10, 0);
    }

    public C1067c(int i, int i2, int i3, int i4) {
        this.f5405c = i;
        this.f5406d = i2;
        this.f5407e = i3;
        this.f5404b = i4;
        new C1065a(59);
        new C1065a(i4 == 1 ? 24 : 12);
    }

    /* renamed from: a */
    public static String m3877a(Resources resources, CharSequence charSequence) {
        return String.format(resources.getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1067c)) {
            return false;
        }
        C1067c c1067c = (C1067c) obj;
        return this.f5405c == c1067c.f5405c && this.f5406d == c1067c.f5406d && this.f5404b == c1067c.f5404b && this.f5407e == c1067c.f5407e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5404b), Integer.valueOf(this.f5405c), Integer.valueOf(this.f5406d), Integer.valueOf(this.f5407e)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5405c);
        parcel.writeInt(this.f5406d);
        parcel.writeInt(this.f5407e);
        parcel.writeInt(this.f5404b);
    }
}
