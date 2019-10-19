package com.tatkovlab.pomodoro.p082h;

import android.app.Activity;
import android.view.View;
import com.tatkovlab.pomodoro.p083i.C2297c;
import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.h.b */
public class C2285b {

    /* renamed from: a */
    private Activity f6665a;

    /* renamed from: b */
    private View f6666b;

    /* renamed from: com.tatkovlab.pomodoro.h.b$a */
    public enum C2286a {
        RED(R.drawable.bg_gradient_red, R.color.status_bar_red),
        GREEN(R.drawable.bg_gradient_green, R.color.status_bar_green);
        

        /* renamed from: c */
        private int f6670c;

        /* renamed from: d */
        private int f6671d;

        C2286a(int i, int i2) {
            this.f6670c = i;
            this.f6671d = i2;
        }

        /* renamed from: a */
        public int mo8018a() {
            return this.f6670c;
        }

        /* renamed from: b */
        public int mo8019b() {
            return this.f6671d;
        }
    }

    public C2285b(Activity activity) {
        this.f6665a = activity;
        this.f6666b = activity.findViewById(R.id.root_view);
    }

    /* renamed from: a */
    public void mo8017a(C2286a aVar) {
        this.f6666b.setBackgroundResource(aVar.mo8018a());
        C2297c.m10467a(this.f6665a, this.f6665a.getResources().getColor(aVar.mo8019b()));
    }
}
