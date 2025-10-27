package com.jeil.emarket.widget;

import android.os.CountDownTimer;

import com.jeil.emarket.activities.auth.PassCodeActivity;
import com.jeil.emarket.components.PasscodeView;


/* renamed from: b.f.a.c.o */

public class CountDownTimerPasscode extends CountDownTimer {


    public final  PasscodeView f8540a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerPasscode(PasscodeView passcodeView, long j, long j2) {
        super(j, j2);
        this.f8540a = passcodeView;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        PasscodeView.verify_register interfaceC3233a = this.f8540a.f12028b;
        if (interfaceC3233a != null) {
            PassCodeActivity.verify_register verifyregister = (PassCodeActivity.verify_register) interfaceC3233a;
//            if (!PassCodeActivity.this.instance.isDestroyed()) {
//                Util.toast(PassCodeActivity.this.instance, R.string.register_verify_expired, "error");
//                PassCodeActivity.this.instance.setResult(0);
//                PassCodeActivity.this.instance.finish();
//            } else {
//                return;
//            }
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        PasscodeView passcodeView = this.f8540a;
        passcodeView.f12030d.setText(String.format(passcodeView.getResources().getString(R.string.please_enter_passcode_in_seconds), Long.valueOf(j / 1000)));
    }
}
