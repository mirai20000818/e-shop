package com.jeil.emarket.adapters.newsletter;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.jeil.emarket.custom.Util;

/* renamed from: b.f.a.b.f.h */

public class NewsletterAdapterAni extends Animation {

    
    public final  NewsletterAdapter.a f7235b;

    
    public final  NewsletterAdapter f7236c;

    public NewsletterAdapterAni(NewsletterAdapter c1800i, NewsletterAdapter.a aVar) {
        this.f7236c = c1800i;
        this.f7235b = aVar;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        this.f7236c.baseActivity.recyclerView.scrollBy(0, (int) ((Util.dp2px((Context) this.f7236c.baseActivity, 90) + (this.f7235b.f7240t.getTop() - (this.f7236c.baseActivity.recyclerView.getHeight() / 2))) * f));
        this.f7236c.baseActivity.recyclerView.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
