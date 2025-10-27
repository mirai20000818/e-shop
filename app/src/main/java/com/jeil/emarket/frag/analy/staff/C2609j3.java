package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.FeeHistoryAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.vendor.FeeHistory;
import com.jeil.emarket.model.vendor.FeeHistoryTotal;
import com.jeil.emarket.model.vendor.FeeTotal;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.d.b.j3 */

public class C2609j3 extends BaseFragment implements BaseInterface {

    /* renamed from: p0 */
    public View f9847p0;

    /* renamed from: q0 */
    public FeeHistoryAdapter f9848q0;

    /* renamed from: o0 */
    public boolean f9846o0 = true;

    /* renamed from: r0 */
    public JSONObject f9849r0 = new JSONObject();

    /* renamed from: b.f.a.g.d.b.j3$a */
    public class a extends TypeToken<List<FeeHistory>> {
        public a(C2609j3 c2609j3) {
        }
    }

    /* renamed from: b.f.a.g.d.b.j3$b */
    public class b extends TypeToken<FeeTotal> {
        public b(C2609j3 c2609j3) {
        }
    }

    /* renamed from: b.f.a.g.d.b.j3$c */
    public class c extends TypeToken<FeeHistoryTotal> {
        public c(C2609j3 c2609j3) {
        }
    }

    public C2609j3() {
    }

    public C2609j3(BaseActivity activityC1391g1) {
        try {
            this.f9849r0.put("startDate", Util.date2Str(new Date(new Date().getYear(), 0, 1)));
            this.f9849r0.put("endDate", Util.date2Str(new Date()));
            this.f9849r0.put("type", "");
            this.jsonObject.put("filter", this.f9849r0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("stats", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9848q0 = new FeeHistoryAdapter(this.baseActivity);
            this.xRecyclerView.setAdapter(this.f9848q0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f9846o0;
            xRecyclerView.f12377b1 = true;
            this.f9847p0 = getLayoutInflater().inflate(R.layout.layout_fee_history_info_box, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            this.f9847p0.findViewById(R.id.pt_kpf_fee_amount).setVisibility(View.GONE);
            this.f9847p0.findViewById(R.id.pt_kpw_fee_amount).setVisibility(View.GONE);
            int i = BaseActivity.anInt2;
            c0541a.setMargins(i, 0, i, 0);
            this.f9847p0.setLayoutParams(c0541a);
            this.f9847p0.measure(((LinearLayout.LayoutParams) c0541a).width, ((LinearLayout.LayoutParams) c0541a).height);
            this.xRecyclerView.addView(this.f9847p0);
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_products);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9846o0) {
            ArrayList arrayList = new ArrayList();
            FeeHistory feeHistory = new FeeHistory();
            feeHistory.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(feeHistory);
            }
            this.f9848q0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9849r0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_fee_history", this).get("e7/finance/fee", this.jsonObject);
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
        if (this.f9846o0) {
            ArrayList arrayList = new ArrayList();
            FeeHistory feeHistory = new FeeHistory();
            feeHistory.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(feeHistory);
            }
            FeeHistoryAdapter c1946n1 = this.f9848q0;
            c1946n1.arrayList = arrayList;
            c1946n1.notifyDataSetChanged();
        } else {
            FeeHistoryAdapter c1946n12 = this.f9848q0;
            c1946n12.arrayList = new ArrayList();
            c1946n12.notifyDataSetChanged();
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
        new API_PROVIDER(getContext(), "get_fee_history", this).get("e7/finance/fee", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    @SuppressLint({"SetTextI18n"})

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_fee_history")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            FeeTotal feeTotal = (FeeTotal) new Gson().fromJson(jSONObject.getString("fee"), new b(this).getType());
            FeeHistoryTotal feeHistoryTotal = (FeeHistoryTotal) new Gson().fromJson(jSONObject.getString("total"), new c(this).getType());
            PriceText priceText = (PriceText) this.f9847p0.findViewById(R.id.pt_kpf_fee_amount);
            PriceText priceText2 = (PriceText) this.f9847p0.findViewById(R.id.pt_kpw_fee_amount);
            priceText.setHidePriceNumber(false);
            priceText2.setHidePriceNumber(false);
            if (feeHistoryTotal.kpf - feeTotal.kpfTotal > 0.0f && feeHistoryTotal.kpw - feeTotal.kpwTotal > 0.0f) {
                priceText2.f12264t = true;
            }
            float f = feeHistoryTotal.kpf;
            float f2 = feeTotal.kpfTotal;
            if (f - f2 > 0.0f) {
                priceText.setPrice(Util.m327c(f - f2));
                priceText.setVisibility(View.VISIBLE);
            }
            float f3 = feeHistoryTotal.kpw;
            float f4 = feeTotal.kpwTotal;
            if (f3 - f4 > 0.0f) {
                priceText2.setPrice(Util.m327c(f3 - f4));
                priceText2.setVisibility(View.VISIBLE);
            }
            if (feeHistoryTotal.kpf - feeTotal.kpfTotal == 0.0f && feeHistoryTotal.kpw - feeTotal.kpwTotal == 0.0f) {
                if (VendorListVM.f10363d.getValue() != null) {
                    if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                        priceText2.setPrice("0");
                        priceText2.setVisibility(View.VISIBLE);
                    } else if (!VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                        priceText2.f12264t = true;
                        priceText2.setPrice("0");
                        priceText2.setVisibility(View.VISIBLE);
                    }
                }
                priceText.setPrice("0");
                priceText.setVisibility(View.VISIBLE);
            }
            Util.setColor(this.baseActivity, (android.widget.TextView) this.f9847p0.findViewById(R.id.ctv_fee_amount_label), R.color.dark);
            this.f9847p0.findViewById(R.id.ctv_shimmer_fee_amount).setVisibility(View.GONE);
            ((ShimmerFrameLayout) this.f9847p0.findViewById(R.id.sfl_shimmer)).hideShimmer();
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9848q0.addAll(list);
                return;
            }
            if (this.f9137a0 == 0) {
                this.f9848q0.addAll(list);
            } else if (this.f9846o0) {
                this.f9848q0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
            } else {
                this.f9848q0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
            }
            if (list.size() == 0) {
                this.xRecyclerView.setNoMore(true);
            }
            if (this.f9848q0.getItemCount() == 0) {
                this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
