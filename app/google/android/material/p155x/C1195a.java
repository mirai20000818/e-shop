package custom.google.android.material.p155x;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.p020e.C0160h;
import androidx.customview.view.AbsSavedState;

import com.jeil.emarket.custom.CustomString;

/* renamed from: b.e.a.a.x.a */
/* loaded from: classes.dex */
public class C1195a extends AbsSavedState {
    public static final Parcelable.Creator<C1195a> CREATOR = new a();

    /* renamed from: d */
    public final C0160h<java.lang.String, Bundle> f6116d;

    /* renamed from: b.e.a.a.x.a$a */
    public static class a implements Parcelable.ClassLoaderCreator<C1195a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new C1195a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new C1195a[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public C1195a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new C1195a(parcel, classLoader, null);
        }
    }

    public /* synthetic */ C1195a(Parcel parcel, ClassLoader classLoader, a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        java.lang.String[] strArr = new java.lang.String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f6116d = new C0160h<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f6116d.put(strArr[i], bundleArr[i]);
        }
    }

    public C1195a(Parcelable parcelable) {
        super(parcelable);
        this.f6116d = new C0160h<>();
    }

    public java.lang.String toString() {
        StringBuilder m3163a = CustomString.format("ExtendableSavedState{");
        m3163a.append(Integer.toHexString(System.identityHashCode(this)));
        m3163a.append(" states=");
        m3163a.append(this.f6116d);
        m3163a.append("}");
        return m3163a.toString();
    }

    @Override // p000a.p048j.p049a.AbstractC0321a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1933b, i);
        int i2 = this.f6116d.f1045d;
        parcel.writeInt(i2);
        java.lang.String[] strArr = new java.lang.String[i2];
        Bundle[] bundleArr = new Bundle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = this.f6116d.m802c(i3);
            bundleArr[i3] = this.f6116d.m804e(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
