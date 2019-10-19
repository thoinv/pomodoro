package com.tatkovlab.pomodoro;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

import com.tatkovlab.pomodoro.p078d.C2238c;
import java.util.Locale;

public class C2204a extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10121k();
    }

    /* renamed from: k */
    private void m10121k() {
        if (C2238c.m10223a()) {
            Resources resources = getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = new Locale(C2238c.m10225b());
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
