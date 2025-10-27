package com.jeil.emarket.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.components.textview.TextView;

import com.jeil.emarket.custom.font.FontManager;


public class QuantityInput extends LinearLayoutCompat {


    public int f12040A;


    @SuppressLint({"Recycle"})
    public TypedArray f12041B;

    
    public boolean f12042C;

    
    public boolean f12043D;

    
    public float f12044E;

    /* renamed from: q */
    public final Handler f12045q;

    /* renamed from: r */
    public AppCompatImageView f12046r;

    /* renamed from: s */
    public MaterialRippleLayout f12047s;

    /* renamed from: t */
    public AppCompatImageView f12048t;

    /* renamed from: u */
    public MaterialRippleLayout f12049u;

    /* renamed from: v */
    public TextView f12050v;

    /* renamed from: w */
    public Runnable f12051w;

    /* renamed from: x */
    public int f12052x;

    /* renamed from: y */
    public InterfaceC3234a f12053y;

    /* renamed from: z */
    public int f12054z;

    /* renamed from: com.jeil.emarket.components.QuantityInput$a */
    public interface InterfaceC3234a {

        void mo4460a(int i);
    }

    public QuantityInput(Context context) {
        super(context);
        this.f12045q = new Handler();
        this.f12051w = null;
        this.f12052x = 1;
        this.f12054z = 9999;
        this.f12040A = 1;
        this.f12042C = false;
        this.f12043D = false;
        this.f12044E = 1.0f;
    }

    public QuantityInput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12045q = new Handler();
        this.f12051w = null;
        this.f12052x = 1;
        this.f12054z = 9999;
        this.f12040A = 1;
        this.f12042C = false;
        this.f12043D = false;
        this.f12044E = 1.0f;
        m6831a(context, attributeSet);
    }

    public QuantityInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12045q = new Handler();
        this.f12051w = null;
        this.f12052x = 1;
        this.f12054z = 9999;
        this.f12040A = 1;
        this.f12042C = false;
        this.f12043D = false;
        this.f12044E = 1.0f;
        m6831a(context, attributeSet);
    }

    @SuppressLint({"ClickableViewAccessibility", "ResourceType", "UseCompatLoadingForDrawables"})

    public void m6831a(Context context, AttributeSet attributeSet) {
        this.f12046r = new AppCompatImageView(context);
        this.f12048t = new AppCompatImageView(context);
        this.f12050v = new TextView(context);
        this.f12050v.setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        this.f12041B = context.obtainStyledAttributes(attributeSet, R.styleable.QuantityInput);
        int dimensionPixelSize = this.f12041B.getDimensionPixelSize(2, 0) * 2;
        int dimensionPixelSize2 = this.f12041B.getDimensionPixelSize(0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        this.f12046r.setLayoutParams(layoutParams);
        this.f12046r.setImageDrawable(getResources().getDrawable(R.drawable.ic_minus));
        this.f12046r.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark)));
        this.f12047s = new MaterialRippleLayout(context);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        ((LinearLayout.LayoutParams) c0541a).gravity = 17;
        this.f12047s.setLayoutParams(c0541a);
        this.f12047s.setRippleRoundedCorners(50);
        this.f12047s.setDefaultRippleAlpha(10);
        this.f12047s.setRippleColor(getResources().getColor(R.color.ripple_dark));
        this.f12047s.setRippleHover(true);
        this.f12047s.setRippleOverlay(true);
        this.f12047s.setPadding(Util.dp2px(context, 0), Util.dp2px(context, 0), Util.dp2px(context, 0), Util.dp2px(context, 0));
        this.f12047s.setBackground(getResources().getDrawable(R.drawable.bd_grey_circle));
        this.f12047s.addView(this.f12046r);
        this.f12050v.setText("1");
        this.f12050v.setTextSize(0, this.f12041B.getDimensionPixelSize(3, 0));
        LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-2, -1);
        if (this.f12041B.getDimensionPixelSize(4, -1) != -1) {
            this.f12050v.setMinWidth(this.f12041B.getDimensionPixelSize(4, 0));
        }
        c0541a2.setMargins(10, 0, 10, 0);
        this.f12050v.setGravity(17);
        this.f12050v.setTextColor(this.f12041B.getColor(1, 0));
        this.f12050v.setLayoutParams(c0541a2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.gravity = 17;
        this.f12048t.setLayoutParams(layoutParams2);
        this.f12048t.setImageDrawable(getResources().getDrawable(R.drawable.ic_plus_button));
        this.f12048t.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark)));
        this.f12049u = new MaterialRippleLayout(context);
        this.f12049u.setLayoutParams(new LinearLayoutCompat.LayoutParams(dimensionPixelSize2, dimensionPixelSize2));
        this.f12049u.setRippleRoundedCorners(50);
        this.f12049u.setDefaultRippleAlpha(10);
        this.f12049u.setRippleColor(getResources().getColor(R.color.ripple_dark));
        this.f12049u.setRippleHover(true);
        this.f12049u.setRippleOverlay(true);
        this.f12049u.setPadding(Util.dp2px(context, 0), Util.dp2px(context, 0), Util.dp2px(context, 0), Util.dp2px(context, 0));
        this.f12049u.setBackground(getResources().getDrawable(R.drawable.bd_grey_circle));
        this.f12049u.addView(this.f12048t);
        linearLayoutCompat.addView(this.f12047s);
        linearLayoutCompat.addView(this.f12050v);
        linearLayoutCompat.addView(this.f12049u);
        this.f12047s.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuantityInput.this.m6832a(view);
            }
        });
        this.f12049u.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuantityInput.this.m6835b(view);
            }
        });
        m6843m();
        m6842l();
        addView(linearLayoutCompat);
    }


    public  void m6832a(View view) {
        m6833a(true);
    }


    public void m6833a(boolean z) {
        int max;
        InterfaceC3234a interfaceC3234a;
        int i = this.f12052x;
        if (i <= this.f12040A || this.f12043D) {
            setDisable("minus");
            return;
        }
        if (z) {
            max = i - 1;
        } else {
            this.f12044E = (float) (this.f12044E * 1.05d);
            max = (int) Math.max(i - Math.floor(this.f12044E), this.f12040A);
        }
        this.f12052x = max;
        setEnable("plus");
        setQty(this.f12052x);
        if (!z || (interfaceC3234a = this.f12053y) == null) {
            return;
        }
        interfaceC3234a.mo4460a(this.f12052x);
    }


    public  boolean m6834a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12051w = new Runnable() { // from class: b.f.a.c.h
                @Override // java.lang.Runnable
                public final void run() {
                    QuantityInput.this.m6839i();
                }
            };
            this.f12045q.postDelayed(this.f12051w, 500L);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.f12045q.removeCallbacks(this.f12051w);
        InterfaceC3234a interfaceC3234a = this.f12053y;
        if (interfaceC3234a != null) {
            interfaceC3234a.mo4460a(this.f12052x);
        }
        this.f12044E = 1.0f;
        if (this.f12052x <= this.f12040A) {
            m6841k();
            return false;
        }
        setEnable("minus");
        return false;
    }


    public  void m6835b(View view) {
        m6836b(true);
    }


    public void m6836b(boolean z) {
        int min;
        InterfaceC3234a interfaceC3234a;
        int i = this.f12052x;
        if (i >= this.f12054z || this.f12042C) {
            setDisable("plus");
            return;
        }
        if (z) {
            min = i + 1;
        } else {
            this.f12044E = (float) (this.f12044E * 1.05d);
            min = (int) Math.min(Math.floor(this.f12044E) + i, this.f12054z);
        }
        this.f12052x = min;
        setEnable("minus");
        setQty(this.f12052x);
        if (!z || (interfaceC3234a = this.f12053y) == null) {
            return;
        }
        interfaceC3234a.mo4460a(this.f12052x);
    }


    public  boolean m6837b(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12051w = new Runnable() { // from class: b.f.a.c.k
                @Override // java.lang.Runnable
                public final void run() {
                    QuantityInput.this.m6838h();
                }
            };
            this.f12045q.postDelayed(this.f12051w, 500L);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.f12045q.removeCallbacks(this.f12051w);
        InterfaceC3234a interfaceC3234a = this.f12053y;
        if (interfaceC3234a != null) {
            interfaceC3234a.mo4460a(this.f12052x);
        }
        this.f12044E = 1.0f;
        if (this.f12052x >= this.f12054z) {
            m6840j();
            return false;
        }
        setEnable("plus");
        return false;
    }

    public int getQty() {
        return this.f12052x;
    }

    /* renamed from: h */
    public  void m6838h() {
        m6836b(false);
        this.f12045q.postDelayed(this.f12051w, 50L);
    }

    
    public  void m6839i() {
        m6833a(false);
        this.f12045q.postDelayed(this.f12051w, 50L);
    }

   
    public final void m6840j() {
        setDisable("plus");
        int i = this.f12054z;
        this.f12052x = i;
        this.f12050v.setText(String.valueOf(i));
    }

    
    public final void m6841k() {
        setDisable("minus");
        int i = this.f12040A;
        this.f12052x = i;
        this.f12050v.setText(String.valueOf(i));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: l */
    public void m6842l() {
        this.f12047s.setOnTouchListener(new View.OnTouchListener() { // from class: b.f.a.c.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return QuantityInput.this.m6834a(view, motionEvent);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: m */
    public void m6843m() {
        this.f12049u.setOnTouchListener(new View.OnTouchListener() { // from class: b.f.a.c.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return QuantityInput.this.m6837b(view, motionEvent);
            }
        });
    }

    public void setDisable(String str) {
        if (str.equals("plus")) {
            this.f12049u.setAlpha(0.6f);
            this.f12048t.setAlpha(0.6f);
            this.f12042C = true;
        } else {
            this.f12047s.setAlpha(0.6f);
            this.f12046r.setAlpha(0.6f);
            this.f12043D = true;
        }
    }

    public void setEnable(String str) {
        if (str.equals("plus")) {
            this.f12049u.setAlpha(1.0f);
            this.f12048t.setAlpha(1.0f);
            this.f12042C = false;
        } else {
            this.f12047s.setAlpha(1.0f);
            this.f12046r.setAlpha(1.0f);
            this.f12043D = false;
        }
    }

    public void setMax(int i) {
        if (i == 0) {
            i = 1;
        }
        this.f12054z = i;
        if (this.f12052x >= this.f12054z) {
            m6840j();
        } else {
            setEnable("plus");
        }
        if (this.f12052x <= this.f12040A) {
            m6841k();
        } else {
            setEnable("minus");
        }
    }

    public void setMin(int i) {
        this.f12040A = i;
        if (this.f12052x <= this.f12040A) {
            m6841k();
        } else {
            setEnable("minus");
        }
    }

    public void setOnQtyChangeListener(InterfaceC3234a interfaceC3234a) {
        this.f12053y = interfaceC3234a;
    }

    public void setQty(int i) {
        this.f12052x = i;
        this.f12050v.setText(String.valueOf(i));
        if (i <= this.f12040A) {
            m6841k();
        } else {
            setEnable("minus");
        }
        if (i >= this.f12054z) {
            m6840j();
        } else {
            setEnable("plus");
        }
    }
}
