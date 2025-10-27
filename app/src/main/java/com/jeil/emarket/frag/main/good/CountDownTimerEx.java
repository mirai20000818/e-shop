package com.jeil.emarket.frag.main.good;

import android.os.CountDownTimer;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.textview.TextView;

/* renamed from: b.f.a.g.b.c.l0 */

public class CountDownTimerEx extends CountDownTimer {

    
    public final  ReminderFragment f9425a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerEx(ReminderFragment reminderFragment, long j, long j2) {
        super(j, j2);
        this.f9425a = reminderFragment;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.f9425a.f9431c0.findViewById(R.id.ctv_remain_time) != null) {
            ((TextView) this.f9425a.f9431c0.findViewById(R.id.ctv_remain_time)).setText(this.f9425a.f9431c0.getResources().getString(R.string.end_flash_sale_period));
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        java.lang.String string;
        java.lang.String str;
        java.lang.String valueOf;
        java.lang.String valueOf2;
        java.lang.String valueOf3;
        if (this.f9425a.f9431c0.findViewById(R.id.ctv_remain_time) != null) {
            TextView textView = (TextView) this.f9425a.f9431c0.findViewById(R.id.ctv_remain_time);
            ReminderFragment reminderFragment = this.f9425a;
            long j2 = reminderFragment.f9437i0;
            long j3 = j % j2;
            long j4 = (j - j3) / j2;
            long j5 = reminderFragment.f9438j0;
            long j6 = j3 % j5;
            long j7 = (j3 - j6) / j5;
            long j8 = reminderFragment.f9439k0;
            long j9 = j6 % j8;
            long j10 = (j6 - j9) / j8;
            long j11 = reminderFragment.f9440l0;
            long j12 = (j9 - (j9 % j11)) / j11;
            if (j > 0) {
                StringBuilder sb = new StringBuilder();
                if (j4 > 0) {
                    str = j4 + "일 ";
                } else {
                    str = "";
                }
                sb.append(str);
                if (java.lang.String.valueOf(j7).length() == 1) {
                    StringBuilder m3162a = CustomString.m3162a('0');
                    m3162a.append(java.lang.String.valueOf(j7));
                    valueOf = m3162a.toString();
                } else {
                    valueOf = java.lang.String.valueOf(j7);
                }
                sb.append(valueOf);
                sb.append(':');
                if (java.lang.String.valueOf(j10).length() == 1) {
                    StringBuilder m3162a2 = CustomString.m3162a('0');
                    m3162a2.append(java.lang.String.valueOf(j10));
                    valueOf2 = m3162a2.toString();
                } else {
                    valueOf2 = java.lang.String.valueOf(j10);
                }
                sb.append(valueOf2);
                sb.append(':');
                if (java.lang.String.valueOf(j12).length() == 1) {
                    StringBuilder m3162a3 = CustomString.m3162a('0');
                    m3162a3.append(java.lang.String.valueOf(j12));
                    valueOf3 = m3162a3.toString();
                } else {
                    valueOf3 = java.lang.String.valueOf(j12);
                }
                sb.append(valueOf3);
                string = sb.toString();
            } else {
                string = reminderFragment.f9431c0.getResources().getString(R.string.end_flash_sale_period);
            }
            textView.setText(string);
        }
    }
}
