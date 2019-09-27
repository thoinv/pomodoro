package com.tatkovlab.pomodoro;

import android.app.Application;
import android.os.Build.VERSION;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p080f.C2263a;
import com.tatkovlab.pomodoro.p083i.C2291a;
import com.tatkovlab.pomodoro.p083i.C2295b;

public class App extends Application {
    public void onCreate() {
        super.onCreate();
        m10015a();
        C2295b.m10460a(getApplicationContext());
        C2250f.m10264a(getApplicationContext(), m10016b());
        C2291a.m10454a(this);
    }

    /* renamed from: a */
    private void m10015a() {
        if (VERSION.SDK_INT >= 26) {
            C2263a.m10368a(this, getPackageName());
        }
    }

    /* renamed from: b */
    private boolean m10016b() {
        return C2291a.m10453a(getApplicationContext(), 0) == 0;
    }
}
