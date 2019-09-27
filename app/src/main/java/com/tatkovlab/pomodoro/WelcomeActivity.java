package com.tatkovlab.pomodoro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p078d.C2236b;
import com.tatkovlab.pomodoro.p078d.C2236b.C2237a;
import com.tatkovlab.pomodoro.p078d.C2238c;
import com.tatkovlab.pomodoro.p078d.C2240d;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p083i.C2295b;
import com.tatkovlab.pomodorolite.R;

public class WelcomeActivity extends C2204a {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_welcome);
        m10117k();
        m10118l();
        m10119m();
        m10120n();
    }

    /* renamed from: k */
    private void m10117k() {
        C2237a aVar = C2237a.LATO_BOLD;
        C2236b.m10219a((TextView) findViewById(R.id.label_below_logo), aVar);
        C2236b.m10219a((TextView) findViewById(R.id.label_top_header), aVar);
        C2236b.m10219a((TextView) findViewById(R.id.eula_link), aVar);
    }

    /* renamed from: l */
    private void m10118l() {
        Button button = (Button) findViewById(R.id.btn_start);
        C2236b.m10219a((TextView) button, C2237a.LATO_BOLD);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2295b.m10461a(C2295b.f6708t, Boolean.valueOf(true));
                C2250f.m10263a().mo7966h().mo7938b();
                WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();
            }
        });
    }

    /* renamed from: m */
    private void m10119m() {
        Button button = (Button) findViewById(R.id.btn_language);
        button.setText(getResources().getString(C2238c.m10226c()));
        C2236b.m10219a((TextView) button, C2237a.LATO_BOLD);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2238c.m10221a((Activity) WelcomeActivity.this);
            }
        });
    }

    /* renamed from: n */
    private void m10120n() {
        TextView textView = (TextView) findViewById(R.id.eula_link);
        C2236b.m10219a(textView, C2237a.LATO_BOLD);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2240d.m10227a("http://www.relaxio.net/terms-of-use-pomodoro-timer.html", WelcomeActivity.this);
            }
        });
    }
}
