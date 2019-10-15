package com.tatkovlab.pomodoro.p079e;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.p031v4.app.C0547x.C0550c;

import androidx.core.app.NotificationCompat;

import com.tatkovlab.pomodoro.MainActivity;
import com.tatkovlab.pomodoro.p079e.C2248e.C2249a;
import com.tatkovlab.pomodoro.p081g.C2271e;
import com.tatkovlab.pomodoro.p081g.C2271e.C2274c;
import com.tatkovlab.pomodoro.p083i.C2298d;
import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.e.h */
class C2254h implements C2247d, C2249a {

    /* renamed from: a */
    private Context f6612a;

    /* renamed from: b */
    private boolean f6613b = false;

    /* renamed from: c */
    private C0550c f6614c;

    /* renamed from: a */
    public int mo7948a() {
        return 1;
    }

    /* renamed from: e */
    public void mo7959e() {
    }

    C2254h(Context context) {
        this.f6612a = context.getApplicationContext();
        m10318i().mo7954a((C2249a) this);
    }

    /* renamed from: b */
    public Notification mo7949b() {
        this.f6614c = m10315f();
        return this.f6614c.mo1926b();
    }

    /* renamed from: f */
    private C0550c m10315f() {
        NotificationCompat.Builder cVar = new NotificationCompat.Builder(this.f6612a, "pomodoro_timer");
        cVar.mo1930c(1).mo1920a(0);
        C2271e d = C2250f.m10263a().mo7962d();
        C2274c h = d.mo7976h();
        if (h == C2274c.POMODORO) {
            cVar.mo1927b(this.f6612a.getResources().getColor(R.color.notification_red)).mo1919a((int) R.drawable.ic_notif_pomodoro).mo1923a((CharSequence) m10313b((int) R.string.notification_pomodoro_running_title)).mo1928b((CharSequence) m10313b((int) R.string.notification_pomodoro_running_body));
        } else if (h == C2274c.SHORT_BREAK || h == C2274c.LONG_BREAK) {
            cVar.mo1927b(this.f6612a.getResources().getColor(R.color.notification_green)).mo1919a((int) R.drawable.ic_notif_pomodoro).mo1923a((CharSequence) m10313b((int) R.string.notification_break_running_title)).mo1928b((CharSequence) m10313b((int) R.string.notification_break_running_body));
        } else if (h == C2274c.IDLE) {
            if (d.mo7977i() == C2274c.POMODORO) {
                cVar.mo1927b(this.f6612a.getResources().getColor(R.color.notification_red)).mo1919a((int) R.drawable.ic_notif_pomodoro).mo1923a((CharSequence) m10313b((int) R.string.notification_break_finished_title)).mo1928b((CharSequence) m10313b((int) R.string.notification_break_finished_body)).mo1925a(true);
            } else {
                cVar.mo1927b(this.f6612a.getResources().getColor(R.color.notification_green)).mo1919a((int) R.drawable.ic_notif_pomodoro).mo1923a((CharSequence) m10313b((int) R.string.notification_pomodoro_finished_title)).mo1928b((CharSequence) m10313b((int) R.string.notification_pomodoro_finished_body)).mo1925a(true);
            }
        }
        m10312a(cVar);
        cVar.mo1921a(PendingIntent.getActivity(this.f6612a, 1, new Intent(this.f6612a, MainActivity.class), 268435456));
        return cVar;
    }

    /* renamed from: a */
    private void m10312a(C0550c cVar) {
        if (m10318i().mo7955b()) {
            cVar.mo1931c((CharSequence) m10316g());
            this.f6613b = true;
            return;
        }
        this.f6613b = false;
    }

    /* renamed from: b */
    private String m10313b(int i) {
        return this.f6612a.getResources().getString(i);
    }

    /* renamed from: g */
    private String m10316g() {
        return C2298d.m10468a((long) m10318i().mo7956c());
    }

    /* renamed from: a */
    public void mo7957a(int i) {
        if (!this.f6613b) {
            this.f6614c = m10315f();
        } else {
            this.f6614c.mo1931c((CharSequence) C2298d.m10468a((long) i));
        }
        m10314b(this.f6614c);
    }

    /* renamed from: d */
    public void mo7958d() {
        m10314b(m10315f());
    }

    /* renamed from: b */
    private void m10314b(C0550c cVar) {
        m10317h().notify(1, cVar.mo1926b());
    }

    /* renamed from: h */
    private NotificationManager m10317h() {
        return (NotificationManager) this.f6612a.getSystemService("notification");
    }

    /* renamed from: i */
    private C2248e m10318i() {
        return C2250f.m10263a().mo7960b();
    }

    /* renamed from: c */
    public void mo7950c() {
        m10317h().cancel(1);
    }
}
