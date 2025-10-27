package com.jeil.emarket.dialog.dialog.dialog;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.dialog.dialog.dialog.base.DialogBaseAni;

/* renamed from: b.f.a.c.c0.c.j */

public class DialogC2001j extends DialogBaseAni<DialogC2001j> {
    public DialogC2001j(Context context) {
        super(context);
        this.f8258i = true;
        this.f8257h = true;
        setCanceledOnTouchOutside(false);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f8251b);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat.setBackgroundResource(R.drawable.bg_white_round);
        ImageView imageView = new ImageView(this.f8251b);
        imageView.setImageResource(R.drawable.ic_loading);
        int dimensionPixelSize = this.f8251b.getResources().getDimensionPixelSize(R.dimen._80sdp);
        int dimensionPixelSize2 = this.f8251b.getResources().getDimensionPixelSize(R.dimen._20sdp);
        int i = dimensionPixelSize - dimensionPixelSize2;
        imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(i, i));
        int i2 = dimensionPixelSize2 / 2;
        imageView.setPadding(i2, i2, i2, i2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(1300L);
        ofFloat.start();
        linearLayoutCompat.addView(imageView);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        linearLayoutCompat.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        return linearLayoutCompat;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
    }
}
