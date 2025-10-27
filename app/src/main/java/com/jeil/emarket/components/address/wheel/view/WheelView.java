package com.jeil.emarket.components.address.wheel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import com.jeil.emarket.components.pickerview.p220l.p221a.InterfaceC2131a;
import com.jeil.emarket.components.pickerview.p220l.p222b.InterfaceC2132a;
import com.jeil.emarket.components.pickerview.p220l.p223c.C2133a;
import com.jeil.emarket.components.pickerview.p220l.p223c.InterfaceC2134b;
import com.jeil.emarket.components.pickerview.p220l.p224d.C2135a;
import com.jeil.emarket.components.pickerview.p220l.p224d.C2137c;
import com.jeil.emarket.components.pickerview.p220l.p224d.HandlerC2136b;
import com.jeil.emarket.custom.font.FontManager;


public class WheelView extends View {

    
    public int f12095A;

    
    public int f12096B;

    
    public int f12097C;

    
    public int f12098D;

    
    public int f12099E;

    /* renamed from: F */
    public int f12100F;

    /* renamed from: G */
    public int f12101G;

    /* renamed from: H */
    public int f12102H;

    
    public float f12103I;

   
    public long f12104J;

    
    public int f12105K;

    /* renamed from: L */
    public int f12106L;

    /* renamed from: M */
    public int f12107M;

    /* renamed from: N */
    public boolean f12108N;

    
    public Context f12109b;

    
    public Handler f12110c;

    
    public GestureDetector f12111d;

    
    public InterfaceC2134b f12112e;

    /* renamed from: f */
    public ScheduledExecutorService f12113f;

    /* renamed from: g */
    public ScheduledFuture<?> f12114g;

    /* renamed from: h */
    public Paint f12115h;

    
    public Paint f12116i;

   
    public Paint f12117j;

    
    public InterfaceC2131a f12118k;

    /* renamed from: l */
    public String f12119l;

    /* renamed from: m */
    public int f12120m;

    /* renamed from: n */
    public int f12121n;

    /* renamed from: o */
    public int f12122o;

    /* renamed from: p */
    public float f12123p;

    /* renamed from: q */
    public Typeface f12124q;

    /* renamed from: r */
    public int f12125r;

    /* renamed from: s */
    public int f12126s;

    /* renamed from: t */
    public int f12127t;

    /* renamed from: u */
    public int f12128u;

    /* renamed from: v */
    public float f12129v;

    /* renamed from: w */
    public boolean f12130w;

    /* renamed from: x */
    public float f12131x;

    /* renamed from: y */
    public float f12132y;

    /* renamed from: z */
    public float f12133z;

    /* renamed from: com.jeil.emarket.components.address.wheel.view.WheelView$a */
    public class RunnableC3240a implements Runnable {
        public RunnableC3240a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView wheelView = WheelView.this;
            wheelView.f12112e.mo4719a(wheelView.getCurrentItem());
        }
    }

    /* renamed from: com.jeil.emarket.components.address.wheel.view.WheelView$b */
    public enum EnumC3241b {
        CLICK,
        FLING,
        DAGGLE
    }

    /* renamed from: com.jeil.emarket.components.address.wheel.view.WheelView$c */
    public enum EnumC3242c {
        FILL,
        WRAP,
        CIRCLE
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12113f = Executors.newSingleThreadScheduledExecutor();
        this.f12124q = FontManager.getFont(getContext(), "font/cheonlima.ttf");
        this.f12128u = 1;
        this.f12129v = 2.7f;
        this.f12098D = 6;
        this.f12102H = 0;
        this.f12103I = 0.0f;
        this.f12104J = 0L;
        this.f12106L = 17;
        this.f12107M = 0;
        this.f12108N = true;
        this.f12120m = getResources().getDimensionPixelSize(R.dimen.font_20);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PickerView, 0, 0);
            this.f12106L = obtainStyledAttributes.getInt(R.styleable.PickerView_wheel_gravity, 17);
            this.f12125r = obtainStyledAttributes.getColor(R.styleable.PickerView_wheel_dividerColor, -5723992);
            this.f12126s = obtainStyledAttributes.getColor(R.styleable.PickerView_wheel_textColorCenter, -14013910);
            this.f12127t = obtainStyledAttributes.getColor(R.styleable.PickerView_wheel_textColorOut, -1118482);
            this.f12128u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PickerView_wheel_textSize, 2);
            this.f12120m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PickerView_wheel_dividerWidth, this.f12120m);
            this.f12129v = obtainStyledAttributes.getFloat(R.styleable.PickerView_wheel_lineSpacingMultiplier, this.f12129v);
            obtainStyledAttributes.recycle();
        }
        m6860c();
        this.f12109b = context;
        this.f12110c = new HandlerC2136b(this);
        this.f12111d = new GestureDetector(context, new C2133a(this));
        this.f12111d.setIsLongpressEnabled(false);
        this.f12130w = true;
        this.f12133z = 0.0f;
        this.f12095A = -1;
        this.f12115h = new Paint();
        this.f12115h.setColor(this.f12125r);
        this.f12115h.setAntiAlias(true);
        this.f12115h.setTypeface(this.f12124q);
        this.f12115h.setTextSize(this.f12120m);
        this.f12116i = new Paint();
        this.f12116i.setColor(this.f12126s);
        this.f12116i.setAntiAlias(true);
        this.f12116i.setTypeface(this.f12124q);
        this.f12116i.setTextSize(this.f12120m);
        this.f12117j = new Paint();
        this.f12117j.setColor(this.f12127t);
        this.f12117j.setAntiAlias(true);
        this.f12117j.setStrokeWidth(this.f12128u);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    private void setOutPaintStyle(float f) {
        this.f12115h.setAlpha(this.f12108N ? Math.max((int) (((90.0f - (Math.abs(f) * 1.5f)) / 90.0f) * 255.0f), 0) : 255);
    }

    
    public final int m6854a(int i) {
        int mo4715a = this.f12118k.mo4715a();
        return i < 0 ? m6854a(mo4715a + i) : i > mo4715a + (-1) ? m6854a(i - this.f12118k.mo4715a()) : i;
    }

    
    public final String m6855a(Object obj) {
        return obj == null ? "" : obj instanceof InterfaceC2132a ? ((InterfaceC2132a) obj).getPickerViewText() : obj.toString();
    }

    
    public void m6856a() {
        ScheduledFuture<?> scheduledFuture = this.f12114g;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f12114g.cancel(true);
        this.f12114g = null;
    }

    
    public final void m6857a(float f) {
        m6856a();
        this.f12114g = this.f12113f.scheduleWithFixedDelay(new C2135a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    
    public void m6858a(EnumC3241b enumC3241b) {
        m6856a();
        if (enumC3241b == EnumC3241b.FLING || enumC3241b == EnumC3241b.DAGGLE) {
            float f = this.f12133z;
            float f2 = this.f12123p;
            this.f12102H = (int) (((f % f2) + f2) % f2);
            int i = this.f12102H;
            this.f12102H = ((float) i) > f2 / 2.0f ? (int) (f2 - i) : -i;
        }
        this.f12114g = this.f12113f.scheduleWithFixedDelay(new C2137c(this, this.f12102H), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    
    public boolean m6859b() {
        return this.f12130w;
    }

    
    public final void m6860c() {
        float f = this.f12129v;
        float f2 = 1.0f;
        if (f >= 1.0f) {
            f2 = 4.0f;
            if (f <= 4.0f) {
                return;
            }
        }
        this.f12129v = f2;
    }

    
    public final void m6861d() {
        if (this.f12112e != null) {
            postDelayed(new RunnableC3240a(), 200L);
        }
    }

    
    public final void m6862e() {
        if (this.f12118k == null) {
            return;
        }
        Rect rect = new Rect();
        for (int i = 0; i < this.f12118k.mo4715a(); i++) {
            String m6855a = m6855a(this.f12118k.getItem(i));
            this.f12116i.getTextBounds(m6855a, 0, m6855a.length(), rect);
            int width = rect.width();
            if (width > this.f12121n) {
                this.f12121n = width;
            }
        }
        this.f12116i.getTextBounds("星期", 0, 2, rect);
        this.f12122o = rect.height();
        this.f12123p = this.f12129v * this.f12122o;
        int i2 = (int) (this.f12123p * (this.f12098D - 1));
        this.f12099E = (int) ((i2 * 2) / 3.141592653589793d);
        this.f12101G = (int) (i2 / 3.141592653589793d);
        this.f12100F = View.MeasureSpec.getSize(this.f12105K);
        int i3 = this.f12099E;
        float f = this.f12123p;
        this.f12131x = (i3 - f) / 2.0f;
        this.f12132y = ((i3 + f) / 2.0f) + 14.0f;
        if (this.f12095A == -1) {
            if (this.f12130w) {
                this.f12095A = (this.f12118k.mo4715a() + 1) / 2;
            } else {
                this.f12095A = 0;
            }
        }
        this.f12097C = this.f12095A;
    }

    public final InterfaceC2131a getAdapter() {
        return this.f12118k;
    }

    public final int getCurrentItem() {
        int i;
        InterfaceC2131a interfaceC2131a = this.f12118k;
        if (interfaceC2131a == null) {
            return 0;
        }
        return Math.max(0, Math.min((!this.f12130w || ((i = this.f12096B) >= 0 && i < interfaceC2131a.mo4715a())) ? this.f12096B : Math.abs(Math.abs(this.f12096B) - this.f12118k.mo4715a()), this.f12118k.mo4715a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f12110c;
    }

    public int getInitPosition() {
        return this.f12095A;
    }

    public float getItemHeight() {
        return this.f12123p;
    }

    public int getItemsCount() {
        InterfaceC2131a interfaceC2131a = this.f12118k;
        if (interfaceC2131a != null) {
            return interfaceC2131a.mo4715a();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.f12133z;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f12118k == null) {
            return;
        }
        this.f12095A = Math.min(Math.max(0, this.f12095A), this.f12118k.mo4715a() + 1);
        try {
            this.f12097C = this.f12095A + (((int) (this.f12133z / this.f12123p)) % this.f12118k.mo4715a());
        } catch (ArithmeticException unused) {
        }
        if (this.f12130w) {
            if (this.f12097C < 0) {
                this.f12097C = this.f12118k.mo4715a() + this.f12097C;
            }
            if (this.f12097C > this.f12118k.mo4715a() - 1) {
                this.f12097C = 0;
            }
        } else {
            if (this.f12097C < 0) {
                this.f12097C = 0;
            }
            if (this.f12097C > this.f12118k.mo4715a() - 1) {
                this.f12097C = this.f12118k.mo4715a() - 1;
            }
        }
        float f = this.f12133z % this.f12123p;
        float f2 = this.f12131x;
        canvas.drawLine(0.0f, f2, this.f12100F, f2, this.f12117j);
        float f3 = this.f12132y;
        canvas.drawLine(0.0f, f3, this.f12100F, f3, this.f12117j);
        int i = 0;
        while (true) {
            int i2 = this.f12098D;
            if (i >= i2) {
                return;
            }
            int i3 = this.f12097C - ((i2 / 2) - i);
            Object obj = "";
            if (this.f12130w) {
                obj = this.f12118k.getItem(m6854a(i3));
            } else if (i3 >= 0 && i3 <= this.f12118k.mo4715a() - 1) {
                obj = this.f12118k.getItem(i3);
            }
            canvas.save();
            double d2 = ((this.f12123p * i) - f) / this.f12101G;
            float f4 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f4 > 90.0f || f4 < -90.0f) {
                canvas.restore();
            } else {
                String m6855a = (TextUtils.isEmpty(this.f12119l) || TextUtils.isEmpty(m6855a(obj))) ? m6855a(obj) : m6855a(obj) + this.f12119l;
                Rect rect = new Rect();
                this.f12116i.getTextBounds(m6855a, 0, m6855a.length(), rect);
                int i4 = this.f12120m;
                for (int width = rect.width(); width > this.f12100F; width = rect.width()) {
                    i4--;
                    this.f12116i.setTextSize(i4);
                    this.f12116i.getTextBounds(m6855a, 0, m6855a.length(), rect);
                }
                this.f12115h.setTextSize(i4);
                Rect rect2 = new Rect();
                this.f12116i.getTextBounds(m6855a, 0, m6855a.length(), rect2);
                this.f12115h.getTextBounds(m6855a, 0, m6855a.length(), rect2);
                if (this.f12106L == 17) {
                    rect2.width();
                    this.f12107M = (int) ((this.f12100F - rect2.width()) * 0.5d);
                }
                float cos = (float) ((this.f12101G - (Math.cos(d2) * this.f12101G)) - ((Math.sin(d2) * this.f12122o) / 2.0d));
                canvas.translate(0.0f, cos);
                int i5 = this.f12122o;
                if ((i5 / 2.0f) + cos < this.f12131x || (i5 / 2.0f) + cos > this.f12132y) {
                    setOutPaintStyle(f4);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 0.9f);
                    canvas.drawText(m6855a, this.f12107M, this.f12122o, this.f12115h);
                } else {
                    canvas.drawText(m6855a, this.f12107M, i5, this.f12116i);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    this.f12096B = this.f12097C - ((this.f12098D / 2) - i);
                }
                canvas.restore();
                this.f12116i.setTextSize(this.f12120m);
            }
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.f12105K = i;
        m6862e();
        setMeasuredDimension(this.f12100F, this.f12099E);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
    
        if (r0 > 0.0f) goto L22;
     */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.address.wheel.view.WheelView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setAdapter(InterfaceC2131a interfaceC2131a) {
        this.f12118k = interfaceC2131a;
        m6862e();
        invalidate();
    }

    public void setAlphaGradient(boolean z) {
        this.f12108N = z;
    }

    public final void setCurrentItem(int i) {
        this.f12096B = i;
        this.f12095A = i;
        this.f12133z = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.f12130w = z;
    }

    public void setDividerColor(int i) {
        this.f12127t = i;
        this.f12117j.setColor(i);
    }

    public void setDividerType(EnumC3242c enumC3242c) {
    }

    public void setGravity(int i) {
        this.f12106L = i;
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0) {
            i++;
        }
        this.f12098D = i + 4;
    }

    public void setLabel(String str) {
        this.f12119l = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.f12129v = f;
            m6860c();
        }
    }

    public final void setOnItemSelectedListener(InterfaceC2134b interfaceC2134b) {
        this.f12112e = interfaceC2134b;
    }

    public void setTextColorCenter(int i) {
        this.f12126s = i;
        this.f12116i.setColor(this.f12126s);
    }

    public void setTextColorOut(int i) {
        this.f12125r = i;
        this.f12115h.setColor(this.f12125r);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.f12120m = (int) (this.f12109b.getResources().getDisplayMetrics().density * f);
            this.f12115h.setTextSize(this.f12120m);
            this.f12116i.setTextSize(this.f12120m);
        }
    }

    public void setTextXOffset(int i) {
        if (i != 0) {
            this.f12116i.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f) {
        this.f12133z = f;
    }

    public final void setTypeface(Typeface typeface) {
        this.f12124q = typeface;
        this.f12115h.setTypeface(this.f12124q);
        this.f12116i.setTypeface(this.f12124q);
    }
}
