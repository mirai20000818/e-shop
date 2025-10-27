package custom.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* renamed from: b.e.a.a.p.i */
/* loaded from: classes.dex */
public class C1151i extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<C1151i> CREATOR = new a();

    /* renamed from: b.e.a.a.p.i$a */
    public static class a implements Parcelable.ClassLoaderCreator<C1151i> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new C1151i(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new C1151i[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public C1151i createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new C1151i(parcel, classLoader);
        }
    }

    public C1151i() {
    }

    public C1151i(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i = 0; i < readInt; i++) {
            put(iArr[i], readParcelableArray[i]);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = keyAt(i2);
            parcelableArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
