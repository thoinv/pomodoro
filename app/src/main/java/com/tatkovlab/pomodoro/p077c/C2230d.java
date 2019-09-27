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
            return ((Integer) C2295b.m10458a(C2295b.f6705q)).intValue();
        }
        return 0;
    }

    /* renamed from: a */
    public boolean mo7922a() {
        return ((Long) C2295b.m10458a(C2295b.f6706r)).longValue() + 28800000 >= System.currentTimeMillis();
    }

    /* renamed from: b */
    public void mo7923b() {
        m10202a(this.f6557a + 1);
        C2295b.m10461a(C2295b.f6706r, Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: c */
    public void mo7924c() {
        m10202a(0);
    }

    /* renamed from: a */
    private void m10202a(int i) {
        this.f6557a = i;
        C2295b.m10461a(C2295b.f6705q, Integer.valueOf(this.f6557a));
    }

    /* renamed from: d */
    public boolean mo7925d() {
        return this.f6557a > 0 && this.f6557a % this.f6558b == 0;
    }
}
