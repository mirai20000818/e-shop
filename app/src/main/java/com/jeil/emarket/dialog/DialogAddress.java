package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.view.View;

import com.jeil.emarket.components.edittext.EditPhone;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Address;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;
import com.jeil.emarket.components.pickerview.PickerViewObj;
import com.jeil.emarket.components.pickerview.InterfacePicker;

/* renamed from: b.f.a.f.u2 */

public class DialogAddress extends ImageDialog1<DialogAddress> implements InterfacePicker {

    /* renamed from: T */
    public View f9075T;

    /* renamed from: U */
    public BaseActivity f9076U;

    /* renamed from: V */
    public String f9077V;

    /* renamed from: W */
    public PickerViewObj f9078W;

    /* renamed from: X */
    public String f9079X;

    /* renamed from: Y */
    public Address f9080Y;

    public DialogAddress(BaseActivity activityC1391g1, Address address) {
        super(activityC1391g1);
        this.f9076U = activityC1391g1;
        this.f9080Y = address;
        this.f9078W = new PickerViewObj(activityC1391g1, this, true, false);
        this.f9077V = "none";
    }


    public  void m4860a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            m4595e();
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p190c.p214w.InterfaceC2104i

    public void mo4547a(String str, String str2) {
        ((TextView) findViewById(R.id.tv_address1)).setText(str2);
        this.f9079X = str;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @SuppressLint({"StringFormatMatches"})
    
    public View mo4576b() {
        View findViewById;
        View.OnClickListener onClickListener;
        this.f9075T = View.inflate(this.f8251b, R.layout.dialog_add_address, null);
        if (this.f9080Y != null) {
            ((EditText) this.f9075T.findViewById(R.id.et_name)).setText(this.f9080Y.name);
            ((TextView) this.f9075T.findViewById(R.id.tv_address1)).setText(PickerViewObj.m4699b(this.f9080Y.address1, this.f9076U));
            ((EditText) this.f9075T.findViewById(R.id.et_address2)).setText(this.f9080Y.address2);
            ((EditText) this.f9075T.findViewById(R.id.et_location)).setText(this.f9080Y.location);
            ((EditPhone) this.f9075T.findViewById(R.id.cep_phone1)).setText(this.f9080Y.phone1);
            this.f9075T.findViewById(R.id.cb_add_default_address).setVisibility(View.GONE);
            Address address = this.f9080Y;
            this.f9079X = address.address1;
            if (!address.phone2.isEmpty()) {
                ((EditPhone) this.f9075T.findViewById(R.id.cep_phone1)).setText(this.f9080Y.phone1);
                this.f9075T.findViewById(R.id.cep_phone2).setVisibility(View.VISIBLE);
                ((EditPhone) this.f9075T.findViewById(R.id.cep_phone2)).setText(this.f9080Y.phone2);
                ((EditPhone) this.f9075T.findViewById(R.id.cep_phone1)).hide();
                ((EditPhone) this.f9075T.findViewById(R.id.cep_phone2)).hide();
            }
            this.f9078W.m4701a(this.f9079X);
            this.f9075T.findViewById(R.id.tv_address1).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogAddress.this.m4863f(view);
                }
            });
            ((EditPhone) this.f9075T.findViewById(R.id.cep_phone1)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogAddress.this.m4864g(view);
                }
            });
            findViewById = this.f9075T.findViewById(R.id.tvOkAddress);
            onClickListener = new View.OnClickListener() { // from class: b.f.a.f.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogAddress.this.AddNewAddress(view);
                }
            };
        } else {
            this.f9075T.findViewById(R.id.tv_address1).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogAddress.this.m4866i(view);
                }
            });
            ((EditPhone) this.f9075T.findViewById(R.id.cep_phone1)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogAddress.this.m4867j(view);
                }
            });
            findViewById = this.f9075T.findViewById(R.id.tvOkAddress);
            onClickListener = new View.OnClickListener() { // from class: b.f.a.f.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogAddress.this.m4868k(view);
                }
            };
        }
        findViewById.setOnClickListener(onClickListener);
        this.f9075T.findViewById(R.id.tvCancelAddress).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddress.this.m4869l(view);
            }
        });
        return this.f9075T;
    }

    
    public  void m4861b(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            m4595e();
        }
        dialogC2001j.dismiss();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void AddAddress(boolean isNew) {

    }

    /* renamed from: f */
    public  void m4863f(View view) {
        this.f9078W.m4703b();
    }

    /* renamed from: g */
    public  void m4864g(View view) {
        ((EditPhone) this.f9075T.findViewById(R.id.cep_phone1)).hide();
        this.f9075T.findViewById(R.id.cep_phone2).setVisibility(View.VISIBLE);
        ((EditPhone) this.f9075T.findViewById(R.id.cep_phone2)).hide();
    }

    /* renamed from: h */
    public  void AddNewAddress(View view) {
        AddAddress(false);
    }

    
    public  void m4866i(View view) {
        this.f9078W.m4703b();
    }

   
    public  void m4867j(View view) {
        ((EditPhone) this.f9075T.findViewById(R.id.cep_phone1)).hide();
        this.f9075T.findViewById(R.id.cep_phone2).setVisibility(View.VISIBLE);
        ((EditPhone) this.f9075T.findViewById(R.id.cep_phone2)).hide();
    }

    
    public  void m4868k(View view) {
        AddNewAddress(true);
    }

    /* renamed from: l */
    public  void m4869l(View view) {
        dismiss();
    }
}
