package com.jeil.emarket.widget.anidraw;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: b.f.a.c.k0.h */

public class AnimationEx extends Animation {

    
    public final  DrawableEx.c f8482b;

    
    public final  DrawableEx f8483c;

    public AnimationEx(DrawableEx drawableEx, DrawableEx.c cVar) {
        this.f8483c = drawableEx;
        this.f8482b = cVar;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        DrawableEx drawableEx = this.f8483c;
        if (drawableEx.f8459d) {
            drawableEx.m4659a(f, this.f8482b);
            return;
        }
        float radians = 0;//(float) Math.toRadians(r8.f8476j / (this.f8482b.f8478l * 6.283185307179586d));
        DrawableEx.c cVar = this.f8482b;
        float f2 = cVar.f8473g;
        float f3 = cVar.f8471e;
        float f4 = cVar.f8475i;
        float interpolation = (DrawableEx.f8456m.getInterpolation(f) * (0.8f - radians)) + f2;
        DrawableEx.c cVar2 = this.f8482b;
        cVar2.f8472f = interpolation;
        cVar2.m4660a();
        float interpolation2 = (DrawableEx.f8455l.getInterpolation(f) * 0.8f) + f3;
        DrawableEx.c cVar3 = this.f8482b;
        cVar3.f8470d = interpolation2;
        cVar3.m4660a();
        DrawableEx.c cVar4 = this.f8482b;
        cVar4.f8474h = (f * 0.25f) + f4;
        cVar4.m4660a();
    }
}
