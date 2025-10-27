package com.jeil.emarket.adapters.ticket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.ticket.chat.TicketUserChatActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;

/* renamed from: b.f.a.b.j.k */

public class TicketAdapter extends BaseMainAdapter<Ticket, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7742f;

    /* renamed from: g */
    public final BaseInterface2 f7743g;

    /* renamed from: b.f.a.b.j.k$a */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* renamed from: b.f.a.b.j.k$b */
    public static class b extends RecyclerView.ViewHolder {


        public final MaterialRippleLayout f7744A;


        public final LinearLayoutCompat f7745B;


        public final View f7746C;


        public final MaterialRippleLayout f7747D;

        /* renamed from: t */
        public final ImageView f7748t;

        /* renamed from: u */
        public final TextView f7749u;

        /* renamed from: v */
        public final TextView f7750v;

        /* renamed from: w */
        public final TextView f7751w;

        /* renamed from: x */
        public final TextView f7752x;

        /* renamed from: y */
        public final TextView f7753y;

        /* renamed from: z */
        public final TextView f7754z;

        public b(View view) {
            super(view);
            this.f7748t = (ImageView) view.findViewById(R.id.iv_user_avatar);
            this.f7749u = (TextView) view.findViewById(R.id.tv_status_badge);
            this.f7750v = (TextView) view.findViewById(R.id.tv_category_name);
            this.f7751w = (TextView) view.findViewById(R.id.tv_vendor_name);
            this.f7752x = (TextView) view.findViewById(R.id.tv_updated_at);
            this.f7753y = (TextView) view.findViewById(R.id.tv_message);
            this.f7754z = (TextView) view.findViewById(R.id.tv_user_name);
            this.f7744A = (MaterialRippleLayout) view.findViewById(R.id.mrl_ticket_item);
            this.f7745B = (LinearLayoutCompat) view.findViewById(R.id.llc_user_avatar);
            this.f7746C = view.findViewById(R.id.vw_not_read_badge);
            this.f7747D = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete);
        }
    }

    public TicketAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7742f = LayoutInflater.from(activityC1391g1);
        this.f7743g = baseInterface2;
    }


    public  void m4504a(DialogC2001j dialogC2001j, int i, Ticket ticket, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            this.f7743g.mo4808a(i, java.lang.String.valueOf(ticket._id), 1);
        }
    }


    public  void m4505a(final Ticket ticket, final int i, View view) {
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = this.baseActivity.getResources().getString(R.string.delete_ticket);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new DialogInterface() { // from class: b.f.a.b.j.a
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                dialogError.dismiss();
            }
        }, new DialogInterface() { // from class: b.f.a.b.j.e
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                TicketAdapter.this.m4507a(ticket, dialogError, i);
            }
        });
    }


    public  void m4506a(Ticket ticket, View view) {
        Intent intent = new Intent(this.baseActivity, TicketUserChatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id", ticket._id);
        intent.putExtra("status", ticket.status);
        intent.putExtra("title", ticket.title);
        this.baseActivity.startActivityForResult(intent, 100);
    }


    public  void m4507a(final Ticket ticket, DialogError dialogError, final int i) {
        TicketCategoryListVM.m5499a(this.baseActivity, ticket._id);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        dialogError.dismiss();
        TicketCategoryListVM.f10282h.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.j.b
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                TicketAdapter.this.m4504a(dialogC2001j, i, ticket, (Integer) obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((Ticket) this.arrayList.get(i)).type == null || !((Ticket) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        User getValue = UserVM.userMutableLiveData.getValue();
        final Ticket ticket = (Ticket) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof b) {
            b bVar = (b) recyclerViewViewHolder;
            bVar.f7749u.setText(Util.m335d(this.baseActivity, ticket.status.equals("pending") ? "open" : ticket.status));
            bVar.f7750v.setText(Util.m353g(ticket.categoryId));
            bVar.f7751w.setText(ticket.vendor.name);
            bVar.f7752x.setText(Util.m307b(ticket.updatedAt));
            bVar.f7753y.setText(ticket.message);
            if (getValue != null && getValue.avatar > -1) {
                ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.man, Glide.with((FragmentActivity) this.baseActivity).load(Util.m345e(java.lang.String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(getValue.avatar)))))).into(bVar.f7748t);
            }
            bVar.f7749u.setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), ticket.status.equals("open") ? "pending" : ticket.status, "color", this.baseActivity.getResources()));
            bVar.f7744A.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.j.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TicketAdapter.this.m4506a(ticket, view);
                }
            });
            bVar.f7746C.setVisibility((!ticket.status.equals("open") || ticket.read == 1) ? View.GONE : View.VISIBLE);
            bVar.f7747D.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.j.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TicketAdapter.this.m4505a(ticket, i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new a(this.f7742f.inflate(R.layout.item_shimmer_ticket, viewGroup, false)) : new b(this.f7742f.inflate(R.layout.item_ticket, viewGroup, false));
    }
}
