package com.jeil.emarket.adapters.ticket;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.ticket.chat.TicketCustomerChatActivity;
import com.jeil.emarket.activities.ticket.chat.TicketUserChatActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.TicketMessage;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.VendorListVM;

/* renamed from: b.f.a.b.j.m */

public class TicketMessageAdapter extends BaseMainAdapter<TicketMessage, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public User f7759f;

    /* renamed from: b.f.a.b.j.m$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ImageView f7760t;

        /* renamed from: u */
        public final TextView f7761u;

        /* renamed from: v */
        public final TextView f7762v;

        /* renamed from: w */
        public final TextView f7763w;

        /* renamed from: x */
        public final LinearLayoutCompat f7764x;

        /* renamed from: y */
        public final LinearLayoutCompat f7765y;

        /* renamed from: z */
        public final MaterialRippleLayout f7766z;

        public a(View view) {
            super(view);
            this.f7760t = (ImageView) view.findViewById(R.id.iv_user_avatar);
            this.f7761u = (TextView) view.findViewById(R.id.tv_created_at);
            this.f7762v = (TextView) view.findViewById(R.id.tv_user_name);
            this.f7763w = (TextView) view.findViewById(R.id.tv_message);
            this.f7764x = (LinearLayoutCompat) view.findViewById(R.id.llc_message);
            this.f7765y = (LinearLayoutCompat) view.findViewById(R.id.llc_updated_at);
            this.f7766z = (MaterialRippleLayout) view.findViewById(R.id.mrl_message);
        }
    }

    /* renamed from: b.f.a.b.j.m$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f7767t;

        /* renamed from: u */
        public final TextView f7768u;

        /* renamed from: v */
        public final TextView f7769v;

        /* renamed from: w */
        public final LinearLayoutCompat f7770w;

        /* renamed from: x */
        public final LinearLayoutCompat f7771x;

        /* renamed from: y */
        public final MaterialRippleLayout f7772y;

        public b(View view) {
            super(view);
            this.f7767t = (TextView) view.findViewById(R.id.tv_created_at);
            this.f7768u = (TextView) view.findViewById(R.id.tv_user_name);
            this.f7769v = (TextView) view.findViewById(R.id.tv_message);
            this.f7770w = (LinearLayoutCompat) view.findViewById(R.id.llc_message);
            this.f7771x = (LinearLayoutCompat) view.findViewById(R.id.llc_updated_at);
            this.f7772y = (MaterialRippleLayout) view.findViewById(R.id.mrl_message);
        }
    }

    public TicketMessageAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    public TicketMessageAdapter(BaseActivity activityC1391g1, User user) {
        super(activityC1391g1);
        this.f7759f = user;
    }


    public  void m4509a(TicketMessage ticketMessage, BaseDialog2 baseDialog2, View view, int i) {
        try {
            ((ClipboardManager) this.baseActivity.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("message", ticketMessage.message));
            Util.toast(this.baseActivity, R.string.text_copied, "success");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        baseDialog2.startAni();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        if (this.arrayList.get(i) == null || ((TicketMessage) this.arrayList.get(i)).createdBy.equals("user")) {
            return 1;
        }
        return ((this.baseActivity instanceof TicketUserChatActivity) || !((TicketMessage) this.arrayList.get(i)).createdBy.equals("market")) ? 2 : 3;
    }


    public  void m4511b(TicketMessage ticketMessage, BaseDialog2 baseDialog2, View view, int i) {
        try {
            ((ClipboardManager) this.baseActivity.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("message", ticketMessage.message));
            Util.toast(this.baseActivity, R.string.text_copied, "success");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        baseDialog2.startAni();
    }


    public  boolean m4510a(final TicketMessage ticketMessage, View view) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, new java.lang.String[]{this.baseActivity.getResources().getString(R.string.text_copy)});
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.b.j.g
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                TicketMessageAdapter.this.m4509a(ticketMessage, baseDialog2, view2, i);
            }
        };
        return true;
    }


    public  boolean m4512b(final TicketMessage ticketMessage, View view) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, new java.lang.String[]{this.baseActivity.getResources().getString(R.string.text_copy)});
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.b.j.j
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                TicketMessageAdapter.this.m4511b(ticketMessage, baseDialog2, view2, i);
            }
        };
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        BaseActivity activityC1391g1;
        LinearLayoutCompat linearLayoutCompat;
        MutableLiveData<Vendor> mutableLiveData;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            User user = this.f7759f;
            if (user == null) {
                user = UserVM.userMutableLiveData.getValue();
            }
            final TicketMessage ticketMessage = (TicketMessage) this.arrayList.get(i);
            TextView textView = aVar.f7761u;
            StringBuilder m3163a = CustomString.format("(");
            m3163a.append(Util.m307b(ticketMessage.createdAt));
            m3163a.append(")");
            textView.setText(m3163a.toString());
            aVar.f7763w.setText(ticketMessage.message);
            if (user != null && user.avatar > -1 && ticketMessage.createdBy.equals("user")) {
                aVar.f7762v.setText(user.fullName);
                ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.man, Glide.with((FragmentActivity) this.baseActivity).load(Util.m345e(java.lang.String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(user.avatar)))))).into(aVar.f7760t);
            }
            aVar.f7765y.setVisibility(ticketMessage.isResolved ? View.GONE : View.VISIBLE);
            aVar.f7766z.setOnLongClickListener(new View.OnLongClickListener() { // from class: b.f.a.b.j.i
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return TicketMessageAdapter.this.m4510a(ticketMessage, view);
                }
            });
            if (!(this.baseActivity instanceof TicketCustomerChatActivity)) {
                return;
            }
            ((FrameLayout.LayoutParams) aVar.f7764x.getLayoutParams()).gravity = 8388611;
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) aVar.f7765y.getLayoutParams())).gravity = 8388611;
            linearLayoutCompat = aVar.f7764x;
            activityC1391g1 = this.baseActivity;
        } else {
            b bVar = (b) recyclerViewViewHolder;
            final TicketMessage ticketMessage2 = (TicketMessage) this.arrayList.get(i);
            Ticket getValue = TicketCategoryListVM.ticketMutableLiveData.getValue();
            java.lang.String str = getValue == null ? "" : getValue.vendor.name;
            if (ticketMessage2.createdBy.endsWith("vendor") && (mutableLiveData = VendorListVM.f10363d) != null && mutableLiveData.getValue() != null) {
                str = VendorListVM.f10363d.getValue().name;
            }
            TextView textView2 = bVar.f7767t;
            StringBuilder m3163a2 = CustomString.format("(");
            m3163a2.append(Util.m307b(ticketMessage2.createdAt));
            m3163a2.append(")");
            textView2.setText(m3163a2.toString());
            bVar.f7769v.setText(ticketMessage2.message);
            TextView textView3 = bVar.f7768u;
            if (ticketMessage2.createdBy.endsWith("market")) {
                str = this.baseActivity.getResources().getString(R.string.market);
            } else if (!ticketMessage2.createdBy.equals("vendor")) {
                str = ticketMessage2.createdBy;
            }
            textView3.setText(str);
            bVar.f7772y.setOnLongClickListener(new View.OnLongClickListener() { // from class: b.f.a.b.j.h
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return TicketMessageAdapter.this.m4512b(ticketMessage2, view);
                }
            });
            activityC1391g1 = this.baseActivity;
            if (activityC1391g1 instanceof TicketCustomerChatActivity) {
                ((FrameLayout.LayoutParams) bVar.f7770w.getLayoutParams()).gravity = 8388613;
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) bVar.f7771x.getLayoutParams())).gravity = 8388613;
                return;
            }
            linearLayoutCompat = bVar.f7770w;
        }
        linearLayoutCompat.setBackgroundTintList(ColorStateList.valueOf(activityC1391g1.getResources().getColor(R.color.vendor_message)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new a(CustomString.m3150a(viewGroup, R.layout.item_message_customer, viewGroup, false));
        }
        return i == 2 ? new b(CustomString.m3150a(viewGroup, R.layout.item_message_vendor, viewGroup, false)) : new b(CustomString.m3150a(viewGroup, R.layout.item_message_market, viewGroup, false));
    }
}
