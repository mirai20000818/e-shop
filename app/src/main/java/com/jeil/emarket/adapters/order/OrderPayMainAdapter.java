package com.jeil.emarket.adapters.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.widget.MaterialRippleLayoutEx;

/* renamed from: b.f.a.b.g.c1 */

public class OrderPayMainAdapter extends BaseMainAdapter<String, OrderPayMainAdapter.a> {

    /* renamed from: f */
    public String f7293f;

    /* renamed from: b.f.a.b.g.c1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public MaterialRippleLayoutEx f7294t;

        public a(View view) {
            super(view);
            this.f7294t = (MaterialRippleLayoutEx) view.findViewWithTag(Integer.valueOf(R.string.payment_method));
        }
    }

    public OrderPayMainAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7293f = Status.f8823n[0];
    }


    public  void m4440a(int i, View view) {
        this.f7293f = (String) this.arrayList.get(i);
        this.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public void onBindViewHolder(a viewHolder, @SuppressLint("RecyclerView") final int i) {
        a aVar = (a) viewHolder;
        aVar.f7294t.m4690a(this.baseActivity, (String) this.arrayList.get(i));
        aVar.f7294t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderPayMainAdapter.this.m4440a(i, view);
            }
        });
        aVar.f7294t.f8541G.setValue( Boolean.valueOf(this.f7293f.equals(this.arrayList.get(i))));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.baseActivity);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat.setGravity(16);
        View view = new View(this.baseActivity);
        view.setBackgroundResource(R.drawable.bg_dotted_line);
        view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        linearLayoutCompat.addView(view, new LinearLayoutCompat.LayoutParams(-1, Util.dp2px((Context) this.baseActivity, 2)));
        MaterialRippleLayoutEx materialRippleLayoutEx = new MaterialRippleLayoutEx(this.baseActivity);
        materialRippleLayoutEx.setTag(Integer.valueOf(R.string.payment_method));
        linearLayoutCompat.addView(materialRippleLayoutEx);
        return new a(linearLayoutCompat);
    }
}
