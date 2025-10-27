package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.activities.seller.VendorOrderDetailActivity;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.SameShippingOrder;
import com.jeil.emarket.model.vendor.OrderDetail;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;
import com.jeil.emarket.viewmodel.ModelCollection;

/* renamed from: b.f.a.f.v2 */

public class DialogChangeOrderStatus extends ImageDialog1<DialogChangeOrderStatus> {

    /* renamed from: T */
    public BaseActivity f9085T;

    /* renamed from: U */
    public View f9086U;

    /* renamed from: V */
    public OrderDetail f9087V;

    /* renamed from: W */
    public List<SameShippingOrder> f9088W;

    public DialogChangeOrderStatus(BaseActivity activityC1391g1, OrderDetail orderDetail) {
        super(activityC1391g1);
        this.f9088W = new ArrayList();
        this.f9085T = activityC1391g1;
        this.f9087V = orderDetail;
    }

    
    public  void m4870a(int i, View view) {
        dismiss();
        BaseActivity activityC1391g1 = this.f9085T;
        if (activityC1391g1 instanceof VendorOrderDetailActivity) {
            ((VendorOrderDetailActivity) activityC1391g1).f11821O = true;
            ((VendorOrderDetailActivity) activityC1391g1).m6603U();
        }
        ModelCollection.m5447d(this.f9085T, this.f9088W.get(i).f12418id);
    }

    
    public  void m4871a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            m4595e();
            BaseActivity activityC1391g1 = this.f9085T;
            if (activityC1391g1 instanceof VendorOrderDetailActivity) {
                ((VendorOrderDetailActivity) activityC1391g1).f11821O = true;
                ((VendorOrderDetailActivity) activityC1391g1).m6603U();
            }
            ModelCollection.m5447d(this.f9085T, this.f9087V.f12440id);
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @SuppressLint({"SetTextI18n"})
    
    public View mo4576b() {
        java.lang.String string;
        TextView textView;
        int i;
        int i2;
        ViewGroup viewGroup = null;
        this.f9086U = View.inflate(this.f8251b, R.layout.dialog_change_order_status, null);
        this.f9088W = ModelCollection.f10216g.getValue();
        List<SameShippingOrder> list = this.f9088W;
        if (list == null || list.size() == 0) {
            this.f9086U.findViewById(R.id.nsv_same_shipping_orders).setVisibility(View.GONE);
            if (this.f9087V.status.equals("requested")) {
                View view = this.f9086U;
                i = R.id.tv_notice;
                textView = (TextView) view.findViewById(R.id.tv_notice);
                string = this.f9085T.getResources().getString(R.string.change_to_accept_warning);
            } else {
                TextView textView2 = (TextView) this.f9086U.findViewById(R.id.tv_notice);
                string = this.f9085T.getResources().getString(R.string.change_to_ready_to_ship_warning);
                textView = textView2;
                i = R.id.tv_notice;
            }
            textView.setText(string);
            i2 = i;
        } else {
            this.f9086U.findViewById(R.id.nsv_same_shipping_orders).setVisibility(View.VISIBLE);
            ((TableLayout) this.f9086U.findViewById(R.id.tl_same_shipping_orders)).setShrinkAllColumns(true);
            TextView textView3 = (TextView) this.f9086U.findViewById(R.id.tv_notice);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f9087V.status.equals("requested") ? this.f9085T.getResources().getString(R.string.change_to_accept_warning) : this.f9085T.getResources().getString(R.string.change_to_ready_to_ship_warning));
            sb.append(" ");
            sb.append(this.f9085T.getResources().getString(R.string.same_shipping_orders_notice));
            textView3.setText(sb.toString());
            View inflate = getLayoutInflater().inflate(R.layout.item_same_shipping_order, (ViewGroup) null, false);
            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_order_id);
            StringBuilder sb2 = new StringBuilder();
            BaseActivity activityC1391g1 = this.f9085T;
            int i3 = R.string.order;
            CustomString.m3171a(activityC1391g1, R.string.order, sb2, " ");
            sb2.append(this.f9087V.displayOrderId);
            textView4.setText(sb2.toString());
            inflate.findViewById(R.id.tv_order_status).setBackgroundTintList(CustomString.m3149a(this.f9085T, this.f9085T.getResources(), this.f9087V.status, "color", this.f9085T.getResources()));
            ((TextView) inflate.findViewById(R.id.tv_order_status)).setText(Util.m335d(this.f9085T, this.f9087V.status));
            if (this.f9087V.shippingAmount != 0.0f) {
                CustomString.m3167a(inflate, R.id.tv_order_free_shipping, 8, R.id.pt_order_shipping_price, 0);
                ((PriceText) inflate.findViewById(R.id.pt_order_shipping_price)).setHidePriceNumber(false);
                ((PriceText) inflate.findViewById(R.id.pt_order_shipping_price)).setCurrency(this.f9087V.shippingCurrency);
                ((PriceText) inflate.findViewById(R.id.pt_order_shipping_price)).setPrice(Util.m327c(this.f9087V.shippingAmount));
            } else {
                CustomString.m3167a(inflate, R.id.tv_order_free_shipping, 0, R.id.pt_order_shipping_price, 8);
            }
            if (this.f9087V.deliveryTime != null) {
                inflate.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.VISIBLE);
                TextView textView5 = (TextView) inflate.findViewById(R.id.tv_shipping_arrived_at);
                StringBuilder m3163a = CustomString.format("( ");
                CustomString.m3171a(this.f9085T, R.string.shipping_time, m3163a, " ");
                m3163a.append(Util.m307b(this.f9087V.deliveryTime));
                m3163a.append(" )");
                textView5.setText(m3163a.toString());
            } else {
                inflate.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.GONE);
            }
            inflate.findViewById(R.id.mrl_same_shipping_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialogChangeOrderStatus.this.m4874h(view2);
                }
            });
            ((TableLayout) this.f9086U.findViewById(R.id.tl_same_shipping_orders)).addView(inflate);
            final int i4 = 0;
            while (i4 < this.f9088W.size()) {
                View inflate2 = getLayoutInflater().inflate(R.layout.item_same_shipping_order, viewGroup, false);
                TextView textView6 = (TextView) inflate2.findViewById(R.id.tv_order_id);
                StringBuilder sb3 = new StringBuilder();
                CustomString.m3171a(this.f9085T, i3, sb3, " ");
                sb3.append(this.f9088W.get(i4).displayOrderId);
                textView6.setText(sb3.toString());
                inflate2.findViewById(R.id.tv_order_status).setBackgroundTintList(CustomString.m3149a(this.f9085T, this.f9085T.getResources(), this.f9088W.get(i4).status, "color", this.f9085T.getResources()));
                ((TextView) inflate2.findViewById(R.id.tv_order_status)).setText(Util.m335d(this.f9085T, this.f9088W.get(i4).status));
                if (this.f9088W.get(i4).shippingPrice != 0.0f) {
                    CustomString.m3167a(inflate2, R.id.tv_order_free_shipping, 8, R.id.pt_order_shipping_price, 0);
                    ((PriceText) inflate2.findViewById(R.id.pt_order_shipping_price)).setHidePriceNumber(false);
                    ((PriceText) inflate2.findViewById(R.id.pt_order_shipping_price)).setCurrency(this.f9088W.get(i4).shippingCurrency);
                    ((PriceText) inflate2.findViewById(R.id.pt_order_shipping_price)).setPrice(Util.m327c(this.f9088W.get(i4).shippingPrice));
                } else {
                    CustomString.m3167a(inflate2, R.id.tv_order_free_shipping, 0, R.id.pt_order_shipping_price, 8);
                }
                if (this.f9088W.get(i4).deliveryTime != null) {
                    inflate2.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.VISIBLE);
                    TextView textView7 = (TextView) inflate2.findViewById(R.id.tv_shipping_arrived_at);
                    StringBuilder m3163a2 = CustomString.format("( ");
                    CustomString.m3171a(this.f9085T, R.string.shipping_time, m3163a2, " ");
                    m3163a2.append(Util.m307b(this.f9088W.get(i4).deliveryTime));
                    m3163a2.append(" )");
                    textView7.setText(m3163a2.toString());
                } else {
                    inflate2.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.GONE);
                }
                inflate2.findViewById(R.id.mrl_same_shipping_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.e0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DialogChangeOrderStatus.this.m4870a(i4, view2);
                    }
                });
                ((TableLayout) this.f9086U.findViewById(R.id.tl_same_shipping_orders)).addView(inflate2);
                i4++;
                viewGroup = null;
                i3 = R.string.order;
            }
            i2 = R.id.tv_notice;
        }
        ((TextView) this.f9086U.findViewById(i2)).setGravity(17);
        if (this.f9087V.status.equals("requested") && this.f9087V.shippingMethod.equals(this.f9085T.getResources().getString(R.string.discuss_shipping_method))) {
            this.f9086U.findViewById(R.id.iv_warn).setVisibility(View.GONE);
            this.f9086U.findViewById(R.id.tv_accept_order_title).setVisibility(View.VISIBLE);
            this.f9086U.findViewById(R.id.ll_shipping_pay).setVisibility(View.VISIBLE);
            TextView textView8 = (TextView) this.f9086U.findViewById(R.id.ctv_common_price_unit);
            java.lang.String str = this.f9087V.shippingCurrency;
            textView8.setText((str == null || !str.equals("kpf")) ? this.f9085T.getResources().getString(R.string.won) : "$");
        } else {
            this.f9086U.findViewById(R.id.iv_warn).setVisibility(View.VISIBLE);
            this.f9086U.findViewById(R.id.tv_accept_order_title).setVisibility(View.GONE);
            this.f9086U.findViewById(R.id.ll_shipping_pay).setVisibility(View.GONE);
            List<SameShippingOrder> list2 = this.f9088W;
            if (list2 == null || list2.size() == 0) {
                this.f8254e = 0.8f;
                this.f9086U.findViewById(R.id.ll_main).setBackgroundResource(R.drawable.bg_box);
                this.f9086U.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.g0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DialogChangeOrderStatus.this.m4872f(view2);
                    }
                });
                this.f9086U.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.f0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DialogChangeOrderStatus.this.m4873g(view2);
                    }
                });
                return this.f9086U;
            }
        }
        this.f8254e = 1.0f;
        this.f9086U.findViewById(R.id.ll_main).setBackgroundColor(this.f9085T.getResources().getColor(R.color.white));
        this.f9086U.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DialogChangeOrderStatus.this.m4872f(view2);
            }
        });
        this.f9086U.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DialogChangeOrderStatus.this.m4873g(view2);
            }
        });
        return this.f9086U;
    }

    /* renamed from: f */
    public  void m4872f(View view) {
        dismiss();
    }

    /* renamed from: g */
    public  void m4873g(View view) {
        float f;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f9087V.status.equals("requested")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this.f9087V.f12440id));
                jSONObject.put("ids", arrayList);
                jSONObject.put("status", "accepted");
                if (this.f9087V.shippingMethod.equals(this.f9085T.getResources().getString(R.string.discuss_shipping_method))) {
                    try {
                        f = Float.parseFloat(((EditForm) this.f9086U.findViewById(R.id.cef_shipping_pay)).getText());
                    } catch (Exception unused) {
                        f = 0.0f;
                    }
                    jSONObject.put("price", f);
                }
            } else if (this.f9087V.status.equals("accepted")) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integer.valueOf(this.f9087V.f12440id));
                jSONObject.put("ids", arrayList2);
                jSONObject.put("status", "readyToShip");
            }
            Util.m239a((Context) this.f9085T, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ModelCollection.m5449d(this.f9085T, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.f9085T);
        dialogC2001j.show();
        ModelCollection.f10217h.observe(this.f9085T, new Observer() { // from class: b.f.a.f.i0
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                DialogChangeOrderStatus.this.m4871a(dialogC2001j, (Integer) obj);
            }
        });
    }

    /* renamed from: h */
    public  void m4874h(View view) {
        Intent intent = new Intent(this.f9085T, VendorOrderDetailActivity.class);
        intent.putExtra("orderVendorId", this.f9087V.f12440id);
        intent.putExtra("displayOrderId", this.f9087V.displayOrderId);
        this.f9085T.startActivityForResult(intent, 100);
    }
}
