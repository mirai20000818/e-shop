package custom.google.android.material.mng1;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* renamed from: b.e.a.a.a.e */
/* loaded from: classes.dex */
public class C1059e extends Property<ImageView, Matrix> {

    /* renamed from: a */
    public final Matrix f5385a;

    public C1059e() {
        super(Matrix.class, "imageMatrixProperty");
        this.f5385a = new Matrix();
    }

    @Override // android.util.Property
    public Matrix get(ImageView imageView) {
        this.f5385a.set(imageView.getImageMatrix());
        return this.f5385a;
    }

    @Override // android.util.Property
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
