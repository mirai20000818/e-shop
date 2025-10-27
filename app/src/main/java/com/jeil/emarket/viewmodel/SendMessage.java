package com.jeil.emarket.viewmodel;

import android.content.Context;
import org.json.JSONObject;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;

/* compiled from: lambda */
/* renamed from: b.f.a.k.z1 */

public final  class SendMessage implements InterfaceContext {


    private final  Context f10440a;

    
    private final  JSONObject f10441b;

    public  SendMessage(Context context, JSONObject jSONObject) {
        this.f10440a = context;
        this.f10441b = jSONObject;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

    public final void mo4271a(Context context) {
        new API_PROVIDER(this.f10440a, "send_message", new TicketCategoryListVM()).post("e7/tickets/message", this.f10441b);
    }
}
