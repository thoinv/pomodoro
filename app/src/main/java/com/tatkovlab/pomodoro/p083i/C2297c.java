package com.tatkovlab.pomodoro.p083i;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;

/* renamed from: com.tatkovlab.pomodoro.i.c */
public class C2297c {
    /* renamed from: a */
    public static void m10467a(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            m10466a(activity).setStatusBarColor(i);
        }
    }

    /* renamed from: a */
    private static Window m10466a(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        return window;
    }
}
