package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.RefundRequestProductAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.customer.RefundRequestProduct;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.g.d.b.t3 */

public class C2659t3 extends BaseFragment implements BaseInterface {

    /* renamed from: A0 */
    public InterfaceString f9977A0;

    /* renamed from: B0 */
    public boolean f9978B0;

    /* renamed from: o0 */
    public RefundRequestProductAdapter f9979o0;

    /* renamed from: p0 */
    public JSONObject f9980p0;

    /* renamed from: q0 */
    public BaseDialog2 f9981q0;

    /* renamed from: r0 */
    public MutableLiveData<java.lang.String> f9982r0;

    /* renamed from: s0 */
    public java.lang.String f9983s0;

    /* renamed from: t0 */
    public MutableLiveData<java.lang.String> f9984t0;

    /* renamed from: u0 */
    public Picker4 f9985u0;

    /* renamed from: v0 */
    public Date f9986v0;

    /* renamed from: w0 */
    public Date f9987w0;

    /* renamed from: x0 */
    public MutableLiveData<Date> f9988x0;

    /* renamed from: y0 */
    public MutableLiveData<Date> f9989y0;

    /* renamed from: z0 */
    public BaseDialog2 f9990z0;

    /* renamed from: b.f.a.g.d.b.t3$a */
    public class a extends TypeToken<List<RefundRequestProduct>> {
        public a(C2659t3 c2659t3) {
        }
    }

    public C2659t3() {
        this.f9980p0 = new JSONObject();
        this.f9982r0 = new MutableLiveData<>();
        this.f9983s0 = "";
        this.f9984t0 = new MutableLiveData<>("");
        this.f9986v0 = null;
        this.f9987w0 = null;
        this.f9988x0 = new MutableLiveData<>();
        this.f9989y0 = new MutableLiveData<>();
        this.f9990z0 = null;
        this.f9978B0 = true;
    }

    public C2659t3(BaseActivity activityC1391g1, java.lang.String str, InterfaceString interfaceString) {
        this.f9980p0 = new JSONObject();
        this.f9982r0 = new MutableLiveData<>();
        this.f9983s0 = "";
        this.f9984t0 = new MutableLiveData<>("");
        this.f9986v0 = null;
        this.f9987w0 = null;
        this.f9988x0 = new MutableLiveData<>();
        this.f9989y0 = new MutableLiveData<>();
        this.f9990z0 = null;
        this.f9978B0 = true;
        this.baseActivity = activityC1391g1;
        this.f9980p0 = new JSONObject();
        try {
            this.f9980p0.put("status", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9977A0 = interfaceString;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9979o0 = new RefundRequestProductAdapter((BaseActivity) getActivity());
            this.xRecyclerView.setAdapter(this.f9979o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9978B0;
            this.f9985u0 = new Picker4(getContext());
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_refunds);
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_refunds);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9978B0) {
            ArrayList arrayList = new ArrayList();
            RefundRequestProduct refundRequestProduct = new RefundRequestProduct();
            refundRequestProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(refundRequestProduct);
            }
            this.f9979o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9980p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_refund_requests", this).get("e7/refunds", this.jsonObject);
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
        if (this.f9978B0) {
            ArrayList arrayList = new ArrayList();
            RefundRequestProduct refundRequestProduct = new RefundRequestProduct();
            refundRequestProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(refundRequestProduct);
            }
            RefundRequestProductAdapter c1976x1 = this.f9979o0;
            c1976x1.arrayList = arrayList;
            c1976x1.notifyDataSetChanged();
        } else {
            RefundRequestProductAdapter c1976x12 = this.f9979o0;
            c1976x12.arrayList = new ArrayList();
            c1976x12.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        this.jsonObject = new JSONObject();
        try {
            this.jsonObject.put("filter", this.f9980p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_refund_requests", this).get("e7/refunds", this.jsonObject);
    }

    /* renamed from: Z0 */
    public RefundRequestProductAdapter m5331Z0() {
        return this.f9979o0;
    }


    public  void m5332a(@SuppressLint({"InflateParams"}) View view, View view2) {
        m5339l(view);
    }


    public  void m5333a(View view, View view2, int i) {
        ((TextView) view.findViewById(R.id.tv_refund_type)).setText(getResources().getString(i == 0 ? R.string.refund_type : i == 1 ? R.string.exchange : R.string.returnProduct));
        this.f9983s0 = i == 0 ? "" : i == 1 ? "exchange" : "return";
        this.f9990z0.startAni();
    }


    public  void m5334a(@SuppressLint({"InflateParams"}) View view, Date date, Date date2, View view2) {
        this.f9986v0 = date;
        this.f9987w0 = date2;
        ((TextView) view.findViewById(R.id.tv_date)).setText(Util.date2Str(this.f9986v0) + " ~ " + Util.date2Str(this.f9987w0));
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: a1 */
    public void m5335a1() {
        Resources m2475L;
        int i;
        java.lang.String[] strArr = new java.lang.String[0];
        final View inflate = getLayoutInflater().inflate(R.layout.dialog_refund_filter, (ViewGroup) null);
        inflate.findViewById(R.id.mrl_date_span).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2659t3.this.m5338k(view);
            }
        });
        this.f9985u0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.b.w1
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date, Date date2, View view) {
                C2659t3.this.m5334a(inflate, date, date2, view);
            }
        };
        inflate.findViewById(R.id.mrl_refund_type).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2659t3.this.m5332a(inflate, view);
            }
        });
        if (this.f9982r0.getValue() != null) {
            ((EditForm) inflate.findViewById(R.id.cef_search)).setText(this.f9982r0.getValue());
        }
        if (this.f9984t0.getValue() != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.tv_refund_type);
            if (this.f9984t0.getValue().equals("")) {
                m2475L = getResources();
                i = R.string.refund_type;
            } else if (this.f9984t0.getValue().equals("exchange")) {
                m2475L = getResources();
                i = R.string.exchange;
            } else {
                m2475L = getResources();
                i = R.string.returnProduct;
            }
            textView.setText(m2475L.getString(i));
        }
        if (this.f9988x0.getValue() != null && this.f9989y0.getValue() != null) {
            ((TextView) inflate.findViewById(R.id.tv_date)).setText(Util.date2Str(this.f9988x0.getValue()) + " ~ " + Util.date2Str(this.f9989y0.getValue()));
        }
        inflate.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2659t3.this.m5336b(inflate, view);
            }
        });
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2659t3.this.m5337c(inflate, view);
            }
        });
        this.f9981q0 = new BaseDialog2(getActivity(), strArr, inflate, 8388613);
        BaseDialog2 baseDialog2 = this.f9981q0;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.76f;
        baseDialog2.show();
    }


    public  void m5336b(@SuppressLint({"InflateParams"}) View view, View view2) {
        this.f9982r0.setValue("");
        this.f9984t0.setValue("");
        this.f9987w0 = null;
        this.f9986v0 = null;
        this.f9988x0.setValue( null);
        this.f9989y0.setValue( null);
        ((EditForm) view.findViewById(R.id.cef_search)).setText("");
        ((TextView) view.findViewById(R.id.tv_date)).setText("");
        ((TextView) view.findViewById(R.id.tv_refund_type)).setText("");
        try {
            this.f9980p0.put("search", "");
            this.f9980p0.put("startDate", "");
            this.f9980p0.put("endDate", "");
            this.f9980p0.put("refundType", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9137a0 = 0;
        mo4891W0();
        this.f9981q0.startAni();
    }


    public  void m5337c(@SuppressLint({"InflateParams"}) View view, View view2) {
        this.f9982r0.setValue(((EditForm) view.findViewById(R.id.cef_search)).getText());
        this.f9984t0.setValue(this.f9983s0);
        this.f9988x0.setValue( this.f9986v0);
        this.f9989y0.setValue( this.f9987w0);
        try {
            this.f9980p0.put("search", this.f9982r0.getValue() != null ? this.f9982r0.getValue() : "");
            this.f9980p0.put("startDate", this.f9988x0.getValue() != null ? Util.date2Str(this.f9988x0.getValue()) : "");
            this.f9980p0.put("endDate", this.f9989y0.getValue() != null ? Util.date2Str(this.f9989y0.getValue()) : "");
            this.f9980p0.put("refundType", this.f9984t0.getValue() != null ? this.f9984t0.getValue() : "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9137a0 = 0;
        mo4891W0();
        this.f9981q0.startAni();
    }

    
    public  void m5338k(View view) {
        this.f9985u0.m4704a();
    }

    /* renamed from: l */
    public void m5339l(final View view) {
        BaseActivity activityC1391g1 = (BaseActivity) getActivity();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 3) {
            Resources m2475L = getResources();
            arrayList.add(new Cancel_Obj(i == 0 ? m2475L.getString(R.string.refund_type) : i == 1 ? m2475L.getString(R.string.exchange) : m2475L.getString(R.string.returnProduct), ((TextView) view.findViewById(R.id.tv_refund_type)).getText().equals(i == 0 ? getResources().getString(R.string.refund_type) : i == 1 ? getResources().getString(R.string.exchange) : getResources().getString(R.string.returnProduct)) ? 1 : 0));
            i++;
        }
        this.f9990z0 = new BaseDialog2(activityC1391g1, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f9990z0;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.y1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                C2659t3.this.m5333a(view, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f9990z0;
        baseDialog22.f8209G = activityC1391g1.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_refund_requests")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (this.f9979o0 != null) {
                if (SimpleVM.f8836d) {
                    m4892X0();
                    this.f9979o0.addAll(list);
                } else {
                    if (this.f9137a0 == 0) {
                        this.f9979o0.addAll(list);
                    } else if (this.f9978B0) {
                        this.f9979o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                    } else {
                        this.f9979o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                    }
                    if (list.size() == 0) {
                        this.xRecyclerView.setNoMore(true);
                    }
                    if (this.f9979o0.getItemCount() == 0) {
                        this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                    }
                }
                if (!jSONObject.has("count") || this.f9977A0 == null) {
                    return;
                }
                this.f9977A0.mo4265a(jSONObject.getString("count"));
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_failed, "error");
            this.baseActivity.finish();
        }
    }
}
