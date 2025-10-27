package com.jeil.emarket.widget.img.ani;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.jeil.emarket.widget.img.ImageViewObj;

/* renamed from: b.f.a.c.h0.f.b */

public class ValueAnimatorListenEx extends ValueAnimatorListen {
    public ValueAnimatorListenEx(ImageViewObj imageViewObj) {
        super(imageViewObj);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ImageViewObj imageViewObj = this.f8367a;
        ImageView imageView = imageViewObj.f8336c;
        Matrix imageMatrix = imageView.getImageMatrix();
        float[] fArr = this.f8368b;
        imageMatrix.getValues(fArr);
        imageMatrix.postTranslate(imageViewObj.mo4615a(2, ((Float) valueAnimator.getAnimatedValue("translateX")).floatValue()) - fArr[2], imageViewObj.mo4615a(5, ((Float) valueAnimator.getAnimatedValue("translateY")).floatValue()) - fArr[5]);
        imageView.invalidate();
    }
}
