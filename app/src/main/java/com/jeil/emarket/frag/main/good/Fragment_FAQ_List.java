package com.jeil.emarket.frag.main.good;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Faq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.fbt.FaqAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.g.b.c.o0 */

public class Fragment_FAQ_List extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: o0 */
    public FaqAdapter f9446o0;

    /* renamed from: p0 */
    public int f9447p0;

    /* renamed from: q0 */
    public boolean f9448q0 = true;


    public Fragment_FAQ_List() {
    }

    public Fragment_FAQ_List(BaseActivity activityC1391g1, int i) {
        this.f9447p0 = i;
        this.baseActivity = activityC1391g1;
        this.f9149m0 = true;
        try {
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9446o0 = new FaqAdapter(this.baseActivity, "show", this);
            this.xRecyclerView.setAdapter(this.f9446o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9448q0;
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((ImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_question_circle);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(getResources().getString(R.string.nomore_loading));
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.llc_footer).getMeasuredHeight() + this.baseActivity.findViewById(R.id.rl_header_tabs).getMeasuredHeight();
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9448q0) {
            ArrayList arrayList = new ArrayList();
            Faq faq = new Faq();
            faq.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(faq);
            }
            this.f9446o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        API_PROVIDER APIS = new API_PROVIDER(getContext(), "get_faq_list", this);
        StringBuilder m3163a = CustomString.format("e6/faq/products/");
        m3163a.append(this.f9447p0);
        APIS.get(m3163a.toString(), this.jsonObject);
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
        if (this.f9448q0) {
            ArrayList arrayList = new ArrayList();
            Faq faq = new Faq();
            faq.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(faq);
            }
            FaqAdapter c1875o = this.f9446o0;
            c1875o.arrayList = arrayList;
            c1875o.notifyDataSetChanged();
        } else {
            FaqAdapter c1875o2 = this.f9446o0;
            c1875o2.arrayList = new ArrayList();
            c1875o2.notifyDataSetChanged();
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
        API_PROVIDER APIS = new API_PROVIDER(getContext(), "get_faq_list", this);
        StringBuilder m3163a = CustomString.format("e6/faq/products/");
        m3163a.append(this.f9447p0);
        APIS.get(m3163a.toString(), this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_faq_list")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new TypeToken<List<Faq>>(){}.getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (!this.f9149m0 && (!SimpleVM.f8836d || this.f9148l0)) {
                if (this.f9137a0 == 0) {
                    this.f9446o0.addAll(list);
                } else if (this.f9448q0) {
                    this.f9446o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9446o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9446o0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                    return;
                }
                return;
            }
            m4892X0();
            this.f9446o0.addAll(list);
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, java.lang.String str, int i2) {
        return true;
    }
}
