package com.jeil.emarket.adapters.refund;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.RefundRequestProduct;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;

import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.interf.BaseInterface2;

/* renamed from: b.f.a.b.a.x */

public class RefundRequestAdapter extends BaseMainAdapter<RefundRequestProduct, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7104f;

    /* renamed from: g */
    public final LayoutInflater f7105g;

    /* renamed from: h */
    public boolean f7106h;

    /* renamed from: b.f.a.b.a.x$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ImageView iv_product_img;

        /* renamed from: u */
        public final TextView tv_product_name;

        /* renamed from: v */
        public final TextView tv_request_id;

        /* renamed from: w */
        public final TextView tv_product_count;

        /* renamed from: x */
        public final TextView tv_cancel_order;

        /* renamed from: y */
        public final TextView tv_status_badge;

        /* renamed from: z */
        public final MaterialRippleLayout mrl_show_detail;
        private final Activity f3933a = null;

        public a(View view) {
            super(view);
            this.iv_product_img = (ImageView) view.findViewById(R.id.iv_product_img);
            this.tv_request_id = (TextView) this.f3933a.findViewById(R.id.tv_request_id);
            this.tv_product_name = (TextView) this.f3933a.findViewById(R.id.tv_product_name);
            this.tv_product_count = (TextView) this.f3933a.findViewById(R.id.tv_product_count);
            this.tv_status_badge = (TextView) this.f3933a.findViewById(R.id.tv_status_badge);
            this.tv_cancel_order = (TextView) this.f3933a.findViewById(R.id.tv_cancel_order);
            this.mrl_show_detail = (MaterialRippleLayout) this.f3933a.findViewById(R.id.mrl_show_detail);
        }
    }

    /* renamed from: b.f.a.b.a.x$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public RefundRequestAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7106h = false;
        this.f7104f = baseInterface2;
        this.f7105g = LayoutInflater.from(activityC1391g1);
    }


    public  void m4407a(int i, RefundRequestProduct refundRequestProduct, View view) {
        this.f7104f.mo4808a(i, java.lang.String.valueOf(refundRequestProduct.f12416id), 1);
    }


    public  void m4408a(DialogInterface dialogInterface) {
        this.f7106h = false;
    }


    public  void m4409a(BaseDialog2 baseDialog2, View view, int i) {
        Toast.makeText(this.baseActivity, (CharSequence) null, Toast.LENGTH_LONG).show();
        baseDialog2.startAni();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((RefundRequestProduct) this.arrayList.get(i)).type == null || !((RefundRequestProduct) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final RefundRequestProduct refundRequestProduct = (RefundRequestProduct) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.tv_request_id.setText(java.lang.String.valueOf(refundRequestProduct.f12416id));
            aVar.tv_product_name.setText(refundRequestProduct.productName);
            aVar.tv_product_count.setText(refundRequestProduct.quantity + Util.getIdentifier(this.baseActivity, "count", ""));
            aVar.tv_status_badge.setText(Util.m335d(this.baseActivity, refundRequestProduct.status));
            java.lang.String str = refundRequestProduct.productImg;
            ((str == null || str.isEmpty()) ? Glide.with((FragmentActivity) this.baseActivity).load(this.baseActivity.getResources().getDrawable(R.drawable.ic_placeholder)) : (RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(refundRequestProduct.productImg, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL))).into(aVar.iv_product_img);
            aVar.tv_status_badge.setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), refundRequestProduct.status, "color", this.baseActivity.getResources()));
            aVar.mrl_show_detail.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RefundRequestAdapter.this.m4410a(refundRequestProduct, view);
                }
            });
            aVar.tv_cancel_order.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RefundRequestAdapter.this.m4407a(i, refundRequestProduct, view);
                }
            });
            aVar.tv_cancel_order.setVisibility(((RefundRequestProduct) this.arrayList.get(i)).status.equals("requested") ? View.VISIBLE : View.GONE);
        }
    }


    public  void m4410a(RefundRequestProduct refundRequestProduct, View view) {
        Resources resources;
        int i;
        if (this.f7106h) {
            return;
        }
        View inflate = LayoutInflater.from(this.baseActivity).inflate(R.layout.item_refund_detail, (ViewGroup) null);
        CustomString.m3174a(new StringBuilder(), refundRequestProduct.f12416id, "", (TextView) inflate.findViewById(R.id.tv_popup_refund_id));
        ((TextView) inflate.findViewById(R.id.tv_popup_order_id)).setText(refundRequestProduct.displayOrderId + "");
        ((TextView) inflate.findViewById(R.id.tv_popup_refund_date)).setText(Util.m307b(refundRequestProduct.modifiedDate));
        TextView textView = (TextView) inflate.findViewById(R.id.tv_popup_refund_type);
        if (refundRequestProduct.type.equals("exchange")) {
            resources = this.baseActivity.getResources();
            i = R.string.exchange;
        } else {
            resources = this.baseActivity.getResources();
            i = R.string.returnProduct;
        }
        textView.setText(resources.getString(i));
        ((TextView) inflate.findViewById(R.id.tv_popup_refund_product)).setText(refundRequestProduct.productName);
        ((TextView) inflate.findViewById(R.id.tv_popup_refund_reason)).setText(refundRequestProduct.reason.text);
        ((TextView) inflate.findViewById(R.id.tv_popup_status_badge)).setText(Util.m335d(this.baseActivity, refundRequestProduct.status));
        inflate.findViewById(R.id.tv_popup_status_badge).setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), refundRequestProduct.status, "color", this.baseActivity.getResources()));
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, inflate);
        this.f7106h = true;
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.b.a.q
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                RefundRequestAdapter.this.m4409a(baseDialog2, view2, i2);
            }
        };
        baseDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.b.a.r
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RefundRequestAdapter.this.m4408a(dialogInterface);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7105g.inflate(R.layout.item_shimmer_product_request, viewGroup, false)) : new a(this.f7105g.inflate(R.layout.item_product_request, viewGroup, false));
    }
}
