package com.tatkovlab.pomodoro.p081g;

import com.tatkovlab.pomodoro.p077c.C2232f;

public interface C2271e {

    interface C2272a {
        void mo7946a();

        void mo7947b();
    }

    interface C2273b {
        void mo7802a();

        void mo7803a(int i);
    }

    enum C2274c {
        IDLE(1),
        POMODORO(2),
        SHORT_BREAK(3),
        LONG_BREAK(4);
        

        private int f6643e;

        C2274c(int i) {
            this.f6643e = i;
        }

        public int mo8007a() {
            return this.f6643e;
        }

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

    void mo7967a();

    void mo7968a(C2232f fVar, C2232f fVar2);

    void mo7969a(C2272a aVar);

    void mo7970a(C2273b bVar);

    void mo7971b();

    void mo7972b(int i);

    void mo7973c();

    void mo7974f();

    void mo7975g();

    C2274c mo7976h();

    C2274c mo7977i();

    int mo7978j();

    int mo7979k();
}
