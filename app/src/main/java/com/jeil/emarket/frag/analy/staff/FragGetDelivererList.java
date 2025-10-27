package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.VendorStaffActivity;
import com.jeil.emarket.adapters.shipping.StaffAdapter1;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.vendor.Staff;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.d.b.i3 */

public class FragGetDelivererList extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: p0 */
    public StaffAdapter1 f9836p0;

    /* renamed from: r0 */
    public InterfaceString f9838r0;

    /* renamed from: o0 */
    public boolean f9835o0 = true;

    /* renamed from: q0 */
    public JSONObject f9837q0 = new JSONObject();

    /* renamed from: b.f.a.g.d.b.i3$a */
    public class a extends TypeToken<List<Staff>> {
        public a(FragGetDelivererList c2604i3) {
        }
    }

    public FragGetDelivererList() {
    }

    public FragGetDelivererList(BaseActivity activityC1391g1, InterfaceString interfaceString) {
        try {
            this.f9837q0.put("search", "");
            this.jsonObject.put("filter", this.f9837q0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9838r0 = interfaceString;
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9836p0 = new StaffAdapter1(this.baseActivity, this);
            this.xRecyclerView.setAdapter(this.f9836p0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9835o0;
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_staff);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_deliverer_list);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9835o0) {
            ArrayList arrayList = new ArrayList();
            Staff staff = new Staff();
            staff.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(staff);
            }
            this.f9836p0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9837q0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_deliverer_list", this).get("e7/deliverers", this.jsonObject);
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
        if (this.f9835o0) {
            ArrayList arrayList = new ArrayList();
            Staff staff = new Staff();
            staff.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(staff);
            }
            StaffAdapter1 c1934j1 = this.f9836p0;
            c1934j1.arrayList = arrayList;
            c1934j1.notifyDataSetChanged();
        } else {
            StaffAdapter1 c1934j12 = this.f9836p0;
            c1934j12.arrayList = new ArrayList();
            c1934j12.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        try {
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_deliverer_list", this).get("e7/deliverers", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_deliverer_list")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ((VendorStaffActivity) this.baseActivity).f11886b0 = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9836p0.addAll((List) ((VendorStaffActivity) this.baseActivity).f11886b0);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9836p0.addAll((List) ((VendorStaffActivity) this.baseActivity).f11886b0);
                } else if (this.f9835o0) {
                    this.f9836p0.addModList((List) ((VendorStaffActivity) this.baseActivity).f11886b0, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9836p0.addModList((List) ((VendorStaffActivity) this.baseActivity).f11886b0, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (((VendorStaffActivity) this.baseActivity).f11886b0.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9836p0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            this.f9838r0.mo4265a(this.f9138b0 + "");
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, java.lang.String str, int i2) {
        this.f9137a0 = 0;
        mo4891W0();
        return true;
    }

    
    public void m5226b(java.lang.String str) throws JSONException {
        this.f9137a0 = 0;
        this.f9837q0.put("search", str);
        this.jsonObject.put("filter", this.f9837q0.toString());
        mo4891W0();
    }
}
