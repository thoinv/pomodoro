package com.tatkovlab.pomodoro.p082h;

import android.view.View;
import android.view.View.OnClickListener;
import com.afollestad.materialdialogs.C1169f;
import com.afollestad.materialdialogs.C1169f.C1174a;
import com.afollestad.materialdialogs.C1169f.C1177d;
import com.afollestad.materialdialogs.C1194i;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.h.c */
public class C2287c implements OnClickListener {
    public void onClick(View view) {
        new C1174a(view.getContext()).mo5477a((int) R.string.add_task_dialog_header).mo5507k(16384).mo5506j(R.color.dark_brown).mo5496c((int) R.color.dark_brown).mo5503g(R.color.dark_brown).mo5487a(C1194i.LIGHT).mo5502f(R.string.save).mo5478a(1, 50).mo5480a((int) R.string.add_task_dialog_hint, 0, (C1177d) new C1177d() {
            /* renamed from: a */
            public void mo5517a(C1169f fVar, CharSequence charSequence) {
                C2250f.m10263a().mo7963e().mo7944a(charSequence.toString(), 0);
            }
        }).mo5498c();
    }
}
