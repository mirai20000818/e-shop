package com.jeil.emarket.listener.ticket.user;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.jeil.emarket.activities.ticket.list.TicketUserListActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.ticket.ticket.FragmentGetTicketList;

/* renamed from: b.f.a.a.j.c.d */

public class TicketUserViewPager implements ViewPager.OnPageChangeListener {


    public final TicketUserListActivity f7025a;

    public TicketUserViewPager(TicketUserListActivity ticketUserListActivity) {
        this.f7025a = ticketUserListActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.j.c.a
            @Override // java.lang.Runnable
            public final void run() {
                TicketUserViewPager.this.m4393c(i);
            }
        }, Status.time);
    }

    
    public  void m4393c(int i) {
        ((FragmentGetTicketList) this.f7025a.f11939J.f7130l.get(i)).m5127c1();
        ((FragmentGetTicketList) this.f7025a.f11939J.f7130l.get(i)).m4888T0();
    }
}
