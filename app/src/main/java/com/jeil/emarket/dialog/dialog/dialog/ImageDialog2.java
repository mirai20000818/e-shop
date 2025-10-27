package com.jeil.emarket.dialog.dialog.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import java.util.Objects;

import com.jeil.emarket.custom.Util;

import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;

/* renamed from: b.f.a.c.c0.c.k */

public class ImageDialog2 extends ImageDialog1<ImageDialog2> {
    public ImageDialog2(Context context) {
        super(context);
    }

    /* renamed from: g */
    public static  void m4582g(View view) {
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        return this.f8239o;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2008f, p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
        super.mo4577c();
        this.f8239o.setBackground(Util.getGradDrawable(this.f8238S, m4590a(this.f8237R)));
        ((Window) Objects.requireNonNull(getWindow())).setDimAmount(0.8f);
        if (this.f8263n != null) {
            if (this.f8253d) {
                this.f8259j.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ImageDialog2.this.m4583f(view);
                    }
                });
            }
            this.f8263n.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImageDialog2.m4582g(view);
                }
            });
        }
    }

    /* renamed from: f */
    public  void m4583f(View view) {
        dismiss();
    }
}
