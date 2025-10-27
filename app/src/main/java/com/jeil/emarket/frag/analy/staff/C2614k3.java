package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.activities.seller.VendorFinanceActivity;
import com.jeil.emarket.activities.ticket.chat.TicketCustomerChatActivity;
import com.jeil.emarket.activities.ticket.chat.TicketMarketChatActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.ChartLineView;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.dialog.widget.popup.BubblePopup;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.ChartParam;
import com.jeil.emarket.model.vendor.Dashboard;
import com.jeil.emarket.model.vendor.DashboardOrderChart;
import com.jeil.emarket.model.vendor.DashboardSaleChart;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.model.vendor.VendorUser;
import com.jeil.emarket.providers.AnalyticsProvider;
import com.jeil.emarket.viewmodel.ModelCollection;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.d.b.k3 */

public class C2614k3 extends Fragment {

    /* renamed from: a0 */
    public Picker4 f9856a0;

    /* renamed from: b0 */
    public Picker4 f9857b0;

    /* renamed from: g0 */
    public ChartLineView f9862g0;

    /* renamed from: h0 */
    public ChartLineView f9863h0;

    /* renamed from: k0 */
    public AnalyticsProvider f9866k0;

    /* renamed from: l0 */
    public int f9867l0;

    /* renamed from: n0 */
    public WaveSwipeRefreshLayout f9869n0;

    /* renamed from: c0 */
    public ChartParam f9858c0 = new ChartParam();

    /* renamed from: d0 */
    public ChartParam f9859d0 = new ChartParam();

    /* renamed from: e0 */
    public MutableLiveData<ChartParam> f9860e0 = new MutableLiveData<>();

    /* renamed from: f0 */
    public MutableLiveData<ChartParam> f9861f0 = new MutableLiveData<>();

    /* renamed from: i0 */
    public ArrayList<ArrayList<Float>> f9864i0 = new ArrayList<>();

    /* renamed from: j0 */
    public ArrayList<ArrayList<Float>> f9865j0 = new ArrayList<>();

    /* renamed from: m0 */
    public boolean f9868m0 = true;


    public static  void m5227a(View view, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        if (nestedScrollView.canScrollVertically(1)) {
            view.findViewById(R.id.ll_bottom_gradient).setVisibility(View.VISIBLE);
        } else {
            view.findViewById(R.id.ll_bottom_gradient).setVisibility(View.GONE);
        }
        boolean canScrollVertically = nestedScrollView.canScrollVertically(-1);
        View findViewById = view.findViewById(R.id.ll_top_gradient);
        if (canScrollVertically) {
            findViewById.setVisibility(View.VISIBLE);
        } else {
            findViewById.setVisibility(View.GONE);
        }
    }


    @SuppressLint("WrongConstant")
    public static  void m5228a(View view, VendorUser vendorUser) {
        View findViewById;
        int i;
        VendorUser.User user;
        if (vendorUser == null || (user = vendorUser.user) == null || !(user.role.equals("vendorManager") || vendorUser.user.role.equals("vendorFinanceManager"))) {
            findViewById = view.findViewById(R.id.ll_section_order_chart);
            i = 8;
        } else {
            findViewById = view.findViewById(R.id.ll_section_order_chart);
            i = 0;
        }
        findViewById.setVisibility(i);
        view.findViewById(R.id.ll_section_sale_chart).setVisibility(i);
    }

    /* renamed from: S0 */
    public void m5231S0() {
        this.f9856a0 = new Picker4(getContext());
        this.f9857b0 = new Picker4(getContext());
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), 0, 1);
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f9856a0.f8615b;
        viewOnClickListenerC2123h.f8694c.f8669s = calendar;
        viewOnClickListenerC2123h.m4728f();
        ViewOnClickListenerC2123h viewOnClickListenerC2123h2 = this.f9857b0.f8615b;
        viewOnClickListenerC2123h2.f8694c.f8669s = calendar;
        viewOnClickListenerC2123h2.m4728f();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5));
        ViewOnClickListenerC2123h viewOnClickListenerC2123h3 = this.f9856a0.f8615b;
        viewOnClickListenerC2123h3.f8694c.f8670t = calendar2;
        viewOnClickListenerC2123h3.m4728f();
        ViewOnClickListenerC2123h viewOnClickListenerC2123h4 = this.f9857b0.f8615b;
        viewOnClickListenerC2123h4.f8694c.f8670t = calendar2;
        viewOnClickListenerC2123h4.m4728f();
    }

    /* renamed from: T0 */
    public  void m5232T0() {
        this.f9869n0.setRefreshing(false);
        this.f9869n0.setEnabled(false);
    }

    /* renamed from: U0 */
    public  void m5233U0() {
       // ((BaseActivity) getActivity()).drawerLayout.m1434b();
    }


    public  void m5234a(View view, View view2) {
        m5241a((MaterialRippleLayout) view.findViewById(R.id.mrl_request), R.string.request_order_tooltip);
    }


    public  void m5235a(View view, CompoundButton compoundButton, boolean z) {
        m5265l(view);
    }


    public  void m5236a(View view, ChartParam chartParam) {
        m5268o(view);
        this.f9866k0.m5662c(getContext(), chartParam.startDate, chartParam.endDate);
    }


    public  void m5237a(final View view, final Dashboard dashboard) {
        if (this.f9868m0) {
            if (VendorListVM.f10363d.getValue() != null) {
                ((TextViewBold) view.findViewById(R.id.tv_header_title)).setText(VendorListVM.f10363d.getValue().name);
            } else {
                ((TextViewBold) view.findViewById(R.id.tv_header_title)).setText(R.string.dashboard);
            }
            if (dashboard.tickets == null || dashboard.vendorInfo == null) {
                return;
            }
            if (this.f9869n0 != null) {
                new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2614k3.this.m5232T0();
                    }
                }, 2000L);
            }
            char c2 = 0;
            this.f9868m0 = false;
            this.f9867l0--;
            m5266m(view);
            ((TextView) view.findViewById(R.id.tv_approved_product)).setText(Util.m217a(dashboard.vendorInfo.registeredProducts) + getResources().getString(R.string.count_unit));
            ((TextView) view.findViewById(R.id.tv_unapproved_product)).setText(Util.m217a((float) dashboard.vendorInfo.notRegisteredProducts) + getResources().getString(R.string.count_unit));
            view.findViewById(R.id.mrl_product).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2614k3.this.m5250c(view2);
                }
            });
            ((TextView) view.findViewById(R.id.tv_low_stock)).setText(Util.m217a(dashboard.vendorInfo.lowStockProducts) + getResources().getString(R.string.count_unit));
            ((TextView) view.findViewById(R.id.tv_empty_stock)).setText(Util.m217a((float) dashboard.vendorInfo.noStockProducts) + getResources().getString(R.string.count_unit));
            ((TextView) view.findViewById(R.id.tv_desktop)).setText(Util.m217a((float) dashboard.vendorInfo.desktopViews) + getResources().getString(R.string.round_unit));
            ((TextView) view.findViewById(R.id.tv_mobile)).setText(Util.m217a((float) dashboard.vendorInfo.mobileViews) + getResources().getString(R.string.round_unit));
            view.findViewById(R.id.mrl_stock).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2614k3.this.m5253d(view2);
                }
            });
            Dashboard.Ticket ticket = dashboard.tickets;
            if (ticket != null && ticket.total != 0) {
                NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_ticket);
                nestedScrollView.setLayoutParams(dashboard.tickets.rows.size() > 3 ? new FrameLayout.LayoutParams(-1, BaseActivity.anInt1 / 2) : new FrameLayout.LayoutParams(-1, -1));
                if (Build.VERSION.SDK_INT >= 23) {
                    nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

                        @Override // androidx.core.widget.NestedScrollView.InterfaceC0581b

                        public final void onScrollChange(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
                            C2614k3.m5227a(view, nestedScrollView2, i, i2, i3, i4);
                        }
                    });
                }
                ((LinearLayoutCompat) view.findViewById(R.id.ll_ticket)).removeAllViews();
                int i = 0;
                while (i < dashboard.tickets.rows.size()) {
                    View inflate = getLayoutInflater().inflate(R.layout.item_ticket_vendor, (ViewGroup) null);
                    inflate.setPadding(Util.dp2px((Context) getActivity(), 10), Util.dp2px((Context) getActivity(), 4), Util.dp2px((Context) getActivity(), 10), Util.dp2px((Context) getActivity(), 4));
                    ((TextView) inflate.findViewById(R.id.tv_status_badge)).setText(Util.m335d(getActivity(), dashboard.tickets.rows.get(i).status.equals("pending") ? "waiting" : dashboard.tickets.rows.get(i).status));
                    ((TextView) inflate.findViewById(R.id.tv_category_name)).setText(Util.m353g(dashboard.tickets.rows.get(i).categoryId));
                    ((TextView) inflate.findViewById(R.id.tv_updated_at)).setText(Util.m307b(dashboard.tickets.rows.get(i).updatedAt));
                    ((TextView) inflate.findViewById(R.id.tv_message)).setText(dashboard.tickets.rows.get(i).message);
                    ((TextView) inflate.findViewById(R.id.tv_user_name)).setText(dashboard.tickets.rows.get(i).fullname);
                    RequestManager m3287a = Glide.with(getActivity());
                    Object[] objArr = new Object[1];
                    objArr[c2] = Integer.valueOf(dashboard.tickets.rows.get(i).avatar);
                    m3287a.load(Util.m345e(java.lang.String.format("e4/uploads/avatars/avatar-%d.jpg", objArr))).load(getActivity().getResources().getDrawable(R.drawable.man)).into((ImageView) inflate.findViewById(R.id.iv_user_avatar));
                    inflate.findViewById(R.id.tv_status_badge).setBackgroundTintList(ColorStateList.valueOf(getActivity().getResources().getColor(getActivity().getResources().getIdentifier(dashboard.tickets.rows.get(i).status, "color", getActivity().getPackageName()))));
                    int finalI = i;
                    inflate.findViewById(R.id.mrl_ticket_item).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.q
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            C2614k3.this.m5244a(dashboard, finalI, view2);
                        }
                    });
                    inflate.findViewById(R.id.ll_main).setPadding(Util.dp2px((Context) getActivity(), 10), Util.dp2px((Context) getActivity(), i == 0 ? 5 : 11), Util.dp2px((Context) getActivity(), 10), Util.dp2px((Context) getActivity(), 11));
                    ((LinearLayoutCompat) view.findViewById(R.id.ll_ticket)).addView(inflate);
                    if (i != dashboard.tickets.rows.size() - 1) {
                        View view2 = new View(getActivity());
                        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, Util.dp2px((Context) getActivity(), 2));
                        ((LinearLayout.LayoutParams) c0541a).leftMargin = Util.dp2px((Context) getActivity(), 20);
                        ((LinearLayout.LayoutParams) c0541a).rightMargin = Util.dp2px((Context) getActivity(), 20);
                        view2.setLayoutParams(c0541a);
                        view2.setBackgroundResource(R.drawable.bg_dotted_line);
                        view2.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                        ((LinearLayoutCompat) view.findViewById(R.id.ll_ticket)).addView(view2);
                    }
                    i++;
                    c2 = 0;
                }
            }
            TextView textView = (TextView) view.findViewById(R.id.tv_open);
            StringBuilder sb = new StringBuilder();
            Dashboard.Ticket ticket2 = dashboard.tickets;
            sb.append(ticket2.total - ticket2.pending);
            sb.append(getResources().getString(R.string.count_unit));
            textView.setText(sb.toString());
            ((TextView) view.findViewById(R.id.tv_pending)).setText(dashboard.tickets.pending + getResources().getString(R.string.count_unit));
        }
    }


    public  void m5238a(final View view, Vendor vendor) {
        final ChartLineView chartLineView = this.f9863h0;
        if (VendorListVM.f10363d.getValue() != null) {
            if (VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                chartLineView.setColorArray(new int[]{getResources().getColor(R.color.chart_secondary)});
            } else if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                chartLineView.setColorArray(new int[]{getResources().getColor(R.color.chart_primary)});
            } else {
                chartLineView.setColorArray(new int[]{getResources().getColor(R.color.chart_primary), getResources().getColor(R.color.chart_secondary)});
            }
        }
        chartLineView.m6816c();
        chartLineView.setShowPopup(3);
        this.f9866k0.f10522d.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.h0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                C2614k3.this.m5243a(chartLineView, view, (DashboardSaleChart) obj);
            }
        });
    }


    public  void m5240a(View view, Date date, Date date2, View view2) {
        this.f9858c0.startDate = Util.date2Str(date);
        this.f9858c0.endDate = Util.date2Str(date2);
        this.f9860e0.setValue( this.f9858c0);
        ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(this.f9858c0.startDate + " ~ " + this.f9858c0.endDate);
    }


    public final void m5241a(MaterialRippleLayout materialRippleLayout, int i) {
        TextView textView = new TextView(getActivity());
        textView.setTextSize(1, 10.5f);
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setGravity(17);
        textView.setLineSpacing(Util.dp2px((Context) getActivity(), 6), 1.0f);
        textView.setPadding(Util.dp2px((Context) getActivity(), 8), Util.dp2px((Context) getActivity(), 8), Util.dp2px((Context) getActivity(), 8), Util.dp2px((Context) getActivity(), 8));
        textView.setText(getResources().getString(i));
        BubblePopup bubblePopup = new BubblePopup(getActivity(), textView);
        bubblePopup.m6907c(materialRippleLayout);
        bubblePopup.m4596a(48);
        BubblePopup bubblePopup2 = bubblePopup;
        if (bubblePopup2.f12222A != null) {
            bubblePopup2.mo4597f();
        }
        bubblePopup2.show();
    }


    public  void m5242a(ChartLineView chartLineView, final View view, DashboardOrderChart dashboardOrderChart) {
        ArrayList<java.lang.String> arrayList = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        ArrayList<Float> arrayList3 = new ArrayList<>();
        ArrayList<Float> arrayList4 = new ArrayList<>();
        this.f9864i0.clear();
        int i = 0;
        while (true) {
            if (i >= (this.f9859d0.selectedInterval.equals(getResources().getString(R.string.today)) ? Math.min(dashboardOrderChart.limit + 1, 24) : dashboardOrderChart.date.size())) {
                break;
            }
            arrayList.add(dashboardOrderChart.date.get(i).length() > 5 ? dashboardOrderChart.date.get(i).substring(5) : dashboardOrderChart.date.get(i));
            arrayList2.add(dashboardOrderChart.total.get(i));
            arrayList3.add(dashboardOrderChart.completed.get(i));
            arrayList4.add(dashboardOrderChart.cancelled.get(i));
            i++;
        }
        this.f9864i0.add(arrayList2);
        this.f9864i0.add(arrayList3);
        this.f9864i0.add(arrayList4);
        chartLineView.setBottomTextList(arrayList);
        chartLineView.setFloatDataList(this.f9864i0);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.s
            @Override // java.lang.Runnable
            public final void run() {
                ((HorizontalScrollView) view.findViewById(R.id.hsv_order_chart)).fullScroll(66);
            }
        }, Status.f8814e);
        ((TextView) view.findViewById(R.id.tv_urgent_orders)).setText(dashboardOrderChart.stats.urgent + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_request_order_count)).setText(dashboardOrderChart.stats.requested.count + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_request_product_count)).setText(dashboardOrderChart.stats.requested.products + getResources().getString(R.string.count_unit));
        PriceText priceText = (PriceText) view.findViewById(R.id.pt_kpf_request_total);
        PriceText priceText2 = (PriceText) view.findViewById(R.id.pt_kpw_request_total);
        priceText.setHidePriceNumber(false);
        priceText2.setHidePriceNumber(false);
        priceText.setVisibility(View.GONE);
        priceText2.setVisibility(View.GONE);
        SubOrder.TotalAmount totalAmount = dashboardOrderChart.stats.requested.total;
        if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
            priceText2.f12264t = true;
        }
        float f = dashboardOrderChart.stats.requested.total.kpf;
        if (f > 0.0f) {
            priceText.setPrice(Util.m327c(f));
            priceText.setVisibility(View.VISIBLE);
        }
        float f2 = dashboardOrderChart.stats.requested.total.kpw;
        if (f2 > 0.0f) {
            priceText2.setPrice(Util.m327c(f2));
            priceText2.setVisibility(View.VISIBLE);
        }
        SubOrder.TotalAmount totalAmount2 = dashboardOrderChart.stats.requested.total;
        if (totalAmount2.kpf == 0.0f && totalAmount2.kpw == 0.0f) {
            if (VendorListVM.f10363d.getValue() != null) {
                if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                    priceText2.setPrice("0");
                    priceText2.setVisibility(View.VISIBLE);
                } else if (!VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                    priceText2.f12264t = true;
                    priceText2.setPrice("0");
                    priceText.setPrice("0");
                    priceText2.setVisibility(View.VISIBLE);
                    priceText.setVisibility(View.VISIBLE);
                }
            }
            priceText.setPrice("0");
            priceText.setVisibility(View.VISIBLE);
        }
        view.findViewById(R.id.mrl_request_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5259f(view2);
            }
        });
        ((TextView) view.findViewById(R.id.tv_completed_order_count)).setText(dashboardOrderChart.stats.completed.count + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_completed_product_count)).setText(dashboardOrderChart.stats.completed.products + getResources().getString(R.string.count_unit));
        PriceText priceText3 = (PriceText) view.findViewById(R.id.pt_kpf_completed_total);
        PriceText priceText4 = (PriceText) view.findViewById(R.id.pt_kpw_completed_total);
        priceText3.setHidePriceNumber(false);
        priceText4.setHidePriceNumber(false);
        priceText4.setVisibility(View.GONE);
        priceText3.setVisibility(View.GONE);
        SubOrder.TotalAmount totalAmount3 = dashboardOrderChart.stats.completed.total;
        if (totalAmount3.kpf > 0.0f && totalAmount3.kpw > 0.0f) {
            priceText4.f12264t = true;
        }
        float f3 = dashboardOrderChart.stats.completed.total.kpf;
        if (f3 > 0.0f) {
            priceText3.setPrice(Util.m327c(f3));
            priceText3.setVisibility(View.VISIBLE);
        }
        float f4 = dashboardOrderChart.stats.completed.total.kpw;
        if (f4 > 0.0f) {
            priceText4.setPrice(Util.m327c(f4));
            priceText4.setVisibility(View.VISIBLE);
        }
        SubOrder.TotalAmount totalAmount4 = dashboardOrderChart.stats.completed.total;
        if (totalAmount4.kpf == 0.0f && totalAmount4.kpw == 0.0f) {
            if (VendorListVM.f10363d.getValue() != null) {
                if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                    priceText4.setPrice("0");
                    priceText4.setVisibility(View.VISIBLE);
                } else if (!VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                    priceText4.f12264t = true;
                    priceText4.setPrice("0");
                    priceText4.setVisibility(View.VISIBLE);
                }
            }
            priceText3.setPrice("0");
            priceText3.setVisibility(View.VISIBLE);
        }
        view.findViewById(R.id.mrl_complete_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5260g(view2);
            }
        });
        ((TextView) view.findViewById(R.id.tv_cancelled_order_count)).setText(dashboardOrderChart.stats.cancelled.count + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_cancelled_product_count)).setText(dashboardOrderChart.stats.cancelled.products + getResources().getString(R.string.count_unit));
        PriceText priceText5 = (PriceText) view.findViewById(R.id.pt_kpf_cancelled_total);
        PriceText priceText6 = (PriceText) view.findViewById(R.id.pt_kpw_cancelled_total);
        priceText5.setHidePriceNumber(false);
        priceText6.setHidePriceNumber(false);
        priceText5.setVisibility(View.GONE);
        priceText6.setVisibility(View.GONE);
        SubOrder.TotalAmount totalAmount5 = dashboardOrderChart.stats.cancelled.total;
        if (totalAmount5.kpf > 0.0f && totalAmount5.kpw > 0.0f) {
            priceText6.f12264t = true;
        }
        float f5 = dashboardOrderChart.stats.cancelled.total.kpf;
        if (f5 > 0.0f) {
            priceText5.setPrice(Util.m327c(f5));
            priceText5.setVisibility(View.VISIBLE);
        }
        float f6 = dashboardOrderChart.stats.cancelled.total.kpw;
        if (f6 > 0.0f) {
            priceText6.setPrice(Util.m327c(f6));
            priceText6.setVisibility(View.VISIBLE);
        }
        SubOrder.TotalAmount totalAmount6 = dashboardOrderChart.stats.cancelled.total;
        if (totalAmount6.kpf == 0.0f && totalAmount6.kpw == 0.0f) {
            if (VendorListVM.f10363d.getValue() != null) {
                if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                    priceText6.setPrice("0");
                    priceText6.setVisibility(View.VISIBLE);
                } else if (!VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                    priceText6.f12264t = true;
                    priceText6.setPrice("0");
                    priceText6.setVisibility(View.VISIBLE);
                }
            }
            priceText5.setPrice("0");
            priceText5.setVisibility(View.VISIBLE);
        }
        view.findViewById(R.id.mrl_cancel_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5261h(view2);
            }
        });
        this.f9867l0--;
        m5266m(view);
    }


    public  void m5243a(ChartLineView chartLineView, final View view, DashboardSaleChart dashboardSaleChart) {
        List<Float> list = null;
        ArrayList<java.lang.String> arrayList = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        ArrayList<Float> arrayList3 = new ArrayList<>();
        this.f9865j0.clear();
        if (VendorListVM.f10363d.getValue() != null) {
            for (int i = 0; i < dashboardSaleChart.date.size(); i++) {
                arrayList.add(dashboardSaleChart.date.get(i).substring(5));
                if (VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                    list = dashboardSaleChart.valueKpf;
                } else if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                    list = dashboardSaleChart.valueKpw;
                } else {
                    arrayList2.add(dashboardSaleChart.valueKpw.get(i));
                    arrayList3.add(dashboardSaleChart.valueKpf.get(i));
                }
                arrayList2.add(list.get(i));
            }
            if (VendorListVM.f10363d.getValue().currency.equals("kpwf")) {
                this.f9865j0.add(arrayList2);
                this.f9865j0.add(arrayList3);
            } else {
                this.f9865j0.add(arrayList2);
            }
        }
        chartLineView.setBottomTextList(arrayList);
        chartLineView.setFloatDataList(this.f9865j0);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.j
            @Override // java.lang.Runnable
            public final void run() {
                ((HorizontalScrollView) view.findViewById(R.id.hsv_chart)).fullScroll(66);
            }
        }, Status.f8814e);
        this.f9867l0--;
        m5266m(view);
        ((TextView) view.findViewById(R.id.tv_selected_period)).setText(this.f9858c0.startDate + " ~ " + this.f9858c0.endDate);
        view.findViewById(R.id.mrl_sold).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5256e(view2);
            }
        });
    }


    public  void m5244a(Dashboard dashboard, int i, View view) {
        Intent intent = new Intent(getActivity(), (dashboard.tickets.rows.get(i).isMarket.booleanValue() ? TicketMarketChatActivity.class : TicketCustomerChatActivity.class));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id", dashboard.tickets.rows.get(i).f12435id);
        intent.putExtra("status", dashboard.tickets.rows.get(i).status);
        intent.putExtra("title", dashboard.tickets.rows.get(i).title);
        intent.putExtra("isDashboard", true);
        getActivity().startActivityForResult(intent, 100);
    }


    public  void m5246b(View view, View view2) {
        m5241a((MaterialRippleLayout) view.findViewById(R.id.mrl_complete), R.string.complete_order_tooltip);
    }


    public  void m5247b(View view, CompoundButton compoundButton, boolean z) {
        m5265l(view);
    }


    public  void m5248b(View view, ChartParam chartParam) {
        if (UserVM.vendorUserMutableLiveData.getValue() == null || UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorAdManager")) {
            return;
        }
        m5268o(view);
        this.f9866k0.m5661b(getContext(), chartParam.startDate, chartParam.endDate);
    }


    public  void m5249b(View view, Date date, Date date2, View view2) {
        this.f9859d0.startDate = Util.date2Str(date);
        this.f9859d0.endDate = Util.date2Str(date2);
        this.f9861f0.setValue( this.f9859d0);
        ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(this.f9859d0.startDate + " ~ " + this.f9859d0.endDate);
    }


    public  void m5250c(View view) {
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivityForVendor.class);
        MainActivityForVendor.global_id = R.id.navigation_products;
        startActivity(intent);
    }


    public  void m5251c(View view, View view2) {
        m5241a((MaterialRippleLayout) view.findViewById(R.id.mrl_cancel), R.string.cancel_order_tooltip);
    }


    public  void m5252c(View view, CompoundButton compoundButton, boolean z) {
        m5264k(view);
    }


    public  void m5253d(View view) {
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivityForVendor.class);
        MainActivityForVendor.global_id = R.id.navigation_products;
        startActivity(intent);
    }


    public  void m5254d(View view, View view2) {
        m5239a(view, "sale");
    }


    public  void m5255d(View view, CompoundButton compoundButton, boolean z) {
        m5264k(view);
    }

    
    public  void m5256e(View view) {
        Intent intent = new Intent(getActivity().getApplicationContext(), VendorFinanceActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.e0
            @Override // java.lang.Runnable
            public final void run() {
                C2614k3.this.m5233U0();
            }
        }, Status.time);
    }

    
    public  void m5257e(View view, View view2) {
        m5239a(view, "order");
    }

    
    public  void m5258e(View view, CompoundButton compoundButton, boolean z) {
        m5264k(view);
    }

    /* renamed from: f */
    public  void m5259f(View view) {
        ModelCollection.f10221l.setValue("requested");
        MainActivityForVendor.global_id = R.id.navigation_orders;
        Intent intent = new Intent(getActivity(), MainActivityForVendor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /* renamed from: g */
    public  void m5260g(View view) {
        ModelCollection.f10221l.setValue("completed");
        MainActivityForVendor.global_id = R.id.navigation_orders;
        Intent intent = new Intent(getActivity(), MainActivityForVendor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        startActivity(intent);
    }

    /* renamed from: h */
    public  void m5261h(View view) {
        ModelCollection.f10221l.setValue("cancelled");
        MainActivityForVendor.global_id = R.id.navigation_orders;
        Intent intent = new Intent(getActivity(), MainActivityForVendor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    
    public  void m5262i(View view) {
        this.f9868m0 = true;
        m5268o(view);
        if (this.f9861f0.getValue() != null) {
            this.f9866k0.m5661b(getContext(), this.f9861f0.getValue().startDate, this.f9861f0.getValue().endDate);
        }
        if (this.f9860e0.getValue() != null) {
            this.f9866k0.m5662c(getContext(), this.f9860e0.getValue().startDate, this.f9860e0.getValue().endDate);
        }
        VendorListVM.m5565b(getContext());
        m5263j(view);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
   
    public void m5263j(final View view) {
        VendorListVM.f10364e.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.b0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                C2614k3.this.m5237a(view, (Dashboard) obj);
            }
        });
    }

    
    public final void m5264k(View view) {
        ChartLineView chartLineView = this.f9862g0;
        int[] iArr = new int[3];
        iArr[0] = ((CheckBox) view.findViewById(R.id.ccb_requested)).isChecked() ? getResources().getColor(R.color.chart_primary) : 0;
        iArr[1] = ((CheckBox) view.findViewById(R.id.ccb_completed)).isChecked() ? getResources().getColor(R.color.chart_secondary) : 0;
        iArr[2] = ((CheckBox) view.findViewById(R.id.ccb_cancelled)).isChecked() ? getResources().getColor(R.color.red) : 0;
        chartLineView.setColorArray(iArr);
        this.f9862g0.m6815b();
        ArrayList<ArrayList<Float>> arrayList = this.f9864i0;
        if (arrayList != null) {
            this.f9862g0.setFloatDataList(arrayList);
        }
    }

    /* renamed from: l */
    public final void m5265l(View view) {
        ChartLineView chartLineView = this.f9863h0;
        int[] iArr = new int[2];
        iArr[0] = ((CheckBox) view.findViewById(R.id.ccb_kpf)).isChecked() ? getResources().getColor(R.color.chart_secondary) : 0;
        iArr[1] = ((CheckBox) view.findViewById(R.id.ccb_kpw)).isChecked() ? getResources().getColor(R.color.chart_primary) : 0;
        chartLineView.setColorArray(iArr);
        this.f9863h0.m6815b();
        ArrayList<ArrayList<Float>> arrayList = this.f9865j0;
        if (arrayList != null) {
            this.f9863h0.setFloatDataList(arrayList);
        }
    }

    /* renamed from: m */
    public final void m5266m(View view) {
        if (this.f9867l0 <= 0) {
            ((ActionLink) CustomString.m3151a(this, R.color.transparent, view.findViewById(R.id.ll_order_chart_unit_selector), view, R.id.cal_display_order_chart_unit_selector)).setmTextViewColor(BaseActivity.color);
            ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setImageViewColor(BaseActivity.color);
            view.findViewById(R.id.cal_display_order_chart_unit_selector).setPadding(Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 5), Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 6));
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a.setMargins(0, 0, 0, Util.dp2px(getContext(), 10));
            view.findViewById(R.id.ll_action_group).setLayoutParams(c0541a);
            LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a2.setMargins(0, 0, 0, 0);
            view.findViewById(R.id.ll_check_box).setLayoutParams(c0541a2);
            view.findViewById(R.id.hsv_order_chart).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
            LinearLayoutCompat.LayoutParams c0541a3 = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a3.setMargins(0, 0, 0, Util.dp2px(getContext(), 16));
            view.findViewById(R.id.hsv_order_chart).setLayoutParams(c0541a3);
            view.findViewById(R.id.v_order_line_view).setAlpha(1.0f);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_urgent_order_label), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_urgent_orders), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_label), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_order_label), R.color.light);
            CustomString.m3165a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_order_count), R.color.dark, view, R.id.tv_request_count_shimmer, 8, R.id.ll_order_count, 0);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_product_count_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_product_count), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_label), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_order_label), R.color.light);
            CustomString.m3165a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_order_count), R.color.dark, view, R.id.tv_completed_count_shimmer, 8, R.id.ll_completed_order_count, 0);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_product_count_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_product_count), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_label), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_order_label), R.color.light);
            CustomString.m3165a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_order_count), R.color.dark, view, R.id.tv_cancelled_count_shimmer, 8, R.id.ll_cancelled_order_count, 0);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_product_count_label), R.color.light);
            CustomString.m3165a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_product_count), R.color.dark, view, R.id.iv_request, 0, R.id.iv_request_shimmer, 8);
            CustomString.m3167a(view, R.id.iv_complete, 0, R.id.iv_complete_shimmer, 8);
            CustomString.m3167a(view, R.id.iv_cancel, 0, R.id.iv_cancel_shimmer, 8);
            CustomString.m3165a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_order_chart_title), R.color.dark, view, R.id.tv_requested, 8, R.id.tv_completed, 8);
            CustomString.m3167a(view, R.id.tv_cancelled, 8, R.id.ccb_requested, 0);
            CustomString.m3167a(view, R.id.ccb_completed, 0, R.id.ccb_cancelled, 0);
            ((ShimmerFrameLayout) view.findViewById(R.id.sfl_layout)).hideShimmer();
            ((ActionLink) CustomString.m3151a(this, R.color.transparent, view.findViewById(R.id.ll_unit_selector), view, R.id.cal_chart_unit)).setmTextViewColor(BaseActivity.color);
            ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setImageViewColor(BaseActivity.color);
            view.findViewById(R.id.cal_chart_unit).setPadding(Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 5), Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 6));
            LinearLayoutCompat.LayoutParams c0541a4 = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a4.setMargins(0, 0, 0, 0);
            view.findViewById(R.id.llc_action_group).setLayoutParams(c0541a4);
            CustomString.m3151a(this, R.color.transparent, view.findViewById(R.id.hsv_chart), view, R.id.v_sale_line_view).setAlpha(1.0f);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_selected_period_label), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_selected_period), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_sale_total_label), R.color.body);
            view.findViewById(R.id.tv_sale_total).setVisibility(View.GONE);
            DashboardSaleChart getValue = this.f9866k0.f10522d.getValue();
            if (getValue != null) {
                PriceText priceText = (PriceText) view.findViewById(R.id.pt_kpf_sale_total);
                PriceText priceText2 = (PriceText) view.findViewById(R.id.pt_kpw_sale_total);
                priceText.setHidePriceNumber(false);
                priceText2.setHidePriceNumber(false);
                priceText.setVisibility(View.GONE);
                priceText2.setVisibility(View.GONE);
                SubOrder.TotalAmount totalAmount = getValue.total;
                if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
                    priceText2.f12264t = true;
                }
                float f = getValue.total.kpf;
                if (f > 0.0f) {
                    priceText.setPrice(Util.m327c(f));
                    priceText.setVisibility(View.VISIBLE);
                }
                float f2 = getValue.total.kpw;
                if (f2 > 0.0f) {
                    priceText2.setPrice(Util.m327c(f2));
                    priceText2.setVisibility(View.VISIBLE);
                }
                SubOrder.TotalAmount totalAmount2 = getValue.total;
                if (totalAmount2.kpf == 0.0f && totalAmount2.kpw == 0.0f) {
                    if (VendorListVM.f10363d.getValue() != null) {
                        if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                            priceText2.setPrice("0");
                        } else if (!VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                            priceText2.f12264t = true;
                            priceText.setPrice("0");
                            priceText2.setPrice("0");
                            priceText.setVisibility(View.VISIBLE);
                        }
                        priceText2.setVisibility(View.VISIBLE);
                    }
                    priceText.setPrice("0");
                    priceText.setVisibility(View.VISIBLE);
                }
            }
            CustomString.m3165a(getContext(), (android.widget.TextView) view.findViewById(R.id.ctv_products_total_label), R.color.dark, view, R.id.tv_kpw, 8, R.id.tv_kpf, 8);
            if (VendorListVM.f10363d.getValue() == null || !VendorListVM.f10363d.getValue().currency.equals("kpwf")) {
                view.findViewById(R.id.ll_sale_check_box).setVisibility(View.GONE);
            } else {
                CustomString.m3167a(view, R.id.ccb_kpw, 0, R.id.ccb_kpf, 0);
                view.findViewById(R.id.ll_sale_check_box).setVisibility(View.VISIBLE);
            }
            ((ShimmerFrameLayout) view.findViewById(R.id.sfl_dashboard_chart)).hideShimmer();
            CustomString.m3151a(this, R.color.blue_bg, view.findViewById(R.id.ll_product), view, R.id.iv_product).setVisibility(View.VISIBLE);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_product_label), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_approved_product_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_approved_product), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_unapproved_product_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_unapproved_product), R.color.dark);
            CustomString.m3151a(this, R.color.red_bg, view.findViewById(R.id.ll_stock), view, R.id.iv_stock).setVisibility(View.VISIBLE);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_stock_label), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_out_of_stock_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_low_stock), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_empty_stock_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_empty_stock), R.color.dark);
            CustomString.m3151a(this, R.color.yellow_bg, view.findViewById(R.id.ll_views), view, R.id.iv_views).setVisibility(View.VISIBLE);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_views), R.color.body);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_desktop_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_desktop), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_mobile_label), R.color.light);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_mobile), R.color.dark);
            Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.ctv_product_label), R.color.dark);
            ((ShimmerFrameLayout) view.findViewById(R.id.sfl_dashboard_overview)).hideShimmer();
            view.findViewById(R.id.ll_ticket_result).setVisibility(View.VISIBLE);
        }
    }

    /* renamed from: n */
    public void m5267n(final View view) {
        ((MainActivityForVendor) getActivity()).setClickEvent(view);
        view.findViewById(R.id.cal_chart_unit).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5254d(view, view2);
            }
        });
        view.findViewById(R.id.cal_display_order_chart_unit_selector).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5257e(view, view2);
            }
        });
        ((CheckBox) view.findViewById(R.id.ccb_requested)).setChecked(true);
        ((CheckBox) view.findViewById(R.id.ccb_completed)).setChecked(true);
        ((CheckBox) view.findViewById(R.id.ccb_cancelled)).setChecked(true);
        ((CheckBox) view.findViewById(R.id.ccb_requested)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.b.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C2614k3.this.m5252c(view, compoundButton, z);
            }
        });
        ((CheckBox) view.findViewById(R.id.ccb_completed)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.b.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C2614k3.this.m5255d(view, compoundButton, z);
            }
        });
        ((CheckBox) view.findViewById(R.id.ccb_cancelled)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.b.g0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C2614k3.this.m5258e(view, compoundButton, z);
            }
        });
        ((CheckBox) view.findViewById(R.id.ccb_kpw)).setChecked(true);
        ((CheckBox) view.findViewById(R.id.ccb_kpf)).setChecked(true);
        ((CheckBox) view.findViewById(R.id.ccb_kpw)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.b.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C2614k3.this.m5235a(view, compoundButton, z);
            }
        });
        ((CheckBox) view.findViewById(R.id.ccb_kpf)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.b.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C2614k3.this.m5247b(view, compoundButton, z);
            }
        });
        view.findViewById(R.id.mrl_request).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5234a(view, view2);
            }
        });
        view.findViewById(R.id.mrl_complete).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5246b(view, view2);
            }
        });
        view.findViewById(R.id.mrl_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2614k3.this.m5251c(view, view2);
            }
        });
    }

    /* renamed from: o */
    public final void m5268o(View view) {
        ((ActionLink) CustomString.m3151a(this, R.color.grey_bg, view.findViewById(R.id.ll_order_chart_unit_selector), view, R.id.cal_display_order_chart_unit_selector)).setmTextViewColor(R.color.transparent);
        ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setImageViewColor(R.color.transparent);
        view.findViewById(R.id.cal_display_order_chart_unit_selector).setPadding(Util.dp2px(getContext(), 10), 0, Util.dp2px(getContext(), 10), 0);
        view.findViewById(R.id.hsv_order_chart).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_bg)));
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, 0, 0, Util.dp2px(getContext(), 10));
        view.findViewById(R.id.ll_check_box).setLayoutParams(c0541a);
        view.findViewById(R.id.v_order_line_view).setAlpha(0.0f);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_urgent_order_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_urgent_orders));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_order_label));
        CustomString.m3166a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_order_count), view, R.id.tv_request_count_shimmer, 0, R.id.ll_order_count, 8);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_product_count_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_request_product_count));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_order_label));
        CustomString.m3166a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_order_count), view, R.id.tv_completed_count_shimmer, 0, R.id.ll_completed_order_count, 8);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_product_count_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_completed_product_count));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_order_label));
        CustomString.m3166a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_order_count), view, R.id.tv_cancelled_count_shimmer, 0, R.id.ll_cancelled_order_count, 8);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_product_count_label));
        CustomString.m3166a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_cancelled_product_count), view, R.id.iv_request, 8, R.id.iv_request_shimmer, 0);
        CustomString.m3167a(view, R.id.iv_complete, 8, R.id.iv_complete_shimmer, 0);
        CustomString.m3167a(view, R.id.iv_cancel, 8, R.id.iv_cancel_shimmer, 0);
        CustomString.m3166a(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_order_chart_title), view, R.id.tv_requested, 0, R.id.tv_completed, 0);
        CustomString.m3167a(view, R.id.tv_cancelled, 0, R.id.ccb_requested, 8);
        CustomString.m3167a(view, R.id.ccb_completed, 8, R.id.ccb_cancelled, 8);
        ((ShimmerFrameLayout) view.findViewById(R.id.sfl_layout)).showShimmer(true);
        ((ShimmerFrameLayout) view.findViewById(R.id.sfl_dashboard_chart)).showShimmer(true);
        ((ActionLink) CustomString.m3151a(this, R.color.grey_bg, view.findViewById(R.id.ll_unit_selector), view, R.id.cal_chart_unit)).setmTextViewColor(R.color.transparent);
        ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setImageViewColor(R.color.transparent);
        view.findViewById(R.id.cal_chart_unit).setPadding(Util.dp2px(getContext(), 10), 0, Util.dp2px(getContext(), 10), 0);
        CustomString.m3151a(this, R.color.grey_bg, view.findViewById(R.id.hsv_chart), view, R.id.v_sale_line_view).setAlpha(0.0f);
        LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a2.setMargins(0, 0, 0, Util.dp2px(getContext(), 10));
        view.findViewById(R.id.llc_action_group).setLayoutParams(c0541a2);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_selected_period_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_selected_period));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_sale_total_label));
        CustomString.m3166a(getContext(), (android.widget.TextView) view.findViewById(R.id.ctv_products_total_label), view, R.id.tv_sale_total, 0, R.id.pt_kpf_sale_total, 8);
        CustomString.m3167a(view, R.id.pt_kpw_sale_total, 8, R.id.tv_kpw, 0);
        CustomString.m3167a(view, R.id.tv_kpf, 0, R.id.ccb_kpw, 8);
        view.findViewById(R.id.ccb_kpf).setVisibility(View.GONE);
        view.findViewById(R.id.ll_product).setBackgroundResource(R.drawable.bg_grey_round);
        CustomString.m3151a(this, R.color.grey_bg, view.findViewById(R.id.ll_product), view, R.id.iv_product).setVisibility(View.GONE);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_product_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_approved_product_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_approved_product));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_unapproved_product_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_unapproved_product));
        view.findViewById(R.id.ll_stock).setBackgroundResource(R.drawable.bg_grey_round);
        CustomString.m3151a(this, R.color.grey_bg, view.findViewById(R.id.ll_stock), view, R.id.iv_stock).setVisibility(View.GONE);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_stock_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_out_of_stock_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_low_stock));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_empty_stock_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_empty_stock));
        view.findViewById(R.id.ll_views).setBackgroundResource(R.drawable.bg_grey_round);
        CustomString.m3151a(this, R.color.grey_bg, view.findViewById(R.id.ll_views), view, R.id.iv_views).setVisibility(View.GONE);
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_views));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_desktop_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_desktop));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_mobile_label));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.tv_mobile));
        Util.setColor(getContext(), (android.widget.TextView) view.findViewById(R.id.ctv_product_label));
        ((ShimmerFrameLayout) view.findViewById(R.id.sfl_dashboard_overview)).showShimmer(true);
        view.findViewById(R.id.ll_ticket_result).setVisibility(View.GONE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x01cf. Please report as an issue. */

    public  void m5245a(java.lang.String str, final View view, BaseDialog2 baseDialog2, View view2, int i) {
        Picker4 picker4;
        InterfaceC2111c interfaceC2111c;
        MutableLiveData<ChartParam> mutableLiveData;
        ChartParam chartParam;
        ChartParam chartParam2;
        java.lang.String string;
        Resources m2475L;
        int i2;
        ChartParam chartParam3;
        Date date;
        ChartParam chartParam4;
        Date date2;
        java.lang.String date2Str;
        Date date3 = new Date();
        if (str.equals("sale")) {
            switch (i) {
                case 0:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.recent_one_week));
                    chartParam3 = this.f9858c0;
                    date = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 6);
                    chartParam3.startDate = Util.date2Str(date);
                    chartParam4 = this.f9858c0;
                    date2Str = Util.date2Str(date3);
                    chartParam4.endDate = date2Str;
                    break;
                case 1:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.current_week));
                    chartParam3 = this.f9858c0;
                    date = new Date(date3.getYear(), date3.getMonth(), (date3.getDate() - date3.getDay()) + 1);
                    chartParam3.startDate = Util.date2Str(date);
                    chartParam4 = this.f9858c0;
                    date2Str = Util.date2Str(date3);
                    chartParam4.endDate = date2Str;
                    break;
                case 2:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.prev_week));
                    this.f9858c0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), (date3.getDate() - date3.getDay()) - 6));
                    chartParam4 = this.f9858c0;
                    date2 = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - date3.getDay());
                    date2Str = Util.date2Str(date2);
                    chartParam4.endDate = date2Str;
                    break;
                case 3:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.recent_one_month));
                    chartParam3 = this.f9858c0;
                    date = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 29);
                    chartParam3.startDate = Util.date2Str(date);
                    chartParam4 = this.f9858c0;
                    date2Str = Util.date2Str(date3);
                    chartParam4.endDate = date2Str;
                    break;
                case 4:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.current_month));
                    chartParam3 = this.f9858c0;
                    date = new Date(date3.getYear(), date3.getMonth(), 1);
                    chartParam3.startDate = Util.date2Str(date);
                    chartParam4 = this.f9858c0;
                    date2Str = Util.date2Str(date3);
                    chartParam4.endDate = date2Str;
                    break;
                case 5:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.prev_month));
                    this.f9858c0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth() - 1, 1));
                    chartParam4 = this.f9858c0;
                    date2 = new Date(date3.getYear(), date3.getMonth(), 0);
                    date2Str = Util.date2Str(date2);
                    chartParam4.endDate = date2Str;
                    break;
                case 6:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.current_year));
                    chartParam3 = this.f9858c0;
                    date = new Date(date3.getYear(), 0, 1);
                    chartParam3.startDate = Util.date2Str(date);
                    chartParam4 = this.f9858c0;
                    date2Str = Util.date2Str(date3);
                    chartParam4.endDate = date2Str;
                    break;
                case 7:
                    ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(this.f9858c0.startDate + " ~ " + this.f9858c0.endDate);
                    break;
            }
            if (i != 7) {
                mutableLiveData = this.f9860e0;
                chartParam = this.f9858c0;
                mutableLiveData.setValue( chartParam);
            } else {
                this.f9856a0.m4704a();
                picker4 = this.f9856a0;
                interfaceC2111c = new InterfaceC2111c() { // from class: b.f.a.g.d.b.n
                    @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

                    public final void mo4696a(Date date4, Date date5, View view3) {
                        C2614k3.this.m5240a(view, date4, date5, view3);
                    }
                };
                picker4.f8616c = interfaceC2111c;
            }
        } else if (str.equals("order")) {
            switch (i) {
                case 0:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.today));
                    this.f9859d0.startDate = Util.date2Str(date3);
                    this.f9859d0.endDate = Util.date2Str(date3);
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.today);
                    chartParam2.selectedInterval = string;
                    break;
                case 1:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.yesterday));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 1));
                    this.f9859d0.endDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 1));
                    chartParam2 = this.f9859d0;
                    m2475L = getResources();
                    i2 = R.string.yesterday;
                    string = m2475L.getString(i2);
                    chartParam2.selectedInterval = string;
                    break;
                case 2:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.recent_one_week));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 6));
                    this.f9859d0.endDate = Util.date2Str(date3);
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.recent_one_week);
                    chartParam2.selectedInterval = string;
                    break;
                case 3:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.current_week));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), (date3.getDate() - date3.getDay()) + 1));
                    this.f9859d0.endDate = Util.date2Str(date3);
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.current_week);
                    chartParam2.selectedInterval = string;
                    break;
                case 4:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.prev_week));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), (date3.getDate() - date3.getDay()) - 6));
                    this.f9859d0.endDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), date3.getDate() - date3.getDay()));
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.prev_week);
                    chartParam2.selectedInterval = string;
                    break;
                case 5:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.recent_one_month));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 29));
                    this.f9859d0.endDate = Util.date2Str(date3);
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.recent_one_month);
                    chartParam2.selectedInterval = string;
                    break;
                case 6:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.current_month));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), 1));
                    this.f9859d0.endDate = Util.date2Str(date3);
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.current_month);
                    chartParam2.selectedInterval = string;
                    break;
                case 7:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.prev_month));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth() - 1, 1));
                    this.f9859d0.endDate = Util.date2Str(new Date(date3.getYear(), date3.getMonth(), 0));
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.prev_month);
                    chartParam2.selectedInterval = string;
                    break;
                case 8:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.current_year));
                    this.f9859d0.startDate = Util.date2Str(new Date(date3.getYear(), 0, 1));
                    this.f9859d0.endDate = Util.date2Str(date3);
                    chartParam2 = this.f9859d0;
                    string = getResources().getString(R.string.current_year);
                    chartParam2.selectedInterval = string;
                    break;
                case 9:
                    ((ActionLink) view.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(this.f9859d0.startDate + " ~ " + this.f9859d0.endDate);
                    chartParam2 = this.f9859d0;
                    m2475L = getResources();
                    i2 = R.string.select_date;
                    string = m2475L.getString(i2);
                    chartParam2.selectedInterval = string;
                    break;
            }
            if (i != 9) {
                mutableLiveData = this.f9861f0;
                chartParam = this.f9859d0;
                mutableLiveData.setValue( chartParam);
            } else {
                this.f9857b0.m4704a();
                picker4 = this.f9857b0;
                interfaceC2111c = new InterfaceC2111c() { // from class: b.f.a.g.d.b.w
                    @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

                    public final void mo4696a(Date date4, Date date5, View view3) {
                        C2614k3.this.m5249b(view, date4, date5, view3);
                    }
                };
                picker4.f8616c = interfaceC2111c;
            }
        }
        baseDialog2.startAni();
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_vendor_home, viewGroup, false);
        this.f9869n0 = (WaveSwipeRefreshLayout) inflate.findViewById(R.id.wsr_layout);
        WaveSwipeRefreshLayout waveSwipeRefreshLayout = this.f9869n0;
        if (waveSwipeRefreshLayout != null) {
            waveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.InterfaceC3256c() { // from class: b.f.a.g.d.b.v
                @Override // com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout.InterfaceC3256c

                public final void mo4970a() {
                    C2614k3.this.m5262i(inflate);
                }
            });
        }
        NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            BaseActivity activityC1391g1 = (MainActivityForVendor) getActivity();
            activityC1391g1.m4286a((View) nestedScrollView, activityC1391g1, inflate, false);
            nestedScrollView.setTag(Integer.valueOf(R.id.wsr_layout));
        }
        this.f9867l0 = (UserVM.vendorUserMutableLiveData.getValue() == null || UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorAdManager")) ? 2 : 3;
        m5231S0();
        VendorListVM.m5565b(getContext());
        m5263j(inflate);
        this.f9866k0 = (AnalyticsProvider) new ViewModelProvider(this).get(AnalyticsProvider.class);
        this.f9863h0 = (ChartLineView) inflate.findViewById(R.id.v_sale_line_view);
        VendorListVM.f10363d.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.x
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                C2614k3.this.m5238a(inflate, (Vendor) obj);
            }
        });
        ((ActionLink) inflate.findViewById(R.id.cal_chart_unit)).setText(getResources().getString(R.string.recent_one_week));
        Date date = new Date();
        this.f9858c0.startDate = Util.date2Str(new Date(date.getYear(), date.getMonth(), date.getDate() - 6));
        this.f9858c0.endDate = Util.date2Str(date);
        this.f9860e0.setValue( this.f9858c0);
        this.f9860e0.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.e
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                C2614k3.this.m5236a(inflate, (ChartParam) obj);
            }
        });
        this.f9862g0 = (ChartLineView) inflate.findViewById(R.id.v_order_line_view);
        final ChartLineView chartLineView = this.f9862g0;
        chartLineView.setColorArray(new int[]{getResources().getColor(R.color.chart_primary), getResources().getColor(R.color.chart_secondary), getResources().getColor(R.color.red)});
        chartLineView.m6816c();
        chartLineView.setShowPopup(3);
        this.f9866k0.f10523e.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.f
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                C2614k3.this.m5242a(chartLineView, inflate, (DashboardOrderChart) obj);
            }
        });
        ((ActionLink) inflate.findViewById(R.id.cal_display_order_chart_unit_selector)).setText(getResources().getString(R.string.today));
        this.f9859d0.startDate = Util.date2Str(date);
        this.f9859d0.endDate = Util.date2Str(date);
        this.f9859d0.selectedInterval = getResources().getString(R.string.today);
        this.f9861f0.setValue( this.f9859d0);
        this.f9861f0.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.d0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                C2614k3.this.m5248b(inflate, (ChartParam) obj);
            }
        });
        m5268o(inflate);
        UserVM.vendorUserMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.l
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                C2614k3.m5228a(inflate, (VendorUser) obj);
            }
        });
        m5267n(inflate);
        inflate.findViewById(R.id.header_border).setVisibility(View.GONE);
        return inflate;
    }

    @SuppressLint({"SetTextI18n"})

    public void m5239a(final View view, final java.lang.String str) {
        java.lang.String[] strArr = {getResources().getString(R.string.recent_one_week), getResources().getString(R.string.current_week), getResources().getString(R.string.prev_week), getResources().getString(R.string.recent_one_month), getResources().getString(R.string.current_month), getResources().getString(R.string.prev_month), getResources().getString(R.string.current_year), getResources().getString(R.string.select_date)};
        java.lang.String[] strArr2 = {getResources().getString(R.string.today), getResources().getString(R.string.yesterday), getResources().getString(R.string.recent_one_week), getResources().getString(R.string.current_week), getResources().getString(R.string.prev_week), getResources().getString(R.string.recent_one_month), getResources().getString(R.string.current_month), getResources().getString(R.string.prev_month), getResources().getString(R.string.current_year), getResources().getString(R.string.select_date)};
        Context m2557p = getContext();
        if (str.equals("sale")) {
            strArr2 = strArr;
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(m2557p, strArr2);
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.r
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                C2614k3.this.m5245a(str, view, baseDialog2, view2, i);
            }
        };
    }
}
