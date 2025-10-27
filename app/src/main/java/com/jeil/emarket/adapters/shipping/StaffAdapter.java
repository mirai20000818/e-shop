package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
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
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.edittext.EditPhone;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.Staff;
import com.jeil.emarket.viewmodel.DelivererVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.b.k.b2 */

public class StaffAdapter extends BaseMainAdapter<Staff, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7798f;

    /* renamed from: g */
    public final LayoutInflater f7799g;

    /* renamed from: h */
    public BaseDialog2 f7800h;

    
    public boolean f7801i;

   
    public boolean f7802j;

    
    public java.lang.String f7803k;

    /* renamed from: b.f.a.b.k.b2$a */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* renamed from: b.f.a.b.k.b2$b */
    public static class b extends RecyclerView.ViewHolder {


        public final MaterialRippleLayout f7804A;

        
        public final MaterialRippleLayout f7805B;

        
        public final TextView f7806C;

        /* renamed from: t */
        public final TextView f7807t;

        /* renamed from: u */
        public final TextView f7808u;

        /* renamed from: v */
        public final TextView f7809v;

        /* renamed from: w */
        public final TextView f7810w;

        /* renamed from: x */
        public final TextView f7811x;

        /* renamed from: y */
        public final TextView f7812y;

        /* renamed from: z */
        public final MaterialRippleLayout f7813z;

        public b(View view) {
            super(view);
            this.f7807t = (TextView) view.findViewById(R.id.ctv_user_fullname);
            this.f7808u = (TextView) view.findViewById(R.id.ctv_user_name);
            this.f7809v = (TextView) view.findViewById(R.id.ctv_last_logged_at);
            this.f7810w = (TextView) view.findViewById(R.id.ctv_platform);
            this.f7811x = (TextView) view.findViewById(R.id.ctv_user_role);
            this.f7812y = (TextView) view.findViewById(R.id.ctv_phone);
            this.f7813z = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete_staff);
            this.f7804A = (MaterialRippleLayout) view.findViewById(R.id.mrl_reset_password);
            this.f7805B = (MaterialRippleLayout) view.findViewById(R.id.mrl_edit_staff_info);
            this.f7806C = (TextView) view.findViewById(R.id.ctv_using_status);
        }
    }

    public StaffAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7800h = null;
        this.f7801i = false;
        this.f7802j = false;
        this.f7803k = "";
        this.f7799g = LayoutInflater.from(activityC1391g1);
        this.f7798f = baseInterface2;
    }


    public  void m4517a(int i, Staff staff, DialogError dialogError, DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f7798f.mo4808a(i, java.lang.String.valueOf(staff.f12447id), 1);
            dialogError.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m4518a(int i, Staff staff, ImageDialog2 imageDialog2, DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f7798f.mo4808a(i, java.lang.String.valueOf(staff.f12447id), 1);
            imageDialog2.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m4519a(android.content.DialogInterface dialogInterface) {
        this.f7801i = false;
    }


    public  void m4523a(final Staff staff, final int i, View view) {
        if (this.f7801i) {
            return;
        }
        View inflate = View.inflate(this.baseActivity, R.layout.dialog_update_staff_password, null);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_new_password);
        final EditForm editForm2 = (EditForm) inflate.findViewById(R.id.cef_confirm_password);
        ((TextView) inflate.findViewById(R.id.ctv_update_password_notice)).setText(staff.fullName + "(" + Util.getIdentifier(this.baseActivity, staff.role, "") + ")" + this.baseActivity.getResources().getString(R.string.update_staff_password_notice));
        editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                editForm.showeye();
            }
        });
        editForm2.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                editForm2.showeye();
            }
        });
        final ImageDialog2 m211a = Util.m211a((Activity) this.baseActivity, inflate);
        m211a.show();
        this.f7801i = true;
        m211a.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.k0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                StaffAdapter.this.m4530c(dialogInterface);
            }
        });
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m211a.dismiss();
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StaffAdapter.this.m4522a(editForm, editForm2, staff, i, m211a, view2);
            }
        });
    }


    public  void m4524a(final Staff staff, final int i, final DialogError dialogError) {
        DelivererVM.m5594b(this.baseActivity, staff.f12447id);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        DelivererVM.f10411d.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.t0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                StaffAdapter.this.m4517a(i, staff, dialogError, dialogC2001j, (Integer) obj);
            }
        });
    }


    public  void m4525a(Staff staff, final View view, final List list, View view2) {
        if (this.f7802j || staff.role.equals("vendorManager")) {
            return;
        }
        this.f7802j = true;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Cancel_Obj(Util.m335d(this.baseActivity, (java.lang.String) list.get(i)), ((TextView) view.findViewById(R.id.ctv_user_role)).getText().equals(Util.m335d(this.baseActivity, (java.lang.String) list.get(i))) ? 1 : 0));
        }
        this.f7800h = new BaseDialog2(this.baseActivity, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f7800h;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.b.k.q0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view3, int i2) {
                StaffAdapter.this.m4521a(view, list, view3, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f7800h;
        baseDialog22.f8209G = this.baseActivity.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
        this.f7800h.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.x0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                StaffAdapter.this.m4531d(dialogInterface);
            }
        });
    }


    public  void m4526a(final Staff staff, final List list, final int i, View view) {
        if (this.f7801i) {
            return;
        }
        final View inflate = View.inflate(this.baseActivity, R.layout.dialog_update_staff, null);
        final EditPhone editPhone = (EditPhone) inflate.findViewById(R.id.cep_phone1);
        final EditPhone editPhone2 = (EditPhone) inflate.findViewById(R.id.cep_phone2);
        java.lang.String str = staff.phone1;
        if (str != null && !str.isEmpty()) {
            editPhone.setText(staff.phone1);
        }
        java.lang.String str2 = staff.phone2;
        if (str2 != null && !str2.isEmpty()) {
            editPhone2.setText(staff.phone2);
        }
        this.f7803k = staff.role;
        ((TextView) inflate.findViewById(R.id.ctv_user_role)).setText(Util.m335d(this.baseActivity, this.f7803k));
        if (staff.role.equals("vendorManager")) {
            ((MaterialRippleLayout) inflate.findViewById(R.id.mrl_user_role)).setDefaultRippleAlpha(0);
        }
        inflate.findViewById(R.id.mrl_user_role).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StaffAdapter.this.m4525a(staff, inflate, list, view2);
            }
        });
        final ImageDialog2 m211a = Util.m211a((Activity) this.baseActivity, inflate);
        ((Window) Objects.requireNonNull(m211a.getWindow())).setDimAmount(0.7f);
        m211a.show();
        this.f7801i = true;
        m211a.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.r0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                StaffAdapter.this.m4519a(dialogInterface);
            }
        });
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m211a.dismiss();
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StaffAdapter.this.m4520a(inflate, editPhone, editPhone2, staff, i, m211a, view2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((Staff) this.arrayList.get(i)).type == null || !((Staff) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    
    public  void m4527b(int i, Staff staff, ImageDialog2 imageDialog2, DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f7798f.mo4808a(i, java.lang.String.valueOf(staff.f12447id), 1);
            imageDialog2.m4595e();
        }
        dialogC2001j.dismiss();
    }

    
    public  void m4528b(android.content.DialogInterface dialogInterface) {
        this.f7801i = false;
    }

    
    public  void m4529b(final Staff staff, final int i, View view) {
        if (this.f7801i) {
            return;
        }
        this.f7801i = true;
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = staff.fullName + "(" + Util.getIdentifier(this.baseActivity, staff.role, "") + ")" + this.baseActivity.getResources().getString(R.string.delete_staff_warning_notice);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.k.w0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                StaffAdapter.this.m4524a(staff, i, dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.g0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                StaffAdapter.this.m4528b(dialogInterface);
            }
        });
    }

    
    public  void m4530c(android.content.DialogInterface dialogInterface) {
        this.f7801i = false;
    }

    
    public  void m4531d(android.content.DialogInterface dialogInterface) {
        this.f7802j = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        java.lang.String str;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Staff staff = (Staff) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof b) {
            b bVar = (b) recyclerViewViewHolder;
            final ArrayList arrayList = new ArrayList();
            arrayList.add("vendorManager");
            arrayList.add("vendorFinanceManager");
            arrayList.add("vendorAdManager");
            arrayList.add("vendorProductManager");
            arrayList.add("vendorAgent");
            bVar.f7807t.setText(staff.fullName);
            TextView textView = bVar.f7808u;
            StringBuilder m3163a = CustomString.format("(");
            m3163a.append(staff.name);
            m3163a.append(")");
            textView.setText(m3163a.toString());
            bVar.f7811x.setText(Util.getIdentifier(this.baseActivity, staff.role, ""));
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
            bVar.f7812y.setText(str);
            bVar.f7809v.setText(Util.m307b(staff.loggedAt));
            bVar.f7810w.setText(Util.getIdentifier(this.baseActivity, staff.channel, ""));
            bVar.f7813z.setVisibility(staff.role.equals("vendorManager") ? View.GONE : View.VISIBLE);
            bVar.f7813z.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StaffAdapter.this.m4529b(staff, i, view);
                }
            });
            bVar.f7804A.setVisibility("vendorManager".equals(staff.role) ? View.VISIBLE : View.GONE);
            bVar.f7804A.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StaffAdapter.this.m4523a(staff, i, view);
                }
            });
            bVar.f7805B.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.o0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StaffAdapter.this.m4526a(staff, arrayList, i, view);
                }
            });
            bVar.f7806C.setText(this.baseActivity.getResources().getString(staff.mask == 0 ? R.string.use_staff : R.string.ban_staff));
            bVar.f7806C.setBackground(this.baseActivity.getResources().getDrawable(R.drawable.bd_badge_round));
            bVar.f7806C.setBackgroundTintList(ColorStateList.valueOf(this.baseActivity.getResources().getColor(staff.mask == 0 ? R.color.requested : R.color.cancelled)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new a(this.f7799g.inflate(R.layout.item_shimmer_staff, viewGroup, false)) : new b(this.f7799g.inflate(R.layout.item_staff, viewGroup, false));
    }


    public  void m4520a(View view, EditPhone editPhone, EditPhone editPhone2, final Staff staff, final int i, final ImageDialog2 imageDialog2, View view2) {
        boolean z;
        boolean z2;
        BaseActivity activityC1391g1;
        Resources resources;
        int i2;
        java.lang.String str = this.f7803k;
        boolean z3 = true;
        View findViewById = view.findViewById(R.id.llc_user_role);
        if (str == null) {
            CustomString.m3168a(this.baseActivity, R.drawable.bd_warn_input, findViewById);
            z = true;
        } else {
            CustomString.m3168a(this.baseActivity, R.drawable.bg_input_border, findViewById);
            z = false;
        }
        if (editPhone.getText().isEmpty()) {
            CustomString.m3169a(this.baseActivity, R.drawable.bd_warn_input, editPhone);
            z = true;
        } else {
            CustomString.m3169a(this.baseActivity, R.drawable.bg_input_border, editPhone);
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
            if (staff.role.equals(this.f7803k) && staff.phone1.equals(editPhone.getText()) && staff.phone2.equals(editPhone2.getText())) {
                z3 = false;
            }
            if (z3) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", staff.f12447id);
                    jSONObject.put("role", this.f7803k);
                    jSONObject.put("phone1", editPhone.getText());
                    jSONObject.put("phone2", editPhone2.getText());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                DelivererVM.m5596b(this.baseActivity, staff.f12447id, jSONObject);
                final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
                dialogC2001j.show();
                DelivererVM.f10411d.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.i0
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        StaffAdapter.this.m4518a(i, staff, imageDialog2, dialogC2001j, (Integer) obj);
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


    public  void m4522a(EditForm editForm, EditForm editForm2, final Staff staff, final int i, final ImageDialog2 imageDialog2, View view) {
        boolean z;
        java.lang.String text = editForm.getText();
        java.lang.String text2 = editForm2.getText();
        if (text.isEmpty()) {
            editForm.setEditTextBackground(this.baseActivity.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm.setEditTextBackground(this.baseActivity.getResources().getDrawable(R.drawable.bg_input_border));
            z = false;
        }
        if (text2.isEmpty()) {
            editForm2.setEditTextBackground(this.baseActivity.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm2.setEditTextBackground(this.baseActivity.getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (z) {
            return;
        }
        if (!text.equals(text2)) {
            Util.toast(this.baseActivity, R.string.enter_correct_password, "error");
            return;
        }
        if (text.length() < 8) {
            BaseActivity activityC1391g1 = this.baseActivity;
            Util.toast(activityC1391g1, java.lang.String.format(activityC1391g1.getResources().getString(R.string.enter_password_limit), 8), "error", 0, 0);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", staff.f12447id);
            jSONObject.put("password", text);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        DelivererVM.m5596b(this.baseActivity, staff.f12447id, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        DelivererVM.f10411d.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.h0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                StaffAdapter.this.m4527b(i, staff, imageDialog2, dialogC2001j, (Integer) obj);
            }
        });
    }


    public  void m4521a(View view, List list, View view2, int i) {
        ((TextView) view.findViewById(R.id.ctv_user_role)).setText(Util.m335d(this.baseActivity, (java.lang.String) list.get(i)));
        this.f7803k = (java.lang.String) list.get(i);
        this.f7800h.startAni();
    }
}
