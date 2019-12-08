package com.tatkovlab.pomodoro.p083i;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;

public class C2297c {
    public static void m10467a(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            m10466a(activity).setStatusBarColor(i);
        }
    }

    private static Window m10466a(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        return window;
    }
}
