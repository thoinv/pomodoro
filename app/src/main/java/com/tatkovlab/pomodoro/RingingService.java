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
import com.tatkovlab.pomodoro.p083i.PrefManager;

public class RingingService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        playRingSound();
        return START_NOT_STICKY;
    }

    @SuppressLint({"InvalidWakeLockTag", "WrongConstant"})
    private void playRingSound() {
        Context baseContext = getBaseContext();
        @SuppressLint("WrongConstant") PowerManager powerManager = (PowerManager) baseContext.getSystemService("power");
        if (powerManager != null) {
            powerManager.newWakeLock(1, "RING_WAKE_LOCK").acquire(10000);
            powerManager.newWakeLock(805306394, "SCREEN_WAKE_LOCK").acquire(5000);
        }

        final MediaPlayer create = MediaPlayer.create(baseContext, C2232f.m10213e().mo7931b());
        if (create != null) {
            Vibrator vibrator = (Vibrator) baseContext.getSystemService("vibrator");
            if (PrefManager.getValue(PrefManager.isVibrationTag) && vibrator != null) {
                vibrator.vibrate(new long[]{0, 200, 300, 200}, -1);
            }
            float intValue = ((float) PrefManager.getValue(PrefManager.ringSoundTags)) / 100.0f;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
