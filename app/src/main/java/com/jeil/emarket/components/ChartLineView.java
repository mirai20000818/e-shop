package com.jeil.emarket.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.jeil.emarket.custom.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.jeil.emarket.custom.font.FontManager;


public class ChartLineView extends View {

    
    public int f11966A;

    
    public int f11967B;

    
    public int f11968C;

    
    public Boolean f11969D;

    
    public int[] f11970E;

    /* renamed from: F */
    public Runnable f11971F;

    
    public final int f11972b;

    
    public final int f11973c;

    
    public final int f11974d;

    
    public final int f11975e;

    /* renamed from: f */
    public final int f11976f;

    /* renamed from: g */
    public final int f11977g;

    /* renamed from: h */
    public final int f11978h;

    
    public final Point f11979i;

   
    public boolean f11980j;

    
    public int f11981k;

    /* renamed from: l */
    public int f11982l;

    /* renamed from: m */
    public int f11983m;

    /* renamed from: n */
    public ArrayList<String> f11984n;

    /* renamed from: o */
    public ArrayList<ArrayList<Float>> f11985o;

    /* renamed from: p */
    public ArrayList<Integer> f11986p;

    /* renamed from: q */
    public ArrayList<Integer> f11987q;

    /* renamed from: r */
    public ArrayList<ArrayList<C3232b>> f11988r;

    /* renamed from: s */
    public Paint f11989s;

    /* renamed from: t */
    public int f11990t;

    /* renamed from: u */
    public Paint f11991u;

    /* renamed from: v */
    public C3232b f11992v;

    /* renamed from: w */
    public C3232b f11993w;

    /* renamed from: x */
    public int f11994x;

    /* renamed from: y */
    public String f11995y;

    /* renamed from: z */
    public int f11996z;

    /* renamed from: com.jeil.emarket.components.ChartLineView$a */
    public class RunnableC3231a implements Runnable {
        public RunnableC3231a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<ArrayList<C3232b>> it = ChartLineView.this.f11988r.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Iterator<C3232b> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    C3232b next = it2.next();
                    next.f11998a = (int) next.m6817a(next.f11998a, next.f12002e, next.f12004g);
                    next.f11999b = next.m6817a(next.f11999b, next.f12003f, next.f12004g);
                    if (!(next.f11998a == next.f12002e && next.f11999b == next.f12003f)) {
                        z = true;
                    }
                }
            }
            if (z) {
                ChartLineView.this.postDelayed(this, 25L);
            }
            ChartLineView.this.invalidate();
        }
    }

    /* renamed from: com.jeil.emarket.components.ChartLineView$b */
    public class C3232b {

        
        public int f11998a;

        
        public float f11999b;

        
        public float f12000c;

        
        public int f12001d;

        
        public int f12002e;

        /* renamed from: f */
        public float f12003f;

        /* renamed from: g */
        public int f12004g;

        public C3232b(int i, float f, int i2, float f2, float f3, int i3) {
            this.f12004g = Util.dp2px(ChartLineView.this.getContext(), 18);
            this.f11998a = i;
            this.f11999b = f;
            this.f12001d = i3;
            this.f12002e = i2;
            this.f12003f = f2;
            this.f12000c = f3;
            this.f12001d = i3;
        }

        
        public final float m6817a(float f, float f2, int i) {
            if (f < f2) {
                f += i;
            } else if (f > f2) {
                f -= i;
            }
            return Math.abs(f2 - f) < ((float) i) ? f2 : f;
        }

        
        public Point m6818a(Point point) {
            point.set(this.f11998a, (int) this.f11999b);
            return point;
        }

        
        public C3232b m6819a(int i, float f, float f2, int i2) {
            this.f12002e = i;
            this.f12003f = f;
            this.f12000c = f2;
            this.f12001d = i2;
            return this;
        }
    }

    public ChartLineView(Context context) {
        this(context, null);
    }

    public ChartLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11972b = Util.dp2px(getContext(), 2);
        this.f11973c = Util.dp2px(getContext(), 5);
        this.f11974d = Util.dp2px(getContext(), -11);
        this.f11975e = Util.dp2px(getContext(), 22);
        this.f11976f = Util.dp2px(getContext(), 2);
        this.f11977g = Util.dp2px(getContext(), 5);
        this.f11978h = Color.parseColor("#EEEEEE");
        this.f11979i = new Point();
        this.f11980j = true;
        this.f11982l = 10;
        this.f11983m = 0;
        this.f11984n = new ArrayList<>();
        this.f11986p = new ArrayList<>();
        this.f11987q = new ArrayList<>();
        this.f11988r = new ArrayList<>();
        this.f11989s = new Paint();
        this.f11991u = new Paint();
        this.f11994x = Util.dp2px(getContext(), 3);
        this.f11995y = "";
        this.f11996z = Util.dp2px(getContext(), 12);
        this.f11966A = (Util.dp2px(getContext(), 45) / 3) * 2;
        this.f11967B = Util.dp2px(getContext(), 45);
        this.f11968C = 3;
        this.f11969D = false;
        this.f11970E = new int[]{Color.parseColor("#e74c3c"), Color.parseColor("#2980b9"), Color.parseColor("#1abc9c")};
        this.f11971F = new RunnableC3231a();
        this.f11991u.setAntiAlias(true);
        this.f11991u.setColor(-1);
        this.f11991u.setTextSize(Util.dp2px(getContext(), 10));
        this.f11991u.setStrokeWidth(5.0f);
        this.f11991u.setTextAlign(Paint.Align.CENTER);
        this.f11991u.setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
        this.f11989s.setAntiAlias(true);
        this.f11989s.setTextSize(Util.dp2px(getContext(), 12));
        this.f11989s.setTextAlign(Paint.Align.CENTER);
        this.f11989s.setStyle(Paint.Style.FILL);
        this.f11989s.setColor(Color.parseColor("#9B9A9B"));
        this.f11989s.setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
        this.f11996z = getPopupHeight() + this.f11977g + this.f11976f + 2;
    }

    private int getHorizontalGridNum() {
        int size = this.f11984n.size() - 1;
        if (size < 1) {
            return 1;
        }
        return size;
    }

    private int getPopupHeight() {
        Rect rect = new Rect();
        this.f11991u.getTextBounds("9", 0, 1, rect);
        return new Rect((-rect.width()) / 2, (((-rect.height()) - 12) - (this.f11972b * 2)) - this.f11973c, rect.width() / 2, (this.f11972b - this.f11973c) + this.f11994x).height();
    }

    private int getVerticalGridlNum() {
        ArrayList<ArrayList<Float>> arrayList = this.f11985o;
        int i = 4;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ArrayList<Float>> it = this.f11985o.iterator();
            while (it.hasNext()) {
                Iterator<Float> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    if (i < it2.next().floatValue() + 1.0f) {
                        i = (int) Math.floor(it2.next().floatValue() + 1.0f);
                    }
                }
            }
        }
        return i;
    }

    @SuppressLint({"SwitchIntDef"})
    
    public final int m6812a(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i2 : size : Math.min(i2, size);
    }

    
    public final void m6813a() {
        int verticalGridlNum = getVerticalGridlNum();
        this.f11987q.clear();
        ArrayList<Integer> arrayList = this.f11987q;
        int i = this.f11996z;
        arrayList.add(Integer.valueOf((((((((this.f11981k - i) - this.f11983m) - this.f11974d) - this.f11975e) - this.f11990t) * verticalGridlNum) / verticalGridlNum) + i));
        ArrayList<ArrayList<Float>> arrayList2 = this.f11985o;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            if (this.f11988r.size() == 0) {
                for (int i2 = 0; i2 < this.f11985o.size(); i2++) {
                    this.f11988r.add(new ArrayList<>());
                }
            }
            for (int i3 = 0; i3 < this.f11985o.size(); i3++) {
                int size = this.f11988r.get(i3).isEmpty() ? 0 : this.f11988r.get(i3).size();
                for (int i4 = 0; i4 < this.f11985o.get(i3).size(); i4++) {
                    int intValue = this.f11986p.get(i4).intValue();
                    float floatValue = this.f11985o.get(i3).get(i4).floatValue();
                    float verticalGridlNum2 = (((verticalGridlNum - floatValue) * (((((this.f11981k ) - this.f11983m) - this.f11974d) - this.f11975e) - this.f11990t)) / getVerticalGridlNum()) + this.f11996z;
                    if (i4 > size - 1) {
                        this.f11988r.get(i3).add(new C3232b(intValue, 0.0f, intValue, verticalGridlNum2, this.f11985o.get(i3).get(i4).floatValue(), i3));
                    } else {
                        ArrayList<C3232b> arrayList3 = this.f11988r.get(i3);
                        C3232b c3232b = this.f11988r.get(i3).get(i4);
                        c3232b.m6819a(intValue, verticalGridlNum2, this.f11985o.get(i3).get(i4).floatValue(), i3);
                        arrayList3.set(i4, c3232b);
                    }
                }
                int size2 = this.f11988r.get(i3).size() - this.f11985o.get(i3).size();
                for (int i5 = 0; i5 < size2; i5++) {
                    this.f11988r.get(i3).remove(this.f11988r.get(i3).size() - 1);
                }
            }
        }
        removeCallbacks(this.f11971F);
        post(this.f11971F);
    }

    
    public final void m6814a(Canvas canvas, float f, Point point, int i) {
        if (i != 0) {
            String str = Util.m303b(f) + this.f11995y;
            int m170a = Util.dp2px(getContext(), str.length() == 1 ? 10 : 8);
            int i2 = point.x;
            int m170a2 = point.y - Util.dp2px(getContext(), 5);
            Rect rect = new Rect();
            this.f11991u.getTextBounds(str, 0, str.length(), rect);
            Rect rect2 = new Rect((i2 - (rect.width() / 2)) - m170a, (((m170a2 - rect.height()) - 12) - (this.f11972b * 2)) - this.f11973c, (rect.width() / 2) + i2 + m170a, ((this.f11972b + m170a2) - this.f11973c) + this.f11994x);
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) getResources().getDrawable(R.drawable.chart_popup);
            ninePatchDrawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
            ninePatchDrawable.setBounds(rect2);
            ninePatchDrawable.draw(canvas);
            canvas.drawText(str, i2, (m170a2 - 12) - this.f11973c, this.f11991u);
        }
    }

    
    public void m6815b() {
        this.f11988r.clear();
    }

    
    public void m6816c() {
        this.f11969D = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        C3232b c3232b;
        float f = 0;
        Point point = null;
        int i = 0;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Util.dp2px(getContext(), 1.0f));
        paint.setColor(this.f11978h);
        paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f, 10.0f, 5.0f}, 1.0f));
        Path path = new Path();
        for (int i2 = 0; i2 < this.f11987q.size(); i2++) {
            if (((this.f11987q.size() - 1) - i2) % this.f11982l == 0) {
                path.moveTo(0.0f, this.f11987q.get(i2).intValue());
                path.lineTo(getWidth(), this.f11987q.get(i2).intValue());
                canvas.drawPath(path, paint);
            }
        }
        if (this.f11984n != null) {
            for (int i3 = 0; i3 < this.f11984n.size(); i3++) {
                canvas.drawText(this.f11984n.get(i3), (this.f11967B * i3) + this.f11966A, this.f11981k - this.f11990t, this.f11989s);
            }
        }
        if (!this.f11969D.booleanValue()) {
            for (int i4 = 0; i4 < this.f11987q.size(); i4++) {
                if (((this.f11987q.size() - 1) - i4) % this.f11982l == 0) {
                    canvas.drawLine(0.0f, this.f11987q.get(i4).intValue(), getWidth(), this.f11987q.get(i4).intValue(), paint);
                }
            }
        }
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(Util.dp2px(getContext(), 2));
        for (int i5 = 0; i5 < this.f11988r.size(); i5++) {
            int[] iArr = this.f11970E;
            if (iArr[i5 % iArr.length] != 0) {
                paint2.setColor(iArr[i5 % iArr.length]);
                int i6 = 0;
                while (i6 < this.f11988r.get(i5).size() - 1) {
                    int i7 = i6 + 1;
                    canvas.drawLine(this.f11988r.get(i5).get(i6).f11998a, this.f11988r.get(i5).get(i6).f11999b, this.f11988r.get(i5).get(i7).f11998a, this.f11988r.get(i5).get(i7).f11999b, paint2);
                    i6 = i7;
                }
            }
        }
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        Paint paint4 = new Paint(paint3);
        paint4.setColor(Color.parseColor("#FFFFFF"));
        ArrayList<ArrayList<C3232b>> arrayList = this.f11988r;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i8 = 0; i8 < this.f11988r.size(); i8++) {
                int[] iArr2 = this.f11970E;
                if (iArr2[i8 % iArr2.length] != 0) {
                    paint3.setColor(iArr2[i8 % iArr2.length]);
                    Iterator<C3232b> it = this.f11988r.get(i8).iterator();
                    while (it.hasNext()) {
                        C3232b next = it.next();
                        canvas.drawCircle(next.f11998a, next.f11999b, this.f11977g, paint3);
                        canvas.drawCircle(next.f11998a, next.f11999b, this.f11976f, paint4);
                    }
                }
            }
        }
        ArrayList<ArrayList<C3232b>> arrayList2 = this.f11988r;
        if (arrayList2 == null || this.f11985o == null || arrayList2.size() != this.f11985o.size()) {
            return;
        }
        for (int i9 = 0; i9 < this.f11988r.size(); i9++) {
            float floatValue = ((Float) Collections.max(this.f11985o.get(i9))).floatValue();
            float floatValue2 = ((Float) Collections.min(this.f11985o.get(i9))).floatValue();
            Iterator<C3232b> it2 = this.f11988r.get(i9).iterator();
            while (it2.hasNext()) {
                C3232b next2 = it2.next();
                int i10 = this.f11968C;
                if (i10 == 1) {
                    f = next2.f12000c;
                    point = this.f11979i;
                    next2.m6818a(point);
                    int[] iArr3 = this.f11970E;
                    i = iArr3[i9 % iArr3.length];
                } else if (i10 == 2) {
                    float f2 = next2.f12000c;
                    if (f2 == floatValue) {
                        Point point2 = this.f11979i;
                        next2.m6818a(point2);
                        int[] iArr4 = this.f11970E;
                        m6814a(canvas, f2, point2, iArr4[i9 % iArr4.length]);
                    }
                    f = next2.f12000c;
                    if (f == floatValue2) {
                        point = this.f11979i;
                        next2.m6818a(point);
                        int[] iArr5 = this.f11970E;
                        i = iArr5[i9 % iArr5.length];
                    }
                }
                m6814a(canvas, f, point, i);
            }
        }
        if (!this.f11980j || (c3232b = this.f11993w) == null) {
            return;
        }
        float f3 = c3232b.f12000c;
        Point point3 = this.f11979i;
        c3232b.m6818a(point3);
        int[] iArr6 = this.f11970E;
        m6814a(canvas, f3, point3, iArr6[this.f11993w.f12001d % iArr6.length]);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int m6812a = m6812a(i, (this.f11966A * 2) + (this.f11967B * getHorizontalGridNum()));
        this.f11981k = m6812a(i2, 0);
        m6813a();
        setMeasuredDimension(m6812a, this.f11981k);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C3232b c3232b;
        C3232b c3232b2 = null;
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!this.f11988r.isEmpty()) {
                int i = this.f11967B / 2;
                Region region = new Region();
                int size = this.f11988r.size();
                loop0: while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    int[] iArr = this.f11970E;
                    if (iArr[size % iArr.length] != 0) {
                        Iterator<C3232b> it = this.f11988r.get(size).iterator();
                        while (it.hasNext()) {
                            C3232b next = it.next();
                            int i2 = next.f11998a;
                            int i3 = (int) next.f11999b;
                            region.set(i2 - i, i3 - i, i2 + i, i3 + i);
                            if (region.contains(x, y)) {
                                c3232b2 = next;
                                break loop0;
                            }
                        }
                    }
                }
            }
            this.f11992v = c3232b2;
        } else if (motionEvent.getAction() == 1 && (c3232b = this.f11992v) != null) {
            this.f11993w = c3232b;
            this.f11992v = null;
            postInvalidate();
        }
        return true;
    }

    public void setBottomTextList(ArrayList<String> arrayList) {
        this.f11984n = arrayList;
        Rect rect = new Rect();
        this.f11990t = 0;
        Iterator<String> it = arrayList.iterator();
        String str = "";
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            this.f11989s.getTextBounds(next, 0, next.length(), rect);
            if (this.f11983m < rect.height()) {
                this.f11983m = rect.height();
            }
            if (i < rect.width()) {
                i = rect.width();
                str = next;
            }
            if (this.f11990t < Math.abs(rect.bottom)) {
                this.f11990t = Math.abs(rect.bottom);
            }
        }
        if (this.f11967B < i) {
            this.f11967B = ((int) this.f11989s.measureText(str, 0, 1)) + i;
        }
        int i2 = i / 2;
        if (this.f11966A < i2) {
            this.f11966A = i2;
        }
        int horizontalGridNum = getHorizontalGridNum();
        this.f11986p.clear();
        for (int i3 = 0; i3 < horizontalGridNum + 1; i3++) {
            this.f11986p.add(Integer.valueOf((this.f11967B * i3) + this.f11966A));
        }
    }

    public void setColorArray(int[] iArr) {
        this.f11970E = iArr;
    }

    public void setFloatDataList(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        this.f11993w = null;
        this.f11985o = arrayList;
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().size() > this.f11984n.size()) {
                throw new RuntimeException("LineView error: dataList.size() > bottomTextList.size()");
            }
        }
        float f = 0.0f;
        Iterator<ArrayList<Float>> it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                m6813a();
                this.f11980j = true;
                setMinimumWidth(0);
                postInvalidate();
                return;
            }
            Iterator<Float> it3 = it2.next().iterator();
            while (it3.hasNext()) {
                Float next = it3.next();
                if (f < next.floatValue()) {
                    f = next.floatValue();
                }
            }
            while (true) {
                this.f11982l = i;
                float f2 = f / 10.0f;
                int i2 = this.f11982l;
                i = f2 > ((float) i2) ? i2 * 10 : 1;
            }
        }
    }

    public void setGraphUnit(String str) {
        this.f11995y = str;
    }

    public void setShowPopup(int i) {
        this.f11968C = i;
    }
}
