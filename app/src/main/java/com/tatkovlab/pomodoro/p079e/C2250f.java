package com.tatkovlab.pomodoro.p079e;

import android.content.Context;
import com.tatkovlab.pomodoro.p081g.C2271e;

/* renamed from: com.tatkovlab.pomodoro.e.f */
public class C2250f {

    /* renamed from: a */
    private static C2250f instance = null;

    /* renamed from: j */
    private static boolean f6591j = false;

    /* renamed from: b */
    private Context context;

    /* renamed from: c */
    private C2248e f6593c = null;

    /* renamed from: d */
    private C2247d f6594d = null;

    /* renamed from: e */
    private C2271e f6595e;

    /* renamed from: f */
    private C2245c f6596f;

    /* renamed from: g */
    private C2258j f6597g;

    /* renamed from: h */
    private C2255i f6598h;

    /* renamed from: i */
    private C2242a f6599i;

    private C2250f(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public static void get(Context context, boolean z) {
        if (instance == null) {
            f6591j = z;
            instance = new C2250f(context);
            instance.mo7962d();
            instance.mo7961c();
            instance.getInstance();
            instance.mo7963e();
            instance.mo7964f();
            instance.mo7965g();
            return;
        }
        throw new RuntimeException("Modules manager already installed.");
    }

    /* renamed from: a */
    public static C2250f m10263a() {
        if (instance != null) {
            return instance;
        }
        throw new RuntimeException("Modules manager must be installed before this method can be called.");
    }

    /* renamed from: b */
    public C2248e mo7960b() {
        if (this.f6593c == null) {
            this.f6593c = new C2261k(this.context);
        }
        return this.f6593c;
    }

    /* renamed from: c */
    public C2247d mo7961c() {
        if (this.f6594d == null) {
            this.f6594d = new C2254h(this.context);
        }
        return this.f6594d;
    }

    /* renamed from: d */
    public C2271e mo7962d() {
        if (this.f6595e == null) {
            this.f6595e = new C2251g(this.context);
        }
        return this.f6595e;
    }

    /* renamed from: e */
    public C2245c mo7963e() {
        if (this.f6596f == null) {
            this.f6596f = new C2243b();
        }
        return this.f6596f;
    }

    /* renamed from: f */
    public C2258j mo7964f() {
        if (!getInstance().mo7937a()) {
            return null;
        }
        if (this.f6597g == null) {
            this.f6597g = new C2258j(this.context);
        }
        return this.f6597g;
    }

    /* renamed from: g */
    public C2255i mo7965g() {
        if (!getInstance().mo7937a()) {
            return null;
        }
        if (this.f6598h == null) {
            this.f6598h = new C2255i();
        }
        return this.f6598h;
    }

    public C2242a getInstance() {
        if (this.f6599i == null) {
            this.f6599i = new C2242a(f6591j);
        }
        return this.f6599i;
    }
}
