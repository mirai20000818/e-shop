package com.jeil.emarket.frag.ticket.ticket;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.ticket.list.TicketUserListActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.adapters.ticket.TicketAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.c.a.f */

public class FragmentGetTicketList extends FragmentlTicketSearch implements BaseInterface, BaseInterface2 {

    /* renamed from: B0 */
    public TicketAdapter f9589B0;

    /* renamed from: C0 */
    public boolean f9590C0 = true;

    /* renamed from: b.f.a.g.c.a.f$a */
    public class a extends TypeToken<List<Ticket>> {
        public a(FragmentGetTicketList c2479f) {
        }
    }

    public FragmentGetTicketList() {
    }

    public FragmentGetTicketList(java.lang.String str, BaseActivity activityC1391g1, InterfaceString interfaceString) {
        this.jsonObject = new JSONObject();
        this.f9599v0.f9604a = str;
        m5127c1();
        this.baseActivity = activityC1391g1;
        this.f9594q0 = interfaceString;
        this.f9602y0.add("cv");
        this.f9602y0.add("cm");
    }

    @Override // p078b.p159f.p160a.p231g.p240c.p241a.C2480g, p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9589B0 = new TicketAdapter(this.baseActivity, this);
            this.xRecyclerView.setAdapter(this.f9589B0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f9590C0;
            xRecyclerView.f12377b1 = true;
            m5124a1();
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9590C0) {
            ArrayList arrayList = new ArrayList();
            Ticket ticket = new Ticket();
            ticket.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(ticket);
            }
            this.f9589B0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9592o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_ticket_list", this).get("e6/tickets", this.jsonObject);
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
        if (this.f9590C0) {
            ArrayList arrayList = new ArrayList();
            Ticket ticket = new Ticket();
            ticket.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(ticket);
            }
            TicketAdapter c1898k = this.f9589B0;
            c1898k.arrayList = arrayList;
            c1898k.notifyDataSetChanged();
        } else {
            TicketAdapter c1898k2 = this.f9589B0;
            c1898k2.arrayList = new ArrayList();
            c1898k2.notifyDataSetChanged();
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
        new API_PROVIDER(this.baseActivity, "get_ticket_list", this).get("e6/tickets", this.jsonObject);
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
                this.f9589B0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9589B0.addAll(list);
                } else if (this.f9590C0) {
                    this.f9589B0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9589B0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9589B0.getItemCount() == 0) {
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

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, java.lang.String str, int i2) {
        FragmentPagerAdaperEx fragmentPagerAdaperEx = ((TicketUserListActivity) this.baseActivity).f11939J;
        for (int i3 = 0; i3 < Math.min(Status.f8822m.length, fragmentPagerAdaperEx.getCount()); i3++) {
            if (((FragmentGetTicketList) fragmentPagerAdaperEx.get(i3)).m5119e1() != null) {
                ((FragmentGetTicketList) fragmentPagerAdaperEx.get(i3)).mo4891W0();
            }
        }
        return true;
    }

    /* renamed from: e1 */
    public TicketAdapter m5119e1() {
        return this.f9589B0;
    }
}
