package com.jeil.emarket.frag.main.vendor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.model.vendor.VendorShipping;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.order.VendorShippingAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.g.b.a.e1 */

public class FragmentShippingList extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public VendorShippingAdapter f9204o0;

    /* renamed from: p0 */
    public java.lang.String f9205p0;

    /* renamed from: q0 */
    public InterfaceString f9206q0;

    /* renamed from: r0 */
    public boolean f9207r0 = true;

    /* renamed from: b.f.a.g.b.a.e1$a */
    public class a extends TypeToken<List<VendorShipping>> {
        public a(FragmentShippingList c2299e1) {
        }
    }

    public FragmentShippingList() {
    }

    public FragmentShippingList(java.lang.String str, InterfaceString interfaceString, BaseActivity activityC1391g1) {
        this.f9205p0 = str;
        this.baseActivity = activityC1391g1;
        try {
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9206q0 = interfaceString;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        XRecyclerView xRecyclerView;
        ItemDecoration2 itemDecoration2;
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9204o0 = new VendorShippingAdapter((BaseActivity) getActivity(), this.f9205p0);
            this.xRecyclerView.setAdapter(this.f9204o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.f12375Z0 = this.f9207r0;
            if (this.f9205p0.equals("shipping")) {
                xRecyclerView = this.xRecyclerView;
                itemDecoration2 = new ItemDecoration2(BaseActivity.anInt2, -1, true, true);
            } else {
                xRecyclerView = this.xRecyclerView;
                itemDecoration2 = new ItemDecoration2(0, -1, true);
            }
            xRecyclerView.addItemDecoration(itemDecoration2);
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_location);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(this.f9205p0.equals("shipping") ? R.string.empty_pending_shipping : R.string.nomore_loading);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.cl_header).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9207r0) {
            ArrayList arrayList = new ArrayList();
            VendorShipping vendorShipping = new VendorShipping();
            vendorShipping.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(vendorShipping);
            }
            this.f9204o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        new API_PROVIDER(this.baseActivity, "get_shipping_list", this).get("e6/deliveries", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: W0 */
    public void mo4891W0() {
        super.mo4891W0();
        if (SimpleVM.f8836d || this.f9148l0) {
            //this.xRecyclerView.m2806j(0);
        } else {
            this.f9137a0 = 0;
        }
        if (this.f9207r0) {
            ArrayList arrayList = new ArrayList();
            VendorShipping vendorShipping = new VendorShipping();
            vendorShipping.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(vendorShipping);
            }
            VendorShippingAdapter c1812d1 = this.f9204o0;
            c1812d1.arrayList = arrayList;
            c1812d1.notifyDataSetChanged();
        } else {
            VendorShippingAdapter c1812d12 = this.f9204o0;
            c1812d12.arrayList = new ArrayList();
            c1812d12.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
            jSONObject.put("status", this.f9205p0);
            this.jsonObject.put("filter", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_shipping_list", this).get("e6/deliveries", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_shipping_list")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9204o0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9204o0.addAll(list);
                } else if (this.f9207r0) {
                    this.f9204o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9204o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9204o0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (this.f9138b0 != 0 && this.f9205p0.equals("completed")) {
                this.baseActivity.findViewById(R.id.tv_timeline_track).setVisibility(View.VISIBLE);
            }
            if (!jSONObject.has("stats") || this.f9206q0 == null) {
                return;
            }
            this.f9206q0.mo4265a(jSONObject.getString("stats"));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
