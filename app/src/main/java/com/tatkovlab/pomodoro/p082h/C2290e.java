package com.tatkovlab.pomodoro.p082h;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tatkovlab.pomodoro.p078d.C2241e;

/* renamed from: com.tatkovlab.pomodoro.h.e */
public class C2290e {

    /* renamed from: a */
    private PomodoroTime pomodoroTime;

    /* renamed from: b */
    private int f6681b;

    /* renamed from: c */
    private int f6682c;

    /* renamed from: d */
    private ImageView f6683d;

    /* renamed from: e */
    private int f6684e;

    public C2290e(PomodoroTime dVar, ImageView imageView) {
        this.f6683d = imageView;
        mo8027a(dVar);
    }

    /* renamed from: a */
    public void mo8027a(PomodoroTime pomodoroTime) {
        this.pomodoroTime = pomodoroTime;
        this.f6683d.setImageResource(pomodoroTime.getTimeDrawableResId());
        this.f6683d.setLayoutParams(new LayoutParams(m10450c(pomodoroTime.mo8022b()), m10450c(pomodoroTime.mo8023c())));
        this.f6684e = C2241e.m10228a(this.f6683d.getContext()) / 2;
        this.f6681b = m10450c(pomodoroTime.mo8022b());
        this.f6682c = m10450c(pomodoroTime.mo8024d());
    }

    /* renamed from: a */
    public void mo8026a(int i) {
        m10449b((this.f6684e - this.f6682c) - ((int) ((((float) i) / ((float) this.pomodoroTime.mo8021a())) * ((float) (this.f6681b - (this.f6682c * 2))))));
    }

    /* renamed from: b */
    private void m10449b(int i) {
        MarginLayoutParams marginLayoutParams = new MarginLayoutParams(this.f6683d.getLayoutParams());
        marginLayoutParams.setMargins(i, 0, 0, 0);
        this.f6683d.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams));
    }

    /* renamed from: c */
    private int m10450c(int i) {
        return C2241e.m10229a(this.f6683d.getContext(), (float) i);
    }
}
