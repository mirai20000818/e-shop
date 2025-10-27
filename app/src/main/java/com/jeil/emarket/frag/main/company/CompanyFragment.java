package com.jeil.emarket.frag.main.company;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.vendor.Vendor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.VendorAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.ProductVendorVM;

/* renamed from: b.f.a.g.b.f.a */

public class CompanyFragment extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public VendorAdapter vendorAdapter;

    /* renamed from: p0 */
    public List<Integer> f9580p0 = new ArrayList();

    /* renamed from: q0 */
    public boolean f9581q0 = true;

    /* renamed from: r0 */
    public int f9582r0 = 0;

    /* renamed from: b.f.a.g.b.f.a$a */
    public class a extends TypeToken<List<Vendor>> {
        public a(CompanyFragment companyFragment) {
        }
    }

    public CompanyFragment(BaseActivity activityC1391g1) {
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            this.baseActivity.getBaseContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.vendorAdapter = new VendorAdapter(this.baseActivity);
            this.xRecyclerView.setAdapter(this.vendorAdapter);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true, true));
            this.xRecyclerView.f12375Z0 = this.f9581q0;
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -2));
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_vendor);
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_wishlist_empty);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9581q0) {
            ArrayList arrayList = new ArrayList();
            Vendor vendor = new Vendor();
            for (int i = 0; i < 6; i++) {
                arrayList.add(vendor);
            }
            this.vendorAdapter.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            int size = this.f9580p0.size();
            this.f9582r0 = this.f9580p0.size();
            int i2 = (this.f9137a0 + 1) * 20;
            if (size > i2) {
                size = i2;
            }
            this.jsonObject.put("ids", this.f9580p0.subList(i2 - 20, size));
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_vendor_data", this).get("e6/vendors", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: W0 */
    public void mo4891W0() {
        super.mo4891W0();
        if (this.xRecyclerView != null) {
            if (SimpleVM.f8836d || this.f9148l0) {
               //?? //this.xRecyclerView.m2806j(0);
            } else {
                this.f9137a0 = 0;
            }
            if (this.f9581q0) {
                ArrayList arrayList = new ArrayList();
                Vendor vendor = new Vendor();
                vendor.type = "shimmer";
                for (int i = 0; i < 6; i++) {
                    arrayList.add(vendor);
                }
                VendorAdapter c1912c2 = this.vendorAdapter;
                c1912c2.arrayList = arrayList;
                c1912c2.notifyDataSetChanged();
            } else {
                VendorAdapter c1912c22 = this.vendorAdapter;
                c1912c22.arrayList = new ArrayList();
                c1912c22.notifyDataSetChanged();
                View view = this.xRecyclerView.view;
                if (view instanceof LinearLayoutEx) {
                    ((LinearLayoutEx) view).setState(0);
                }
                this.xRecyclerView.f12360K0.setVisibility(View.GONE);
            }
            try {
                int size = this.f9580p0.size();
                this.f9582r0 = this.f9580p0.size();
                int i2 = (this.f9137a0 + 1) * 20;
                if (size > i2) {
                    size = i2;
                }
                this.jsonObject.put("ids", this.f9580p0.subList(i2 - 20, size));
                this.jsonObject.put("page", this.f9137a0 + 1);
                this.jsonObject.put("perPage", 20);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f9582r0 != 0) {
                new API_PROVIDER(this.baseActivity, "get_vendor_data", this).get("e6/vendors", this.jsonObject);
                return;
            }
            VendorAdapter c1912c23 = this.vendorAdapter;
            c1912c23.arrayList = new ArrayList();
            c1912c23.notifyDataSetChanged();
            this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
            this.xRecyclerView.setNoMore(true);
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        MutableLiveData<List<Integer>> mutableLiveData;
        ArrayList arrayList;
        new ArrayList();
        if (str == null || str.length() <= 0 || !str2.equals("get_vendor_data")) {
            return;
        }
        m4889U0();
        try {
            List list = (List) new Gson().fromJson(new JSONObject(str).getString("rows"), new a(this).getType());
            this.f9138b0 = this.f9582r0;
            ArrayList arrayList2 = new ArrayList();
            List<Integer> getValue = ProductVendorVM.f10377e.getValue();
            if (list.size() != 0 && getValue != null && getValue.size() != 0) {
                for (int i2 = 0; i2 < getValue.size(); i2++) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        if (((Vendor) list.get(i3)).f12449id == getValue.get(i2).intValue()) {
                            arrayList2.add(list.get(i3));
                        }
                    }
                }
            }
            if (SimpleVM.f8836d) {
                m4892X0();
                VendorAdapter c1912c2 = this.vendorAdapter;
                c1912c2.arrayList = arrayList2;
                c1912c2.notifyDataSetChanged();
                if (arrayList2.size() != 0) {
                    return;
                }
                mutableLiveData = ProductVendorVM.f10377e;
                arrayList = new ArrayList();
            } else {
                if (this.f9137a0 == 0) {
                    VendorAdapter c1912c22 = this.vendorAdapter;
                    c1912c22.arrayList = arrayList2;
                    c1912c22.notifyDataSetChanged();
                } else if (this.f9581q0) {
                    this.vendorAdapter.addModList((List) arrayList2, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.vendorAdapter.addModList((List) arrayList2, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (arrayList2.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.vendorAdapter.getItemCount() != 0) {
                    return;
                }
                this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                mutableLiveData = ProductVendorVM.f10377e;
                arrayList = new ArrayList();
            }
            mutableLiveData.setValue( arrayList);
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }
}
