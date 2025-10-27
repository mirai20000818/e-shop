package custom.google.android.material.p142k;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.p007b.p008a.C0052a;
import androidx.core.view.C0271a;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0356l;

import custom.google.android.material.p143l.ViewOnTouchListenerC1131a;
import custom.google.android.material.p144m.C1132a;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;

/* renamed from: b.e.a.a.k.n */
/* loaded from: classes.dex */
public final class C1118n<S> extends DialogInterfaceOnCancelListenerC0356l {

    /* renamed from: H0 */
    public static final Object f5653H0 = "CONFIRM_BUTTON_TAG";

    /* renamed from: I0 */
    public static final Object f5654I0 = "CANCEL_BUTTON_TAG";

    /* renamed from: J0 */
    public static final Object f5655J0 = "TOGGLE_BUTTON_TAG";

    /* renamed from: A0 */
    public CharSequence f5656A0;

    /* renamed from: B0 */
    public boolean f5657B0;

    /* renamed from: C0 */
    public int f5658C0;

    /* renamed from: D0 */
    public TextView f5659D0;

    /* renamed from: E0 */
    public CheckableImageButton f5660E0;

    /* renamed from: F0 */
    public C1181g f5661F0;

    /* renamed from: G0 */
    public Button f5662G0;

    /* renamed from: q0 */
    public final LinkedHashSet<InterfaceC1120p<? super S>> f5663q0 = new LinkedHashSet<>();

    /* renamed from: r0 */
    public final LinkedHashSet<View.OnClickListener> f5664r0 = new LinkedHashSet<>();

    /* renamed from: s0 */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f5665s0 = new LinkedHashSet<>();

    /* renamed from: t0 */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f5666t0 = new LinkedHashSet<>();

    /* renamed from: u0 */
    public int f5667u0;

    /* renamed from: v0 */
    public InterfaceC1108d<S> f5668v0;

    /* renamed from: w0 */
    public AbstractC1127w<S> f5669w0;

    /* renamed from: x0 */
    public C1103a f5670x0;

    /* renamed from: y0 */
    public C1111g<S> f5671y0;

    /* renamed from: z0 */
    public int f5672z0;

    /* renamed from: b.e.a.a.k.n$a */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<InterfaceC1120p<? super S>> it = C1118n.this.f5663q0.iterator();
            while (it.hasNext()) {
                it.next().m4020a((Object) C1118n.this.m4015Y0());
            }
            C1118n.this.m1686S0();
        }
    }

    /* renamed from: b.e.a.a.k.n$b */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = C1118n.this.f5664r0.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            C1118n.this.m1686S0();
        }
    }

    /* renamed from: b.e.a.a.k.n$c */
    public class c extends AbstractC1126v<S> {
        public c() {
        }

        @Override // p078b.p126e.p127a.p128a.p142k.AbstractC1126v
        /* renamed from: a */
        public void mo4019a(S s) {
            C1118n.this.m4018a1();
            C1118n c1118n = C1118n.this;
            c1118n.f5662G0.setEnabled(c1118n.f5668v0.m3994c());
        }
    }

    /* renamed from: a */
    public static boolean m4011a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Util.m291b(context, R$attr.materialCalendarStyle, C1111g.class.getCanonicalName()), new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* renamed from: b */
    public static int m4012b(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i = new C1122r(C1130z.m4043b()).f5684e;
        return ((i - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i) + (dimensionPixelOffset * 2);
    }

    /* renamed from: c */
    public static boolean m4013c(Context context) {
        return m4011a(context, R.attr.windowFullscreen);
    }

    @Override // p000a.p055m.p056a.DialogInterfaceOnCancelListenerC0356l, androidx.fragment.app.Fragment
    /* renamed from: B0 */
    public void mo1684B0() {
        super.mo1684B0();
        Window window = m1690W0().getWindow();
        if (this.f5657B0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f5661F0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f5661F0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC1131a(m1690W0(), rect));
        }
        m4016Z0();
    }

    @Override // p000a.p055m.p056a.DialogInterfaceOnCancelListenerC0356l, androidx.fragment.app.Fragment
    /* renamed from: C0 */
    public void mo1685C0() {
        this.f5669w0.m4037S0();
        super.mo1685C0();
    }

    /* renamed from: X0 */
    public String m4014X0() {
        return this.f5668v0.m3990a(m2557p());
    }

    /* renamed from: Y0 */
    public final S m4015Y0() {
        return this.f5668v0.m3989a();
    }

    /* renamed from: Z0 */
    public final void m4016Z0() {
        AbstractC1127w<S> abstractC1127w;
        Context m2484P0 = getContext();
        int i = this.f5667u0;
        if (i == 0) {
            i = this.f5668v0.m3992b(m2484P0);
        }
        InterfaceC1108d<S> interfaceC1108d = this.f5668v0;
        C1103a c1103a = this.f5670x0;
        C1111g<S> c1111g = new C1111g<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("GRID_SELECTOR_KEY", interfaceC1108d);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c1103a);
        bundle.putParcelable("CURRENT_MONTH_KEY", c1103a.f5587e);
        c1111g.m2546k(bundle);
        this.f5671y0 = c1111g;
        if (this.f5660E0.isChecked()) {
            InterfaceC1108d<S> interfaceC1108d2 = this.f5668v0;
            C1103a c1103a2 = this.f5670x0;
            abstractC1127w = new C1121q<>();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i);
            bundle2.putParcelable("DATE_SELECTOR_KEY", interfaceC1108d2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", c1103a2);
            abstractC1127w.m2546k(bundle2);
        } else {
            abstractC1127w = this.f5671y0;
        }
        this.f5669w0 = abstractC1127w;
        m4018a1();
        FragmentTransaction beginTransaction = m2555o().beginTransaction();
        int i2 = R$id.mtrl_calendar_frame;
        AbstractC1127w<S> abstractC1127w2 = this.f5669w0;
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        beginTransaction.replace(i2, abstractC1127w2, (String) null, 2);
        FragmentTransaction c0331a = (FragmentTransaction) beginTransaction;
        if (c0331a.f2326g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        c0331a.f2327h = false;
        c0331a.f2109r.m1585b((FragmentManager.o) c0331a, false);
        this.f5669w0.mo4008a(new c());
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: a */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f5657B0 ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.f5657B0) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(m4012b(context), -2));
        } else {
            View findViewById = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R$id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(m4012b(context), -1));
            Resources resources = getContext().getResources();
            findViewById2.setMinimumHeight(resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height) + (resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding) * (C1123s.f5688g - 1)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * C1123s.f5688g) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding));
        }
        this.f5659D0 = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        ViewCompat.m1303g(this.f5659D0, 1);
        this.f5660E0 = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.f5656A0;
        if (charSequence != null) {
            textView.setText(charSequence);
        } else {
            textView.setText(this.f5672z0);
        }
        this.f5660E0.setTag(f5655J0);
        CheckableImageButton checkableImageButton = this.f5660E0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, C0052a.m373c(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], C0052a.m373c(context, R$drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.f5660E0.setChecked(this.f5658C0 != 0);
        ViewCompat.m1274a(this.f5660E0, (C0271a) null);
        m4017a(this.f5660E0);
        this.f5660E0.setOnClickListener(new ViewOnClickListenerC1119o(this));
        this.f5662G0 = (Button) inflate.findViewById(R$id.confirm_button);
        if (this.f5668v0.m3994c()) {
            this.f5662G0.setEnabled(true);
        } else {
            this.f5662G0.setEnabled(false);
        }
        this.f5662G0.setTag(f5653H0);
        this.f5662G0.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag(f5654I0);
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // p000a.p055m.p056a.DialogInterfaceOnCancelListenerC0356l, androidx.fragment.app.Fragment
    /* renamed from: a */
    public final void mo1694a(Bundle bundle) {
        super.mo1694a(bundle);
        if (bundle == null) {
            bundle = m2553n();
        }
        this.f5667u0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f5668v0 = (InterfaceC1108d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f5670x0 = (C1103a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f5672z0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f5656A0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f5658C0 = bundle.getInt("INPUT_MODE_KEY");
    }

    /* renamed from: a */
    public final void m4017a(CheckableImageButton checkableImageButton) {
        this.f5660E0.setContentDescription(checkableImageButton.getContext().getString(this.f5660E0.isChecked() ? R$string.mtrl_picker_toggle_to_calendar_input_mode : R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    /* renamed from: a1 */
    public final void m4018a1() {
        String m4014X0 = m4014X0();
        this.f5659D0.setContentDescription(String.format(m2498a(R$string.mtrl_picker_announce_current_selection), m4014X0));
        this.f5659D0.setText(m4014X0);
    }

    @Override // p000a.p055m.p056a.DialogInterfaceOnCancelListenerC0356l, androidx.fragment.app.Fragment
    /* renamed from: c */
    public final void mo1699c(Bundle bundle) {
        super.mo1699c(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f5667u0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f5668v0);
        C1103a.b bVar = new C1103a.b(this.f5670x0);
        if (this.f5671y0.m4002V0() != null) {
            bVar.f5594c = Long.valueOf(this.f5671y0.m4002V0().f5686g);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", bVar.f5595d);
        C1122r m4022b = C1122r.m4022b(bVar.f5592a);
        C1122r m4022b2 = C1122r.m4022b(bVar.f5593b);
        C1103a.c cVar = (C1103a.c) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = bVar.f5594c;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new C1103a(m4022b, m4022b2, cVar, l == null ? null : C1122r.m4022b(l.longValue()), null));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f5672z0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f5656A0);
    }

    @Override // p000a.p055m.p056a.DialogInterfaceOnCancelListenerC0356l
    /* renamed from: l */
    public final Dialog mo1702l(Bundle bundle) {
        Context m2484P0 = getContext();
        Context m2484P02 = getContext();
        int i = this.f5667u0;
        if (i == 0) {
            i = this.f5668v0.m3992b(m2484P02);
        }
        Dialog dialog = new Dialog(m2484P0, i);
        Context context = dialog.getContext();
        this.f5657B0 = m4013c(context);
        int m291b = Util.m291b(context, R$attr.colorSurface, C1118n.class.getCanonicalName());
        this.f5661F0 = new C1181g(C1185k.m4176a(context, (AttributeSet) null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar).m4185a());
        C1181g c1181g = this.f5661F0;
        c1181g.f5989b.f6013b = new C1132a(context);
        c1181g.m4171i();
        this.f5661F0.m4156a(ColorStateList.valueOf(m291b));
        this.f5661F0.m4152a(ViewCompat.m1306i(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // p000a.p055m.p056a.DialogInterfaceOnCancelListenerC0356l, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f5665s0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
    }

    @Override // p000a.p055m.p056a.DialogInterfaceOnCancelListenerC0356l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f5666t0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) m2490T();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }
}
