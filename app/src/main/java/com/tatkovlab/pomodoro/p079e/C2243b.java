package com.tatkovlab.pomodoro.p079e;

import com.tatkovlab.pomodoro.p081g.C2271e.C2272a;
import com.tatkovlab.pomodoro.p083i.PrefManager;

/* renamed from: com.tatkovlab.pomodoro.e.b */
public class C2243b implements C2245c {

    /* renamed from: a */
    private String currentTaskName = PrefManager.getValue(PrefManager.CURRENT_TASK_NAME);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int currentTaskCount = PrefManager.getValue(PrefManager.CURRENT_TASK_COUNT);

    /* renamed from: c */
    private C2246a f6588c;

    public C2243b() {
        C2250f.m10263a().mo7962d().mo7969a(new C2272a() {
            /* renamed from: a */
            public void mo7946a() {
                C2243b.this.currentTaskCount = C2243b.this.currentTaskCount + 1;
                PrefManager.save(PrefManager.CURRENT_TASK_COUNT, C2243b.this.currentTaskCount);
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
    public String getCurrentTaskName() {
        return this.currentTaskName;
    }

    /* renamed from: a */
    public void mo7944a(String currentTaskName, int currentTaskCount) {
        this.currentTaskName = currentTaskName;
        this.currentTaskCount = currentTaskCount;
        PrefManager.save(PrefManager.CURRENT_TASK_NAME, currentTaskName);
        PrefManager.save(PrefManager.CURRENT_TASK_COUNT, 0);
        m10238c();
    }

    /* renamed from: b */
    public int mo7945b() {
        return this.currentTaskCount;
    }

    /* renamed from: a */
    public void mo7943a(C2246a aVar) {
        this.f6588c = aVar;
    }
}
