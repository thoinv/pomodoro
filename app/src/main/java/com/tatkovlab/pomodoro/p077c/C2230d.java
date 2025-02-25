package com.tatkovlab.pomodoro.p077c;

import com.tatkovlab.pomodoro.p083i.PrefManager;

public class C2230d {

    private int f6557a = m10203e();

    private int f6558b;

    public C2230d(int i) {
        this.f6558b = i;
    }

    private int m10203e() {
        if (mo7922a()) {
            return PrefManager.getValue(PrefManager.LONG_BREAK_COUNTER_COMPLETED_POMODOROS);
        }
        return 0;
    }

    public boolean mo7922a() {
        return PrefManager.getValue(PrefManager.LONG_BREAK_COUNTER_LAST_COMPLETED_POMODORO) + 28800000 >= System.currentTimeMillis();
    }

    public void mo7923b() {
        m10202a(this.f6557a + 1);
        PrefManager.save(PrefManager.LONG_BREAK_COUNTER_LAST_COMPLETED_POMODORO, System.currentTimeMillis());
    }

    public void mo7924c() {
        m10202a(0);
    }

    private void m10202a(int i) {
        this.f6557a = i;
        PrefManager.save(PrefManager.LONG_BREAK_COUNTER_COMPLETED_POMODOROS, this.f6557a);
    }

    public boolean mo7925d() {
        return this.f6557a > 0 && this.f6557a % this.f6558b == 0;
    }
}
