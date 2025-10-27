package com.jeil.emarket.frag.analy.analy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.balysv.materialripple.MaterialRippleLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.activities.seller.AnalyticsActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.ChartLineView;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.components.vendor.VendorLevel;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.custom.font.CredValue;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.AnalyticsOverviewData;
import com.jeil.emarket.model.vendor.ChartParam;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.providers.AnalyticsProvider;
import com.jeil.emarket.viewmodel.VendorListVM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.d.a.p0 */

public class FragmentAnalyticsOverView extends Fragment {

    /* renamed from: a0 */
    public BaseActivity f9711a0;

    /* renamed from: b0 */
    public AnalyticsProvider f9712b0;

    /* renamed from: c0 */
    public Picker4 f9713c0;

    /* renamed from: g0 */
    public ChartLineView f9717g0;

    /* renamed from: d0 */
    public ChartParam f9714d0 = new ChartParam();

    /* renamed from: e0 */
    public boolean f9715e0 = false;

    /* renamed from: f0 */
    public MutableLiveData<ChartParam> f9716f0 = new MutableLiveData<>();

    /* renamed from: h0 */
    public ArrayList<ArrayList<Float>> f9718h0 = new ArrayList<>();

    public FragmentAnalyticsOverView(BaseActivity activityC1391g1) {
        this.f9711a0 = activityC1391g1;
    }

    /* renamed from: S0 */
    public void m5194S0() {
        this.f9713c0 = new Picker4(getContext());
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), 0, 1);
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f9713c0.f8615b;
        viewOnClickListenerC2123h.f8694c.f8669s = calendar;
        viewOnClickListenerC2123h.m4728f();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5));
        ViewOnClickListenerC2123h viewOnClickListenerC2123h2 = this.f9713c0.f8615b;
        viewOnClickListenerC2123h2.f8694c.f8670t = calendar2;
        viewOnClickListenerC2123h2.m4728f();
    }


    public  void m5195a(DialogInterface dialogInterface) {
        this.f9715e0 = false;
    }


    public  void m5197a(View view, CompoundButton compoundButton, boolean z) {
        m5206e(view);
    }


    public  void m5199a(View view, ChartParam chartParam) {
        view.findViewById(R.id.llc_unit_selector).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_bg)));
        ((ActionLink) view.findViewById(R.id.cal_display_unit_selector)).setmTextViewColor(R.color.transparent);
        ((ActionLink) view.findViewById(R.id.cal_display_unit_selector)).setImageViewColor(R.color.transparent);
        view.findViewById(R.id.cal_display_unit_selector).setPadding(Util.dp2px(getContext(), 10), 0, Util.dp2px(getContext(), 10), 0);
        view.findViewById(R.id.hsv_chart).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_bg)));
        view.findViewById(R.id.v_sale_line_view).setAlpha(0.0f);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, 0, 0, Util.dp2px(getContext(), 10));
        view.findViewById(R.id.llc_action_group).setLayoutParams(c0541a);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_label));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_order_label));
        CustomString.m3166a(getContext(), (TextView) view.findViewById(R.id.tv_request_order_count), view, R.id.tv_request_count_shimmer, 0, R.id.ll_order_count, 8);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_product_count_label));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_product_count));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_label));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_order_label));
        CustomString.m3166a(getContext(), (TextView) view.findViewById(R.id.tv_completed_order_count), view, R.id.tv_completed_count_shimmer, 0, R.id.ll_completed_order_count, 8);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_product_count_label));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_product_count));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_label));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_order_label));
        CustomString.m3166a(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_order_count), view, R.id.tv_cancelled_count_shimmer, 0, R.id.ll_cancelled_order_count, 8);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_product_count_label));
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_product_count));
        CustomString.m3166a(getContext(), (TextView) view.findViewById(R.id.ctv_products_total_label), view, R.id.ll_vendor_point, 8, R.id.ll_shimmer_point, 0);
        CustomString.m3167a(view, R.id.tv_kpw, 0, R.id.tv_kpf, 0);
        CustomString.m3167a(view, R.id.ccb_kpw, 8, R.id.ccb_kpf, 8);
        ((ShimmerFrameLayout) view.findViewById(R.id.sfl_chart)).showShimmer(true);
        this.f9712b0.m5659a(getContext(), chartParam.startDate, chartParam.endDate);
    }


    public  void m5201a(View view, Date date, Date date2, View view2) {
        this.f9714d0.startDate = Util.date2Str(date);
        this.f9714d0.endDate = Util.date2Str(date2);
        this.f9716f0.setValue( this.f9714d0);
        ((ActionLink) view.findViewById(R.id.cal_display_unit_selector)).setText(this.f9714d0.startDate + " ~ " + this.f9714d0.endDate);
    }

    
    public  void m5203b(View view, CompoundButton compoundButton, boolean z) {
        m5206e(view);
    }

    
    public  void m5204c(View view) {
        ((AnalyticsActivity) this.f9711a0).m6580R();
    }

    
    public  void m5205d(View view) {
        this.f9711a0.close();
    }

    
    public final void m5206e(View view) {
        ChartLineView chartLineView = this.f9717g0;
        int[] iArr = new int[2];
        iArr[0] = ((CheckBox) view.findViewById(R.id.ccb_kpw)).isChecked() ? getResources().getColor(R.color.chart_primary) : 0;
        iArr[1] = ((CheckBox) view.findViewById(R.id.ccb_kpf)).isChecked() ? getResources().getColor(R.color.chart_secondary) : 0;
        chartLineView.setColorArray(iArr);
        this.f9717g0.m6815b();
        ArrayList<ArrayList<Float>> arrayList = this.f9718h0;
        if (arrayList != null) {
            this.f9717g0.setFloatDataList(arrayList);
        }
    }


    public  void m5202a(ChartLineView chartLineView, final View view, AnalyticsOverviewData analyticsOverviewData) {
        List<Float> list = null;
        ArrayList<java.lang.String> arrayList = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        ArrayList<Float> arrayList3 = new ArrayList<>();
        this.f9718h0.clear();
        if (VendorListVM.f10363d.getValue() != null) {
            for (int i = 0; i < analyticsOverviewData.date.size(); i++) {
                arrayList.add(analyticsOverviewData.date.get(i).substring(5));
                if (VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                    list = analyticsOverviewData.valueKpf;
                } else if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                    list = analyticsOverviewData.valueKpw;
                } else {
                    arrayList2.add(analyticsOverviewData.valueKpw.get(i));
                    arrayList3.add(analyticsOverviewData.valueKpf.get(i));
                }
                arrayList2.add(list.get(i));
            }
            if (VendorListVM.f10363d.getValue().currency.equals("kpwf")) {
                this.f9718h0.add(arrayList2);
                this.f9718h0.add(arrayList3);
            } else {
                this.f9718h0.add(arrayList2);
            }
        }
        chartLineView.setBottomTextList(arrayList);
        chartLineView.setFloatDataList(this.f9718h0);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.a.e0
            @Override // java.lang.Runnable
            public final void run() {
                ((HorizontalScrollView) view.findViewById(R.id.hsv_chart)).fullScroll(66);
            }
        }, Status.f8814e);
        view.findViewById(R.id.llc_unit_selector).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        ((ActionLink) view.findViewById(R.id.cal_display_unit_selector)).setmTextViewColor(BaseActivity.color);
        ((ActionLink) view.findViewById(R.id.cal_display_unit_selector)).setImageViewColor(BaseActivity.color);
        view.findViewById(R.id.cal_display_unit_selector).setPadding(Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 5), Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 6));
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, 0, 0, 0);
        view.findViewById(R.id.llc_action_group).setLayoutParams(c0541a);
        view.findViewById(R.id.hsv_chart).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a2.setMargins(0, 0, 0, Util.dp2px(getContext(), 16));
        view.findViewById(R.id.hsv_chart).setLayoutParams(c0541a2);
        view.findViewById(R.id.v_sale_line_view).setAlpha(1.0f);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_label), R.color.body);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_order_label), R.color.light);
        CustomString.m3165a(getContext(), (TextView) view.findViewById(R.id.tv_request_order_count), R.color.dark, view, R.id.tv_request_count_shimmer, 8, R.id.ll_order_count, 0);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_product_count_label), R.color.light);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_request_product_count), R.color.dark);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_label), R.color.body);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_order_label), R.color.light);
        CustomString.m3165a(getContext(), (TextView) view.findViewById(R.id.tv_completed_order_count), R.color.dark, view, R.id.tv_completed_count_shimmer, 8, R.id.ll_completed_order_count, 0);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_product_count_label), R.color.light);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_completed_product_count), R.color.dark);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_label), R.color.body);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_order_label), R.color.light);
        CustomString.m3165a(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_order_count), R.color.dark, view, R.id.tv_cancelled_count_shimmer, 8, R.id.ll_cancelled_order_count, 0);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_product_count_label), R.color.light);
        Util.setColor(getContext(), (TextView) view.findViewById(R.id.tv_cancelled_product_count), R.color.dark);
        CustomString.m3165a(getContext(), (TextView) view.findViewById(R.id.ctv_products_total_label), R.color.dark, view, R.id.ll_vendor_point, 0, R.id.ll_shimmer_point, 8);
        CustomString.m3167a(view, R.id.tv_kpw, 8, R.id.tv_kpf, 8);
        if (VendorListVM.f10363d.getValue() == null || !VendorListVM.f10363d.getValue().currency.equals("kpwf")) {
            view.findViewById(R.id.ll_sale_check_box).setVisibility(View.GONE);
        } else {
            CustomString.m3167a(view, R.id.ccb_kpw, 0, R.id.ccb_kpf, 0);
            view.findViewById(R.id.ll_sale_check_box).setVisibility(View.VISIBLE);
        }
        ((ShimmerFrameLayout) view.findViewById(R.id.sfl_chart)).hideShimmer();
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_request_order_count)).setText(analyticsOverviewData.stats.requested.count + getResources().getString(R.string.count_unit));
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_request_product_count)).setText(analyticsOverviewData.stats.requested.products + getResources().getString(R.string.count_unit));
        PriceText priceText = (PriceText) view.findViewById(R.id.pt_kpf_request_total);
        PriceText priceText2 = (PriceText) view.findViewById(R.id.pt_kpw_request_total);
        priceText.setHidePriceNumber(false);
        priceText2.setHidePriceNumber(false);
        priceText.setVisibility(View.GONE);
        priceText2.setVisibility(View.GONE);
        SubOrder.TotalAmount totalAmount = analyticsOverviewData.stats.requested.total;
        if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
            priceText2.f12264t = true;
        }
        float f = analyticsOverviewData.stats.requested.total.kpf;
        if (f > 0.0f) {
            priceText.setPrice(Util.m327c(f));
            priceText.setVisibility(View.VISIBLE);
        }
        float f2 = analyticsOverviewData.stats.requested.total.kpw;
        if (f2 > 0.0f) {
            priceText2.setPrice(Util.m327c(f2));
            priceText2.setVisibility(View.VISIBLE);
        }
        SubOrder.TotalAmount totalAmount2 = analyticsOverviewData.stats.requested.total;
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
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_completed_order_count)).setText(analyticsOverviewData.stats.completed.count + getResources().getString(R.string.count_unit));
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_completed_product_count)).setText(analyticsOverviewData.stats.completed.products + getResources().getString(R.string.count_unit));
        PriceText priceText3 = (PriceText) view.findViewById(R.id.pt_kpf_completed_total);
        PriceText priceText4 = (PriceText) view.findViewById(R.id.pt_kpw_completed_total);
        priceText3.setHidePriceNumber(false);
        priceText4.setHidePriceNumber(false);
        priceText4.setVisibility(View.GONE);
        priceText3.setVisibility(View.GONE);
        SubOrder.TotalAmount totalAmount3 = analyticsOverviewData.stats.completed.total;
        if (totalAmount3.kpf > 0.0f && totalAmount3.kpw > 0.0f) {
            priceText4.f12264t = true;
        }
        float f3 = analyticsOverviewData.stats.completed.total.kpf;
        if (f3 > 0.0f) {
            priceText3.setPrice(Util.m327c(f3));
            priceText3.setVisibility(View.VISIBLE);
        }
        float f4 = analyticsOverviewData.stats.completed.total.kpw;
        if (f4 > 0.0f) {
            priceText4.setPrice(Util.m327c(f4));
            priceText4.setVisibility(View.VISIBLE);
        }
        SubOrder.TotalAmount totalAmount4 = analyticsOverviewData.stats.completed.total;
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
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_cancelled_order_count)).setText(analyticsOverviewData.stats.cancelled.count + getResources().getString(R.string.count_unit));
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_cancelled_product_count)).setText(analyticsOverviewData.stats.cancelled.products + getResources().getString(R.string.count_unit));
        PriceText priceText5 = (PriceText) view.findViewById(R.id.pt_kpf_cancelled_total);
        PriceText priceText6 = (PriceText) view.findViewById(R.id.pt_kpw_cancelled_total);
        priceText5.setHidePriceNumber(false);
        priceText6.setHidePriceNumber(false);
        priceText5.setVisibility(View.GONE);
        priceText6.setVisibility(View.GONE);
        SubOrder.TotalAmount totalAmount5 = analyticsOverviewData.stats.cancelled.total;
        if (totalAmount5.kpf > 0.0f && totalAmount5.kpw > 0.0f) {
            priceText6.f12264t = true;
        }
        float f5 = analyticsOverviewData.stats.cancelled.total.kpf;
        if (f5 > 0.0f) {
            priceText5.setPrice(Util.m327c(f5));
            priceText5.setVisibility(View.VISIBLE);
        }
        float f6 = analyticsOverviewData.stats.cancelled.total.kpw;
        if (f6 > 0.0f) {
            priceText6.setPrice(Util.m327c(f6));
            priceText6.setVisibility(View.VISIBLE);
        }
        SubOrder.TotalAmount totalAmount6 = analyticsOverviewData.stats.cancelled.total;
        if (totalAmount6.kpf == 0.0f && totalAmount6.kpw == 0.0f) {
            if (VendorListVM.f10363d.getValue() != null) {
                if (VendorListVM.f10363d.getValue().currency.equals("kpw")) {
                    priceText6.setPrice("0");
                    priceText6.setVisibility(View.VISIBLE);
                    return;
                } else if (!VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                    priceText6.f12264t = true;
                    priceText6.setPrice("0");
                    priceText6.setVisibility(View.VISIBLE);
                }
            }
            priceText5.setPrice("0");
            priceText5.setVisibility(View.VISIBLE);
        }
    }


    public  void m5198a(final View view, BaseDialog2 baseDialog2, View view2, int i) {
        int i2 = i + 2;
        Date[] m341d = Util.m341d(i2);
        this.f9714d0.startDate = m341d[0] != null ? Util.date2Str(m341d[0]) : "";
        this.f9714d0.endDate = m341d[1] != null ? Util.date2Str(m341d[1]) : "";
        if (i != 7) {
            this.f9716f0.setValue( this.f9714d0);
            ((ActionLink) view.findViewById(R.id.cal_display_unit_selector)).setText(Status.day_filter[i2]);
        } else {
            this.f9713c0.m4704a();
            this.f9713c0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.a.f0
                @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

                public final void mo4696a(Date date, Date date2, View view3) {
                    FragmentAnalyticsOverView.this.m5201a(view, date, date2, view3);
                }
            };
        }
        baseDialog2.startAni();
    }


    public  void m5196a(final View view, View view2) {
        if (this.f9715e0) {
            return;
        }
        this.f9715e0 = true;
        final BaseDialog2 baseDialog2 = new BaseDialog2(getContext(), Status.f8807B);
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.a.c0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view3, int i) {
                FragmentAnalyticsOverView.this.m5198a(view, baseDialog2, view3, i);
            }
        };
        baseDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.d.a.j0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FragmentAnalyticsOverView.this.m5195a(dialogInterface);
            }
        });
    }


    public  void m5200a(View view, Vendor vendor) {
        int i;
        int i2;
        int i3 = vendor.point;
        int i4 = 0;
        while (true) {
            int[] iArr = CredValue.f10442a;
            if (i4 >= iArr.length) {
                i = 0;
                i2 = 0;
                break;
            } else {
                if (iArr[i4] > i3) {
                    i2 = iArr[i4];
                    i = iArr[i4 - 1];
                    break;
                }
                i4++;
            }
        }
        int[] iArr2 = {i, i2};
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_vendor_point_notice)).setText(java.lang.String.format(this.f9711a0.getResources().getString(R.string.current_vendor_notice), Integer.valueOf(CredValue.m5616a(i3)), Util.getDecimalFormat(i3, false), Util.getDecimalFormat(iArr2[1] - i3, false)));
        ((ProgressBar) view.findViewById(R.id.pb_vendor_level)).setProgress((int) (((i3 - iArr2[0]) / (iArr2[1] - iArr2[0])) * 100.0f));
        ((VendorLevel) view.findViewById(R.id.vl_vendor_level_start)).m6978a(iArr2[0], this.f9711a0);
        view.findViewById(R.id.vl_vendor_level_start).setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1, 1.0f));
        ((VendorLevel) view.findViewById(R.id.vl_vendor_level_end)).m6978a(iArr2[1], this.f9711a0);
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_analytics_overview, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.GONE);
                materialRippleLayout2.setVisibility(View.VISIBLE);
            }
            if (materialRippleLayout2 != null) {
                materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.i0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FragmentAnalyticsOverView.this.m5205d(view);
                    }
                });
            }
        }
        this.f9712b0 = (AnalyticsProvider) new ViewModelProvider(this).get(AnalyticsProvider.class);
        this.f9717g0 = (ChartLineView) inflate.findViewById(R.id.v_sale_line_view);
        final ChartLineView chartLineView = this.f9717g0;
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
        this.f9712b0.f10529k.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.b0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentAnalyticsOverView.this.m5202a(chartLineView, inflate, (AnalyticsOverviewData) obj);
            }
        });
        ((ActionLink) inflate.findViewById(R.id.cal_display_unit_selector)).setText(getResources().getString(R.string.recent_one_week));
        Date date = new Date();
        this.f9714d0.startDate = Util.date2Str(new Date(date.getYear(), date.getMonth(), date.getDate() - 6));
        this.f9714d0.endDate = Util.date2Str(date);
        this.f9716f0.setValue( this.f9714d0);
        this.f9716f0.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.g0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentAnalyticsOverView.this.m5199a(inflate, (ChartParam) obj);
            }
        });
        m5194S0();
        ((TextViewBold) inflate.findViewById(R.id.tv_header_title)).setText(R.string.analytics);
        inflate.findViewById(R.id.header_border).setVisibility(View.GONE);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) inflate.findViewById(R.id.llc_menu_toggle);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, Util.dp2px((Context) this.f9711a0, 65), 0, 0);
        layoutParams.gravity = 8388613;
        linearLayoutCompat.setLayoutParams(layoutParams);
        this.f9711a0.mo4284G();
        inflate.findViewById(R.id.cal_display_unit_selector).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentAnalyticsOverView.this.m5196a(inflate, view);
            }
        });
        inflate.findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentAnalyticsOverView.this.m5204c(view);
            }
        });
        ((CheckBox) inflate.findViewById(R.id.ccb_kpw)).setChecked(true);
        ((CheckBox) inflate.findViewById(R.id.ccb_kpf)).setChecked(true);
        ((CheckBox) inflate.findViewById(R.id.ccb_kpw)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.a.m0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FragmentAnalyticsOverView.this.m5197a(inflate, compoundButton, z);
            }
        });
        ((CheckBox) inflate.findViewById(R.id.ccb_kpf)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.a.k0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FragmentAnalyticsOverView.this.m5203b(inflate, compoundButton, z);
            }
        });
        VendorListVM.f10363d.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.d0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentAnalyticsOverView.this.m5200a(inflate, (Vendor) obj);
            }
        });
        ((BaseActivityForVendor) this.f9711a0).m4331a(R.id.navigation_home, inflate);
        return inflate;
    }
}
