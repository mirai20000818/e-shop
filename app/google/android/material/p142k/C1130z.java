package custom.google.android.material.p142k;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import com.google.gson.internal.bind.util.ISO8601Utils;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: b.e.a.a.k.z */
/* loaded from: classes.dex */
public class C1130z {

    /* renamed from: a */
    public static AtomicReference<C1129y> f5707a = new AtomicReference<>();

    /* renamed from: a */
    public static long m4038a(long j) {
        Calendar m4045c = m4045c();
        m4045c.setTimeInMillis(j);
        return m4041a(m4045c).getTimeInMillis();
    }

    @TargetApi(24)
    /* renamed from: a */
    public static DateFormat m4039a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone(ISO8601Utils.UTC_ID));
        return instanceForSkeleton;
    }

    /* renamed from: a */
    public static Calendar m4041a(Calendar calendar) {
        Calendar m4044b = m4044b(calendar);
        Calendar m4045c = m4045c();
        m4045c.set(m4044b.get(1), m4044b.get(2), m4044b.get(5));
        return m4045c;
    }

    /* renamed from: a */
    public static java.util.TimeZone m4042a() {
        return java.util.TimeZone.getTimeZone(ISO8601Utils.UTC_ID);
    }

    /* renamed from: b */
    public static Calendar m4043b() {
        C1129y c1129y = f5707a.get();
        if (c1129y == null) {
            c1129y = C1129y.f5704c;
        }
        java.util.TimeZone timeZone = c1129y.f5706b;
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = c1129y.f5705a;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(m4042a());
        return calendar;
    }

    /* renamed from: b */
    public static Calendar m4044b(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(m4042a());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* renamed from: c */
    public static Calendar m4045c() {
        return m4044b(null);
    }

    /* renamed from: a */
    public static java.text.DateFormat m4040a(Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(0, locale);
        dateInstance.setTimeZone(m4042a());
        return dateInstance;
    }
}
