package com.jeil.emarket.components.pickerview;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.util.ArrayMap;
import android.view.View;
import android.view.Window;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.address.wheel.view.WheelView;
import com.jeil.emarket.model.customer.AddressData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;

import com.jeil.emarket.components.pickerview.date.p216a.C2106a;
import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2113e;
import com.jeil.emarket.components.pickerview.date.p219d.C2126k;
import com.jeil.emarket.components.pickerview.date.p219d.C2127l;
import com.jeil.emarket.components.pickerview.date.p219d.C2128m;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2124i;
import com.jeil.emarket.custom.font.FontManager;

/* renamed from: b.f.a.c.w.g */

public class PickerViewObj {

    
    public static java.lang.String f8604d = "";

    
    public static List<AddressData> f8605e = new ArrayList();

    /* renamed from: f */
    public static ArrayList<ArrayList<java.lang.String>> f8606f = new ArrayList<>();

    /* renamed from: g */
    public static ArrayList<ArrayList<ArrayList<java.lang.String>>> f8607g = new ArrayList<>();

    /* renamed from: h */
    public static Map<java.lang.String, java.lang.String> f8608h;

    
    public static Map<java.lang.String, java.lang.String> f8609i;

   
    public static Map<java.lang.String, java.lang.String> f8610j;

    
    public java.lang.String f8611a;

    
    public java.lang.String f8612b;

    
    public ViewOnClickListenerC2124i f8613c;

    /* renamed from: b.f.a.c.w.g$a */
    public static class a extends TypeToken<AddressData> {
    }

    public PickerViewObj(Context context, final InterfacePicker interfacePicker, boolean z, final boolean z2) {
        m4698a(context);
        InterfaceC2113e interfaceC2113e = new InterfaceC2113e() { // from class: b.f.a.c.w.b
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2113e
            
            public final void mo4695a(int i, int i2, int i3, View view) {
                PickerViewObj.this.m4702a(z2, interfacePicker, i, i2, i3, view);
            }
        };
        C2108a c2108a = new C2108a(1);
        c2108a.f8635L = context;
        c2108a.f8650a = interfaceC2113e;
        c2108a.f8644U = context.getResources().getColor(R.color.grey);
        c2108a.f8643T = context.getResources().getColor(R.color.dark);
        c2108a.f8641R = 15;
        c2108a.f8647X = FontManager.getFont(context, "font/cheonlima.ttf");
        c2108a.f8663m = false;
        c2108a.f8664n = true;
        c2108a.f8665o = true;
        this.f8613c = new ViewOnClickListenerC2124i(c2108a);
        if (z) {
            ((Window) Objects.requireNonNull(this.f8613c.f8701j.getWindow())).setDimAmount(0.85f);
        }
        ViewOnClickListenerC2124i viewOnClickListenerC2124i = this.f8613c;
        List list = f8605e;
        ArrayList<ArrayList<java.lang.String>> arrayList = f8606f;
        ArrayList<ArrayList<ArrayList<java.lang.String>>> arrayList2 = z2 ? null : f8607g;
        C2128m<T> c2128m = viewOnClickListenerC2124i.f8704k;
        c2128m.f8712e = list;
        c2128m.f8713f = arrayList;
        c2128m.f8714g = arrayList2;
        c2128m.f8708a.setAdapter(new C2106a(c2128m.f8712e));
        c2128m.f8708a.setCurrentItem(0);
        List<List<T>> list2 = c2128m.f8713f;
        if (list2 != 0) {
            c2128m.f8709b.setAdapter(new C2106a((List) list2.get(0)));
        }
        WheelView wheelView = c2128m.f8709b;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        List<List<List<T>>> list3 = c2128m.f8714g;
        if (list3 != 0) {
            c2128m.f8710c.setAdapter(new C2106a((List) ((List) list3.get(0)).get(0)));
        }
        WheelView wheelView2 = c2128m.f8710c;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        if (c2128m.f8713f == null) {
            c2128m.f8709b.setVisibility(View.GONE);
        } else {
            c2128m.f8709b.setVisibility(View.VISIBLE);
        }
        if (c2128m.f8714g == null) {
            c2128m.f8710c.setVisibility(View.GONE);
        } else {
            c2128m.f8710c.setVisibility(View.VISIBLE);
        }
        C2126k c2126k = new C2126k(c2128m);
        c2128m.f8716i = new C2127l(c2128m);
        if (list != null && c2128m.f8715h) {
            c2128m.f8708a.setOnItemSelectedListener(c2126k);
        }
        if (arrayList != null && c2128m.f8715h) {
            c2128m.f8709b.setOnItemSelectedListener(c2128m.f8716i);
        }
        if (arrayList2 != null) {
            boolean z3 = c2128m.f8715h;
        }
        C2128m<T> c2128m2 = viewOnClickListenerC2124i.f8704k;
        if (c2128m2 != 0) {
            C2108a c2108a2 = viewOnClickListenerC2124i.f8694c;
            c2128m2.m4732a(c2108a2.f8660j, c2108a2.f8661k, c2108a2.f8662l);
        }
    }

    
    public static java.lang.String m4697a(java.lang.String str, Context context) {
        java.lang.String str2 = "";
        if (f8605e == null) {
            if (context == null) {
                return "";
            }
            m4698a(context);
        }
        java.lang.String[] split = str.split(" ");
        if (split.length == 0) {
            return "";
        }
        for (int i = 0; i < f8605e.size(); i++) {
            if (f8605e.get(i).label.equals(split[0])) {
                if (f8605e.get(i).cities == null || f8605e.get(i).cities.size() == 0) {
                    return f8605e.get(i).name;
                }
                java.lang.String str3 = str2;
                for (int i2 = 0; i2 < f8605e.get(i).cities.size(); i2++) {
                    if (f8605e.get(i).cities.get(i2).label.equals(split[1])) {
                        if (f8605e.get(i).cities.get(i2).dongs == null || f8605e.get(i).cities.get(i2).dongs.size() == 0 || split.length <= 2) {
                            str3 = f8605e.get(i).cities.get(i2).name;
                            break;
                        }
                        int i3 = 0;
                        while (true) {
                            if (i3 >= f8605e.get(i).cities.size()) {
                                break;
                            }
                            if (f8605e.get(i).cities.get(i2).dongs.get(i3).label.equals(split[2])) {
                                str3 = f8605e.get(i).cities.get(i2).dongs.get(i3).name;
                                break;
                            }
                            i3++;
                        }
                    }
                }
                str2 = str3;
            }
        }
        return str2;
    }

    
    public static void m4698a(Context context) {
        if (f8604d.isEmpty()) {
            f8604d = "failed";
            f8608h = new ArrayMap();
            f8609i = new ArrayMap();
            f8610j = new ArrayMap();
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.address), StandardCharsets.UTF_8));
                while (true) {
                    java.lang.String readLine = bufferedReader.readLine();
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
                        AddressData addressData = (AddressData) gson.fromJson(jSONArray.optJSONObject(i).toString(), new a().getType());
                        arrayList.add(addressData);
                        f8608h.put(addressData.name, addressData.label);
                    }
                    f8605e = arrayList;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ArrayList<java.lang.String> arrayList2 = new ArrayList<>();
                        ArrayList<ArrayList<java.lang.String>> arrayList3 = new ArrayList<>();
                        if (((AddressData) arrayList.get(i2)).cities != null) {
                            for (int i3 = 0; i3 < ((AddressData) arrayList.get(i2)).cities.size(); i3++) {
                                arrayList2.add(((AddressData) arrayList.get(i2)).cities.get(i3).label);
                                f8609i.put(((AddressData) arrayList.get(i2)).cities.get(i3).name, ((AddressData) arrayList.get(i2)).cities.get(i3).label);
                                ArrayList<java.lang.String> arrayList4 = new ArrayList<>();
                                List<AddressData.City.Dong> list = ((AddressData) arrayList.get(i2)).cities.get(i3).dongs;
                                if (list != null) {
                                    for (int i4 = 0; i4 < list.size(); i4++) {
                                        arrayList4.add(list.get(i4).label);
                                        f8610j.put(list.get(i4).name, list.get(i4).label);
                                    }
                                } else {
                                    arrayList4.add("미정");
                                    f8610j.put(((AddressData) arrayList.get(i2)).cities.get(i3).name + "00", "미정");
                                }
                                arrayList3.add(arrayList4);
                            }
                        }
                        f8606f.add(arrayList2);
                        f8607g.add(arrayList3);
                    }
                    f8604d = "loaded";
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    
    public static java.lang.String m4699b(java.lang.String str, Context context) {
        if (f8608h == null || f8609i == null || f8610j == null) {
            if (context == null) {
                return "";
            }
            m4698a(context);
        }
        if (str == null) {
            return "";
        }
        java.lang.String str2 = str.isEmpty() ? "" : f8608h.get(str.substring(0, 2));
        if (str.length() >= 4 && f8609i.get(str.substring(0, 4)) != null) {
            StringBuilder m3177b = CustomString.m3177b(str2, " ");
            m3177b.append(f8609i.get(str.substring(0, 4)));
            str2 = m3177b.toString();
        }
        if (f8610j.get(str) == null) {
            return str2;
        }
        StringBuilder m3177b2 = CustomString.m3177b(str2, " ");
        m3177b2.append(f8610j.get(str));
        return m3177b2.toString();
    }

    
    public  void m4700a() {
        Dialog dialog = this.f8613c.f8701j;
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().bringToFront();
    }

    
    public void m4701a(java.lang.String str) {
        if (str.length() == 6 || str.length() == 4) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= f8605e.size()) {
                    i2 = 0;
                    break;
                } else if (f8605e.get(i2).name.equals(str.substring(0, 2))) {
                    break;
                } else {
                    i2++;
                }
            }
            if (f8606f.size() <= i2) {
                return;
            }
            java.lang.String str2 = f8609i.get(str.substring(0, 4));
            int i3 = 0;
            while (true) {
                if (i3 >= f8606f.get(i2).size()) {
                    i3 = 0;
                    break;
                } else if (f8606f.get(i2).get(i3).equals(str2)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (str.length() == 6) {
                if (f8607g.size() <= i2 || f8607g.get(i2).size() <= i3) {
                    return;
                }
                java.lang.String str3 = f8610j.get(str);
                int i4 = 0;
                while (true) {
                    if (i4 >= f8607g.get(i2).get(i3).size()) {
                        break;
                    }
                    if (f8607g.get(i2).get(i3).get(i4).equals(str3)) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
            }
            this.f8613c.f8704k.m4732a(i2, i3, i);
        }
    }

    
    public  void m4702a(boolean z, InterfacePicker interfacePicker, int i, int i2, int i3, View view) {
        StringBuilder sb;
        java.lang.String pickerViewText = f8605e.size() > 0 ? f8605e.get(i).getPickerViewText() : "";
        java.lang.String str = (f8606f.size() <= 0 || f8606f.get(i).size() <= 0) ? "" : f8606f.get(i).get(i2);
        java.lang.String str2 = (z || f8606f.size() <= 0 || f8607g.get(i).size() <= 0 || f8607g.get(i).get(i2).size() <= 0) ? "" : f8607g.get(i).get(i2).get(i3);
        if (z) {
            this.f8612b = f8605e.size() > 0 ? f8605e.get(i).cities.get(i2).name : "";
        } else {
            this.f8611a = f8605e.size() > 0 ? f8605e.get(i).cities.get(i2).dongs != null ? f8605e.get(i).cities.get(i2).dongs.get(i3).name : f8605e.get(i).cities.get(i2).name : "";
        }
        java.lang.String str3 = z ? this.f8612b : this.f8611a;
        if (z) {
            sb = CustomString.m3178b(pickerViewText, " ", str);
        } else {
            sb = new StringBuilder();
            sb.append(pickerViewText);
            sb.append(" ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
        }
        interfacePicker.mo4547a(str3, sb.toString());
    }

    
    public void m4703b() {
        this.f8613c.m4724d();
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.c.w.a
            @Override // java.lang.Runnable
            public final void run() {
                PickerViewObj.this.m4700a();
            }
        }, 3000L);
    }
}
