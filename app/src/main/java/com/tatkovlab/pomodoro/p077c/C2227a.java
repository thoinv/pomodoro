package com.tatkovlab.pomodoro.p077c;

import com.tatkovlab.pomodorolite.R;
import java.util.Random;

/* renamed from: com.tatkovlab.pomodoro.c.a */
public enum C2227a {
    NO_1(R.string.break_header_v1, R.drawable.break_image_1),
    NO_2(R.string.break_header_v2, R.drawable.break_image_2),
    NO_3(R.string.break_header_v3, R.drawable.break_image_3),
    NO_4(R.string.break_header_v4, R.drawable.break_image_4),
    NO_5(R.string.break_header_v5, R.drawable.break_image_5),
    NO_6(R.string.break_header_v6, R.drawable.break_image_6),
    NO_7(R.string.break_header_v7, R.drawable.break_image_7),
    NO_8(R.string.break_header_v8, R.drawable.break_image_8),
    NO_9(R.string.break_header_v9, R.drawable.break_image_9),
    NO_10(R.string.break_header_v10, R.drawable.break_image_10);
    

    /* renamed from: k */
    private int f6542k;

    /* renamed from: l */
    private int f6543l;

    private C2227a(int i, int i2) {
        this.f6542k = i;
        this.f6543l = i2;
    }

    /* renamed from: a */
    public int mo7918a() {
        return this.f6542k;
    }

    /* renamed from: b */
    public int mo7919b() {
        return this.f6543l;
    }

    /* renamed from: c */
    public static C2227a m10196c() {
        return values()[new Random().nextInt(values().length)];
    }
}
