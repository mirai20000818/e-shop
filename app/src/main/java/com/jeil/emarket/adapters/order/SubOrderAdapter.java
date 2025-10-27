package com.jeil.emarket.adapters.order;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.account.OrderDetailActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.point.PointActivity;
import com.jeil.emarket.activities.point.PointEditActivity;
import com.jeil.emarket.activities.ticket.chat.TicketUserChatActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.DialogOrderCancel;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.viewmodel.ModelCollection;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

/* renamed from: b.f.a.b.g.e1 */

public class SubOrderAdapter extends BaseMainAdapter<SubOrder, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final HashMap<java.lang.String, java.lang.String> f7314f;

    /* renamed from: g */
    public final LayoutInflater f7315g;

    /* renamed from: h */
    public int f7316h;


    public boolean f7317i;

    /* renamed from: b.f.a.b.g.e1$a */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* renamed from: b.f.a.b.g.e1$b */
    public static class b extends RecyclerView.ViewHolder {


        public final MaterialRippleLayout f7318A;


        public final TextView f7319B;


        public final TextView f7320C;


        public final TextView f7321D;


        public final TextView f7322E;

        /* renamed from: F */
        public final TextView f7323F;

        /* renamed from: G */
        public final TextView f7324G;

        /* renamed from: H */
        public final PriceText f7325H;


        public final PriceText f7326I;

       
        public final PriceText f7327J;


        public final PriceText f7328K;

        /* renamed from: L */
        public final PriceText f7329L;

        /* renamed from: M */
        public final PriceText f7330M;

        /* renamed from: N */
        public final PriceText f7331N;

        /* renamed from: O */
        public final PriceText f7332O;

        /* renamed from: P */
        public final PriceText f7333P;

        /* renamed from: Q */
        public final LinearLayoutCompat f7334Q;

        /* renamed from: R */
        public final LinearLayoutCompat f7335R;

        /* renamed from: S */
        public final LinearLayoutCompat f7336S;

        /* renamed from: T */
        public final LinearLayoutCompat f7337T;

        /* renamed from: U */
        public final LinearLayoutCompat f7338U;

        /* renamed from: V */
        public final LinearLayoutCompat f7339V;

        /* renamed from: W */
        public final LinearLayoutCompat f7340W;

        /* renamed from: X */
        public final TextView f7341X;

        /* renamed from: Y */
        public final LinearLayoutCompat f7342Y;

        /* renamed from: Z */
        public final LinearLayoutCompat f7343Z;

        /* renamed from: a0 */
        public final RecyclerView f7344a0;

        /* renamed from: b0 */
        public final View f7345b0;

        /* renamed from: c0 */
        public final View f7346c0;

        /* renamed from: d0 */
        public final ProgressBar f7347d0;

        /* renamed from: e0 */
        public final ProgressBar f7348e0;

        /* renamed from: f0 */
        public final ProgressBar f7349f0;

        /* renamed from: g0 */
        public final TextView f7350g0;

        /* renamed from: h0 */
        public final TextView f7351h0;

        /* renamed from: i0 */
        public final ActionLink f7352i0;

        /* renamed from: j0 */
        public final LinearLayoutCompat f7353j0;

        /* renamed from: k0 */
        public final LinearLayoutCompat f7354k0;

        /* renamed from: l0 */
        public final MaterialRippleLayout f7355l0;

        /* renamed from: m0 */
        public final MaterialRippleLayout f7356m0;

        /* renamed from: t */
        public final TextView f7357t;

        /* renamed from: u */
        public final TextView f7358u;

        /* renamed from: v */
        public final TextView f7359v;

        /* renamed from: w */
        public final TextView f7360w;

        /* renamed from: x */
        public final TextView f7361x;

        /* renamed from: y */
        public final TextView f7362y;

        /* renamed from: z */
        public final MaterialRippleLayout f7363z;

        public b(View view) {
            super(view);
            this.f7357t = (TextView) view.findViewById(R.id.ctv_suborder_vendor_name);
            this.f7358u = (TextView) view.findViewById(R.id.ctv_suborder_id);
            this.f7359v = (TextView) view.findViewById(R.id.ctv_suborder_arrived_at);
            this.f7360w = (TextView) view.findViewById(R.id.ctv_suborder_deliverer);
            this.f7361x = (TextView) view.findViewById(R.id.tv_phone1);
            this.f7362y = (TextView) view.findViewById(R.id.tv_phone2);
            this.f7363z = (MaterialRippleLayout) view.findViewById(R.id.mrl_phone1);
            this.f7318A = (MaterialRippleLayout) view.findViewById(R.id.mrl_phone2);
            this.f7325H = (PriceText) view.findViewById(R.id.pt_suborder_kpf_total);
            this.f7326I = (PriceText) view.findViewById(R.id.pt_suborder_kpw_total);
            this.f7319B = (TextView) view.findViewById(R.id.ctv_suborder_free_shipping);
            this.f7332O = (PriceText) view.findViewById(R.id.pt_suborder_shipping_price);
            this.f7333P = (PriceText) view.findViewById(R.id.pt_discuss_shipping_price);
            this.f7320C = (TextView) view.findViewById(R.id.ctv_suborder_shipping_method);
            this.f7321D = (TextView) view.findViewById(R.id.ctv_suborder_urgent_shipping);
            this.f7327J = (PriceText) view.findViewById(R.id.pt_suborder_cancel_refund_kpf_price);
            this.f7328K = (PriceText) view.findViewById(R.id.pt_suborder_cancel_refund_kpw_price);
            this.f7329L = (PriceText) view.findViewById(R.id.pt_kpf_suborder_checkout_total);
            this.f7330M = (PriceText) view.findViewById(R.id.pt_kpw_suborder_checkout_total);
            this.f7322E = (TextView) view.findViewById(R.id.ctv_suborder_payment_method);
            this.f7331N = (PriceText) view.findViewById(R.id.pt_suborder_payment_price);
            this.f7324G = (TextView) view.findViewById(R.id.ctv_point_notice);
            this.f7334Q = (LinearLayoutCompat) view.findViewById(R.id.llc_payment);
            this.f7335R = (LinearLayoutCompat) view.findViewById(R.id.ll_phone);
            this.f7323F = (TextView) view.findViewById(R.id.ctv_suborder_status);
            this.f7336S = (LinearLayoutCompat) view.findViewById(R.id.llc_cancel_refund_item);
            this.f7337T = (LinearLayoutCompat) view.findViewById(R.id.ll_arrived_at_item);
            this.f7338U = (LinearLayoutCompat) view.findViewById(R.id.llc_deliverer_item);
            this.f7339V = (LinearLayoutCompat) view.findViewById(R.id.llc_suborder_points);
            this.f7340W = (LinearLayoutCompat) view.findViewById(R.id.llc_point_box);
            this.f7341X = (TextView) view.findViewById(R.id.ctv_suborder_unknown_shipping);
            this.f7342Y = (LinearLayoutCompat) view.findViewById(R.id.llc_discuss_shipping_price_info);
            this.f7343Z = (LinearLayoutCompat) view.findViewById(R.id.ll_info);
            this.f7344a0 = (RecyclerView) view.findViewById(R.id.rv_order_products);
            this.f7345b0 = view.findViewById(R.id.v_border);
            this.f7346c0 = view.findViewById(R.id.v_discuss_shipping_price);
            this.f7347d0 = (ProgressBar) view.findViewById(R.id.pb_suborder_support);
            this.f7348e0 = (ProgressBar) view.findViewById(R.id.pb_suborder_service);
            this.f7349f0 = (ProgressBar) view.findViewById(R.id.pb_suborder_shipping);
            this.f7350g0 = (TextView) view.findViewById(R.id.ctv_action_point);
            this.f7351h0 = (TextView) view.findViewById(R.id.ctv_exceeded_time);
            this.f7352i0 = (ActionLink) view.findViewById(R.id.cal_cancel_order);
            this.f7353j0 = (LinearLayoutCompat) view.findViewById(R.id.llc_order_actions);
            this.f7354k0 = (LinearLayoutCompat) view.findViewById(R.id.ll_shipping_price);
            this.f7355l0 = (MaterialRippleLayout) view.findViewById(R.id.mrl_agree_price);
            this.f7356m0 = (MaterialRippleLayout) view.findViewById(R.id.mrl_move_to_ticket);
        }
    }

    public SubOrderAdapter(BaseActivity activityC1391g1, int i) {
        super(activityC1391g1);
        this.f7314f = new HashMap<>();
        this.f7317i = false;
        this.f7315g = LayoutInflater.from(activityC1391g1);
        this.f7316h = i;
    }


    public  void m4442a(android.content.DialogInterface dialogInterface) {
        this.f7317i = false;
    }


    public  void m4443a(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            ModelCollection.m5436b(this.baseActivity, this.f7316h);
        }
    }


    public  void m4444a(DialogOrderCancel dialogOrderCancel, SubOrder subOrder) {
        java.lang.String obj = ((Editable) Objects.requireNonNull(((EditText) dialogOrderCancel.findViewById(R.id.et_customer_note)).getText())).toString();
        if (obj.isEmpty() || obj.trim().length() == 0) {
            BaseActivity activityC1391g1 = this.baseActivity;
            Util.toast(activityC1391g1, activityC1391g1.getResources().getString(R.string.order_cancel_desc), "error", 0, 0);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", ((Editable) Objects.requireNonNull(dialogOrderCancel.f9122T.getText())).toString());
            jSONObject.put("status", "cancelled");
            jSONObject.put("orderVendorId", subOrder.vendorId);
        } catch (Exception unused) {
        }
        ((OrderDetailActivity) this.baseActivity).f11643N = true;
        ModelCollection.m5430a(this.baseActivity, subOrder.f12425id, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        dialogOrderCancel.dismiss();
        ModelCollection.f10217h.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.g.h0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj2) {
                SubOrderAdapter.this.m4443a(dialogC2001j, (Integer) obj2);
            }
        });
    }


    public final void m4445a(SubOrder.DeliveryInfo deliveryInfo, int i) {
        java.lang.String str;
        java.lang.String str2;
        if (deliveryInfo != null) {
            java.lang.String str3 = (i != 2 || (str2 = deliveryInfo.delivererPhone2) == null || str2.isEmpty()) ? (i != 1 || (str = deliveryInfo.delivererPhone1) == null || str.isEmpty()) ? "" : deliveryInfo.delivererPhone1 : deliveryInfo.delivererPhone2;
            if (!str3.isEmpty()) {
                try {
                    this.baseActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str3)));
                    return;
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
        Util.toast(this.baseActivity, R.string.not_exist_phone, "error");
    }


    public  void m4446a(SubOrder subOrder, View view) {
        m4445a(subOrder.delivery, 1);
    }


    public  void m4447a(SubOrder subOrder, DialogError dialogError) {
        ((OrderDetailActivity) this.baseActivity).f11643N = true;
        ModelCollection.m5426a(this.baseActivity, subOrder.f12425id);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        dialogError.dismiss();
        ModelCollection.f10217h.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.g.d0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SubOrderAdapter.this.m4448b(dialogC2001j, (Integer) obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((SubOrder) this.arrayList.get(i)).type == null || !((SubOrder) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x051e, code lost:
    
        if ((r12.kpf + r3.shipping.price) <= 0.0f) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x04c4, code lost:
    
        if (r3.totalAmount.kpf > 0.0f) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0520, code lost:
    
        r12 = 8;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @android.annotation.SuppressLint({"SetTextI18n"})

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(RecyclerView.ViewHolder r20, int r21) {
        /*
            Method dump skipped, instructions count: 1870
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p178b.p185g.C1815e1.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }


    public  void m4448b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            ModelCollection.m5436b(this.baseActivity, this.f7316h);
        }
    }


    public  void m4449b(SubOrder subOrder, View view) {
        m4445a(subOrder.delivery, 2);
    }


    public  void m4450c(final SubOrder subOrder, View view) {
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = this.baseActivity.getResources().getString(R.string.confirm_shipping_price_warning_notice);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.g.g0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                SubOrderAdapter.this.m4447a(subOrder, dialogError);
            }
        });
    }


    public  void m4451d(SubOrder subOrder, View view) {
        Intent intent = new Intent(this.baseActivity, TicketUserChatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id", subOrder.ticket);
        intent.putExtra("status", "pending");
        StringBuilder sb = new StringBuilder();
        sb.append(subOrder.f12425id);
        CustomString.m3171a(this.baseActivity, R.string.number_order, sb, " ");
        sb.append(this.baseActivity.getResources().getString(R.string.discuss_shipping_price));
        intent.putExtra("title", sb.toString());
        this.baseActivity.startActivityForResult(intent, 100);
    }


    public  void m4452e(SubOrder subOrder, View view) {
        SubOrder.VendorPoint vendorPoint = subOrder.point;
        if (vendorPoint == null || vendorPoint.support == 0.0f) {
            return;
        }
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), PointActivity.class);
        intent.putExtra("page", "account");
        intent.putExtra("pointId", subOrder.point.f12426id);
        this.baseActivity.startActivity(intent);
    }

    /* renamed from: f */
    public  void m4453f(SubOrder subOrder, View view) {
        SubOrder.VendorPoint vendorPoint = subOrder.point;
        if (vendorPoint == null || vendorPoint.support == 0.0f) {
            Intent intent = new Intent(this.baseActivity.getApplicationContext(), PointEditActivity.class);
            intent.putExtra("page", "add");
            intent.putExtra("orderId", subOrder.f12425id);
            intent.putExtra("parent_orderId", this.f7316h);
            intent.putExtra("vendorId", subOrder.vendorId);
            intent.putExtra("vendorName", subOrder.name);
            this.baseActivity.startActivity(intent);
        }
    }

    /* renamed from: g */
    public  void m4454g(final SubOrder subOrder, View view) {
        if ((subOrder.orderStatus.equals("requested") || subOrder.orderStatus.equals("accepted")) && !this.f7317i) {
            this.f7317i = true;
            final DialogOrderCancel dialogOrderCancel = new DialogOrderCancel(this.baseActivity);
            dialogOrderCancel.f8246v = this.baseActivity.getResources().getString(R.string.cancel_order_warning_notice);
            dialogOrderCancel.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
            dialogOrderCancel.show();
            dialogOrderCancel.m4585a( new DialogInterface() { // from class: b.f.a.b.g.k0
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

                public final void cancel() {
                    SubOrderAdapter.this.m4444a(dialogOrderCancel, subOrder);
                }
            });
            dialogOrderCancel.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.g.f0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    SubOrderAdapter.this.m4442a(dialogInterface);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new a(this.f7315g.inflate(R.layout.item_shimmer_suborder, viewGroup, false)) : new b(this.f7315g.inflate(R.layout.item_suborder, viewGroup, false));
    }
}
