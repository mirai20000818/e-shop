package com.jeil.emarket.adapters.order;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.seller.VendorOrderDetailActivity;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.vendor.VendorOrder;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;

import com.jeil.emarket.frag.analy.staff.C2624m3;

/* renamed from: b.f.a.b.g.f1 */

public class VendorOrderAdaper extends BaseMainAdapter<VendorOrder, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public C2624m3 f7367f;

    /* renamed from: g */
    public final LayoutInflater f7368g;

    /* renamed from: b.f.a.b.g.f1$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f7369A;


        public final TextView f7370B;


        public final TextView f7371C;

        
        public final TextView f7372D;

        
        public final LinearLayoutCompat f7373E;

        /* renamed from: F */
        public final LinearLayoutCompat f7374F;

        /* renamed from: G */
        public final LinearLayoutCompat f7375G;

        /* renamed from: H */
        public final TextView f7376H;

        
        public final TextView f7377I;

       
        public final TextView f7378J;

        
        public final TextView f7379K;

        /* renamed from: L */
        public final TextView f7380L;

        /* renamed from: M */
        public final TextView f7381M;

        /* renamed from: N */
        public final LinearLayoutCompat f7382N;

        /* renamed from: O */
        public final TextView f7383O;

        /* renamed from: P */
        public final TextView f7384P;

        /* renamed from: Q */
        public final TextView f7385Q;

        /* renamed from: R */
        public final LinearLayoutCompat f7386R;

        /* renamed from: S */
        public final PriceText f7387S;

        /* renamed from: T */
        public final TextView f7388T;

        /* renamed from: t */
        public final MaterialRippleLayout f7389t;

        /* renamed from: u */
        public final TextView f7390u;

        /* renamed from: v */
        public final TextView f7391v;

        /* renamed from: w */
        public final LinearLayoutCompat f7392w;

        /* renamed from: x */
        public final LinearLayoutCompat f7393x;

        /* renamed from: y */
        public final ProductPrice f7394y;

        /* renamed from: z */
        public final ProductPrice f7395z;

        public a(View view) {
            super(view);
            this.f7389t = (MaterialRippleLayout) view.findViewById(R.id.mrl_item);
            this.f7390u = (TextView) view.findViewById(R.id.tv_order_id);
            this.f7391v = (TextView) view.findViewById(R.id.tv_order_requested_at);
            this.f7393x = (LinearLayoutCompat) view.findViewById(R.id.ll_kpf_order_total);
            this.f7392w = (LinearLayoutCompat) view.findViewById(R.id.ll_kpw_order_total);
            this.f7394y = (ProductPrice) view.findViewById(R.id.pp_kpw_order_total_price);
            this.f7395z = (ProductPrice) view.findViewById(R.id.pp_kpf_order_total_price);
            this.f7369A = (TextView) view.findViewById(R.id.tv_kpf_order_product_count);
            this.f7370B = (TextView) view.findViewById(R.id.tv_kpw_order_product_count);
            this.f7371C = (TextView) view.findViewById(R.id.tv_shipping_info);
            this.f7372D = (TextView) view.findViewById(R.id.tv_shipping_address);
            this.f7373E = (LinearLayoutCompat) view.findViewById(R.id.ll_shipping_address_item);
            this.f7376H = (TextView) view.findViewById(R.id.tv_shipping_method);
            this.f7374F = (LinearLayoutCompat) view.findViewById(R.id.ll_shipping_method_item);
            this.f7377I = (TextView) view.findViewById(R.id.tv_cancelled_reason);
            this.f7375G = (LinearLayoutCompat) view.findViewById(R.id.ll_cancelled_reason);
            this.f7378J = (TextView) view.findViewById(R.id.tv_order_status);
            this.f7379K = (TextView) view.findViewById(R.id.tv_urgent_order_badge);
            this.f7380L = (TextView) view.findViewById(R.id.tv_cancel_order_badge);
            this.f7381M = (TextView) view.findViewById(R.id.tv_refund_order_badge);
            this.f7382N = (LinearLayoutCompat) view.findViewById(R.id.ll_shipping_arrived_at_item);
            this.f7383O = (TextView) view.findViewById(R.id.tv_shipping_arrived_at);
            this.f7384P = (TextView) view.findViewById(R.id.tv_completed_at);
            this.f7385Q = (TextView) view.findViewById(R.id.tv_completed_at_label);
            this.f7386R = (LinearLayoutCompat) view.findViewById(R.id.ll_shipping_price);
            this.f7387S = (PriceText) view.findViewById(R.id.pt_shipping_price);
            this.f7388T = (TextView) view.findViewById(R.id.tv_fbt);
        }
    }

    /* renamed from: b.f.a.b.g.f1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public VendorOrderAdaper(BaseActivity activityC1391g1, C2624m3 c2624m3) {
        super(activityC1391g1);
        this.f7367f = c2624m3;
        this.f7368g = LayoutInflater.from(activityC1391g1);
    }


    public  void m4455a(VendorOrder vendorOrder, View view) {
        Intent intent = new Intent(this.baseActivity, VendorOrderDetailActivity.class);
        intent.putExtra("orderVendorId", vendorOrder.f12451id);
        intent.putExtra("displayOrderId", vendorOrder.displayOrderId);
        this.f7367f.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((VendorOrder) this.arrayList.get(i)).type == null || !((VendorOrder) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03aa  */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @android.annotation.SuppressLint({"SetTextI18n"})

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        /*
            Method dump skipped, instructions count: 1148
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p178b.p185g.C1818f1.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7368g.inflate(R.layout.item_shimmer_vendor_order, viewGroup, false)) : new a(this.f7368g.inflate(R.layout.item_vendor_order, viewGroup, false));
    }
}
