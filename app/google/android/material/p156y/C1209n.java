package custom.google.android.material.p156y;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.p007b.p008a.C0052a;
import custom.google.android.material.internal.C1156n;

/* renamed from: b.e.a.a.y.n */
/* loaded from: classes.dex */
public class C1209n extends AbstractC1204i {

    /* renamed from: d */
    public final TextWatcher f6199d;

    /* renamed from: e */
    public final TextInputLayout.InterfaceC3066f f6200e;

    /* renamed from: f */
    public final TextInputLayout.InterfaceC3067g f6201f;

    /* renamed from: b.e.a.a.y.n$a */
    public class a extends C1156n {
        public a() {
        }

        @Override // p078b.p126e.p127a.p128a.p147p.C1156n, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C1209n.this.f6168c.setChecked(!C1209n.m4262a(r1));
        }
    }

    /* renamed from: b.e.a.a.y.n$b */
    public class b implements TextInputLayout.InterfaceC3066f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC3066f
        /* renamed from: a */
        public void mo4221a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            C1209n.this.f6168c.setChecked(!C1209n.m4262a(r4));
            editText.removeTextChangedListener(C1209n.this.f6199d);
            editText.addTextChangedListener(C1209n.this.f6199d);
        }
    }

    /* renamed from: b.e.a.a.y.n$c */
    public class c implements TextInputLayout.InterfaceC3067g {

        /* renamed from: b.e.a.a.y.n$c$a */
        public class a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ EditText f6205b;

            public a(EditText editText) {
                this.f6205b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6205b.removeTextChangedListener(C1209n.this.f6199d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC3067g
        /* renamed from: a */
        public void mo4222a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* renamed from: b.e.a.a.y.n$d */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = C1209n.this.f6166a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            editText.setTransformationMethod(C1209n.m4262a(C1209n.this) ? null : PasswordTransformationMethod.getInstance());
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            C1209n.this.f6166a.m6213p();
        }
    }

    public C1209n(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6199d = new a();
        this.f6200e = new b();
        this.f6201f = new c();
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m4262a(C1209n c1209n) {
        EditText editText = c1209n.f6166a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // p078b.p126e.p127a.p128a.p156y.AbstractC1204i
    /* renamed from: a */
    public void mo4218a() {
        this.f6166a.setEndIconDrawable(C0052a.m373c(this.f6167b, R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f6166a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        this.f6166a.setEndIconOnClickListener(new d());
        this.f6166a.m6192a(this.f6200e);
        this.f6166a.m6193a(this.f6201f);
        EditText editText = this.f6166a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
