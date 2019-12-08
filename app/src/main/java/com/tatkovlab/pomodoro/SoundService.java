package com.tatkovlab.pomodoro;

import android.annotation.SuppressLint;
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

    private int f6458a = 0;

    private final IBinder f6459b = new C2189a();

    private C2279h f6460c;

    private List<Pair<C2270d, Integer>> f6461d = new ArrayList();

    public class C2189a extends Binder {
        public C2189a() {
        }

        public SoundService mo7842a() {
            return SoundService.this;
        }
    }

    @SuppressLint("WrongConstant")
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

    public void mo7836a(C2270d dVar, int i) {
        if (this.f6460c != null) {
            this.f6460c.mo8012a(dVar, i);
        } else {
            this.f6461d.add(new Pair(dVar, Integer.valueOf(i)));
        }
    }

    public void mo7835a(C2270d dVar) {
        if (this.f6460c != null) {
            this.f6460c.mo8011a(dVar);
        }
    }

    public void mo7838b(C2270d dVar, int i) {
        if (this.f6460c != null) {
            this.f6460c.mo8013a(dVar.mo7930a(), i);
        }
    }

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

    private void m10068c() {
        this.f6461d = new ArrayList();
    }

    private C2269c m10069d() {
        return new C2278g();
    }

    private void m10070e() {
        m10067b(10);
    }

    private void m10067b(long j) {
        if (this.f6460c != null) {
            this.f6460c.mo8010a(j);
            this.f6460c = null;
        }
    }

    public boolean mo7837a() {
        return this.f6458a == 1;
    }

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
