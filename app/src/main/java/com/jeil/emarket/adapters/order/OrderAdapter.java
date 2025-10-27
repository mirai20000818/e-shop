package com.jeil.emarket.adapters.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.account.OrderActivity;
import com.jeil.emarket.activities.account.OrderDetailActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.DialogOrderCancel;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.customer.Order;
import com.jeil.emarket.viewmodel.ModelCollection;

import org.json.JSONObject;

import java.util.Objects;

/* renamed from: b.f.a.b.g.y0 */

public class OrderAdapter extends BaseMainAdapter<Order, RecyclerView.ViewHolder> implements BaseInterface {

    /* renamed from: f */
    public final LayoutInflater f7523f;

    /* renamed from: g */
    public boolean f7524g;

    /* renamed from: h */
    public DialogC2001j f7525h;

    /* renamed from: b.f.a.b.g.y0$a */
    public static class a extends RecyclerView.ViewHolder {

        
        public final ProductPrice pp_order_kpw_total_price;


        public final LinearLayoutCompat llc_order_count_item;


        public final AppCompatImageView iv_order_action;


        public final AppCompatImageView iv_plus;

        
        public final TextView tv_order_action;

        /* renamed from: t */
        public final MaterialRippleLayout mrl_show_detail;

        /* renamed from: u */
        public final TextView ctv_order_id;

        /* renamed from: v */
        public final TextView ctv_order_requested_at;

        /* renamed from: w */
        public final TextView ctv_order_product_count;

        /* renamed from: x */
        public final TextView ctv_order_status;

        /* renamed from: y */
        public final MaterialRippleLayout mrl_cancel_order;

        /* renamed from: z */
        public final ProductPrice pp_order_kpf_total_price;

        public a(View view) {
            super(view);
            this.ctv_order_id = (TextView) view.findViewById(R.id.ctv_order_id);
            this.ctv_order_requested_at = (TextView) view.findViewById(R.id.ctv_order_requested_at);
            this.ctv_order_product_count = (TextView) view.findViewById(R.id.ctv_order_product_count);
            this.ctv_order_status = (TextView) view.findViewById(R.id.ctv_order_status);
            this.mrl_cancel_order = (MaterialRippleLayout) view.findViewById(R.id.mrl_cancel_order);
            this.mrl_show_detail = (MaterialRippleLayout) view.findViewById(R.id.mrl_show_detail);
            this.pp_order_kpf_total_price = (ProductPrice) view.findViewById(R.id.pp_order_kpf_total_price);
            this.pp_order_kpw_total_price = (ProductPrice) view.findViewById(R.id.pp_order_kpw_total_price);
            this.llc_order_count_item = (LinearLayoutCompat) view.findViewById(R.id.llc_order_count_item);
            this.iv_order_action = (AppCompatImageView) view.findViewById(R.id.iv_order_action);
            this.iv_plus = (AppCompatImageView) view.findViewById(R.id.iv_plus);
            this.tv_order_action = (TextView) view.findViewById(R.id.tv_order_action);
        }
    }

    /* renamed from: b.f.a.b.g.y0$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f7538t;

        public b(View view) {
            super(view);
            this.f7538t = (TextView) view.findViewById(R.id.ctv_action_cancel_order);
        }
    }

    public OrderAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7524g = false;
        this.f7523f = LayoutInflater.from(activityC1391g1);
    }

    
    public  void m4475a(android.content.DialogInterface dialogInterface) {
        this.f7524g = false;
    }

    
    public  void m4476a(DialogOrderCancel dialogOrderCancel, int i) {
        java.lang.String obj = ((Editable) Objects.requireNonNull(((EditText) dialogOrderCancel.findViewById(R.id.et_customer_note)).getText())).toString();
        if (obj.isEmpty() || obj.trim().length() == 0) {
            BaseActivity activityC1391g1 = this.baseActivity;
            Util.toast(activityC1391g1, activityC1391g1.getResources().getString(R.string.order_cancel_desc), "error", 0, 0);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", "cancelled");
            jSONObject.put("reason", ((Editable) Objects.requireNonNull(dialogOrderCancel.f9122T.getText())).toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f7525h = new DialogC2001j(this.baseActivity);
        this.f7525h.show();
        new API_PROVIDER(this.baseActivity, "cancel_order", this).put("e6/orders/" + i, jSONObject);
        dialogOrderCancel.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((Order) this.arrayList.get(i)).type == null || !((Order) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }


    public  void m4479b(android.content.DialogInterface dialogInterface) {
        this.f7524g = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "WrongConstant"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Order order = (Order) this.arrayList.get(i);
        int i3 = 0;
        if (!(recyclerViewViewHolder instanceof a)) {
            if (recyclerViewViewHolder instanceof b) {
                ((b) recyclerViewViewHolder).f7538t.setVisibility(View.VISIBLE);
                return;
            }
            return;
        }
        a aVar = (a) recyclerViewViewHolder;
        CustomString.m3174a(new StringBuilder(), order.orderId, "", aVar.ctv_order_id);
        if (order.orderTotalKpf > 0.0f || order.orderTotalOldKpf > 0.0f || (order.shippingPrice > 0.0f && (str4 = order.shippingCurrency) != null && str4.equals("kpf"))) {
            aVar.pp_order_kpf_total_price.setHidePriceNumber(false);
            aVar.pp_order_kpf_total_price.setVisibility(View.VISIBLE);
            aVar.pp_order_kpf_total_price.m6941c(false);
            aVar.pp_order_kpf_total_price.setPtSalePrice(Util.m327c(order.orderTotalKpf + ((order.shippingPrice <= 0.0f || (str = order.shippingCurrency) == null || !str.equals("kpf")) ? 0.0f : order.shippingPrice)));
            if (order.orderTotalKpf == 0.0f && order.orderTotalOldKpf != 0.0f) {
                aVar.pp_order_kpf_total_price.setRegularPriceSize(13);
                aVar.pp_order_kpf_total_price.setRegularPrice(Util.m327c(order.orderTotalOldKpf));
            }
            i2 = 1;
        } else {
            aVar.pp_order_kpf_total_price.setVisibility(View.GONE);
            i2 = 0;
        }
        if (order.orderTotalKpw > 0.0f || order.orderTotalOldKpw > 0.0f || (order.shippingPrice > 0.0f && (str3 = order.shippingCurrency) != null && str3.equals("kpw"))) {
            i2++;
            aVar.pp_order_kpw_total_price.setHidePriceNumber(false);
            aVar.pp_order_kpw_total_price.setVisibility(View.VISIBLE);
            aVar.pp_order_kpw_total_price.m6941c(false);
            aVar.pp_order_kpw_total_price.setPtSalePrice(Util.m327c(order.orderTotalKpw + ((order.shippingPrice <= 0.0f || (str2 = order.shippingCurrency) == null || !str2.equals("kpw")) ? 0.0f : order.shippingPrice)));
            if (order.orderTotalKpw == 0.0f && order.orderTotalOldKpw != 0.0f) {
                aVar.pp_order_kpw_total_price.setRegularPriceSize(13);
                aVar.pp_order_kpw_total_price.setRegularPrice(Util.m327c(order.orderTotalOldKpw));
            }
        } else {
            aVar.pp_order_kpw_total_price.setVisibility(View.GONE);
        }
        if (i2 == 2) {
            aVar.iv_plus.setVisibility(View.VISIBLE);
        } else {
            aVar.iv_plus.setVisibility(View.GONE);
        }
        aVar.pp_order_kpf_total_price.m6940b(!order.orderStatus.equals("cancelled"));
        aVar.pp_order_kpw_total_price.m6940b(!order.orderStatus.equals("cancelled"));
        aVar.ctv_order_requested_at.setText(Util.m307b(order.orderCreatedAt));
        if (order.orderProductCount == 0) {
            aVar.llc_order_count_item.setVisibility(View.GONE);
        } else {
            aVar.llc_order_count_item.setVisibility(View.VISIBLE);
            aVar.ctv_order_product_count.setText(Util.getDecimalFormat(order.orderProductCount) + this.baseActivity.getString(R.string.order_count_unit));
        }
        aVar.ctv_order_status.setText(order.orderStatus);
        MaterialRippleLayout materialRippleLayout = aVar.mrl_cancel_order;
        if (!order.orderStatus.equals("requested") && !order.orderStatus.equals("accepted") && !order.orderStatus.equals("completed") && !order.orderStatus.equals("cancelled") && !order.orderStatus.equals("refunded")) {
            i3 = 8;
        }
        materialRippleLayout.setVisibility(i3);
        aVar.iv_order_action.setImageDrawable(this.baseActivity.getResources().getDrawable((order.orderStatus.equals("completed") || order.orderStatus.equals("cancelled") || order.orderStatus.equals("refunded")) ? R.drawable.ic_trash : R.drawable.ic_close_circle));
        aVar.tv_order_action.setText(this.baseActivity.getResources().getString((order.orderStatus.equals("completed") || order.orderStatus.equals("cancelled") || order.orderStatus.equals("refunded")) ? R.string.action_delete_order : R.string.action_cancel_order));
        aVar.mrl_cancel_order.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderAdapter.this.m4477a(order, view);
            }
        });
        aVar.mrl_show_detail.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderAdapter.this.m4480b(order, view);
            }
        });
        aVar.ctv_order_status.setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), order.orderStatus, "color", this.baseActivity.getResources()));
        aVar.ctv_order_status.setText(Util.m335d(this.baseActivity, order.orderStatus));
    }


    public  void m4480b(Order order, View view) {
        ModelCollection.m5436b(this.baseActivity, order.orderId);
        Intent intent = new Intent(this.baseActivity, OrderDetailActivity.class);
        intent.putExtra("orderVendorId", order.orderId);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7523f.inflate(R.layout.item_shimmer_order, viewGroup, false)) : new a(this.f7523f.inflate(R.layout.item_order, viewGroup, false));
    }

    
    public  void m4474a(int i, DialogError dialogError) {
        this.f7525h = new DialogC2001j(this.baseActivity);
        this.f7525h.show();
        new API_PROVIDER(this.baseActivity, "hide_order", this).put("e6/orders/hide/" + i, null);
        dialogError.dismiss();
    }

    
    public  void m4477a(Order order, View view) {
        if (this.f7524g) {
            return;
        }
        this.f7524g = true;
        if (!order.orderStatus.equals("completed") && !order.orderStatus.equals("cancelled") && !order.orderStatus.equals("refunded")) {
            final int i = order.orderId;
            final DialogOrderCancel dialogOrderCancel = new DialogOrderCancel(this.baseActivity);
            dialogOrderCancel.f8246v = this.baseActivity.getResources().getString(R.string.cancel_order_warning_notice);
            dialogOrderCancel.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
            dialogOrderCancel.show();
            dialogOrderCancel.m4585a(new DialogInterface() { // from class: b.f.a.b.g.r
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
                
                public final void cancel() {
                    OrderAdapter.this.m4476a(dialogOrderCancel, i);
                }
            });
            dialogOrderCancel.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.g.q
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    OrderAdapter.this.m4475a(dialogInterface);
                }
            });
            return;
        }
        final int i2 = order.orderId;
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = this.baseActivity.getResources().getString(R.string.delete_order_warning_notice);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.g.t
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
            
            public final void cancel() {
                OrderAdapter.this.m4474a(i2, dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.g.u
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                OrderAdapter.this.m4479b(dialogInterface);
            }
        });
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            if (this.f7525h != null) {
                this.f7525h.dismiss();
            }
            if (this.baseActivity instanceof OrderActivity) {
                ((OrderActivity) this.baseActivity).m6276I();
            }
        } catch (Exception e2) {
            e2.getLocalizedMessage();
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
