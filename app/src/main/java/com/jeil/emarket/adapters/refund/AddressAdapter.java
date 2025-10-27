package com.jeil.emarket.adapters.refund;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.google.gson.Gson;
import com.jeil.emarket.activities.account.AddressActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.pickerview.PickerViewObj;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.dialog.DialogAddress;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.model.customer.Address;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.viewmodel.LiveDataCollection;
import com.jeil.emarket.viewmodel.UserVM;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: b.f.a.b.a.u */

public class AddressAdapter extends BaseMainAdapter<Address, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public boolean f7078f;

    /* renamed from: g */
    public DialogAddress f7079g;

    /* renamed from: h */
    public int f7080h;

    
    public AddressActivity f7081i;

   
    public final LayoutInflater f7082j;

    
    public boolean f7083k;
 
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        java.lang.String str;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Address address = (Address) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            final a aVar = (a) recyclerViewViewHolder;
            final int i2 = ((Address) this.arrayList.get(i)).id;
            aVar.f7086t.setText(address.name);
            TextView textView = aVar.f7087u;
            StringBuilder sb = new StringBuilder();
            sb.append(PickerViewObj.m4699b(address.address1, this.f7081i));
            sb.append(" ");
            CustomString.m3175a(sb, address.address2, textView);
            java.lang.String str2 = address.location;
            if (str2 == null || str2.isEmpty()) {
                aVar.f7088v.setVisibility(View.GONE);
            } else {
                aVar.f7088v.setText(address.location);
                aVar.f7088v.setVisibility(View.VISIBLE);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(address.phone1);
            java.lang.String str3 = address.phone1;
            sb2.append((str3 == null || str3.isEmpty() || (str = address.phone2) == null || str.isEmpty()) ? "" : ", ");
            sb2.append(address.phone2);
            aVar.f7089w.setText(sb2.toString());
            aVar.f7091y.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddressAdapter.this.m4400a(address, view);
                }
            });
            aVar.f7084A.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddressAdapter.this.m4401a(address, aVar, view);
                }
            });
            aVar.f7085B.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddressAdapter.this.m4403b(address, view);
                }
            });
            if (this.f7078f) {
                aVar.f7085B.setVisibility(View.GONE);
                aVar.f7090x.setVisibility(View.VISIBLE);
                aVar.f7090x.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AddressAdapter.this.m4404c(address, view);
                    }
                });
                aVar.f7092z.setVisibility(View.GONE);
            }
            LiveDataCollection.idLiveData.observe(this.f7081i, new Observer() { // from class: b.f.a.b.a.d
                @Override // p000a.p060o.InterfaceC0405p
                
                public final void onChanged(Object obj) {
                    AddressAdapter.this.m4398a(aVar, i2, (Integer) obj);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    public int getItemViewType(int i) {
        return (((Address) this.arrayList.get(i)).type == null || !((Address) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new a(this.f7082j.inflate(R.layout.item_address, viewGroup, false));
        }
        View inflate = this.f7082j.inflate(R.layout.item_shimmer_address, viewGroup, false);
        if (this.f7078f) {
            inflate.findViewById(R.id.ll_address_edit).setVisibility(View.GONE);
        }
        return new b(inflate);
    }



    
    public  void m4400a(Address address, View view) {
        if (this.f7083k) {
            return;
        }
        this.f7083k = true;
        if (address.id == LiveDataCollection.anInt) {
            return;
        }
        this.f7079g = new DialogAddress(this.f7081i, address);
        this.f7079g.show();
        this.f7079g.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.a.j
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                AddressAdapter.this.m4402b(dialogInterface);
            }
        });
    }

    /* renamed from: b.f.a.b.a.u$a */
    public static class a extends RecyclerView.ViewHolder {

        
        public final CheckBox f7084A;

        
        public final MaterialRippleLayout f7085B;

        /* renamed from: t */
        public final TextView f7086t;

        /* renamed from: u */
        public final TextView f7087u;

        /* renamed from: v */
        public final TextView f7088v;

        /* renamed from: w */
        public final TextView f7089w;

        /* renamed from: x */
        public final MaterialRippleLayout f7090x;

        /* renamed from: y */
        public final LinearLayoutCompat f7091y;

        /* renamed from: z */
        public final LinearLayoutCompat f7092z;

        public a(View view) {
            super(view);
            this.f7086t = (TextView) view.findViewById(R.id.tv_name);
            this.f7087u = (TextView) view.findViewById(R.id.tv_address);
            this.f7088v = (TextView) view.findViewById(R.id.tv_location);
            this.f7089w = (TextView) view.findViewById(R.id.tv_phone);
            this.f7090x = (MaterialRippleLayout) view.findViewById(R.id.mrl_address);
            this.f7091y = (LinearLayoutCompat) view.findViewById(R.id.ll_edit);
            this.f7092z = (LinearLayoutCompat) view.findViewById(R.id.ll_address_edit);
            this.f7084A = (CheckBox) view.findViewById(R.id.cb_isDefault);
            this.f7085B = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete_address);
        }
    }

    /* renamed from: b.f.a.b.a.u$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public AddressAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7078f = false;
        this.f7079g = null;
        this.f7080h = 0;
        this.f7083k = false;
        this.f7081i = (AddressActivity) activityC1391g1;
        this.f7082j = LayoutInflater.from(activityC1391g1);
    }

    
    public  void m4395a(int i, final int i2, final DialogError dialogError) {
        LiveDataCollection.m5547a(this.f7081i, i);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.f7081i);
        dialogC2001j.show();
        LiveDataCollection.integerMutableLiveData1.observe(this.f7081i, new Observer() { // from class: b.f.a.b.a.h
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                AddressAdapter.this.m4396a(i2, dialogError, dialogC2001j, (Integer) obj);
            }
        });
    }

    
    public  void m4397a(android.content.DialogInterface dialogInterface) {
        this.f7083k = false;
    }

    
    public  void m4398a(a aVar, int i, Integer num) {
        User getValue = UserVM.userMutableLiveData.getValue();
        if (getValue != null) {
            getValue.defaultAddressId = num.intValue();
            UserVM.userMutableLiveData.setValue( getValue);
        }
        if (num.intValue() != -1) {
            aVar.f7084A.setChecked(num.intValue() == i);
        }
        this.f7080h = num.intValue();
    }

    
    public  void m4399a(Address address) {
        if (address != null) {
            int i = -1;
            for (int i2 = 0; i2 < this.arrayList.size(); i2++) {
                if (((Address) this.arrayList.get(i2)).id == address.id) {
                    i = i2;
                }
            }
            if (i > -1) {
                this.arrayList.set(i, address);
                notifyItemChanged(this.f7081i.xRecyclerView.arrayList.size() + i + 1);
                if (this.arrayList.size() == 1) {
                    this.notifyDataSetChanged();
                }
                LiveDataCollection.addressMutableLiveData1 = new MutableLiveData<>();
            }
        }
    }

    
    
    public  void m4402b(android.content.DialogInterface dialogInterface) {
        this.f7083k = false;
        if (this.f7079g.f9077V.equals("update")) {
            LiveDataCollection.addressMutableLiveData1.observe(this.f7081i, new Observer() { // from class: b.f.a.b.a.g
                @Override // p000a.p060o.InterfaceC0405p
                
                public final void onChanged(Object obj) {
                    AddressAdapter.this.m4399a((Address) obj);
                }
            });
        }
    }

    
    public  void m4403b(Address address, View view) {
        if (this.f7083k) {
            return;
        }
        final int i = address.id;
        this.f7083k = true;
        if (i == LiveDataCollection.anInt) {
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.arrayList.size(); i3++) {
            if (((Address) this.arrayList.get(i3)).id == i) {
                i2 = i3;
            }
        }
        final DialogError dialogError = new DialogError(this.f7081i);
        dialogError.f8246v = this.f7081i.getResources().getString(R.string.delect_address);
        dialogError.m4584a(this.f7081i.getResources().getString(R.string.cancel), this.f7081i.getResources().getString(R.string.ok));
        dialogError.show();
        int finalI = i2;
        dialogError.m4585a(new DialogInterface() { // from class: b.f.a.b.a.l
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
            
            public final void cancel() {
                dialogError.dismiss();
            }
        }, new DialogInterface() { // from class: b.f.a.b.a.f
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
            
            public final void cancel() {
                AddressAdapter.this.m4395a(i, finalI, dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.a.k
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                AddressAdapter.this.m4397a(dialogInterface);
            }
        });
    }

    
    public  void m4404c(Address address, View view) {
        Intent intent = new Intent();
        intent.putExtra("address", new Gson().toJson(address));
        this.f7081i.setResult(-1, intent);
        this.f7081i.finish();
    }

    
    public  void m4396a(int i, DialogError dialogError, DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            if (this.arrayList.size() == 0) {
                this.notifyDataSetChanged();
            } else {
                int i2 = i + 1;
                notifyItemChanged(this.f7081i.xRecyclerView.arrayList.size() + i2);
                if (this.f7081i.xRecyclerView.arrayList.size() + i2 < getItemCount()) {
                    this.notifyItemMoved(this.f7081i.xRecyclerView.arrayList.size() + i2, getItemCount() - 1);
                }
            }
            dialogError.m4595e();
        }
        dialogC2001j.dismiss();
    }

    

    

    
    public  void m4401a(Address address, a aVar, View view) {
        final int i = address.id;
        if (i == LiveDataCollection.anInt) {
            return;
        }
        if (i == this.f7080h) {
            aVar.f7084A.setChecked(true);
            return;
        }
        final AddressActivity addressActivity = this.f7081i;
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
            jSONObject.put("isDefault", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LiveDataCollection.idLiveData.setValue(Integer.valueOf(i));
        API_PROVIDER.checkInternet(addressActivity, new InterfaceContext() { // from class: b.f.a.k.v
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context) {
                new API_PROVIDER(addressActivity, "put_address", new LiveDataCollection()).put("e6/address/" + i, jSONObject);
            }
        });
    }
}
