package com.jeil.emarket.frag.main.vendor;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.intro.HelpDetailActivity;
import com.jeil.emarket.adapters.refund.RefundProductAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.customer.RefundProduct;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.b.a.b1 */

public class SearchFragmentBase extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public RefundProductAdapter f9170o0;

    /* renamed from: p0 */
    public JSONObject f9171p0 = new JSONObject();

    /* renamed from: q0 */
    public boolean f9172q0 = true;

    /* renamed from: b.f.a.g.b.a.b1$a */
    public class a extends TypeToken<List<RefundProduct>> {
        public a(SearchFragmentBase searchFragment1) {
        }
    }

    public SearchFragmentBase(BaseActivity activityC1391g1) {
        this.baseActivity = activityC1391g1;
        try {
            this.jsonObject.put("filter", this.f9171p0.toString());
            this.jsonObject.put("page", this.f9137a0);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9170o0 = new RefundProductAdapter((BaseActivity) getActivity());
            this.xRecyclerView.setAdapter(this.f9170o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9172q0;
            View inflate = getLayoutInflater().inflate(R.layout.layout_top_search, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            int i = BaseActivity.anInt2;
            c0541a.setMargins(i, 0, i, 0);
            inflate.setLayoutParams(c0541a);
            inflate.findViewById(R.id.llc_date_picker).setVisibility(View.GONE);
            inflate.findViewById(R.id.mrl_help_link).setVisibility(View.VISIBLE);
            inflate.findViewById(R.id.mrl_help_link).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchFragmentBase.this.m4912k(view);
                }
            });
            final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_search);
            editForm.setPlaceHolder(getResources().getString(R.string.refund_product_placeholder));
            editForm.setInputType(1);
            if (Build.VERSION.SDK_INT >= 26) {
                editForm.setFocusedByDefault(false);
            }
            editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchFragmentBase.this.m4910a(editForm, view);
                }
            });
            editForm.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.b.a.t0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return SearchFragmentBase.this.m4911a(editForm, textView, i2, keyEvent);
                }
            });
            this.xRecyclerView.addView(inflate);
            View inflate2 = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate2.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_box);
            ((com.jeil.emarket.components.textview.TextView) inflate2.findViewById(R.id.tv_empty_title)).setText(R.string.empty_shop);
            this.xRecyclerView.setEmptyView(inflate2);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.header).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9172q0) {
            ArrayList arrayList = new ArrayList();
            RefundProduct refundProduct = new RefundProduct();
            refundProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(refundProduct);
            }
            this.f9170o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9171p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_refund_products", this).get("e6/refund/available", this.jsonObject);
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
        if (this.f9172q0) {
            ArrayList arrayList = new ArrayList();
            RefundProduct refundProduct = new RefundProduct();
            refundProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(refundProduct);
            }
            RefundProductAdapter c1765w = this.f9170o0;
            c1765w.arrayList = arrayList;
            c1765w.notifyDataSetChanged();
        } else {
            RefundProductAdapter c1765w2 = this.f9170o0;
            c1765w2.arrayList = new ArrayList();
            c1765w2.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
        }
        try {
            this.jsonObject.put("filter", this.f9171p0.toString());
            this.jsonObject.put("page", this.f9137a0);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getActivity(), "get_refund_products", this).get("e6/refund/available", this.jsonObject);
    }


    public  void m4910a(EditForm editForm, View view) {
        java.lang.String text = editForm.getText();
        this.f9137a0 = 0;
        try {
            this.f9171p0.put("search", text);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }

    
    public  void m4912k(View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), HelpDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("index", 3);
        startActivity(intent, (Bundle) null);
    }


    public  boolean m4911a(EditForm editForm, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        java.lang.String text = editForm.getText();
        this.f9137a0 = 0;
        try {
            this.f9171p0.put("search", text);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
        return true;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_refund_products")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9170o0.addAll(list);
                return;
            }
            if (this.f9137a0 == 0) {
                this.f9170o0.addAll(list);
            } else if (this.f9172q0) {
                this.f9170o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
            } else {
                this.f9170o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
            }
            if (list.size() == 0) {
                this.xRecyclerView.setNoMore(true);
            }
            if (this.f9170o0.getItemCount() == 0) {
                this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_failed, "error");
            this.baseActivity.finish();
        }
    }
}
