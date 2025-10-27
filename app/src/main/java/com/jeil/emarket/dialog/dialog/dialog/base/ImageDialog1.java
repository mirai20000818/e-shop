package com.jeil.emarket.dialog.dialog.dialog.base;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jeil.emarket.custom.Util;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;

/* renamed from: b.f.a.c.c0.c.l.f */

public abstract class ImageDialog1<T extends ImageDialog1<T>> extends DialogBaseAni<T> {


    public int f8220A;


    public LinearLayoutCompat f8221B;


    public CustomButton f8222C;


    public CustomButton f8223D;


    public CustomButton f8224E;

    /* renamed from: F */
    public String f8225F;

    /* renamed from: G */
    public String f8226G;

    /* renamed from: H */
    public String f8227H;


    public int f8228I;


    public int f8229J;


    public int f8230K;

    /* renamed from: L */
    public float f8231L;

    /* renamed from: M */
    public float f8232M;

    /* renamed from: N */
    public float f8233N;

    /* renamed from: O */
    public DialogInterface f8234O;

    /* renamed from: P */
    public DialogInterface f8235P;

    /* renamed from: Q */
    public DialogInterface f8236Q;

    /* renamed from: R */
    public float f8237R;

    /* renamed from: S */
    public int f8238S;

    /* renamed from: o */
    public LinearLayoutCompat f8239o;

    /* renamed from: p */
    public TextView f8240p;

    /* renamed from: q */
    public String f8241q;

    /* renamed from: r */
    public int f8242r;

    /* renamed from: s */
    public float f8243s;

    /* renamed from: t */
    public boolean f8244t;

    /* renamed from: u */
    public TextView f8245u;

    /* renamed from: v */
    public String f8246v;

    /* renamed from: w */
    public int f8247w;

    /* renamed from: x */
    public int f8248x;

    /* renamed from: y */
    public float f8249y;

    /* renamed from: z */
    public AppCompatImageView f8250z;

    public ImageDialog1(Context context) {
        super(context);
        this.f8244t = true;
        this.f8247w = 8388611;
        this.f8220A = 2;
        this.f8225F = "";
        this.f8226G = "";
        this.f8227H = "";
        this.f8231L = 14.0f;
        this.f8232M = 14.0f;
        this.f8233N = 14.0f;
        this.f8237R = 8.0f;
        this.f8238S = Color.parseColor("#ffffff");
        this.f8254e = 1.0f;
        this.f8239o = new LinearLayoutCompat(context);
        this.f8239o.setOrientation(LinearLayoutCompat.VERTICAL);
        this.f8240p = new TextView(context);
        this.f8245u = new TextView(context);
        this.f8250z = new AppCompatImageView(context);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(Util.dp2px(this.f8251b, 56), Util.dp2px(this.f8251b, 56));
        ((LinearLayout.LayoutParams) c0541a).bottomMargin = Util.dp2px(this.f8251b, 16);
        ((LinearLayout.LayoutParams) c0541a).gravity = 17;
        this.f8250z.setLayoutParams(c0541a);
        this.f8250z.setScaleType(ImageView.ScaleType.CENTER);
        this.f8221B = new LinearLayoutCompat(context);
        this.f8221B.setOrientation(LinearLayoutCompat.HORIZONTAL);
        this.f8222C = new CustomButton(context);
        this.f8222C.setGravity(17);
        this.f8224E = new CustomButton(context);
        this.f8224E.setGravity(17);
        this.f8223D = new CustomButton(context);
        this.f8223D.setGravity(17);
    }


    public ImageDialog1<T> m4584a(String... strArr) {
        String str;
        if (strArr.length < 1 || strArr.length > 3) {
            throw new IllegalStateException(" range of param btnTexts length is [1,3]!");
        }
        if (strArr.length == 1) {
            str = strArr[0];
        } else {
            if (strArr.length == 2) {
                this.f8225F = strArr[0];
                this.f8226G = strArr[1];
                return this;
            }
            this.f8225F = strArr[0];
            this.f8226G = strArr[1];
            str = strArr[2];
        }
        this.f8227H = str;
        return this;
    }


    public void m4585a(DialogInterface... dialogInterfaceArr) {
        DialogInterface dialogInterface;
        if (dialogInterfaceArr.length < 1 || dialogInterfaceArr.length > 3) {
            throw new IllegalStateException(" range of param onBtnClickLs length is [1,3]!");
        }
        if (dialogInterfaceArr.length == 1) {
            dialogInterface = dialogInterfaceArr[0];
        } else if (dialogInterfaceArr.length == 2) {
            this.f8234O = dialogInterfaceArr[0];
            this.f8235P = dialogInterfaceArr[1];
            return;
        } else {
            this.f8234O = dialogInterfaceArr[0];
            this.f8235P = dialogInterfaceArr[1];
            dialogInterface = dialogInterfaceArr[2];
        }
        this.f8236Q = dialogInterface;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
        CustomButton customButton;
        this.f8240p.setVisibility(this.f8244t ? View.VISIBLE : View.GONE);
        this.f8240p.setText(TextUtils.isEmpty(this.f8241q) ? "" : this.f8241q);
        this.f8240p.setTextColor(this.f8242r);
        this.f8240p.setTextSize(1, this.f8243s);
        this.f8245u.setGravity(this.f8247w);
        this.f8245u.setText(this.f8246v);
        this.f8245u.setTextColor(this.f8248x);
        this.f8245u.setTextSize(1, this.f8249y);
        this.f8245u.setLineSpacing(0.0f, 1.5f);
        this.f8245u.setGravity(1);
        this.f8222C.setText(this.f8225F);
        this.f8223D.setText(this.f8226G);
        this.f8224E.setText(this.f8227H);
        this.f8222C.setTextColor(this.f8228I);
        this.f8223D.setTextColor(this.f8229J);
        this.f8224E.setTextColor(this.f8230K);
        this.f8222C.setTextSize(1, this.f8231L);
        this.f8223D.setTextSize(1, this.f8232M);
        this.f8224E.setTextSize(1, this.f8233N);
        this.f8222C.setBackgroundResource(R.drawable.bd_primary_round);
        this.f8222C.setStateListAnimator(null);
        this.f8224E.setStateListAnimator(null);
        this.f8223D.setStateListAnimator(null);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, m4590a(55.0f), 1.0f);
        ((LinearLayout.LayoutParams) c0541a).rightMargin = m4590a(5.0f);
        this.f8222C.setLayoutParams(c0541a);
        LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(m4590a(30.0f), m4590a(30.0f));
        ((LinearLayout.LayoutParams) c0541a2).rightMargin = m4590a(5.0f);
        ((LinearLayout.LayoutParams) c0541a2).leftMargin = m4590a(5.0f);
        this.f8224E.setLayoutParams(c0541a2);
        LinearLayoutCompat.LayoutParams c0541a3 = new LinearLayoutCompat.LayoutParams(-1, m4590a(55.0f), 1.0f);
        ((LinearLayout.LayoutParams) c0541a3).leftMargin = m4590a(5.0f);
        this.f8223D.setLayoutParams(c0541a3);
        int i = this.f8220A;
        if (i != 1) {
            if (i == 2) {
                customButton = this.f8224E;
            }
            this.f8222C.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.l.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImageDialog1.this.m4586c(view);
                }
            });
            this.f8223D.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.l.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImageDialog1.this.m4587d(view);
                }
            });
            this.f8224E.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.l.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImageDialog1.this.m4588e(view);
                }
            });
        }
        this.f8222C.setVisibility(View.GONE);
        customButton = this.f8223D;
        customButton.setVisibility(View.GONE);
        this.f8222C.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.l.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageDialog1.this.m4586c(view);
            }
        });
        this.f8223D.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.l.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageDialog1.this.m4587d(view);
            }
        });
        this.f8224E.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.l.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageDialog1.this.m4588e(view);
            }
        });
    }


    public  void m4586c(View view) {
        DialogInterface dialogInterface = this.f8234O;
        if (dialogInterface != null) {
            dialogInterface.cancel();
        } else {
            dismiss();
        }
    }


    public  void m4587d(View view) {
        DialogInterface dialogInterface = this.f8235P;
        if (dialogInterface != null) {
            dialogInterface.cancel();
        } else {
            dismiss();
        }
    }


    public  void m4588e(View view) {
        DialogInterface dialogInterface = this.f8236Q;
        if (dialogInterface != null) {
            dialogInterface.cancel();
        } else {
            dismiss();
        }
    }
}
