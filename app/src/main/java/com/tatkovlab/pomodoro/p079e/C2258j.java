package com.tatkovlab.pomodoro.p079e;

import android.content.Context;
import com.tatkovlab.pomodoro.p076b.C2210a;
import com.tatkovlab.pomodoro.p076b.C2220c;
import com.tatkovlab.pomodoro.p076b.C2221d;
import com.tatkovlab.pomodoro.p076b.C2223f;
import com.tatkovlab.pomodoro.p076b.C2223f.C2225a;
import com.tatkovlab.pomodoro.p076b.C2223f.C2226b;
import com.tatkovlab.pomodoro.p081g.C2271e.C2272a;

/* renamed from: com.tatkovlab.pomodoro.e.j */
public class C2258j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2223f f6618a = null;

    C2258j(Context context) {
        C2210a.m10138a(context);
        C2250f.m10263a().mo7962d().mo7969a((C2272a) new C2272a() {
            /* renamed from: a */
            public void mo7946a() {
                if (C2258j.this.f6618a != null) {
                    C2258j.this.f6618a.mo7901d(C2258j.this.f6618a.mo7903e() + 1);
                    C2210a.m10144b(C2258j.this.f6618a);
                    C2258j.this.m10335a();
                }
            }

            /* renamed from: b */
            public void mo7947b() {
                if (C2258j.this.f6618a != null) {
                    C2258j.this.f6618a.mo7904e(C2258j.this.f6618a.mo7905f() + 1);
                    C2210a.m10144b(C2258j.this.f6618a);
                    C2258j.this.m10335a();
                }
            }
        });
        C2210a.m10140a((C2221d<C2223f>) new C2221d<C2223f>() {
            /* renamed from: a */
            public void mo7844a(C2223f fVar) {
                C2258j.this.f6618a = fVar;
                C2258j.this.m10335a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10335a() {
        if (this.f6618a != null) {
            C2250f.m10263a().mo7963e().mo7944a(this.f6618a.mo7898c(), (int) this.f6618a.mo7903e());
        } else {
            C2250f.m10263a().mo7963e().mo7944a(null, 0);
        }
    }

    /* renamed from: a */
    public void mo7985a(C2223f fVar) {
        this.f6618a = fVar;
        C2210a.m10146d(fVar);
        m10335a();
    }

    /* renamed from: b */
    public void mo7986b(C2223f fVar) {
        C2210a.m10141a(fVar);
    }

    /* renamed from: c */
    public void mo7987c(C2223f fVar) {
        C2223f fVar2 = new C2223f();
        fVar2.mo7895a(fVar.mo7898c());
        fVar2.mo7894a(C2226b.NEW);
        fVar2.mo7893a(C2225a.TODAY);
        fVar2.mo7899c(fVar.mo7900d());
        fVar2.mo7901d(0);
        fVar2.mo7904e(0);
        fVar2.mo7906f(System.currentTimeMillis());
        mo7986b(fVar2);
    }

    /* renamed from: d */
    public void mo7988d(C2223f fVar) {
        if (this.f6618a != null && this.f6618a.mo7891a() == fVar.mo7891a()) {
            this.f6618a = null;
            m10335a();
        }
        C2210a.m10145c(fVar);
    }

    /* renamed from: e */
    public void mo7989e(C2223f fVar) {
        if (this.f6618a != null && this.f6618a.mo7891a() == fVar.mo7891a()) {
            this.f6618a = fVar;
            if (this.f6618a.mo7907g() == C2226b.FINISHED) {
                this.f6618a = null;
            }
            m10335a();
        }
        C2210a.m10144b(fVar);
    }

    /* renamed from: a */
    public void mo7984a(C2220c<C2223f> cVar) {
        C2210a.m10139a(cVar);
    }
}
