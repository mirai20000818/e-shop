package com.jeil.emarket.components.dialog.widget.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;


import com.jeil.emarket.dialog.dialog.dialog.bottom.DialogBaseBottom;
import com.anievaluate.ani.TransAniSet;
import com.anievaluate.ani.transAni.TransAni;


public class BubblePopup extends DialogBaseBottom<BubblePopup> {

    
    public TriangleView f12222A;

    
    public int f12223B;

    
    public int f12224C;

    
    public RelativeLayout.LayoutParams f12225D;

    /* renamed from: t */
    public View f12226t;

    /* renamed from: u */
    public LinearLayoutCompat f12227u;

    /* renamed from: v */
    public RelativeLayout.LayoutParams f12228v;

    /* renamed from: w */
    public int f12229w;

    /* renamed from: x */
    public int f12230x;

    /* renamed from: y */
    public int f12231y;

    /* renamed from: z */
    public int f12232z;

    public static class TriangleView extends View {

        
        public Paint f12233b;

        
        public Path f12234c;

        
        public int f12235d;

        
        public int f12236e;

        public TriangleView(Context context) {
            super(context);
            this.f12233b = new Paint(1);
            this.f12234c = new Path();
        }

        public TriangleView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12233b = new Paint(1);
            this.f12234c = new Path();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Path path;
            float f;
            float f2;
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();
            this.f12233b.setColor(this.f12235d);
            this.f12234c.reset();
            int i = this.f12236e;
            if (i != 48) {
                if (i == 80) {
                    this.f12234c.moveTo(0.0f, 0.0f);
                    float f3 = width;
                    this.f12234c.lineTo(f3, 0.0f);
                    path = this.f12234c;
                    f = f3 / 2.0f;
                    f2 = height;
                }
                canvas.drawPath(this.f12234c, this.f12233b);
            }
            f = width;
            this.f12234c.moveTo(f / 2.0f, 0.0f);
            f2 = height;
            this.f12234c.lineTo(0.0f, f2);
            path = this.f12234c;
            path.lineTo(f, f2);
            this.f12234c.close();
            canvas.drawPath(this.f12234c, this.f12233b);
        }

        public void setColor(int i) {
            this.f12235d = i;
            invalidate();
        }

        public void setGravity(int i) {
            this.f12236e = i;
            invalidate();
        }
    }

    public BubblePopup(Context context, View view) {
        super(context);
        this.f12226t = view;
        m4593a(false);
        this.f12229w = Color.parseColor("#DD333333");
        this.f12230x = m4590a(3.0f);
        this.f12231y = m4590a(8.0f);
        this.f12232z = m4590a(8.0f);
        m4596a(48);
        this.f12223B = m4590a(10.0f);
        this.f12224C = m4590a(5.0f);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public View mo4576b() {
        View inflate = View.inflate(this.f8251b, R.layout.popup_bubble, null);
        this.f12227u = (LinearLayoutCompat) inflate.findViewById(R.id.ll_content);
        this.f12222A = (TriangleView) inflate.findViewById(R.id.triangle_view);
        this.f12227u.addView(this.f12226t);
        this.f12228v = (RelativeLayout.LayoutParams) this.f12227u.getLayoutParams();
        this.f12225D = (RelativeLayout.LayoutParams) this.f12222A.getLayoutParams();
        inflate.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -1));
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: b.f.a.c.c0.c.m.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                BubblePopup.this.mo4597f();
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.m.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BubblePopup.this.m6908d(view);
            }
        });
        return inflate;
    }

    
    public BubblePopup m6907c(View view) {
        if (view == null) {
            return this;
        }
        this.f8279o = view;
        int[] iArr = new int[2];
        this.f8279o.getLocationOnScreen(iArr);
        this.f8280p = (view.getWidth() / 2) + iArr[0];
        if (this.f8282r == 48) {
            this.f8281q = (iArr[1] - Util.m321c(this.f8251b)) - m4590a(1.0f);
        } else {
            this.f8281q = m4590a(1.0f) + view.getHeight() + (iArr[1] - Util.m321c(this.f8251b));
        }
        return this;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public void mo4577c() {
        this.f12227u.setBackground(Util.getGradDrawable(this.f12229w, this.f12230x));
        this.f12228v.setMargins(this.f12231y, 0, this.f12232z, 0);
        this.f12227u.setLayoutParams(this.f12228v);
        this.f12222A.setColor(this.f12229w);
        this.f12222A.setGravity(this.f8282r == 48 ? 80 : 48);
        RelativeLayout.LayoutParams layoutParams = this.f12225D;
        layoutParams.width = this.f12223B;
        layoutParams.height = this.f12224C;
        this.f12222A.setLayoutParams(layoutParams);
    }

    
    public  void m6908d(View view) {
        m4595e();
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p198m.AbstractDialogC2013c
    /* renamed from: f */
    public void mo4597f() {
        m6907c(this.f8279o);
        TriangleView triangleView = this.f12222A;
        float width = this.f8280p - (triangleView.getWidth() / 2.0f);
        if (TransAni.f10697r) {
            TransAni.m5828a(triangleView).m5835c(width);
        } else {
            triangleView.setX(width);
        }
        if (this.f8282r == 48) {
            TransAniSet.m5827a(this.f12222A, this.f8281q - this.f12222A.getHeight());
           // TransAniSet.m5827a(this.f12227u, r0 - r1.getHeight());
        } else {
            TransAniSet.m5827a(this.f12222A, this.f8281q);
            TransAniSet.m5827a(this.f12227u, this.f12222A.getHeight() + this.f8281q);
        }
        int i = this.f8280p - this.f12228v.leftMargin;
        int i2 = (this.f8252c.widthPixels - this.f8280p) - this.f12228v.rightMargin;
        int width2 = this.f12227u.getWidth();
        int i3 = width2 / 2;
        int i4 = (i3 > i || i3 > i2) ? i <= i2 ? this.f12228v.leftMargin : this.f8252c.widthPixels - (width2 + this.f12228v.rightMargin) : this.f8280p - i3;
        LinearLayoutCompat linearLayoutCompat = this.f12227u;
        float f = i4;
        if (TransAni.f10697r) {
            TransAni.m5828a(linearLayoutCompat).m5835c(f);
        } else {
            linearLayoutCompat.setX(f);
        }
    }
}
