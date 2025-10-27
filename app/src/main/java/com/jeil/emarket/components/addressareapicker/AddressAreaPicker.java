package com.jeil.emarket.components.addressareapicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.AddressData;
import com.jeil.emarket.model.vendor.Address;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

import com.jeil.emarket.widget.picker.LinearLayoutCompat1;
import com.jeil.emarket.widget.picker.PickerviewObj;
import com.jeil.emarket.widget.picker.PickerviewAdapter;
import com.jeil.emarket.widget.picker.Pickerview2;


public class AddressAreaPicker<T> extends LinearLayoutCompat {

    /* renamed from: q */
    public PickerviewObj f12143q;

    /* renamed from: r */
    public Pickerview2<?> f12144r;

    /* renamed from: s */
    public PickerviewAdapter f12145s;

    /* renamed from: t */
    public PickerviewAdapter f12146t;

    /* renamed from: u */
    public PickerviewAdapter.a f12147u;

    /* renamed from: v */
    public View f12148v;

    /* renamed from: com.jeil.emarket.components.addressareapicker.AddressAreaPicker$a */
    public class C3243a extends TypeToken<AddressData> {
        public C3243a(AddressAreaPicker addressAreaPicker) {
        }
    }

    public AddressAreaPicker(Context context) {
        super(context);
        m6867a((List<String>) null);
        m6865a(context);
    }

    public AddressAreaPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6867a((List<String>) null);
        m6865a(context);
    }

    private void setNodeStatus(Pickerview2<?> pickerview2) {
        for (int i = 0; i < pickerview2.f8792f.size(); i++) {
            pickerview2.m4761a(i).f8790d = pickerview2.f8790d;
            if (pickerview2.m4761a(i).m4763b()) {
                for (int i2 = 0; i2 < pickerview2.m4761a(i).m4760a(); i2++) {
                    pickerview2.m4761a(i).m4761a(i2).f8790d = pickerview2.f8790d;
                }
            }
        }
    }


    public final void m6863a(int i, ListView listView) {
        listView.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, Util.dp2px(this.f12148v.getContext(), 36) * i));
    }


    public final void m6865a(Context context) {
        this.f12143q = new PickerviewObj();
        this.f12148v = LayoutInflater.from(context).inflate(R.layout.pickerview_address_area, (ViewGroup) this, false);
        m6875j();
        addView(this.f12148v);
    }


    public final void m6866a(ListView listView, int i) {
        if (listView == null || listView.getChildCount() <= 0 || listView.getChildAt(i) == null) {
            return;
        }
        for (int i2 = 0; i2 < listView.getChildCount(); i2++) {
            ((LinearLayoutCompat1) listView.getChildAt(i2)).m4756i();
        }
        ((LinearLayoutCompat1) listView.getChildAt(i)).m4755h();
    }


    public void m6867a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.address), StandardCharsets.UTF_8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else {
                    sb.append(readLine);
                }
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(sb.toString());
                Gson gson = new Gson();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add((AddressData) gson.fromJson(jSONArray.optJSONObject(i).toString(), new C3243a(this).getType()));
                }
                ArrayList arrayList2 = new ArrayList();
                boolean z = list != null && list.size() > 0;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ArrayList arrayList3 = new ArrayList();
                    if (((AddressData) arrayList.get(i2)).cities != null) {
                        for (int i3 = 0; i3 < ((AddressData) arrayList.get(i2)).cities.size(); i3++) {
                            ArrayList arrayList4 = new ArrayList();
                            List<AddressData.City.Dong> list2 = ((AddressData) arrayList.get(i2)).cities.get(i3).dongs;
                            if (list2 != null) {
                                for (int i4 = 0; i4 < list2.size(); i4++) {
                                    boolean z2 = list != null && list.contains(list2.get(i4).name);
                                    boolean z3 = list != null && list.contains(((AddressData) arrayList.get(i2)).cities.get(i3).name);
                                    boolean z4 = list != null && list.contains(((AddressData) arrayList.get(i2)).name);
                                    if (!z || z2 || z3 || z4) {
                                        arrayList4.add(new Pickerview2(new Address(list2.get(i4).name, list2.get(i4).label, 0)));
                                    }
                                }
                            }
                            if (arrayList4.size() > 0) {
                                Pickerview2 pickerview2 = new Pickerview2(new Address(((AddressData) arrayList.get(i2)).cities.get(i3).name, ((AddressData) arrayList.get(i2)).cities.get(i3).label, 0));
                                pickerview2.m4762a(arrayList4);
                                arrayList3.add(pickerview2);
                            }
                        }
                    }
                    if (arrayList3.size() > 0) {
                        Pickerview2 pickerview22 = new Pickerview2(new Address(((AddressData) arrayList.get(i2)).name, ((AddressData) arrayList.get(i2)).label, 0));
                        pickerview22.m4762a(arrayList3);
                        arrayList2.add(pickerview22);
                    }
                }
                Pickerview2<?> pickerview23 = new Pickerview2<>(new Address("", "", 0));
                pickerview23.m4762a(arrayList2);
                this.f12144r = pickerview23;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    
    public  void m6868b(int i, Pickerview2 pickerview2) {
        m6866a(PickerviewObj.f8777f, i);
        PickerviewObj pickerviewObj = this.f12143q;
        pickerviewObj.f8782d = pickerview2;
        pickerviewObj.f8780b = (LinearLayoutCompat1) PickerviewObj.f8777f.getChildAt(i);
        if (!pickerview2.m4763b() || pickerview2.m4760a() <= 0) {
            this.f12146t.m4758a(new ArrayList());
        } else {
            this.f12146t.m4758a(pickerview2.f8792f);
            m6863a(this.f12146t.getCount(), PickerviewObj.f8778g);
        }
    }

    
    public  void m6869c(int i, Pickerview2 pickerview2) {
        m6866a(PickerviewObj.f8778g, i);
        pickerview2.f8790d = pickerview2.f8790d == 0 ? 1 : 0;
        if (PickerviewObj.f8778g.getChildAt(i) != null) {
            ((LinearLayoutCompat1) PickerviewObj.f8778g.getChildAt(i)).setState(pickerview2.f8790d);
            ((LinearLayoutCompat1) PickerviewObj.f8778g.getChildAt(i)).m4755h();
        }
        m6873h();
        m6874i();
    }

    
    public  void m6870d(int i, Pickerview2 pickerview2) {
        PickerviewAdapter pickerviewAdapter;
        ArrayList arrayList;
        int i2 = pickerview2.f8790d;
        if (i2 == 0 || i2 == 2) {
            pickerview2.f8790d = 1;
        } else {
            pickerview2.f8790d = 0;
        }
        if (PickerviewObj.f8776e.getChildAt(i) != null) {
            ((LinearLayoutCompat1) PickerviewObj.f8776e.getChildAt(i)).setState(pickerview2.f8790d);
            m6866a(PickerviewObj.f8776e, i);
            m6866a(PickerviewObj.f8777f, 0);
            PickerviewObj pickerviewObj = this.f12143q;
            pickerviewObj.f8781c = pickerview2;
            pickerviewObj.f8779a = (LinearLayoutCompat1) PickerviewObj.f8776e.getChildAt(i);
            setNodeStatus(pickerview2);
            this.f12145s.m4758a(pickerview2.f8792f);
            /*if (c2149l.f8792f.get(0).f8792f == null || c2149l.f8792f.get(0).f8792f.size() <= 0) {
                c2148k = this.f12146t;
                arrayList = new ArrayList();
            } else {
                c2148k = this.f12146t;
                arrayList = c2149l.f8792f.get(0).f8792f;
            }*/
            //c2148k.m4758a(arrayList);
            m6863a(this.f12145s.getCount(), PickerviewObj.f8777f);
            m6863a(this.f12146t.getCount(), PickerviewObj.f8778g);
        }
    }

    
    public  void m6871e(int i, Pickerview2 pickerview2) {
        LinearLayoutCompat1 linearLayoutCompat1;
        int i2;
        int i3 = pickerview2.f8790d;
        if (i3 == 0 || i3 == 2) {
            linearLayoutCompat1 = (LinearLayoutCompat1) PickerviewObj.f8777f.getChildAt(i);
            i2 = 1;
        } else {
            linearLayoutCompat1 = (LinearLayoutCompat1) PickerviewObj.f8777f.getChildAt(i);
            i2 = 0;
        }
        linearLayoutCompat1.setState(i2);
        pickerview2.f8790d = i2;
        m6866a(PickerviewObj.f8777f, i);
        this.f12143q.f8780b = (LinearLayoutCompat1) PickerviewObj.f8777f.getChildAt(i);
        this.f12143q.f8782d = pickerview2;
        m6874i();
        setNodeStatus(pickerview2);
        List<Pickerview2<T>> list = pickerview2.f8792f;
        if (list == null || list.size() <= 0) {
            this.f12146t.m4758a(new ArrayList());
        } else {
            this.f12146t.m4758a(pickerview2.f8792f);
            m6863a(this.f12146t.getCount(), PickerviewObj.f8778g);
        }
    }

    /* renamed from: f */
    public  void m6872f(int i, Pickerview2 pickerview2) {
        this.f12147u.mo4753a(i, pickerview2);
    }

    public List<String> getSelectedAddress() {
        ArrayList arrayList = new ArrayList();
        Pickerview2<?> pickerview2 = this.f12144r;
        if (pickerview2 != null && pickerview2.m4763b()) {
            for (int i = 0; i < this.f12144r.m4760a(); i++) {
                if (this.f12144r.m4761a(i).f8790d == 1) {
                    arrayList.add(((Address) this.f12144r.m4761a(i).f8787a).name);
                } else if (this.f12144r.m4761a(i).f8790d == 2 && this.f12144r.m4761a(i).m4763b()) {
                    for (int i2 = 0; i2 < this.f12144r.m4761a(i).m4760a(); i2++) {
                        if (this.f12144r.m4761a(i).m4761a(i2).f8790d == 1) {
                            arrayList.add(((Address) this.f12144r.m4761a(i).m4761a(i2).f8787a).name);
                        } else if (this.f12144r.m4761a(i).m4761a(i2).f8790d == 2 && this.f12144r.m4761a(i).m4761a(i2).m4763b()) {
                            for (int i3 = 0; i3 < this.f12144r.m4761a(i).m4761a(i2).m4760a(); i3++) {
                                Pickerview2<?> m4761a = this.f12144r.m4761a(i).m4761a(i2).m4761a(i3);
                                if (m4761a.f8790d == 1) {
                                    arrayList.add(((Address) m4761a.f8787a).name);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    public void m6873h() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= PickerviewObj.f8778g.getChildCount()) {
                break;
            }
            if (((LinearLayoutCompat1) PickerviewObj.f8778g.getChildAt(i)).getState() != 1) {
                i2 = 0;
            }
            sb.append(i2);
            i++;
        }
        if (!sb.toString().contains("0")) {
            PickerviewObj pickerviewObj = this.f12143q;
            pickerviewObj.f8782d.f8790d = 1;
            pickerviewObj.f8780b.setState(1);
        } else if (sb.toString().contains("1")) {
            PickerviewObj pickerviewObj2 = this.f12143q;
            pickerviewObj2.f8782d.f8790d = 2;
            pickerviewObj2.f8780b.setState(2);
        } else {
            PickerviewObj pickerviewObj3 = this.f12143q;
            pickerviewObj3.f8782d.f8790d = 0;
            pickerviewObj3.f8780b.setState(0);
        }
        this.f12143q.f8780b.m4755h();
    }

    
    public final void m6874i() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= PickerviewObj.f8777f.getChildCount()) {
                break;
            }
            if (((LinearLayoutCompat1) PickerviewObj.f8777f.getChildAt(i)).getState() != 2) {
                z = false;
            }
            sb.append(z);
            i++;
        }
        if (!sb.toString().contains("2")) {
            if (!sb.toString().contains("0") && sb.length() == PickerviewObj.f8777f.getChildCount()) {
                this.f12143q.f8779a.setState(1);
                this.f12143q.f8781c.f8790d = 1;
            } else if (!sb.toString().contains("1")) {
                this.f12143q.f8779a.setState(0);
                this.f12143q.f8781c.f8790d = 0;
            }
            this.f12143q.f8779a.m4755h();
        }
        this.f12143q.f8779a.setState(2);
        this.f12143q.f8781c.f8790d = 2;
        this.f12143q.f8779a.m4755h();
    }

   
    public final void m6875j() {
        PickerviewObj.f8776e = (ListView) this.f12148v.findViewById(R.id.lv_province);
        PickerviewObj.f8776e.setDividerHeight(0);
        PickerviewAdapter pickerviewAdapter = new PickerviewAdapter(getContext(), this.f12144r.f8792f, this.f12143q, true);
        PickerviewObj.f8776e.setAdapter((ListAdapter) pickerviewAdapter);
        m6863a(pickerviewAdapter.getCount(), PickerviewObj.f8776e);
        PickerviewObj.f8777f = (ListView) this.f12148v.findViewById(R.id.lv_city);
        PickerviewObj.f8777f.setDividerHeight(0);
        this.f12145s = new PickerviewAdapter(getContext(), this.f12144r.f8792f.get(0).f8792f, this.f12143q, true);
        PickerviewObj.f8777f.setAdapter((ListAdapter) this.f12145s);
        m6863a(this.f12145s.getCount(), PickerviewObj.f8777f);
        PickerviewObj.f8778g = (ListView) this.f12148v.findViewById(R.id.lv_dong);
        PickerviewObj.f8778g.setDividerHeight(0);
        this.f12146t = new PickerviewAdapter(getContext(), this.f12144r.f8792f.get(0).f8792f.get(0).f8792f, this.f12143q);
        PickerviewObj.f8778g.setAdapter((ListAdapter) this.f12146t);
        m6863a(this.f12146t.getCount(), PickerviewObj.f8778g);
        PickerviewAdapter.a aVar = new PickerviewAdapter.a() { // from class: b.f.a.c.x.d
            @Override // p078b.p159f.p160a.p190c.p225x.C2148k.a

            public final void mo4753a(int i, Pickerview2 c2149l) {
                AddressAreaPicker.this.m6864a(i, c2149l);
            }
        };
        PickerviewAdapter.a aVar2 = new PickerviewAdapter.a() { // from class: b.f.a.c.x.c
            @Override // p078b.p159f.p160a.p190c.p225x.C2148k.a

            public final void mo4753a(int i, Pickerview2 c2149l) {
                AddressAreaPicker.this.m6868b(i, c2149l);
            }
        };
        this.f12147u = new PickerviewAdapter.a() { // from class: b.f.a.c.x.a
            @Override // p078b.p159f.p160a.p190c.p225x.C2148k.a

            public final void mo4753a(int i, Pickerview2 pickerview2) {
                AddressAreaPicker.this.m6869c(i, pickerview2);
            }
        };
        pickerviewAdapter.f8784c = aVar;
        PickerviewAdapter pickerviewAdapter2 = this.f12145s;
        pickerviewAdapter2.f8784c = aVar2;
        PickerviewAdapter pickerviewAdapter3 = this.f12146t;
        pickerviewAdapter3.f8784c = this.f12147u;
        PickerviewAdapter.b bVar = new PickerviewAdapter.b() { // from class: b.f.a.c.x.b
            @Override // p078b.p159f.p160a.p190c.p225x.C2148k.b

            public final void mo4754a(int i, Pickerview2 c2149l) {
                AddressAreaPicker.this.m6870d(i, c2149l);
            }
        };
        PickerviewAdapter.b bVar2 = new PickerviewAdapter.b() { // from class: b.f.a.c.x.e
            @Override // p078b.p159f.p160a.p190c.p225x.C2148k.b

            public final void mo4754a(int i, Pickerview2 c2149l) {
                AddressAreaPicker.this.m6871e(i, c2149l);
            }
        };
        PickerviewAdapter.b bVar3 = new PickerviewAdapter.b() { // from class: b.f.a.c.x.f
            @Override // p078b.p159f.p160a.p190c.p225x.C2148k.b

            public final void mo4754a(int i, Pickerview2 c2149l) {
                AddressAreaPicker.this.m6872f(i, c2149l);
            }
        };
        pickerviewAdapter.f8785d = bVar;
        pickerviewAdapter2.f8785d = bVar2;
        pickerviewAdapter3.f8785d = bVar3;
    }

    public void setAddressData(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (this.f12144r.m4763b()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f12144r.m4760a()) {
                        break;
                    }
                    String str = ((Address) this.f12144r.m4761a(i2).f8787a).name;
                    if (str != null && str.contains(list.get(i))) {
                        this.f12144r.m4761a(i2).f8790d = 1;
                        setNodeStatus(this.f12144r.m4761a(i2));
                        break;
                    }
                    if (this.f12144r.m4761a(i2).m4763b()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.f12144r.m4761a(i2).m4760a()) {
                                break;
                            }
                            String str2 = ((Address) this.f12144r.m4761a(i2).m4761a(i3).f8787a).name;
                            if (str2 != null && str2.contains(list.get(i))) {
                                this.f12144r.m4761a(i2).m4761a(i3).f8790d = 1;
                                setNodeStatus(this.f12144r.m4761a(i2).m4761a(i3));
                                this.f12144r.m4761a(i2).f8790d = 2;
                                break;
                            }
                            if (this.f12144r.m4761a(i2).m4761a(i3).m4763b()) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= this.f12144r.m4761a(i2).m4761a(i3).m4760a()) {
                                        break;
                                    }
                                    String str3 = ((Address) this.f12144r.m4761a(i2).m4761a(i3).m4761a(i4).f8787a).name;
                                    if (str3 != null && str3.contains(list.get(i))) {
                                        this.f12144r.m4761a(i2).m4761a(i3).m4761a(i4).f8790d = 1;
                                        this.f12144r.m4761a(i2).f8790d = 2;
                                        this.f12144r.m4761a(i2).m4761a(i3).f8790d = 2;
                                        break;
                                    }
                                    i4++;
                                }
                            }
                            i3++;
                        }
                    }
                    i2++;
                }
            }
        }
        m6875j();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        View view = this.f12148v;
        if (view != null) {
            view.findViewById(R.id.ll_item).setBackgroundResource(i);
        }
    }


    public  void m6864a(int i, Pickerview2 pickerview2) {
        PickerviewAdapter pickerviewAdapter;
        ArrayList arrayList;
        m6866a(PickerviewObj.f8776e, i);
        m6866a(PickerviewObj.f8777f, 0);
        PickerviewObj pickerviewObj = this.f12143q;
        pickerviewObj.f8781c = pickerview2;
        pickerviewObj.f8779a = (LinearLayoutCompat1) PickerviewObj.f8776e.getChildAt(i);
        this.f12145s.m4758a(pickerview2.f8792f);
       /* if (c2149l.f8792f.get(0).f8792f != null && c2149l.f8792f.get(0).f8792f.size() > 0) {
            c2148k = this.f12146t;
            arrayList = c2149l.f8792f.get(0).f8792f;
        } else {
            c2148k = this.f12146t;
            arrayList = new ArrayList();
        }*/
        //c2148k.m4758a(arrayList);
        m6863a(this.f12145s.getCount(), PickerviewObj.f8777f);
        m6863a(this.f12146t.getCount(), PickerviewObj.f8778g);
    }
}
