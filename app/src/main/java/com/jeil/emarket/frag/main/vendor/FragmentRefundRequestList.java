package com.jeil.emarket.frag.main.vendor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.account.RefundRequestsActivity;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.model.customer.RefundRequestProduct;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.refund.RefundRequestAdapter;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.g.b.a.c1 */

public class FragmentRefundRequestList extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: o0 */
    public RefundRequestAdapter f9180o0;

    /* renamed from: q0 */
    public InterfaceString f9182q0;

    /* renamed from: s0 */
    public java.lang.String f9184s0;

    /* renamed from: t0 */
    public DialogC2001j f9185t0;

    /* renamed from: p0 */
    public JSONObject f9181p0 = new JSONObject();

    /* renamed from: r0 */
    public boolean f9183r0 = true;

    /* renamed from: b.f.a.g.b.a.c1$a */
    public class a extends TypeToken<List<RefundRequestProduct>> {
        public a(FragmentRefundRequestList c2293c1) {
        }
    }

    public FragmentRefundRequestList() {
    }

    public FragmentRefundRequestList(BaseActivity activityC1391g1, java.lang.String str, InterfaceString interfaceString) {
        this.f9184s0 = str;
        this.baseActivity = activityC1391g1;
        this.jsonObject = new JSONObject();
        try {
            this.f9181p0.put("status", str);
            this.jsonObject.put("filter", this.f9181p0.toString());
            this.jsonObject.put("page", this.f9137a0);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9182q0 = interfaceString;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9180o0 = new RefundRequestAdapter((BaseActivity) getActivity(), this);
            this.xRecyclerView.setAdapter(this.f9180o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9183r0;
            if (this.f9184s0.equals("completed") || this.f9184s0.equals("cancelled")) {
                View inflate = getLayoutInflater().inflate(R.layout.layout_top_search, (ViewGroup) null);
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
                int i = BaseActivity.anInt2;
                c0541a.setMargins(i, 0, i, 0);
                CustomString.m3167a(inflate, R.id.llc_date_picker, 8, R.id.mrl_help_link, 8);
                final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_search);
                editForm.setPlaceHolder(getResources().getString(R.string.refund_product_placeholder));
                editForm.setInputType(1);
                editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.w0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FragmentRefundRequestList.this.m4914a(editForm, view);
                    }
                });
                editForm.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.b.a.u0
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                        return FragmentRefundRequestList.this.m4916a(editForm, textView, i2, keyEvent);
                    }
                });
                inflate.setLayoutParams(c0541a);
                this.xRecyclerView.addView(inflate);
            }
            View inflate2 = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((com.jeil.emarket.components.textview.TextView) inflate2.findViewById(R.id.tv_empty_title)).setText(R.string.empty_refunds);
            ((AppCompatImageView) inflate2.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_refunds);
            this.xRecyclerView.setEmptyView(inflate2);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9183r0) {
            ArrayList arrayList = new ArrayList();
            RefundRequestProduct refundRequestProduct = new RefundRequestProduct();
            refundRequestProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(refundRequestProduct);
            }
            this.f9180o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9181p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_refund_requests", this).get("e6/refund", this.jsonObject);
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
        if (this.f9183r0) {
            ArrayList arrayList = new ArrayList();
            RefundRequestProduct refundRequestProduct = new RefundRequestProduct();
            refundRequestProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(refundRequestProduct);
            }
            RefundRequestAdapter c1766x = this.f9180o0;
            c1766x.arrayList = arrayList;
            c1766x.notifyDataSetChanged();
        } else {
            RefundRequestAdapter c1766x2 = this.f9180o0;
            c1766x2.arrayList = new ArrayList();
            c1766x2.notifyDataSetChanged();
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
        new API_PROVIDER(getContext(), "get_refund_requests", this).get("e6/refund", this.jsonObject);
    }

    /* renamed from: Z0 */
    public RefundRequestAdapter m4913Z0() {
        return this.f9180o0;
    }


    public  void m4914a(EditForm editForm, View view) {
        m4917b(editForm.getText());
    }


    public  void m4915a(java.lang.String str, DialogError dialogError) {
        new API_PROVIDER(getContext(), "cancel_refund_request", this).put("e6/refund/" + str, null);
        this.f9185t0 = new DialogC2001j(this.baseActivity);
        this.f9185t0.show();
        dialogError.dismiss();
    }


    public  boolean m4916a(EditForm editForm, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m4917b(editForm.getText());
        return true;
    }


    public void m4917b(java.lang.String str) {
        this.f9137a0 = 0;
        try {
            this.f9181p0.put("search", str);
            this.jsonObject.put("filter", this.f9181p0.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, final java.lang.String str, int i2) {
        final DialogError dialogError = new DialogError(getActivity());
        dialogError.f8246v = getResources().getString(R.string.cancel_refund_request);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new DialogCancel(dialogError), new DialogInterface() { // from class: b.f.a.g.b.a.v0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                FragmentRefundRequestList.this.m4915a(str, dialogError);
            }
        });
        return true;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (!str2.equals("get_refund_requests")) {
            if (str2.equals("cancel_refund_request")) {
                this.f9185t0.dismiss();
                if (i == 200) {
                    ((RefundRequestsActivity) this.baseActivity).m6370I();
                    return;
                }
                return;
            }
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9180o0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9180o0.addAll(list);
                } else if (this.f9183r0) {
                    this.f9180o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9180o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9180o0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (!jSONObject.has("stats") || this.f9182q0 == null) {
                return;
            }
            this.f9182q0.mo4265a(jSONObject.getString("stats"));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_failed, "error");
            this.baseActivity.finish();
        }
    }
}
