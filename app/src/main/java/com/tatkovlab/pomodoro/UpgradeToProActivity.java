package com.tatkovlab.pomodoro;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p078d.C2236b;
import com.tatkovlab.pomodoro.p078d.C2236b.C2237a;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodorolite.R;

public class UpgradeToProActivity extends C2204a {

    /* renamed from: j */
    private static final int[] f6480j = {R.id.label_top_header, R.id.label_app_name, R.id.label_tasks, R.id.label_stats, R.id.label_support};

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_upgrade_to_pro);
        m10115k();
        m10116l();
    }

    /* renamed from: k */
    private void m10115k() {
        for (int findViewById : f6480j) {
            C2236b.m10219a((TextView) findViewById(findViewById), C2237a.LATO_BOLD);
        }
    }

    /* renamed from: l */
    private void m10116l() {
        Button button = (Button) findViewById(R.id.button_upgrade_to_premium);
        C2236b.m10219a((TextView) button, C2237a.LATO_BOLD);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2250f.m10263a().mo7966h().mo7939b(UpgradeToProActivity.this);
            }
        });
        Button button2 = (Button) findViewById(R.id.button_maybe_later);
        C2236b.m10219a((TextView) button2, C2237a.LATO_BOLD);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                UpgradeToProActivity.this.onBackPressed();
            }
        });
    }
}
