package com.jeil.emarket.adapters.help;

import android.annotation.SuppressLint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Help;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;

import com.jeil.emarket.interf.BaseInterface2;

/* renamed from: b.f.a.b.e.b */

public class HelpAdapter extends BaseMainAdapter<Help, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7213f;

    /* renamed from: b.f.a.b.e.b$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final MaterialRippleLayout f7214t;

        /* renamed from: u */
        public final TextView f7215u;

        public a(View view) {
            super(view);
            this.f7215u = (TextView) view.findViewById(R.id.ctv_item_content);
            this.f7214t = (MaterialRippleLayout) view.findViewById(R.id.mrl_help_item);
        }
    }

    public HelpAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.baseActivity = activityC1391g1;
        this.f7213f = baseInterface2;
    }


    public  void m4431a(Help help, int i, View view) {
        if (help.isLink) {
            this.f7213f.mo4808a(i, help.text, 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        MaterialRippleLayout materialRippleLayout;
        final Help help = (Help) this.arrayList.get(i);
        a aVar = (a) viewHolder;
        TextView textView = aVar.f7215u;
        if (textView != null) {
            textView.setText(Html.fromHtml(help.text));
        }
        if (!help.isLink && (materialRippleLayout = aVar.f7214t) != null) {
            materialRippleLayout.setRippleAlpha(0);
            aVar.f7214t.setRippleColor(this.baseActivity.getResources().getColor(R.color.transparent));
        }
        MaterialRippleLayout materialRippleLayout2 = aVar.f7214t;
        if (materialRippleLayout2 != null) {
            materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.e.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HelpAdapter.this.m4431a(help, i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.baseActivity).inflate(R.layout.item_help, viewGroup, false));
    }
}
