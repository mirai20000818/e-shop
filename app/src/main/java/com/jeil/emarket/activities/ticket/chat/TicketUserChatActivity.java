package com.jeil.emarket.activities.ticket.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.Util;
import com.google.gson.Gson;
import com.jeil.emarket.activities.ticket.list.TicketUserListActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.TicketMessage;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.services.MessageService;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.listener.ticket.ticket.ActivityTicketChat;
import com.jeil.emarket.listener.ticket.ticket.DialogErrorW;
import com.jeil.emarket.adapters.ticket.TicketMessageAdapter;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;


public class TicketUserChatActivity extends ActivityTicketChat {
    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_back).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.b.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketUserChatActivity.this.m6785f(view);
            }
        });
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    
    public void mo4374I() {
        if (m4309v()) {
            return;
        }
        if (this.f7013M.booleanValue()) {
            setResult(-1, new Intent(getApplicationContext(), TicketUserListActivity.class));
        }
        finish();
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    /* renamed from: P */
    public void mo4381P() {
        final DialogError dialogError = new DialogError(this);
        dialogError.f8246v = getResources().getString(R.string.resolveTicketWarning);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.f8250z.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_check_circle));
        dialogError.f8250z.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        dialogError.m4585a(new DialogErrorW(), new DialogInterface() { // from class: b.f.a.a.j.b.o
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
            
            public final void cancel() {
                TicketUserChatActivity.this.m6783a(dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.j.b.p
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                TicketUserChatActivity.this.m6784b(dialogInterface);
            }
        });
    }

    
    public  void m6783a(DialogError dialogError) {
        int i;
        User user;
        Ticket getValue = TicketCategoryListVM.ticketMutableLiveData.getValue();
        JSONObject jSONObject = new JSONObject();
        User user2 = new User();
        if (getValue == null || (user = getValue.agent) == null || (i = user.f12429id) <= 0) {
            i = 0;
        }
        user2.f12429id = i;
        try {
            jSONObject.put("_id", this.f7009I);
            jSONObject.put("status", "resolved");
            jSONObject.put("receiver", user2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f7013M = true;
        TicketCategoryListVM.m5502a(this, jSONObject);
        if (getValue != null) {
            getValue.status = "resolved";
            TicketCategoryListVM.ticketMutableLiveData.setValue( getValue);
            Util.toast(this, getString(R.string.resolvedTicket), "default", 0, 0);
        }
        View findViewById = findViewById(R.id.mrl_ticket_item);
        if (findViewById != null) {
            findViewById.setVisibility(View.GONE);
        }
        m4385a("user", getResources().getString(R.string.resolvedTicket), new Date(), "send", true);
        dialogError.dismiss();
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    @SuppressLint({"SetTextI18n"})
    
    public void mo4382a(Ticket ticket) {
        super.mo4382a(ticket);
        TextView textView = (TextView) findViewById(R.id.tv_status_badge);
        textView.setText(Util.m335d(this, ticket.status.equals("pending") ? "open" : ticket.status));
        textView.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(getResources().getIdentifier(ticket.status.equals("open") ? "pending" : ticket.status, "color", getPackageName()))));
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    
    public void mo4295a(User user) {
        if (Status.f8832w.booleanValue()) {
            super.mo4295a(user);
        }
    }

    
    public  void m6784b(android.content.DialogInterface dialogInterface) {
        this.f7016P = false;
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    
    public void mo4386b(String str) {
        TicketCategoryListVM.m5501a((Context) this, str, (Boolean) false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    
    public void mo4387b(List<TicketMessage> list) {
        if (list.size() > 0) {
            if (this.f7010J.equals("resolved")) {
                TicketMessage ticketMessage = new TicketMessage();
                ticketMessage.createdBy = "user";
                ticketMessage.message = getResources().getString(R.string.resolvedTicket);
                ticketMessage.createdAt = new Date();
                ticketMessage.isResolved = true;
                list.add(ticketMessage);
            }
            TicketMessageAdapter c1900m = new TicketMessageAdapter(this);
            c1900m.arrayList = list;
            c1900m.notifyDataSetChanged();
            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_messages);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
            recyclerView.setAdapter(c1900m);
            recyclerView.setHasFixedSize(true);
            if (this.f7012L.booleanValue()) {
                recyclerView.addItemDecoration(new ItemDecoration2(Util.dp2px((Context) this, 5), 1, false));
            }
            this.f7012L = false;
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.j.b.n
                @Override // java.lang.Runnable
                public final void run() {
                 //   r0.scrollBy(0, RecyclerView.this.computeVerticalScrollRange());
                }
            }, 300L);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    
    public void mo4388c(String str) {
        User user;
        Object obj;
        if (TicketCategoryListVM.ticketMutableLiveData.getValue() == null || UserVM.userMutableLiveData.getValue() == null) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        User user2 = new User();
        Ticket.Receiver receiver = new Ticket.Receiver(TicketCategoryListVM.ticketMutableLiveData.getValue().vendor.f12449id, TicketCategoryListVM.ticketMutableLiveData.getValue().vendor.f12449id == 0 ? "market" : "vendor");
        if (TicketCategoryListVM.ticketMutableLiveData.getValue().agent != null) {
            user2.f12429id = TicketCategoryListVM.ticketMutableLiveData.getValue().agent.f12429id;
            user2.name = TicketCategoryListVM.ticketMutableLiveData.getValue().agent.name;
            user = user2;
        } else {
            user = null;
        }
        try {
            jSONObject.put("ticketId", this.f7009I);
            jSONObject.put("createdBy", "user");
            jSONObject.put("message", str);
            if (Status.f8832w.booleanValue()) {
                jSONObject.put("type", "app");
                jSONObject.put("userId", UserVM.userMutableLiveData.getValue().f12429id);
                jSONObject.put("receiver", new Gson().toJson(receiver));
                obj = new Gson().toJson(user);
            } else {
                jSONObject.put("receiver", receiver);
                obj = user;
            }
            jSONObject.put("agent", obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f7013M = true;
        if (Status.f8832w.booleanValue() && MessageService.f12471g) {
            MessageService.f12472h.m7011a("sendCustomerMsg", jSONObject);
        } else {
            API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.a2
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
                
                public final void mo4271a(Context context) {
                    new API_PROVIDER(context, "send_message", new TicketCategoryListVM()).post("e6/tickets/message", jSONObject);
                }
            });
        }
        this.f7010J = "pending";
        m4385a("user", str, new Date(), "send", false);
        if (TicketCategoryListVM.ticketMutableLiveData.getValue() != null) {
            Ticket getValue = TicketCategoryListVM.ticketMutableLiveData.getValue();
            getValue.status = "pending";
            TicketCategoryListVM.ticketMutableLiveData.setValue( getValue);
        }
    }

    /* renamed from: f */
    public  void m6785f(View view) {
        mo4374I();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        mo4374I();
    }
}
