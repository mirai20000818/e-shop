package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.ReviewAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.customer.Review;
import com.jeil.emarket.model.vendor.VendorReviewCount;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.d.b.u3 */

public class C2664u3 extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public ReviewAdapter f9998o0;

    /* renamed from: q0 */
    public View f10000q0;

    /* renamed from: s0 */
    public InterfaceString f10002s0;

    /* renamed from: p0 */
    public JSONObject f9999p0 = new JSONObject();

    /* renamed from: r0 */
    public boolean f10001r0 = true;

    /* renamed from: b.f.a.g.d.b.u3$a */
    public class a extends TypeToken<List<Review>> {
        public a(C2664u3 c2664u3) {
        }
    }

    /* renamed from: b.f.a.g.d.b.u3$b */
    public class b extends TypeToken<VendorReviewCount> {
        public b(C2664u3 c2664u3) {
        }
    }

    public C2664u3(BaseActivity activityC1391g1, java.lang.String str, InterfaceString interfaceString) {
        this.baseActivity = activityC1391g1;
        try {
            this.f9999p0.put("status", str);
            this.f9999p0.put("withCount", true);
            this.jsonObject.put("filter", this.f9999p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f10002s0 = interfaceString;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
           // this.f9998o0 = new ReviewAdapter(this.baseActivity, (FragmentVendorListPage) this.f3693w);
            this.xRecyclerView.setAdapter(this.f9998o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f10001r0;
            xRecyclerView.f12377b1 = true;
            this.f10000q0 = getLayoutInflater().inflate(R.layout.layout_vendor_review_point, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            int i = BaseActivity.anInt2;
            c0541a.setMargins(i, 0, i, 0);
            this.f10000q0.setLayoutParams(c0541a);
            this.xRecyclerView.addView(this.f10000q0);
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_star_full);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_review);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.header).getMeasuredHeight() + this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f10001r0) {
            ArrayList arrayList = new ArrayList();
            Review review = new Review();
            review.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(review);
            }
            this.f9998o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9999p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_vendor_reviews", this).get("e7/reviews", this.jsonObject);
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
        if (this.f10001r0) {
            ArrayList arrayList = new ArrayList();
            Review review = new Review();
            review.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(review);
            }
            ReviewAdapter c1979y1 = this.f9998o0;
            c1979y1.arrayList = arrayList;
            c1979y1.notifyDataSetChanged();
        } else {
            ReviewAdapter c1979y12 = this.f9998o0;
            c1979y12.arrayList = new ArrayList();
            c1979y12.notifyDataSetChanged();
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
        new API_PROVIDER(this.baseActivity, "get_vendor_reviews", this).get("e7/reviews", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    @SuppressLint({"SetTextI18n"})

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_vendor_reviews")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            VendorReviewCount vendorReviewCount = (VendorReviewCount) new Gson().fromJson(jSONObject.getString("count"), new b(this).getType());
            ((TextView) this.f10000q0.findViewById(R.id.ctv_avg_point)).setText(vendorReviewCount.totalAvgRating + "");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9998o0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9998o0.addAll(list);
                } else if (this.f10001r0) {
                    this.f9998o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9998o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9998o0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (this.f10002s0 != null) {
                this.f10002s0.mo4265a(new Gson().toJson(vendorReviewCount.status));
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
