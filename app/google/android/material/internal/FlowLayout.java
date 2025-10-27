package custom.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;

/* renamed from: b.e.a.a.p.d */
/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: b */
    public int f5838b;

    /* renamed from: c */
    public int f5839c;

    /* renamed from: d */
    public boolean f5840d;

    /* renamed from: e */
    public int f5841e;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5840d = false;
        m4100a(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5840d = false;
        m4100a(context, attributeSet);
    }

    /* renamed from: a */
    public int m4099a(View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    /* renamed from: a */
    public final void m4100a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.f5838b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_lineSpacing, 0);
        this.f5839c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public boolean mo4101a() {
        return this.f5840d;
    }

    public int getItemSpacing() {
        return this.f5839c;
    }

    public int getLineSpacing() {
        return this.f5838b;
    }

    public int getRowCount() {
        return this.f5841e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            this.f5841e = 0;
            return;
        }
        this.f5841e = 1;
        boolean z2 = ViewCompat.m1310m(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i7 = (i3 - i) - paddingLeft;
        int i8 = paddingRight;
        int i9 = paddingTop;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = Util.m175a(marginLayoutParams);
                    int i11 = Build.VERSION.SDK_INT;
                    i5 = marginLayoutParams.getMarginEnd();
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i8 + i6;
                if (!this.f5840d && measuredWidth > i7) {
                    i9 = paddingTop + this.f5838b;
                    this.f5841e++;
                    i8 = paddingRight;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f5841e - 1));
                int i12 = i8 + i6;
                int measuredWidth2 = childAt.getMeasuredWidth() + i12;
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                if (z2) {
                    i12 = i7 - measuredWidth2;
                    measuredWidth2 = (i7 - i8) - i6;
                }
                childAt.layout(i12, i9, measuredWidth2, measuredHeight);
                i8 = childAt.getMeasuredWidth() + i6 + i5 + this.f5839c + i8;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i5 - getPaddingRight();
        int i6 = paddingLeft;
        int i7 = paddingTop;
        int i8 = i7;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i4 = marginLayoutParams.leftMargin + 0;
                    i3 = marginLayoutParams.rightMargin + 0;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (childAt.getMeasuredWidth() + i6 + i4 > paddingRight && !mo4101a()) {
                    i6 = getPaddingLeft();
                    i8 = this.f5838b + i7;
                }
                int measuredWidth = i6 + i4 + childAt.getMeasuredWidth();
                i7 = childAt.getMeasuredHeight() + i8;
                if (measuredWidth <= i9) {
                    measuredWidth = i9;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i4 + i3 + this.f5839c + i6;
                if (i10 == getChildCount() - 1) {
                    measuredWidth += i3;
                }
                i6 = measuredWidth2;
                i9 = measuredWidth;
            }
        }
        int paddingRight2 = getPaddingRight() + i9;
        int paddingBottom = getPaddingBottom() + i7;
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(paddingRight2, size);
        } else if (mode != 1073741824) {
            size = paddingRight2;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != 1073741824) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i) {
        this.f5839c = i;
    }

    public void setLineSpacing(int i) {
        this.f5838b = i;
    }

    public void setSingleLine(boolean z) {
        this.f5840d = z;
    }
}
