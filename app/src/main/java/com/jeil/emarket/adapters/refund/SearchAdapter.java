package com.jeil.emarket.adapters.refund;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.interf.BaseInterface2;

/* renamed from: b.f.a.b.a.y */

public class SearchAdapter extends BaseMainAdapter<String, SearchAdapter.a> {

    /* renamed from: f */
    public final BaseInterface2 f7114f;

    /* renamed from: b.f.a.b.a.y$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public TextView f7115t;

        public a(View view) {
            super(view);
            this.f7115t = (TextView) view.findViewById(R.id.tv_search_term);
        }
    }

    public SearchAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7114f = baseInterface2;
    }


    public  void m4411a(int i, View view) {
        this.f7114f.mo4808a(i, (java.lang.String) this.arrayList.get(i), 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})

    public void onBindViewHolder(a viewHolder, final int i) {
        TextView textView;
        Resources resources;
        int i2;
        a aVar = (a) viewHolder;
        aVar.f7115t.setText((CharSequence) this.arrayList.get(i));
        aVar.f7115t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAdapter.this.m4411a(i, view);
            }
        });
        if (i == -1) {
            aVar.f7115t.setBackgroundResource(R.drawable.bg_attribute_selected);
            textView = aVar.f7115t;
            resources = this.baseActivity.getResources();
            i2 = BaseActivity.color;
        } else {
            aVar.f7115t.setBackgroundResource(R.drawable.bd_grey_ellipse);
            textView = aVar.f7115t;
            resources = this.baseActivity.getResources();
            i2 = R.color.dark;
        }
        textView.setTextColor(resources.getColor(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(CustomString.m3150a(viewGroup, R.layout.item_search_term, viewGroup, false));
    }
}
