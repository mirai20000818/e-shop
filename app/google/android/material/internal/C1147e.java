package custom.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

/* renamed from: b.e.a.a.p.e */
/* loaded from: classes.dex */
public class C1147e extends LinearLayoutCompat {

    /* renamed from: q */
    public Drawable f5842q;

    /* renamed from: r */
    public final Rect f5843r;

    /* renamed from: s */
    public final Rect f5844s;

    /* renamed from: t */
    public int f5845t;

    /* renamed from: u */
    public boolean f5846u;

    /* renamed from: v */
    public boolean f5847v;

    public C1147e(Context context) {
        this(context, null);
    }

    public C1147e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1147e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5843r = new Rect();
        this.f5844s = new Rect();
        this.f5845t = 119;
        this.f5846u = true;
        this.f5847v = false;
        TypedArray m4125b = C1157o.m4125b(context, attributeSet, R$styleable.ForegroundLinearLayout, i, 0, new int[0]);
        this.f5845t = m4125b.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.f5845t);
        Drawable drawable = m4125b.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f5846u = m4125b.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        m4125b.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f5842q;
        if (drawable != null) {
            if (this.f5847v) {
                this.f5847v = false;
                Rect rect = this.f5843r;
                Rect rect2 = this.f5844s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f5846u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f5845t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f5842q;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f5842q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f5842q.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f5842q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f5845t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5842q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3305e == 1) {
            m2251b(i, i2, i3, i4);
        } else {
            m2246a(i, i2, i3, i4);
        }
        this.f5847v = z | this.f5847v;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5847v = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f5842q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f5842q);
            }
            this.f5842q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f5845t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f5845t != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f5845t = i;
            if (this.f5845t == 119 && this.f5842q != null) {
                this.f5842q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5842q;
    }
}
