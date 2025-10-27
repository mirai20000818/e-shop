package com.jeil.emarket.adapters.category;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ShopActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.viewmodel.CategoryVM;

/* renamed from: b.f.a.b.c.d */

public class CategorySubAdapter extends BaseMainAdapter<Category, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public java.lang.String f7144f;

    public CategorySubAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((Category) this.arrayList.get(i)).children == null || ((Category) this.arrayList.get(i)).children.size() == 0) ? 3 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        //recyclerViewViewHolder.onBindViewHolder(recyclerViewViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 2 ? new SecondVH(CustomString.m3150a(viewGroup, R.layout.item_category_sub, viewGroup, false)) : new MainVH(CustomString.m3150a(viewGroup, R.layout.item_category_third, viewGroup, false));
    }

    /* renamed from: b.f.a.b.c.d$a */
    public class SecondVH extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ActionLink f7145t;

        public SecondVH(View view) {
            super(view);
            this.f7145t = (ActionLink) view.findViewById(R.id.cal_category_name);
        }


        public  void m4426a(int i, View view) {
            Intent intent = new Intent(CategorySubAdapter.this.baseActivity.getApplicationContext(), ShopActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("category", ((Category) CategorySubAdapter.this.arrayList.get(i)).f12393id);
            intent.putExtra("tree", ((Category) CategorySubAdapter.this.arrayList.get(i)).tree);
            CategoryVM.f10388f.setValue( false);
            CategorySubAdapter.this.baseActivity.startActivity(intent);
        }

        //@Override // p078b.p159f.p160a.p178b.p180b.C1773f

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            RecyclerView.LayoutParams layoutParams;
            BaseActivity activityC1391g1;
            int i2;
            SecondVH secondVHVar = (SecondVH) viewHolder;
            if (i != 0 && i != 1) {
                layoutParams = (RecyclerView.LayoutParams) secondVHVar.f7145t.getLayoutParams();
                activityC1391g1 = CategorySubAdapter.this.baseActivity;
                i2 = 20;
            } else {
                layoutParams = (RecyclerView.LayoutParams) secondVHVar.f7145t.getLayoutParams();
                activityC1391g1 = CategorySubAdapter.this.baseActivity;
                i2 = 0;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = Util.dp2px((Context) activityC1391g1, i2);
            secondVHVar.f7145t.setLayoutParams(layoutParams);
            secondVHVar.f7145t.setText(((Category) CategorySubAdapter.this.arrayList.get(i)).name);
            secondVHVar.f7145t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.c.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SecondVH.this.m4426a(i, view);
                }
            });
        }
    }

    /* renamed from: b.f.a.b.c.d$b */
    public class MainVH extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final MaterialRippleLayout f7147t;

        /* renamed from: u */
        public final TextView f7148u;

        /* renamed from: v */
        public final ImageView f7149v;

        public MainVH(View view) {
            super(view);
            this.f7147t = (MaterialRippleLayout) view.findViewById(R.id.mrl_main);
            this.f7148u = (TextView) view.findViewById(R.id.tv_category_name);
            this.f7149v = (ImageView) view.findViewById(R.id.iv_category_img);
        }


        public  void m4427a(int i, View view) {
            Intent intent = new Intent(CategorySubAdapter.this.baseActivity.getApplicationContext(), ShopActivity.class);
            intent.putExtra("category", ((Category) CategorySubAdapter.this.arrayList.get(i)).f12393id);
            intent.putExtra("tree", ((Category) CategorySubAdapter.this.arrayList.get(i)).tree);
            CategoryVM.f10388f.setValue( false);
            CategorySubAdapter.this.baseActivity.startActivity(intent);
        }

        //@Override // p078b.p159f.p160a.p178b.p180b.C1773f

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            MainVH mainVHVar = (MainVH) viewHolder;
            mainVHVar.f7148u.setText(((Category) CategorySubAdapter.this.arrayList.get(i)).name);
            java.lang.String str = ((Category) CategorySubAdapter.this.arrayList.get(i)).img;
            if (str == null || str.isEmpty()) {
                str = CategorySubAdapter.this.f7144f;
            }
            Glide.with((FragmentActivity) CategorySubAdapter.this.baseActivity).load(Util.m306b(str, "md")).diskCacheStrategy(DiskCacheStrategy.ALL).into(mainVHVar.f7149v);
            mainVHVar.f7147t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.c.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainVH.this.m4427a(i, view);
                }
            });
        }
    }
}
