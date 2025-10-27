package com.jeil.emarket.adapters.base;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentPagerAdapter;

/* renamed from: b.f.a.b.b.g */

public class FragmentPagerAdaperEx extends FragmentPagerAdapter {

   
    public List<String> f7128j;

    
    public List<Integer> f7129k;

    /* renamed from: l */
    public List<Fragment> f7130l;

    public FragmentPagerAdaperEx(androidx.fragment.app.FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
        this.f7128j = new ArrayList();
        this.f7129k = new ArrayList();
        this.f7130l = new ArrayList();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }


    @Override // p000a.p075x.p076a.AbstractC0513a

    public int getCount() {
        return this.f7130l.size();
    }


    public int m4417a(String str) {
        if (this.f7128j.contains(str)) {
            return this.f7128j.indexOf(str);
        }
        return -1;
    }

   // @Override // p000a.p075x.p076a.AbstractC0513a

    public CharSequence mo2187a(int i) {
        return this.f7128j.get(i);
    }


    public void m4418a(int i, int i2) {
        if (i < 0 || i >= getCount()) {
            return;
        }
        this.f7129k.set(i, Integer.valueOf(i2));
    }


    public void m4419a(int i, String str, int i2) {
        if (i < 0 || i >= getCount()) {
            return;
        }
        this.f7128j.set(i, str);
        this.f7129k.set(i, Integer.valueOf(i2));
    }


    public void addFragment(Fragment fragment, String str) {
        this.f7130l.add(fragment);
        this.f7128j.add(str);
        this.f7129k.add(-1);
    }


    public void addFragment(Fragment fragment, String str, boolean z) {
        this.f7130l.add(fragment);
        this.f7128j.add(str);
        this.f7129k.add(Integer.valueOf(z ? 0 : -1));
    }


    public Fragment get(int i) {
        return this.f7130l.get(i);
    }


    public int getInt(int i) {
        return this.f7129k.get(i).intValue();
    }
}
