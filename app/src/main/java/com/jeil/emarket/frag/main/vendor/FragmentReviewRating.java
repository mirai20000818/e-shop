package com.jeil.emarket.frag.main.vendor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Review;
import com.jeil.emarket.model.customer.ReviewRating;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.point.ReviewAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.g.b.a.d1 */

public class FragmentReviewRating extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public HashMap<String, String> f9189o0;

    /* renamed from: p0 */
    public List<String> f9190p0;

    /* renamed from: q0 */
    public List<TextView> f9191q0;

    /* renamed from: r0 */
    public ReviewAdapter f9192r0;

    /* renamed from: s0 */
    public JSONObject f9193s0;

    /* renamed from: t0 */
    public String f9194t0;

    /* renamed from: u0 */
    public Bundle f9195u0;

    /* renamed from: v0 */
    public InterfaceString f9196v0;

    /* renamed from: w0 */
    public MutableLiveData<ReviewRating> f9197w0;

    /* renamed from: x0 */
    public boolean f9198x0;

    /* renamed from: y0 */
    public String f9199y0;

    /* renamed from: b.f.a.g.b.a.d1$a */
    public class a extends TypeToken<List<Review>> {
        public a(FragmentReviewRating c2296d1) {
        }
    }

    /* renamed from: b.f.a.g.b.a.d1$b */
    public class b extends TypeToken<ReviewRating> {
        public b(FragmentReviewRating c2296d1) {
        }
    }

    public FragmentReviewRating() {
        this.f9189o0 = new HashMap<>();
        this.f9190p0 = new ArrayList();
        this.f9191q0 = new ArrayList();
        this.f9193s0 = new JSONObject();
        this.f9194t0 = "detail";
        this.f9198x0 = true;
        this.f9199y0 = "updated_at";
    }

    public FragmentReviewRating(BaseActivity activityC1391g1, String str, String str2, Bundle bundle, List<Integer> list, InterfaceString interfaceString) {
        this.f9189o0 = new HashMap<>();
        this.f9190p0 = new ArrayList();
        this.f9191q0 = new ArrayList();
        this.f9193s0 = new JSONObject();
        this.f9194t0 = "detail";
        this.f9198x0 = true;
        this.f9199y0 = "updated_at";
        this.baseActivity = activityC1391g1;
        this.f9194t0 = str2;
        this.f9195u0 = bundle;
        this.f9197w0 = new MutableLiveData<>();
        try {
            this.f9193s0.put("sortBy", "updated_at");
            this.f9193s0.put("sortDir", "desc");
            this.f9193s0.put("status", str);
            this.f9193s0.put("withCount", true);
            if (!this.f9194t0.equals("account")) {
                this.jsonObject.put("productId", this.f9195u0.getInt("productId"));
                this.f9193s0.put("type", str2);
                this.f9193s0.put("rating", list);
            } else if (this.f9195u0.getInt("reviewId") != 0) {
                this.f9193s0.put("id", this.f9195u0.getInt("reviewId"));
            }
            this.jsonObject.put("filter", this.f9193s0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9196v0 = interfaceString;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"UseCompatLoadingForDrawables", "InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        BaseActivity activityC1391g1;
        int i;
        super.showBootomMenu();
        this.f9189o0.put(getResources().getString(R.string.sort_updated_at), "updated_at");
        this.f9189o0.put(getResources().getString(R.string.sort_rating), "rating");
        this.f9190p0.add(getResources().getString(R.string.sort_updated_at));
        this.f9190p0.add(getResources().getString(R.string.sort_rating));
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            BaseActivity activityC1391g12 = (BaseActivity) getActivity();
            String str = this.f9194t0;
            this.f9192r0 = new ReviewAdapter(activityC1391g12, str, str.equals("detail") ? this.f9195u0.getString("productType") : "");
            this.xRecyclerView.setAdapter(this.f9192r0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.f12375Z0 = this.f9198x0;
            if (this.f9194t0.equals("detail")) {
                this.xRecyclerView.setFooterHeight(false);
            }
            if (this.f9194t0.equals("account")) {
                this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
                
                View inflate = getLayoutInflater().inflate(R.layout.layout_top_sort, (ViewGroup) null);
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
                c0541a.setMargins(this.f9194t0.equals("account") ? 0 : BaseActivity.anInt2, 0, 0, 0);
                int i2 = 0;
                while (i2 < this.f9189o0.size()) {
                    final TextView textView = new TextView(getActivity());
                    textView.setBackgroundResource(i2 == 0 ? R.drawable.bd_round_button : R.drawable.bd_round_white_button);
                    textView.setTextColor(getResources().getColor(i2 == 0 ? R.color.white : R.color.dark));
                    textView.setPadding(Util.dp2px((Context) getActivity(), 13), Util.dp2px((Context) getActivity(), 7), Util.dp2px((Context) getActivity(), 13), Util.dp2px((Context) getActivity(), 7));
                    textView.setTextSize(1, 11.0f);
                    textView.setText(this.f9190p0.get(i2));
                    LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    if (i2 == 0) {
                        c0541a2.setMargins(Util.dp2px((Context) getActivity(), 10), 0, Util.dp2px((Context) getActivity(), 5), 0);
                    }
                    textView.setLayoutParams(c0541a2);
                    int finalI = i2;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.x0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FragmentReviewRating.this.m4919a(textView, finalI, view);
                        }
                    });
                    ((LinearLayoutCompat) inflate.findViewById(R.id.llc_sort_items)).addView(textView);
                    this.f9191q0.add(textView);
                    i2++;
                }
                inflate.setLayoutParams(c0541a);
                this.xRecyclerView.addView(inflate);
            } else if (this.f9194t0.equals("detail")) {
                this.xRecyclerView.m6994L();
                this.xRecyclerView.setNestedScrollingEnabled(false);
            }
            View inflate2 = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate2.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f));
            ((AppCompatImageView) inflate2.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_star_full);
            ((TextView) inflate2.findViewById(R.id.tv_empty_title)).setText(R.string.empty_review);
            this.xRecyclerView.setEmptyView(inflate2);
            XRecyclerView xRecyclerView = this.xRecyclerView;
            if (this.f9194t0.equals("detail")) {
                activityC1391g1 = this.baseActivity;
                i = R.id.rl_header_tabs;
            } else {
                activityC1391g1 = this.baseActivity;
                i = R.id.header_scroll;
            }
            xRecyclerView.header = activityC1391g1.findViewById(i).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9198x0) {
            ArrayList arrayList = new ArrayList();
            Review review = new Review();
            review.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(review);
            }
            this.f9192r0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9193s0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_reviews", this).get(this.f9194t0.equals("account") ? "e6/reviews" : "e6/reviews/products", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: W0 */
    public void mo4891W0() {
        super.mo4891W0();
        if (this.f9149m0 || SimpleVM.f8836d || this.f9148l0) {
            //this.xRecyclerView.m2806j(0);
        } else {
            this.f9137a0 = 0;
        }
        if (this.f9198x0) {
            ArrayList arrayList = new ArrayList();
            Review review = new Review();
            review.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(review);
            }
            ReviewAdapter c1887g = this.f9192r0;
            c1887g.arrayList = arrayList;
            c1887g.notifyDataSetChanged();
        } else {
            ReviewAdapter c1887g2 = this.f9192r0;
            c1887g2.arrayList = new ArrayList();
            c1887g2.notifyDataSetChanged();
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
        new API_PROVIDER(getContext(), "get_reviews", this).get(this.f9194t0.equals("account") ? "e6/reviews" : "e6/reviews/products", this.jsonObject);
    }

    /* renamed from: Z0 */
    public ReviewAdapter m4918Z0() {
        return this.f9192r0;
    }


    public  void m4919a(TextView textView, int i, View view) {
        for (int i2 = 0; i2 < this.f9191q0.size(); i2++) {
            Util.m310b((Context) getActivity(), (View) this.f9191q0.get(i2));
        }
        Util.setColorSize((Context) getActivity(), (View) textView);
        m4921b(this.f9189o0.get(this.f9190p0.get(i)));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m4920a(List<Integer> list) throws JSONException {
        this.f9137a0 = 0;
        this.f9193s0.put("rating", list);
        this.jsonObject.put("filter", this.f9193s0.toString());
        mo4891W0();
    }


    public void m4921b(String str) {
        if (this.f9199y0.equals(str)) {
            return;
        }
        this.f9137a0 = 0;
        this.f9199y0 = str;
        try {
            this.f9193s0.put("sortBy", str);
            this.jsonObject.put("filter", this.f9193s0.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m4922c(String str) throws JSONException {
        this.f9137a0 = 0;
        this.f9193s0.put("status", str);
        this.jsonObject.put("filter", this.f9193s0.toString());
        mo4891W0();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:9:0x0017, B:11:0x0043, B:13:0x0047, B:16:0x004c, B:18:0x0051, B:19:0x0078, B:21:0x007e, B:22:0x0083, B:24:0x008b, B:25:0x009b, B:27:0x00a1, B:29:0x00c2, B:30:0x0163, B:32:0x0169, B:34:0x016d, B:40:0x011c, B:42:0x0122, B:45:0x0128, B:48:0x0160, B:50:0x0057, B:52:0x005b, B:53:0x006a, B:54:0x0093), top: B:8:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:9:0x0017, B:11:0x0043, B:13:0x0047, B:16:0x004c, B:18:0x0051, B:19:0x0078, B:21:0x007e, B:22:0x0083, B:24:0x008b, B:25:0x009b, B:27:0x00a1, B:29:0x00c2, B:30:0x0163, B:32:0x0169, B:34:0x016d, B:40:0x011c, B:42:0x0122, B:45:0x0128, B:48:0x0160, B:50:0x0057, B:52:0x005b, B:53:0x006a, B:54:0x0093), top: B:8:0x0017 }] */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo4478a(java.lang.String r6, java.lang.String r7, int r8, android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p231g.p233b.p234a.C2296d1.mo4478a(java.lang.String, java.lang.String, int, android.content.Context):void");
    }
}
