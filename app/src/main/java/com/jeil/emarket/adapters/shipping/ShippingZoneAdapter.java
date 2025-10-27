package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.pickerview.PickerViewObj;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.ShippingZone;

/* renamed from: b.f.a.b.k.a2 */

public class ShippingZoneAdapter extends BaseMainAdapter<ShippingZone, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7778f;

    /* renamed from: g */
    public final LayoutInflater f7779g;

    /* renamed from: h */
    public boolean f7780h;

    /* renamed from: b.f.a.b.k.a2$a */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* renamed from: b.f.a.b.k.a2$b */
    public static class b extends RecyclerView.ViewHolder {


        public final TextView f7781A;


        public final TextView f7782B;

        
        public final MaterialRippleLayout f7783C;

        
        public final TextView f7784D;

        /* renamed from: t */
        public final MaterialRippleLayout f7785t;

        /* renamed from: u */
        public final TextView f7786u;

        /* renamed from: v */
        public final TextView f7787v;

        /* renamed from: w */
        public final PriceText f7788w;

        /* renamed from: x */
        public final TextView f7789x;

        /* renamed from: y */
        public final TextView f7790y;

        /* renamed from: z */
        public final PriceText f7791z;

        public b(View view) {
            super(view);
            this.f7785t = (MaterialRippleLayout) view.findViewById(R.id.mrl_show_detail);
            this.f7786u = (TextView) view.findViewById(R.id.ctv_zone_name);
            this.f7787v = (TextView) view.findViewById(R.id.ctv_zones);
            this.f7788w = (PriceText) view.findViewById(R.id.pt_common_shipping_price);
            this.f7789x = (TextView) view.findViewById(R.id.ctv_common_shipping_time);
            this.f7790y = (TextView) view.findViewById(R.id.ctv_common_free_shipping);
            this.f7791z = (PriceText) view.findViewById(R.id.pt_urgent_shipping_price);
            this.f7781A = (TextView) view.findViewById(R.id.ctv_urgent_shipping_time);
            this.f7782B = (TextView) view.findViewById(R.id.ctv_urgent_free_shipping);
            this.f7783C = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete_zone);
            this.f7784D = (TextView) view.findViewById(R.id.ctv_using_status);
        }
    }

    public ShippingZoneAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7780h = false;
        this.f7779g = LayoutInflater.from(activityC1391g1);
        this.f7778f = baseInterface2;
    }


    public  void m4513a(final int i, final ShippingZone shippingZone, View view) {
        if (this.f7780h) {
            return;
        }
        this.f7780h = true;
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = this.baseActivity.getResources().getString(R.string.delete_shipping_zone_warning_notice);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.k.c0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                ShippingZoneAdapter.this.m4514a(i, shippingZone, dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.e0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                ShippingZoneAdapter.this.m4515a(dialogInterface);
            }
        });
    }


    public  void m4514a(int i, ShippingZone shippingZone, DialogError dialogError) {
        this.f7778f.mo4808a(i, java.lang.String.valueOf(shippingZone.f12446id), 1);
        dialogError.dismiss();
    }


    public  void m4515a(android.content.DialogInterface dialogInterface) {
        this.f7780h = false;
    }


    public  void m4516a(ShippingZone shippingZone, View view) {
        Intent intent = new Intent(this.baseActivity, ShippingZoneEditActivity.class);
        intent.putExtra("name", shippingZone.name);
        intent.putExtra("id", shippingZone.f12446id);
        intent.putExtra("type", "edit");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((ShippingZone) this.arrayList.get(i)).type == null || !((ShippingZone) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final ShippingZone shippingZone = (ShippingZone) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof b) {
            b bVar = (b) recyclerViewViewHolder;
            bVar.f7785t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShippingZoneAdapter.this.m4516a(shippingZone, view);
                }
            });
            bVar.f7786u.setText(shippingZone.name);
            StringBuilder sb = new StringBuilder();
            if (shippingZone.areas.size() != 0) {
                for (int i2 = 0; i2 < shippingZone.areas.size(); i2++) {
                    sb.append(PickerViewObj.m4699b(shippingZone.areas.get(i2), this.baseActivity));
                    if (i2 != shippingZone.areas.size() - 1) {
                        sb.append(", ");
                    }
                }
            }
            bVar.f7787v.setText(sb.toString());
            float f = shippingZone.price;
            if (f == 0.0f || f == -1.0f) {
                bVar.f7788w.setVisibility(View.GONE);
                bVar.f7790y.setVisibility(View.VISIBLE);
            } else {
                bVar.f7788w.setVisibility(View.VISIBLE);
                bVar.f7790y.setVisibility(View.GONE);
                bVar.f7788w.setCurrency(shippingZone.shippingCurrency);
                bVar.f7788w.setPrice(Util.m327c(shippingZone.price));
            }
            TextView textView = bVar.f7789x;
            StringBuilder m3163a = CustomString.format("(");
            m3163a.append(shippingZone.deliveryTime);
            m3163a.append(this.baseActivity.getResources().getString(R.string.hour_unit));
            m3163a.append(")");
            textView.setText(m3163a.toString());
            float f2 = shippingZone.urgentPrice;
            if (f2 == 0.0f || f2 == -1.0f) {
                bVar.f7791z.setVisibility(View.GONE);
                bVar.f7782B.setVisibility(View.VISIBLE);
            } else {
                bVar.f7791z.setVisibility(View.VISIBLE);
                bVar.f7782B.setVisibility(View.GONE);
                bVar.f7791z.setCurrency(shippingZone.shippingCurrency);
                bVar.f7791z.setPrice(Util.m327c(shippingZone.urgentPrice));
            }
            TextView textView2 = bVar.f7781A;
            StringBuilder m3163a2 = CustomString.format("(");
            m3163a2.append(shippingZone.urgentDeliveryTime);
            m3163a2.append(this.baseActivity.getResources().getString(R.string.hour_unit));
            m3163a2.append(")");
            textView2.setText(m3163a2.toString());
            bVar.f7784D.setText(this.baseActivity.getResources().getString(this.baseActivity.getResources().getIdentifier(shippingZone.status, "string", this.baseActivity.getPackageName())));
            bVar.f7784D.setBackground(this.baseActivity.getResources().getDrawable(R.drawable.bd_badge_round));
            bVar.f7784D.setBackgroundTintList(ColorStateList.valueOf(this.baseActivity.getResources().getColor(shippingZone.status.equals("using") ? R.color.requested : R.color.cancelled)));
            bVar.f7783C.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShippingZoneAdapter.this.m4513a(i, shippingZone, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new a(this.f7779g.inflate(R.layout.item_shimmer_shipping_zone, viewGroup, false)) : new b(this.f7779g.inflate(R.layout.item_shipping_zone, viewGroup, false));
    }
}
