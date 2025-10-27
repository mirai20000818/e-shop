package com.jeil.emarket.frag.analy.staff;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.intro.VendorSettingActivity;
import com.jeil.emarket.components.button.SwitchView;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.model.vendor.VendorBusinessInfo;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: b.f.a.g.d.b.b4 */

public class FragmentVendorSetting extends Fragment {

    /* renamed from: f0 */
    public DialogC2001j f9776f0;

    /* renamed from: h0 */
    public VendorSettingActivity f9778h0;

    /* renamed from: i0 */
    public View f9779i0;

    /* renamed from: b0 */
    public List<Integer> f9772b0 = new ArrayList();

    /* renamed from: c0 */
    public List<Integer> f9773c0 = new ArrayList();

    /* renamed from: d0 */
    public List<Category> f9774d0 = new ArrayList();

    /* renamed from: e0 */
    public ImageDialog2 f9775e0 = null;

    /* renamed from: g0 */
    public boolean f9777g0 = false;

    /* renamed from: a0 */
    public Vendor f9771a0 = VendorListVM.f10363d.getValue();

    public FragmentVendorSetting(VendorSettingActivity vendorSettingActivity) {
        this.f9778h0 = vendorSettingActivity;
    }


    public static  void m5215a(LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, View view, int i, int i2, int i3, int i4) {
        if (view.canScrollVertically(-1)) {
            linearLayoutCompat.setVisibility(View.VISIBLE);
        } else {
            linearLayoutCompat.setVisibility(View.GONE);
        }
        if (view.canScrollVertically(1)) {
            linearLayoutCompat2.setVisibility(View.VISIBLE);
        } else {
            linearLayoutCompat2.setVisibility(View.GONE);
        }
    }

    /* renamed from: S0 */
    public void m5216S0() {
        if (this.f9771a0 != null) {
            this.f9774d0 = CategoryVM.listMutableLiveData.getValue();
            this.f9772b0 = new ArrayList();
            Vendor vendor = this.f9771a0;
            if (vendor != null) {
                int[] iArr = vendor.categories;
                if (iArr.length != 0) {
                    for (int i : iArr) {
                        this.f9772b0.add(Integer.valueOf(i));
                    }
                }
            }
            m5219a(this.f9772b0);
            this.f9773c0 = this.f9772b0;
            if (this.f9771a0.currency != null) {
                ((RadioButton) this.f9779i0.findViewById(R.id.crb_kpw)).setChecked(this.f9771a0.currency.equals("kpw"));
                ((RadioButton) this.f9779i0.findViewById(R.id.crb_kpf)).setChecked(this.f9771a0.currency.equals("kpf"));
                ((RadioButton) this.f9779i0.findViewById(R.id.crb_kpwf)).setChecked(this.f9771a0.currency.equals("kpwf"));
                if (this.f9771a0.currency.equals("kpw")) {
                    this.f9779i0.findViewById(R.id.cb_pay_narae).setVisibility(View.GONE);
                    this.f9779i0.findViewById(R.id.cb_pay_ulim).setVisibility(View.VISIBLE);
                } else {
                    this.f9779i0.findViewById(R.id.cb_pay_narae).setVisibility(View.VISIBLE);
                    this.f9779i0.findViewById(R.id.cb_pay_ulim).setVisibility(View.GONE);
                }
            }
            CheckBox checkBox = (CheckBox) this.f9779i0.findViewById(R.id.cb_pay_ulim);
            List<String> list = this.f9771a0.payType;
            checkBox.setChecked((list == null || list.indexOf("ulim") == -1) ? false : true);
            CheckBox checkBox2 = (CheckBox) this.f9779i0.findViewById(R.id.cb_pay_narae);
            List<String> list2 = this.f9771a0.payType;
            checkBox2.setChecked((list2 == null || list2.indexOf("narae") == -1) ? false : true);
            CheckBox checkBox3 = (CheckBox) this.f9779i0.findViewById(R.id.cb_pay_samhung);
            List<String> list3 = this.f9771a0.payType;
            checkBox3.setChecked((list3 == null || list3.indexOf("samhung") == -1) ? false : true);
            CheckBox checkBox4 = (CheckBox) this.f9779i0.findViewById(R.id.cb_pay_transfer);
            List<String> list4 = this.f9771a0.payType;
            checkBox4.setChecked((list4 == null || list4.indexOf("transfer") == -1) ? false : true);
            SwitchView switchView = (SwitchView) this.f9779i0.findViewById(R.id.csv_ticket);
            Boolean bool = this.f9771a0.enableTicket;
            switchView.setChecked(bool != null ? bool.booleanValue() : false);
            this.f9779i0.findViewById(R.id.csv_ticket).setEnabled(!this.f9771a0.hideName);
        }
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9779i0 = layoutInflater.inflate(R.layout.fragment_vendor_setting, viewGroup, false);
        m5216S0();
        this.f9779i0.findViewById(R.id.btn_save_vendor_info).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.e3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentVendorSetting.this.m5223c(view);
            }
        });
        this.f9779i0.findViewById(R.id.mrl_main_categories).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.f3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentVendorSetting.this.m5224d(view);
            }
        });
        return this.f9779i0;
    }


    public  void m5217a(android.content.DialogInterface dialogInterface) {
        m5219a(this.f9773c0);
        this.f9777g0 = false;
    }


    public  void m5218a(VendorBusinessInfo vendorBusinessInfo, DialogError dialogError, final boolean z, final List list) {
        VendorListVM.m5562a(this.f9778h0, vendorBusinessInfo);
        this.f9776f0 = new DialogC2001j(this.f9778h0);
        this.f9776f0.show();
        dialogError.dismiss();
        VendorListVM.f10366g.observe(this.f9778h0, new Observer() { // from class: b.f.a.g.d.b.b3
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentVendorSetting.this.m5221a(z, list, (Integer) obj);
            }
        });
    }


    public final void m5219a(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() != 0 && this.f9774d0 != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                for (int i = 0; i < this.f9774d0.size(); i++) {
                    if (this.f9774d0.get(i).f12393id == intValue) {
                        Category category = new Category();
                        category.f12393id = intValue;
                        category.name = this.f9774d0.get(i).name;
                        arrayList.add(category);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() != 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(((Category) arrayList.get(i2)).name);
            }
        }
        ((TextView) this.f9779i0.findViewById(R.id.ctv_vendor_categories)).setText(sb.toString());
    }


    public  void m5220a(List list, View view) {
        this.f9773c0 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (((CheckBox) list.get(i)).isChecked()) {
                this.f9773c0.add(Integer.valueOf(this.f9774d0.get(i).f12393id));
            }
        }
        this.f9775e0.dismiss();
    }


    public  void m5221a(boolean z, List list, Integer num) {
        DialogC2001j dialogC2001j = this.f9776f0;
        if (dialogC2001j != null) {
            dialogC2001j.dismiss();
        }
        if (num.intValue() != 200 || VendorListVM.f10363d.getValue() == null) {
            return;
        }
        VendorListVM.f10363d.getValue().enableTicket = Boolean.valueOf(z);
        VendorListVM.f10363d.getValue().payType = list;
        int[] iArr = new int[this.f9773c0.size()];
        for (int i = 0; i < this.f9773c0.size(); i++) {
            iArr[i] = this.f9773c0.get(i).intValue();
        }
        this.f9772b0 = this.f9773c0;
        VendorListVM.f10363d.getValue().categories = iArr;
    }

    
    public  void m5222b(boolean z, List list, Integer num) {
        DialogC2001j dialogC2001j = this.f9776f0;
        if (dialogC2001j != null) {
            dialogC2001j.dismiss();
        }
        if (num.intValue() != 200 || VendorListVM.f10363d.getValue() == null) {
            return;
        }
        VendorListVM.f10363d.getValue().enableTicket = Boolean.valueOf(z);
        VendorListVM.f10363d.getValue().payType = list;
    }

    
    public  void m5223c(View view) {
        boolean z;
        final VendorBusinessInfo vendorBusinessInfo = new VendorBusinessInfo();
        if (this.f9773c0.size() == 0) {
            this.f9778h0.findViewById(R.id.llc_categories).setBackgroundResource(R.drawable.bd_warn_input);
            return;
        }
        this.f9778h0.findViewById(R.id.llc_categories).setBackgroundResource(R.drawable.bg_input_border);
        final boolean m6901a = ((SwitchView) this.f9778h0.findViewById(R.id.csv_ticket)).m6901a();
        Boolean bool = this.f9771a0.enableTicket;
        boolean z2 = m6901a != (bool != null ? bool.booleanValue() : !m6901a);
        if (this.f9772b0.toString().equals(this.f9773c0.toString())) {
            z = false;
        } else {
            z2 = true;
            z = true;
        }
        final ArrayList arrayList = new ArrayList();
        if (((CheckBox) this.f9778h0.findViewById(R.id.cb_pay_ulim)).isChecked()) {
            arrayList.add("ulim");
        }
        if (((CheckBox) this.f9778h0.findViewById(R.id.cb_pay_narae)).isChecked()) {
            arrayList.add("narae");
        }
        if (((CheckBox) this.f9778h0.findViewById(R.id.cb_pay_samhung)).isChecked()) {
            arrayList.add("samhung");
        }
        if (((CheckBox) this.f9778h0.findViewById(R.id.cb_pay_transfer)).isChecked()) {
            arrayList.add("transfer");
        }
        if ((arrayList.size() != 0 || this.f9771a0.payType != null) && !arrayList.equals(this.f9771a0.payType)) {
            z2 = true;
        }
        if (!z2) {
            Util.toast(this.f9778h0, getResources().getString(R.string.no_change), "error", 0, 0);
            return;
        }
        vendorBusinessInfo.currency = this.f9771a0.currency;
        vendorBusinessInfo.enableTicket = Boolean.valueOf(m6901a);
        vendorBusinessInfo.payType = arrayList;
        vendorBusinessInfo.categories = this.f9773c0;
        if (!z) {
            VendorListVM.m5562a(this.f9778h0, vendorBusinessInfo);
            this.f9776f0 = new DialogC2001j(this.f9778h0);
            this.f9776f0.show();
            VendorListVM.f10366g.observe(this.f9778h0, new Observer() { // from class: b.f.a.g.d.b.x2
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    FragmentVendorSetting.this.m5222b(m6901a, arrayList, (Integer) obj);
                }
            });
            return;
        }
        final DialogError dialogError = new DialogError(this.f9778h0);
        dialogError.f8246v = getResources().getString(R.string.change_main_category_warning_notice);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new DialogInterface() { // from class: b.f.a.g.d.b.b
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                dialogError.dismiss();
            }
        }, new DialogInterface() { // from class: b.f.a.g.d.b.y2
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                FragmentVendorSetting.this.m5218a(vendorBusinessInfo, dialogError, m6901a, arrayList);
            }
        });
    }

    
    public  void m5224d(View view) {
        if (this.f9777g0) {
            return;
        }
        this.f9777g0 = true;
        View inflate = View.inflate(this.f9778h0, R.layout.dialog_checkbox_item_group, null);
        final ArrayList arrayList = new ArrayList();
        for (Category category : this.f9774d0) {
            View inflate2 = View.inflate(this.f9778h0, R.layout.item_checkbox, null);
            CheckBox checkBox = (CheckBox) inflate2;
            checkBox.setText(category.name);
            checkBox.setChecked(false);
            Iterator<Integer> it = this.f9773c0.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().intValue() == category.f12393id) {
                        checkBox.setChecked(true);
                        break;
                    }
                } else {
                    break;
                }
            }
            arrayList.add(checkBox);
            ((LinearLayoutCompat) inflate.findViewById(R.id.llc_checkbox_items)).addView(inflate2, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        final LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) inflate.findViewById(R.id.ll_top_gradient);
        final LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) inflate.findViewById(R.id.ll_bottom_gradient);
        if (Build.VERSION.SDK_INT >= 23) {
            inflate.findViewById(R.id.nsv_main).setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: b.f.a.g.d.b.d3
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view2, int i, int i2, int i3, int i4) {
                    FragmentVendorSetting.m5215a(linearLayoutCompat, linearLayoutCompat2, view2, i, i2, i3, i4);
                }
            });
        }
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.z2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorSetting.this.m5220a(arrayList, view2);
            }
        });
        inflate.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.a3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorSetting.this.m5225e(view2);
            }
        });
        this.f9775e0 = Util.m212a(this.f9778h0, inflate, 0.74f, 0.5f);
        this.f9775e0.show();
        this.f9775e0.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.g.d.b.c3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                FragmentVendorSetting.this.m5217a(dialogInterface);
            }
        });
    }

    
    public  void m5225e(View view) {
        this.f9775e0.dismiss();
    }
}
