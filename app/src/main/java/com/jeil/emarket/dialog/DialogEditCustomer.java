package com.jeil.emarket.dialog;

import android.view.View;

import com.jeil.emarket.activities.seller.VendorOrderDetailActivity;
import com.jeil.emarket.components.edittext.EditPhone;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;
import com.jeil.emarket.components.pickerview.PickerViewObj;
import com.jeil.emarket.components.pickerview.InterfacePicker;
import com.jeil.emarket.viewmodel.ModelCollection;

/* renamed from: b.f.a.f.w2 */

public class DialogEditCustomer extends ImageDialog1<DialogEditCustomer> implements InterfacePicker {

    /* renamed from: T */
    public PickerViewObj f9093T;

    /* renamed from: U */
    public String f9094U;

    /* renamed from: V */
    public View f9095V;

    /* renamed from: W */
    public BaseActivity f9096W;

    /* renamed from: X */
    public ShippingInfo f9097X;

    /* renamed from: Y */
    public int f9098Y;

    public DialogEditCustomer(BaseActivity activityC1391g1, ShippingInfo shippingInfo, int i) {
        super(activityC1391g1);
        this.f9096W = activityC1391g1;
        this.f9097X = shippingInfo;
        this.f9098Y = i;
        this.f9093T = new PickerViewObj(activityC1391g1, this, true, false);
    }

    
    public  void m4875a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            m4595e();
            BaseActivity activityC1391g1 = this.f9096W;
            if (activityC1391g1 instanceof VendorOrderDetailActivity) {
                ((VendorOrderDetailActivity) activityC1391g1).f11821O = true;
                ((VendorOrderDetailActivity) activityC1391g1).m6603U();
            }
            ModelCollection.m5447d(this.f9096W, this.f9098Y);
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p190c.p214w.InterfaceC2104i
    
    public void mo4547a(String str, String str2) {
        ((TextView) findViewById(R.id.tv_address1)).setText(str2);
        this.f9094U = str;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public View mo4576b() {
        this.f9095V = View.inflate(this.f8251b, R.layout.dialog_edit_customer, null);
        ShippingInfo shippingInfo = this.f9097X;
        if (shippingInfo != null) {
            String str = shippingInfo.address1;
            if (str != null && !str.isEmpty()) {
                this.f9094U = PickerViewObj.m4697a(this.f9097X.address1, this.f9096W);
            }
            ((EditText) this.f9095V.findViewById(R.id.et_name)).setText(this.f9097X.name);
            ((TextView) this.f9095V.findViewById(R.id.tv_address1)).setText(this.f9097X.address1);
            ((EditText) this.f9095V.findViewById(R.id.et_address2)).setText(this.f9097X.address2);
            ((EditText) this.f9095V.findViewById(R.id.et_location)).setText(this.f9097X.location);
            ((EditPhone) this.f9095V.findViewById(R.id.cep_phone1)).setText(this.f9097X.phone1);
            if (!this.f9097X.phone2.isEmpty()) {
                ((EditPhone) this.f9095V.findViewById(R.id.cep_phone2)).setText(this.f9097X.phone2);
            }
            this.f9093T.m4701a(this.f9094U);
            this.f9095V.findViewById(R.id.tv_address1).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEditCustomer.this.m4876f(view);
                }
            });
            this.f9095V.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEditCustomer.this.m4877g(view);
                }
            });
        }
        this.f9095V.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEditCustomer.this.m4878h(view);
            }
        });
        return this.f9095V;
    }

    /* renamed from: f */
    public  void m4876f(View view) {
        this.f9093T.m4703b();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m4877g(android.view.View r15) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p230f.DialogC2261w2.m4877g(android.view.View):void");
    }

    /* renamed from: h */
    public  void m4878h(View view) {
        dismiss();
    }
}
