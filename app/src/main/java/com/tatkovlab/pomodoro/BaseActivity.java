package com.tatkovlab.pomodoro;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.tatkovlab.pomodoro.p078d.C2238c;
import java.util.Locale;

public class BaseActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    private void init() {
        if (C2238c.m10223a()) {
            Resources resources = getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = new Locale(C2238c.m10225b());
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
