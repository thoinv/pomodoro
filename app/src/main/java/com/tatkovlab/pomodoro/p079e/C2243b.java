package com.tatkovlab.pomodoro.p079e;

import com.tatkovlab.pomodoro.p079e.C2245c.C2246a;
import com.tatkovlab.pomodoro.p081g.C2271e.C2272a;
import com.tatkovlab.pomodoro.p083i.C2295b;

/* renamed from: com.tatkovlab.pomodoro.e.b */
public class C2243b implements C2245c {

    /* renamed from: a */
    private String f6586a = ((String) C2295b.m10458a(C2295b.f6701m));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f6587b = ((Integer) C2295b.m10458a(C2295b.f6702n)).intValue();

    /* renamed from: c */
    private C2246a f6588c;

    public C2243b() {
        C2250f.m10263a().mo7962d().mo7969a((C2272a) new C2272a() {
            /* renamed from: a */
            public void mo7946a() {
                C2243b.this.f6587b = C2243b.this.f6587b + 1;
                C2295b.m10461a(C2295b.f6702n, Integer.valueOf(C2243b.this.f6587b));
                C2243b.this.m10238c();
            }

            /* renamed from: b */
            public void mo7947b() {
                C2243b.this.m10238c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10238c() {
        if (this.f6588c != null) {
            this.f6588c.mo7801a();
        }
    }

    /* renamed from: a */
    public String mo7942a() {
        return this.f6586a;
    }

    /* renamed from: a */
    public void mo7944a(String str, int i) {
        this.f6586a = str;
        this.f6587b = i;
        C2295b.m10461a(C2295b.f6701m, str);
        C2295b.m10461a(C2295b.f6702n, Integer.valueOf(0));
        m10238c();
    }

    /* renamed from: b */
    public int mo7945b() {
        return this.f6587b;
    }

    /* renamed from: a */
    public void mo7943a(C2246a aVar) {
        this.f6588c = aVar;
    }
}
