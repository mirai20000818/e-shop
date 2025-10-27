package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.SaleReportAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.SaleReport;
import com.jeil.emarket.model.vendor.SaleReportStats;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.d.b.x3 */

public class GetSaleReports extends BaseFragment implements BaseInterface {

    /* renamed from: p0 */
    public View f10041p0;

    /* renamed from: q0 */
    public SaleReportAdapter f10042q0;

    /* renamed from: s0 */
    public Picker4 f10044s0;

    /* renamed from: o0 */
    public boolean f10040o0 = true;

    /* renamed from: r0 */
    public JSONObject f10043r0 = new JSONObject();

    /* renamed from: t0 */
    public Date f10045t0 = new Date();

    /* renamed from: u0 */
    public Date f10046u0 = new Date();

    /* renamed from: b.f.a.g.d.b.x3$a */
    public class a extends TypeToken<List<SaleReport>> {
        public a(GetSaleReports getSaleReports) {
        }
    }

    /* renamed from: b.f.a.g.d.b.x3$b */
    public class b extends TypeToken<SaleReportStats> {
        public b(GetSaleReports getSaleReports) {
        }
    }

    public GetSaleReports() {
    }

    public GetSaleReports(BaseActivity activityC1391g1) {
        try {
            this.f10043r0.put("startDate", Util.date2Str(this.f10045t0));
            this.f10043r0.put("endDate", Util.date2Str(this.f10046u0));
            this.jsonObject.put("filter", this.f10043r0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("stats", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams", "SetTextI18n"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        this.f10044s0 = new Picker4(getContext());
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f10042q0 = new SaleReportAdapter(this.baseActivity);
            this.xRecyclerView.setAdapter(this.f10042q0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f10040o0;
            xRecyclerView.f12377b1 = true;
            this.f10041p0 = getLayoutInflater().inflate(R.layout.layout_sale_report_info_box, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            this.f10041p0.findViewById(R.id.pt_kpf_sold_total).setVisibility(View.GONE);
            this.f10041p0.findViewById(R.id.pt_kpw_sold_total).setVisibility(View.GONE);
            ((EditForm) this.f10041p0.findViewById(R.id.cef_search)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.s2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GetSaleReports.this.m5368k(view);
                }
            });
            ((EditForm) this.f10041p0.findViewById(R.id.cef_search)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.d.b.u2
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return GetSaleReports.this.m5366a(textView, i, keyEvent);
                }
            });
            ((com.jeil.emarket.components.textview.TextView) this.f10041p0.findViewById(R.id.ctv_date_span)).setText(getResources().getString(R.string.today));
            Date date = new Date();
            this.f10045t0 = date;
            this.f10046u0 = date;
            this.f10041p0.findViewById(R.id.mrl_date).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.r2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GetSaleReports.this.m5369l(view);
                }
            });
            this.f10041p0.findViewById(R.id.mrl_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.v2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GetSaleReports.this.m5370m(view);
                }
            });
            int i = BaseActivity.anInt2;
            c0541a.setMargins(i, 0, i, 0);
            this.f10041p0.setLayoutParams(c0541a);
            this.f10041p0.measure(((LinearLayout.LayoutParams) c0541a).width, ((LinearLayout.LayoutParams) c0541a).height);
            this.xRecyclerView.addView(this.f10041p0);
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_products);
            ((com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f10040o0) {
            ArrayList arrayList = new ArrayList();
            SaleReport saleReport = new SaleReport();
            saleReport.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(saleReport);
            }
            this.f10042q0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f10043r0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_sale_reports", this).get("e7/finance/sales", this.jsonObject);
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
        if (this.f10040o0) {
            Util.setColor((Context) this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_sold_amount_label));
            Util.setColor((Context) this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_sold_amount));
            Util.setColor((Context) this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_unit));
            Util.setColor((Context) this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_sold_total_label));
            this.f10041p0.findViewById(R.id.ctv_shimmer_sold_total).setVisibility(View.VISIBLE);
            ((ShimmerFrameLayout) this.f10041p0.findViewById(R.id.sfl_shimmer)).showShimmer(true);
            this.f10041p0.findViewById(R.id.pt_kpf_sold_total).setVisibility(View.GONE);
            this.f10041p0.findViewById(R.id.pt_kpw_sold_total).setVisibility(View.GONE);
            ArrayList arrayList = new ArrayList();
            SaleReport saleReport = new SaleReport();
            saleReport.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(saleReport);
            }
            SaleReportAdapter c1982z1 = this.f10042q0;
            c1982z1.arrayList = arrayList;
            c1982z1.notifyDataSetChanged();
        } else {
            SaleReportAdapter c1982z12 = this.f10042q0;
            c1982z12.arrayList = new ArrayList();
            c1982z12.notifyDataSetChanged();
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
        new API_PROVIDER(getContext(), "get_sale_reports", this).get("e7/finance/sales", this.jsonObject);
    }

    /* renamed from: Z0 */
    public void m5362Z0() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.f10045t0);
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f10044s0.f8615b;
        viewOnClickListenerC2123h.f8694c.f8669s = calendar;
        viewOnClickListenerC2123h.m4728f();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(this.f10046u0);
        this.f10044s0.m4705a(calendar2);
    }


    public  void m5363a(BaseDialog2 baseDialog2, View view, int i) {
        if (i == 9) {
            ((com.jeil.emarket.components.textview.TextView) this.f10041p0.findViewById(R.id.ctv_date_span)).setText(Util.date2Str(this.f10045t0) + " ~ " + Util.date2Str(this.f10046u0));
            m5362Z0();
            this.f10044s0.m4704a();
            this.f10044s0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.b.w2
                @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

                public final void mo4696a(Date date, Date date2, View view2) {
                    GetSaleReports.this.m5365a(date, date2, view2);
                }
            };
        } else {
            ((com.jeil.emarket.components.textview.TextView) this.f10041p0.findViewById(R.id.ctv_date_span)).setText(Status.day_filter[i]);
            Date[] m341d = Util.m341d(i);
            this.f10045t0 = m341d[0];
            this.f10046u0 = m341d[1];
            m5364a(Util.date2Str(this.f10045t0), Util.date2Str(this.f10046u0), ((EditForm) this.f10041p0.findViewById(R.id.cef_search)).getText());
        }
        baseDialog2.startAni();
    }


    public void m5364a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f9137a0 = 0;
        try {
            this.f10043r0.put("startDate", str);
            this.f10043r0.put("endDate", str2);
            this.f10043r0.put("search", str3);
            this.jsonObject.put("filter", this.f10043r0.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }


    public  void m5365a(Date date, Date date2, View view) {
        this.f10045t0 = date;
        this.f10046u0 = date2;
        ((com.jeil.emarket.components.textview.TextView) this.f10041p0.findViewById(R.id.ctv_date_span)).setText(Util.date2Str(date) + " ~ " + Util.date2Str(date2));
        m5364a(Util.date2Str(this.f10045t0), Util.date2Str(this.f10046u0), ((EditForm) this.f10041p0.findViewById(R.id.cef_search)).getText());
    }


    public  boolean m5366a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m5364a(Util.date2Str(this.f10045t0), Util.date2Str(this.f10046u0), ((EditForm) this.f10041p0.findViewById(R.id.cef_search)).getText());
        return true;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: a1 */
    public void m5367a1() {
        final BaseDialog2 baseDialog2 = new BaseDialog2(getContext(), Status.day_filter);
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.t2
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i) {
                GetSaleReports.this.m5363a(baseDialog2, view, i);
            }
        };
    }

    
    public  void m5368k(View view) {
        m5364a(Util.date2Str(this.f10045t0), Util.date2Str(this.f10046u0), ((EditForm) this.f10041p0.findViewById(R.id.cef_search)).getText());
    }

    /* renamed from: l */
    public  void m5369l(View view) {
        m5367a1();
    }

    /* renamed from: m */
    public  void m5370m(View view) {
        Date date = new Date();
        this.f10045t0 = date;
        this.f10046u0 = date;
        m5364a(Util.date2Str(this.f10045t0), Util.date2Str(this.f10046u0), "");
        ((com.jeil.emarket.components.textview.TextView) this.f10041p0.findViewById(R.id.ctv_date_span)).setText(getResources().getString(R.string.today));
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_sale_reports")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            SaleReportStats saleReportStats = (SaleReportStats) new Gson().fromJson(jSONObject.getString("stats"), new b(this).getType());
            ((com.jeil.emarket.components.textview.TextView) this.f10041p0.findViewById(R.id.ctv_sold_amount)).setText(Util.m217a(saleReportStats.productsSold));
            PriceText priceText = (PriceText) this.f10041p0.findViewById(R.id.pt_kpf_sold_total);
            PriceText priceText2 = (PriceText) this.f10041p0.findViewById(R.id.pt_kpw_sold_total);
            priceText.setHidePriceNumber(false);
            priceText2.setHidePriceNumber(false);
            SubOrder.TotalAmount totalAmount = saleReportStats.orderTotal;
            if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
                priceText2.f12264t = true;
            }
            SubOrder.TotalAmount totalAmount2 = saleReportStats.orderTotal;
            if (totalAmount2.kpf > 0.0f) {
                priceText.setPrice(Util.m327c(totalAmount2.kpf));
                priceText.setVisibility(View.VISIBLE);
            }
            SubOrder.TotalAmount totalAmount3 = saleReportStats.orderTotal;
            if (totalAmount3.kpw > 0.0f) {
                priceText2.setPrice(Util.m327c(totalAmount3.kpw));
                priceText2.setVisibility(View.VISIBLE);
            }
            SubOrder.TotalAmount totalAmount4 = saleReportStats.orderTotal;
            if (totalAmount4.kpf == 0.0f && totalAmount4.kpw == 0.0f) {
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
            Util.setColor(this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_sold_amount_label), R.color.dark);
            Util.setColor(this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_sold_amount), R.color.dark);
            Util.setColor(this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_unit), R.color.light);
            Util.setColor(this.baseActivity, (TextView) this.f10041p0.findViewById(R.id.ctv_sold_total_label), R.color.dark);
            this.f10041p0.findViewById(R.id.ctv_shimmer_sold_total).setVisibility(View.GONE);
            ((ShimmerFrameLayout) this.f10041p0.findViewById(R.id.sfl_shimmer)).hideShimmer();
            this.f10041p0.findViewById(R.id.cef_search).setVisibility(View.VISIBLE);
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f10042q0.addAll(list);
                return;
            }
            if (this.f9137a0 == 0) {
                this.f10042q0.addAll(list);
            } else if (this.f10040o0) {
                this.f10042q0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
            } else {
                this.f10042q0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
            }
            if (list.size() == 0) {
                this.xRecyclerView.setNoMore(true);
            }
            if (this.f10042q0.getItemCount() == 0) {
                this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
