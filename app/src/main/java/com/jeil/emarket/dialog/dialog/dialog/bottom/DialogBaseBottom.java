package com.jeil.emarket.dialog.dialog.dialog.bottom;

import android.content.Context;
import android.view.View;
import com.jeil.emarket.components.dialog.widget.popup.BubblePopup;
import com.jeil.emarket.dialog.dialog.dialog.base.DialogBaseAni;

/* renamed from: b.f.a.c.c0.c.m.c */

public abstract class DialogBaseBottom<T extends DialogBaseBottom<T>> extends DialogBaseAni<T> {

    /* renamed from: o */
    public View f8279o;

    /* renamed from: p */
    public int f8280p;

    /* renamed from: q */
    public int f8281q;

    /* renamed from: r */
    public int f8282r;

    /* renamed from: s */
    public boolean f8283s;

    public DialogBaseBottom(Context context) {
        super(context);
        this.f8255f = 1.0f;
        m4593a(false);
    }


    public T m4596a(int i) {
        if (i != 48 && i != 80) {
            throw new IllegalArgumentException("Gravity must be either Gravity.TOP or Gravity.BOTTOM");
        }
        this.f8282r = i;
        ((BubblePopup) this).m6907c(this.f8279o);
        return this;
    }

    /* renamed from: f */
    public abstract void mo4597f();

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8283s) {
            mo4597f();
        }
    }
}
