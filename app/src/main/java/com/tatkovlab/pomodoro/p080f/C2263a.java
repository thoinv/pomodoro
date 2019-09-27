package com.tatkovlab.pomodoro.p080f;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build;

import com.tatkovlab.pomodorolite.R;

import java.util.ArrayList;

/* renamed from: com.tatkovlab.pomodoro.f.a */
public enum C2263a {
    POMODORO_TIMER("pomodoro_timer", 2, R.string.app_name);


    /* renamed from: b */
    private String f6628b;

    /* renamed from: c */
    private int f6629c;

    /* renamed from: d */
    private int f6630d;

    /* renamed from: e */
    private int f6631e;

    private C2263a(String str, int i, int i2) {
        this(r8, r9, str, i, i2, -1);
    }

    private C2263a(String str, int i, int i2, int i3) {
        this.f6628b = str;
        this.f6629c = i;
        this.f6630d = i2;
        this.f6631e = i3;
    }

    /* renamed from: a */
    public String mo7993a() {
        return this.f6628b;
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

    @SuppressLint("WrongConstant")
    public static void m10368a(Context context, String str) {
        C2263a[] values;
        ArrayList arrayList = new ArrayList();
        for (C2263a aVar : values()) {
            NotificationChannel notificationChannel = new NotificationChannel(aVar.mo7993a(), context.getResources().getString(aVar.mo7995c()), aVar.mo7994b());
            notificationChannel.enableVibration(true);
            int d = aVar.mo7996d();
            if (d != -1) {
                AudioAttributes build = new Builder().setUsage(5).build();
                StringBuilder sb = new StringBuilder();
                sb.append("android.resource://");
                sb.append(str);
                sb.append("/");
                sb.append(d);
                notificationChannel.setSound(Uri.parse(sb.toString()), build);
            }
            notificationChannel.setLockscreenVisibility(1);
            arrayList.add(notificationChannel);
        }
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannels(arrayList);
    }
}
