package com.tatkovlab.pomodoro.p082h;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;

import com.tatkovlab.pomodorolite.R;

public enum PomodoroTime {
    MINUTES_25(1500, 640, 11, R.drawable.timeline_25),
    MINUTES_45(2700, 1134, 11, R.drawable.timeline_40);
    

    private final int f6676c;

    private final int f6677d;

    private final int f6678e;

    private final int timeDrawableResId;

    public int mo8023c() {
        return 70;
    }

    PomodoroTime(int i, int i2, int i3, @DrawableRes int timeDrawableResId) {
        this.f6676c = i;
        this.f6677d = i2;
        this.f6678e = i3;
        this.timeDrawableResId = timeDrawableResId;
    }

    public int mo8021a() {
        return this.f6676c;
    }

    public int mo8022b() {
        return this.f6677d;
    }

    public int mo8024d() {
        return this.f6678e;
    }

    public int getTimeDrawableResId() {
        return this.timeDrawableResId;
    }

    public static PomodoroTime m10443a(int i) {
        return i > MINUTES_25.mo8021a() ? MINUTES_45 : MINUTES_25;
    }
}
