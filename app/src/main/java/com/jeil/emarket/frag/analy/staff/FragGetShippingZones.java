package com.jeil.emarket.frag.analy.staff;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.ShippingZoneAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.ShippingZone;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.d.b.y3 */

public class FragGetShippingZones extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: o0 */
    public JSONObject f10056o0 = new JSONObject();

    /* renamed from: p0 */
    public boolean f10057p0 = true;

    /* renamed from: q0 */
    public DialogC2001j f10058q0;

    /* renamed from: r0 */
    public ShippingZoneAdapter f10059r0;

    /* renamed from: b.f.a.g.d.b.y3$a */
    public class a extends TypeToken<List<ShippingZone>> {
        public a(FragGetShippingZones c2684y3) {
        }
    }

    public FragGetShippingZones() {
    }

    public FragGetShippingZones(BaseActivity activityC1391g1, java.lang.String str) {
        this.baseActivity = activityC1391g1;
        try {
            this.f10056o0.put("search", str);
            this.f10056o0.put("timestamp", "");
            this.f10056o0.put("withCount", true);
            this.jsonObject.put("filter", this.f10056o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f10059r0 = new ShippingZoneAdapter(this.baseActivity, this);
            this.xRecyclerView.setAdapter(this.f10059r0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.setPullRefreshEnabled(false);
            this.xRecyclerView.f12375Z0 = this.f10057p0;
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            int i = BaseActivity.anInt1;
            int dimension = (int) this.baseActivity.getResources().getDimension(R.dimen.empty_wrapper_space);
            int i2 = ((i / 2) - 0) - 0;
            int i3 = BaseActivity.anInt2;
            int i4 = dimension / 2;
            inflate.setPadding(0, ((i2 - i3) - i4) / 2, 0, ((i2 - i3) - i4) / 2);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_location);
            this.xRecyclerView.setEmptyView(inflate);
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f10057p0) {
            ArrayList arrayList = new ArrayList();
            ShippingZone shippingZone = new ShippingZone();
            shippingZone.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(shippingZone);
            }
            this.f10059r0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f10056o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_shipping_zones", this).get("e7/shipping/zones", this.jsonObject);
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
        if (this.f10057p0) {
            ArrayList arrayList = new ArrayList();
            ShippingZone shippingZone = new ShippingZone();
            shippingZone.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(shippingZone);
            }
            ShippingZoneAdapter c1904a2 = this.f10059r0;
            c1904a2.arrayList = arrayList;
            c1904a2.notifyDataSetChanged();
        } else {
            ShippingZoneAdapter c1904a22 = this.f10059r0;
            c1904a22.arrayList = new ArrayList();
            c1904a22.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        this.jsonObject = new JSONObject();
        try {
            this.jsonObject.put("filter", this.f10056o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_shipping_zones", this).get("e7/shipping/zones", this.jsonObject);
    }

    /* renamed from: Z0 */
    public ShippingZoneAdapter m5371Z0() {
        return this.f10059r0;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (!str2.equals("get_shipping_zones")) {
            if (str2.equals("delete_shipping_zone")) {
                this.f10058q0.dismiss();
                this.f9137a0 = 0;
                mo4891W0();
                return;
            }
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (this.f10059r0 != null) {
                if (SimpleVM.f8836d) {
                    m4892X0();
                    this.f10059r0.addAll(list);
                    return;
                }
                if (this.f9137a0 == 0) {
                    this.f10059r0.addAll(list);
                } else if (this.f10057p0) {
                    this.f10059r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f10059r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f10059r0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_failed, "error");
            this.baseActivity.finish();
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, java.lang.String str, int i2) {
        this.f10058q0 = new DialogC2001j(this.baseActivity);
        this.f10058q0.show();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("zoneIds", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "delete_shipping_zone", this).delete("e7/shipping/zones", jSONObject);
        return true;
    }


    public void m5372b(java.lang.String str) throws JSONException {
        this.f9137a0 = 0;
        this.f10056o0.put("search", str);
        this.jsonObject.put("filter", this.f10056o0.toString());
        mo4891W0();
    }
}
