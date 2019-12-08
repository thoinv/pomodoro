package com.tatkovlab.pomodoro;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

import com.tatkovlab.pomodoro.p078d.C2238c;
import java.util.Locale;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        updateConfiguration();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initViews();
    }

    protected abstract void initViews();

    public abstract int getLayoutId();

    private void updateConfiguration() {
        if (C2238c.m10223a()) {
            Resources resources = getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = new Locale(C2238c.m10225b());
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
