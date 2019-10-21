package com.tatkovlab.pomodoro.p077c;

import android.content.Context;

import com.tatkovlab.pomodoro.p083i.PrefManager;
import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.c.e */
public class C2231e {
    /* renamed from: a */
    public int mo7926a() {
        return 4;
    }

    /* renamed from: a */
    public int mo7927a(Context context) {
        return Integer.parseInt(context.getResources().getStringArray(R.array.pomodoro_duration_values)[
                PrefManager.getValue(PrefManager.pomodoroDurationIndex)]) * 60;
    }

    /* renamed from: b */
    public int mo7928b(Context context) {
        return Integer.parseInt(context.getResources().getStringArray(R.array.short_breaks_values)[
                PrefManager.getValue(PrefManager.shortBreakTag)]) * 60;
    }

    /* renamed from: c */
    public int mo7929c(Context context) {
        return Integer.parseInt(context.getResources().getStringArray(R.array.long_breaks_values)[
                PrefManager.getValue(PrefManager.longBreakTag)]) * 60;
    }
}
