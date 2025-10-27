package com.jeil.emarket.frag.main.vendors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.internal.FlowLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.vendor.VendorActivity;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.vendor.VendorLevel;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.viewmodel.DayProductVM;
import com.jeil.emarket.viewmodel.ProductVendorVM;
import com.jeil.emarket.widget.layout2.LinearLayoutCompat3;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.g.b.e.s */

public class FragmentVendorDescription extends Fragment implements BaseInterface {

    /* renamed from: a0 */
    public int f9554a0;

    /* renamed from: b0 */
    public VendorActivity f9555b0;

    /* renamed from: c0 */
    public View f9556c0;

    /* renamed from: b.f.a.g.b.e.s$a */
    public class a extends TypeToken<Vendor> {
        public a(FragmentVendorDescription fragmentVendorDescription) {
        }
    }

    public FragmentVendorDescription(VendorActivity vendorActivity, int i) {
        this.f9555b0 = vendorActivity;
        this.f9554a0 = i;
    }

    /* renamed from: S0 */
    public void m5099S0() {
        API_PROVIDER APIS = new API_PROVIDER(this.f9555b0, "get_vendor_info", this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f9554a0);
            if (!DayProductVM.f10258g.contains(Integer.valueOf(this.f9554a0))) {
                jSONObject.put("views", true);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        StringBuilder m3163a = CustomString.format("e6/vendors/");
        m3163a.append(this.f9554a0);
        APIS.get(m3163a.toString(), jSONObject);
    }

    @Override // androidx.fragment.app.Fragment
    
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9556c0 = layoutInflater.inflate(R.layout.fragment_vendor_description, viewGroup, false);
        m5099S0();
        final NestedScrollView nestedScrollView = (NestedScrollView) this.f9556c0.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            BaseActivity activityC1391g1 = this.f9555b0;
            activityC1391g1.m4286a((View) nestedScrollView, activityC1391g1, (View) null, false).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    nestedScrollView.smoothScrollBy(0, 0, 300);
                }
            });
        }
        return this.f9556c0;
    }

    
    public  void m5100a(Category category, View view) {
        this.f9555b0.m6793a(category);
    }

    @SuppressLint({"DefaultLocale"})
    
    public void m5101a(final Vendor vendor) {
        java.lang.String str;
        VendorLevel vendorLevel;
        if (vendor != null) {
            if (vendor.name != null) {
                ((TextView) this.f9556c0.findViewById(R.id.tv_vendor_name)).setText(vendor.name);
            }
            java.lang.String str2 = vendor.approvedAt;
            if (str2 != null) {
                Date date = null;
                try {
                    date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str2);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                java.lang.String m220a = Util.date2Str2(getContext(), date);
                TextView textView = (TextView) this.f9556c0.findViewById(R.id.tv_enter_year);
                if (textView != null) {
                    textView.setText(m220a);
                }
            }
            int i = vendor.point;
            if (i > -1 && (vendorLevel = (VendorLevel) this.f9556c0.findViewById(R.id.vl_vendor_level)) != null) {
                vendorLevel.m6978a(i, getContext());
            }
            this.f9556c0.findViewById(R.id.vendor_card_img).getLayoutParams().width = BaseActivity.anInt - Util.dp2px((Context) this.f9555b0, 50);
            this.f9556c0.findViewById(R.id.vendor_logo_img).getLayoutParams().width = (BaseActivity.anInt * 7) / 30;
            //Glide.with(this).load((vendor.hideName || (str = vendor.logo) == null) ? this.f9555b0.getResources().getDrawable(R.drawable.logo_home) : Util.m345e(str)).diskCacheStrategy(DiskCacheStrategy.ALL).m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) this.f9555b0, 5)), true).load(this.f9555b0.getResources().getDrawable(R.drawable.ic_placeholder)).into((ImageView) this.f9556c0.findViewById(R.id.vendor_logo_img));
            RequestManager m3289a = Glide.with(this);
            java.lang.String str3 = vendor.card;
           // m3289a.load(str3 != null ? Util.m345e(str3) : this.f9555b0.getResources().getDrawable(R.drawable.vendor)).diskCacheStrategy(DiskCacheStrategy.ALL).m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) this.f9555b0, 5)), true).load(this.f9555b0.getResources().getDrawable(R.drawable.vendor)).into((ImageView) this.f9556c0.findViewById(R.id.vendor_card_img));
            ((AppCompatImageView) this.f9556c0.findViewById(R.id.iv_wishlist)).setImageResource(ProductVendorVM.m5577a(vendor.f12449id) ? R.drawable.ic_wishlist_full : R.drawable.ic_wishlist_empty);
            this.f9556c0.findViewById(R.id.mrl_add_to_wishlist).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentVendorDescription.this.m5102a(vendor, view);
                }
            });
            ArrayList<Category> arrayList = new ArrayList();
            for (int i2 : vendor.categories) {
                for (Category category : (List<Category>) Objects.requireNonNull(CategoryVM.listMutableLiveData.getValue())) {
                    if (category.f12393id == i2) {
                        arrayList.add(category);
                    }
                }
            }
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.f9556c0.findViewById(R.id.ll_categories);
            @SuppressLint("RestrictedApi") FlowLayout flowLayout = new FlowLayout(this.f9555b0);
            for (final Category category2 : arrayList) {
                ButtonToggle buttonToggle = new ButtonToggle(this.f9555b0);
                buttonToggle.setText(category2.name);
                buttonToggle.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FragmentVendorDescription.this.m5100a(category2, view);
                    }
                });
                buttonToggle.m6893a(1, 10.5f);
                LinearLayoutCompat linearLayoutCompat2 = new LinearLayoutCompat(this.f9555b0);
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                c0541a.setMargins(Util.dp2px((Context) this.f9555b0, 3), Util.dp2px((Context) this.f9555b0, 5), Util.dp2px((Context) this.f9555b0, 3), Util.dp2px((Context) this.f9555b0, 5));
                linearLayoutCompat2.addView(buttonToggle, c0541a);
                flowLayout.addView(linearLayoutCompat2);
            }
            linearLayoutCompat.addView(flowLayout);
            java.lang.String str4 = vendor.description;
            if (str4 == null || str4.isEmpty()) {
                return;
            }
            LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) this.f9556c0.findViewById(R.id.ll_description);
            LinearLayoutCompat3 c2058p = new LinearLayoutCompat3(this.f9555b0, "");
            c2058p.setItem(vendor.description);
            linearLayoutCompat3.addView(c2058p);
            linearLayoutCompat3.setVisibility(View.VISIBLE);
        }
    }

    
    public  void m5102a(Vendor vendor, View view) {
        ProductVendorVM.m5576a(vendor.f12449id, vendor);
        ((AppCompatImageView) this.f9556c0.findViewById(R.id.iv_wishlist)).setImageResource(ProductVendorVM.m5577a(vendor.f12449id) ? R.drawable.ic_wishlist_full : R.drawable.ic_wishlist_empty);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_vendor_info")) {
            return;
        }
        try {
            VendorActivity.f11940N.setValue( new Gson().fromJson(str, new a(this).getType()));
            m5101a(VendorActivity.f11940N.getValue());
            this.f9555b0.m6791K();
            this.f9556c0.findViewById(R.id.nsv_shimmer).setVisibility(View.GONE);
            this.f9556c0.findViewById(R.id.nsv_main).setVisibility(View.VISIBLE);
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            this.f9555b0.finish();
        }
    }
}
