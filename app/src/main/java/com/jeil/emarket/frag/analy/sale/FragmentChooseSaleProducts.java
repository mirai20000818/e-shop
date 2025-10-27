package com.jeil.emarket.frag.analy.sale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
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
import com.jeil.emarket.adapters.shipping.FBTAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.FBT;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.d.c.o */

public class FragmentChooseSaleProducts extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: o0 */
    public JSONObject f10099o0;

    /* renamed from: p0 */
    public boolean f10100p0;

    /* renamed from: q0 */
    public DialogC2001j f10101q0;

    /* renamed from: r0 */
    public FBTAdapter f10102r0;

    /* renamed from: b.f.a.g.d.c.o$a */
    public class a extends TypeToken<List<FBT>> {
        public a(FragmentChooseSaleProducts c2704o) {
        }
    }

    public FragmentChooseSaleProducts() {
        this.f10099o0 = new JSONObject();
        this.f10100p0 = true;
    }

    public FragmentChooseSaleProducts(BaseActivity activityC1391g1) {
        this.f10099o0 = new JSONObject();
        this.f10100p0 = true;
        this.baseActivity = activityC1391g1;
        this.f10099o0 = new JSONObject();
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f10102r0 = new FBTAdapter((BaseActivity) getActivity(), this);
            this.xRecyclerView.setAdapter(this.f10102r0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f10100p0;
            final View inflate = getLayoutInflater().inflate(R.layout.layout_choose_sale_products, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            int i = BaseActivity.anInt2;
            c0541a.setMargins(i, 0, i, 0);
            final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_search);
            if (Build.VERSION.SDK_INT >= 26) {
                editForm.setFocusedByDefault(false);
            }
            editForm.setPlaceHolder(getResources().getString(R.string.FBT_placeholder));
            editForm.setInputType(1);
            ((EditForm) inflate.findViewById(R.id.cef_search)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.c.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentChooseSaleProducts.this.m5385a(inflate, view);
                }
            });
            ((EditForm) inflate.findViewById(R.id.cef_search)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.d.c.f
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return FragmentChooseSaleProducts.this.m5386a(inflate, textView, i2, keyEvent);
                }
            });
            inflate.setLayoutParams(c0541a);
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.c.g
                @Override // java.lang.Runnable
                public final void run() {
                    editForm.setVisibility(View.VISIBLE);
                }
            }, 80L);
            this.xRecyclerView.addView(inflate);
            View inflate2 = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((com.jeil.emarket.components.textview.TextView) inflate2.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
            ((AppCompatImageView) inflate2.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_products);
            this.xRecyclerView.setEmptyView(inflate2);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f10100p0) {
            ArrayList arrayList = new ArrayList();
            FBT fbt = new FBT();
            fbt.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(fbt);
            }
            this.f10102r0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f10099o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_fbt_list", this).get("e7/fbt", this.jsonObject);
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
        if (this.f10100p0) {
            ArrayList arrayList = new ArrayList();
            FBT fbt = new FBT();
            fbt.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(fbt);
            }
            FBTAdapter c1937k1 = this.f10102r0;
            c1937k1.arrayList = arrayList;
            c1937k1.notifyDataSetChanged();
        } else {
            FBTAdapter c1937k12 = this.f10102r0;
            c1937k12.arrayList = new ArrayList();
            c1937k12.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        this.jsonObject = new JSONObject();
        try {
            this.jsonObject.put("filter", this.f10099o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_fbt_list", this).get("e7/fbt", this.jsonObject);
    }

    /* renamed from: Z0 */
    public FBTAdapter m5384Z0() {
        return this.f10102r0;
    }


    public  void m5385a(@SuppressLint({"InflateParams"}) View view, View view2) {
        m5387b(((EditForm) view.findViewById(R.id.cef_search)).getText());
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, java.lang.String str, int i2) {
        this.f10101q0 = new DialogC2001j(this.baseActivity);
        this.f10101q0.show();
        new API_PROVIDER(this.baseActivity, "delete_fbt", this).delete("e7/fbt/" + str, (JSONObject) null);
        return true;
    }


    public  boolean m5386a(@SuppressLint({"InflateParams"}) View view, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m5387b(((EditForm) view.findViewById(R.id.cef_search)).getText());
        return true;
    }

    
    public void m5387b(java.lang.String str) {
        this.f9137a0 = 0;
        try {
            this.f10099o0.put("search", str);
            this.jsonObject.put("filter", this.f10099o0.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }

    
    public void m5388c(int i) {
        if (i != 0) {
            this.f10101q0 = new DialogC2001j(this.baseActivity);
            this.f10101q0.show();
            new API_PROVIDER(this.baseActivity, "delete_fbt", this).delete("e7/fbt/" + i, (JSONObject) null);
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (!str2.equals("get_fbt_list")) {
            if (str2.equals("delete_fbt")) {
                this.f9137a0 = 0;
                mo4891W0();
                this.f10101q0.dismiss();
                return;
            }
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (this.f10102r0 != null) {
                if (SimpleVM.f8836d) {
                    m4892X0();
                    this.f10102r0.addAll(list);
                    return;
                }
                if (this.f9137a0 == 0) {
                    this.f10102r0.addAll(list);
                } else if (this.f10100p0) {
                    this.f10102r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f10102r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f10102r0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_failed, "error");
            this.baseActivity.finish();
        }
    }
}
