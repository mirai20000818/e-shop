package com.jeil.emarket.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.c.x.k */

public class PickerviewAdapter<T> extends ArrayAdapter<T> {

    
    public boolean f8783b;

    
    public a f8784c;

    
    public b f8785d;

    
    public PickerviewObj f8786e;

    /* renamed from: b.f.a.c.x.k$a */
    public interface a {
        
        void mo4753a(int i, Pickerview2<?> pickerview2);
    }

    /* renamed from: b.f.a.c.x.k$b */
    public interface b {
        
        void mo4754a(int i, Pickerview2<?> pickerview2);
    }

    public PickerviewAdapter(Context context, List<T> list, PickerviewObj pickerviewObj) {
        super(context, 0, new ArrayList(list));
        this.f8783b = false;
        this.f8786e = pickerviewObj;
    }

    public PickerviewAdapter(Context context, List<T> list, PickerviewObj pickerviewObj, boolean z) {
        super(context, 0, new ArrayList(list));
        this.f8783b = false;
        this.f8786e = pickerviewObj;
        this.f8783b = z;
    }

    
    public  void m4757a(int i, Object obj, View view) {
        this.f8784c.mo4753a(i, (Pickerview2) obj);
    }

    
    public void m4758a(List<T> list) {
        super.clear();
        super.addAll(list);
    }

    
    public  void m4759b(int i, Object obj, View view) {
        this.f8785d.mo4754a(i, (Pickerview2) obj);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new LinearLayoutCompat1(getContext());
        }
        final T item = getItem(i);
        if (item instanceof Pickerview2) {
            Pickerview2<?> pickerview2 = (Pickerview2) item;
//            T t = pickerview2.f8787a;
//            if (t instanceof Address) {
//                LinearLayoutCompat1 linearLayoutCompat1 = (LinearLayoutCompat1) view;
//                linearLayoutCompat1.setText(((Address) t).label);
//                linearLayoutCompat1.f8768r.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.x.h
//                    @Override // android.view.View.OnClickListener
//                    public final void onClick(View view2) {
//                        PickerviewAdapter.this.m4757a(i, item, view2);
//                    }
//                });
//                linearLayoutCompat1.f8767q.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.x.g
//                    @Override // android.view.View.OnClickListener
//                    public final void onClick(View view2) {
//                        PickerviewAdapter.this.m4759b(i, item, view2);
//                    }
//                });
//                linearLayoutCompat1.setState(pickerview2.f8790d);
//                if (linearLayoutCompat1.getActiveStatus()) {
//                    linearLayoutCompat1.m4755h();
//                }
//                if (pickerview2.f8788b == 1 && this.f8783b && i == 0) {
//                    this.f8783b = false;
//                    linearLayoutCompat1.m4755h();
//                    PickerviewObj pickerviewObj = this.f8786e;
//                    pickerviewObj.f8779a = linearLayoutCompat1;
//                    pickerviewObj.f8781c = pickerview2;
//                } else if (pickerview2.f8788b == 2 && this.f8783b && i == 0) {
//                    this.f8783b = false;
//                    linearLayoutCompat1.m4755h();
//                    PickerviewObj pickerviewObj2 = this.f8786e;
//                    pickerviewObj2.f8780b = linearLayoutCompat1;
//                    pickerviewObj2.f8782d = pickerview2;
//                }
//            }
        }
        return view;
    }
}
