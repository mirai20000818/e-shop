package com.jeil.emarket.activities.account;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.model.customer.Address;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.refund.AddressAdapter;
import com.jeil.emarket.dialog.DialogAddress;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.LiveDataCollection;


public class AddressActivity extends BaseActivity {

    
    public AddressAdapter addressAdapter;


    public DialogAddress dialogAddress = null;

    
    public XRecyclerView xRecyclerView;

    
    public void m6260I() {
        this.addressAdapter = new AddressAdapter(this);
        this.xRecyclerView = (XRecyclerView) findViewById(R.id.rv_address);
        this.xRecyclerView.setAdapter(this.addressAdapter);
        this.xRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        xRecyclerView.f12375Z0 = true;
        xRecyclerView.setLoadingMoreEnabled(false);
        this.xRecyclerView.setPaginationView(new View(this));
        View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
        ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_location);
        ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_address);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.xRecyclerView.setEmptyView(inflate);
        this.xRecyclerView.header = findViewById(R.id.header).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        ArrayList arrayList = new ArrayList();
        Address address = new Address();
        address.type = "shimmer";
        for (int i = 0; i < 6; i++) {
            arrayList.add(address);
        }
        LiveDataCollection.getAddress().setValue(arrayList);
        API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.u
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context) {
                new API_PROVIDER(getApplicationContext(), "get_address", new LiveDataCollection()).m5406a("e6/address");
            }
        });
        LiveDataCollection.getAddress().observe(this, new Observer() { // from class: b.f.a.a.a.b
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                AddressActivity.this.m6264b((List) obj);
            }
        });
    }

   
    public void m6261J() {
        this.dialogAddress = new DialogAddress(this, null);
        this.dialogAddress.show();
        this.dialogAddress.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AddressActivity.this.m6263b(dialogInterface);
            }
        });
    }


    public  void m6262a(Address address) {
        if (address != null) {
            if (this.addressAdapter.arrayList.size() == 1) {
                address.isDefault = true;
                address.type = "";
                List<Address> list = this.addressAdapter.arrayList;
                list.set(list.size() - 1, address);
                this.addressAdapter.notifyDataSetChanged();
                this.addressAdapter.notifyDataSetChanged();
                return;
            }
            List<Address> list2 = this.addressAdapter.arrayList;
            list2.set(list2.size() - 1, address);
            AddressAdapter addressAdapter = this.addressAdapter;
            addressAdapter.notifyItemChanged(this.xRecyclerView.arrayList.size() + addressAdapter.arrayList.size());
        }
    }


    public  void m6264b(List list) {
        AddressAdapter addressAdapter;
        if (list == null || (addressAdapter = this.addressAdapter) == null) {
            return;
        }
        addressAdapter.arrayList = list;
        addressAdapter.notifyDataSetChanged();
    }

    
    public  void m6265d(View view) {
        m6261J();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        AddressAdapter addressAdapter;
        super.onCreate(bundle);
        this.f6501u = false;
        setContentView(R.layout.activity_address);
        m4307e(R.string.shipping_addresses);
        findViewById(R.id.mrl_add_address).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressActivity.this.m6265d(view);
            }
        });
        m6260I();
        if (getIntent().getBooleanExtra("checkout", false) && (addressAdapter = this.addressAdapter) != null) {
            addressAdapter.f7078f = true;
        }
        addBottomNav(R.id.navigation_account);
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }


    public  void m6263b(DialogInterface dialogInterface) {
        if (this.dialogAddress.f9077V.equals("create")) {
            Address address = new Address();
            address.type = "shimmer";
            AddressAdapter addressAdapter = this.addressAdapter;
            addressAdapter.arrayList.add(address);
            addressAdapter.notifyItemChanged(addressAdapter.arrayList.size());
            if (this.addressAdapter.arrayList.size() == 1) {
                this.addressAdapter.notifyDataSetChanged();
            }
            LiveDataCollection.addressMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.a.d
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    AddressActivity.this.m6262a((Address) obj);
                }
            });
        }
    }
}
