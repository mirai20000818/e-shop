package custom.google.android.material.p146o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import custom.google.android.material.p151t.C1172b;
import custom.google.android.material.p152u.InterfaceC1174b;

/* renamed from: b.e.a.a.o.g */
/* loaded from: classes.dex */
public class C1141g extends C1138d {
    public C1141g(FloatingActionButton floatingActionButton, InterfaceC1174b interfaceC1174b) {
        super(floatingActionButton, interfaceC1174b);
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: a */
    public float mo4047a() {
        return this.f5759x.getElevation();
    }

    /* renamed from: a */
    public final Animator m4070a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f5759x, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f5759x, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(C1138d.f5725E);
        return animatorSet;
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: a */
    public void mo4051a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f5759x.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(C1138d.f5726F, m4070a(f, f3));
            stateListAnimator.addState(C1138d.f5727G, m4070a(f, f2));
            stateListAnimator.addState(C1138d.f5728H, m4070a(f, f2));
            stateListAnimator.addState(C1138d.f5729I, m4070a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f5759x, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.f5759x;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f5759x, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(C1138d.f5725E);
            stateListAnimator.addState(C1138d.f5730J, animatorSet);
            stateListAnimator.addState(C1138d.f5731K, m4070a(0.0f, 0.0f));
            this.f5759x.setStateListAnimator(stateListAnimator);
        }
        if (mo4064i()) {
            m4068m();
        }
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: a */
    public void mo4053a(ColorStateList colorStateList) {
        Drawable drawable = this.f5738c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(C1172b.m4140a(colorStateList));
        } else {
            super.mo4053a(colorStateList);
        }
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: a */
    public void mo4054a(Rect rect) {
        if (FloatingActionButton.this.f11404l) {
            super.mo4054a(rect);
        } else {
            int sizeDimension = !m4066k() ? (this.f5745j - this.f5759x.getSizeDimension()) / 2 : 0;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: a */
    public void mo4055a(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.f5759x.isEnabled()) {
                this.f5759x.setElevation(this.f5742g);
                if (this.f5759x.isPressed()) {
                    floatingActionButton = this.f5759x;
                    f = this.f5744i;
                } else if (this.f5759x.isFocused() || this.f5759x.isHovered()) {
                    floatingActionButton = this.f5759x;
                    f = this.f5743h;
                }
                floatingActionButton.setTranslationZ(f);
            }
            this.f5759x.setElevation(0.0f);
            floatingActionButton = this.f5759x;
            floatingActionButton.setTranslationZ(f);
        }
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: d */
    public void mo4059d() {
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: e */
    public void mo4060e() {
        m4068m();
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: h */
    public boolean mo4063h() {
        return false;
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: i */
    public boolean mo4064i() {
        return FloatingActionButton.this.f11404l || !m4066k();
    }

    @Override // p078b.p126e.p127a.p128a.p146o.C1138d
    /* renamed from: l */
    public void mo4067l() {
    }
}
