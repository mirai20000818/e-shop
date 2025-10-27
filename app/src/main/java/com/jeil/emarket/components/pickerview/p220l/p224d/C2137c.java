package com.jeil.emarket.components.pickerview.p220l.p224d;

import com.jeil.emarket.components.address.wheel.view.WheelView;
import java.util.TimerTask;

/* renamed from: b.f.a.c.w.l.d.c */

public final class C2137c extends TimerTask {


    public final WheelView f8751b;

    
    public int f8752c = Integer.MAX_VALUE;

    
    public int f8753d = 0;

    
    public int f8754e;

    public C2137c(WheelView wheelView, int i) {
        this.f8751b = wheelView;
        this.f8754e = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f8752c == Integer.MAX_VALUE) {
            this.f8752c = this.f8754e;
        }
        int i = this.f8752c;
        this.f8753d = (int) (i * 0.1f);
        if (this.f8753d == 0) {
            if (i < 0) {
                this.f8753d = -1;
            } else {
                this.f8753d = 1;
            }
        }
        if (Math.abs(this.f8752c) <= 1) {
            this.f8751b.m6856a();
            this.f8751b.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f8751b;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f8753d);
        if (!this.f8751b.m6859b()) {
            float itemHeight = this.f8751b.getItemHeight();
            float itemsCount = ((this.f8751b.getItemsCount() - 1) - this.f8751b.getInitPosition()) * itemHeight;
            if (this.f8751b.getTotalScrollY() <= (-this.f8751b.getInitPosition()) * itemHeight || this.f8751b.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f8751b;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f8753d);
                this.f8751b.m6856a();
                this.f8751b.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f8751b.getHandler().sendEmptyMessage(1000);
        this.f8752c -= this.f8753d;
    }
}
