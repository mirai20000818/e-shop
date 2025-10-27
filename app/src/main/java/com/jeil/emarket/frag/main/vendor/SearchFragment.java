package com.jeil.emarket.frag.main.vendor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.vendor.VendorActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.vendor.VendorPoint;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.model.customer.Point;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.model.vendor.VendorPointCount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.point.PointAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.g.b.a.a1 */

public class SearchFragment extends BaseFragment implements BaseInterface {

    /* renamed from: r0 */
    public PointAdapter f9158r0;

    /* renamed from: t0 */
    public java.lang.String f9160t0;

    /* renamed from: u0 */
    public Bundle f9161u0;

    /* renamed from: v0 */
    public View f9162v0;

    /* renamed from: w0 */
    public InterfaceString f9163w0;

    /* renamed from: o0 */
    public HashMap<java.lang.String, java.lang.String> f9155o0 = new HashMap<>();

    /* renamed from: p0 */
    public List<java.lang.String> f9156p0 = new ArrayList();

    /* renamed from: q0 */
    public List<TextView> f9157q0 = new ArrayList();

    /* renamed from: s0 */
    public JSONObject f9159s0 = new JSONObject();

    /* renamed from: x0 */
    public boolean f9164x0 = true;

    /* renamed from: y0 */
    public java.lang.String f9165y0 = "updated_at";

    /* renamed from: b.f.a.g.b.a.a1$a */
    public class a extends TypeToken<List<Point>> {
        public a(SearchFragment searchFragment) {
        }
    }

    /* renamed from: b.f.a.g.b.a.a1$b */
    public class b extends TypeToken<VendorPointCount> {
        public b(SearchFragment searchFragment) {
        }
    }

    public SearchFragment(BaseActivity activityC1391g1, java.lang.String str, java.lang.String str2, Bundle bundle, List<Integer> list, List<Integer> list2, List<Integer> list3, InterfaceString interfaceString) {
        this.baseActivity = activityC1391g1;
        this.f9160t0 = str2;
        this.f9161u0 = bundle;
        try {
            if (!this.f9160t0.equals("vendorPoint")) {
                this.f9159s0.put("sortBy", "updated_at");
                this.f9159s0.put("sortDir", "desc");
                this.f9159s0.put("type", str2);
            }
            this.f9159s0.put("withCount", true);
            this.f9159s0.put("status", str);
            if (this.f9160t0.equals("vendor")) {
                this.f9159s0.put("vendor", this.f9161u0.getInt("vendorId"));
                this.f9159s0.put("support", list);
                this.f9159s0.put("service", list2);
                this.f9159s0.put("delivery", list3);
            } else if (this.f9160t0.equals("account") && this.f9161u0.getInt("pointId") != 0) {
                this.f9159s0.put("id", this.f9161u0.getInt("pointId"));
            }
            this.jsonObject.put("filter", this.f9159s0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9163w0 = interfaceString;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        this.f9155o0.put(getResources().getString(R.string.sort_updated_at), "updated_at");
        this.f9155o0.put(getResources().getString(R.string.sort_support_point), "support");
        this.f9155o0.put(getResources().getString(R.string.sort_service_point), "service");
        this.f9155o0.put(getResources().getString(R.string.sort_shipping_point), "delivery");
        this.f9156p0.add(getResources().getString(R.string.sort_updated_at));
        this.f9156p0.add(getResources().getString(R.string.sort_support_point));
        this.f9156p0.add(getResources().getString(R.string.sort_service_point));
        this.f9156p0.add(getResources().getString(R.string.sort_shipping_point));
        int i = 0;
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9158r0 = new PointAdapter(this.baseActivity, this.f9160t0);
            this.xRecyclerView.setAdapter(this.f9158r0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9164x0;
            if (this.f9160t0.equals("vendorPoint") || this.f9160t0.equals("vendor")) {
                this.xRecyclerView.f12377b1 = true;
            }
            this.f9162v0 = getLayoutInflater().inflate(this.f9160t0.equals("vendorPoint") ? R.layout.item_vendor_point_box : this.f9160t0.equals("vendor") ? R.layout.item_vendor_point : R.layout.layout_top_sort, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            c0541a.setMargins(this.f9160t0.equals("account") ? 0 : BaseActivity.anInt2, 0, this.f9160t0.equals("account") ? 0 : BaseActivity.anInt2, 0);
            if (this.f9160t0.equals("account")) {
                final int i2 = 0;
                while (i2 < this.f9155o0.size()) {
                    final TextView textView = new TextView(this.baseActivity);
                    textView.setBackgroundResource(i2 == 0 ? R.drawable.bd_round_button : R.drawable.bd_round_white_button);
                    textView.setTextColor(getResources().getColor(i2 == 0 ? R.color.white : R.color.dark));
                    textView.setPadding(Util.dp2px((Context) this.baseActivity, 13), Util.dp2px((Context) this.baseActivity, 7), Util.dp2px((Context) this.baseActivity, 13), Util.dp2px((Context) this.baseActivity, 7));
                    textView.setTextSize(1, 11.0f);
                    textView.setText(this.f9156p0.get(i2));
                    LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    if (i2 == 0) {
                        c0541a2.setMargins(Util.dp2px((Context) this.baseActivity, 10), 0, Util.dp2px((Context) this.baseActivity, 5), 0);
                    } else {
                        c0541a2.setMargins(0, 0, i2 != this.f9155o0.size() - 1 ? Util.dp2px((Context) this.baseActivity, 5) : Util.dp2px((Context) this.baseActivity, 10), 0);
                    }
                    textView.setLayoutParams(c0541a2);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.q0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SearchFragment.this.m4905a(textView, i2, view);
                        }
                    });
                    ((LinearLayoutCompat) this.f9162v0.findViewById(R.id.llc_sort_items)).addView(textView);
                    this.f9157q0.add(textView);
                    i2++;
                }
            }
            this.f9162v0.setLayoutParams(c0541a);
            if (this.f9160t0.equals("vendor") && VendorActivity.f11940N.getValue() != null) {
                View view = this.f9162v0;
                MutableLiveData<Vendor> mutableLiveData = VendorActivity.f11940N;
                if (mutableLiveData != null && mutableLiveData.getValue() != null) {
                    ((VendorPoint) view.findViewById(R.id.vp_support)).m6980a(VendorActivity.f11940N.getValue().supportPoint.floatValue(), VendorActivity.f11940N.getValue().avgSupportPoint.floatValue());
                    ((VendorPoint) view.findViewById(R.id.vp_service)).m6980a(VendorActivity.f11940N.getValue().servicePoint.floatValue(), VendorActivity.f11940N.getValue().avgServicePoint.floatValue());
                    ((VendorPoint) view.findViewById(R.id.vp_delivery)).m6980a(VendorActivity.f11940N.getValue().deliveryPoint.floatValue(), VendorActivity.f11940N.getValue().avgDeliveryPoint.floatValue());
                    ((ProgressBar) view.findViewById(R.id.pb_progress_support)).setProgress((int) ((VendorActivity.f11940N.getValue().supportPoint.floatValue() * 100.0f) / 5.0f));
                    ((ProgressBar) view.findViewById(R.id.pb_progress_service)).setProgress((int) ((VendorActivity.f11940N.getValue().servicePoint.floatValue() * 100.0f) / 5.0f));
                    ((ProgressBar) view.findViewById(R.id.pb_progress_delivery)).setProgress((int) ((VendorActivity.f11940N.getValue().deliveryPoint.floatValue() * 100.0f) / 5.0f));
                }
            }
            this.xRecyclerView.addView(this.f9162v0);
        }
        View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.baseActivity.findViewById(R.id.llc_point_header_tab);
        ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_star_full);
        ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_review);
        this.xRecyclerView.setEmptyView(inflate);
        XRecyclerView xRecyclerView = this.xRecyclerView;
        int measuredHeight = this.baseActivity.findViewById(R.id.header).getMeasuredHeight();
        if (this.f9160t0.equals("vendorPoint")) {
            i = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight();
        } else if (linearLayoutCompat != null) {
            i = linearLayoutCompat.getMeasuredHeight();
        }
        this.f9160t0.equals("vendorPoint");
        xRecyclerView.header = measuredHeight + i + ((int) getResources().getDimension(R.dimen.bottom_height));
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9164x0) {
            ArrayList arrayList = new ArrayList();
            Point point = new Point();
            point.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(point);
            }
            this.f9158r0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9159s0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_points", this).get(this.f9160t0.equals("vendorPoint") ? "e7/points" : this.f9160t0.equals("account") ? "e6/points" : "e6/vendor/points", this.jsonObject);
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
        if (this.f9164x0) {
            ArrayList arrayList = new ArrayList();
            Point point = new Point();
            point.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(point);
            }
            PointAdapter c1886f = this.f9158r0;
            c1886f.arrayList = arrayList;
            c1886f.notifyDataSetChanged();
        } else {
            PointAdapter c1886f2 = this.f9158r0;
            c1886f2.arrayList = new ArrayList();
            c1886f2.notifyDataSetChanged();
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
        new API_PROVIDER(this.baseActivity, "get_points", this).get(this.f9160t0.equals("vendorPoint") ? "e7/points" : this.f9160t0.equals("account") ? "e6/points" : "e6/vendor/points", this.jsonObject);
    }


    public  void m4905a(TextView textView, int i, View view) {
        for (int i2 = 0; i2 < this.f9157q0.size(); i2++) {
            Util.m310b((Context) this.baseActivity, (View) this.f9157q0.get(i2));
        }
        Util.m233a((Context) this.baseActivity, (View) textView);
        java.lang.String str = this.f9155o0.get(this.f9156p0.get(i));
        if (this.f9165y0.equals(str)) {
            return;
        }
        this.f9165y0 = str;
        try {
            this.f9159s0.put("sortBy", str);
            this.jsonObject.put("filter", this.f9159s0.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    public final void m4906a(VendorPointCount vendorPointCount) {
        ((VendorPoint) this.f9162v0.findViewById(R.id.vp_support)).m6980a(vendorPointCount.vendorSupportPoint, Float.parseFloat(vendorPointCount.marketPoint.support));
        ((VendorPoint) this.f9162v0.findViewById(R.id.vp_service)).m6980a(vendorPointCount.vendorServicePoint, Float.parseFloat(vendorPointCount.marketPoint.service));
        ((VendorPoint) this.f9162v0.findViewById(R.id.vp_delivery)).m6980a(vendorPointCount.vendorDeliveryPoint, Float.parseFloat(vendorPointCount.marketPoint.delivery));
        ((TextView) this.f9162v0.findViewById(R.id.ctv_vendor_point)).setText(Util.m217a(vendorPointCount.vendorPoint));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m4907a(List<Integer> list) {
        this.f9137a0 = 0;
        this.f9159s0.put("service", list);
        this.jsonObject.put("filter", this.f9159s0.toString());
        mo4891W0();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m4908b(List<Integer> list) {
        this.f9137a0 = 0;
        this.f9159s0.put("delivery", list);
        this.jsonObject.put("filter", this.f9159s0.toString());
        mo4891W0();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m4909c(List<Integer> list) {
        this.f9137a0 = 0;
        this.f9159s0.put("support", list);
        this.jsonObject.put("filter", this.f9159s0.toString());
        mo4891W0();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        InterfaceString interfaceString;
        java.lang.String string;
        if (str == null || str.length() <= 0 || !str2.equals("get_points")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            VendorPointCount vendorPointCount = null;
            if (this.f9160t0.equals("vendorPoint")) {
                vendorPointCount = (VendorPointCount) new Gson().fromJson(jSONObject.getString("count"), new b(this).getType());
                m4906a(vendorPointCount);
            }
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9158r0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9158r0.addAll(list);
                } else if (this.f9164x0) {
                    this.f9158r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9158r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9158r0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (this.f9160t0.equals("vendorPoint") && vendorPointCount != null && this.f9163w0 != null) {
                interfaceString = this.f9163w0;
                string = new Gson().toJson(vendorPointCount.status);
            } else if (this.f9160t0.equals("vendor") && jSONObject.has("total") && this.f9163w0 != null) {
                interfaceString = this.f9163w0;
                string = jSONObject.getInt("total") + "";
            } else {
                if (!this.f9160t0.equals("account") || !jSONObject.has("count") || this.f9163w0 == null) {
                    return;
                }
                interfaceString = this.f9163w0;
                string = jSONObject.getString("count");
            }
            interfaceString.mo4265a(string);
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
