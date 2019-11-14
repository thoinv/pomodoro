package com.tatkovlab.pomodoro.p078d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class C2240d {
    public static void m10227a(String str, Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
