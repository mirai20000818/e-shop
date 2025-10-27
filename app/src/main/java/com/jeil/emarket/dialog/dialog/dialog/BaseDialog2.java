package com.jeil.emarket.dialog.dialog.dialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jeil.emarket.custom.Util;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.components.textview.TextView;
import java.util.ArrayList;

import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;

/* renamed from: b.f.a.c.c0.c.h */

public class BaseDialog2 extends BaseAniDialog<BaseDialog2> {


    public ListView f8203A;

    
    public int f8204B;

    
    public int f8205C;

    
    public BaseAdapter f8206D;

    
    public ArrayList<Cancel_Obj> f8207E;

    /* renamed from: F */
    public DialogInterface2 interface2;

    /* renamed from: G */
    public int f8209G;

    /* renamed from: H */
    public String f8210H;

    
    public View f8211I;

    /* renamed from: y */
    public LinearLayoutCompat f8212y;

    /* renamed from: z */
    public int f8213z;

    /* renamed from: b.f.a.c.c0.c.h$a */
    public class a extends BaseAdapter {
        public a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return BaseDialog2.this.f8207E.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2;
            int i3;
            Cancel_Obj cancelObj = BaseDialog2.this.f8207E.get(i);
            LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(BaseDialog2.this.f8251b);
            linearLayoutCompat.setOrientation(LinearLayoutCompat.HORIZONTAL);
            int i4 = BaseDialog2.this.f8274x;
            if (i4 == 80) {
                linearLayoutCompat.setGravity(17);
            } else if (i4 == 8388613) {
                linearLayoutCompat.setGravity(16);
                linearLayoutCompat.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 1));
                linearLayoutCompat.setPadding(BaseDialog2.this.m4590a(5.0f), 0, BaseDialog2.this.m4590a(5.0f), 0);
            }
            TextView textView = new TextView(BaseDialog2.this.f8251b);
            textView.setSingleLine(true);
            textView.setTextSize(1, 14.0f);
            textView.setHeight(BaseDialog2.this.m4590a(45.0f));
            textView.setLetterSpacing(0.02f);
            textView.setText(cancelObj.f8193a);
            int i5 = BaseDialog2.this.f8274x;
            if (i5 == 80) {
                textView.setGravity(17);
            } else if (i5 == 8388613) {
                textView.setGravity(16);
            }
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int i6 = BaseDialog2.this.f8274x;
            if (i6 == 80) {
                ((LinearLayout.LayoutParams) c0541a).gravity = 17;
            } else if (i6 == 8388613) {
                c0541a = new LinearLayoutCompat.LayoutParams(-2, -2, 1.0f);
            }
            textView.setLayoutParams(c0541a);
            linearLayoutCompat.addView(textView);
            ImageView imageView = new ImageView(BaseDialog2.this.f8251b);
            imageView.setPadding(BaseDialog2.this.m4590a(5.0f), 0, 0, 0);
            imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(BaseDialog2.this.m4590a(20.0f), BaseDialog2.this.m4590a(15.0f)));
            imageView.setImageResource(cancelObj.f8194b);
            linearLayoutCompat.setPadding(BaseDialog2.this.m4590a(12.0f), 0, 0, 0);
            linearLayoutCompat.addView(imageView);
            MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(BaseDialog2.this.f8251b);
            materialRippleLayout.addView(linearLayoutCompat);
            if (cancelObj.f8195c) {
                materialRippleLayout.setDefaultRippleAlpha(0);
                i2 = Color.parseColor("#FF999999");
            } else {
                materialRippleLayout.setDefaultRippleAlpha(10);
                i2 = BaseDialog2.this.f8205C;
            }
            textView.setTextColor(i2);
            if ((cancelObj.f8194b != 0 || BaseDialog2.this.f8210H.equals(cancelObj.f8193a)) && (i3 = BaseDialog2.this.f8209G) != 0) {
                textView.setTextColor(i3);
                imageView.setImageTintList(ColorStateList.valueOf(BaseDialog2.this.f8209G));
            }
            return materialRippleLayout;
        }
    }

    public BaseDialog2(Context context, View view) {
        this(context, new String[0], view, 80);
    }

    public BaseDialog2(Context context, ArrayList<Cancel_Obj> arrayList, int i) {
        super(context, i);
        this.f8213z = Color.parseColor("#ffffffff");
        this.f8204B = Color.parseColor("#D7D7D9");
        this.f8205C = Color.parseColor("#ff222222");
        this.f8207E = new ArrayList<>();
        this.f8209G = 0;
        this.f8210H = "";
        this.f8207E.addAll(arrayList);
    }

    public BaseDialog2(Context context, String[] strArr) {
        this(context, strArr, null, 80);
    }

    public BaseDialog2(Context context, String[] strArr, View view, int i) {
        super(context, i);
        this.f8213z = Color.parseColor("#ffffffff");
        this.f8204B = Color.parseColor("#D7D7D9");
        this.f8205C = Color.parseColor("#ff222222");
        this.f8207E = new ArrayList<>();
        this.f8209G = 0;
        this.f8210H = "";
        if (strArr != null) {
            this.f8207E = new ArrayList<>();
            for (String str : strArr) {
                this.f8207E.add(new Cancel_Obj(str, 0));
            }
        }
        if (view != null) {
            this.f8211I = view;
        }
    }

    public BaseDialog2(Context context, String[] strArr, int[] iArr) {
        super(context, 80);
        this.f8213z = Color.parseColor("#ffffffff");
        this.f8204B = Color.parseColor("#D7D7D9");
        this.f8205C = Color.parseColor("#ff222222");
        this.f8207E = new ArrayList<>();
        this.f8209G = 0;
        this.f8210H = "";
        this.f8207E = new ArrayList<>();
        if (strArr == null || iArr == null || strArr.length != iArr.length) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            this.f8207E.add(new Cancel_Obj(strArr[i], iArr[i]));
        }
    }


    public  void m4575a(AdapterView adapterView, View view, int i, long j) {
        DialogInterface2 dialogInterface2 = this.interface2;
        if (dialogInterface2 != null) {
            dialogInterface2.mo4264a(view, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View mo4576b() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p190c.p193c0.p196c.DialogC1999h.mo4576b():android.view.View");
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public void mo4577c() {
        if (this.f8211I == null) {
            this.f8203A.setDivider(new ColorDrawable(this.f8204B));
            this.f8203A.setDividerHeight(m4590a(0.4f));
            if (this.f8206D == null) {
                this.f8206D = new a();
            }
            this.f8203A.setAdapter((ListAdapter) this.f8206D);
            this.f8203A.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: b.f.a.c.c0.c.a
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    BaseDialog2.this.m4575a(adapterView, view, i, j);
                }
            });
        }
        int i = this.f8274x;
        if (i == 80) {
            float m4590a = m4590a(20.0f);
            this.f8212y.setBackground(Util.getGradDrawable(this.f8213z, new float[]{m4590a, m4590a, m4590a, m4590a, 0.0f, 0.0f, 0.0f, 0.0f}));
        } else if (i == 8388613) {
            this.f8212y.setBackgroundColor(this.f8213z);
        }
    }

    
    public  void m4578c(View view) {
        if (this.f8253d) {
            startAni();
        }
    }

    
    public  void m4579d(View view) {
        if (this.f8253d) {
            startAni();
        }
    }
}
