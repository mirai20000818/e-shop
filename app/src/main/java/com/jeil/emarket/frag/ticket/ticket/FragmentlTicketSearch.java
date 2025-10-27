package com.jeil.emarket.frag.ticket.ticket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.GradientScrollLayout;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.customer.TicketCategory;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.c.a.g */

public class FragmentlTicketSearch extends BaseFragment {

    /* renamed from: A0 */
    public int f9591A0;

    /* renamed from: p0 */
    public View f9593p0;

    /* renamed from: q0 */
    public InterfaceString f9594q0;

    /* renamed from: r0 */
    public Picker4 f9595r0;

    /* renamed from: s0 */
    public Date f9596s0;

    /* renamed from: t0 */
    public Date f9597t0;

    /* renamed from: w0 */
    public List<TicketCategory> f9600w0;

    /* renamed from: o0 */
    public JSONObject f9592o0 = new JSONObject();

    /* renamed from: u0 */
    public MutableLiveData<a> f9598u0 = new MutableLiveData<>();

    /* renamed from: v0 */
    public a f9599v0 = new a(this);

    /* renamed from: x0 */
    public List<ButtonToggle> f9601x0 = new ArrayList();

    /* renamed from: y0 */
    public List<java.lang.String> f9602y0 = new ArrayList();

    /* renamed from: z0 */
    public java.lang.String f9603z0 = "";

    /* renamed from: b.f.a.g.c.a.g$a */
    public class a {

        
        public java.lang.String f9604a;

        
        public java.lang.String f9605b;

        
        public java.lang.String f9606c;

        
        public java.lang.String f9607d;

        
        public java.lang.String f9608e;

        public a(FragmentlTicketSearch fragmentlTicketSearch) {
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"SetTextI18n"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        m5120Z0();
    }

    /* renamed from: Z0 */
    public void m5120Z0() {
        this.f9595r0 = new Picker4(this.baseActivity);
        Calendar calendar = Calendar.getInstance();
        Date date = this.f9596s0;
        if (date != null) {
            calendar.setTime(date);
        } else {
            calendar.set(calendar.get(1), 0, 1);
        }
        this.f9595r0.m4707b(calendar);
        Calendar calendar2 = Calendar.getInstance();
        Date date2 = this.f9597t0;
        if (date2 != null) {
            calendar2.setTime(date2);
        } else {
            calendar2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5));
        }
        this.f9595r0.m4705a(calendar2);
    }

    
    public  void m5121a(int i, View view) {
        this.f9599v0.f9605b = this.f9600w0.get(i)._id;
        m5126c(i);
        this.f9598u0.setValue( this.f9599v0);
    }

    
    public  void m5122a(a aVar) {
        this.jsonObject = new JSONObject();
        this.f9137a0 = 0;
        mo5128d1();
        mo4891W0();
    }

    
    public  void m5123a(Date date, Date date2, View view) {
        this.f9596s0 = date;
        this.f9597t0 = date2;
        this.f9599v0.f9607d = Util.date2Str(date);
        this.f9599v0.f9608e = Util.date2Str(date2);
        this.f9598u0.setValue( this.f9599v0);
        TextView textView = (TextView) this.f9593p0.findViewById(R.id.ctv_date_span);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9599v0.f9607d);
        sb.append(" ~ ");
        CustomString.m3175a(sb, this.f9599v0.f9608e, textView);
    }

    /* renamed from: a1 */
    public void m5124a1() {
        View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
        inflate.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -2));
        ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_tickets);
        ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_message_dots);
        this.xRecyclerView.setEmptyView(inflate);
        this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    /* renamed from: b1 */
    public void m5125b1() {
        this.f9593p0 = getLayoutInflater().inflate(R.layout.layout_ticket_search, (ViewGroup) null, false);
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
        int i = BaseActivity.anInt2;
        c0541a.setMargins(i, 0, i, 0);
        this.f9600w0 = TicketCategoryListVM.m5495a(this.f9602y0);
        GradientScrollLayout gradientScrollLayout = new GradientScrollLayout(this.baseActivity);
        gradientScrollLayout.removeAllViews();
        if (this.f9600w0.size() > 0) {
            TicketCategory ticketCategory = new TicketCategory();
            ticketCategory.name = getResources().getString(R.string.all);
            ticketCategory._id = "";
            ticketCategory.type = "";
            this.f9600w0.add(0, ticketCategory);
            for (int i2 = 0; i2 < this.f9600w0.size(); i2++) {
                ButtonToggle buttonToggle = new ButtonToggle(this.baseActivity);
                buttonToggle.setText(this.f9600w0.get(i2).name);
                buttonToggle.m6893a(1, 10.0f);
                LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
                if (i2 > 0) {
                    c0541a2.setMargins(Util.dp2px((Context) this.baseActivity, 7), 0, 0, 0);
                } else {
                    buttonToggle.m6896d();
                }
                if (i2 == this.f9600w0.size() - 1) {
                    c0541a2.setMargins(Util.dp2px((Context) this.baseActivity, 7), 0, Util.dp2px((Context) this.baseActivity, 15), 0);
                }
                buttonToggle.setLayoutParams(c0541a2);
                int finalI = i2;
                buttonToggle.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.c.a.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FragmentlTicketSearch.this.m5121a(finalI, view);
                    }
                });
                this.f9601x0.add(buttonToggle);
                gradientScrollLayout.m6824a(buttonToggle);
            }
        }
        ((LinearLayoutCompat) this.f9593p0.findViewById(R.id.llc_category_item)).addView(gradientScrollLayout);
        TextView textView = (TextView) this.f9593p0.findViewById(R.id.ctv_date_span);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9599v0.f9607d);
        sb.append(" ~ ");
        CustomString.m3175a(sb, this.f9599v0.f9608e, textView);
        this.f9593p0.findViewById(R.id.ctv_date_span).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.c.a.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentlTicketSearch.this.m5129k(view);
            }
        });
        this.f9595r0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.c.a.a
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c
            
            public final void mo4696a(Date date, Date date2, View view) {
                FragmentlTicketSearch.this.m5123a(date, date2, view);
            }
        };
        this.f9593p0.findViewById(R.id.mrl_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.c.a.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentlTicketSearch.this.m5130l(view);
            }
        });
        this.f9598u0.observe(this.baseActivity, new Observer() { // from class: b.f.a.g.c.a.b
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentlTicketSearch.this.m5122a((FragmentlTicketSearch.a) obj);
            }
        });
        this.f9593p0.setLayoutParams(c0541a);
        this.xRecyclerView.addView(this.f9593p0);
    }

    
    public void m5126c(int i) {
        for (int i2 = 0; i2 < this.f9601x0.size(); i2++) {
            ButtonToggle buttonToggle = this.f9601x0.get(i2);
            if (i2 != i) {
                buttonToggle.m6897e();
            } else {
                buttonToggle.m6896d();
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: c1 */
    public void m5127c1() {
        this.f9596s0 = new Date(new Date().getYear(), new Date().getMonth() - 1, new Date().getDate());
        this.f9597t0 = new Date();
        this.f9599v0.f9607d = Util.date2Str(this.f9596s0);
        this.f9599v0.f9608e = Util.date2Str(this.f9597t0);
        a aVar = this.f9599v0;
        aVar.f9605b = "";
        aVar.f9606c = "";
        mo5128d1();
        View view = this.f9593p0;
        if (view != null) {
            ((TextView) view.findViewById(R.id.ctv_date_span)).setText(this.f9599v0.f9607d + " ~ " + this.f9599v0.f9608e);
            m5126c(0);
        }
    }

    /* renamed from: d1 */
    public void mo5128d1() {
        try {
            this.f9592o0.put("status", this.f9599v0.f9604a.equals("all") ? "" : this.f9599v0.f9604a);
            this.f9592o0.put("startDate", this.f9599v0.f9607d);
            this.f9592o0.put("endDate", this.f9599v0.f9608e);
            this.f9592o0.put("categoryId", this.f9599v0.f9605b);
            this.f9592o0.put("search", this.f9599v0.f9606c);
            this.jsonObject.put("filter", this.f9592o0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    
    public  void m5129k(View view) {
        this.f9595r0.m4704a();
    }

    /* renamed from: l */
    public  void m5130l(View view) {
        this.f9596s0 = new Date(new Date().getYear(), new Date().getMonth() - 1, new Date().getDate());
        this.f9597t0 = new Date();
        a aVar = this.f9599v0;
        aVar.f9606c = "";
        aVar.f9605b = "";
        aVar.f9607d = Util.date2Str(this.f9596s0);
        this.f9599v0.f9608e = Util.date2Str(this.f9597t0);
        this.f9598u0.setValue( this.f9599v0);
        ((TextView) this.f9593p0.findViewById(R.id.ctv_date_span)).setText(this.f9599v0.f9607d + " ~ " + this.f9599v0.f9608e);
        m5126c(0);
    }
}
