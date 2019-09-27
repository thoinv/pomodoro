package com.tatkovlab.pomodoro;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Pair;
import com.tatkovlab.pomodoro.p079e.C2247d;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p081g.C2269c;
import com.tatkovlab.pomodoro.p081g.C2270d;
import com.tatkovlab.pomodoro.p081g.C2278g;
import com.tatkovlab.pomodoro.p081g.C2279h;
import java.util.ArrayList;
import java.util.List;

public class SoundService extends Service {

    /* renamed from: a */
    private int f6458a = 0;

    /* renamed from: b */
    private final IBinder f6459b = new C2189a();

    /* renamed from: c */
    private C2279h f6460c;

    /* renamed from: d */
    private List<Pair<C2270d, Integer>> f6461d = new ArrayList();

    /* renamed from: com.tatkovlab.pomodoro.SoundService$a */
    public class C2189a extends Binder {
        public C2189a() {
        }

        /* renamed from: a */
        public SoundService mo7842a() {
            return SoundService.this;
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (mo7837a()) {
            return 1;
        }
        C2247d c = C2250f.m10263a().mo7961c();
        startForeground(c.mo7948a(), c.mo7949b());
        if (this.f6460c == null) {
            m10066b();
        }
        this.f6460c.mo8009a();
        this.f6458a = 1;
        return 1;
    }

    /* renamed from: a */
    public void mo7836a(C2270d dVar, int i) {
        if (this.f6460c != null) {
            this.f6460c.mo8012a(dVar, i);
        } else {
            this.f6461d.add(new Pair(dVar, Integer.valueOf(i)));
        }
    }

    /* renamed from: a */
    public void mo7835a(C2270d dVar) {
        if (this.f6460c != null) {
            this.f6460c.mo8011a(dVar);
        }
    }

    /* renamed from: b */
    public void mo7838b(C2270d dVar, int i) {
        if (this.f6460c != null) {
            this.f6460c.mo8013a(dVar.mo7930a(), i);
        }
    }

    /* renamed from: b */
    private void m10066b() {
        if (this.f6460c != null) {
            m10070e();
        }
        this.f6460c = new C2279h(this, m10069d());
        for (Pair pair : this.f6461d) {
            this.f6460c.mo8012a((C2270d) pair.first, ((Integer) pair.second).intValue());
        }
        m10068c();
    }

    /* renamed from: c */
    private void m10068c() {
        this.f6461d = new ArrayList();
    }

    /* renamed from: d */
    private C2269c m10069d() {
        return new C2278g();
    }

    /* renamed from: e */
    private void m10070e() {
        m10067b(10);
    }

    /* renamed from: b */
    private void m10067b(long j) {
        if (this.f6460c != null) {
            this.f6460c.mo8010a(j);
            this.f6460c = null;
        }
    }

    /* renamed from: a */
    public boolean mo7837a() {
        return this.f6458a == 1;
    }

    /* renamed from: a */
    public void mo7834a(long j) {
        m10067b(j);
        this.f6458a = 0;
        stopForeground(true);
        stopSelf();
    }

    public void onDestroy() {
        m10070e();
        this.f6458a = 0;
    }

    public IBinder onBind(Intent intent) {
        return this.f6459b;
    }
}
