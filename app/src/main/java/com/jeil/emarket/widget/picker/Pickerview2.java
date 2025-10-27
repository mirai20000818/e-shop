package com.jeil.emarket.widget.picker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: b.f.a.c.x.l */

public class Pickerview2<T> {


    public T f8787a;

    
    public int f8789c;

    
    public Pickerview2<T> f8791e;

    /* renamed from: f */
    public List<Pickerview2<T>> f8792f = new ArrayList();


    public int f8788b = 0;

    
    public int f8790d = 0;

    public Pickerview2(T t) {
        this.f8787a = t;
    }


    public int m4760a() {
        return this.f8792f.size();
    }


    public Pickerview2<T> m4761a(int i) {
        if (i < 0 || i >= this.f8792f.size()) {
            return null;
        }
        return this.f8792f.get(i);
    }


    public Pickerview2<T> m4762a(Collection<? extends Pickerview2<T>> collection) {
        for (Pickerview2<T> pickerview2 : collection) {
            pickerview2.m4764c();
            pickerview2.f8791e = this;
            pickerview2.f8789c = this.f8792f.size();
            this.f8792f.add(pickerview2);
        }
        return this;
    }


    public boolean m4763b() {
        return !this.f8792f.isEmpty();
    }

    
    public final void m4764c() {
        this.f8788b++;
        Iterator<Pickerview2<T>> it = this.f8792f.iterator();
        while (it.hasNext()) {
            it.next().m4764c();
        }
    }
}
