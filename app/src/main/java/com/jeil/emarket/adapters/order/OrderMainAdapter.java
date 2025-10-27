package com.jeil.emarket.adapters.order;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.review.ReviewEditActivity;
import com.jeil.emarket.components.QuantityInput;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.OrderItem;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;


/* renamed from: b.f.a.b.g.a1 */

public class OrderMainAdapter extends BaseMainAdapter<OrderItem, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public String f7251f;

    /* renamed from: g */
    public String f7252g;

    /* renamed from: h */
    public int f7253h;

    
    public int f7254i;

   
    public Boolean f7255j;

    /* renamed from: b.f.a.b.g.a1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final RecyclerView f7256t;

        /* renamed from: u */
        public final QuantityInput f7257u;

        /* renamed from: v */
        public final TextView f7258v;

        /* renamed from: w */
        public final ProductPrice f7259w;

        /* renamed from: x */
        public final ProductPrice f7260x;

        /* renamed from: y */
        public final View f7261y;

        /* renamed from: z */
        public final View f7262z;

        public a(View view) {
            super(view);
            this.f7256t = (RecyclerView) view.findViewById(R.id.rv_cart_products);
            this.f7257u = (QuantityInput) view.findViewById(R.id.cqi_quantity);
            this.f7258v = (TextView) view.findViewById(R.id.tv_quantity);
            this.f7259w = (ProductPrice) view.findViewById(R.id.pp_kpf_price);
            this.f7260x = (ProductPrice) view.findViewById(R.id.pp_kpw_price);
            this.f7261y = view.findViewById(R.id.v_border);
            this.f7262z = view.findViewById(R.id.v_bottom_border);
        }
    }

    /* renamed from: b.f.a.b.g.a1$b */
    public static class b extends RecyclerView.ViewHolder {


        public final ProgressBar f7263A;


        public final View f7264B;


        public final LinearLayoutCompat f7265C;


        public final TextView f7266D;

        /* renamed from: t */
        public final ImageView f7267t;

        /* renamed from: u */
        public final TextView f7268u;

        /* renamed from: v */
        public final TextView f7269v;

        /* renamed from: w */
        public final TextView f7270w;

        /* renamed from: x */
        public final PriceText f7271x;

        /* renamed from: y */
        public final TextView f7272y;

        /* renamed from: z */
        public final TextView f7273z;

        public b(View view) {
            super(view);
            this.f7267t = (ImageView) view.findViewById(R.id.iv_order_item_product_img);
            this.f7268u = (TextView) view.findViewById(R.id.ctv_item_product_name);
            this.f7269v = (TextView) view.findViewById(R.id.ctv_item_count);
            this.f7270w = (TextView) view.findViewById(R.id.ctv_item_pre_count);
            this.f7271x = (PriceText) view.findViewById(R.id.ctv_item_total);
            this.f7272y = (TextView) view.findViewById(R.id.ctv_add_review_notice);
            this.f7273z = (TextView) view.findViewById(R.id.ctv_action_point);
            this.f7263A = (ProgressBar) view.findViewById(R.id.pb_item_review_rate);
            this.f7264B = view.findViewById(R.id.v_item_border);
            this.f7265C = (LinearLayoutCompat) view.findViewById(R.id.llc_review_item);
            this.f7266D = (TextView) view.findViewById(R.id.tv_cancel_item_count);
        }
    }

    public OrderMainAdapter(BaseActivity activityC1391g1, String str, String str2, int i, int i2, Boolean bool) {
        super(activityC1391g1);
        this.f7251f = str;
        this.f7252g = str2;
        this.f7253h = i;
        this.f7255j = bool;
        this.f7254i = i2;
    }


    public  void m4439a(OrderItem orderItem, View view) {
        OrderItem.Review review = orderItem.review;
        if (review == null || review.rating == 0.0f) {
            Intent intent = new Intent(this.baseActivity.getApplicationContext(), ReviewEditActivity.class);
            intent.putExtra("page", "add");
            intent.putExtra("productName", orderItem.name);
            intent.putExtra("productId", orderItem.productId);
            intent.putExtra("orderItemId", orderItem.f12404id);
            intent.putExtra("productImage", orderItem.productImg);
            intent.putExtra("vendorId", this.f7253h);
            intent.putExtra("orderId", this.f7254i);
            this.baseActivity.startActivity(intent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((OrderItem) this.arrayList.get(i)).discountType == null || ((OrderItem) this.arrayList.get(i)).discountType.isEmpty()) ? 2 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x022f  */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @android.annotation.SuppressLint({"SetTextI18n"})

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p178b.p185g.C1803a1.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return i == 1 ? new a(from.inflate(R.layout.item_order_discount, viewGroup, false)) : new b(from.inflate(R.layout.item_sub_product, viewGroup, false));
    }
}
