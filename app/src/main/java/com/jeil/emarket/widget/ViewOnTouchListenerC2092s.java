package com.jeil.emarket.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.c.s */

public class ViewOnTouchListenerC2092s implements View.OnTouchListener {


    public int f8562b;


    public int f8563c;


    public int f8564d;


    public long f8565e;

    /* renamed from: f */
    public RecyclerView f8566f;

    /* renamed from: g */
    public d f8567g;

    /* renamed from: h */
    public boolean f8568h;

    
    public int f8569i = 1;

   
    public List<f> f8570j = new ArrayList();

    
    public int f8571k = 0;

    /* renamed from: l */
    public float f8572l;

    /* renamed from: m */
    public float f8573m;

    /* renamed from: n */
    public boolean f8574n;

    /* renamed from: o */
    public int f8575o;

    /* renamed from: p */
    public VelocityTracker f8576p;

    /* renamed from: q */
    public int f8577q;

    /* renamed from: r */
    public View f8578r;

    /* renamed from: s */
    public boolean f8579s;

    /* renamed from: t */
    public View f8580t;

    /* renamed from: b.f.a.c.s$a */
    public class a extends AnimatorListenerAdapter {


        public final  View f8581a;


        public final  int f8582b;

        public a(View view, int i) {
            this.f8581a = view;
            this.f8582b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewOnTouchListenerC2092s.m4694a(ViewOnTouchListenerC2092s.this, this.f8581a, this.f8582b);
        }
    }

    /* renamed from: b.f.a.c.s$b */
    public class b extends AnimatorListenerAdapter {


        public final  View f8584a;


        public final  int f8585b;

        public b(View view, int i) {
            this.f8584a = view;
            this.f8585b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewOnTouchListenerC2092s.m4694a(ViewOnTouchListenerC2092s.this, this.f8584a, this.f8585b);
        }
    }

    /* renamed from: b.f.a.c.s$c */
    public static class c {


        public RecyclerView f8587a;


        public d f8588b;


        public e f8589c;


        public boolean f8590d = false;


        public View f8591e;

        public c(RecyclerView recyclerView, d dVar) {
            this.f8587a = recyclerView;
            this.f8588b = dVar;
        }
    }

    /* renamed from: b.f.a.c.s$d */
    public interface d {

        void mo4365a(View view);


        boolean mo4366a(int i);
    }

    /* renamed from: b.f.a.c.s$e */
    public interface e {
    }

    /* renamed from: b.f.a.c.s$f */
    public static class f implements Comparable<f> {


        public int f8592b;


        public View f8593c;

        public f(int i, View view) {
            this.f8592b = i;
            this.f8593c = view;
        }

        @Override // java.lang.Comparable
        public int compareTo(f fVar) {
            return fVar.f8592b - this.f8592b;
        }
    }

    public ViewOnTouchListenerC2092s(c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(cVar.f8587a.getContext());
        this.f8562b = viewConfiguration.getScaledTouchSlop();
        this.f8563c = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f8564d = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f8565e = cVar.f8587a.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f8566f = cVar.f8587a;
        this.f8567g = cVar.f8588b;
        this.f8568h = cVar.f8590d;
        e eVar = cVar.f8589c;
        this.f8580t = cVar.f8591e;
    }


    public static  void m4694a(ViewOnTouchListenerC2092s viewOnTouchListenerC2092s, View view, int i) {
        ValueAnimator duration = ValueAnimator.ofInt(viewOnTouchListenerC2092s.f8568h ? view.getWidth() : view.getHeight(), 1).setDuration(viewOnTouchListenerC2092s.f8565e);
        duration.addListener(new AnimatorListenerAdapterEx(viewOnTouchListenerC2092s, view));
        duration.addUpdateListener(new ValueAnimatorListener(viewOnTouchListenerC2092s));
        viewOnTouchListenerC2092s.f8570j.add(new f(i, view));
        duration.start();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        ViewPropertyAnimator translationX;
        int i;
        ViewPropertyAnimator duration;
        Animator.AnimatorListener bVar;
        boolean z3;
        boolean z4;
        int i2;
        ViewPropertyAnimator translationX2;
        if (this.f8569i < 2) {
            this.f8569i = this.f8568h ? this.f8566f.getHeight() : this.f8566f.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (this.f8579s) {
                return false;
            }
            this.f8566f.getLocationOnScreen(new int[2]);
            //this.f8578r = this.f8566f.m2731a(((int) motionEvent.getRawX()) - r13[0], ((int) motionEvent.getRawY()) - r13[1]);
            if (this.f8578r != null) {
                this.f8572l = motionEvent.getRawX();
                this.f8573m = motionEvent.getRawY();
                //this.f8577q = this.f8566f.m2793g(this.f8578r);
                if (this.f8567g.mo4366a(this.f8577q)) {
                    this.f8576p = VelocityTracker.obtain();
                    this.f8576p.addMovement(motionEvent);
                } else {
                    this.f8578r = null;
                }
            }
            return false;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.f8576p;
                if (velocityTracker != null && !this.f8579s) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.f8572l;
                    float rawY = motionEvent.getRawY() - this.f8573m;
                    if (this.f8568h) {
                        if (Math.abs(rawY) > this.f8562b && Math.abs(rawX) < Math.abs(rawY) / 2.0f) {
                            this.f8574n = true;
                            this.f8575o = rawY > 0.0f ? this.f8562b : -this.f8562b;
                            this.f8566f.requestDisallowInterceptTouchEvent(true);
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                            this.f8566f.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (this.f8574n) {
                            View view2 = this.f8580t;
                            if (view2 == null) {
                                view2 = this.f8578r;
                            }
                            view2.setTranslationY(rawY - this.f8575o);
                            View view3 = this.f8580t;
                            if (view3 == null) {
                                view3 = this.f8578r;
                            }
                            view3.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawY) * 2.0f) / this.f8569i))));
                            return true;
                        }
                    } else {
                        if (Math.abs(rawX) > this.f8562b && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                            this.f8574n = true;
                            this.f8575o = rawX > 0.0f ? this.f8562b : -this.f8562b;
                            this.f8566f.requestDisallowInterceptTouchEvent(true);
                            MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                            obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                            this.f8566f.onTouchEvent(obtain2);
                            obtain2.recycle();
                        }
                        if (this.f8574n) {
                            View view4 = this.f8580t;
                            if (view4 == null) {
                                view4 = this.f8578r;
                            }
                            view4.setTranslationX(rawX - this.f8575o);
                            View view5 = this.f8580t;
                            if (view5 == null) {
                                view5 = this.f8578r;
                            }
                            view5.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / this.f8569i))));
                            return true;
                        }
                    }
                }
            } else if (actionMasked == 3 && this.f8576p != null) {
                View view6 = this.f8578r;
                if (view6 != null && this.f8574n) {
                    if (this.f8568h) {
                        View view7 = this.f8580t;
                        if (view7 != null) {
                            view6 = view7;
                        }
                        translationX2 = view6.animate().translationY(0.0f);
                    } else {
                        View view8 = this.f8580t;
                        if (view8 != null) {
                            view6 = view8;
                        }
                        translationX2 = view6.animate().translationX(0.0f);
                    }
                    translationX2.alpha(1.0f).setDuration(this.f8565e).setListener(null);
                }
                View view9 = this.f8578r;
                this.f8576p.recycle();
                this.f8576p = null;
                this.f8572l = 0.0f;
                this.f8573m = 0.0f;
                this.f8578r = null;
                this.f8577q = -1;
                this.f8574n = false;
            }
            return false;
        }
        if (!this.f8574n) {
            View view10 = this.f8578r;
        }
        if (this.f8576p != null) {
            float rawX2 = motionEvent.getRawX() - this.f8572l;
            float rawY2 = motionEvent.getRawY() - this.f8573m;
            this.f8576p.addMovement(motionEvent);
            this.f8576p.computeCurrentVelocity(1000);
            float xVelocity = this.f8576p.getXVelocity();
            float yVelocity = this.f8576p.getYVelocity();
            float abs = Math.abs(xVelocity);
            float abs2 = Math.abs(this.f8576p.getYVelocity());
            if (this.f8568h) {
                if (Math.abs(rawY2) <= this.f8569i / 2.0f || !this.f8574n) {
                    if (this.f8563c > abs2 || abs2 > this.f8564d || abs >= abs2 || !this.f8574n) {
                        z3 = false;
                    } else {
                        z3 = ((yVelocity > 0.0f ? 1 : (yVelocity == 0.0f ? 0 : -1)) < 0) == ((rawY2 > 0.0f ? 1 : (rawY2 == 0.0f ? 0 : -1)) < 0);
                        if (this.f8576p.getYVelocity() > 0.0f) {
                            z4 = true;
                        }
                    }
                    z4 = false;
                } else {
                    z4 = rawY2 > 0.0f;
                    z3 = true;
                }
                if (!z3 || (i2 = this.f8577q) == -1) {
                    View view11 = this.f8580t;
                    if (view11 == null) {
                        view11 = this.f8578r;
                    }
                    translationX = view11.animate().translationY(0.0f);
                    translationX.alpha(1.0f).setDuration(this.f8565e).setListener(null);
                } else {
                    View view12 = this.f8578r;
                    this.f8571k++;
                    View view13 = this.f8580t;
                    if (view13 == null) {
                        view13 = view12;
                    }
                    duration = view13.animate().translationY(z4 ? this.f8569i : -this.f8569i).alpha(0.0f).setDuration(this.f8565e);
                    bVar = new a(view12, i2);
                    duration.setListener(bVar);
                }
            } else {
                if (Math.abs(rawX2) <= this.f8569i / 2.0f || !this.f8574n) {
                    if (this.f8563c > abs || abs > this.f8564d || abs2 >= abs || !this.f8574n) {
                        z = false;
                    } else {
                        z = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                        if (this.f8576p.getXVelocity() > 0.0f) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                } else {
                    z2 = rawX2 > 0.0f;
                    z = true;
                }
                if (!z || (i = this.f8577q) == -1) {
                    View view14 = this.f8580t;
                    if (view14 == null) {
                        view14 = this.f8578r;
                    }
                    translationX = view14.animate().translationX(0.0f);
                    translationX.alpha(1.0f).setDuration(this.f8565e).setListener(null);
                } else {
                    View view15 = this.f8578r;
                    this.f8571k++;
                    View view16 = this.f8580t;
                    if (view16 == null) {
                        view16 = view15;
                    }
                    duration = view16.animate().translationX(z2 ? this.f8569i : -this.f8569i).alpha(0.0f).setDuration(this.f8565e);
                    bVar = new b(view15, i);
                    duration.setListener(bVar);
                }
            }
            this.f8576p.recycle();
            this.f8576p = null;
            this.f8572l = 0.0f;
            this.f8573m = 0.0f;
            this.f8578r = null;
            this.f8577q = -1;
            this.f8574n = false;
        }
        return false;
    }
}
