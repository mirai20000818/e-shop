package com.jeil.emarket.dialog;

import android.content.res.Resources;
import android.text.Editable;
import android.view.View;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.seller.VendorStaffActivity;
import com.jeil.emarket.components.edittext.EditPhone;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.model.vendor.Staff;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;
import com.jeil.emarket.viewmodel.DelivererVM;

/* renamed from: b.f.a.f.r2 */

public class DialogDelivery extends ImageDialog1<DialogDelivery> {

    /* renamed from: T */
    public View f9046T;

    /* renamed from: U */
    public BaseActivity f9047U;

    public DialogDelivery(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f9047U = activityC1391g1;
    }


    public  void m4841a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            m4595e();
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public View mo4576b() {
        this.f9046T = View.inflate(this.f8251b, R.layout.dialog_add_deliverer, null);
        this.f9046T.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDelivery.this.m4842f(view);
            }
        });
        this.f9046T.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDelivery.this.m4843g(view);
            }
        });
        return this.f9046T;
    }

    /* renamed from: f */
    public  void m4842f(View view) {
        boolean z;
        boolean z2;
        BaseActivity activityC1391g1;
        Resources resources;
        int i;
        EditText editText = (EditText) this.f9046T.findViewById(R.id.et_deliverer_full_name);
        EditPhone editPhone = (EditPhone) this.f9046T.findViewById(R.id.cep_phone1);
        EditPhone editPhone2 = (EditPhone) this.f9046T.findViewById(R.id.cep_phone2);
        java.lang.String text = editPhone.getText();
        java.lang.String text2 = editPhone2.getText();
        boolean z3 = true;
        if (text.isEmpty()) {
            CustomString.m3169a(this.f9047U, R.drawable.bd_warn_input, editPhone);
            z = true;
        } else {
            CustomString.m3169a(this.f9047U, R.drawable.bg_input_border, editPhone);
            z = false;
        }
        if (((Editable) Objects.requireNonNull(editText.getText())).toString().isEmpty()) {
            editText.setBackground(this.f9047U.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editText.setBackground(this.f9047U.getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (z) {
            return;
        }
        if (editPhone.m6929c(editPhone.getText())) {
            CustomString.m3169a(this.f9047U, R.drawable.bg_input_border, editPhone);
            z2 = true;
        } else {
            CustomString.m3169a(this.f9047U, R.drawable.bd_warn_input, editPhone);
            z2 = false;
        }
        if (text2.isEmpty() || editPhone2.m6929c(text2)) {
            CustomString.m3169a(this.f9047U, R.drawable.bg_input_border, editPhone2);
        } else {
            CustomString.m3169a(this.f9047U, R.drawable.bd_warn_input, editPhone2);
            z2 = false;
        }
        if (z2) {
            List<Staff> list = ((VendorStaffActivity) this.f9047U).f11886b0;
            if (list != null && list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2).fullName.equals(editText.getText().toString()) && (list.get(i2).phone1.equals(text) || list.get(i2).phone2.equals(text) || (!text2.isEmpty() && (list.get(i2).phone1.equals(text2) || list.get(i2).phone2.equals(text2))))) {
                        break;
                    }
                }
            }
            z3 = false;
            if (!z3) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("phone1", text);
                    jSONObject.put("phone2", text2);
                    jSONObject.put("fullname", ((Editable) Objects.requireNonNull(editText.getText())).toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                DelivererVM.m5592a(this.f9047U, jSONObject);
                final DialogC2001j dialogC2001j = new DialogC2001j(this.f9047U);
                dialogC2001j.show();
                DelivererVM.f10412e.observe(this.f9047U, new Observer() { // from class: b.f.a.f.d
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        DialogDelivery.this.m4841a(dialogC2001j, (Integer) obj);
                    }
                });
                return;
            }
            activityC1391g1 = this.f9047U;
            resources = activityC1391g1.getResources();
            i = R.string.already_existed_deliverer_warning_notice;
        } else {
            activityC1391g1 = this.f9047U;
            resources = activityC1391g1.getResources();
            i = R.string.invalid_phone;
        }
        Util.toast(activityC1391g1, resources.getString(i), "error", 0, 0);
    }

    /* renamed from: g */
    public  void m4843g(View view) {
        dismiss();
    }
}
