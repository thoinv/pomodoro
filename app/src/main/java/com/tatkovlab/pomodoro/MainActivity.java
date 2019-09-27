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
import com.afollestad.materialdialogs.C1169f;
import com.afollestad.materialdialogs.C1169f.C1174a;
import com.afollestad.materialdialogs.C1194i;
import com.tatkovlab.pomodoro.p078d.C2236b;
import com.tatkovlab.pomodoro.p078d.C2236b.C2237a;
import com.tatkovlab.pomodoro.p078d.C2238c;
import com.tatkovlab.pomodoro.p079e.C2242a;
import com.tatkovlab.pomodoro.p079e.C2245c;
import com.tatkovlab.pomodoro.p079e.C2245c.C2246a;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p081g.C2271e;
import com.tatkovlab.pomodoro.p081g.C2271e.C2273b;
import com.tatkovlab.pomodoro.p081g.C2271e.C2274c;
import com.tatkovlab.pomodoro.p082h.C2280a;
import com.tatkovlab.pomodoro.p082h.C2280a.C2284a;
import com.tatkovlab.pomodoro.p082h.C2285b;
import com.tatkovlab.pomodoro.p082h.C2285b.C2286a;
import com.tatkovlab.pomodoro.p082h.C2287c;
import com.tatkovlab.pomodoro.p082h.C2289d;
import com.tatkovlab.pomodoro.p082h.C2290e;
import com.tatkovlab.pomodoro.p083i.C2291a;
import com.tatkovlab.pomodoro.p083i.C2295b;
import com.tatkovlab.pomodorolite.R;

public class MainActivity extends C2204a {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C2290e f6406j;

    /* renamed from: k */
    private C2285b f6407k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C1169f f6408l;

    /* renamed from: m */
    private Button f6409m;

    /* renamed from: n */
    private Button f6410n;

    /* renamed from: o */
    private Button f6411o;

    /* renamed from: p */
    private TextView f6412p;

    /* renamed from: q */
    private ViewGroup f6413q;

    /* renamed from: r */
    private String f6414r;

    /* renamed from: t */
    private void m10034t() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!((Boolean) C2295b.m10458a(C2295b.f6708t)).booleanValue()) {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
            return;
        }
        setContentView((int) R.layout.activity_main);
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
        m10033s().mo7970a((C2273b) null);
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
        if (z || !((Boolean) C2295b.m10458a(C2295b.f6695g)).booleanValue()) {
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
    private void m10026l() {
        this.f6409m = (Button) findViewById(R.id.button_start_pomodoro);
        C2236b.m10219a((TextView) this.f6409m, C2237a.LATO_BOLD);
        this.f6409m.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2250f.m10263a().mo7962d().mo7967a();
                MainActivity.this.m10027m();
            }
        });
        this.f6410n = (Button) findViewById(R.id.button_cancel_pomodoro);
        C2236b.m10219a((TextView) this.f6410n, C2237a.LATO_BOLD);
        this.f6410n.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.m10033s().mo7971b();
                MainActivity.this.m10027m();
            }
        });
        this.f6411o = (Button) findViewById(R.id.button_skip_break);
        C2236b.m10219a((TextView) this.f6411o, C2237a.LATO_BOLD);
        this.f6411o.setOnClickListener(new OnClickListener() {
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
                this.f6409m.setVisibility(0);
                this.f6410n.setVisibility(8);
                this.f6411o.setVisibility(8);
                this.f6407k.mo8017a(C2286a.RED);
            } else if (i == C2274c.SHORT_BREAK) {
                m10021b(true);
            } else if (i == C2274c.LONG_BREAK) {
                m10021b(false);
            }
            m10019a(true);
        } else {
            if (h == C2274c.POMODORO) {
                this.f6409m.setVisibility(8);
                this.f6410n.setVisibility(0);
                this.f6411o.setVisibility(8);
                this.f6407k.mo8017a(C2286a.RED);
            } else if (h == C2274c.SHORT_BREAK || h == C2274c.LONG_BREAK) {
                this.f6409m.setVisibility(8);
                this.f6410n.setVisibility(8);
                this.f6411o.setVisibility(0);
                this.f6407k.mo8017a(C2286a.GREEN);
            }
            m10019a(false);
        }
        this.f6406j.mo8026a(m10033s().mo7978j());
    }

    /* renamed from: n */
    private void m10028n() {
        this.f6413q = (ViewGroup) findViewById(R.id.box_completed_pomodoros_indicator);
        this.f6412p = (TextView) findViewById(R.id.task_name_text);
        C2236b.m10219a(this.f6412p, C2237a.PANGOLIN_REGULAR);
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
        if (e.mo7942a() == null) {
            this.f6412p.setText(R.string.no_task_placeholder);
            m10017a(this.f6413q, 0);
            return;
        }
        this.f6412p.setText(e.mo7942a());
        m10017a(this.f6413q, e.mo7945b());
    }

    /* renamed from: a */
    private void m10017a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildCount() != i) {
            this.f6413q.removeAllViews();
            for (int i2 = 0; i2 < i; i2++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.ic_done);
                this.f6413q.addView(imageView);
            }
        }
    }

    /* renamed from: p */
    private void m10030p() {
        this.f6406j = new C2290e(C2289d.MINUTES_25, (ImageView) findViewById(R.id.time_line));
    }

    /* renamed from: q */
    private void m10031q() {
        this.f6406j.mo8027a(C2289d.m10443a(m10033s().mo7979k()));
    }

    /* renamed from: r */
    private void m10032r() {
        m10033s().mo7970a((C2273b) new C2273b() {
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
            this.f6408l = new C1174a(this).mo5482a((int) R.layout.pop_up_time_for_break, true).mo5487a(C1194i.LIGHT).mo5491a(false).mo5498c();
            new C2280a(this.f6408l.mo5464f(), z, new C2284a() {
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
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public C2271e m10033s() {
        return C2250f.m10263a().mo7962d();
    }
}
