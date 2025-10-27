package com.jeil.emarket.adapters.newsletter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.activities.product.ShopActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Category;
import java.util.List;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;


/* renamed from: b.f.a.b.f.g */

public class ItemShimmerCategoryHomeAdapter extends BaseMainAdapter<Category, RecyclerView.ViewHolder> {

    /* renamed from: b.f.a.b.f.g$a */
    public static class MainVM extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ImageView f7230t;

        /* renamed from: u */
        public final TextView f7231u;

        /* renamed from: v */
        public final MaterialRippleLayout f7232v;

        public MainVM(View view) {
            super(view);
            this.f7232v = (MaterialRippleLayout) view.findViewById(R.id.mrl_main);
            this.f7230t = (ImageView) view.findViewById(R.id.iv_category_img);
            this.f7231u = (TextView) view.findViewById(R.id.tv_category_name);
        }
    }

    /* renamed from: b.f.a.b.f.g$b */
    public static class SecondVM extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final View f7233t;

        /* renamed from: u */
        public final LinearLayoutCompat f7234u;

        public SecondVM(View view) {
            super(view);
            this.f7234u = (LinearLayoutCompat) view.findViewById(R.id.ll_main);
            this.f7233t = view.findViewById(R.id.vw_img);
        }
    }

    public ItemShimmerCategoryHomeAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    @Override // p078b.p159f.p160a.p178b.p180b.AbstractC1770c
    
    public void addAll(List<Category> list) {
        this.arrayList.clear();
        this.arrayList.addAll(list);
        Category category = new Category();
        category.f12393id = 0;
        category.name = this.baseActivity.getResources().getString(R.string.all_products);
        this.arrayList.add(0, category);
        this.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((Category) this.arrayList.get(i)).type == null || !((Category) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof MainVM) {
            MainVM mainVMVar = (MainVM) recyclerViewViewHolder;
            ViewGroup.LayoutParams layoutParams = mainVMVar.f7230t.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = mainVMVar.f7230t.getLayoutParams();
            int m4299b = (((BaseActivity.anInt - this.baseActivity.m4299b(40)) * 5) / 32) - this.baseActivity.m4299b(6);
            layoutParams2.height = m4299b;
            layoutParams.width = m4299b;
            mainVMVar.f7232v.getLayoutParams().width = (int) (BaseActivity.anInt / 5.6f);
            ((RequestBuilder) ((((Category) this.arrayList.get(position)).img == null || ((Category) this.arrayList.get(position)).img.isEmpty()) ?
                    Glide.with((FragmentActivity) this.baseActivity).load(this.baseActivity.getResources().getDrawable(R.drawable.cat_8)).load(R.drawable.ic_placeholder) : CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(((Category) this.arrayList.get(position)).img, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL)))).into(mainVMVar.f7230t);
            mainVMVar.f7231u.setText(((Category) this.arrayList.get(position)).name);
            if (position < 2) {
                ((RecyclerView.LayoutParams) mainVMVar.f7232v.getLayoutParams()).setMarginStart(Util.dp2px((Context) this.baseActivity, 8));
            } else {
                if (position >= getItemCount() - (getItemCount() % 2 != 0 ? 1 : 2)) {
                    ((RecyclerView.LayoutParams) mainVMVar.f7232v.getLayoutParams()).setMarginEnd(Util.dp2px((Context) this.baseActivity, 8));
                }
            }
            mainVMVar.f7232v.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.f.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemShimmerCategoryHomeAdapter.this.m4433a(position, view);
                }
            });
            return;
        }
        if (recyclerViewViewHolder instanceof SecondVM) {
            SecondVM secondVMVar = (SecondVM) recyclerViewViewHolder;
            ViewGroup.LayoutParams layoutParams3 = secondVMVar.f7233t.getLayoutParams();
            ViewGroup.LayoutParams layoutParams4 = secondVMVar.f7233t.getLayoutParams();
            int m4299b2 = (((BaseActivity.anInt - this.baseActivity.m4299b(40)) * 5) / 32) - this.baseActivity.m4299b(12);
            layoutParams4.height = m4299b2;
            layoutParams3.width = m4299b2;
            secondVMVar.f7234u.getLayoutParams().width = (int) (BaseActivity.anInt / 5.8f);
            if (position < 2) {
                ((GridLayoutManager.LayoutParams) secondVMVar.f7234u.getLayoutParams()).setMarginStart(Util.dp2px((Context) this.baseActivity, 8));
            } else if (position >= getItemCount() - 2) {
                ((GridLayoutManager.LayoutParams) secondVMVar.f7234u.getLayoutParams()).setMarginEnd(Util.dp2px((Context) this.baseActivity, 8));
            }
        }
    }

    
    public  void m4433a(int i, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), ShopActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", ((Category) this.arrayList.get(i)).f12393id);
        intent.putExtra("tree", ((Category) this.arrayList.get(i)).tree);
        intent.putExtra("from_category", true);
        this.baseActivity.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return i == 1 ? new SecondVM(from.inflate(R.layout.item_shimmer_category_home, viewGroup, false)) : new MainVM(from.inflate(R.layout.item_category_home, viewGroup, false));
    }
}
