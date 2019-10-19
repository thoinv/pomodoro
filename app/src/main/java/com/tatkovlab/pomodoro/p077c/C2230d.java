package com.tatkovlab.pomodoro.p077c;

import com.tatkovlab.pomodoro.p083i.C2295b;

/* renamed from: com.tatkovlab.pomodoro.c.d */
public class C2230d {

    /* renamed from: a */
    private int f6557a = m10203e();

    /* renamed from: b */
    private int f6558b;

    public C2230d(int i) {
        this.f6558b = i;
    }

    /* renamed from: e */
    private int m10203e() {
        if (mo7922a()) {
            return C2295b.getValue(C2295b.LONG_BREAK_COUNTER_COMPLETED_POMODOROS);
        }
        return 0;
    }

    /* renamed from: a */
    public boolean mo7922a() {
        return C2295b.getValue(C2295b.LONG_BREAK_COUNTER_LAST_COMPLETED_POMODORO) + 28800000 >= System.currentTimeMillis();
    }

    /* renamed from: b */
    public void mo7923b() {
        m10202a(this.f6557a + 1);
        C2295b.save(C2295b.LONG_BREAK_COUNTER_LAST_COMPLETED_POMODORO, System.currentTimeMillis());
    }

    /* renamed from: c */
    public void mo7924c() {
        m10202a(0);
    }

    /* renamed from: a */
    private void m10202a(int i) {
        this.f6557a = i;
        C2295b.save(C2295b.LONG_BREAK_COUNTER_COMPLETED_POMODOROS, this.f6557a);
    }

    /* renamed from: d */
    public boolean mo7925d() {
        return this.f6557a > 0 && this.f6557a % this.f6558b == 0;
    }
}
