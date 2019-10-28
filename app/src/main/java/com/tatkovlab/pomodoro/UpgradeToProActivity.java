package com.tatkovlab.pomodoro;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodorolite.R;

public class UpgradeToProActivity extends BaseActivity {

    private static final int[] labels = {R.id.label_top_header, R.id.label_app_name, R.id.label_tasks, R.id.label_stats, R.id.label_support};

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upgrade_to_pro);
        m10115k();
        m10116l();
    }

    /* renamed from: k */
    private void m10115k() {
        for (int findViewById : labels) {
            FontHelper.setTypeface((TextView) findViewById(findViewById), Fonts.LATO_BOLD);
        }
    }

    /* renamed from: l */
    private void m10116l() {
        Button button = findViewById(R.id.button_upgrade_to_premium);
        FontHelper.setTypeface(button, Fonts.LATO_BOLD);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2250f.m10263a().getInstance().mo7939b(UpgradeToProActivity.this);
            }
        });
        Button button2 = findViewById(R.id.button_maybe_later);
        FontHelper.setTypeface(button2, Fonts.LATO_BOLD);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                UpgradeToProActivity.this.onBackPressed();
            }
        });
    }
}
