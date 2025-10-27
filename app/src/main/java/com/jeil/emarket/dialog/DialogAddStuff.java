package com.jeil.emarket.dialog;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.edittext.EditPhone;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.textview.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;
import com.jeil.emarket.viewmodel.DelivererVM;

/* renamed from: b.f.a.f.t2 */

public class DialogAddStuff extends ImageDialog1<DialogAddStuff> {

    /* renamed from: T */
    public List<java.lang.String> f9064T;

    /* renamed from: U */
    public BaseDialog2 f9065U;

    /* renamed from: V */
    public View f9066V;

    /* renamed from: W */
    public BaseActivity f9067W;

    /* renamed from: X */
    public java.lang.String f9068X;

    /* renamed from: Y */
    public boolean f9069Y;

    public DialogAddStuff(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f9064T = new ArrayList();
        this.f9065U = null;
        this.f9068X = "";
        this.f9069Y = false;
        this.f9067W = activityC1391g1;
    }

    
    public  void m4853a(DialogInterface dialogInterface) {
        this.f9069Y = false;
    }

    
    public  void m4854a(View view, List list, View view2, int i) {
        ((TextView) view.findViewById(R.id.ctv_user_role)).setText(Util.m335d(this.f9067W, (java.lang.String) list.get(i)));
        this.f9068X = (java.lang.String) list.get(i);
        this.f9065U.startAni();
    }

    
    public  void m4855a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            dismiss();
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        this.f9066V = View.inflate(this.f8251b, R.layout.dialog_add_staff, null);
        this.f9064T.add("vendorFinanceManager");
        this.f9064T.add("vendorAdManager");
        this.f9064T.add("vendorProductManager");
        this.f9064T.add("vendorAgent");
        this.f9066V.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddStuff.this.m4856f(view);
            }
        });
        this.f9066V.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddStuff.this.m4857g(view);
            }
        });
        final EditForm editForm = (EditForm) this.f9066V.findViewById(R.id.cef_new_password);
        final EditForm editForm2 = (EditForm) this.f9066V.findViewById(R.id.cef_confirm_password);
        editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditForm.this.showeye();
            }
        });
        editForm2.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditForm.this.showeye();
            }
        });
        ((EditPhone) this.f9066V.findViewById(R.id.cep_phone1)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddStuff.this.m4858h(view);
            }
        });
        this.f9068X = this.f9064T.get(r0.size() - 1);
        ((TextView) this.f9066V.findViewById(R.id.ctv_user_role)).setText(Util.m335d(this.f9067W, this.f9068X));
        this.f9066V.findViewById(R.id.mrl_user_role).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddStuff.this.m4859i(view);
            }
        });
        return this.f9066V;
    }

    /* renamed from: f */
    public  void m4856f(View view) {
        boolean z;
        BaseActivity activityC1391g1;
        java.lang.String string;
        EditText editText = (EditText) this.f9066V.findViewById(R.id.et_staff_name);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.f9066V.findViewById(R.id.llc_user_role);
        EditForm editForm = (EditForm) this.f9066V.findViewById(R.id.cef_new_password);
        EditForm editForm2 = (EditForm) this.f9066V.findViewById(R.id.cef_confirm_password);
        EditPhone editPhone = (EditPhone) this.f9066V.findViewById(R.id.cep_phone1);
        EditPhone editPhone2 = (EditPhone) this.f9066V.findViewById(R.id.cep_phone2);
        java.lang.String text = editPhone.getText();
        java.lang.String text2 = editPhone2.getText();
        boolean z2 = true;
        if (((Editable) Objects.requireNonNull(editText.getText())).toString().isEmpty()) {
            editText.setBackground(this.f9067W.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editText.setBackground(this.f9067W.getResources().getDrawable(R.drawable.bg_input_border));
            z = false;
        }
        java.lang.String str = this.f9068X;
        if (str == null || str.isEmpty()) {
            linearLayoutCompat.setBackground(this.f9067W.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            linearLayoutCompat.setBackground(this.f9067W.getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (editForm.getText().isEmpty()) {
            editForm.setEditTextBackground(this.f9067W.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm.setEditTextBackground(this.f9067W.getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (editForm2.getText().isEmpty()) {
            editForm2.setEditTextBackground(this.f9067W.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm2.setEditTextBackground(this.f9067W.getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (text.isEmpty()) {
            CustomString.m3169a(this.f9067W, R.drawable.bd_warn_input, editPhone);
            z = true;
        } else {
            CustomString.m3169a(this.f9067W, R.drawable.bg_input_border, editPhone);
        }
        if (z) {
            return;
        }
        if (!editForm.getText().equals(editForm2.getText())) {
            Util.toast(this.f9067W, R.string.enter_correct_password, "error");
            return;
        }
        if (editForm.getText().length() < 8) {
            activityC1391g1 = this.f9067W;
            string = java.lang.String.format(activityC1391g1.getResources().getString(R.string.enter_password_limit), 8);
        } else {
            if (editPhone.m6929c(editPhone.getText())) {
                CustomString.m3169a(this.f9067W, R.drawable.bg_input_border, editPhone);
            } else {
                CustomString.m3169a(this.f9067W, R.drawable.bd_warn_input, editPhone);
                z2 = false;
            }
            if (text2.isEmpty() || editPhone2.m6929c(text2)) {
                CustomString.m3169a(this.f9067W, R.drawable.bg_input_border, editPhone2);
            } else {
                CustomString.m3169a(this.f9067W, R.drawable.bd_warn_input, editPhone2);
                z2 = false;
            }
            if (z2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", editText.getText().toString());
                    jSONObject.put("role", this.f9068X);
                    jSONObject.put("password", editForm.getText());
                    jSONObject.put("phone1", editPhone.getText());
                    jSONObject.put("phone2", editPhone2.getText());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                DelivererVM.m5598b(this.f9067W, jSONObject);
                final DialogC2001j dialogC2001j = new DialogC2001j(this.f9067W);
                dialogC2001j.show();
                DelivererVM.f10411d.observe(this.f9067W, new Observer() { // from class: b.f.a.f.s
                    @Override // p000a.p060o.InterfaceC0405p
                    
                    public final void onChanged(Object obj) {
                        DialogAddStuff.this.m4855a(dialogC2001j, (Integer) obj);
                    }
                });
                return;
            }
            activityC1391g1 = this.f9067W;
            string = activityC1391g1.getResources().getString(R.string.invalid_phone);
        }
        Util.toast(activityC1391g1, string, "error", 0, 0);
    }

    /* renamed from: g */
    public  void m4857g(View view) {
        dismiss();
    }

    /* renamed from: h */
    public  void m4858h(View view) {
        ((EditPhone) this.f9066V.findViewById(R.id.cep_phone1)).hide();
        this.f9066V.findViewById(R.id.cep_phone2).setVisibility(View.VISIBLE);
        ((EditPhone) this.f9066V.findViewById(R.id.cep_phone2)).hide();
    }


    public  void m4859i(View view) {
        if (this.f9069Y) {
            return;
        }
        this.f9069Y = true;
        final View view2 = this.f9066V;
        final List<java.lang.String> list = this.f9064T;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Cancel_Obj(Util.m335d(this.f9067W, list.get(i)), ((TextView) view2.findViewById(R.id.ctv_user_role)).getText().equals(Util.m335d(this.f9067W, list.get(i))) ? 1 : 0));
        }
        this.f9065U = new BaseDialog2(this.f9067W, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f9065U;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.f.r
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b
            
            public final void mo4264a(View view3, int i2) {
                DialogAddStuff.this.m4854a(view2, list, view3, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f9065U;
        baseDialog22.f8209G = this.f9067W.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
        this.f9065U.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.f.m
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogAddStuff.this.m4853a(dialogInterface);
            }
        });
    }
}
