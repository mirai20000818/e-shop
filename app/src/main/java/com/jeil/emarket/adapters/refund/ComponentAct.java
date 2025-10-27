package com.jeil.emarket.adapters.refund;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.model.customer.Avatar;

/* renamed from: b.f.a.b.a.t */

public class ComponentAct extends BaseMainAdapter<Avatar, ComponentAct.a> {

    /* renamed from: f */
    public int f7075f;

    /* renamed from: b.f.a.b.a.t$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ImageView f7076t;

        /* renamed from: u */
        public final ImageView f7077u;

        public a(View view) {
            super(view);
            this.f7076t = (ImageView) view.findViewById(R.id.ivAvatar);
            this.f7077u = (ImageView) view.findViewById(R.id.ivAvatarCheck);
        }
    }

    public ComponentAct(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    
    public  void m4394a(@SuppressLint({"RecyclerView"}) int i, a aVar, View view) {
//        for (T t : this.arrayList) {
//            if (t.cur) {
//                notifyItemChanged(this.arrayList.indexOf(t));
//                t.cur = false;
//            }
//        }
        this.f7075f = i;
        java.lang.String str = ((Avatar) this.arrayList.get(i)).url;
        ((Avatar) this.arrayList.get(i)).cur = true;
        aVar.f7077u.setVisibility(View.VISIBLE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"UseCompatLoadingForDrawables", "WrongConstant"})

    public void onBindViewHolder(a viewHolder, @SuppressLint({"RecyclerView"}) final int i) {
        ImageView imageView;
        int i2;
        final a aVar = (a) viewHolder;
//        aVar.f3933a.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.a
//            @Override // android.view.View.OnClickListener
//            public final void onClick(View view) {
//                ComponentAct.this.m4394a(i, aVar, view);
//            }
//        });
        if (((Avatar) this.arrayList.get(i)).url != null) {
           // ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.man, Glide.with(aVar.f3933a.getContext()).load(Util.m306b(((Avatar) this.arrayList.get(i)).url, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL))).m3762a((Transformation<Bitmap>) new RoundedCorners(70), true).into(aVar.f7076t);
        }
        if (((Avatar) this.arrayList.get(i)).cur) {
            this.f7075f = i;
            java.lang.String str = ((Avatar) this.arrayList.get(i)).url;
            imageView = aVar.f7077u;
            i2 = 0;
        } else {
            imageView = aVar.f7077u;
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(CustomString.m3150a(viewGroup, R.layout.item_grid_avatar, viewGroup, false));
    }
}
