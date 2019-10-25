package com.tatkovlab.pomodoro.p077c;

import com.tatkovlab.pomodoro.p081g.C2270d;
import com.tatkovlab.pomodoro.p083i.PrefManager;
import com.tatkovlab.pomodorolite.R;

import static com.tatkovlab.pomodoro.p083i.PrefManager.getValue;

public enum C2232f implements C2270d {
    TICKING_1("Ticking", R.raw.ticking, 0),
    TICKING_2("Ticking_2", R.raw.ticking_2, 0),
    RINGING_1("Ringing", R.raw.alarm_ring_short, 0),
    RINGING_2("Ringing_2", R.raw.alarm_notification, 0);
    

    private String f6564e;

    private int f6565f;

    private int f6566g;

    C2232f(String str, int i, int i2) {
        this.f6564e = str;
        this.f6565f = i;
        this.f6566g = i2;
    }

    public String mo7930a() {
        return this.f6564e;
    }

    public int mo7931b() {
        return this.f6565f;
    }

    public long mo7932c() {
        return (long) this.f6566g;
    }

    public static C2232f m10212d() {
        switch (getValue(PrefManager.TICKING_SOUND_INDEX)) {
            case 0:
                return TICKING_1;
            case 1:
                return TICKING_2;
            default:
                return TICKING_1;
        }
    }

    public static C2232f m10213e() {
        switch (getValue(PrefManager.RINGING_SOUND_INDEX)) {
            case 0:
                return RINGING_1;
            case 1:
                return RINGING_2;
            default:
                return RINGING_1;
        }
    }
}
