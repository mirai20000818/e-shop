package com.jeil.emarket.adapters.fbt;

import android.annotation.SuppressLint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Faq;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;

import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.interf.BaseInterface2;

/* renamed from: b.f.a.b.h.o */

public class FaqAdapter extends BaseMainAdapter<Faq, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7577f;

    /* renamed from: g */
    public final LayoutInflater f7578g;

    /* renamed from: h */
    public String f7579h;

    /* renamed from: b.f.a.b.h.o$a */
    public static class aVM extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView tv_question;

        /* renamed from: u */
        public final TextView f7581u;

        /* renamed from: v */
        public final MaterialRippleLayout f7582v;

        public aVM(View view) {
            super(view);
            this.tv_question = (TextView) view.findViewById(R.id.tv_question);
            this.f7581u = (TextView) view.findViewById(R.id.tv_answer);
            this.f7582v = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete_faq);
        }
    }

    /* renamed from: b.f.a.b.h.o$b */
    public static class bVM extends RecyclerView.ViewHolder {
        public bVM(View view) {
            super(view);
        }
    }

    public FaqAdapter(BaseActivity activityC1391g1, String str, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7578g = LayoutInflater.from(activityC1391g1);
        this.f7579h = str;
        this.f7577f = baseInterface2;
    }


    public  void m4482a(final int i, View view) {
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = this.baseActivity.getResources().getString(R.string.delete_faq_warning_notice);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new DialogInterface() { // from class: b.f.a.b.h.d
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                dialogError.dismiss();
            }
        }, new DialogInterface() { // from class: b.f.a.b.h.c
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                FaqAdapter.this.m4483a(i, dialogError);
            }
        });
    }


    public  void m4483a(int i, DialogError dialogError) {
        this.f7577f.mo4808a(i, "", 1);
        dialogError.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((Faq) this.arrayList.get(i)).type == null || !((Faq) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof aVM) {
            aVM aVMVar = (aVM) recyclerViewViewHolder;
            aVMVar.tv_question.setText(((Faq) this.arrayList.get(i)).question);
            aVMVar.f7581u.setText(Html.fromHtml(((Faq) this.arrayList.get(i)).answer));
            if (!this.f7579h.equals("setting")) {
                aVMVar.f7582v.setVisibility(View.GONE);
            } else {
                aVMVar.f7582v.setVisibility(View.VISIBLE);
                aVMVar.f7582v.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.h.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FaqAdapter.this.m4482a(i, view);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new bVM(this.f7578g.inflate(R.layout.item_shimmer_faq, viewGroup, false)) : new aVM(this.f7578g.inflate(R.layout.item_faq, viewGroup, false));
    }
}
