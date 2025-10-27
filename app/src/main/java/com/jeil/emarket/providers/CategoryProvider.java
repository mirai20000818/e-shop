package com.jeil.emarket.providers;

import android.content.Context;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.viewmodel.CategoryVM;

/* renamed from: b.f.a.m.f0 */

public class CategoryProvider extends ViewModel {


    public MutableLiveData<Integer> f10473d;


    public MutableLiveData<String> f10474e;

    /* renamed from: f */
    public MutableLiveData<List<Category>> f10475f = new MutableLiveData<>();

    /* renamed from: g */
    public MutableLiveData<Category> f10476g = new MutableLiveData<>();

    /* renamed from: h */
    public MutableLiveData<Category> f10477h = new MutableLiveData<>();


    public void m5658a(Context context, int i, String str) {
        List<Category> getValue;
        this.f10473d = new MutableLiveData<>();
        this.f10474e = new MutableLiveData<>();
        this.f10473d.setValue( Integer.valueOf(i));
        this.f10474e.setValue( str);
        this.f10475f = new MutableLiveData<>();
        String[] split = ((String) Objects.requireNonNull(this.f10474e.getValue())).split(",");
        if (split.length <= 3 && (getValue = CategoryVM.listMutableLiveData.getValue()) != null) {
            try {
                Category category = getValue.get(Integer.parseInt(split[0]));
                this.f10476g.setValue(category);
                List<Category> list = category.children;
                if (list != null) {
                    ArrayList arrayList = new ArrayList(list);
                    if (split.length == 3) {
                        try {
                            this.f10477h.setValue(category.children.get(Integer.parseInt(split[1])));
                        } catch (Exception unused) {
                        }
                        this.f10475f.setValue( arrayList);
                    }
                    this.f10477h.setValue(null);
                    this.f10475f.setValue( arrayList);
                }
            } catch (Exception unused2) {
                Util.toast(context, context.getString(R.string.wrong_input_value), "error", 0, 0);
            }
        }
    }
}
