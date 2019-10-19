package com.tatkovlab.pomodoro.p080f;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.tatkovlab.pomodorolite.R;

import java.util.ArrayList;

/* renamed from: com.tatkovlab.pomodoro.f.a */
public enum C2263a {
    POMODORO_TIMER("pomodoro_timer", 2, R.string.app_name);


    /* renamed from: b */
    private String channelName;

    /* renamed from: c */
    private int f6629c;

    /* renamed from: d */
    private int f6630d;

    /* renamed from: e */
    private int f6631e;

    C2263a(String channelName, int i, int i2) {
        this(channelName, i, i2, -1);
    }

    C2263a(String channelName, int i, int i2, int i3) {
        this.channelName = channelName;
        this.f6629c = i;
        this.f6630d = i2;
        this.f6631e = i3;
    }

    /* renamed from: a */
    public String getChannelName() {
        return this.channelName;
    }

    /* renamed from: b */
    public int mo7994b() {
        return this.f6629c;
    }

    /* renamed from: c */
    public int mo7995c() {
        return this.f6630d;
    }

    /* renamed from: d */
    public int mo7996d() {
        return this.f6631e;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("WrongConstant")
    public static void createNotificationChanel(Context context, String str) {
        ArrayList<NotificationChannel> listChannel = new ArrayList<>();

        for (C2263a aVar : values()) {
            NotificationChannel notificationChannel = new NotificationChannel(aVar.getChannelName(), context.getResources().getString(aVar.mo7995c()), aVar.mo7994b());
            notificationChannel.enableVibration(true);
            int d = aVar.mo7996d();
            if (d != -1) {
                AudioAttributes build = new Builder().setUsage(5).build();
                notificationChannel.setSound(Uri.parse("android.resource://" + str + "/" + d), build);
            }
            notificationChannel.setLockscreenVisibility(1);
            listChannel.add(notificationChannel);
        }
        NotificationManager notification = (NotificationManager) context.getSystemService("notification");
        if (notification == null) {
            return;
        }
        notification.createNotificationChannels(listChannel);
    }
}
