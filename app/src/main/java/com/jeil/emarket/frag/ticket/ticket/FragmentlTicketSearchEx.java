package com.jeil.emarket.frag.ticket.ticket;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.ticket.TicketAdapter1;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.g.c.a.h */

public class FragmentlTicketSearchEx extends FragmentlTicketSearch implements BaseInterface {

    /* renamed from: B0 */
    public TicketAdapter1 f9609B0;

    /* renamed from: C0 */
    public boolean f9610C0 = true;

    /* renamed from: b.f.a.g.c.a.h$a */
    public class a extends TypeToken<List<Ticket>> {
        public a(FragmentlTicketSearchEx fragmentlTicketSearchEx) {
        }
    }

    public FragmentlTicketSearchEx() {
    }

    public FragmentlTicketSearchEx(java.lang.String str, BaseActivity activityC1391g1, java.lang.String str2, InterfaceString interfaceString) {
        List<java.lang.String> list;
        java.lang.String str3;
        this.jsonObject = new JSONObject();
        this.f9599v0.f9604a = str;
        this.baseActivity = activityC1391g1;
        this.f9594q0 = interfaceString;
        this.f9591A0 = ((Vendor) Objects.requireNonNull(VendorListVM.f10363d.getValue())).f12449id;
        this.f9603z0 = str2;
        m5127c1();
        if (str2.equals("user")) {
            this.f9602y0 = new ArrayList();
            list = this.f9602y0;
            str3 = "cv";
        } else {
            if (!str2.equals("market")) {
                return;
            }
            this.f9602y0 = new ArrayList();
            list = this.f9602y0;
            str3 = "vm";
        }
        list.add(str3);
    }

    @Override // p078b.p159f.p160a.p231g.p240c.p241a.C2480g, p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        m5120Z0();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9609B0 = new TicketAdapter1(this.baseActivity, Boolean.valueOf(this.f9603z0.equals("user")));
            this.xRecyclerView.setAdapter(this.f9609B0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9610C0;
            m5125b1();
            m5124a1();
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9610C0) {
            ArrayList arrayList = new ArrayList();
            Ticket ticket = new Ticket();
            ticket.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(ticket);
            }
            this.f9609B0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9592o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_ticket_list", this).get("e7/tickets", this.jsonObject);
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
        if (this.f9610C0) {
            ArrayList arrayList = new ArrayList();
            Ticket ticket = new Ticket();
            ticket.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(ticket);
            }
            TicketAdapter1 c1899l = this.f9609B0;
            c1899l.arrayList = arrayList;
            c1899l.notifyDataSetChanged();
        } else {
            TicketAdapter1 c1899l2 = this.f9609B0;
            c1899l2.arrayList = new ArrayList();
            c1899l2.notifyDataSetChanged();
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
        new API_PROVIDER(this.baseActivity, "get_ticket_list", this).get("e7/tickets", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_ticket_list")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9609B0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9609B0.addAll(list);
                } else if (this.f9610C0) {
                    this.f9609B0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9609B0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9609B0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (!jSONObject.has("count") || this.f9594q0 == null) {
                return;
            }
            this.f9594q0.mo4265a(jSONObject.getString("count"));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }

    @Override // p078b.p159f.p160a.p231g.p240c.p241a.C2480g
    /* renamed from: d1 */
    public void mo5128d1() {
        try {
            this.f9592o0.put("status", this.f9599v0.f9604a.equals("all") ? "" : this.f9599v0.f9604a);
            this.f9592o0.put("startDate", this.f9599v0.f9607d);
            this.f9592o0.put("endDate", this.f9599v0.f9608e);
            this.f9592o0.put("categoryId", this.f9599v0.f9605b);
            this.f9592o0.put("search", this.f9599v0.f9606c);
            this.f9592o0.put("receiver", this.f9603z0);
            this.f9592o0.put("vendorId", this.f9603z0.equals("user") ? this.f9591A0 : 0);
            this.jsonObject.put("filter", this.f9592o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e1 */
    public TicketAdapter1 m5131e1() {
        return this.f9609B0;
    }
}
