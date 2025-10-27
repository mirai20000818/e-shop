package com.jeil.emarket.adapters.refund;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.account.OrderActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.OrderStatus;

public class OrderAct extends BaseMainAdapter<OrderStatus, OrderAct.a> {

    /* renamed from: f */
    public boolean f7093f;

    /* renamed from: g */
    public Context f7094g;

    /* renamed from: b.f.a.b.a.v$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public TextView f7095t;

        /* renamed from: u */
        public TextView f7096u;

        /* renamed from: v */
        public LinearLayoutCompat f7097v;

        public a(View view) {
            super(view);
            this.f7095t = (TextView) view.findViewById(R.id.tv_text);
            this.f7096u = (TextView) view.findViewById(R.id.tv_count);
            this.f7097v = (LinearLayoutCompat) view.findViewById(R.id.ll_order_status);
        }
    }

    public OrderAct(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7093f = false;
        this.f7094g = activityC1391g1;
    }


    public  void m4405a(Context context, int i, View view) {
        Intent intent = new Intent(context.getApplicationContext(), OrderActivity.class);
        intent.putExtra("status", ((OrderStatus) this.arrayList.get(i)).status);
        context.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public void onBindViewHolder(a viewHolder, final int i) {
        a aVar = (a) viewHolder;
//        final Context context = aVar.f3933a.getContext();
//        java.lang.String str = ((OrderStatus) this.arrayList.get(i)).status;
//        aVar.f7097v.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(context.getResources().getIdentifier(CustomString.append(str, "_bg"), "color", context.getPackageName()))));
//        aVar.f7097v.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.m
//            @Override // android.view.View.OnClickListener
//            public final void onClick(View view) {
//                OrderAct.this.m4405a(context, i, view);
//            }
//        });
//        aVar.f7095t.setTextColor(context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName())));
//        aVar.f7096u.setTextColor(context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName())));
//        aVar.f7095t.setText(Util.getIdentifier(this.baseActivity, str, "").substring(0, 2));
//        aVar.f7096u.setText(java.lang.String.valueOf(((OrderStatus) this.arrayList.get(i)).count));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(CustomString.m3150a(viewGroup, R.layout.item_order_status, viewGroup, false));
        aVar.f7097v.getLayoutParams().width = (viewGroup.getMeasuredWidth() - ((getItemCount() - 1) * BaseActivity.anInt2)) / getItemCount();
        if (this.f7093f) {
            aVar.f7097v.setPadding(0, Util.dp2px(this.f7094g, 10), 0, Util.dp2px(this.f7094g, 9));
            aVar.f7095t.setTextSize(1, 12.0f);
            aVar.f7096u.setTextSize(1, 13.5f);
        }
        return aVar;
    }
}
