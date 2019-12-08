package com.tatkovlab.pomodoro.p079e;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
//import android.support.p031v4.app.C0547x.C0550c;

import androidx.core.app.NotificationCompat;

import com.tatkovlab.pomodoro.MainActivity;
import com.tatkovlab.pomodoro.p079e.C2248e.C2249a;
import com.tatkovlab.pomodoro.p081g.C2271e;
import com.tatkovlab.pomodoro.p081g.C2271e.C2274c;
import com.tatkovlab.pomodoro.p083i.C2298d;
import com.tatkovlab.pomodorolite.R;

class C2254h implements C2247d, C2249a {

    private Context context;

    private boolean f6613b = false;

    private NotificationCompat.Builder f6614c;

    public int mo7948a() {
        return 1;
    }

    public void mo7959e() {
    }

    C2254h(Context context) {
        this.context = context.getApplicationContext();
        m10318i().mo7954a(this);
    }

    public Notification mo7949b() {
        this.f6614c = m10315f();
        return this.f6614c.build();
    }

    @SuppressLint("WrongConstant")
    private NotificationCompat.Builder m10315f() {
        NotificationCompat.Builder cVar = new NotificationCompat.Builder(this.context, "pomodoro_timer");
        cVar.setPriority(1).setDefaults(0);
        C2271e d = C2250f.m10263a().mo7962d();
        C2274c h = d.mo7976h();
        if (h == C2274c.POMODORO) {
            cVar.setColor(this.context.getResources().getColor(R.color.notification_red))
                    .setSmallIcon(R.drawable.ic_notif_pomodoro)
                    .setContentTitle(getString(R.string.notification_pomodoro_running_title))
                    .setContentText(getString(R.string.notification_pomodoro_running_body));
        } else if (h == C2274c.SHORT_BREAK || h == C2274c.LONG_BREAK) {
            cVar.setColor(this.context.getResources().getColor(R.color.notification_green))
                    .setSmallIcon(R.drawable.ic_notif_pomodoro)
                    .setContentTitle(getString(R.string.notification_break_running_title))
                    .setContentText(getString(R.string.notification_break_running_body));
        } else if (h == C2274c.IDLE) {
            if (d.mo7977i() == C2274c.POMODORO) {
                cVar.setColor(this.context.getResources().getColor(R.color.notification_red))
                        .setSmallIcon(R.drawable.ic_notif_pomodoro)
                        .setContentTitle(getString(R.string.notification_break_finished_title))
                        .setContentText(getString(R.string.notification_break_finished_body))
                        .setAutoCancel(true);
            } else {
                cVar.setColor(this.context.getResources().getColor(R.color.notification_green))
                        .setSmallIcon(R.drawable.ic_notif_pomodoro)
                        .setContentTitle(getString(R.string.notification_pomodoro_finished_title))
                        .setContentText(getString(R.string.notification_pomodoro_finished_body))
                        .setAutoCancel(true);
            }
        }
        m10312a(cVar);
        cVar.setContentIntent(PendingIntent.getActivity(this.context, 1,
                new Intent(this.context, MainActivity.class), 268435456));
        return cVar;
    }

    private void m10312a(NotificationCompat.Builder cVar) {
        if (m10318i().mo7955b()) {
            cVar.setSubText(m10316g());
            this.f6613b = true;
            return;
        }
        this.f6613b = false;
    }

    private String getString(int i) {
        return this.context.getResources().getString(i);
    }

    private String m10316g() {
        return C2298d.m10468a((long) m10318i().mo7956c());
    }

    public void mo7957a(int i) {
        if (!this.f6613b) {
            this.f6614c = m10315f();
        } else {
            this.f6614c.setSubText(C2298d.m10468a((long) i));
        }
        m10314b(this.f6614c);
    }

    public void mo7958d() {
        m10314b(m10315f());
    }

    private void m10314b(NotificationCompat.Builder cVar) {
        getNotificationManager().notify(1, cVar.build());
    }

    private NotificationManager getNotificationManager() {
        return (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    private C2248e m10318i() {
        return C2250f.m10263a().mo7960b();
    }

    public void mo7950c() {
        getNotificationManager().cancel(1);
    }
}
