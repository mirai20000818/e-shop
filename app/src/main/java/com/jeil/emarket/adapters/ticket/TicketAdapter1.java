package com.jeil.emarket.adapters.ticket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.ticket.chat.TicketCustomerChatActivity;
import com.jeil.emarket.activities.ticket.chat.TicketMarketChatActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.User;


/* renamed from: b.f.a.b.j.l */

public class TicketAdapter1 extends BaseMainAdapter<Ticket, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public Boolean f7755f;

    /* renamed from: g */
    public final LayoutInflater f7756g;

    /* renamed from: b.f.a.b.j.l$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final LinearLayoutCompat f7757t;

        /* renamed from: u */
        public final TextView f7758u;

        public a(View view) {
            super(view);
            this.f7757t = (LinearLayoutCompat) view.findViewById(R.id.llc_shimmer_user_avatar);
            this.f7758u = (TextView) view.findViewById(R.id.tv_shimmer_vendor_name);
        }
    }

    public TicketAdapter1(BaseActivity activityC1391g1, Boolean bool) {
        super(activityC1391g1);
        this.f7755f = bool;
        this.f7756g = LayoutInflater.from(activityC1391g1);
    }

    
    public  void m4508a(Ticket ticket, View view) {
        Intent intent = new Intent(this.baseActivity, (this.f7755f.booleanValue() ? TicketCustomerChatActivity.class : TicketMarketChatActivity.class));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id", ticket._id);
        intent.putExtra("status", ticket.status);
        intent.putExtra("title", ticket.title);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((Ticket) this.arrayList.get(i)).type == null || !((Ticket) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Ticket ticket = (Ticket) this.arrayList.get(i);
        if (!(recyclerViewViewHolder instanceof TicketAdapter.b)) {
            if (recyclerViewViewHolder instanceof a) {
                a aVar = (a) recyclerViewViewHolder;
                if (this.f7755f.booleanValue()) {
                    aVar.f7757t.setVisibility(View.VISIBLE);
                } else {
                    aVar.f7757t.setVisibility(View.GONE);
                }
                aVar.f7758u.setVisibility(View.GONE);
                return;
            }
            return;
        }
        TicketAdapter.b bVar = (TicketAdapter.b) recyclerViewViewHolder;
        bVar.f7749u.setText(Util.m335d(this.baseActivity, (this.f7755f.booleanValue() || !ticket.status.equals("pending")) ? ticket.status : "open"));
        bVar.f7750v.setText(Util.m353g(ticket.categoryId));
        bVar.f7752x.setText(Util.m307b(ticket.updatedAt));
        bVar.f7753y.setText(ticket.message);
        bVar.f7754z.setText(ticket.user.fullName);
        User user = ticket.user;
        if (user == null || user.avatar <= -1 || !this.f7755f.booleanValue()) {
            bVar.f7745B.setVisibility(View.GONE);
            bVar.f7754z.setVisibility(View.GONE);
        } else {
           // ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.man, Glide.with((FragmentActivity) this.baseActivity).load(Util.m345e(java.lang.String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(ticket.user.avatar)))))).m3762a((Transformation<Bitmap>) new RoundedCorners(70), true).into(bVar.f7748t);
        }
        int identifier = this.baseActivity.getResources().getIdentifier(ticket.status.equals("open") ? "pending" : ticket.status, "color", this.baseActivity.getPackageName());
        if (identifier != 0) {
            bVar.f7749u.setBackgroundTintList(ColorStateList.valueOf(this.baseActivity.getResources().getColor(identifier)));
        }
        bVar.f7744A.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.j.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketAdapter1.this.m4508a(ticket, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new a(this.f7756g.inflate(R.layout.item_shimmer_ticket_vendor, viewGroup, false)) : new TicketAdapter.b(this.f7756g.inflate(R.layout.item_ticket_vendor, viewGroup, false));
    }
}
