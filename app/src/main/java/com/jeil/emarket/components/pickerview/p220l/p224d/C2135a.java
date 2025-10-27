package com.jeil.emarket.components.pickerview.p220l.p224d;

import android.os.Handler;
import com.jeil.emarket.components.address.wheel.view.WheelView;
import java.util.TimerTask;

/* renamed from: b.f.a.c.w.l.d.a */

public final class C2135a extends TimerTask {


    public final float f8747b;

    
    public final WheelView f8748c;

    
    public float f8749d = 2.1474836E9f;

    public C2135a(WheelView wheelView, float f) {
        this.f8748c = wheelView;
        this.f8747b = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        int i;
        if (this.f8749d == 2.1474836E9f) {
            if (Math.abs(this.f8747b) > 2000.0f) {
                this.f8749d = this.f8747b <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f8749d = this.f8747b;
            }
        }
        if (Math.abs(this.f8749d) < 0.0f || Math.abs(this.f8749d) > 20.0f) {
            int i2 = (int) (this.f8749d / 100.0f);
            WheelView wheelView = this.f8748c;
            float f = i2;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f);
            if (!this.f8748c.m6859b()) {
                float itemHeight = this.f8748c.getItemHeight();
                float f2 = (-this.f8748c.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f8748c.getItemsCount() - 1) - this.f8748c.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f8748c.getTotalScrollY() - d2 < f2) {
                    f2 = this.f8748c.getTotalScrollY() + f;
                } else if (this.f8748c.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f8748c.getTotalScrollY() + f;
                }
                if (this.f8748c.getTotalScrollY() <= f2) {
                    this.f8749d = 40.0f;
                    this.f8748c.setTotalScrollY((int) f2);
                } else if (this.f8748c.getTotalScrollY() >= itemsCount) {
                    this.f8748c.setTotalScrollY((int) itemsCount);
                    this.f8749d = -40.0f;
                }
            }
            float f3 = this.f8749d;
            this.f8749d = f3 < 0.0f ? f3 + 20.0f : f3 - 20.0f;
            handler = this.f8748c.getHandler();
            i = 1000;
        } else {
            this.f8748c.m6856a();
            handler = this.f8748c.getHandler();
            i = 2000;
        }
        handler.sendEmptyMessage(i);
    }
}
