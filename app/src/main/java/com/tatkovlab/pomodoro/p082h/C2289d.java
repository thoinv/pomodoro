package com.tatkovlab.pomodoro.p082h;

import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.h.d */
public enum C2289d {
    MINUTES_25(1500, 640, 11, R.drawable.timeline_25),
    MINUTES_45(2700, 1134, 11, R.drawable.timeline_40);
    

    /* renamed from: c */
    private final int f6676c;

    /* renamed from: d */
    private final int f6677d;

    /* renamed from: e */
    private final int f6678e;

    /* renamed from: f */
    private final int f6679f;

    /* renamed from: c */
    public int mo8023c() {
        return 70;
    }

    private C2289d(int i, int i2, int i3, int i4) {
        this.f6676c = i;
        this.f6677d = i2;
        this.f6678e = i3;
        this.f6679f = i4;
    }

    /* renamed from: a */
    public int mo8021a() {
        return this.f6676c;
    }

    /* renamed from: b */
    public int mo8022b() {
        return this.f6677d;
    }

    /* renamed from: d */
    public int mo8024d() {
        return this.f6678e;
    }

    /* renamed from: e */
    public int mo8025e() {
        return this.f6679f;
    }

    /* renamed from: a */
    public static C2289d m10443a(int i) {
        return i > MINUTES_25.mo8021a() ? MINUTES_45 : MINUTES_25;
    }
}
