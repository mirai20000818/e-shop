package com.anievaluate.evaluate;

import java.util.ArrayList;

/* renamed from: b.g.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2942a implements Cloneable {

    /* renamed from: b */
    public ArrayList<a> f10619b = null;

    /* renamed from: b.g.a.a$a */
    public interface a {
        /* renamed from: a */
        void mo4314a(AbstractC2942a abstractC2942a);

        /* renamed from: b */
        void mo4315b(AbstractC2942a abstractC2942a);

        /* renamed from: c */
        void mo4316c(AbstractC2942a abstractC2942a);
    }


    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AbstractC2942a mo7450clone() {
        try {
            AbstractC2942a abstractC2942a = (AbstractC2942a) super.clone();
            if (this.f10619b != null) {
                ArrayList<a> arrayList = this.f10619b;
                abstractC2942a.f10619b = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    abstractC2942a.f10619b.add(arrayList.get(i));
                }
            }
            return abstractC2942a;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
