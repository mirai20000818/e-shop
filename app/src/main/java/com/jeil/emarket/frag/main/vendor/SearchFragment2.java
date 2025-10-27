package com.jeil.emarket.frag.main.vendor;

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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.order.OrderAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.customer.Order;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.b.a.z0 */

public class SearchFragment2 extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public OrderAdapter f9287o0;

    /* renamed from: q0 */
    public InterfaceString f9289q0;

    /* renamed from: r0 */
    public Picker4 f9290r0;

    /* renamed from: s0 */
    public Date f9291s0;

    /* renamed from: t0 */
    public Date f9292t0;

    /* renamed from: v0 */
    public java.lang.String f9294v0;

    /* renamed from: p0 */
    public JSONObject f9288p0 = new JSONObject();

    /* renamed from: u0 */
    public boolean f9293u0 = true;

    /* renamed from: b.f.a.g.b.a.z0$a */
    public class a extends TypeToken<List<Order>> {
        public a(SearchFragment2 searchFragment2) {
        }
    }

    public SearchFragment2(BaseActivity activityC1391g1, java.lang.String str, InterfaceString interfaceString) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(1), calendar.get(2) - 1, calendar.get(5));
        this.f9291s0 = calendar.getTime();
        this.f9292t0 = new Date();
        this.f9294v0 = str;
        try {
            this.f9288p0.put("search", "");
            this.f9288p0.put("withReasons", true);
            this.f9288p0.put("startDate", Util.date2Str(this.f9291s0));
            this.f9288p0.put("endDate", Util.date2Str(this.f9292t0));
            this.f9288p0.put("status", str);
            this.jsonObject.put("filter", this.f9288p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.baseActivity = activityC1391g1;
        this.f9289q0 = interfaceString;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"SetTextI18n"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        this.f9290r0 = new Picker4(this.baseActivity);
        Calendar calendar = Calendar.getInstance();
        Date date = this.f9291s0;
        if (date != null) {
            calendar.setTime(date);
        } else {
            calendar.set(calendar.get(1), 0, 1);
        }
        this.f9290r0.m4707b(calendar);
        Calendar calendar2 = Calendar.getInstance();
        Date date2 = this.f9292t0;
        if (date2 != null) {
            calendar2.setTime(date2);
        } else {
            calendar2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5));
        }
        this.f9290r0.m4705a(calendar2);
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9287o0 = new OrderAdapter(this.baseActivity);
            this.xRecyclerView.setAdapter(this.f9287o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f9293u0;
            xRecyclerView.f12377b1 = true;
            if (this.f9294v0.equals("completed") || this.f9294v0.equals("cancelled") || this.f9294v0.equals("refunded")) {
                final View inflate = getLayoutInflater().inflate(R.layout.layout_top_search, (ViewGroup) null);
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
                int i = BaseActivity.anInt2;
                c0541a.setMargins(i, 0, i, 0);
                CustomString.m3167a(inflate, R.id.mrl_help_link, 8, R.id.llc_date_picker, 0);
                ((EditForm) inflate.findViewById(R.id.cef_search)).setPlaceHolder(getResources().getString(R.string.input_order_id));
                ((EditForm) inflate.findViewById(R.id.cef_search)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.l0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchFragment2.this.m4963a(inflate, view);
                    }
                });
                ((EditForm) inflate.findViewById(R.id.cef_search)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.b.a.n0
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                        return SearchFragment2.this.m4966a(inflate, textView, i2, keyEvent);
                    }
                });
                ((com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.ctv_date_span)).setText(Util.date2Str(this.f9291s0) + " ~ " + Util.date2Str(this.f9292t0));
                inflate.findViewById(R.id.ctv_date_span).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.m0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchFragment2.this.m4969k(view);
                    }
                });
                inflate.findViewById(R.id.mrl_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.o0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchFragment2.this.m4967b(inflate, view);
                    }
                });
                this.f9290r0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.b.a.p0
                    @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

                    public final void mo4696a(Date date3, Date date4, View view) {
                        SearchFragment2.this.m4964a(inflate, date3, date4, view);
                    }
                };
                inflate.setLayoutParams(c0541a);
                inflate.measure(((LinearLayout.LayoutParams) c0541a).width, ((LinearLayout.LayoutParams) c0541a).height);
                this.xRecyclerView.addView(inflate);
            }
            View inflate2 = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate2.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_empty_order);
            ((com.jeil.emarket.components.textview.TextView) inflate2.findViewById(R.id.tv_empty_title)).setText(R.string.empty_order);
            this.xRecyclerView.setEmptyView(inflate2);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9293u0) {
            ArrayList arrayList = new ArrayList();
            Order order = new Order();
            order.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(order);
            }
            this.f9287o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9288p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(this.baseActivity, "get_orders", this).get("e6/orders", this.jsonObject);
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
        if (this.f9293u0) {
            ArrayList arrayList = new ArrayList();
            Order order = new Order();
            order.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(order);
            }
            OrderAdapter c1858y0 = this.f9287o0;
            c1858y0.arrayList = arrayList;
            c1858y0.notifyDataSetChanged();
        } else {
            OrderAdapter c1858y02 = this.f9287o0;
            c1858y02.arrayList = new ArrayList();
            c1858y02.notifyDataSetChanged();
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
        new API_PROVIDER(this.baseActivity, "get_orders", this).get("e6/orders", this.jsonObject);
    }


    public  void m4963a(@SuppressLint({"InflateParams"}) View view, View view2) {
        m4968b(((EditForm) view.findViewById(R.id.cef_search)).getText());
    }


    public  void m4964a(@SuppressLint({"InflateParams"}) View view, Date date, Date date2, View view2) {
        this.f9291s0 = date;
        this.f9292t0 = date2;
        m4965a(Util.date2Str(this.f9291s0), Util.date2Str(this.f9292t0), ((EditForm) view.findViewById(R.id.cef_search)).getText());
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.ctv_date_span)).setText(Util.date2Str(date) + " ~ " + Util.date2Str(date2));
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !"get_orders".equals(str2)) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9287o0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9287o0.addAll(list);
                } else if (this.f9293u0) {
                    this.f9287o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9287o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9287o0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (!jSONObject.has("count") || this.f9289q0 == null) {
                return;
            }
            this.f9289q0.mo4265a(jSONObject.getString("count"));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }


    public void m4965a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f9137a0 = 0;
        try {
            this.f9288p0.put("startDate", str);
            this.f9288p0.put("endDate", str2);
            this.f9288p0.put("search", str3);
            this.jsonObject.put("filter", this.f9288p0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }


    public  boolean m4966a(@SuppressLint({"InflateParams"}) View view, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m4968b(((EditForm) view.findViewById(R.id.cef_search)).getText());
        return true;
    }

    
    public  void m4967b(@SuppressLint({"InflateParams"}) View view, View view2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(1), calendar.get(2) - 1, calendar.get(5));
        this.f9292t0 = new Date();
        this.f9291s0 = calendar.getTime();
        ((EditForm) view.findViewById(R.id.cef_search)).setText("");
        m4965a(Util.date2Str(this.f9291s0), Util.date2Str(this.f9292t0), "");
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.ctv_date_span)).setText(Util.date2Str(this.f9291s0) + " ~ " + Util.date2Str(this.f9292t0));
    }

    
    public void m4968b(java.lang.String str) {
        this.f9137a0 = 0;
        try {
            this.f9288p0.put("search", str);
            this.jsonObject.put("filter", this.f9288p0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mo4891W0();
    }

    
    public  void m4969k(View view) {
        this.f9290r0.m4704a();
    }
}
