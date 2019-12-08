package com.tatkovlab.pomodoro.p081g;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

public class C2264a {

    public Handler f6632a = new Handler();

    public C2267a f6633b;

    public int f6634c;

    private Timer f6635d;

    public interface C2267a {
        void mo8000a();

        void mo8001a(int i);
    }

    public C2264a(int i, long j, C2267a aVar) {
        if (i == 0) {
            aVar.mo8000a();
            return;
        }
        mo7997a();
        this.f6633b = aVar;
        this.f6634c = i;
        this.f6635d = new Timer(true);
        m10375a(i, j);
    }

    private void m10375a(int i, long j) {
        this.f6635d.schedule(m10378b(), 0, m10376b(i, j));
    }

    private TimerTask m10378b() {
        return new TimerTask() {
            public void run() {
                C2264a.this.f6632a.post(new Runnable() {
                    public void run() {
                        C2264a.this.f6634c = C2264a.this.f6634c - 1;
                        if (C2264a.this.f6634c <= 0) {
                            C2264a.this.f6633b.mo8000a();
                            C2264a.this.mo7997a();
                            return;
                        }
                        C2264a.this.f6633b.mo8001a(C2264a.this.f6634c);
                    }
                });
            }
        };
    }

    private long m10376b(int i, long j) {
        long j2 = j / ((long) i);
        if (j2 < 1) {
            return 1;
        }
        return j2;
    }

    public void mo7997a() {
        if (this.f6635d != null) {
            this.f6635d.cancel();
            this.f6635d.purge();
            this.f6635d = null;
            this.f6632a.removeCallbacksAndMessages(null);
        }
    }
}
