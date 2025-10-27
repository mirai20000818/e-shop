package custom.google.android.material.p154w;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: b.e.a.a.w.f */
/* loaded from: classes.dex */
public class C1194f {

    /* renamed from: e */
    public static C1194f f6107e;

    /* renamed from: a */
    public final Object f6108a = new Object();

    /* renamed from: b */
    public final Handler f6109b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c */
    public c f6110c;

    /* renamed from: d */
    public c f6111d;

    /* renamed from: b.e.a.a.w.f$a */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            C1194f.this.m4213a((c) message.obj);
            return true;
        }
    }

    /* renamed from: b.e.a.a.w.f$b */
    public interface b {
        /* renamed from: a */
        void m4215a(int i);
    }

    /* renamed from: b.e.a.a.w.f$c */
    public static class c {

        /* renamed from: a */
        public final WeakReference<b> f6113a;

        /* renamed from: b */
        public int f6114b;

        /* renamed from: c */
        public boolean f6115c;

        /* renamed from: a */
        public boolean m4216a(b bVar) {
            return bVar != null && this.f6113a.get() == bVar;
        }
    }

    /* renamed from: a */
    public void m4213a(c cVar) {
        b bVar;
        synchronized (this.f6108a) {
            if ((this.f6110c == cVar || this.f6111d == cVar) && (bVar = cVar.f6113a.get()) != null) {
                this.f6109b.removeCallbacksAndMessages(cVar);
                bVar.m4215a(2);
            }
        }
    }

    /* renamed from: b */
    public void m4214b(b bVar) {
        synchronized (this.f6108a) {
            c cVar = this.f6110c;
            if ((cVar != null && cVar.m4216a(bVar)) && this.f6110c.f6115c) {
                this.f6110c.f6115c = false;
                c cVar2 = this.f6110c;
                int i = cVar2.f6114b;
                if (i != -2) {
                    if (i <= 0) {
                        i = i == -1 ? 1500 : 2750;
                    }
                    this.f6109b.removeCallbacksAndMessages(cVar2);
                    Handler handler = this.f6109b;
                    handler.sendMessageDelayed(Message.obtain(handler, 0, cVar2), i);
                }
            }
        }
    }

    /* renamed from: a */
    public void m4212a(b bVar) {
        synchronized (this.f6108a) {
            c cVar = this.f6110c;
            if ((cVar != null && cVar.m4216a(bVar)) && !this.f6110c.f6115c) {
                this.f6110c.f6115c = true;
                this.f6109b.removeCallbacksAndMessages(this.f6110c);
            }
        }
    }
}
