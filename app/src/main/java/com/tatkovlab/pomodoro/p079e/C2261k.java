package com.tatkovlab.pomodoro.p079e;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.CountDownTimer;

import com.tatkovlab.pomodoro.p083i.PrefManager;
import com.tatkovlab.pomodoro.receivers.TimerBackupAlarmReceiver;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.tatkovlab.pomodoro.e.k */
class C2261k implements C2248e {

    /* renamed from: a */
    private CountDownTimer f6621a;

    /* renamed from: b */
    private List<C2249a> f6622b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f6623c;

    /* renamed from: d */
    private Context f6624d;

    C2261k(Context context) {
        this.f6624d = context;
        int h = m10360h();
        if (h > 0) {
            mo7952a(h);
        }
    }

    /* renamed from: a */
    public void mo7952a(int i) {
        this.f6623c = i;
        m10350a(false);
        m10356d(i);
        CountDownTimer r1 = new CountDownTimer(1000 * ((long) i), 1000) {
            public void onTick(long j) {
                C2261k.this.f6623c = ((int) j) / 1000;
                C2261k.this.m10354c(C2261k.this.f6623c);
            }

            public void onFinish() {
                C2261k.this.m10350a(false);
                C2261k.this.m10358f();
            }
        };
        this.f6621a = r1;
        this.f6621a.start();
        m10351b(i);
    }

    /* renamed from: b */
    @SuppressLint("WrongConstant")
    private void m10351b(int i) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis() + 2000 + (((long) i) * 1000);
        PendingIntent d = m10355d();
        AlarmManager alarmManager = (AlarmManager) this.f6624d.getSystemService("alarm");
        if (VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(0, timeInMillis, d);
        } else if (VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, timeInMillis, d);
        } else {
            alarmManager.set(0, timeInMillis, d);
        }
    }

    /* renamed from: d */
    @SuppressLint("WrongConstant")
    private PendingIntent m10355d() {
        long longValue = PrefManager.getValue(PrefManager.TIMER_STARTED_TIME).longValue();
        Intent intent = new Intent(this.f6624d, TimerBackupAlarmReceiver.class);
        intent.putExtra("INTENT_EXTRA_TIMER_STARTED_TIME", longValue);
        return PendingIntent.getBroadcast(this.f6624d, 2, intent, 268435456);
    }

    /* renamed from: e */
    private void m10357e() {
        PendingIntent d = m10355d();
        @SuppressLint("WrongConstant") AlarmManager alarmManager = (AlarmManager) this.f6624d.getSystemService("alarm");
        d.cancel();
        alarmManager.cancel(d);
    }

    /* renamed from: a */
    public void mo7953a(long j) {
        if (j > 0 && j == PrefManager.getValue(PrefManager.TIMER_STARTED_TIME).longValue()) {
            mo7951a();
            m10358f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10354c(int i) {
        for (C2249a a : this.f6622b) {
            a.mo7957a(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10358f() {
        for (C2249a d : this.f6622b) {
            d.mo7958d();
        }
    }

    /* renamed from: g */
    private void m10359g() {
        for (C2249a e : this.f6622b) {
            e.mo7959e();
        }
    }

    /* renamed from: a */
    public void mo7951a() {
        m10350a(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10350a(boolean z) {
        m10357e();
        if (this.f6621a != null) {
            this.f6621a.cancel();
            m10361i();
        }
        this.f6621a = null;
        if (z) {
            m10359g();
        }
    }

    /* renamed from: h */
    private int m10360h() {
        long longValue = PrefManager.getValue(PrefManager.TIMER_STARTED_TIME).longValue() + PrefManager.getValue(PrefManager.TIMER_DURATION_IN_MILLIS).longValue();
        if (longValue > System.currentTimeMillis()) {
            return (int) ((longValue - System.currentTimeMillis()) / 1000);
        }
        return 0;
    }

    /* renamed from: d */
    private void m10356d(int i) {
        PrefManager.save(PrefManager.TIMER_STARTED_TIME, Long.valueOf(System.currentTimeMillis()));
        PrefManager.save(PrefManager.TIMER_DURATION_IN_MILLIS, Long.valueOf(((long) i) * 1000));
    }

    /* renamed from: i */
    private void m10361i() {
        PrefManager.save(PrefManager.TIMER_STARTED_TIME, Long.valueOf(0));
        PrefManager.save(PrefManager.TIMER_DURATION_IN_MILLIS, Long.valueOf(0));
    }

    /* renamed from: b */
    public boolean mo7955b() {
        return this.f6621a != null;
    }

    /* renamed from: c */
    public int mo7956c() {
        return this.f6623c;
    }

    /* renamed from: a */
    public void mo7954a(C2249a aVar) {
        this.f6622b.add(aVar);
    }
}
