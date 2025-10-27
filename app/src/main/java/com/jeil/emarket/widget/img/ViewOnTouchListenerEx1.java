package com.jeil.emarket.widget.img;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.jeil.emarket.widget.img.ani.ValueAnimatorListenEx;
import com.jeil.emarket.widget.img.ani.ValueAnimatorListenEx1;

/* renamed from: b.f.a.c.h0.b */

public class ViewOnTouchListenerEx1 extends ViewOnTouchListenerEx {

    
    public InterfaceEx f8339A;

    /* renamed from: h */
    public final GestureDetector f8344h;

    /* renamed from: l */
    public float f8348l;

    /* renamed from: y */
    public boolean f8361y;

    /* renamed from: z */
    public ValueAnimator f8362z;

    
    public final ImageViewObj f8340d = new ImageViewObjEx();

    
    public final Matrix f8341e = new Matrix();

    
    public int f8345i = 0;

    /* renamed from: f */
    public final PointF f8342f = new PointF();

    /* renamed from: g */
    public final PointF f8343g = new PointF();

   
    public float f8346j = 1.0f;

    
    public float f8347k = 0.0f;

    /* renamed from: n */
    public boolean f8350n = false;

    /* renamed from: o */
    public boolean f8351o = true;

    /* renamed from: p */
    public boolean f8352p = true;

    /* renamed from: q */
    public boolean f8353q = true;

    /* renamed from: m */
    public long f8349m = 100;

    /* renamed from: t */
    public long f8356t = 200;

    /* renamed from: r */
    public long f8354r = 200;

    /* renamed from: s */
    public long f8355s = 200;

    /* renamed from: x */
    public float f8360x = 1.337f;

    /* renamed from: w */
    public float f8359w = 0.1337f;

    /* renamed from: u */
    public float f8357u = 2.5f;

    /* renamed from: v */
    public float f8358v = 1.4f;

    /* renamed from: b.f.a.c.h0.b$b */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public  b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            ViewOnTouchListenerEx1 viewOnTouchListenerEx1 = ViewOnTouchListenerEx1.this;
            if (viewOnTouchListenerEx1.f8357u <= 0.0f || viewOnTouchListenerEx1.m4623a()) {
                return super.onDoubleTap(motionEvent);
            }
            float f = ViewOnTouchListenerEx1.this.f8340d.m4618b()[0];
            float m4614a = ViewOnTouchListenerEx1.this.f8340d.m4614a();
            ViewOnTouchListenerEx1 viewOnTouchListenerEx12 = ViewOnTouchListenerEx1.this;
            float f2 = viewOnTouchListenerEx12.f8358v * m4614a;
            ValueAnimatorListenEx1 valueAnimatorListenEx1 = new ValueAnimatorListenEx1(viewOnTouchListenerEx12.f8340d, motionEvent.getX(), motionEvent.getY());
            float f3 = f > f2 ? m4614a : ViewOnTouchListenerEx1.this.f8357u * f;
            ViewOnTouchListenerEx1 viewOnTouchListenerEx13 = ViewOnTouchListenerEx1.this;
            viewOnTouchListenerEx13.m4621a(f, f3, viewOnTouchListenerEx13.f8356t, valueAnimatorListenEx1, null);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            ViewOnTouchListenerEx1 viewOnTouchListenerEx1 = ViewOnTouchListenerEx1.this;
            if (viewOnTouchListenerEx1.f8345i != 1 || viewOnTouchListenerEx1.f8354r <= 0 || viewOnTouchListenerEx1.m4623a()) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            ViewOnTouchListenerEx1 viewOnTouchListenerEx12 = ViewOnTouchListenerEx1.this;
            float f3 = (viewOnTouchListenerEx12.f8354r / 1000.0f) * viewOnTouchListenerEx12.f8359w;
            float[] m4618b = viewOnTouchListenerEx12.f8340d.m4618b();
            ViewOnTouchListenerEx1.this.f8362z = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("translateX", m4618b[2], m4618b[2] + (f * f3 * m4618b[0])), PropertyValuesHolder.ofFloat("translateY", m4618b[5], m4618b[5] + (f2 * f3 * m4618b[4])));
            ViewOnTouchListenerEx1 viewOnTouchListenerEx13 = ViewOnTouchListenerEx1.this;
            viewOnTouchListenerEx13.f8362z.setDuration(viewOnTouchListenerEx13.f8354r);
            ViewOnTouchListenerEx1 viewOnTouchListenerEx14 = ViewOnTouchListenerEx1.this;
            viewOnTouchListenerEx14.f8362z.addUpdateListener(new ValueAnimatorListenEx(viewOnTouchListenerEx14.f8340d));
            ViewOnTouchListenerEx1.this.f8362z.setInterpolator(new DecelerateInterpolator());
            ViewOnTouchListenerEx1.this.f8362z.start();
            return true;
        }
    }

    public ViewOnTouchListenerEx1(Context context) {
        b bVar = new b();
        this.f8344h = new GestureDetector(context, bVar);
        this.f8344h.setOnDoubleTapListener(bVar);
    }

    
    public final void m4621a(float f, float f2, long j, ValueAnimatorListenEx1 valueAnimatorListenEx1, Interpolator interpolator) {
        if (m4623a()) {
            throw new IllegalStateException("An animation is currently running; Check isAnimating() first!");
        }
        this.f8362z = ValueAnimator.ofFloat(f, f2);
        this.f8362z.setDuration(j);
        this.f8362z.addUpdateListener(valueAnimatorListenEx1);
        if (interpolator != null) {
            this.f8362z.setInterpolator(interpolator);
        }
        this.f8362z.start();
    }

    
    public final void m4622a(MotionEvent motionEvent, Matrix matrix) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            this.f8366c.put(motionEvent.getPointerId(i), new PointF(motionEvent.getX(i), motionEvent.getY(i)));
        }
        this.f8341e.set(matrix);
        int size = this.f8365b.size();
        if (size == 0) {
            this.f8345i = 0;
            return;
        }
        if (m4623a()) {
            this.f8362z.cancel();
        }
        if (size != 1) {
            if (size > 1) {
                this.f8345i = 2;
                this.f8346j = ViewOnTouchListenerEx.m4625a(motionEvent, motionEvent.findPointerIndex(m4628a(0)), motionEvent.findPointerIndex(m4628a(1)));
                this.f8348l = 0.0f;
                if (this.f8346j > 10.0f) {
                    ViewOnTouchListenerEx.m4627a(this.f8342f, motionEvent, m4628a(0), m4628a(1));
                    this.f8347k = ViewOnTouchListenerEx.m4626a(motionEvent, m4628a(0), m4628a(1), m4629b(0).y < m4629b(1).y);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f8345i == 2 && this.f8355s > 0 && !m4623a()) {
            float pow = (float) Math.pow(Math.pow(Math.pow(this.f8348l, 0.001d), this.f8355s), this.f8360x);
            long j = this.f8355s;
            PointF pointF = this.f8343g;
            float f = pointF.x;
            float f2 = pointF.y;
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            float f3 = this.f8340d.m4618b()[0];
            m4621a(f3, f3 * pow, j, new ValueAnimatorListenEx1(this.f8340d, f, f2), decelerateInterpolator);
        }
        this.f8345i = 1;
    }

    
    public boolean m4623a() {
        ValueAnimator valueAnimator = this.f8362z;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // p078b.p159f.p160a.p190c.p204h0.ViewOnTouchListenerC2036d, android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.onTouch(view, motionEvent);
        this.f8344h.onTouchEvent(motionEvent);
        try {
            ImageView imageView = (ImageView) view;
            Matrix imageMatrix = imageView.getImageMatrix();
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            int i = 0;
            motionEvent.getPointerCoords(0, pointerCoords);
            Rect rect = new Rect();
            float[] fArr = new float[9];
            imageMatrix.getValues(fArr);
            imageView.getDrawingRect(rect);
            float f = pointerCoords.y;
            if (f < fArr[5] || (f > rect.bottom - fArr[5] && this.f8339A != null)) {
                this.f8339A.mo4630a();
                return true;
            }
            ImageViewObj imageViewObj = this.f8340d;
            if (imageViewObj.f8336c != imageView) {
                imageViewObj.m4616a(imageView);
            } else {
                ImageView.ScaleType scaleType = imageView.getScaleType();
                ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
                if (scaleType != scaleType2) {
                    imageView.setScaleType(scaleType2);
                    ImageViewObj imageViewObj2 = this.f8340d;
                    imageViewObj2.f8335b = imageMatrix;
                    imageViewObj2.m4620d();
                }
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0 && actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f8361y) {
                        m4622a(motionEvent, imageMatrix);
                        this.f8361y = false;
                    }
                    imageMatrix.set(this.f8341e);
                    if (this.f8345i == 1 && this.f8352p) {
                        PointF m4629b = m4629b(0);
                        int findPointerIndex = motionEvent.findPointerIndex(m4628a(0));
                        imageMatrix.postTranslate(this.f8340d.m4617b(2, motionEvent.getX(findPointerIndex) - m4629b.x), this.f8340d.m4617b(5, motionEvent.getY(findPointerIndex) - m4629b.y));
                    } else if (this.f8345i == 2) {
                        ViewOnTouchListenerEx.m4627a(this.f8343g, motionEvent, m4628a(0), m4628a(1));
                        if (this.f8350n) {
                            float m4626a = this.f8347k - ViewOnTouchListenerEx.m4626a(motionEvent, m4628a(0), m4628a(1), m4629b(0).y < m4629b(1).y);
                            PointF pointF = this.f8343g;
                            imageMatrix.postRotate(m4626a, pointF.x, pointF.y);
                        }
                        if (this.f8351o) {
                            float m4617b = this.f8340d.m4617b(0, ViewOnTouchListenerEx.m4625a(motionEvent, motionEvent.findPointerIndex(m4628a(0)), motionEvent.findPointerIndex(m4628a(1))) / this.f8346j);
                            PointF pointF2 = this.f8343g;
                            imageMatrix.postScale(m4617b, m4617b, pointF2.x, pointF2.y);
                            if (motionEvent.getHistorySize() > 0) {
                                int m4628a = m4628a(0);
                                int m4628a2 = m4628a(1);
                                long j = this.f8349m;
                                int findPointerIndex2 = motionEvent.findPointerIndex(m4628a);
                                int findPointerIndex3 = motionEvent.findPointerIndex(m4628a2);
                                long eventTime = motionEvent.getEventTime();
                                float m4625a = ViewOnTouchListenerEx.m4625a(motionEvent, findPointerIndex2, findPointerIndex3);
                                int historySize = motionEvent.getHistorySize();
                                long j2 = 0;
                                float f2 = m4625a;
                                float f3 = 1.0f;
                                while (i < historySize && j2 < j) {
                                    int i2 = (historySize - 1) - i;
                                    float historicalX = motionEvent.getHistoricalX(findPointerIndex2, i2) - motionEvent.getHistoricalX(findPointerIndex3, i2);
                                    float historicalY = motionEvent.getHistoricalY(findPointerIndex2, i2) - motionEvent.getHistoricalY(findPointerIndex3, i2);
                                    float f4 = (historicalY * historicalY) + (historicalX * historicalX);
                                    long j3 = eventTime;
                                    float sqrt = (float) Math.sqrt(f4);
                                    f3 *= f2 / sqrt;
                                    j2 = j3 - motionEvent.getHistoricalEventTime(i2);
                                    i++;
                                    f2 = sqrt;
                                    eventTime = j3;
                                }
                                this.f8348l = (float) Math.pow(Math.pow(f3, 1.0d / j), 1000.0d);
                            }
                        }
                        if (this.f8353q && this.f8352p) {
                            PointF pointF3 = this.f8343g;
                            float f5 = pointF3.x;
                            PointF pointF4 = this.f8342f;
                            imageMatrix.postTranslate(f5 - pointF4.x, pointF3.y - pointF4.y);
                        }
                        this.f8340d.mo4619c();
                    }
                    imageView.invalidate();
                    return true;
                }
                if (actionMasked != 5 && actionMasked != 6) {
                    return true;
                }
            }
            m4622a(motionEvent, imageMatrix);
            return true;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("View must be an instance of ImageView", e2);
        }
    }
}
