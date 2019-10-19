package com.tatkovlab.pomodoro.p081g;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tatkovlab.pomodoro.g.h */
public class C2279h {

    /* renamed from: a */
    Map<String, C2268b> f6653a = new HashMap();

    /* renamed from: b */
    C2269c f6654b;

    /* renamed from: c */
    private boolean f6655c = false;

    /* renamed from: d */
    private Context f6656d;

    public C2279h(Context context, C2269c cVar) {
        this.f6656d = context;
        this.f6654b = cVar;
    }

    /* renamed from: a */
    public void mo8012a(C2270d dVar, int i) {
        if (!this.f6653a.containsKey(dVar.mo7930a())) {
            C2268b a = this.f6654b.mo8006a(this.f6656d, dVar.mo7931b(), dVar.mo7932c());
            a.mo8003a(i);
            this.f6653a.put(dVar.mo7930a(), a);
            if (this.f6655c) {
                a.mo8002a();
            }
        }
    }

    /* renamed from: a */
    public void mo8011a(C2270d dVar) {
        if (this.f6653a.containsKey(dVar.mo7930a())) {
            this.f6653a.remove(dVar.mo7930a()).mo8005b();
        }
    }

    /* renamed from: a */
    public void mo8009a() {
        this.f6655c = true;
        for (C2268b a : this.f6653a.values()) {
            a.mo8002a();
        }
    }

    /* renamed from: a */
    public void mo8010a(long j) {
        this.f6655c = false;
        for (C2268b a : this.f6653a.values()) {
            a.mo8004a(j);
        }
        this.f6653a = null;
    }

    /* renamed from: a */
    public void mo8013a(String str, int i) {
        C2268b bVar = this.f6653a.get(str);
        if (bVar != null) {
            bVar.mo8003a(i);
        }
    }
}
