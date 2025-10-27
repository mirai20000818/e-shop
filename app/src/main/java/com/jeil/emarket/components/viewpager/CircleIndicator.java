package com.jeil.emarket.components.viewpager;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;


public class CircleIndicator extends LinearLayout {


    public ViewPager f12333b;


    public int f12334c;

    
    public int f12335d;

    
    public int f12336e;

    /* renamed from: f */
    public int f12337f;

    /* renamed from: g */
    public int f12338g;

    /* renamed from: h */
    public int f12339h;

    
    public int f12340i;

   
    public Animator f12341j;

    
    public Animator f12342k;

    /* renamed from: l */
    public Animator f12343l;

    /* renamed from: m */
    public Animator f12344m;

    /* renamed from: n */
    public int f12345n;

    /* renamed from: o */
    public final ViewPager.OnPageChangeListener f12346o;

    /* renamed from: com.jeil.emarket.components.viewpager.CircleIndicator$a */
    public class C3260a implements ViewPager.OnPageChangeListener {
        public C3260a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrollStateChanged(int i) {
            View childAt;
            if (CircleIndicator.this.f12333b.getAdapter() == null || CircleIndicator.this.f12333b.getAdapter().getCount() <= 0) {
                return;
            }
            if (CircleIndicator.this.f12342k.isRunning()) {
                CircleIndicator.this.f12342k.end();
                CircleIndicator.this.f12342k.cancel();
            }
            if (CircleIndicator.this.f12341j.isRunning()) {
                CircleIndicator.this.f12341j.end();
                CircleIndicator.this.f12341j.cancel();
            }
            CircleIndicator circleIndicator = CircleIndicator.this;
            int i2 = circleIndicator.f12345n;
            if (i2 >= 0 && (childAt = circleIndicator.getChildAt(i2)) != null) {
                childAt.setBackgroundResource(CircleIndicator.this.f12340i);
                CircleIndicator.this.f12342k.setTarget(childAt);
                CircleIndicator.this.f12342k.start();
            }
            View childAt2 = CircleIndicator.this.getChildAt(i);
            if (childAt2 != null) {
                childAt2.setBackgroundResource(CircleIndicator.this.f12339h);
                CircleIndicator.this.f12341j.setTarget(childAt2);
                CircleIndicator.this.f12341j.start();
            }
            CircleIndicator.this.f12345n = i;
        }
    }

    /* renamed from: com.jeil.emarket.components.viewpager.CircleIndicator$b */
    public static class InterpolatorC3261b implements Interpolator {
        public  InterpolatorC3261b(C3260a c3260a) {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        this.f12334c = -1;
        this.f12335d = -1;
        this.f12336e = -1;
        this.f12337f = R.animator.scale_with_alpha;
        this.f12338g = 0;
        this.f12339h = R.drawable.bg_white_circle;
        this.f12340i = R.drawable.ic_indicator;
        this.f12345n = -1;
        this.f12346o = new C3260a();
        m6985a(context, (AttributeSet) null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12334c = -1;
        this.f12335d = -1;
        this.f12336e = -1;
        this.f12337f = R.animator.scale_with_alpha;
        this.f12338g = 0;
        this.f12339h = R.drawable.bg_white_circle;
        this.f12340i = R.drawable.ic_indicator;
        this.f12345n = -1;
        this.f12346o = new C3260a();
        m6985a(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12334c = -1;
        this.f12335d = -1;
        this.f12336e = -1;
        this.f12337f = R.animator.scale_with_alpha;
        this.f12338g = 0;
        this.f12339h = R.drawable.bg_white_circle;
        this.f12340i = R.drawable.ic_indicator;
        this.f12345n = -1;
        this.f12346o = new C3260a();
        m6985a(context, attributeSet);
    }


    public int m6982a(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }


    public final Animator m6983a(Context context) {
        int i = this.f12338g;
        if (i != 0) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.f12337f);
        loadAnimator.setInterpolator(new InterpolatorC3261b(null));
        return loadAnimator;
    }


    public final void m6984a(int i, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i);
        addView(view, this.f12335d, this.f12336e);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        int i2 = this.f12334c;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }


    public final void m6985a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleIndicator);
            this.f12335d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
            this.f12336e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
            this.f12334c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, 3);
            this.f12337f = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator, R.animator.scale_with_alpha);
            this.f12338g = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
            this.f12339h = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable, R.drawable.bg_white_circle);
            this.f12340i = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected, this.f12340i);
            setOrientation(obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_orientation, -1) == 1 ?
                    R.styleable.CircleIndicator_ci_animator_reverse : R.styleable.CircleIndicator_ci_animator);
            int i = obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
            if (i < 0) {
                i = 17;
            }
            setGravity(i);
            obtainStyledAttributes.recycle();
        }
        int i2 = this.f12335d;
        if (i2 < 0) {
            i2 = m6982a(5.0f);
        }
        this.f12335d = i2;
        int i3 = this.f12336e;
        if (i3 < 0) {
            i3 = m6982a(5.0f);
        }
        this.f12336e = i3;
        int i4 = this.f12334c;
        if (i4 < 0) {
            i4 = m6982a(5.0f);
        }
        this.f12334c = i4;
        int i5 = this.f12337f;
        if (i5 == 0) {
            i5 = R.animator.scale_with_alpha;
        }
        this.f12337f = i5;
        this.f12341j = m6986b(context);
        this.f12343l = m6986b(context);
        this.f12343l.setDuration(0L);
        this.f12342k = m6983a(context);
        this.f12344m = m6983a(context);
        this.f12344m.setDuration(0L);
        int i6 = this.f12339h;
        if (i6 == 0) {
            i6 = R.drawable.bg_white_circle;
        }
        this.f12339h = i6;
        int i7 = this.f12340i;
        if (i7 == 0) {
            i7 = this.f12339h;
        }
        this.f12340i = i7;
    }


    public final Animator m6986b(Context context) {
        return AnimatorInflater.loadAnimator(context, this.f12337f);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager viewPager = this.f12333b;
        if (viewPager == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        viewPager.setOnPageChangeListener(onPageChangeListener);
        this.f12333b.setOnPageChangeListener(onPageChangeListener);
    }

    public void setViewPager(ViewPager viewPager) {
        int i;
        Animator animator;
        this.f12333b = viewPager;
        ViewPager viewPager2 = this.f12333b;
        if (viewPager2 == null || viewPager2.getAdapter() == null) {
            return;
        }
        this.f12345n = -1;
        removeAllViews();
        int getCount = this.f12333b.getAdapter().getCount();
        if (getCount > 0) {
            int currentItem = this.f12333b.getCurrentItem();
            for (int i2 = 0; i2 < getCount; i2++) {
                if (currentItem == i2) {
                    i = this.f12339h;
                    animator = this.f12343l;
                } else {
                    i = this.f12340i;
                    animator = this.f12344m;
                }
                m6984a(i, animator);
            }
        }
        this.f12333b.setOnPageChangeListener(this.f12346o);
        this.f12333b.setOnPageChangeListener(this.f12346o);
        this.f12346o.onPageScrollStateChanged(this.f12333b.getCurrentItem());
    }
}
