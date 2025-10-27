package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditPhone;
import com.jeil.emarket.components.pickerview.InterfacePicker;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.Staff;
import com.jeil.emarket.viewmodel.DelivererVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

/* renamed from: b.f.a.b.k.j1 */

public class StaffAdapter1 extends BaseMainAdapter<Staff, RecyclerView.ViewHolder> implements InterfacePicker {

    /* renamed from: f */
    public final BaseInterface2 f7913f;

    /* renamed from: g */
    public final LayoutInflater f7914g;

    /* renamed from: h */
    public View f7915h;

    
    public boolean f7916i;

    /* renamed from: b.f.a.b.k.j1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f7917t;

        /* renamed from: u */
        public final TextView f7918u;

        /* renamed from: v */
        public final TextView f7919v;

        /* renamed from: w */
        public final TextView f7920w;

        /* renamed from: x */
        public final MaterialRippleLayout f7921x;

        /* renamed from: y */
        public final MaterialRippleLayout f7922y;

        public a(View view) {
            super(view);
            this.f7917t = (TextView) view.findViewById(R.id.ctv_user_fullname);
            this.f7918u = (TextView) view.findViewById(R.id.ctv_phone);
            this.f7919v = (TextView) view.findViewById(R.id.ctv_delivery);
            this.f7920w = (TextView) view.findViewById(R.id.ctv_good_delivery);
            this.f7921x = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete_staff);
            this.f7922y = (MaterialRippleLayout) view.findViewById(R.id.mrl_edit_staff_info);
        }
    }

    /* renamed from: b.f.a.b.k.j1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public StaffAdapter1(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7916i = false;
        this.f7914g = LayoutInflater.from(activityC1391g1);
        this.f7913f = baseInterface2;
    }


    public  void m4541a(int i, Staff staff, DialogError dialogError, DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f7913f.mo4808a(i, java.lang.String.valueOf(staff.f12447id), 1);
            dialogError.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m4542a(int i, Staff staff, ImageDialog2 imageDialog2, DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f7913f.mo4808a(i, java.lang.String.valueOf(staff.f12447id), 1);
            imageDialog2.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m4543a(android.content.DialogInterface dialogInterface) {
        this.f7916i = false;
    }


    public  void m4544a(EditPhone editPhone, EditPhone editPhone2, final Staff staff, final int i, final ImageDialog2 imageDialog2, View view) {
        boolean z;
        boolean z2;
        BaseActivity activityC1391g1;
        Resources resources;
        int i2;
        boolean z3 = true;
        if (editPhone.getText().isEmpty()) {
            CustomString.m3169a(this.baseActivity, R.drawable.bd_warn_input, editPhone);
            z = true;
        } else {
            CustomString.m3169a(this.baseActivity, R.drawable.bg_input_border, editPhone);
            z = false;
        }
        if (z) {
            return;
        }
        if (editPhone.m6929c(editPhone.getText())) {
            CustomString.m3169a(this.baseActivity, R.drawable.bg_input_border, editPhone);
            z2 = true;
        } else {
            CustomString.m3169a(this.baseActivity, R.drawable.bd_warn_input, editPhone);
            z2 = false;
        }
        if (editPhone2.getText().isEmpty() || editPhone2.m6929c(editPhone2.getText())) {
            CustomString.m3169a(this.baseActivity, R.drawable.bg_input_border, editPhone2);
        } else {
            CustomString.m3169a(this.baseActivity, R.drawable.bd_warn_input, editPhone2);
            z2 = false;
        }
        if (z2) {
            if (staff.phone1.equals(editPhone.getText()) && staff.phone2.equals(editPhone2.getText())) {
                z3 = false;
            }
            if (z3) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", staff.f12447id);
                    jSONObject.put("phone1", editPhone.getText());
                    jSONObject.put("phone2", editPhone2.getText());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                DelivererVM.m5590a(this.baseActivity, staff.f12447id, jSONObject);
                final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
                dialogC2001j.show();
                DelivererVM.f10412e.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.e
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        StaffAdapter1.this.m4542a(i, staff, imageDialog2, dialogC2001j, (Integer) obj);
                    }
                });
                return;
            }
            activityC1391g1 = this.baseActivity;
            resources = activityC1391g1.getResources();
            i2 = R.string.no_change;
        } else {
            activityC1391g1 = this.baseActivity;
            resources = activityC1391g1.getResources();
            i2 = R.string.invalid_phone;
        }
        Util.toast(activityC1391g1, resources.getString(i2), "error", 0, 0);
    }


    public  void m4546a(final Staff staff, final int i, final DialogError dialogError) {
        DelivererVM.m5588a(this.baseActivity, staff.f12447id);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        DelivererVM.f10412e.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.i
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                StaffAdapter1.this.m4541a(i, staff, dialogError, dialogC2001j, (Integer) obj);
            }
        });
    }

    @Override // p078b.p159f.p160a.p190c.p214w.InterfaceC2104i

    public void mo4547a(java.lang.String str, java.lang.String str2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((Staff) this.arrayList.get(i)).type == null || !((Staff) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    
    public  void m4548b(android.content.DialogInterface dialogInterface) {
        this.f7916i = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        java.lang.String str;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Staff staff = (Staff) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.f7917t.setText(staff.fullName);
            java.lang.String str2 = staff.phone1;
            if (str2 == null || str2.isEmpty()) {
                java.lang.String str3 = staff.phone2;
                str = (str3 == null || str3.isEmpty()) ? "" : staff.phone2;
            } else {
                str = staff.phone1;
                java.lang.String str4 = staff.phone2;
                if (str4 != null && !str4.isEmpty()) {
                    StringBuilder m3177b = CustomString.m3177b(str, ", ");
                    m3177b.append(staff.phone2);
                    str = m3177b.toString();
                }
            }
            aVar.f7918u.setText(str);
            TextView textView = aVar.f7919v;
            StringBuilder sb = new StringBuilder();
            sb.append(staff.deliveries);
            CustomString.m3170a(this.baseActivity, R.string.delivery_count_unit, sb, textView);
            TextView textView2 = aVar.f7920w;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(staff.goodDeliveries);
            CustomString.m3170a(this.baseActivity, R.string.delivery_count_unit, sb2, textView2);
            aVar.f7921x.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StaffAdapter1.this.m4545a(staff, i, view);
                }
            });
            aVar.f7922y.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StaffAdapter1.this.m4549b(staff, i, view);
                }
            });
        }
    }

    
    public  void m4549b(final Staff staff, final int i, View view) {
        if (this.f7916i) {
            return;
        }
        this.f7915h = View.inflate(this.baseActivity, R.layout.dialog_update_deliverer, null);
        final EditPhone editPhone = (EditPhone) this.f7915h.findViewById(R.id.cep_phone1);
        final EditPhone editPhone2 = (EditPhone) this.f7915h.findViewById(R.id.cep_phone2);
        java.lang.String str = staff.phone1;
        if (str != null && !str.isEmpty()) {
            editPhone.setText(staff.phone1);
        }
        java.lang.String str2 = staff.phone2;
        if (str2 != null && !str2.isEmpty()) {
            editPhone2.setText(staff.phone2);
        }
        final ImageDialog2 m211a = Util.m211a((Activity) this.baseActivity, this.f7915h);
        m211a.show();
        this.f7916i = true;
        m211a.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                StaffAdapter1.this.m4548b(dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(m211a.getWindow())).setDimAmount(0.7f);
        CustomButton customButton = (CustomButton) this.f7915h.findViewById(R.id.cb_cancel);
        CustomButton customButton2 = (CustomButton) this.f7915h.findViewById(R.id.cb_ok);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m211a.dismiss();
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StaffAdapter1.this.m4544a(editPhone, editPhone2, staff, i, m211a, view2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7914g.inflate(R.layout.item_shimmer_staff, viewGroup, false)) : new a(this.f7914g.inflate(R.layout.item_deliverer, viewGroup, false));
    }


    public  void m4545a(final Staff staff, final int i, View view) {
        if (this.f7916i) {
            return;
        }
        this.f7916i = true;
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = staff.fullName + this.baseActivity.getResources().getString(R.string.delete_deliverer_warning_notice);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.k.c
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                StaffAdapter1.this.m4546a(staff, i, dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                StaffAdapter1.this.m4543a(dialogInterface);
            }
        });
    }
}
