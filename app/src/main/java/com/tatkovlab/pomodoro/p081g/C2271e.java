package com.tatkovlab.pomodoro.p081g;

import com.tatkovlab.pomodoro.p077c.C2232f;

/* renamed from: com.tatkovlab.pomodoro.g.e */
public interface C2271e {

    /* renamed from: com.tatkovlab.pomodoro.g.e$a */
    public interface C2272a {
        /* renamed from: a */
        void mo7946a();

        /* renamed from: b */
        void mo7947b();
    }

    /* renamed from: com.tatkovlab.pomodoro.g.e$b */
    public interface C2273b {
        /* renamed from: a */
        void mo7802a();

        /* renamed from: a */
        void mo7803a(int i);
    }

    /* renamed from: com.tatkovlab.pomodoro.g.e$c */
    public enum C2274c {
        IDLE(1),
        POMODORO(2),
        SHORT_BREAK(3),
        LONG_BREAK(4);
        

        /* renamed from: e */
        private int f6643e;

        private C2274c(int i) {
            this.f6643e = i;
        }

        /* renamed from: a */
        public int mo8007a() {
            return this.f6643e;
        }

        /* renamed from: a */
        public static C2274c m10408a(int i) {
            C2274c[] values;
            C2274c cVar = IDLE;
            for (C2274c cVar2 : values()) {
                if (cVar2.mo8007a() == i) {
                    return cVar2;
                }
            }
            return cVar;
        }
    }

    /* renamed from: a */
    void mo7967a();

    /* renamed from: a */
    void mo7968a(C2232f fVar, C2232f fVar2);

    /* renamed from: a */
    void mo7969a(C2272a aVar);

    /* renamed from: a */
    void mo7970a(C2273b bVar);

    /* renamed from: b */
    void mo7971b();

    /* renamed from: b */
    void mo7972b(int i);

    /* renamed from: c */
    void mo7973c();

    /* renamed from: f */
    void mo7974f();

    /* renamed from: g */
    void mo7975g();

    /* renamed from: h */
    C2274c mo7976h();

    /* renamed from: i */
    C2274c mo7977i();

    /* renamed from: j */
    int mo7978j();

    /* renamed from: k */
    int mo7979k();
}
