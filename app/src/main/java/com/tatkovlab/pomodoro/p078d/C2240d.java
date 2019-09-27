package com.tatkovlab.pomodoro.p078d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: com.tatkovlab.pomodoro.d.d */
public class C2240d {
    /* renamed from: a */
    public static void m10227a(String str, Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
