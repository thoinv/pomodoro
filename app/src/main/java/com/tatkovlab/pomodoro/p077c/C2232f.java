package com.tatkovlab.pomodoro.p077c;

import com.tatkovlab.pomodoro.p081g.C2270d;
import com.tatkovlab.pomodoro.p083i.PrefManager;
import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.c.f */
public enum C2232f implements C2270d {
    TICKING_1("Ticking", R.raw.ticking, 0),
    TICKING_2("Ticking_2", R.raw.ticking_2, 0),
    RINGING_1("Ringing", R.raw.alarm_ring_short, 0),
    RINGING_2("Ringing_2", R.raw.alarm_notification, 0);
    

    /* renamed from: e */
    private String f6564e;

    /* renamed from: f */
    private int f6565f;

    /* renamed from: g */
    private int f6566g;

    C2232f(String str, int i, int i2) {
        this.f6564e = str;
        this.f6565f = i;
        this.f6566g = i2;
    }

    /* renamed from: a */
    public String mo7930a() {
        return this.f6564e;
    }

    /* renamed from: b */
    public int mo7931b() {
        return this.f6565f;
    }

    /* renamed from: c */
    public long mo7932c() {
        return (long) this.f6566g;
    }

    /* renamed from: d */
    public static C2232f m10212d() {
        C2232f fVar = TICKING_1;
        switch (PrefManager.getValue(PrefManager.TICKING_SOUND_INDEX).intValue()) {
            case 0:
                return TICKING_1;
            case 1:
                return TICKING_2;
            default:
                return fVar;
        }
    }

    /* renamed from: e */
    public static C2232f m10213e() {
        C2232f fVar = RINGING_1;
        switch (PrefManager.getValue(PrefManager.RINGING_SOUND_INDEX).intValue()) {
            case 0:
                return RINGING_1;
            case 1:
                return RINGING_2;
            default:
                return fVar;
        }
    }
}
