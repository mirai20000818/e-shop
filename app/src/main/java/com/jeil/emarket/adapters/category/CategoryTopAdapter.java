package com.jeil.emarket.adapters.category;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.interf.BaseInterface2;

/* renamed from: b.f.a.b.c.e */

public class CategoryTopAdapter extends BaseMainAdapter<Category, CategoryTopAdapter.MainVH> {

    /* renamed from: f */
    public final BaseInterface2 f7151f;

    /* renamed from: g */
    public int selpos;

    /* renamed from: b.f.a.b.c.e$a */
    public static class MainVH extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView name;

        public MainVH(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.tv_category_name);
        }
    }

    public CategoryTopAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.selpos = -1;
        this.f7151f = baseInterface2;
    }

    
    public  void m4428a(int i, View view) {
        this.f7151f.mo4808a(i, "", 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public void onBindViewHolder(MainVH viewHolder, @SuppressLint("RecyclerView") int position) {
        TextView textView;
        int i2;
        MainVH mainVHVar = (MainVH) viewHolder;
        mainVHVar.name.setText(((Category) this.arrayList.get(position)).name);
        mainVHVar.name.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.c.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryTopAdapter.this.m4428a(position, view);
            }
        });
        Resources resources = this.baseActivity.getResources();
        if (position == this.selpos) {
            mainVHVar.name.setBackgroundColor(resources.getColor(R.color.white));
            textView = mainVHVar.name;
            i2 = BaseActivity.color;
        } else {
            mainVHVar.name.setBackgroundColor(resources.getColor(R.color.transparent));
            textView = mainVHVar.name;
            i2 = R.color.dark;
        }
        textView.setTextColor(resources.getColor(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public MainVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MainVH(CustomString.m3150a(viewGroup, R.layout.item_category_top, viewGroup, false));
    }
}
