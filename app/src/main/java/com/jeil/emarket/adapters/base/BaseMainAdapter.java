package com.jeil.emarket.adapters.base;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.jeil.emarket.activities.baseactivity.BaseActivity;

/* renamed from: b.f.a.b.b.c */

public abstract class BaseMainAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    
    public BaseActivity baseActivity;

    
    public List<T> arrayList = new ArrayList();

    public MutableLiveData<Boolean> booleanMutableLiveData;

    /* renamed from: g */
    public int pos;

    public BaseMainAdapter(BaseActivity baseActivity, int i) {
        this.baseActivity = baseActivity;
        this.booleanMutableLiveData = new MutableLiveData<>(false);
        this.pos = i;
    }

    public BaseMainAdapter(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemCount() {
        List<T> list = this.arrayList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }


    public void add(T t) {
        this.arrayList.add(t);
        notifyItemChanged(this.arrayList.size() - 1);
    }


    public void addAll(List<T> list) {
        this.arrayList = list;
        this.notifyDataSetChanged();
    }

    
    public void clear() {
        this.arrayList.clear();
        this.notifyDataSetChanged();
    }


    public void addModList(List<T> list, int index, boolean z) {
        int size;
        int size2;
        int sizeModList = this.arrayList.size() % 20 > 0 ? this.arrayList.size() % 20 : 20;
        if (z) {
            this.arrayList = this.arrayList.subList(0, this.arrayList.size() - sizeModList);
        }
        this.arrayList.addAll(list);
        if (!z) {
            size = (this.arrayList.size() - list.size()) + index;
            size2 = list.size();
        } else if (sizeModList > list.size()) {
            this.notifyItemRangeChanged((this.arrayList.size() - list.size()) + index, list.size());
            this.notifyItemRangeInserted(this.arrayList.size() + index, sizeModList - list.size());
            return;
        } else {
            this.notifyItemRangeChanged((this.arrayList.size() - list.size()) + index, sizeModList);
            size = (this.arrayList.size() - list.size()) + index + sizeModList;
            size2 = list.size() - sizeModList;
        }
        this.notifyItemRangeRemoved(size, size2);
    }
}
