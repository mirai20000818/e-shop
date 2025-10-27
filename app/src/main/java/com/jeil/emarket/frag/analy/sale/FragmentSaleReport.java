package com.jeil.emarket.frag.analy.sale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.SaleProductAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.SaleProduct;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.d.c.q */

public class FragmentSaleReport extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: q0 */
    public Picker4 f10108q0;

    /* renamed from: r0 */
    public SaleProductAdapter f10109r0;

    /* renamed from: s0 */
    public DialogC2001j f10110s0;

    /* renamed from: x0 */
    public View f10115x0;

    /* renamed from: o0 */
    public boolean f10106o0 = true;

    /* renamed from: p0 */
    public JSONObject f10107p0 = new JSONObject();

    /* renamed from: t0 */
    public Date f10111t0 = null;

    /* renamed from: u0 */
    public Date f10112u0 = null;

    /* renamed from: v0 */
    public MutableLiveData<Integer> f10113v0 = new MutableLiveData<>(0);

    /* renamed from: w0 */
    public MutableLiveData<java.lang.String> f10114w0 = new MutableLiveData<>("");

    /* renamed from: y0 */
    public java.lang.String f10116y0 = "";

    /* renamed from: b.f.a.g.d.c.q$a */
    public class a extends TypeToken<List<SaleProduct>> {
        public a(FragmentSaleReport c2706q) {
        }
    }

    public FragmentSaleReport() {
    }

    public FragmentSaleReport(BaseActivity activityC1391g1) {
        try {
            this.f10107p0.put("startDate", "");
            this.f10107p0.put("endDate", "");
            this.jsonObject.put("filter", this.f10107p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
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
        this.f10108q0 = new Picker4(getContext());
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f10109r0 = new SaleProductAdapter((BaseActivity) getActivity(), this);
            this.xRecyclerView.setAdapter(this.f10109r0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f10106o0;
            xRecyclerView.f12377b1 = true;
            this.f10115x0 = getLayoutInflater().inflate(R.layout.layout_sale_report_info_box, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            this.f10115x0.findViewById(R.id.ll_price).setVisibility(View.GONE);
            this.f10115x0.findViewById(R.id.cef_search).setVisibility(View.GONE);
            this.f10115x0.findViewById(R.id.tv_content).setVisibility(View.VISIBLE);
            ((TextView) this.f10115x0.findViewById(R.id.ctv_date_span)).setText(getResources().getString(R.string.all));
            this.f10111t0 = null;
            this.f10112u0 = null;
            this.f10115x0.findViewById(R.id.mrl_date).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.c.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentSaleReport.this.m5396k(view);
                }
            });
            this.f10115x0.findViewById(R.id.mrl_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.c.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentSaleReport.this.m5397l(view);
                }
            });
            int i = BaseActivity.anInt2;
            c0541a.setMargins(i, 0, i, 0);
            this.f10115x0.setLayoutParams(c0541a);
            this.f10115x0.measure(((LinearLayout.LayoutParams) c0541a).width, ((LinearLayout.LayoutParams) c0541a).height);
            this.xRecyclerView.addView(this.f10115x0);
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_shop);
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_products);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f10106o0) {
            ArrayList arrayList = new ArrayList();
            SaleProduct saleProduct = new SaleProduct();
            saleProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(saleProduct);
            }
            this.f10109r0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f10107p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_sale_product_list", this).get("e7/sale/flash", this.jsonObject);
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
        if (this.f10106o0) {
            ArrayList arrayList = new ArrayList();
            SaleProduct saleProduct = new SaleProduct();
            saleProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(saleProduct);
            }
            SaleProductAdapter c1973w1 = this.f10109r0;
            c1973w1.arrayList = arrayList;
            c1973w1.notifyDataSetChanged();
        } else {
            SaleProductAdapter c1973w12 = this.f10109r0;
            c1973w12.arrayList = new ArrayList();
            c1973w12.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        this.jsonObject = new JSONObject();
        try {
            if (this.f10113v0.getValue() != null && this.f10113v0.getValue().intValue() > 0 && this.f10114w0.getValue() != null && !this.f10114w0.getValue().isEmpty()) {
                this.f10107p0.put("category", this.f10113v0.getValue());
            }
            this.f10107p0.put("search", this.f10116y0);
            this.f10107p0.put("startDate", this.f10111t0 != null ? Util.date2Str(this.f10111t0) : "");
            this.f10107p0.put("endDate", this.f10112u0 != null ? Util.date2Str(this.f10112u0) : "");
            this.jsonObject.put("filter", this.f10107p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_sale_product_list", this).get("e7/sale/flash", this.jsonObject);
    }

    /* renamed from: Z0 */
    public SaleProductAdapter m5389Z0() {
        return this.f10109r0;
    }

    
    public  void m5390a(BaseDialog2 baseDialog2, View view, int i) {
        java.lang.String str;
        if (i == 10) {
            TextView textView = (TextView) this.f10115x0.findViewById(R.id.ctv_date_span);
            if (this.f10111t0 != null) {
                str = Util.date2Str(this.f10111t0) + " ~ " + Util.date2Str(this.f10112u0);
            } else {
                str = Status.day_filter1[i];
            }
            textView.setText(str);
            m5393a1();
            this.f10108q0.m4704a();
            this.f10108q0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.c.k
                @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c
                
                public final void mo4696a(Date date, Date date2, View view2) {
                    FragmentSaleReport.this.m5392a(date, date2, view2);
                }
            };
        } else {
            ((TextView) this.f10115x0.findViewById(R.id.ctv_date_span)).setText(Status.day_filter1[i]);
            Date[] m319b = Util.m319b(i, true);
            this.f10111t0 = m319b[0];
            this.f10112u0 = m319b[1];
            m5395c1();
        }
        baseDialog2.startAni();
    }

    
    public void m5391a(java.lang.String str, boolean z) {
        if (str.equals(this.f10116y0)) {
            return;
        }
        this.f10116y0 = str;
        if (z) {
            m5395c1();
        }
    }

    
    public  void m5392a(Date date, Date date2, View view) {
        this.f10111t0 = date;
        this.f10112u0 = date2;
        ((TextView) this.f10115x0.findViewById(R.id.ctv_date_span)).setText(Util.date2Str(date) + " ~ " + Util.date2Str(date2));
        m5395c1();
    }

    /* renamed from: a1 */
    public void m5393a1() {
        Calendar calendar = Calendar.getInstance();
        Date date = this.f10111t0;
        if (date == null) {
            date = new Date(new Date().getYear(), 0, 1);
        }
        calendar.setTime(date);
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f10108q0.f8615b;
        viewOnClickListenerC2123h.f8694c.f8669s = calendar;
        viewOnClickListenerC2123h.m4728f();
        Calendar calendar2 = Calendar.getInstance();
        Date date2 = this.f10112u0;
        if (date2 == null) {
            date2 = new Date();
        }
        calendar.setTime(date2);
        this.f10108q0.m4705a(calendar2);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: b1 */
    public void m5394b1() {
        final BaseDialog2 baseDialog2 = new BaseDialog2(getContext(), Status.day_filter1);
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.c.i
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b
            
            public final void mo4264a(View view, int i) {
                FragmentSaleReport.this.m5390a(baseDialog2, view, i);
            }
        };
    }

    /* renamed from: c1 */
    public void m5395c1() {
        this.f9137a0 = 0;
        mo4891W0();
    }

    
    public  void m5396k(View view) {
        m5394b1();
    }

    /* renamed from: l */
    public  void m5397l(View view) {
        this.f10111t0 = null;
        this.f10112u0 = null;
        m5395c1();
        ((TextView) this.f10115x0.findViewById(R.id.ctv_date_span)).setText(getResources().getString(R.string.all));
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c
    
    public boolean mo4808a(int i, java.lang.String str, int i2) {
        if (str.equals("refresh")) {
            this.f9137a0 = 0;
            mo4891W0();
            return true;
        }
        this.f10110s0 = new DialogC2001j(this.baseActivity);
        this.f10110s0.show();
        new API_PROVIDER(getContext(), "delete_sale_product", this).delete("e7/sale/flash/" + str, (JSONObject) null);
        return true;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (!str2.equals("get_sale_product_list")) {
            if (str2.equals("delete_sale_product")) {
                this.f10110s0.dismiss();
                if (i == 200) {
                    this.f9137a0 = 0;
                    mo4891W0();
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
            if (this.f10109r0 != null) {
                if (SimpleVM.f8836d) {
                    m4892X0();
                    this.f10109r0.addAll(list);
                    return;
                }
                if (this.f9137a0 == 0) {
                    this.f10109r0.addAll(list);
                } else if (this.f10106o0) {
                    this.f10109r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f10109r0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f10109r0.getItemCount() == 0) {
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
