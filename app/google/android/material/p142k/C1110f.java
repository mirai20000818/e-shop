package custom.google.android.material.p142k;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: b.e.a.a.k.f */
/* loaded from: classes.dex */
public class C1110f extends BaseAdapter {

    /* renamed from: e */
    public static final int f5615e;

    /* renamed from: b */
    public final Calendar f5616b = C1130z.m4045c();

    /* renamed from: c */
    public final int f5617c = this.f5616b.getMaximum(7);

    /* renamed from: d */
    public final int f5618d = this.f5616b.getFirstDayOfWeek();

    static {
        f5615e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    /* renamed from: a */
    public final int m3997a(int i) {
        int i2 = i + this.f5618d;
        int i3 = this.f5617c;
        return i2 > i3 ? i2 - i3 : i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5617c;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i >= this.f5617c) {
            return null;
        }
        return Integer.valueOf(m3997a(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f5616b;
        int i2 = i + this.f5618d;
        int i3 = this.f5617c;
        if (i2 > i3) {
            i2 -= i3;
        }
        calendar.set(7, i2);
        textView.setText(this.f5616b.getDisplayName(7, f5615e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f5616b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
