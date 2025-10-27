package com.jeil.emarket.adapters.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.QuantityInput;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.OrderItem;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;

import com.jeil.emarket.dialog.ImageDialog3;

/* renamed from: b.f.a.b.g.h1 */

public class OrderItemAdapter extends BaseMainAdapter<OrderItem, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public String f7405f;

    /* renamed from: g */
    public final LayoutInflater f7406g;

    /* renamed from: b.f.a.b.g.h1$a */
    public static class a extends RecyclerView.ViewHolder {


        public final View f7407A;


        public final View f7408B;

        /* renamed from: t */
        public final RecyclerView f7409t;

        /* renamed from: u */
        public final QuantityInput f7410u;

        /* renamed from: v */
        public final TextView f7411v;

        /* renamed from: w */
        public final TextView f7412w;

        /* renamed from: x */
        public final ProductPrice f7413x;

        /* renamed from: y */
        public final ProductPrice f7414y;

        /* renamed from: z */
        public final CheckBox f7415z;

        public a(View view) {
            super(view);
            this.f7409t = (RecyclerView) view.findViewById(R.id.rv_cart_products);
            this.f7410u = (QuantityInput) view.findViewById(R.id.cqi_quantity);
            this.f7411v = (TextView) view.findViewById(R.id.tv_quantity);
            this.f7412w = (TextView) view.findViewById(R.id.tv_discount_notice);
            this.f7413x = (ProductPrice) view.findViewById(R.id.pp_kpf_price);
            this.f7414y = (ProductPrice) view.findViewById(R.id.pp_kpw_price);
            this.f7415z = (CheckBox) view.findViewById(R.id.cb_product);
            this.f7407A = view.findViewById(R.id.v_border);
            this.f7408B = view.findViewById(R.id.v_bottom_border);
        }
    }

    /* renamed from: b.f.a.b.g.h1$b */
    public static class b extends RecyclerView.ViewHolder {


        public final ActionLink f7416A;


        public final ProductPrice f7417B;


        public final PriceText f7418C;


        public final View f7419D;

        
        public final TextView f7420E;

        /* renamed from: F */
        public final LinearLayoutCompat f7421F;

        /* renamed from: G */
        public final LinearLayoutCompat f7422G;

        /* renamed from: H */
        public final LinearLayoutCompat f7423H;

        
        public final TextView f7424I;

       
        public final QuantityInput f7425J;

        
        public Boolean f7426K;

        /* renamed from: t */
        public final AppCompatImageView f7427t;

        /* renamed from: u */
        public final TextView f7428u;

        /* renamed from: v */
        public final TextView f7429v;

        /* renamed from: w */
        public final LinearLayoutCompat f7430w;

        /* renamed from: x */
        public final TextView f7431x;

        /* renamed from: y */
        public final TextView f7432y;

        /* renamed from: z */
        public final LinearLayoutCompat f7433z;

        public b(View view) {
            super(view);
            this.f7426K = false;
            this.f7427t = (AppCompatImageView) view.findViewById(R.id.iv_order_item_product_img);
            this.f7428u = (TextView) view.findViewById(R.id.tv_item_product_name);
            this.f7429v = (TextView) view.findViewById(R.id.tv_sku);
            this.f7430w = (LinearLayoutCompat) view.findViewById(R.id.ll_sku_item);
            this.f7431x = (TextView) view.findViewById(R.id.tv_product_count);
            this.f7432y = (TextView) view.findViewById(R.id.tv_id);
            this.f7433z = (LinearLayoutCompat) view.findViewById(R.id.ll_product_id);
            this.f7416A = (ActionLink) view.findViewById(R.id.cal_show_refund_reason);
            this.f7417B = (ProductPrice) view.findViewById(R.id.pt_item_price);
            this.f7418C = (PriceText) view.findViewById(R.id.pt_sell_price);
            this.f7419D = view.findViewById(R.id.v_item_border);
            this.f7420E = (TextView) view.findViewById(R.id.tv_refund_reason);
            this.f7421F = (LinearLayoutCompat) view.findViewById(R.id.ll_main_info);
            this.f7422G = (LinearLayoutCompat) view.findViewById(R.id.ll_item_price);
            this.f7423H = (LinearLayoutCompat) view.findViewById(R.id.ll_sell_price);
            this.f7424I = (TextView) view.findViewById(R.id.tv_cancel_item_count);
            this.f7425J = (QuantityInput) view.findViewById(R.id.cqi_quantity);
        }
    }

    /* renamed from: b.f.a.b.g.h1$c */
    public static class c extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }
    }

    public OrderItemAdapter(BaseActivity activityC1391g1, String str) {
        super(activityC1391g1);
        this.f7405f = str;
        this.f7406g = LayoutInflater.from(activityC1391g1);
    }


    public static  void m4457a(ImageDialog3 dialogC2269y2, View view) {
        dialogC2269y2.m4882a(0);
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }


    public  void m4458a(int i, int i2) {
        ((OrderItem) this.arrayList.get(i)).cancelQty = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        if (((OrderItem) this.arrayList.get(i)).type == null || !((OrderItem) this.arrayList.get(i)).type.equals("shimmer")) {
            return (((OrderItem) this.arrayList.get(i)).discountType == null || ((OrderItem) this.arrayList.get(i)).discountType.isEmpty()) ? 3 : 2;
        }
        return 1;
    }


    public  void m4459b(int i, int i2) {
        ((OrderItem) this.arrayList.get(i)).curQty = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x033b  */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @android.annotation.SuppressLint({"SetTextI18n"})

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(RecyclerView.ViewHolder r17, final int r18) {
        /*
            Method dump skipped, instructions count: 831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p178b.p185g.C1824h1.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new c(this.f7406g.inflate(R.layout.item_shimmer_vendor_sub_product, viewGroup, false)) : i == 2 ? new a(this.f7406g.inflate(R.layout.item_cart_discount, viewGroup, false)) : new b(this.f7406g.inflate(R.layout.item_vendor_sub_product, viewGroup, false));
    }


    public static  void m4456a(b bVar, View view) {
        bVar.f7426K = Boolean.valueOf(!bVar.f7426K.booleanValue());
        if (bVar.f7426K.booleanValue()) {
            //Util.m313b((View) bVar.f7420E);
        } else {
            //Util.m243a((View) bVar.f7420E);
        }
        bVar.f7416A.setmImageView(bVar.f7426K.booleanValue() ? R.drawable.ic_angle_down : R.drawable.ic_angle_right);
    }
}
