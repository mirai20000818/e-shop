package com.jeil.emarket.widget.img.ani;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.jeil.emarket.widget.img.ImageViewObj;

/* renamed from: b.f.a.c.h0.f.c */

public class ValueAnimatorListenEx1 extends ValueAnimatorListen {


    public final boolean f8369c;


    public float f8370d;


    public float f8371e;

    public ValueAnimatorListenEx1(ImageViewObj imageViewObj, float f, float f2) {
        super(imageViewObj);
        this.f8370d = f;
        this.f8371e = f2;
        this.f8369c = true;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ImageViewObj imageViewObj = this.f8367a;
        ImageView imageView = imageViewObj.f8336c;
        if (imageView.getDrawable() != null) {
            Matrix imageMatrix = imageView.getImageMatrix();
            float[] fArr = this.f8368b;
            imageMatrix.getValues(fArr);
            float mo4615a = imageViewObj.mo4615a(0, ((Float) valueAnimator.getAnimatedValue()).floatValue()) / fArr[0];
            if (this.f8369c) {
                imageMatrix.postScale(mo4615a, mo4615a, this.f8370d, this.f8371e);
            } else {
                imageMatrix.postScale(mo4615a, mo4615a);
            }
            imageViewObj.mo4619c();
            imageView.invalidate();
        }
    }
}
