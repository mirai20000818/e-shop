package com.jeil.emarket.components.pickerview.date.p219d;

import android.annotation.SuppressLint;
import android.view.View;

import com.jeil.emarket.components.address.wheel.view.WheelView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.jeil.emarket.components.pickerview.date.p216a.C2107b;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2110b;
import com.jeil.emarket.components.pickerview.p220l.p223c.InterfaceC2134b;

/* renamed from: b.f.a.c.w.k.d.o */

public class C2130o {

    /* renamed from: x */
    @SuppressLint({"SimpleDateFormat"})
    public static DateFormat f8721x = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public int f8722a;


    public View f8723b;


    public WheelView f8724c;


    public WheelView f8725d;


    public WheelView f8726e;

    /* renamed from: f */
    public WheelView f8727f;

    /* renamed from: g */
    public WheelView f8728g;

    /* renamed from: h */
    public WheelView f8729h;

    
    public int f8730i;

   
    public boolean[] f8731j;

    
    public int f8732k;

    /* renamed from: l */
    public int f8733l;

    /* renamed from: m */
    public int f8734m;

    /* renamed from: n */
    public int f8735n;

    /* renamed from: o */
    public int f8736o;

    /* renamed from: p */
    public int f8737p;

    /* renamed from: q */
    public int f8738q;

    /* renamed from: r */
    public int f8739r;

    /* renamed from: s */
    public int f8740s;

    /* renamed from: t */
    public int f8741t;

    /* renamed from: u */
    public int f8742u;

    /* renamed from: v */
    public int f8743v;

    /* renamed from: w */
    public InterfaceC2110b f8744w;

    /* renamed from: b.f.a.c.w.k.d.o$a */
    public class a implements InterfaceC2134b {
        public a() {
        }

        @Override // p078b.p159f.p160a.p190c.p214w.p220l.p223c.InterfaceC2134b

        public void mo4719a(int i) {
            C2130o.this.f8744w.mo4717a();
        }
    }

    public C2130o(View view, boolean[] zArr, int i, int i2) {
        this.f8722a = -1;
        this.f8732k = 1900;
        this.f8733l = 2100;
        this.f8734m = 1;
        this.f8735n = 12;
        this.f8736o = 1;
        this.f8737p = 31;
        this.f8738q = 0;
        this.f8739r = 23;
        this.f8740s = 0;
        this.f8741t = 59;
        this.f8723b = view;
        this.f8731j = zArr;
        this.f8730i = i;
        this.f8743v = i2;
    }

    public C2130o(View view, boolean[] zArr, int i, int i2, int i3) {
        this.f8722a = -1;
        this.f8732k = 1900;
        this.f8733l = 2100;
        this.f8734m = 1;
        this.f8735n = 12;
        this.f8736o = 1;
        this.f8737p = 31;
        this.f8738q = 0;
        this.f8739r = 23;
        this.f8740s = 0;
        this.f8741t = 59;
        this.f8723b = view;
        this.f8731j = zArr;
        this.f8730i = i;
        this.f8743v = i2;
        this.f8722a = i3;
    }


    public String m4734a() {
        int currentItem;
        int currentItem2;
        StringBuilder sb = new StringBuilder();
        if (this.f8742u == this.f8732k) {
            int currentItem3 = this.f8725d.getCurrentItem();
            int i = this.f8734m;
            if (currentItem3 + i == i) {
                sb.append(this.f8724c.getCurrentItem() + this.f8732k);
                sb.append("-");
                sb.append(this.f8725d.getCurrentItem() + this.f8734m);
                sb.append("-");
                sb.append(this.f8726e.getCurrentItem() + this.f8736o);
                sb.append(" ");
                int i2 = 0;
                sb.append(this.f8727f.getCurrentItem() + (this.f8726e.getCurrentItem() == 0 ? this.f8738q : 0));
                sb.append(":");
                int currentItem4 = this.f8728g.getCurrentItem();
                if (this.f8726e.getCurrentItem() == 0 && this.f8727f.getCurrentItem() == 0) {
                    i2 = this.f8740s;
                }
                currentItem2 = currentItem4 + i2;
                sb.append(currentItem2);
                sb.append(":");
                sb.append(this.f8729h.getCurrentItem());
                return sb.toString();
            }
            sb.append(this.f8724c.getCurrentItem() + this.f8732k);
            sb.append("-");
            currentItem = this.f8725d.getCurrentItem() + this.f8734m;
        } else {
            sb.append(this.f8724c.getCurrentItem() + this.f8732k);
            sb.append("-");
            currentItem = this.f8725d.getCurrentItem() + 1;
        }
        sb.append(currentItem);
        sb.append("-");
        sb.append(this.f8726e.getCurrentItem() + 1);
        sb.append(" ");
        sb.append(this.f8727f.getCurrentItem());
        sb.append(":");
        currentItem2 = this.f8728g.getCurrentItem();
        sb.append(currentItem2);
        sb.append(":");
        sb.append(this.f8729h.getCurrentItem());
        return sb.toString();
    }


    public void m4735a(float f) {
        this.f8726e.setLineSpacingMultiplier(f);
        this.f8725d.setLineSpacingMultiplier(f);
        this.f8724c.setLineSpacingMultiplier(f);
        this.f8727f.setLineSpacingMultiplier(f);
        this.f8728g.setLineSpacingMultiplier(f);
        this.f8729h.setLineSpacingMultiplier(f);
    }


    public  void m4736a(int i) {
        int currentItem = this.f8726e.getCurrentItem();
        this.f8727f.setAdapter(new C2107b(0, 23));
        this.f8728g.setAdapter(new C2107b(0, 59));
        int i2 = currentItem + this.f8736o;
        int currentItem2 = this.f8725d.getCurrentItem();
        int i3 = this.f8734m;
        int i4 = currentItem2 + i3;
        if (this.f8742u == this.f8732k && i4 == i3 && i2 == this.f8736o) {
            this.f8727f.setAdapter(new C2107b(this.f8738q, this.f8739r));
            if (this.f8727f.getCurrentItem() == 0) {
                this.f8728g.setAdapter(new C2107b(this.f8740s, this.f8741t));
            }
            int currentItem3 = this.f8727f.getCurrentItem();
            int i5 = this.f8739r;
            int i6 = this.f8738q;
            if (currentItem3 > i5 - i6) {
                this.f8727f.setCurrentItem(i5 - i6);
            }
        }
        this.f8727f.setCurrentItem(this.f8727f.getCurrentItem());
        InterfaceC2110b interfaceC2110b = this.f8744w;
        if (interfaceC2110b != null) {
            interfaceC2110b.mo4717a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c4  */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4737a(int r17, int r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 1139
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p190c.p214w.p215k.p219d.C2130o.m4737a(int, int, int, int, int, int):void");
    }


    public final void m4738a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        WheelView wheelView;
        C2107b c2107b;
        int currentItem = this.f8726e.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            int i5 = i4 <= 31 ? i4 : 31;
            wheelView = this.f8726e;
            c2107b = new C2107b(i3, i5);
        } else if (list2.contains(String.valueOf(i2))) {
            int i6 = i4 <= 30 ? i4 : 30;
            wheelView = this.f8726e;
            c2107b = new C2107b(i3, i6);
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            int i7 = i4 <= 28 ? i4 : 28;
            wheelView = this.f8726e;
            c2107b = new C2107b(i3, i7);
        } else {
            int i8 = i4 <= 29 ? i4 : 29;
            wheelView = this.f8726e;
            c2107b = new C2107b(i3, i8);
        }
        wheelView.setAdapter(c2107b);
        if (currentItem > this.f8726e.getAdapter().mo4715a() - 1) {
            this.f8726e.setCurrentItem(this.f8726e.getAdapter().mo4715a() - 1);
        }
    }


    public void m4739a(WheelView.EnumC3242c enumC3242c) {
        this.f8726e.setDividerType(enumC3242c);
        this.f8725d.setDividerType(enumC3242c);
        this.f8724c.setDividerType(enumC3242c);
        this.f8727f.setDividerType(enumC3242c);
        this.f8728g.setDividerType(enumC3242c);
        this.f8729h.setDividerType(enumC3242c);
    }


    public final void m4740a(WheelView wheelView) {
        if (this.f8744w != null) {
            wheelView.setOnItemSelectedListener(new a());
        }
    }


    public void m4741a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str != null) {
            this.f8724c.setLabel(str);
        } else {
            this.f8724c.setLabel(this.f8723b.getContext().getString(R.string.pickerview_year));
        }
        WheelView wheelView = this.f8725d;
        if (str2 == null) {
            str2 = this.f8723b.getContext().getString(R.string.pickerview_month);
        }
        wheelView.setLabel(str2);
        WheelView wheelView2 = this.f8726e;
        if (str3 != null) {
            wheelView2.setLabel(str3);
        } else {
            wheelView2.setLabel(this.f8723b.getContext().getString(R.string.pickerview_day));
        }
        WheelView wheelView3 = this.f8727f;
        if (str4 != null) {
            wheelView3.setLabel(str4);
        } else {
            wheelView3.setLabel(this.f8723b.getContext().getString(R.string.pickerview_hours));
        }
        WheelView wheelView4 = this.f8728g;
        if (str5 != null) {
            wheelView4.setLabel(str5);
        } else {
            wheelView4.setLabel(this.f8723b.getContext().getString(R.string.pickerview_minutes));
        }
        WheelView wheelView5 = this.f8729h;
        if (str6 != null) {
            wheelView5.setLabel(str6);
        } else {
            wheelView5.setLabel(this.f8723b.getContext().getString(R.string.pickerview_seconds));
        }
    }


    public void m4742a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = calendar2.get(11);
            int i5 = calendar2.get(12);
            int i6 = this.f8732k;
            if (i <= i6) {
                if (i != i6) {
                    return;
                }
                int i7 = this.f8734m;
                if (i2 <= i7 && (i2 != i7 || i3 <= this.f8736o)) {
                    return;
                }
            }
            this.f8733l = i;
            this.f8735n = i2;
            this.f8737p = i3;
            this.f8739r = i4;
            this.f8741t = i5;
            return;
        }
        if (calendar == null || calendar2 != null) {
            if (calendar != null) {
                this.f8732k = calendar.get(1);
                this.f8733l = calendar2.get(1);
                this.f8734m = calendar.get(2) + 1;
                this.f8735n = calendar2.get(2) + 1;
                this.f8736o = calendar.get(5);
                this.f8737p = calendar2.get(5);
                this.f8738q = calendar.get(11);
                this.f8739r = calendar2.get(11);
                this.f8740s = calendar.get(11);
                this.f8741t = calendar2.get(11);
                return;
            }
            return;
        }
        int i8 = calendar.get(1);
        int i9 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        int i11 = calendar.get(11);
        int i12 = calendar.get(12);
        int i13 = this.f8733l;
        if (i8 >= i13) {
            if (i8 != i13) {
                return;
            }
            int i14 = this.f8735n;
            if (i9 >= i14 && (i9 != i14 || i10 >= this.f8737p)) {
                return;
            }
        }
        this.f8734m = i9;
        this.f8736o = i10;
        this.f8732k = i8;
        this.f8738q = i11;
        this.f8740s = i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m4743a(java.util.List r11, java.util.List r12, int r13) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p190c.p214w.p215k.p219d.C2130o.m4743a(java.util.List, java.util.List, int):void");
    }


    public void m4744a(boolean z) {
        this.f8726e.setAlphaGradient(z);
        this.f8725d.setAlphaGradient(z);
        this.f8724c.setAlphaGradient(z);
        this.f8727f.setAlphaGradient(z);
        this.f8728g.setAlphaGradient(z);
        this.f8729h.setAlphaGradient(z);
    }


    public  void m4745b(int i) {
        int currentItem = this.f8727f.getCurrentItem();
        this.f8728g.setAdapter(new C2107b(0, 59));
        int i2 = currentItem + this.f8736o;
        int currentItem2 = this.f8725d.getCurrentItem() + this.f8734m;
        int currentItem3 = this.f8725d.getCurrentItem();
        int i3 = this.f8738q;
        int i4 = currentItem3 + i3;
        if (this.f8742u == this.f8732k && currentItem2 == this.f8734m && i2 == this.f8736o && i4 == i3) {
            this.f8728g.setAdapter(new C2107b(this.f8740s, this.f8741t));
        }
        InterfaceC2110b interfaceC2110b = this.f8744w;
        if (interfaceC2110b != null) {
            interfaceC2110b.mo4717a();
        }
    }


    public void m4746b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f8724c.setTextXOffset(i);
        this.f8725d.setTextXOffset(i2);
        this.f8726e.setTextXOffset(i3);
        this.f8727f.setTextXOffset(i4);
        this.f8728g.setTextXOffset(i5);
        this.f8729h.setTextXOffset(i6);
    }


    public void m4747b(boolean z) {
        this.f8724c.setCyclic(z);
        this.f8725d.setCyclic(z);
        this.f8726e.setCyclic(z);
        this.f8727f.setCyclic(z);
        this.f8728g.setCyclic(z);
        this.f8729h.setCyclic(z);
    }


    public void m4748c(int i) {
        this.f8726e.setDividerColor(i);
        this.f8725d.setDividerColor(i);
        this.f8724c.setDividerColor(i);
        this.f8727f.setDividerColor(i);
        this.f8728g.setDividerColor(i);
        this.f8729h.setDividerColor(i);
    }


    public void m4749d(int i) {
        this.f8726e.setItemsVisibleCount(i);
        this.f8725d.setItemsVisibleCount(i);
        this.f8724c.setItemsVisibleCount(i);
        this.f8727f.setItemsVisibleCount(i);
        this.f8728g.setItemsVisibleCount(i);
        this.f8729h.setItemsVisibleCount(i);
    }


    public void m4750e(int i) {
        this.f8732k = i;
    }

    /* renamed from: f */
    public void m4751f(int i) {
        this.f8726e.setTextColorCenter(i);
        this.f8725d.setTextColorCenter(i);
        this.f8724c.setTextColorCenter(i);
        this.f8727f.setTextColorCenter(i);
        this.f8728g.setTextColorCenter(i);
        this.f8729h.setTextColorCenter(i);
    }

    /* renamed from: g */
    public void m4752g(int i) {
        this.f8726e.setTextColorOut(i);
        this.f8725d.setTextColorOut(i);
        this.f8724c.setTextColorOut(i);
        this.f8727f.setTextColorOut(i);
        this.f8728g.setTextColorOut(i);
        this.f8729h.setTextColorOut(i);
    }
}
