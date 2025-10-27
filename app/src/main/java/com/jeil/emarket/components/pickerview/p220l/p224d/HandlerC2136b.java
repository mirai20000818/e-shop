package com.jeil.emarket.components.pickerview.p220l.p224d;

import android.os.Handler;
import android.os.Message;
import com.jeil.emarket.components.address.wheel.view.WheelView;

/* renamed from: b.f.a.c.w.l.d.b */

public final class HandlerC2136b extends Handler {


    public final WheelView f8750a;

    public HandlerC2136b(WheelView wheelView) {
        this.f8750a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f8750a.invalidate();
        } else if (i == 2000) {
            this.f8750a.m6858a(WheelView.EnumC3241b.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.f8750a.m6861d();
        }
    }
}
