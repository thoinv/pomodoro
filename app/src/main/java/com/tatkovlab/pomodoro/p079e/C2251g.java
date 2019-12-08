package com.tatkovlab.pomodoro.p079e;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import com.tatkovlab.pomodoro.RingingService;
import com.tatkovlab.pomodoro.SoundService;
import com.tatkovlab.pomodoro.SoundService.C2189a;
import com.tatkovlab.pomodoro.p077c.C2230d;
import com.tatkovlab.pomodoro.p077c.C2231e;
import com.tatkovlab.pomodoro.p077c.C2232f;
import com.tatkovlab.pomodoro.p079e.C2248e.C2249a;
import com.tatkovlab.pomodoro.p081g.C2271e;
import com.tatkovlab.pomodoro.p083i.PrefManager;
import java.util.ArrayList;
import java.util.List;

class C2251g implements C2249a, C2271e {

    private Context f6600a;

    public SoundService f6601b;

    private boolean f6602c;

    public C2274c f6603d = C2274c.IDLE;

    private C2274c f6604e = C2274c.POMODORO;

    private C2273b f6605f;

    private List<C2272a> f6606g = new ArrayList();

    private C2231e f6607h = new C2231e();

    private C2230d f6608i = new C2230d(this.f6607h.mo7926a());

    private ServiceConnection f6609j = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C2251g.this.f6601b = ((C2189a) iBinder).mo7842a();
            if (C2251g.this.f6603d != C2274c.IDLE) {
                C2251g.this.m10292w();
                C2251g.this.m10289t();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C2251g.this.f6601b = null;
        }
    };

    public void mo7959e() {
    }

    C2251g(Context context) {
        this.f6600a = context.getApplicationContext();
        m10293x();
        C2250f.m10263a().mo7960b().mo7954a(this);
        m10281l();
    }

    private void m10281l() {
        this.f6603d = C2274c.m10408a(PrefManager.getValue(PrefManager.CURRENT_POMODORO_STATE));
        if (this.f6603d == C2274c.POMODORO && !m10295z().mo7955b()) {
            m10276a(C2274c.IDLE);
        }
        if (this.f6608i.mo7922a()) {
            this.f6604e = C2274c.m10408a(PrefManager.getValue(PrefManager.NEXT_POMODORO_STATE));
            C2250f.m10263a().getInstance().mo7941d();
        }
    }

    public void mo7967a() {
        m10276a(C2274c.POMODORO);
        m10279c(this.f6607h.mo7927a(this.f6600a));
    }

    public void mo7971b() {
        m10276a(C2274c.IDLE);
        m10278b(C2274c.POMODORO);
        m10295z().mo7951a();
        m10290u();
        m10287r();
    }

    public void mo7973c() {
        m10276a(C2274c.SHORT_BREAK);
        m10279c(this.f6607h.mo7928b(this.f6600a));
    }

    public void mo7974f() {
        m10276a(C2274c.LONG_BREAK);
        this.f6608i.mo7924c();
        m10279c(this.f6607h.mo7929c(this.f6600a));
    }

    public void mo7975g() {
        m10276a(C2274c.IDLE);
        m10278b(C2274c.POMODORO);
        m10295z().mo7951a();
        m10290u();
        C2250f.m10263a().mo7961c().mo7950c();
    }

    private void m10276a(C2274c cVar) {
        this.f6603d = cVar;
        PrefManager.save(PrefManager.CURRENT_POMODORO_STATE, cVar.mo8007a());
    }

    private void m10278b(C2274c cVar) {
        this.f6604e = cVar;
        PrefManager.save(PrefManager.NEXT_POMODORO_STATE, cVar.mo8007a());
    }

    public void mo7970a(C2273b bVar) {
        this.f6605f = bVar;
    }

    public void mo7969a(C2272a aVar) {
        this.f6606g.add(aVar);
    }

    public C2274c mo7976h() {
        return this.f6603d;
    }

    public C2274c mo7977i() {
        return this.f6604e;
    }

    public int mo7978j() {
        if (m10295z().mo7955b()) {
            return m10295z().mo7956c();
        }
        switch (this.f6604e) {
            case POMODORO:
                return this.f6607h.mo7927a(this.f6600a);
            case SHORT_BREAK:
            case LONG_BREAK:
                return 0;
            default:
                return this.f6607h.mo7927a(this.f6600a);
        }
    }

    public void mo7972b(int i) {
        if (m10294y()) {
            this.f6601b.mo7838b(C2232f.m10212d(), i);
        }
    }

    public void mo7968a(C2232f fVar, C2232f fVar2) {
        if (m10294y() && this.f6601b.mo7837a()) {
            m10275a(fVar2);
            this.f6601b.mo7835a(fVar);
        }
    }

    public int mo7979k() {
        int j = mo7978j();
        int a = this.f6607h.mo7927a(this.f6600a);
        return Math.max(Math.max(j, a), this.f6607h.mo7929c(this.f6600a));
    }

    public void mo7957a(int i) {
        if (this.f6605f != null) {
            this.f6605f.mo7803a(i);
        }
    }

    public void mo7958d() {
        m10282m();
        m10288s();
        if (this.f6603d == C2274c.POMODORO) {
            m10283n();
        } else {
            m10284o();
        }
    }

    @SuppressLint({"InvalidWakeLockTag", "WrongConstant"})
    private void m10282m() {
        ((PowerManager) this.f6600a.getSystemService("power")).newWakeLock(1, "POMODORO_MODULE_WAKE_LOCK").acquire(10000);
    }

    private void m10283n() {
        this.f6608i.mo7923b();
        m10276a(C2274c.IDLE);
        m10278b(this.f6608i.mo7925d() ? C2274c.LONG_BREAK : C2274c.SHORT_BREAK);
        m10285p();
        m10286q();
    }

    private void m10284o() {
        m10276a(C2274c.IDLE);
        m10278b(C2274c.POMODORO);
        m10285p();
    }

    private void m10285p() {
        if (this.f6605f != null) {
            this.f6605f.mo7802a();
        }
    }

    private void m10286q() {
        for (C2272a a : this.f6606g) {
            a.mo7946a();
        }
    }

    private void m10287r() {
        for (C2272a b : this.f6606g) {
            b.mo7947b();
        }
    }

    private void m10288s() {
        if (m10294y()) {
            m10290u();
        }
        m10291v();
    }

    private void m10279c(int i) {
        if (m10294y()) {
            if (!this.f6601b.mo7837a()) {
                m10292w();
            }
            m10289t();
            m10295z().mo7952a(i);
        }
    }

    /* access modifiers changed from: private */
    public void m10289t() {
        m10275a(C2232f.m10212d());
    }

    private void m10275a(C2232f fVar) {
        this.f6601b.mo7836a(fVar, PrefManager.getValue(PrefManager.tickingTag));
    }

    private void m10290u() {
        if (m10294y()) {
            m10274a(10);
        }
    }

    private void m10291v() {
        this.f6600a.startService(new Intent(this.f6600a, RingingService.class));
    }

    /* access modifiers changed from: private */
    public void m10292w() {
        if (m10294y()) {
            Intent intent = new Intent(this.f6600a, SoundService.class);
            if (VERSION.SDK_INT >= 26) {
                this.f6600a.startForegroundService(intent);
            } else {
                this.f6600a.startService(intent);
            }
        }
    }

    private void m10274a(long j) {
        if (m10294y()) {
            this.f6601b.mo7834a(j);
        }
    }

    private void m10293x() {
        this.f6600a.bindService(new Intent(this.f6600a, SoundService.class), this.f6609j, 1);
        this.f6602c = true;
    }

    private boolean m10294y() {
        return this.f6602c && this.f6601b != null;
    }

    private C2248e m10295z() {
        return C2250f.m10263a().mo7960b();
    }
}
