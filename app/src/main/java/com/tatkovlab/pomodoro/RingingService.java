package com.tatkovlab.pomodoro;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import com.tatkovlab.pomodoro.p077c.C2232f;
import com.tatkovlab.pomodoro.p083i.C2295b;

public class RingingService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m10041a();
        return 2;
    }

    /* renamed from: a */
    @SuppressLint({"InvalidWakeLockTag", "WrongConstant"})
    private void m10041a() {
        Context baseContext = getBaseContext();
        @SuppressLint("WrongConstant") PowerManager powerManager = (PowerManager) baseContext.getSystemService("power");
        powerManager.newWakeLock(1, "RING_WAKE_LOCK").acquire(10000);
        powerManager.newWakeLock(805306394, "SCREEN_WAKE_LOCK").acquire(5000);
        final MediaPlayer create = MediaPlayer.create(baseContext, C2232f.m10213e().mo7931b());
        if (create != null) {
            if (((Boolean) C2295b.getValue(C2295b.isVibrationTag)).booleanValue()) {
                ((Vibrator) baseContext.getSystemService("vibrator")).vibrate(new long[]{0, 200, 300, 200}, -1);
            }
            float intValue = ((float) ((Integer) C2295b.getValue(C2295b.ringSoundTags)).intValue()) / 100.0f;
            create.setScreenOnWhilePlaying(true);
            create.setVolume(intValue, intValue);
            create.start();
            create.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    create.release();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
