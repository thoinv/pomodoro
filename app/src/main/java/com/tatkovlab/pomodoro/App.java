package com.tatkovlab.pomodoro;

import android.app.Application;
import android.os.Build.VERSION;

import androidx.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p080f.C2263a;
import com.tatkovlab.pomodoro.p083i.AppRateUtils;
import com.tatkovlab.pomodoro.p083i.PrefManager;

public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        createNotificationChannel();
        PrefManager.init(getApplicationContext());
        C2250f.get(getApplicationContext(), isFirstLaunchTime());
        AppRateUtils.checkAndUpdateFirstLaunchTime(this);
    }

    private void createNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            C2263a.createNotificationChanel(this, getPackageName());
        }
    }

    private boolean isFirstLaunchTime() {
        return AppRateUtils.getFirstLaunchTime(getApplicationContext(), 0) == 0;
    }
}
