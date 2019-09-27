package com.tatkovlab.pomodoro.p078d;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.WindowManager;

/* renamed from: com.tatkovlab.pomodoro.d.e */
public class C2241e {
    /* renamed from: a */
    public static int m10229a(Context context, float f) {
        return Math.round(f * context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: a */
    public static int m10228a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (VERSION.SDK_INT < 13) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }
}
