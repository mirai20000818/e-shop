package com.jeil.emarket.widget.loading;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;
import com.jeil.emarket.widget.loading.other.Loading;
import com.jeil.emarket.widget.loading.other.LodingObj;

/* renamed from: b.f.a.c.g0.a */

public class LoadingIndicatorView extends View {

    
    public static int f8317e;


    public Paint f8318b;

    
    public Loading f8319c;

    
    public boolean f8320d;

    public LoadingIndicatorView(Context context) {
        super(context);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.LoadingIndicatorView);
        obtainStyledAttributes.getInt(R.styleable.LoadingIndicatorView_indicator, 22);
        f8317e = obtainStyledAttributes.getColor(R.styleable.LoadingIndicatorView_indicatorColor, -1);
        obtainStyledAttributes.recycle();
        this.f8318b = new Paint();
        this.f8318b.setColor(f8317e);
        this.f8318b.setStyle(Paint.Style.FILL);
        this.f8318b.setAntiAlias(true);
        m4608b();
    }


    public final int m4605a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }


    public void m4606a() {
        Loading loading = this.f8319c;
        if (loading == null) {
            return;
        }
        loading.m4613b();
    }


    public void m4607a(Canvas canvas) {
        Loading loading = this.f8319c;
        if (loading == null) {
            return;
        }
        Paint paint = this.f8318b;
        LodingObj lodingObj = (LodingObj) loading;
        float m4611a = lodingObj.m4611a() / 20.0f;
        for (int i = 0; i < 8; i++) {
            canvas.save();
            int m4611a2 = lodingObj.m4611a();
            View view = lodingObj.f8327a;
            int height = view == null ? 0 : view.getHeight();
            double d2 = i * 0.7853981633974483d;
            double m4611a3 = (lodingObj.m4611a() / 4.0f) - m4611a;
            canvas.translate((float) ((Math.cos(d2) * m4611a3) + (m4611a2 / 2)), (float) ((Math.sin(d2) * m4611a3) + (height / 2)));
            float[] fArr = lodingObj.f8325c;
            canvas.scale(fArr[i], fArr[i]);
            paint.setAlpha(lodingObj.f8326d[i]);
            canvas.drawCircle(0.0f, 0.0f, m4611a, paint);
            canvas.restore();
        }
    }


    public final void m4608b() {
        if (this.f8319c != null) {
            return;
        }
        this.f8319c = new LodingObj();
        this.f8319c.f8327a = this;
    }

    
    public void m4609c() {
        this.f8320d = true;
        Loading loading = this.f8319c;
        if (loading != null) {
            loading.f8327a = null;
            List<Animator> list = loading.f8328b;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Animator animator = loading.f8328b.get(i);
                    animator.cancel();
                    animator.removeAllListeners();
                }
                loading.f8328b.clear();
                loading.f8328b = null;
            }
            loading.f8328b = null;
            this.f8319c = null;
        }
        this.f8318b = null;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Loading loading = this.f8319c;
        if (loading == null) {
            return;
        }
        loading.m4612a(Loading.a.START);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Loading loading = this.f8319c;
        if (loading == null) {
            return;
        }
        loading.m4612a(Loading.a.CANCEL);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m4607a(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f8320d) {
            return;
        }
        this.f8320d = true;
        m4606a();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m4605a(((int) getContext().getResources().getDisplayMetrics().density) * 70, i), m4605a(((int) getContext().getResources().getDisplayMetrics().density) * 70, i2));
    }

    public void setIndicatorColor(int i) {
        f8317e = i;
        this.f8318b.setColor(f8317e);
        invalidate();
    }

    public void setIndicatorId(int i) {
        if (this.f8319c != null) {
            return;
        }
        this.f8319c = new LodingObj();
        this.f8319c.f8327a = this;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            Loading loading = this.f8319c;
            if (loading == null) {
                return;
            }
            if (i == 8 || i == 4) {
                this.f8319c.m4612a(Loading.a.END);
            } else {
                loading.m4612a(Loading.a.START);
            }
        }
    }
}
