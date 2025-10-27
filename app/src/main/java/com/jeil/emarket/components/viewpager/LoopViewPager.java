package com.jeil.emarket.components.viewpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

import java.util.List;
import androidx.viewpager.widget.PagerAdapter;

import com.jeil.emarket.widget.pa.PagerAdapterEx;


public class LoopViewPager extends ViewPager {

    /* renamed from: i0 */
    public PagerAdapterEx f12348i0;

    /* renamed from: j0 */
    public boolean f12349j0;

    /* renamed from: k0 */
    public List<OnPageChangeListener> f12350k0;

    /* renamed from: l0 */
    public Handler f12351l0;

    /* renamed from: m0 */
    public OnPageChangeListener f12352m0;

    /* renamed from: com.jeil.emarket.components.viewpager.LoopViewPager$a */
    public class HandlerC3262a extends Handler {
        public HandlerC3262a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LoopViewPager loopViewPager = LoopViewPager.this;
            if (!loopViewPager.f12349j0 || loopViewPager.f12348i0.getCount() <= 0) {
                return;
            }
            LoopViewPager loopViewPager2 = LoopViewPager.this;
            loopViewPager2.setCurrentItem(loopViewPager2.getCurrentItem() + 1);
        }
    }

    /* renamed from: com.jeil.emarket.components.viewpager.LoopViewPager$b */
    public class C3263b implements OnPageChangeListener {

        
        public float f12354a = -1.0f;


        public float f12355b = -1.0f;

        public C3263b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageSelected(int i) {
            LoopViewPager loopViewPager = LoopViewPager.this;
            if (loopViewPager.f12348i0 != null) {
                int currentItem = LoopViewPager.super.getCurrentItem();
                int m4678b = LoopViewPager.this.f12348i0.m4678b(currentItem);
                if (i == 0 && (currentItem == 0 || currentItem == LoopViewPager.this.f12348i0.getCount() - 1)) {
                    LoopViewPager.this.setCurrentItem(m4678b, false);
                }
            }
            if (LoopViewPager.this.f12350k0 != null) {
                for (int i2 = 0; i2 < LoopViewPager.this.f12350k0.size(); i2++) {
                    OnPageChangeListener onPageChangeListener = LoopViewPager.this.f12350k0.get(i2);
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageSelected(i);
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrolled(int i, float f, int i2) {
            PagerAdapterEx pagerAdapterEx;
            PagerAdapterEx pagerAdapterEx2 = LoopViewPager.this.f12348i0;
            if (pagerAdapterEx2 != null) {
                int m4678b = pagerAdapterEx2.m4678b(i);
                if (f == 0.0f && this.f12354a == 0.0f && (i == 0 || i == LoopViewPager.this.f12348i0.getCount() - 1)) {
                    LoopViewPager.this.setCurrentItem(m4678b, false);
                }
                i = m4678b;
            }
            this.f12354a = f;
            if (LoopViewPager.this.f12350k0 != null) {
                for (int i3 = 0; i3 < LoopViewPager.this.f12350k0.size(); i3++) {
                    OnPageChangeListener onPageChangeListener = LoopViewPager.this.f12350k0.get(i3);
                    if (onPageChangeListener != null && (pagerAdapterEx = LoopViewPager.this.f12348i0) != null && pagerAdapterEx.m4679e() > 0) {
                        if (i != (LoopViewPager.this.f12348i0.m4679e() + (LoopViewPager.this.f12348i0.m4679e() - 1)) % LoopViewPager.this.f12348i0.m4679e()) {
                            onPageChangeListener.onPageScrolled(i, f, i2);
                        } else if (f > 0.5d) {
                            onPageChangeListener.onPageScrolled(0, 0.0f, 0);
                        } else {
                            onPageChangeListener.onPageScrolled(i, 0.0f, 0);
                        }
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrollStateChanged(int i) {
            int m4678b = LoopViewPager.this.f12348i0.m4678b(i);
            float f = m4678b;
            if (this.f12355b != f) {
                this.f12355b = f;
                if (LoopViewPager.this.f12350k0 != null) {
                    for (int i2 = 0; i2 < LoopViewPager.this.f12350k0.size(); i2++) {
                        OnPageChangeListener onPageChangeListener = LoopViewPager.this.f12350k0.get(i2);
                        if (onPageChangeListener != null) {
                            onPageChangeListener.onPageScrollStateChanged(m4678b);
                        }
                    }
                }
            }
            LoopViewPager.this.m6988i();
        }
    }

    public LoopViewPager(Context context) {
        super(context);
        List<OnPageChangeListener> list;
        this.f12349j0 = false;
        this.f12351l0 = new HandlerC3262a(Looper.getMainLooper());
        this.f12352m0 = new C3263b();
        OnPageChangeListener onPageChangeListener = this.f12352m0;
//        if (onPageChangeListener != null && (list = this.f4124T) != null) {
//            list.remove(onPageChangeListener);
//        }
//        super.setOnPageChangeListener(this.f12352m0);
    }

    @Override // androidx.viewpager.widget.ViewPager
    
    public void setCurrentItem(int i, boolean z) {
        if (this.f12348i0.f8512d) {
            i++;
        }
        super.setCurrentItem(i, z);
    }

//    @Override // androidx.viewpager.widget.ViewPager
//    
//    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
//        if (this.f12350k0 == null) {
//            this.f12350k0 = new ArrayList();
//        }
//        this.f12350k0.add(onPageChangeListener);
//    }
//
//    @Override // androidx.viewpager.widget.ViewPager
//    
//    public boolean mo3128a(View view, boolean z, int i, int i2, int i3) {
//        int i4;
//        ImageView imageView;
//        Drawable drawable;
//        if (view instanceof ViewGroup) {
//            ViewGroup viewGroup = (ViewGroup) view;
//            int scrollX = view.getScrollX();
//            int scrollY = view.getScrollY();
//            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
//                View childAt = viewGroup.getChildAt(childCount);
//                if ((childAt instanceof ImageView) && (drawable = (imageView = (ImageView) childAt).getDrawable()) != null) {
//                    float width = imageView.getWidth();
//                    float height = imageView.getHeight();
//                    float intrinsicWidth = drawable.getIntrinsicWidth();
//                    float intrinsicHeight = drawable.getIntrinsicHeight();
//                    float[] fArr = new float[9];
//                    imageView.getImageMatrix().getValues(fArr);
//                    float f = fArr[2] + i;
//                    float f2 = fArr[0] * intrinsicWidth;
//                    if (fArr[0] / C2041a.m4631a(width, height, intrinsicWidth, intrinsicHeight) > 1.2f && !C2041a.m4632a(f, width, f2) && f2 > width) {
//                        return true;
//                    }
//                }
//                int i5 = i2 + scrollX;
//                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && mo3128a(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
//                    return true;
//                }
//            }
//        }
//        return z && view.canScrollHorizontally(-i);
//    }

//    @Override // androidx.viewpager.widget.ViewPager
//
//    public void mo3132b(OnPageChangeListener onPageChangeListener) {
//        List<OnPageChangeListener> list = this.f12350k0;
//        if (list != null) {
//            list.remove(onPageChangeListener);
//        }
//    }

    @Override // androidx.viewpager.widget.ViewPager
    public PagerAdapter getAdapter() {
        PagerAdapterEx pagerAdapterEx = this.f12348i0;
        if (pagerAdapterEx != null) {
            return pagerAdapterEx.f8511c;
        }
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        PagerAdapterEx pagerAdapterEx = this.f12348i0;
        if (pagerAdapterEx != null) {
            return pagerAdapterEx.m4678b(super.getCurrentItem());
        }
        return 0;
    }


    public void m6988i() {
        this.f12351l0.removeMessages(1001);
        this.f12351l0.sendEmptyMessageDelayed(1001, 5000L);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.f12348i0 = new PagerAdapterEx(pagerAdapter);
        PagerAdapterEx pagerAdapterEx = this.f12348i0;
        pagerAdapterEx.f8512d = true;
        super.setAdapter(pagerAdapterEx);
        setCurrentItem(0, false);
    }

    public void setAutoPlay(boolean z) {
        this.f12349j0 = z;
        m6988i();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    public LoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        List<OnPageChangeListener> list;
        this.f12349j0 = false;
        this.f12351l0 = new HandlerC3262a(Looper.getMainLooper());
        this.f12352m0 = new C3263b();
        OnPageChangeListener onPageChangeListener = this.f12352m0;
//        if (onPageChangeListener != null && (list = this.f4124T) != null) {
//            list.remove(onPageChangeListener);
//        }
//        super.setOnPageChangeListener(this.f12352m0);
    }
}
