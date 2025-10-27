package com.jeil.emarket.dialog.dialog.dialog;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;

/* renamed from: b.f.a.c.c0.c.i */

public class DialogError extends ImageDialog1<DialogError> {
    public DialogError(Context context) {
        super(context);
        this.f8248x = Color.parseColor("#8a000000");
        this.f8249y = 11.5f;
        this.f8228I = Color.parseColor("#FF222222");
        this.f8229J = Color.parseColor("#FFFFFFFF");
        this.f8230K = Color.parseColor("#FFFFFFFF");
        this.f8254e = 0.8f;
        setCanceledOnTouchOutside(true);
    }

    /* renamed from: g */
    public static  void m4580g(View view) {
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public View mo4576b() {
        this.f8250z.setBackgroundDrawable(this.f8251b.getDrawable(R.drawable.ic_danger_circle));
        this.f8239o.addView(this.f8250z);
        this.f8239o.setPadding(m4590a(16.0f), m4590a(23.0f), m4590a(16.0f), m4590a(18.0f));
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(m4590a(14.0f), 0, m4590a(14.0f), m4590a(10.0f));
        this.f8245u.setLayoutParams(c0541a);
        this.f8245u.setGravity(17);
        this.f8239o.addView(this.f8245u);
        this.f8221B.setGravity(17);
        this.f8221B.addView(this.f8222C);
        this.f8221B.addView(this.f8224E);
        this.f8221B.addView(this.f8223D);
        this.f8239o.addView(this.f8221B);
        LinearLayoutCompat linearLayoutCompat = this.f8239o;
        this.f8263n = linearLayoutCompat;
        return linearLayoutCompat;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2008f, p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public void mo4577c() {
        super.mo4577c();
        this.f8239o.setBackground(Util.getGradDrawable(this.f8238S, m4590a(this.f8237R)));
        this.f8222C.setCorner_radius(true);
        this.f8222C.setTextColor(getContext().getResources().getColor(BaseActivity.color));
        this.f8222C.setmOutlineWidth(2);
        this.f8222C.setCornerRadius(m4590a(25.0f));
        this.f8223D.setCornerRadius(m4590a(25.0f));
        this.f8222C.setTextSize(1, 12.0f);
        this.f8223D.setTextSize(1, 12.0f);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-2, Util.dp2px(getContext(), 47), 1.0f);
        ((LinearLayout.LayoutParams) c0541a).rightMargin = Util.dp2px(getContext(), 4);
        ((LinearLayout.LayoutParams) c0541a).leftMargin = Util.dp2px(getContext(), 4);
        this.f8222C.setLayoutParams(c0541a);
        this.f8223D.setLayoutParams(c0541a);
        LinearLayoutCompat linearLayoutCompat = this.f8259j;
        DisplayMetrics displayMetrics = this.f8252c;
        linearLayoutCompat.setLayoutParams(new FrameLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels));
        if (this.f8253d) {
            this.f8259j.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogError.this.m4581f(view);
                }
            });
        }
        this.f8239o.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.c0.c.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogError.m4580g(view);
            }
        });
    }

    /* renamed from: f */
    public  void m4581f(View view) {
        dismiss();
    }
}
