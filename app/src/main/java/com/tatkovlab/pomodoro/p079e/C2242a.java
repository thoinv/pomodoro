package com.tatkovlab.pomodoro.p079e;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tatkovlab.pomodoro.UpgradeToProActivity;

/* renamed from: com.tatkovlab.pomodoro.e.a */
public class C2242a {

    /* renamed from: a */
    private boolean f6585a = false;

    C2242a(boolean z) {
        if (z) {
            this.f6585a = true;
        }
    }

    /* renamed from: a */
    public boolean mo7937a() {
        return true;
    }

    /* renamed from: b */
    public void mo7938b() {
        this.f6585a = true;
    }

    /* renamed from: c */
    public boolean mo7940c() {
        return !mo7937a() && !this.f6585a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo7941d() {
        this.f6585a = true;
    }

    /* renamed from: a */
    public void mo7936a(Activity activity) {
        activity.startActivity(new Intent(activity, UpgradeToProActivity.class));
        this.f6585a = true;
    }

    /* renamed from: b */
    public void mo7939b(Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=com.tatkovlab.pomodoro"));
        activity.startActivity(intent);
    }
}
