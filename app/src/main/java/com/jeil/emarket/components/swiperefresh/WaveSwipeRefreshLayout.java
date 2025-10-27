package com.jeil.emarket.components.swiperefresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import com.jeil.emarket.widget.anidraw.AppCompatImageViewEx;
import com.jeil.emarket.widget.anidraw.DrawableEx;
import com.jeil.emarket.widget.anidraw.AnimationEx1;
import com.jeil.emarket.widget.anidraw.ViewTreeObserverOnPreDrawListenerC2076k;


public class WaveSwipeRefreshLayout extends ViewGroup implements ViewTreeObserver.OnPreDrawListener {


    public final DecelerateInterpolator f12299b;


    public final Animation f12300c;


    public View f12301d;


    public InterfaceC3256c f12302e;

    /* renamed from: f */
    public EnumC3258e f12303f;

    /* renamed from: g */
    public C3257d f12304g;

    /* renamed from: h */
    public ViewTreeObserverOnPreDrawListenerC2076k f12305h;


    public boolean f12306i;

   
    public boolean f12307j;


    public float f12308k;

    /* renamed from: l */
    public boolean f12309l;

    /* renamed from: m */
    public int f12310m;

    /* renamed from: n */
    public Animation.AnimationListener f12311n;

    /* renamed from: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout$a */
    public class C3254a extends Animation {
        public C3254a(WaveSwipeRefreshLayout waveSwipeRefreshLayout) {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
        }
    }

    /* renamed from: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout$b */
    public class AnimationAnimationListenerC3255b implements Animation.AnimationListener {
        public AnimationAnimationListenerC3255b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            InterfaceC3256c interfaceC3256c;
            if (!WaveSwipeRefreshLayout.this.m6971e()) {
                WaveSwipeRefreshLayout.this.f12304g.f12313e.stop();
                WaveSwipeRefreshLayout.this.f12304g.setVisibility(View.GONE);
                WaveSwipeRefreshLayout.this.f12304g.m6973a();
                WaveSwipeRefreshLayout.this.f12305h.m4676f();
                return;
            }
            WaveSwipeRefreshLayout.this.f12304g.m6973a();
            WaveSwipeRefreshLayout.this.f12304g.f12313e.start();
            WaveSwipeRefreshLayout waveSwipeRefreshLayout = WaveSwipeRefreshLayout.this;
            if (!waveSwipeRefreshLayout.f12306i || (interfaceC3256c = waveSwipeRefreshLayout.f12302e) == null) {
                return;
            }
            interfaceC3256c.mo4970a();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout$c */
    public interface InterfaceC3256c {

        void mo4970a();
    }

    /* renamed from: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout$e */
    public enum EnumC3258e {
        REFRESHING,
        PENDING
    }

    /* renamed from: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout$f */
    public enum EnumC3259f {
        FIRST(0.1f),
        SECOND(FIRST.f12321b + 0.16f),
        THIRD(FIRST.f12321b + 0.5f);



        public final float f12321b;

        EnumC3259f(float f) {
            this.f12321b = f;
        }
    }

    public WaveSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public WaveSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveSwipeRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12300c = new C3254a(this);
        this.f12303f = EnumC3258e.PENDING;
        this.f12307j = false;
        this.f12310m = -1;
        this.f12311n = new AnimationAnimationListenerC3255b();
        getViewTreeObserver().addOnPreDrawListener(this);
        setWillNotDraw(false);
        this.f12299b = new DecelerateInterpolator(2.0f);
        setChildrenDrawingOrderEnabled(true);
        C3257d c3257d = new C3257d(this, getContext());
        this.f12304g = c3257d;
        addView(c3257d);
        this.f12305h = new ViewTreeObserverOnPreDrawListenerC2076k(getContext());
        addView(this.f12305h, 0);
    }


    public static int m6964b(int i) {
        return View.MeasureSpec.makeMeasureSpec(i, MeasureSpec.EXACTLY);
    }

    private void setState(EnumC3258e enumC3258e) {
        this.f12303f = enumC3258e;
        setEnabled(true);
    }

    private void setState(boolean z) {
        setState(z ? EnumC3258e.REFRESHING : EnumC3258e.PENDING);
    }


    public final void m6965a() {
        this.f12300c.reset();
        this.f12300c.setDuration(200L);
        this.f12300c.setInterpolator(this.f12299b);
        C3257d c3257d = this.f12304g;
        c3257d.f8453d = this.f12311n;
        c3257d.clearAnimation();
        this.f12304g.startAnimation(this.f12300c);
    }


    public  void m6966a(ValueAnimator valueAnimator) {
        this.f12304g.setTranslationY((this.f12304g.getHeight() / 2.0f) + this.f12305h.getCurrentCircleCenterY());
    }


    public boolean m6968b() {
        View view = this.f12301d;
        if (view == null) {
            return false;
        }
        return view.canScrollVertically(-1);
    }


    public final void m6969c() {
        if (this.f12301d == null) {
            int i = 0;
            while (true) {
                if (i >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f12304g) && !childAt.equals(this.f12305h)) {
                    this.f12301d = childAt;
                    break;
                }
                i++;
            }
        }
        if (this.f12301d == null) {
            throw new IllegalStateException("This view must have at least one AbsListView");
        }
    }


    public void m6970d() {
        float f = -this.f12308k;
        this.f12305h.m4669b(((5.0f - ((2.0f * f) / Math.min(getMeasuredWidth(), getMeasuredHeight()))) * f) / 1000.0f);
        if (!m6971e()) {
            this.f12304g.m6974a(0.0f, 0.0f);
            this.f12304g.setVisibility(View.GONE);
        }
        this.f12310m = -1;
    }


    public boolean m6971e() {
        return this.f12303f == EnumC3258e.REFRESHING;
    }

    /* renamed from: f */
    public final void m6972f() {
        if (this.f12304g.getVisibility() != View.VISIBLE) {
            this.f12304g.setVisibility(View.VISIBLE);
        }
        C3257d c3257d = this.f12304g;
        c3257d.setScaleX(1.0f);
        c3257d.setScaleY(1.0f);
        this.f12304g.m6973a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r0 != 3) goto L43;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            r6.m6969c()
            boolean r0 = r6.isEnabled()
            r1 = 0
            if (r0 == 0) goto L82
            boolean r0 = r6.m6968b()
            if (r0 != 0) goto L82
            boolean r0 = r6.m6971e()
            if (r0 == 0) goto L18
            goto L82
        L18:
            int r0 = r7.getActionMasked()
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 == 0) goto L6d
            r3 = -1
            r4 = 1
            if (r0 == r4) goto L6a
            r5 = 2
            if (r0 == r5) goto L2b
            r7 = 3
            if (r0 == r7) goto L6a
            goto L82
        L2b:
            int r0 = r6.f12310m
            if (r0 != r3) goto L30
            return r1
        L30:
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L39
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L3d
        L39:
            float r7 = r7.getY(r0)
        L3d:
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 != 0) goto L42
            return r1
        L42:
            float r0 = r6.f12308k
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L4a
            r6.f12308k = r7
        L4a:
            float r0 = r6.f12308k
            float r7 = r7 - r0
            android.content.Context r0 = r6.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 <= 0) goto L82
            boolean r7 = r6.m6971e()
            if (r7 != 0) goto L82
            com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout$d r7 = r6.f12304g
            r7.m6973a()
            return r4
        L6a:
            r6.f12310m = r3
            goto L82
        L6d:
            int r0 = r7.getPointerId(r1)
            r6.f12310m = r0
            int r0 = r6.f12310m
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L7c
            goto L80
        L7c:
            float r2 = r7.getY(r0)
        L80:
            r6.f12308k = r2
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 0) {
            return;
        }
        m6969c();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f12301d.layout(getPaddingLeft(), getPaddingTop(), measuredWidth - getPaddingRight(), measuredHeight - getPaddingBottom());
        if (this.f12305h == null) {
            return;
        }
        int measuredWidth2 = getMeasuredWidth();
        int measuredHeight2 = getMeasuredHeight();
        int measuredWidth3 = this.f12304g.getMeasuredWidth();
        this.f12304g.layout((measuredWidth2 - measuredWidth3) / 2, -this.f12304g.getMeasuredHeight(), (measuredWidth3 + measuredWidth2) / 2, 0);
        this.f12305h.layout(getPaddingLeft(), getPaddingTop(), measuredWidth2 - getPaddingRight(), measuredHeight2 - getPaddingBottom());
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m6969c();
        this.f12301d.measure(m6964b(getMeasuredWidth() - (getPaddingRight() + getPaddingLeft())), m6964b(getMeasuredHeight() - (getPaddingBottom() + getPaddingTop())));
        this.f12305h.measure(i, i2);
        C3257d c3257d = this.f12304g;
        int i3 = (int) c3257d.f12313e.f8464i;
        c3257d.measure(m6964b(i3), m6964b(i3));
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.f12305h.bringToFront();
        this.f12304g.bringToFront();
        if (this.f12307j) {
            this.f12307j = false;
            this.f12305h.m4672c();
            m6972f();
            this.f12304g.setBackgroundColor(0);
            this.f12304g.setTranslationY((this.f12304g.getHeight() / 2.0f) + this.f12305h.getCurrentCircleCenterY());
            m6965a();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r0 != 3) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0144 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void setOnRefreshListener(InterfaceC3256c interfaceC3256c) {
        this.f12302e = interfaceC3256c;
    }

    public void setRefreshing(boolean z) {
        if (!z || m6971e()) {
            m6967a(z, false);
            return;
        }
        setState(true);
        this.f12306i = false;
        this.f12307j = true;
        if (this.f12305h.getCurrentCircleCenterY() == 0.0f) {
            return;
        }
        this.f12305h.m4672c();
        m6972f();
        this.f12304g.setTranslationY((this.f12304g.getHeight() / 2.0f) + this.f12305h.getCurrentCircleCenterY());
        m6965a();
    }

    /* renamed from: com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout$d */
    public class C3257d extends AppCompatImageViewEx {


        public final DrawableEx f12313e;

        public C3257d(WaveSwipeRefreshLayout waveSwipeRefreshLayout, Context context) {
            super(context);
            this.f12313e = new DrawableEx(context, waveSwipeRefreshLayout);
            setImageDrawable(null);
            DrawableEx drawableEx = this.f12313e;
            drawableEx.f8458c.f8481o = 0;
            setImageDrawable(drawableEx);
            setVisibility(View.GONE);
        }


        public void m6973a() {
            this.f12313e.f8458c.f8480n = 255;
        }


        public void m6974a(float f, float f2) {
            DrawableEx drawableEx = this.f12313e;
            DrawableEx.c cVar = drawableEx.f8458c;
            cVar.f8470d = f;
            cVar.m4660a();
            DrawableEx.c cVar2 = drawableEx.f8458c;
            cVar2.f8472f = f2;
            cVar2.m4660a();
        }
    }


    public void m6967a(boolean z, boolean z2) {
        if (m6971e() != z) {
            this.f12306i = z2;
            m6969c();
            setState(z);
            if (m6971e()) {
                m6965a();
                return;
            }
            Animation.AnimationListener animationListener = this.f12311n;
            AnimationEx1 animationEx1 = new AnimationEx1(this);
            animationEx1.setDuration(200L);
            this.f12304g.m4658a(animationListener);
            this.f12304g.clearAnimation();
            this.f12304g.startAnimation(animationEx1);
        }
    }
}
