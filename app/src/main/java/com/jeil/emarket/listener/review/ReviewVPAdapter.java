package com.jeil.emarket.listener.review;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.jeil.emarket.activities.review.ReviewActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.FragmentReviewRating;

/* renamed from: b.f.a.a.h.m */

public class ReviewVPAdapter implements ViewPager.OnPageChangeListener {


    public final ReviewActivity f6729a;

    public ReviewVPAdapter(ReviewActivity reviewActivity) {
        this.f6729a = reviewActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.h.b
            @Override // java.lang.Runnable
            public final void run() {
                ReviewVPAdapter.this.m4369c(i);
            }
        }, Status.time);
    }

    
    public  void m4369c(int i) {
        ((FragmentReviewRating) this.f6729a.fragmentPagerAdaperEx.f7130l.get(i)).m4888T0();
    }
}
