package com.tatkovlab.pomodoro.p079e;

import android.annotation.SuppressLint;

import com.tatkovlab.pomodoro.p076b.C2210a;
import com.tatkovlab.pomodoro.p076b.C2221d;
import com.tatkovlab.pomodoro.p077c.C2228b;
import com.tatkovlab.pomodoro.p077c.C2233g;
import com.tatkovlab.pomodoro.p077c.C2234h;
import com.tatkovlab.pomodoro.p078d.C2235a;
import com.tatkovlab.pomodoro.p081g.C2271e.C2272a;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.tatkovlab.pomodoro.e.i */
public class C2255i {
    C2255i() {
        C2250f.m10263a().mo7962d().mo7969a((C2272a) new C2272a() {
            /* renamed from: b */
            public void mo7947b() {
            }

            /* renamed from: a */
            public void mo7946a() {
                C2210a.m10137a(System.currentTimeMillis());
            }
        });
    }

    /* renamed from: a */
    public void mo7982a(final C2221d<C2233g> dVar) {
        C2210a.m10142a(m10327a(), new C2221d<C2234h>() {
            /* renamed from: a */
            public void mo7844a(C2234h hVar) {
                dVar.mo7844a(C2255i.this.m10325a(hVar));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C2233g m10325a(C2234h hVar) {
        C2233g gVar = new C2233g();
        List<Long> list = hVar.f6575a;
        gVar.f6567a = ((Long) list.get(0)).longValue();
        gVar.f6568b = ((Long) list.get(1)).longValue();
        gVar.f6569c = ((Long) list.get(2)).longValue();
        gVar.f6570d = ((Long) hVar.f6575a.get(3)).longValue();
        gVar.f6571e = ((Long) hVar.f6575a.get(4)).longValue();
        gVar.f6572f = ((Long) hVar.f6575a.get(5)).longValue();
        gVar.f6573g = ((Long) hVar.f6575a.get(6)).longValue();
        gVar.f6574h = hVar.f6576b;
        return gVar;
    }

    /* renamed from: a */
    @SuppressLint("WrongConstant")
    private C2228b[] m10327a() {
        Calendar a = C2235a.m10217a();
        Calendar instance = Calendar.getInstance();
        C2228b bVar = new C2228b(a, instance);
        Calendar calendar = (Calendar) a.clone();
        calendar.add(6, -1);
        C2228b bVar2 = new C2228b(calendar, a);
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(6, -7);
        Calendar calendar3 = (Calendar) calendar2.clone();
        calendar3.add(6, 1);
        C2228b bVar3 = new C2228b(calendar2, calendar3);
        Calendar calendar4 = (Calendar) a.clone();
        calendar4.set(5, 1);
        C2228b bVar4 = new C2228b(calendar4, instance);
        Calendar calendar5 = (Calendar) calendar4.clone();
        calendar5.add(2, -1);
        Calendar calendar6 = (Calendar) instance.clone();
        calendar6.add(2, -1);
        calendar6.set(11, 23);
        calendar6.set(12, 59);
        calendar6.set(13, 59);
        C2228b bVar5 = new C2228b(calendar5, calendar6);
        C2228b bVar6 = new C2228b(calendar5, calendar4);
        Calendar calendar7 = (Calendar) calendar5.clone();
        calendar7.add(2, -1);
        return new C2228b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, new C2228b(calendar7, calendar5)};
    }
}