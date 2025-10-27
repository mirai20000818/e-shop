package custom.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import androidx.core.graphics.C0230b;
import androidx.core.view.C0278d0;
import androidx.core.view.ViewCompat;
import androidx.core.view.InterfaceC0297n;

/* renamed from: b.e.a.a.p.j */
/* loaded from: classes.dex */
public class C1152j extends FrameLayout {

    /* renamed from: b */
    public Drawable f5880b;

    /* renamed from: c */
    public Rect f5881c;

    /* renamed from: d */
    public Rect f5882d;

    /* renamed from: e */
    public boolean f5883e;

    /* renamed from: f */
    public boolean f5884f;

    /* renamed from: b.e.a.a.p.j$a */
    public class a implements InterfaceC0297n {
        public a() {
        }

        @Override // p000a.p030h.p042i.InterfaceC0297n
        /* renamed from: a */
        public C0278d0 mo368a(View view, C0278d0 c0278d0) {
            C1152j c1152j = C1152j.this;
            if (c1152j.f5881c == null) {
                c1152j.f5881c = new Rect();
            }
            C1152j.this.f5881c.set(c0278d0.m1164c(), c0278d0.m1166e(), c0278d0.m1165d(), c0278d0.m1163b());
            C1152j.this.mo4116a(c0278d0);
            C1152j c1152j2 = C1152j.this;
            boolean z = true;
            if ((!c0278d0.f1775a.mo1182h().equals(C0230b.f1635e)) && C1152j.this.f5880b != null) {
                z = false;
            }
            c1152j2.setWillNotDraw(z);
            ViewCompat.m1260G(C1152j.this);
            return c0278d0.m1161a();
        }
    }

    public C1152j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5882d = new Rect();
        this.f5883e = true;
        this.f5884f = true;
        TypedArray m4125b = C1157o.m4125b(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f5880b = m4125b.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        m4125b.recycle();
        setWillNotDraw(true);
        ViewCompat.m1278a(this, new a());
    }

    /* renamed from: a */
    public void mo4116a(C0278d0 c0278d0) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f5881c == null || this.f5880b == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f5883e) {
            this.f5882d.set(0, 0, width, this.f5881c.top);
            this.f5880b.setBounds(this.f5882d);
            this.f5880b.draw(canvas);
        }
        if (this.f5884f) {
            this.f5882d.set(0, height - this.f5881c.bottom, width, height);
            this.f5880b.setBounds(this.f5882d);
            this.f5880b.draw(canvas);
        }
        Rect rect = this.f5882d;
        Rect rect2 = this.f5881c;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f5880b.setBounds(this.f5882d);
        this.f5880b.draw(canvas);
        Rect rect3 = this.f5882d;
        Rect rect4 = this.f5881c;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f5880b.setBounds(this.f5882d);
        this.f5880b.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f5880b;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f5880b;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f5884f = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f5883e = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f5880b = drawable;
    }
}
