package com.anievaluate.evaluate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.anievaluate.abstra.AbstractC2953a;
import com.anievaluate.abstra.AbstractC2955c;
import com.jeil.emarket.custom.CustomString;

/* renamed from: b.g.a.i */
/* loaded from: classes.dex */
public class C2950i implements Cloneable {

    /* renamed from: l */
    public static final InterfaceC2951j f10651l = new C2945d();

    /* renamed from: m */
    public static final InterfaceC2951j f10652m = new C2943b();

    /* renamed from: n */
    public static Class[] f10653n;

    /* renamed from: o */
    public static Class[] f10654o;

    /* renamed from: p */
    public static Class[] f10655p;

    /* renamed from: q */
    public static final HashMap<Class, HashMap<java.lang.String, Method>> f10656q;

    /* renamed from: r */
    public static final HashMap<Class, HashMap<java.lang.String, Method>> f10657r;

    /* renamed from: b */
    public java.lang.String f10658b;

    /* renamed from: c */
    public AbstractC2955c f10659c;

    /* renamed from: d */
    public Method f10660d;

    
    public Method f10661e;

    /* renamed from: f */
    public Class f10662f;

    /* renamed from: g */
    public C2947f f10663g;

    /* renamed from: h */
    public final ReentrantReadWriteLock f10664h;

    
    public final Object[] f10665i;

   
    public InterfaceC2951j f10666j;

    
    public Object f10667k;

    /* renamed from: b.g.a.i$b */
    public static class b extends C2950i {

        /* renamed from: s */
        public AbstractC2953a f10668s;

        /* renamed from: t */
        public C2944c f10669t;

        /* renamed from: u */
        public float f10670u;

        public b(AbstractC2955c abstractC2955c, float... fArr) {
            super(abstractC2955c);
            super.mo5820a(fArr);
            this.f10669t = (C2944c) this.f10663g;
            if (abstractC2955c instanceof AbstractC2953a) {
                this.f10668s = (AbstractC2953a) this.f10659c;
            }
        }

        @Override // p078b.p268g.p269a.C2950i
        /* renamed from: a */
        public Object mo5814a() {
            return Float.valueOf(this.f10670u);
        }

        @Override // p078b.p268g.p269a.C2950i
        /* renamed from: a */
        public void mo5817a(float f) {
            this.f10670u = this.f10669t.m5800b(f);
        }

        @Override // p078b.p268g.p269a.C2950i
        /* renamed from: a */
        public void mo5818a(Class cls) {
            if (this.f10659c != null) {
                return;
            }
            super.mo5818a(cls);
        }

        @Override // p078b.p268g.p269a.C2950i
        /* renamed from: a */
        public void mo5819a(Object obj) {
            AbstractC2953a abstractC2953a = this.f10668s;
            if (abstractC2953a != null) {
                abstractC2953a.mo5811a((AbstractC2953a) obj, this.f10670u);
                return;
            }
            AbstractC2955c abstractC2955c = this.f10659c;
            if (abstractC2955c != null) {
                abstractC2955c.mo5826a(obj, Float.valueOf(this.f10670u));
                return;
            }
            if (this.f10660d != null) {
                try {
                    this.f10665i[0] = Float.valueOf(this.f10670u);
                    this.f10660d.invoke(obj, this.f10665i);
                } catch (IllegalAccessException e2) {
                    e2.toString();
                } catch (InvocationTargetException e3) {
                    e3.toString();
                }
            }
        }

        @Override // p078b.p268g.p269a.C2950i
        /* renamed from: a */
        public void mo5820a(float... fArr) {
            super.mo5820a(fArr);
            this.f10669t = (C2944c) this.f10663g;
        }



        public b(java.lang.String str, float... fArr) {
            super(str);
            super.mo5820a(fArr);
            this.f10669t = (C2944c) this.f10663g;
        }
    }

    static {
        Class cls = Integer.TYPE;
        f10653n = new Class[]{Float.TYPE, Float.class, Double.TYPE, cls, Double.class, Integer.class};
        Class cls2 = Double.TYPE;
        f10654o = new Class[]{cls, Integer.class, Float.TYPE, cls2, Float.class, Double.class};
        f10655p = new Class[]{cls2, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
        f10656q = new HashMap<>();
        f10657r = new HashMap<>();
    }

    public /* synthetic */ C2950i(AbstractC2955c abstractC2955c) {
        this.f10660d = null;
        this.f10661e = null;
        this.f10663g = null;
        this.f10664h = new ReentrantReadWriteLock();
        this.f10665i = new Object[1];
        this.f10659c = abstractC2955c;
        if (abstractC2955c != null) {
            this.f10658b = abstractC2955c.f10696a;
        }
    }

    /* renamed from: a */
    public static C2950i m5812a(AbstractC2955c<?, Float> abstractC2955c, float... fArr) {
        return new b(abstractC2955c, fArr);
    }

    /* renamed from: a */
    public static C2950i m5813a(java.lang.String str, float... fArr) {
        return new b(str, fArr);
    }

    /* renamed from: a */
    public Object mo5814a() {
        return this.f10667k;
    }

    /* renamed from: a */
    public final Method m5815a(Class cls, java.lang.String str, Class cls2) {
        StringBuilder m3163a;
        java.lang.String str2 = this.f10658b;
        if (str2 != null && str2.length() != 0) {
            str = str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
        }
        Method method = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(str, null);
            } catch (NoSuchMethodException e2) {
                try {
                    method = cls.getDeclaredMethod(str, null);
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    m3163a = CustomString.format("Couldn't find no-arg method for property ");
                    m3163a.append(this.f10658b);
                    m3163a.append(": ");
                    m3163a.append(e2);
                }
            }
        } else {
            Class<?>[] clsArr = new Class[1];
            for (Class<?> cls3 : this.f10662f.equals(Float.class) ? f10653n : this.f10662f.equals(Integer.class) ? f10654o : this.f10662f.equals(Double.class) ? f10655p : new Class[]{this.f10662f}) {
                clsArr[0] = cls3;
                try {
                    try {
                        Method method2 = cls.getMethod(str, clsArr);
                        this.f10662f = cls3;
                        return method2;
                    } catch (NoSuchMethodException unused2) {
                        method = cls.getDeclaredMethod(str, clsArr);
                        method.setAccessible(true);
                        this.f10662f = cls3;
                        return method;
                    }
                } catch (NoSuchMethodException unused3) {
                }
            }
            m3163a = CustomString.format("Couldn't find setter/getter for property ");
            m3163a.append(this.f10658b);
            m3163a.append(" with value type ");
            m3163a.append(this.f10662f);
        }
        return method;
    }

    /* renamed from: a */
    public final Method m5816a(Class cls, HashMap<Class, HashMap<java.lang.String, Method>> hashMap, java.lang.String str, Class cls2) {
        try {
            this.f10664h.writeLock().lock();
            HashMap<java.lang.String, Method> hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? hashMap2.get(this.f10658b) : null;
            if (method == null) {
                method = m5815a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f10658b, method);
            }
            return method;
        } finally {
            this.f10664h.writeLock().unlock();
        }
    }

    /* renamed from: a */
    public void mo5817a(float f) {
        this.f10667k = this.f10663g.mo5799a(f);
    }

    /* renamed from: a */
    public void mo5818a(Class cls) {
        this.f10660d = m5816a(cls, f10656q, "set", this.f10662f);
    }

    /* renamed from: a */
    public void mo5819a(Object obj) {
        AbstractC2955c abstractC2955c = this.f10659c;
        if (abstractC2955c != null) {
            abstractC2955c.mo5826a(obj, mo5814a());
        }
        if (this.f10660d != null) {
            try {
                this.f10665i[0] = mo5814a();
                this.f10660d.invoke(obj, this.f10665i);
            } catch (IllegalAccessException e2) {
                e2.toString();
            } catch (InvocationTargetException e3) {
                e3.toString();
            }
        }
    }



    public java.lang.String toString() {
        return this.f10658b + ": " + this.f10663g.toString();
    }

    /* renamed from: a */
    public void mo5820a(float... fArr) {
        this.f10662f = Float.TYPE;
        int length = fArr.length;
        AbstractC2946e.a[] aVarArr = new AbstractC2946e.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (AbstractC2946e.a) AbstractC2946e.m5801a(0.0f);
            aVarArr[1] = new AbstractC2946e.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (AbstractC2946e.a) AbstractC2946e.m5802a(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                aVarArr[i] = new AbstractC2946e.a(i / (length - 1), fArr[i]);
            }
        }
        this.f10663g = new C2944c(aVarArr);
    }

    public /* synthetic */ C2950i(java.lang.String str) {
        this.f10660d = null;
        this.f10661e = null;
        this.f10663g = null;
        this.f10664h = new ReentrantReadWriteLock();
        this.f10665i = new Object[1];
        this.f10658b = str;
    }
}
