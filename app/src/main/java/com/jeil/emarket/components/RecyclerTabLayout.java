package com.jeil.emarket.components;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.Util;

import java.util.Objects;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.PagerAdapter;

import com.jeil.emarket.custom.font.FontManager;


public class RecyclerTabLayout extends RecyclerView {

    /* renamed from: H0 */
    public Paint paint;

    /* renamed from: I0 */
    public int f12056I0;

    /* renamed from: J0 */
    public int f12057J0;

    /* renamed from: K0 */
    public int f12058K0;

    /* renamed from: L0 */
    public int f12059L0;

    /* renamed from: M0 */
    public int f12060M0;

    /* renamed from: N0 */
    public int f12061N0;

    /* renamed from: O0 */
    public int f12062O0;

    /* renamed from: P0 */
    public int f12063P0;

    /* renamed from: Q0 */
    public boolean f12064Q0;

    /* renamed from: R0 */
    public LinearLayoutManager linearLayoutManager;

    /* renamed from: S0 */
    public ViewPager viewPager;

    /* renamed from: T0 */
    public RTL_ViewHolder<?> f12067T0;

    /* renamed from: U0 */
    public int f12068U0;

    /* renamed from: V0 */
    public int f12069V0;

    /* renamed from: W0 */
    public int f12070W0;

    /* renamed from: X0 */
    public float f12071X0;

    /* renamed from: Y0 */
    public float f12072Y0;

    /* renamed from: Z0 */
    public boolean f12073Z0;

    /* renamed from: a1 */
    public boolean f12074a1;

    /* renamed from: b1 */
    public int f12075b1;

    /* renamed from: c1 */
    public int f12076c1;

    /* renamed from: d1 */
    public C3237c f12077d1;

    /* renamed from: com.jeil.emarket.components.RecyclerTabLayout$a */
    public class C3235a extends LinearLayoutManager {
        public C3235a(Context context) {
            super(context, RecyclerView.VERTICAL, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        
        public boolean canScrollHorizontally() {
            return RecyclerTabLayout.this.f12074a1;
        }
    }

    /* renamed from: com.jeil.emarket.components.RecyclerTabLayout$b */
    public static abstract class RTL_ViewHolder<T extends ViewHolder> extends Adapter<T> {

        
        public ViewPager f12079d;

        
        public int f12080e;

        public RTL_ViewHolder(ViewPager viewPager) {
            this.f12079d = viewPager;
        }
    }

    /* renamed from: com.jeil.emarket.components.RecyclerTabLayout$d */
    public static class MyTextView extends AppCompatTextView {

        /* renamed from: g */
        public float f12092g;

        public MyTextView(Context context) {
            super(context);
            m6853d();
        }

        
        public ColorStateList m6852a(int i, int i2) {
            return new ColorStateList(new int[][]{TextView.SELECTED_STATE_SET, TextView.EMPTY_STATE_SET}, new int[]{i2, i});
        }

        
        public void m6853d() {
            this.f12092g = Util.getFontSize();
            setTextSize(0, getTextSize());
            setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
        }

        @Override // android.widget.TextView
        public void setTextSize(float f) {
            super.setTextSize(f * this.f12092g);
        }

        @Override // p000a.p005b.p013e.C0086a0, android.widget.TextView
        public void setTextSize(int i, float f) {
            super.setTextSize(i, f * this.f12092g);
        }
    }

    /* renamed from: com.jeil.emarket.components.RecyclerTabLayout$e */
    public static class VP_Listener implements ViewPager.OnPageChangeListener {

        
        public final RecyclerTabLayout recyclerTabLayout;

        
        public int f12094b;

        public VP_Listener(RecyclerTabLayout recyclerTabLayout) {
            this.recyclerTabLayout = recyclerTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageSelected(int i) {
            this.f12094b = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrolled(int i, float f, int i2) {
            this.recyclerTabLayout.m6845a(i, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrollStateChanged(int i) {
            if (this.f12094b == 0) {
                RecyclerTabLayout recyclerTabLayout = this.recyclerTabLayout;
                if (recyclerTabLayout.f12068U0 != i) {
                    recyclerTabLayout.m6848l(i);
                }
            }
        }
    }

    public RecyclerTabLayout(Context context) {
        this(context, null);
    }

    public RecyclerTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerTabLayout, i, R.style.rtl_RecyclerTabLayout);
        setIndicatorColor(obtainStyledAttributes.getColor(R.styleable.RecyclerTabLayout_rtl_tabIndicatorColor, 0));
        setIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabIndicatorHeight, 0));
        setIndicatorType(obtainStyledAttributes.getBoolean(R.styleable.RecyclerTabLayout_rtl_tabIndicatorType, false));
        this.f12057J0 = obtainStyledAttributes.getResourceId(R.styleable.RecyclerTabLayout_rtl_tabTextAppearance, R.style.rtl_RecyclerTabLayout_Tab);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPadding, 0);
        this.f12062O0 = dimensionPixelSize;
        this.f12061N0 = dimensionPixelSize;
        this.f12060M0 = dimensionPixelSize;
        this.f12059L0 = dimensionPixelSize;
        this.f12059L0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingStart, this.f12059L0);
        this.f12060M0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingTop, this.f12060M0);
        this.f12061N0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingEnd, this.f12061N0);
        this.f12062O0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingBottom, this.f12062O0);
        if (obtainStyledAttributes.hasValue(R.styleable.RecyclerTabLayout_rtl_tabSelectedTextColor)) {
            this.f12058K0 = obtainStyledAttributes.getColor(R.styleable.RecyclerTabLayout_rtl_tabSelectedTextColor, 0);
        }
        this.f12056I0 = obtainStyledAttributes.getInteger(R.styleable.RecyclerTabLayout_rtl_tabOnScreenLimit, 0);
        this.f12074a1 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerTabLayout_rtl_scrollEnabled, true);
        obtainStyledAttributes.recycle();
        this.linearLayoutManager = new C3235a(getContext());
        //this.linearLayoutManager.m2705m(0);
        setLayoutManager(this.linearLayoutManager);
        setItemAnimator(null);
        this.f12072Y0 = 0.6f;
    }

    
    public void m6844a(int i, float f, float f2) {
        if (this.f12067T0 == null) {
            return;
        }
        if (f > 0.0f && f2 >= this.f12072Y0 - 0.001f) {
            i++;
        } else if (f >= 0.0f || f2 > (1.0f - this.f12072Y0) + 0.001f) {
            i = -1;
        }
        if (i >= 0) {
            RTL_ViewHolder<?> RTLViewHolder = this.f12067T0;
            if (i != RTLViewHolder.f12080e) {
                RTLViewHolder.f12080e = i;
                RTLViewHolder.notifyDataSetChanged();
            }
        }
    }

    
    public void m6845a(int i, float f, boolean z) {
        int i2;
        int i3;
        View findViewByPosition = this.linearLayoutManager.findViewByPosition(i);
        View findViewByPosition2 = this.linearLayoutManager.findViewByPosition(i + 1);
        if (findViewByPosition != null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = i == 0 ? 0.0f : (measuredWidth / 2.0f) - (findViewByPosition.getMeasuredWidth() / 2.0f);
            float measuredWidth3 = findViewByPosition.getMeasuredWidth() + measuredWidth2;
            if (findViewByPosition2 != null) {
                float measuredWidth4 = (measuredWidth3 - ((measuredWidth / 2.0f) - (findViewByPosition2.getMeasuredWidth() / 2.0f))) * f;
                int i4 = (int) (measuredWidth2 - measuredWidth4);
                int measuredWidth5 = findViewByPosition2.getMeasuredWidth();
                if (i == 0) {
                    float measuredWidth6 = (measuredWidth5 - findViewByPosition.getMeasuredWidth()) / 2.0f;
                    this.f12069V0 = (int) (measuredWidth6 * f);
                    i3 = (int) ((findViewByPosition.getMeasuredWidth() + measuredWidth6) * f);
                } else {
                    this.f12069V0 = (int) (((measuredWidth5 - findViewByPosition.getMeasuredWidth()) / 2.0f) * f);
                    i3 = (int) measuredWidth4;
                }
                this.f12070W0 = i3;
                i2 = i4;
            } else {
                i2 = (int) measuredWidth2;
                this.f12070W0 = 0;
                this.f12069V0 = 0;
            }
            if (z) {
                this.f12070W0 = 0;
                this.f12069V0 = 0;
            }
        } else {
            this.f12073Z0 = true;
            i2 = 0;
        }
        m6844a(i, f - this.f12071X0, f);
        this.f12068U0 = i;
       // m2730G();
        if (i != this.f12075b1 || i2 != this.f12076c1) {
            this.linearLayoutManager.scrollToPositionWithOffset(i, i2);
        }
        if (this.f12063P0 > 0) {
            invalidate();
        }
        this.f12075b1 = i;
        this.f12076c1 = i2;
        this.f12071X0 = f;
    }

    
    public  void m6846a(int i, ValueAnimator valueAnimator) {
        m6845a(i, ((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    
    public void m6847b(int i, boolean z) {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i, z);
            m6848l(this.viewPager.getCurrentItem());
        } else if (!z || i == this.f12068U0) {
            m6848l(i);
        } else {
            m6849m(i);
        }
    }

    /* renamed from: l */
    public void m6848l(int i) {
        m6845a(i, 0.0f, false);
        RTL_ViewHolder<?> RTLViewHolder = this.f12067T0;
        RTLViewHolder.f12080e = i;
        RTLViewHolder.notifyDataSetChanged();
    }

    /* renamed from: m */
    public void m6849m(final int i) {
        View findViewByPosition = this.linearLayoutManager.findViewByPosition(i);
        float abs = findViewByPosition != null ? Math.abs((getMeasuredWidth() / 2.0f) - ((findViewByPosition.getMeasuredWidth() / 2.0f) + findViewByPosition.getX())) / findViewByPosition.getMeasuredWidth() : 1.0f;
        ValueAnimator ofFloat = i < this.f12068U0 ? ValueAnimator.ofFloat(abs, 0.0f) : ValueAnimator.ofFloat(-abs, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.f.a.c.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RecyclerTabLayout.this.m6846a(i, valueAnimator);
            }
        });
        ofFloat.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        View findViewByPosition = this.linearLayoutManager.findViewByPosition(this.f12068U0);
        if (findViewByPosition == null) {
            if (this.f12073Z0) {
                this.f12073Z0 = false;
                m6848l(this.viewPager.getCurrentItem());
                return;
            }
            return;
        }
        this.f12073Z0 = false;
        int left = (findViewByPosition.getLeft() + this.f12070W0) - this.f12069V0;
        int right = findViewByPosition.getRight() + this.f12070W0 + this.f12069V0;
        int height = getHeight() - this.f12063P0;
        int height2 = getHeight();
        int i = this.f12064Q0 ? 0 : height;
        this.paint.setAntiAlias(true);
        if (this.f12064Q0) {
            canvas.drawRoundRect(left, i, right, height2, getHeight() / 2, getHeight() / 2, this.paint);
        } else {
            canvas.drawRect(left, i, right, height2, this.paint);
        }
    }

    public void setIndicatorColor(int i) {
        this.paint.setColor(i);
    }

    public void setIndicatorHeight(int i) {
        this.f12063P0 = i;
    }

    public void setIndicatorType(boolean z) {
        this.f12064Q0 = z;
    }

    public void setUpWithAdapter(RTL_ViewHolder<?> RTLViewHolder) {
        this.f12067T0 = RTLViewHolder;
        this.viewPager = RTLViewHolder.f12079d;
        if (this.viewPager.getAdapter() == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
//        this.viewPager.setOnPageChangeListener(new VP_Listener(this));
        setAdapter(RTLViewHolder);
        m6848l(this.viewPager.getCurrentItem());
    }

    public void setUpWithViewPager(ViewPager viewPager) {
        this.f12077d1 = new C3237c(viewPager);
        C3237c c3237c = this.f12077d1;
        int i = this.f12059L0;
        int i2 = this.f12060M0;
        int i3 = this.f12061N0;
        int i4 = this.f12062O0;
        c3237c.f12081f = i;
        c3237c.f12082g = i2;
        c3237c.f12083h = i3;
        c3237c.f12084i = i4;
        c3237c.f12085j = this.f12057J0;
        c3237c.f12086k = this.f12058K0;
        c3237c.f12088m = this.f12056I0;
        setUpWithAdapter(c3237c);
    }

    /* renamed from: com.jeil.emarket.components.RecyclerTabLayout$c */
    public static class C3237c extends RTL_ViewHolder<ViewHolder> {

        /* renamed from: f */
        public int f12081f;

        /* renamed from: g */
        public int f12082g;

        /* renamed from: h */
        public int f12083h;

        
        public int f12084i;

       
        public int f12085j;

        
        public int f12086k;

        /* renamed from: l */
        public int f12087l;

        /* renamed from: m */
        public int f12088m;

        /* renamed from: com.jeil.emarket.components.RecyclerTabLayout$c$a */
        public class view_holder extends ViewHolder {

            /* renamed from: t */
            public TextView f12089t;

            /* renamed from: u */
            public TextView f12090u;

            @SuppressLint({"ResourceType"})
            public view_holder(View view) {
                super(view);
                this.f12089t = (TextView) view.findViewById(R.string.heading);
                this.f12090u = (TextView) view.findViewById(R.string.count);
                view.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        view_holder.this.m6851a(view2);
                    }
                });
            }

            
            public  void m6851a(View view) {
//                int m2836c = m2836c();
//                if (m2836c != -1) {
//                    C3237c.this.f12079d.setCurrentItem(m2836c, true);
//                }
            }
        }

        public C3237c(ViewPager viewPager) {
            super(viewPager);
            this.f12087l = -6710887;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        
        public int getItemCount() {
            return ((PagerAdapter) Objects.requireNonNull(this.f12079d.getAdapter())).getCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        @SuppressLint({"SetTextI18n"})
        
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            view_holder viewholderVar = (view_holder) viewHolder;
//            viewholderVar.f12089t.setText(((PagerAdapter) Objects.requireNonNull(this.f12079d.getAdapter())).mo2187a(i));
//            viewholderVar.f12089t.setSelected(this.f12080e == i);
//            int intValue = ((FragmentMyManager) this.f12079d.getAdapter()).f7129k.get(i).intValue();
//            if (intValue > -1) {
//                viewholderVar.f12090u.setVisibility(View.VISIBLE);
//                viewholderVar.f12090u.setText("(" + intValue + ")");
//                viewholderVar.f12090u.setSelected(this.f12080e == i);
//            } else {
//                viewholderVar.f12090u.setVisibility(View.GONE);
//            }
            LinearLayoutCompat.LayoutParams m6850c = m6850c();
            viewholderVar.f12089t.setLayoutParams(m6850c);
            viewholderVar.f12090u.setLayoutParams(m6850c);
        }

        
        public LinearLayoutCompat.LayoutParams m6850c() {
            return new LinearLayoutCompat.LayoutParams(-2, -1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        @SuppressLint({"ResourceType"})
        
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            MyTextView myTextView = new MyTextView(viewGroup.getContext());
            MyTextView myTextView2 = new MyTextView(viewGroup.getContext());
            LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(viewGroup.getContext());
            myTextView.setId(R.string.heading);
            myTextView2.setId(R.string.count);
            linearLayoutCompat.setPadding(this.f12081f, this.f12082g, this.f12083h, this.f12084i);
            myTextView.setTextAppearance(viewGroup.getContext(), this.f12085j);
            myTextView.setGravity(17);
            myTextView.setMaxLines(2);
            myTextView.setEllipsize(TextUtils.TruncateAt.END);
            myTextView2.setTextAppearance(viewGroup.getContext(), this.f12085j);
            myTextView2.setGravity(17);
            myTextView2.setMaxLines(2);
            myTextView2.setEllipsize(TextUtils.TruncateAt.END);
            myTextView2.setPadding(10, 0, 0, 0);
            linearLayoutCompat.setGravity(17);
            if (this.f12088m > 0) {
                linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(viewGroup.getMeasuredWidth() / this.f12088m, -1));
            }
            myTextView.setTextAppearance(myTextView.getContext(), this.f12085j);
            myTextView.m6853d();
            myTextView2.setTextColor(this.f12087l);
            myTextView2.m6853d();
            if (this.f12086k != 0) {
                myTextView.setTextColor(myTextView.m6852a(myTextView.getCurrentTextColor(), this.f12086k));
                myTextView2.setTextColor(myTextView2.m6852a(myTextView2.getCurrentTextColor(), this.f12086k));
            }
            myTextView.setLayoutParams(m6850c());
            myTextView2.setLayoutParams(m6850c());
            linearLayoutCompat.addView(myTextView);
            linearLayoutCompat.addView(myTextView2);
            return new view_holder(linearLayoutCompat);
        }
    }
}
