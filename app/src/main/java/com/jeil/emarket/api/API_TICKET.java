package com.jeil.emarket.api;

import android.content.Context;

import com.google.gson.Gson;
import com.jeil.emarket.interf.InterfaceTicketMessage;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.TicketMessage;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;

import org.json.JSONObject;

/* renamed from: b.f.a.i.u */

public class API_TICKET {


    //public C2966h f10148a;


    public InterfaceTicketMessage f10149b;

    public API_TICKET(String str, String str2, final Context context, InterfaceTicketMessage interfaceTicketMessage) {
//        this.f10148a = null;
//        this.f10149b = interfaceTicketMessage;
//        if (str != null) {
//            try {
//                C2960b.a aVar = new C2960b.a();
//                aVar.f10945b = "/test/ticket";
//                aVar.f10899s = "token=" + str + "&type=" + str2;
//                this.f10148a = C2960b.m5837a("http://10.99.8.2/", aVar);
//                this.f10148a.m5865b();
//                this.f10148a.m5872b("connect", new C2973a.a() { // from class: b.f.a.i.l
//                    @Override // p273c.p274a.p277c.C2973a.a
//
//                    public final void mo5399a(Object[] objArr) {
//                    }
//                });
//                this.f10148a.m5872b("createTicketSuccess", new C2973a.a() { // from class: b.f.a.i.n
//                    @Override // p273c.p274a.p277c.C2973a.a
//
//                    public final void mo5399a(Object[] objArr) {
//                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: b.f.a.i.o
//                            @Override // java.lang.Runnable
//                            public final void run() {
//                                API_TICKET.m5418a(r1);
//                            }
//                        });
//                    }
//                });
//                this.f10148a.m5872b("serverError", new C2973a.a() { // from class: b.f.a.i.k
//                    @Override // p273c.p274a.p277c.C2973a.a
//
//                    public final void mo5399a(Object[] objArr) {
//                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: b.f.a.i.i
//                            @Override // java.lang.Runnable
//                            public final void run() {
//                                API_TICKET.m5421d(r1, objArr);
//                            }
//                        });
//                    }
//                });
//                this.f10148a.m5872b("msgToReceive", new C2973a.a() { // from class: b.f.a.i.j
//                    @Override // p273c.p274a.p277c.C2973a.a
//
//                    public final void mo5399a(Object[] objArr) {
//                        API_TICKET.this.m5424a(objArr);
//                    }
//                });
//                this.f10148a.m5872b("changeStatusSuccess", new C2973a.a() { // from class: b.f.a.i.m
//                    @Override // p273c.p274a.p277c.C2973a.a
//
//                    public final void mo5399a(Object[] objArr) {
//                        API_TICKET.this.m5422a(context, objArr);
//                    }
//                });
//            } catch (URISyntaxException e2) {
//                e2.printStackTrace();
//            }
//        }
    }


    public static  void m5418a(Context context) {
        //til.m350f(context, context.getResources().getString(R.string.create_ticket_success));
        TicketCategoryListVM.f10283i.setValue( false);
    }


    public static  void m5421d(Context context, Object[] objArr) {
        //Util.toast(context, objArr[0] != null ? objArr[0].toString() : context.getResources().getString(R.string.server_failed), "error", 0, 0);
        TicketCategoryListVM.f10283i.setValue( true);
    }


    public  void m5422a(Context context, Object[] objArr) {
        try {
            Ticket ticket = (Ticket) new Gson().fromJson(objArr[0].toString(), new TokenM(this).getType());
            Ticket getValue = TicketCategoryListVM.ticketMutableLiveData.getValue();
            if (getValue == null || ticket._id == null || ticket.status == null || !ticket._id.equals(getValue._id)) {
                return;
            }
            //Util.m350f(context, context.getResources().getString(ticket.status.equals("resolved") ? R.string.resolve_ticket_success : R.string.close_ticket_success));
            getValue.status = ticket.status;
            TicketCategoryListVM.ticketMutableLiveData.setValue( getValue);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


    public void m5423a(String str, JSONObject jSONObject) {
//        if (this.f10148a.f10792c) {
//            this.f10148a.mo5862a(str, jSONObject);
//        }
    }


    public  void m5424a(Object[] objArr) {
        try {
            TicketMessage ticketMessage = (TicketMessage) new Gson().fromJson(objArr[0].toString(), new TokenModel(this).getType());
            if (this.f10149b != null) {
                this.f10149b.mo5398a(ticketMessage);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
