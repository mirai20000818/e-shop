package com.jeil.emarket.viewmodel;

import com.jeil.emarket.model.customer.TicketMessage;
import com.jeil.emarket.model.vendor.OrderHistory;
import com.jeil.emarket.services.BackgroundService;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

/* renamed from: b.f.a.k.j3 */

public class HistoryVM extends ViewModel {

    
    public static MutableLiveData<OrderHistory> f10270d = new MutableLiveData<>();

    
    public static MutableLiveData<TicketMessage> f10271e = new MutableLiveData<>();

    
    public static void m5494c() {
        if (BackgroundService.f12457m) {
            BackgroundService.f12458n.m7005a();
        }
    }
}
