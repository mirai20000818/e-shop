package com.jeil.emarket.frag.main.good;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.FBT;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.fbt.FBTAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration3;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.g.b.c.n0 */

public class Fragment_Tab_Border extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public FBTAdapter f9443o0;

    /* renamed from: p0 */
    public boolean f9444p0 = true;


    public Fragment_Tab_Border(BaseActivity activityC1391g1) {
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) this.baseActivity, 1, 1, false);
            this.f9443o0 = new FBTAdapter(this.baseActivity);
            this.xRecyclerView.setAdapter(this.f9443o0);
            this.xRecyclerView.setLayoutManager(gridLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration3(1, BaseActivity.anInt2, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f9444p0;
            xRecyclerView.setDrawingCacheEnabled(true);
            this.xRecyclerView.m6994L();
            new LinearLayoutCompat(this.baseActivity).setOrientation(LinearLayoutCompat.VERTICAL);
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
           ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_box);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.header).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        if (this.f9139c0) {
            return;
        }
        super.mo4890V0();
        if (this.f9444p0) {
            ArrayList arrayList = new ArrayList();
            FBT fbt = new FBT();
            fbt.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(fbt);
            }
            this.f9443o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("page", this.f9137a0 + 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_fbt_collections", this).get("e6/fbts/", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: W0 */
    public void mo4891W0() {
        super.mo4891W0();
        if (SimpleVM.f8836d || this.f9148l0) {
            //this.xRecyclerView.m2806j(0);
            NestedScrollView nestedScrollView = this.nsv_main;
            if (nestedScrollView != null) {
                nestedScrollView.m2444b(0, 0);
            }
        } else {
            this.f9137a0 = 0;
        }
        if (this.f9444p0) {
            ArrayList arrayList = new ArrayList();
            FBT fbt = new FBT();
            fbt.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(fbt);
            }
            FBTAdapter c1874n = this.f9443o0;
            c1874n.arrayList = arrayList;
            c1874n.notifyDataSetChanged();
        } else {
            FBTAdapter c1874n2 = this.f9443o0;
            c1874n2.arrayList = new ArrayList();
            c1874n2.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
        }
        try {
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("page", this.f9137a0 + 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_fbt_collections", this).get("e6/fbts/", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k, androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) super.onCreateView(layoutInflater, viewGroup, bundle);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.baseActivity);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        View view = new View(this.baseActivity);
        if (!SimpleVM.f8836d) {
            view.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, Util.dp2px((Context) this.baseActivity, 1) / 2));
            view.setBackgroundColor(getResources().getColor(R.color.border));
            view.setId(R.id.fragment_tab_border);
        }
        if (!SimpleVM.f8836d) {
            linearLayoutCompat.addView(view);
        }
        linearLayoutCompat.addView(coordinatorLayout);
        if (!SimpleVM.f8836d || this.f9148l0) {
            return linearLayoutCompat;
        }
        this.nsv_main = new NestedScrollView(this.baseActivity);
        this.nsv_main.setTag(Integer.valueOf(R.id.nsv_main));
        this.nsv_main.addView(linearLayoutCompat);
        return this.nsv_main;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_fbt_collections")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new TypeToken<List<FBT>>(){}.getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            this.f9443o0.f7572f = this.f9137a0;
            if (SimpleVM.f8836d && !this.f9148l0) {
                m4892X0();
                this.f9443o0.addAll(list);
                return;
            }
            if (this.f9137a0 == 0) {
                this.f9443o0.addAll(list);
            } else if (this.f9444p0) {
                this.f9443o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
            } else {
                this.f9443o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
            }
            if (list.size() == 0) {
                this.xRecyclerView.setNoMore(true);
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_failed, "error");
            this.baseActivity.finish();
        }
    }
}
