package com.tatkovlab.pomodoro.p078d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.WindowManager;

public class C2241e {
    public static int m10229a(Context context, float f) {
        return Math.round(f * context.getResources().getDisplayMetrics().density);
    }

    public static int m10228a(Context context) {
        @SuppressLint("WrongConstant") WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if(windowManager == null){
            return 0;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }
}
