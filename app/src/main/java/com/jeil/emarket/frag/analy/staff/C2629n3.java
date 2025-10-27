package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.order.VendorOrderAdaper;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.vendor.FeeHistoryTotal;
import com.jeil.emarket.model.vendor.VendorOrder;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.d.b.n3 */

public class C2629n3 extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public View f9896o0;

    /* renamed from: p0 */
    public VendorOrderAdaper f9897p0;

    /* renamed from: q0 */
    public JSONObject f9898q0;

    /* renamed from: r0 */
    public InterfaceString f9899r0;

    /* renamed from: s0 */
    public boolean f9900s0;

    /* renamed from: t0 */
    public java.lang.String f9901t0;

    /* renamed from: u0 */
    public Picker4 f9902u0;

    /* renamed from: v0 */
    public Date f9903v0;

    /* renamed from: w0 */
    public Date f9904w0;

    /* renamed from: x0 */
    public java.lang.String f9905x0;

    /* renamed from: y0 */
    public java.lang.String f9906y0;

    /* renamed from: b.f.a.g.d.b.n3$a */
    public class a extends TypeToken<List<VendorOrder>> {
        public a(C2629n3 c2629n3) {
        }
    }

    /* renamed from: b.f.a.g.d.b.n3$b */
    public class b extends TypeToken<FeeHistoryTotal> {
        public b(C2629n3 c2629n3) {
        }
    }

    public C2629n3() {
        this.f9898q0 = new JSONObject();
        this.f9900s0 = true;
        this.f9903v0 = new Date(new Date().getYear(), new Date().getMonth(), new Date().getDate() - 6);
        this.f9904w0 = new Date();
        this.f9905x0 = "";
        this.f9906y0 = "";
    }

    public C2629n3(BaseActivity activityC1391g1, java.lang.String str, InterfaceString interfaceString) {
        this.f9898q0 = new JSONObject();
        this.f9900s0 = true;
        this.f9903v0 = new Date(new Date().getYear(), new Date().getMonth(), new Date().getDate() - 6);
        this.f9904w0 = new Date();
        this.f9905x0 = "";
        this.f9906y0 = "";
        this.f9901t0 = str;
        if (str.equals("completed") || str.equals("cancelled")) {
            this.f9903v0 = new Date();
        } else {
            this.f9903v0 = null;
            this.f9904w0 = null;
        }
        if (str.equals("all")) {
            this.f9906y0 = "createdAt";
        }
        try {
            if (this.f9901t0.equals("all")) {
                this.f9898q0.put("filterDate", this.f9906y0);
            }
            this.f9898q0.put("status", str.equals("urgent") ? "process" : str);
            this.f9898q0.put("search", this.f9905x0);
            this.f9898q0.put("urgent", str.equals("urgent"));
            this.f9898q0.put("startDate", Util.date2Str(this.f9903v0));
            this.f9898q0.put("endDate", Util.date2Str(this.f9904w0));
            this.jsonObject.put("filter", this.f9898q0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9899r0 = interfaceString;
        this.baseActivity = activityC1391g1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01e8  */
    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @android.annotation.SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void showBootomMenu() {
        /*
            Method dump skipped, instructions count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p231g.p243d.p251b.C2629n3.mo4887S0():void");
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9900s0) {
            ArrayList arrayList = new ArrayList();
            VendorOrder vendorOrder = new VendorOrder();
            vendorOrder.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(vendorOrder);
            }
            this.f9897p0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9898q0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_vendor_orders", this).get("e7/orders", this.jsonObject);
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
        if (this.f9900s0) {
            ((ShimmerFrameLayout) this.f9896o0.findViewById(R.id.sfl_shimmer_sum)).showShimmer(true);
            this.f9896o0.findViewById(R.id.tv_sum).setVisibility(View.VISIBLE);
            this.f9896o0.findViewById(R.id.ll_sum_result).setVisibility(View.GONE);
            ArrayList arrayList = new ArrayList();
            VendorOrder vendorOrder = new VendorOrder();
            vendorOrder.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(vendorOrder);
            }
            VendorOrderAdaper c1818f1 = this.f9897p0;
            c1818f1.arrayList = arrayList;
            c1818f1.notifyDataSetChanged();
        } else {
            VendorOrderAdaper c1818f12 = this.f9897p0;
            c1818f12.arrayList = new ArrayList();
            c1818f12.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        try {
            this.f9898q0.put("search", this.f9905x0);
            if (this.f9901t0.equals("all") && !this.f9906y0.isEmpty()) {
                this.f9898q0.put("filterDate", this.f9906y0);
            }
            this.f9898q0.put("startDate", Util.date2Str(this.f9903v0));
            this.f9898q0.put("endDate", Util.date2Str(this.f9904w0));
            this.jsonObject.put("filter", this.f9898q0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_vendor_orders", this).get("e7/orders", this.jsonObject);
    }

    /* renamed from: Z0 */
    public VendorOrderAdaper m5278Z0() {
        return this.f9897p0;
    }


    public  void m5279a(BaseDialog2 baseDialog2, View view, int i) {
        TextView textView;
        Resources m2475L;
        int i2;
        switch (i) {
            case 0:
                this.f9906y0 = "createdAt";
                textView = (TextView) this.f9896o0.findViewById(R.id.tv_select_date_label);
                m2475L = getResources();
                i2 = R.string.order_created_at_comma;
                break;
            case 1:
                this.f9906y0 = "updatedAt";
                textView = (TextView) this.f9896o0.findViewById(R.id.tv_select_date_label);
                m2475L = getResources();
                i2 = R.string.order_updated_at_comma;
                break;
            case 2:
                this.f9906y0 = "acceptedAt";
                textView = (TextView) this.f9896o0.findViewById(R.id.tv_select_date_label);
                m2475L = getResources();
                i2 = R.string.accepted_at_comma;
                break;
            case 3:
                this.f9906y0 = "readyAt";
                textView = (TextView) this.f9896o0.findViewById(R.id.tv_select_date_label);
                m2475L = getResources();
                i2 = R.string.ready_to_ship_at_comma;
                break;
            case 4:
                this.f9906y0 = "shippingAt";
                textView = (TextView) this.f9896o0.findViewById(R.id.tv_select_date_label);
                m2475L = getResources();
                i2 = R.string.shipping_leaved_at_comma;
                break;
            case 5:
                this.f9906y0 = "completedAt";
                textView = (TextView) this.f9896o0.findViewById(R.id.tv_select_date_label);
                m2475L = getResources();
                i2 = R.string.completed_at_comma;
                break;
            case 6:
                this.f9906y0 = "cancelledAt";
                textView = (TextView) this.f9896o0.findViewById(R.id.tv_select_date_label);
                m2475L = getResources();
                i2 = R.string.cancelled_at_comma;
                break;
        }
        //textView.setText(m2475L.getString(i2));
        m5287d1();
        baseDialog2.startAni();
    }


    public void m5280a(java.lang.String str, boolean z) {
        if (str.equals(this.f9905x0)) {
            return;
        }
        this.f9905x0 = str;
        if (z) {
            m5287d1();
        }
    }


    public  void m5281a(Date date, View view) {
        this.f9904w0 = date;
        if (this.f9901t0.equals("completed") || this.f9901t0.equals("cancelled")) {
            this.f9903v0 = date;
        } else {
            this.f9903v0 = null;
            this.f9904w0 = null;
        }
        m5287d1();
        ((TextView) this.f9896o0.findViewById(R.id.ctv_date_span)).setText((this.f9901t0.equals("completed") || this.f9901t0.equals("cancelled")) ? getResources().getString(R.string.today) : getResources().getString(R.string.all));
        ((TextView) this.f9896o0.findViewById(R.id.ctv_select_date_span)).setText(getResources().getString(R.string.all));
    }


    public  void m5282a(Date date, Date date2, View view) {
        this.f9903v0 = date;
        this.f9904w0 = date2;
        ((TextView) this.f9896o0.findViewById(R.id.ctv_date_span)).setText(Util.date2Str(date) + " ~ " + Util.date2Str(date2));
        ((TextView) this.f9896o0.findViewById(R.id.ctv_select_date_span)).setText(Util.date2Str(date) + " ~ " + Util.date2Str(date2));
        m5287d1();
    }

    /* renamed from: a1 */
    public void m5283a1() {
        if (this.f9903v0 != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.f9903v0);
            ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f9902u0.f8615b;
            viewOnClickListenerC2123h.f8694c.f8669s = calendar;
            viewOnClickListenerC2123h.m4728f();
        }
        if (this.f9904w0 != null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(this.f9904w0);
            ViewOnClickListenerC2123h viewOnClickListenerC2123h2 = this.f9902u0.f8615b;
            viewOnClickListenerC2123h2.f8694c.f8670t = calendar2;
            viewOnClickListenerC2123h2.m4728f();
        }
    }


    public  void m5284b(BaseDialog2 baseDialog2, View view, int i) {
        java.lang.String str;
        java.lang.String str2;
        if (i == 10) {
            TextView textView = (TextView) this.f9896o0.findViewById(R.id.ctv_date_span);
            if (this.f9903v0 != null) {
                str = Util.date2Str(this.f9903v0) + " ~ " + Util.date2Str(this.f9904w0);
            } else {
                str = Status.day_filter1[i];
            }
            textView.setText(str);
            TextView textView2 = (TextView) this.f9896o0.findViewById(R.id.ctv_select_date_span);
            if (this.f9903v0 != null) {
                str2 = Util.date2Str(this.f9903v0) + " ~ " + Util.date2Str(this.f9904w0);
            } else {
                str2 = Status.day_filter1[i];
            }
            textView2.setText(str2);
            m5283a1();
            this.f9902u0.m4704a();
            this.f9902u0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.b.t0
                @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

                public final void mo4696a(Date date, Date date2, View view2) {
                    C2629n3.this.m5282a(date, date2, view2);
                }
            };
        } else {
            ((TextView) this.f9896o0.findViewById(R.id.ctv_date_span)).setText(Status.day_filter1[i]);
            ((TextView) this.f9896o0.findViewById(R.id.ctv_select_date_span)).setText(Status.day_filter1[i]);
            Date[] m319b = Util.m319b(i, true);
            this.f9903v0 = m319b[0];
            this.f9904w0 = m319b[1];
            m5287d1();
        }
        baseDialog2.startAni();
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: b1 */
    public void m5285b1() {
        final BaseDialog2 baseDialog2 = new BaseDialog2(getContext(), new java.lang.String[]{getResources().getString(R.string.order_created_at), getResources().getString(R.string.order_updated_at), getResources().getString(R.string.accepted_at), getResources().getString(R.string.ready_to_ship_at), getResources().getString(R.string.shipping_leaved_at), getResources().getString(R.string.completed_at), getResources().getString(R.string.cancelled_at)});
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.r0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i) {
                C2629n3.this.m5279a(baseDialog2, view, i);
            }
        };
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: c1 */
    public void m5286c1() {
        final BaseDialog2 baseDialog2 = new BaseDialog2(getContext(), Status.day_filter1);
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.u0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i) {
                C2629n3.this.m5284b(baseDialog2, view, i);
            }
        };
    }

    /* renamed from: d1 */
    public void m5287d1() {
        this.f9137a0 = 0;
        mo4891W0();
    }

    
    public  void m5288k(View view) {
        m5286c1();
    }

    /* renamed from: l */
    public  void m5289l(View view) {
        m5285b1();
    }

    /* renamed from: m */
    public  void m5290m(View view) {
        m5286c1();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    @SuppressLint({"SetTextI18n"})

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_vendor_orders")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9896o0.findViewById(R.id.tv_sum).setVisibility(View.GONE);
            this.f9896o0.findViewById(R.id.ll_sum_result).setVisibility(View.VISIBLE);
            ((ShimmerFrameLayout) this.f9896o0.findViewById(R.id.sfl_shimmer_sum)).hideShimmer();
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            FeeHistoryTotal feeHistoryTotal = new FeeHistoryTotal();
            if (jSONObject.getString("total") != null) {
                feeHistoryTotal = (FeeHistoryTotal) new Gson().fromJson(jSONObject.getString("total"), new b(this).getType());
            }
            ((TextView) this.f9896o0.findViewById(R.id.tv_count)).setText(this.f9138b0 + getResources().getString(R.string.count_unit));
            PriceText priceText = (PriceText) this.f9896o0.findViewById(R.id.pt_kpf_sum);
            PriceText priceText2 = (PriceText) this.f9896o0.findViewById(R.id.pt_kpw_sum);
            priceText.setHidePriceNumber(false);
            priceText2.setHidePriceNumber(false);
            priceText.setVisibility(View.GONE);
            priceText2.setVisibility(View.GONE);
            if (feeHistoryTotal.kpf > 0.0f && feeHistoryTotal.kpw > 0.0f) {
                priceText2.f12264t = true;
            }
            float f = feeHistoryTotal.kpf;
            if (f > 0.0f) {
                priceText.setPrice(Util.m327c(f));
                priceText.setVisibility(View.VISIBLE);
            }
            float f2 = feeHistoryTotal.kpw;
            if (f2 > 0.0f) {
                priceText2.setPrice(Util.m327c(f2));
                priceText2.setVisibility(View.VISIBLE);
            }
            if (feeHistoryTotal.kpf == 0.0f && feeHistoryTotal.kpw == 0.0f) {
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
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9897p0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9897p0.addAll(list);
                } else if (this.f9900s0) {
                    this.f9897p0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9897p0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9897p0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (!jSONObject.has("count") || this.f9899r0 == null) {
                return;
            }
            this.f9899r0.mo4265a(jSONObject.getString("count"));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
