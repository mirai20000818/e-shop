package com.jeil.emarket.frag.ticket.base;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.ticket.ticket.FragmentlTicketSearchEx;

import java.util.Objects;

/* renamed from: b.f.a.g.c.b.j */

public class FragmentTicketListVendor extends Fragment {

    /* renamed from: a0 */
    public ViewPager f9621a0;

    /* renamed from: b0 */
    public FragmentPagerAdaperEx f9622b0;

    /* renamed from: c0 */
    public BaseActivity f9623c0;

    /* renamed from: d0 */
    public View f9624d0;

    /* renamed from: b.f.a.g.c.b.j$a */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrollStateChanged(final int i) {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.c.b.f
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentTicketListVendor.a.this.m5140c(i);
                }
            }, Status.time);
        }


        public  void m5140c(int i) {
            ((FragmentlTicketSearchEx) FragmentTicketListVendor.this.f9622b0.f7130l.get(i)).m5127c1();
            ((FragmentlTicketSearchEx) FragmentTicketListVendor.this.f9622b0.f7130l.get(i)).m4888T0();
        }
    }

   // @Override // androidx.fragment.app.Fragment
    /* renamed from: B0 */
    public void mo1684B0() {
       // this.f3653G = true;
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.c.b.g
            @Override // java.lang.Runnable
            public final void run() {
                FragmentTicketListVendor.this.m5137S0();
            }
        }, Status.time);
    }

    /* renamed from: S0 */
    public  void m5137S0() {
        BottomNavigationView bottomNavigationView = this.f9623c0.bottomNavigationView;
        if (bottomNavigationView != null) {
            bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
        }
    }

    /* renamed from: T0 */
    public void m5138T0() {
        int getCount = ((PagerAdapter) Objects.requireNonNull(this.f9621a0.getAdapter())).getCount();
        for (int i = 0; i < getCount; i++) {
            try {
                if (((FragmentlTicketSearchEx) this.f9622b0.get(i)).m5131e1() != null) {
                    ((FragmentlTicketSearchEx) this.f9622b0.get(i)).m4893Y0();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9622b0 = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        this.f9624d0 = layoutInflater.inflate(R.layout.fragment_ticket_list_vendor, viewGroup, false);
        View view = this.f9624d0;
        if ((view instanceof CoordinatorLayout) && view.findViewById(R.id.cb_add_ticket) != null) {
        //    ((CoordinatorLayout.LayoutParams) this.f9624d0.findViewById(R.id.cb_add_ticket).getLayoutParams()).m2410a(new BottomViewBehavior());
        }
        return this.f9624d0;
    }


    public void m5139c(View view) {
        this.f9621a0 = (ViewPager) view.findViewById(R.id.vp_statuses);
        this.f9621a0.setAdapter(this.f9622b0);
        ((RecyclerTabLayout) view.findViewById(R.id.rtl_statuses)).setUpWithViewPager(this.f9621a0);
        this.f9621a0.setOnPageChangeListener(new a());
    }
}
