package com.tatkovlab.pomodoro.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tatkovlab.pomodoro.p079e.C2250f;

public class TimerBackupAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.hasExtra("INTENT_EXTRA_TIMER_STARTED_TIME")) {
            C2250f.m10263a().mo7960b().mo7953a(intent.getLongExtra("INTENT_EXTRA_TIMER_STARTED_TIME", -1));
        }
    }
}
