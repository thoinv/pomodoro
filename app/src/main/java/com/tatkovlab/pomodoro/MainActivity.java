package com.tatkovlab.pomodoro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodoro.p078d.C2238c;
import com.tatkovlab.pomodoro.p079e.C2242a;
import com.tatkovlab.pomodoro.p079e.C2245c;
import com.tatkovlab.pomodoro.p079e.C2245c.C2246a;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p081g.C2271e;
import com.tatkovlab.pomodoro.p081g.C2271e.C2273b;
import com.tatkovlab.pomodoro.p081g.C2271e.C2274c;
import com.tatkovlab.pomodoro.p082h.C2280a;
import com.tatkovlab.pomodoro.p082h.C2285b;
import com.tatkovlab.pomodoro.p082h.C2285b.C2286a;
import com.tatkovlab.pomodoro.p082h.C2287c;
import com.tatkovlab.pomodoro.p082h.PomodoroTime;
import com.tatkovlab.pomodoro.p082h.C2290e;
import com.tatkovlab.pomodoro.p083i.C2291a;
import com.tatkovlab.pomodoro.p083i.PrefManager;
import com.tatkovlab.pomodorolite.R;

public class MainActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C2290e f6406j;

    /* renamed from: k */
    private C2285b f6407k;
    /* access modifiers changed from: private */

    /* renamed from: m */
    private Button btStartPomodoro;

    /* renamed from: n */
    private Button btCancelPomodoro;

    /* renamed from: o */
    private Button btSkipBreak;

    /* renamed from: p */
    private TextView tvTaskName;

    /* renamed from: q */
    private ViewGroup layoutCompletedTicks;

    /* renamed from: r */
    private String f6414r;
    private MaterialDialog f6408l;

    /* renamed from: t */
    private void m10034t() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!PrefManager.getValue(PrefManager.WAS_WELCOME_SCREEN_SHOWN)) {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        this.f6414r = C2238c.m10225b();
        this.f6407k = new C2285b(this);
        m10030p();
        m10028n();
        m10026l();
        m10032r();
        m10034t();
        C2291a.m10456b(this);
        C2242a h = C2250f.m10263a().mo7966h();
        if (h.mo7940c()) {
            h.mo7936a(this);
        }
    }

    public void onDestroy() {
        m10033s().mo7970a(null);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m10031q();
        m10027m();
        m10025k();
    }

    /* renamed from: k */
    private void m10025k() {
        if (!this.f6414r.equals(C2238c.m10225b())) {
            new Handler().post(new Runnable() {
                public void run() {
                    MainActivity.this.recreate();
                }
            });
        }
    }

    /* renamed from: a */
    private void m10019a(boolean z) {
        if (z || !PrefManager.getValue(PrefManager.keepScreenOnTag)) {
            getWindow().clearFlags(128);
        } else {
            getWindow().addFlags(128);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.f6408l != null && this.f6408l.isShowing()) {
            this.f6408l.dismiss();
            this.f6408l = null;
        }
    }

    /* renamed from: l */
    @SuppressLint("WrongConstant")
    private void m10026l() {
        this.btStartPomodoro = findViewById(R.id.button_start_pomodoro);
        FontHelper.setTypeface(this.btStartPomodoro, Fonts.LATO_BOLD);
        this.btStartPomodoro.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2250f.m10263a().mo7962d().mo7967a();
                MainActivity.this.m10027m();
            }
        });
        this.btCancelPomodoro = findViewById(R.id.button_cancel_pomodoro);
        FontHelper.setTypeface(this.btCancelPomodoro, Fonts.LATO_BOLD);
        this.btCancelPomodoro.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.m10033s().mo7971b();
                MainActivity.this.m10027m();
            }
        });
        this.btSkipBreak = findViewById(R.id.button_skip_break);
        FontHelper.setTypeface(this.btSkipBreak, Fonts.LATO_BOLD);
        this.btSkipBreak.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.m10033s().mo7975g();
                MainActivity.this.m10027m();
            }
        });
        findViewById(R.id.button_settings).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        View findViewById = findViewById(R.id.button_stats);
        if (C2250f.m10263a().mo7966h().mo7937a()) {
            findViewById.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, StatsActivity.class));
                }
            });
        } else {
            findViewById.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    @SuppressLint("WrongConstant")
    public void m10027m() {
        C2274c h = m10033s().mo7976h();
        if (h == C2274c.IDLE) {
            C2274c i = m10033s().mo7977i();
            if (i == C2274c.POMODORO) {
                this.btStartPomodoro.setVisibility(0);
                this.btCancelPomodoro.setVisibility(8);
                this.btSkipBreak.setVisibility(8);
                this.f6407k.mo8017a(C2286a.RED);
            } else if (i == C2274c.SHORT_BREAK) {
                m10021b(true);
            } else if (i == C2274c.LONG_BREAK) {
                m10021b(false);
            }
            m10019a(true);
        } else {
            if (h == C2274c.POMODORO) {
                this.btStartPomodoro.setVisibility(8);
                this.btCancelPomodoro.setVisibility(0);
                this.btSkipBreak.setVisibility(8);
                this.f6407k.mo8017a(C2286a.RED);
            } else if (h == C2274c.SHORT_BREAK || h == C2274c.LONG_BREAK) {
                this.btStartPomodoro.setVisibility(8);
                this.btCancelPomodoro.setVisibility(8);
                this.btSkipBreak.setVisibility(0);
                this.f6407k.mo8017a(C2286a.GREEN);
            }
            m10019a(false);
        }
        this.f6406j.mo8026a(m10033s().mo7978j());
    }

    /* renamed from: n */
    private void m10028n() {
        this.layoutCompletedTicks = findViewById(R.id.box_completed_pomodoros_indicator);
        this.tvTaskName = findViewById(R.id.task_name_text);
        FontHelper.setTypeface(this.tvTaskName, Fonts.PANGOLIN_REGULAR);
        findViewById(R.id.note_background).setOnClickListener(new C2287c());
        C2250f.m10263a().mo7963e().mo7943a(new C2246a() {
            /* renamed from: a */
            public void mo7801a() {
                MainActivity.this.m10029o();
            }
        });
        m10029o();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m10029o() {
        C2245c e = C2250f.m10263a().mo7963e();
        if (e.getCurrentTaskName() == null) {
            this.tvTaskName.setText(R.string.no_task_placeholder);
            m10017a(this.layoutCompletedTicks, 0);
            return;
        }
        this.tvTaskName.setText(e.getCurrentTaskName());
        m10017a(this.layoutCompletedTicks, e.mo7945b());
    }

    /* renamed from: a */
    private void m10017a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildCount() != i) {
            this.layoutCompletedTicks.removeAllViews();
            for (int i2 = 0; i2 < i; i2++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.ic_done);
                this.layoutCompletedTicks.addView(imageView);
            }
        }
    }

    /* renamed from: p */
    private void m10030p() {
        this.f6406j = new C2290e(PomodoroTime.MINUTES_25, (ImageView) findViewById(R.id.time_line));
    }

    /* renamed from: q */
    private void m10031q() {
        this.f6406j.mo8027a(PomodoroTime.m10443a(m10033s().mo7979k()));
    }

    /* renamed from: r */
    private void m10032r() {
        m10033s().mo7970a(new C2273b() {
            /* renamed from: a */
            public void mo7802a() {
                MainActivity.this.m10027m();
            }

            /* renamed from: a */
            public void mo7803a(int i) {
                MainActivity.this.f6406j.mo8026a(i);
            }
        });
    }

    /* renamed from: b */
    private void m10021b(boolean z) {
        if (this.f6408l == null || !this.f6408l.isShowing()) {
            this.f6408l = new MaterialDialog.Builder(this).customView(R.layout.pop_up_time_for_break, true)
                    .theme(Theme.LIGHT).build();
            new C2280a(this.f6408l.getView(), z, new C2280a.C2284a() {
                /* renamed from: a */
                public void mo7804a() {
                    MainActivity.this.m10033s().mo7973c();
                    MainActivity.this.m10027m();
                    MainActivity.this.f6408l.dismiss();
                }

                /* renamed from: b */
                public void mo7805b() {
                    MainActivity.this.m10033s().mo7974f();
                    MainActivity.this.m10027m();
                    MainActivity.this.f6408l.dismiss();
                }

                /* renamed from: c */
                public void mo7806c() {
                    MainActivity.this.m10033s().mo7975g();
                    MainActivity.this.m10027m();
                    MainActivity.this.f6408l.dismiss();
                }
            });
        }
        this.f6408l.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public C2271e m10033s() {
        return C2250f.m10263a().mo7962d();
    }
}
