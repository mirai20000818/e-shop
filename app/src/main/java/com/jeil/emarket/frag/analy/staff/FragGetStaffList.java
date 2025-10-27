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
import com.jeil.emarket.adapters.shipping.StaffAdapter;
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

/* renamed from: b.f.a.g.d.b.z3 */

public class FragGetStaffList extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: p0 */
    public StaffAdapter f10069p0;

    /* renamed from: r0 */
    public InterfaceString f10071r0;

    /* renamed from: o0 */
    public boolean f10068o0 = true;

    /* renamed from: q0 */
    public JSONObject f10070q0 = new JSONObject();

    /* renamed from: b.f.a.g.d.b.z3$a */
    public class a extends TypeToken<List<Staff>> {
        public a(FragGetStaffList c2689z3) {
        }
    }

    public FragGetStaffList() {
    }

    public FragGetStaffList(BaseActivity activityC1391g1, InterfaceString interfaceString) {
        try {
            this.f10070q0.put("search", "");
            this.f10070q0.put("role", "");
            this.f10070q0.put("channel", "");
            this.f10070q0.put("mask", "");
            this.jsonObject.put("filter", this.f10070q0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f10071r0 = interfaceString;
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f10069p0 = new StaffAdapter(this.baseActivity, this);
            this.xRecyclerView.setAdapter(this.f10069p0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f10068o0;
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_staff);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_staff_list);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f10068o0) {
            ArrayList arrayList = new ArrayList();
            Staff staff = new Staff();
            staff.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(staff);
            }
            this.f10069p0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f10070q0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_staff_list", this).get("e7/employees", this.jsonObject);
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
        if (this.f10068o0) {
            ArrayList arrayList = new ArrayList();
            Staff staff = new Staff();
            staff.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(staff);
            }
            StaffAdapter c1908b2 = this.f10069p0;
            c1908b2.arrayList = arrayList;
            c1908b2.notifyDataSetChanged();
        } else {
            StaffAdapter c1908b22 = this.f10069p0;
            c1908b22.arrayList = new ArrayList();
            c1908b22.notifyDataSetChanged();
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
        new API_PROVIDER(getContext(), "get_staff_list", this).get("e7/employees", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_staff_list")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f10069p0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f10069p0.addAll(list);
                } else if (this.f10068o0) {
                    this.f10069p0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f10069p0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f10069p0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            this.f10071r0.mo4265a(this.f9138b0 + "");
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }


    public void m5373a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) throws JSONException {
        this.f9137a0 = 0;
        this.f10070q0.put("search", str);
        this.f10070q0.put("role", str2);
        this.f10070q0.put("channel", str3);
        this.f10070q0.put("mask", i);
        this.jsonObject.put("filter", this.f10070q0.toString());
        mo4891W0();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, java.lang.String str, int i2) {
        this.f9137a0 = 0;
        mo4891W0();
        return true;
    }
}
