package com.jeil.emarket.dialog;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.seller.VendorOrderDetailActivity;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import java.util.Date;

import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.viewmodel.ModelCollection;

/* renamed from: b.f.a.f.d3 */

public class DialogSelectShippingArrivedAt extends BaseAniDialog<DialogSelectShippingArrivedAt> {


    public Date f8910A;


    public float f8911B;


    public int f8912C;


    public int f8913D;


    public java.lang.String f8914E;

    /* renamed from: F */
    public java.lang.String f8915F;

    /* renamed from: G */
    public Date f8916G;

    /* renamed from: H */
    public BaseActivity f8917H;

    /* renamed from: y */
    public MutableLiveData<Date> f8918y;

    /* renamed from: z */
    public PickerObj3 f8919z;

    /* renamed from: b.f.a.f.d3$a */
    public class a implements TextWatcher {


        public final  EditForm f8920b;

        public a(DialogSelectShippingArrivedAt dialogSelectShippingArrivedAt, EditForm editForm) {
            this.f8920b = editForm;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            float f;
            EditForm editForm;
            try {
                f = Float.parseFloat(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
            } catch (Exception unused) {
                this.f8920b.setText("0");
                f = 0.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                java.lang.String str = "";
                if (f == 0.0f) {
                    editForm = this.f8920b;
                } else {
                    editForm = this.f8920b;
                    str = f + "";
                }
                editForm.setText(str);
            }
            if (f > 1.0E7f) {
                this.f8920b.setText("10000000");
            }
        }
    }

    public DialogSelectShippingArrivedAt(BaseActivity activityC1391g1, Date date, Date date2, int i, int i2, java.lang.String str, java.lang.String str2) {
        super(activityC1391g1, 80);
        this.f8918y = new MutableLiveData<>();
        if (date2 != null) {
            this.f8918y.setValue( date2);
            this.f8910A = date2;
        }
        this.f8916G = date;
        this.f8917H = activityC1391g1;
        this.f8912C = i;
        this.f8913D = i2;
        this.f8914E = str2;
        this.f8915F = str;
    }


    public  void m4799a(View view, Date date, View view2) {
        this.f8910A = date;
        ((TextView) view.findViewById(R.id.tv_shipping_time)).setText(Util.m307b(date));
    }


    public  void m4800a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            BaseActivity activityC1391g1 = this.f8917H;
            if (activityC1391g1 instanceof VendorOrderDetailActivity) {
                ((VendorOrderDetailActivity) activityC1391g1).f11821O = true;
                ((VendorOrderDetailActivity) activityC1391g1).m6603U();
            }
            ModelCollection.m5447d(this.f8917H, this.f8912C);
        }
        dialogC2001j.dismiss();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m4801a(com.jeil.emarket.components.edittext.EditForm r9, android.view.View r10, android.view.View r11) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p230f.DialogC2179d3.m4801a(com.jeil.emarket.components.edittext.EditForm, android.view.View, android.view.View):void");
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        PickerObj3 pickerObj3;
        Date date;
        final View inflate = View.inflate(this.f8251b, R.layout.dialog_select_shipping_arrived_at, null);
        inflate.findViewById(R.id.llc_button_group).setBackgroundColor(inflate.getResources().getColor(R.color.white));
        inflate.findViewById(R.id.cb_cancel).setVisibility(View.GONE);
        inflate.findViewById(R.id.cb_cancel_outline).setVisibility(View.VISIBLE);
        inflate.setBackground(Util.m205a(Color.parseColor("#ffffffff"), new float[]{m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), 0.0f, 0.0f, 0.0f, 0.0f}));
        inflate.setPadding(m4590a(10.0f), m4590a(20.0f), m4590a(10.0f), m4590a(7.0f));
        this.f8919z = new PickerObj3(this.f8917H);
        this.f8919z.m4712a(this.f8916G);
        MutableLiveData<Date> mutableLiveData = this.f8918y;
        if (mutableLiveData == null || mutableLiveData.getValue() == null) {
            pickerObj3 = this.f8919z;
            date = this.f8916G;
        } else {
            ((TextView) inflate.findViewById(R.id.tv_shipping_time)).setText(Util.m307b(this.f8918y.getValue()));
            pickerObj3 = this.f8919z;
            date = this.f8918y.getValue();
        }
        pickerObj3.m4714b(date);
        this.f8919z.f8619c = new InterfaceC2115g() { // from class: b.f.a.f.n1
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

            public final void mo4267a(Date date2, View view) {
                DialogSelectShippingArrivedAt.this.m4799a(inflate, date2, view);
            }
        };
        inflate.findViewById(R.id.mrl_arrived_at).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSelectShippingArrivedAt.this.m4802c(view);
            }
        });
        inflate.findViewById(R.id.llc_shipping_pay).setVisibility(this.f8913D == 1 ? View.VISIBLE : View.GONE);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_shipping_pay);
        editForm.setEditListener(new a(this, editForm));
        ((TextView) inflate.findViewById(R.id.ctv_common_price_unit)).setText(this.f8915F.equals("kpw") ? this.f8917H.getResources().getString(R.string.won) : "$");
        if (this.f8914E.equals("time")) {
            CustomString.m3167a(inflate, R.id.llc_shipping_pay, 8, R.id.llc_shipping_time, 0);
        } else if (this.f8914E.equals("price")) {
            inflate.findViewById(R.id.llc_shipping_pay).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.llc_shipping_time).setVisibility(View.GONE);
            new LinearLayoutCompat.LayoutParams(-1, -2).setMargins(Util.dp2px((Context) this.f8917H, 10), Util.dp2px((Context) this.f8917H, 10), Util.dp2px((Context) this.f8917H, 10), Util.dp2px((Context) this.f8917H, 7));
        }
        inflate.findViewById(R.id.cb_cancel_outline).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSelectShippingArrivedAt.this.m4803d(view);
            }
        });
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSelectShippingArrivedAt.this.m4801a(editForm, inflate, view);
            }
        });
        return inflate;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
    }


    public  void m4802c(View view) {
        this.f8919z.m4710a();
    }


    public  void m4803d(View view) {
        startAni();
    }
}
