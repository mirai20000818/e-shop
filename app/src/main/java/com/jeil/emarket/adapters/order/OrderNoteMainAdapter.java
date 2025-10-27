package com.jeil.emarket.adapters.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.OrderNote;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.b.g.b1 */

public class OrderNoteMainAdapter extends BaseMainAdapter<OrderNote, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public int f7278f;

    /* renamed from: g */
    public boolean f7279g;

    /* renamed from: h */
    public List<java.lang.String> f7280h;

    
    public final LayoutInflater f7281i;

    /* renamed from: b.f.a.b.g.b1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final LinearLayoutCompat f7282t;

        /* renamed from: u */
        public final TextView f7283u;

        /* renamed from: v */
        public final TextView f7284v;

        /* renamed from: w */
        public final TextView f7285w;

        /* renamed from: x */
        public final TextView f7286x;

        /* renamed from: y */
        public final View f7287y;

        public a(View view) {
            super(view);
            this.f7282t = (LinearLayoutCompat) view.findViewById(R.id.ll_note_item);
            this.f7283u = (TextView) view.findViewById(R.id.tv_order_note_date);
            this.f7284v = (TextView) view.findViewById(R.id.tv_order_note_day);
            this.f7285w = (TextView) view.findViewById(R.id.tv_order_note_info);
            this.f7286x = (TextView) view.findViewById(R.id.tv_order_deliverer);
            this.f7287y = view.findViewById(R.id.v_note_border);
        }
    }

    /* renamed from: b.f.a.b.g.b1$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final View f7288t;

        /* renamed from: u */
        public final LinearLayoutCompat f7289u;

        public b(View view) {
            super(view);
            this.f7288t = view.findViewById(R.id.v_shimmer_note_border);
            this.f7289u = (LinearLayoutCompat) view.findViewById(R.id.llc_shimmer_note_item);
        }
    }

    public OrderNoteMainAdapter(BaseActivity activityC1391g1, int i, boolean z) {
        super(activityC1391g1);
        this.f7280h = new ArrayList();
        this.f7278f = i;
        this.f7279g = z;
        this.f7281i = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((OrderNote) this.arrayList.get(i)).type == null || !((OrderNote) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "StringFormatMatches"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        LinearLayoutCompat.LayoutParams c0541a;
        LinearLayoutCompat linearLayoutCompat;
        java.lang.String str;
        StringBuilder sb;
        java.lang.String str2;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        OrderNote orderNote = (OrderNote) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            Resources resources = this.baseActivity.getResources();
            this.f7280h.add(resources.getString(R.string.sunday));
            this.f7280h.add(resources.getString(R.string.monday));
            this.f7280h.add(resources.getString(R.string.tuesday));
            this.f7280h.add(resources.getString(R.string.wednesday));
            this.f7280h.add(resources.getString(R.string.thursday));
            this.f7280h.add(resources.getString(R.string.friday));
            this.f7280h.add(resources.getString(R.string.saturday));
            if (orderNote.date != null) {
                TextView textView = aVar.f7283u;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f7279g ? i + 1 + Status.f8820k : i + 1);
                sb2.append(". ");
                sb2.append(Util.m307b(orderNote.date));
                textView.setText(sb2.toString());
                aVar.f7284v.setText(this.f7280h.get(orderNote.date.getDay()));
            }
            if (!orderNote.status.equals("shipping") || orderNote.custom == null) {
                aVar.f7286x.setVisibility(View.GONE);
            } else {
                TextView textView2 = aVar.f7286x;
                StringBuilder sb3 = new StringBuilder();
                CustomString.m3171a(this.baseActivity, R.string.deliverer, sb3, " ");
                CustomString.m3175a(sb3, orderNote.custom, textView2);
                aVar.f7286x.setVisibility(View.VISIBLE);
            }
            java.lang.String[] split = orderNote.custom.split("_");
            str = "";
            if (orderNote.status.equals("accepted")) {
                sb = new StringBuilder();
                sb.append(orderNote.vendor);
                str2 = "에서 주문을 접수하였습니다.";
            } else {
                if (orderNote.status.equals("cancelledItem")) {
                    str = java.lang.String.format(this.baseActivity.getResources().getString(R.string.cancel_item_order_note), orderNote.vendor, split[0], split[1]);
                    if (split.length > 2) {
                        orderNote.custom = orderNote.custom.replaceAll("<br/>", "\n");
                        StringBuilder m3177b = CustomString.m3177b(str, "\n");
                        CustomString.m3171a(this.baseActivity, R.string.cancel_reason, m3177b, " ");
                        m3177b.append(split[2]);
                        str = m3177b.toString();
                    }
                } else if (orderNote.status.equals("addedItem")) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < split.length; i2 += 2) {
                        arrayList.add(split[i2] + "번 상품 " + split[i2 + 1] + this.baseActivity.getResources().getString(R.string.count_unit));
                    }
                    StringBuilder sb4 = new StringBuilder();
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        sb4.append((java.lang.String) arrayList.get(i3));
                        if (i3 != arrayList.size() - 1) {
                            sb4.append(", ");
                        }
                    }
                    str = orderNote.vendor + "에서 " + sb4.toString() + "를 추가하였습니다.";
                } else if (orderNote.status.equals("shipping")) {
                    sb = new StringBuilder();
                    sb.append(orderNote.vendor);
                    str2 = "에서 주문에 따르는 상품들을 송달하고있습니다.";
                } else if (orderNote.status.equals("completed")) {
                    str = orderNote.vendor.equals("손님") ? "손님이 주문을 완성하였습니다." : CustomString.m3160a(new StringBuilder(), orderNote.vendor, "에서 주문을 완성하였습니다.");
                } else if (orderNote.status.equals("readyToShip")) {
                    str = java.lang.String.format(this.baseActivity.getResources().getString(R.string.ready_to_ship_order_note), orderNote.vendor);
                } else if (orderNote.status.equals("cancelled")) {
                    if (orderNote.vendor.equals("손님")) {
                        str = CustomString.m3160a(CustomString.format("손님이 "), split[0].isEmpty() ? "" : CustomString.m3160a(new StringBuilder(), split[0], "의 "), "주문을 취소하였습니다.");
                        if (split.length > 1) {
                            orderNote.custom = orderNote.custom.replaceAll("<br/>", "\n");
                            sb = CustomString.m3177b(str, "\n");
                            CustomString.m3171a(this.baseActivity, R.string.cancel_reason, sb, " ");
                            str2 = orderNote.custom.split("_")[1];
                        }
                    } else if (orderNote.vendor.equals("백화점관리부")) {
                        str = CustomString.m3160a(CustomString.format("손님의 주문은 "), orderNote.vendor, "에 의하여 취소되였습니다.");
                        java.lang.String str3 = orderNote.custom;
                        if (str3 != null && !str3.isEmpty()) {
                            orderNote.custom = orderNote.custom.replaceAll("<br/>", "\n");
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("\n");
                            CustomString.m3171a(this.baseActivity, R.string.cancel_reason, sb, " ");
                            str2 = orderNote.custom;
                        }
                    } else {
                        str = CustomString.m3160a(new StringBuilder(), orderNote.vendor, "에서 주문을 취소하였습니다.");
                        java.lang.String str4 = orderNote.custom;
                        if (str4 != null && !str4.isEmpty()) {
                            orderNote.custom = orderNote.custom.replaceAll("<br/>", "\n");
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("\n");
                            CustomString.m3171a(this.baseActivity, R.string.cancel_reason, sb, " ");
                            str2 = orderNote.custom;
                        }
                    }
                } else if (orderNote.status.equals("refunded")) {
                    str = "손님이 주문을 반환하였습니다.";
                } else if (orderNote.status.endsWith("_created")) {
                    str = java.lang.String.format(this.baseActivity.getResources().getString(R.string.create_refund_order_note), split[0], split[4], split[1], split[2], split[3]);
                } else if (orderNote.status.endsWith("_accepted")) {
                    str = java.lang.String.format(this.baseActivity.getResources().getString(R.string.accepted_refund_order_note), split[0], split[4], split[1], split[2], split[3]);
                } else if (orderNote.status.endsWith("_shipping")) {
                    str = java.lang.String.format(this.baseActivity.getResources().getString(R.string.shipping_refund_order_note), split[0], split[4], split[1], split[2], split[3]);
                } else if (orderNote.status.endsWith("_testing")) {
                    str = java.lang.String.format(this.baseActivity.getResources().getString(R.string.testing_refund_order_note), split[0], split[4], split[1], split[2], split[3]);
                } else if (orderNote.status.endsWith("_completed")) {
                    str = java.lang.String.format(this.baseActivity.getResources().getString(R.string.completed_refund_order_note), split[0], split[4], split[1], split[2], split[3]);
                } else {
                    boolean endsWith = orderNote.status.endsWith("_cancelled");
                    int i4 = R.string.returnProduct;
                    if (endsWith && orderNote.vendor.equals("손님")) {
                        java.lang.String string = this.baseActivity.getResources().getString(R.string.cancelled_refund_by_customer_order_note);
                        Object[] objArr = new Object[4];
                        objArr[0] = split[4];
                        Resources resources2 = this.baseActivity.getResources();
                        if (!split[1].equals("return")) {
                            i4 = R.string.exchange;
                        }
                        objArr[1] = resources2.getString(i4);
                        objArr[2] = split[2];
                        objArr[3] = split[3];
                        str = java.lang.String.format(string, objArr);
                    } else if (orderNote.status.endsWith("_cancelled") && !orderNote.vendor.equals("손님")) {
                        java.lang.String string2 = this.baseActivity.getResources().getString(R.string.cancelled_refund_order_note);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = split[4];
                        Resources resources3 = this.baseActivity.getResources();
                        if (!split[1].equals("return")) {
                            i4 = R.string.exchange;
                        }
                        objArr2[1] = resources3.getString(i4);
                        objArr2[2] = split[2];
                        objArr2[3] = split[3];
                        str = java.lang.String.format(string2, objArr2);
                    }
                }
                aVar.f7285w.setText(str);
                if (i == getItemCount() - 1 || this.f7278f > Status.f8820k) {
                    return;
                }
                aVar.f7287y.setVisibility(View.GONE);
                c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
                c0541a.setMargins(0, Util.dp2px((Context) this.baseActivity, 9), 0, Util.dp2px((Context) this.baseActivity, 3));
                linearLayoutCompat = aVar.f7282t;
            }
            //sb.append(str2);
            //str = sb.toString();
            aVar.f7285w.setText(str);
            if (i == getItemCount() - 1) {
                return;
            } else {
                return;
            }
        }
        if (!(recyclerViewViewHolder instanceof b)) {
            return;
        }
        b bVar = (b) recyclerViewViewHolder;
        if (i != getItemCount() - 1 || this.f7278f > Status.f8820k) {
            return;
        }
        bVar.f7288t.setVisibility(View.GONE);
        c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
        c0541a.setMargins(0, Util.dp2px((Context) this.baseActivity, 9), 0, Util.dp2px((Context) this.baseActivity, 3));
        linearLayoutCompat = bVar.f7289u;
        linearLayoutCompat.setLayoutParams(c0541a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7281i.inflate(R.layout.item_shimmer_order_note, viewGroup, false)) : new a(this.f7281i.inflate(R.layout.item_order_note, viewGroup, false));
    }
}
