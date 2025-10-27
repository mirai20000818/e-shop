package com.jeil.emarket.dialog;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;

/* renamed from: b.f.a.f.z2 */

public class DialogOrderCancel extends DialogError {

    /* renamed from: T */
    public EditText f9122T;

    public DialogOrderCancel(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f8254e = 1.0f;
        this.f8237R = 0.0f;
        this.f8249y = 14.0f;
        this.f8248x = activityC1391g1.getResources().getColor(R.color.dark);
        this.f9122T = new EditText(activityC1391g1);
        this.f9122T.setId(R.id.et_customer_note);
        this.f9122T.setBackground(activityC1391g1.getResources().getDrawable(R.drawable.bg_input_border));
        this.f9122T.setHint(activityC1391g1.getResources().getString(R.string.order_cancel_hint));
        this.f9122T.setHintTextColor(activityC1391g1.getResources().getColor(R.color.light));
        this.f9122T.setTextSize(1, 12.0f);
        this.f9122T.setTextColor(activityC1391g1.getResources().getColor(R.color.dark));
        this.f9122T.setLines(4);
        this.f9122T.setLineSpacing(Util.dp2px((Context) activityC1391g1, 6), 1.0f);
        this.f9122T.setPadding(m4590a(10.0f), m4590a(10.0f), m4590a(10.0f), m4590a(10.0f));
        this.f9122T.setGravity(8388659);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, m4590a(5.0f), 0, m4590a(15.0f));
        this.f9122T.setLayoutParams(c0541a);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.DialogC2000i, p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        this.f8250z.setBackgroundDrawable(this.f8251b.getDrawable(R.drawable.ic_sad_circle));
        this.f8239o.addView(this.f8250z);
        this.f8239o.setPadding(m4590a(23.0f), m4590a(23.0f), m4590a(23.0f), m4590a(18.0f));
        this.f8245u.setPadding(0, 0, 0, m4590a(15.0f));
        this.f8239o.addView(this.f8245u);
        this.f8239o.addView(this.f9122T);
        this.f8221B.setGravity(17);
        this.f8221B.addView(this.f8222C);
        this.f8221B.addView(this.f8224E);
        this.f8221B.addView(this.f8223D);
        this.f8239o.addView(this.f8221B);
        LinearLayoutCompat linearLayoutCompat = this.f8239o;
        this.f8263n = linearLayoutCompat;
        return linearLayoutCompat;
    }
}
