package com.jeil.emarket.listener.cart;

import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;

/* compiled from: lambda */
/* renamed from: b.f.a.a.e.a0 */

public final  class DialogErrorInter implements DialogInterface {

    
    private final  DialogError f6601a;

    public DialogErrorInter(DialogError f6601a) {
        this.f6601a = f6601a;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
    
    public final void cancel() {
        this.f6601a.dismiss();
    }
}
