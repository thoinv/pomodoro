package com.tatkovlab.pomodoro;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.p031v4.p032a.C0447a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p077c.C2232f;
import com.tatkovlab.pomodoro.p078d.C2236b;
import com.tatkovlab.pomodoro.p078d.C2236b.C2237a;
import com.tatkovlab.pomodoro.p078d.C2238c;
import com.tatkovlab.pomodoro.p078d.C2240d;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p083i.C2295b;
import com.tatkovlab.pomodoro.p083i.C2295b.C2296a;
import com.tatkovlab.pomodorolite.R;

public class SettingsActivity extends C2204a {

    /* renamed from: j */
    private int[] f6426j = {R.id.label_ringing_volume, R.id.label_ticking_volume, R.id.label_short_break_duration, R.id.label_long_break_duration, R.id.label_pomodoro_duration, R.id.label_pomodoro_duration_below, R.id.label_ringing_sound, R.id.label_ticking_sound, R.id.label_language, R.id.language_button, R.id.terms_of_use, R.id.privacy_policy};

    /* renamed from: com.tatkovlab.pomodoro.SettingsActivity$a */
    private interface C2186a {
        /* renamed from: a */
        void mo7814a(int i);
    }

    /* renamed from: com.tatkovlab.pomodoro.SettingsActivity$b */
    private interface C2187b {
        /* renamed from: a */
        void mo7820a();
    }

    /* renamed from: com.tatkovlab.pomodoro.SettingsActivity$c */
    private static class C2188c extends ArrayAdapter<String> {

        /* renamed from: a */
        private static final C2237a f6456a = C2237a.LATO_BOLD;

        /* renamed from: b */
        private int f6457b;

        private C2188c(Context context, int i, int i2) {
            this(context, i, context.getResources().getStringArray(i2));
        }

        private C2188c(Context context, int i, String[] strArr) {
            super(context, i, strArr);
            this.f6457b = C0447a.m1731c(context, R.color.dark_brown);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getView(i, view, viewGroup);
            C2236b.m10219a(textView, f6456a);
            return textView;
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
            C2236b.m10219a(textView, f6456a);
            textView.setTextColor(this.f6457b);
            return textView;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_settings);
        m10050k();
        m10051l();
        m10052m();
        m10053n();
        m10054o();
        m10055p();
        m10058s();
        m10056q();
        m10059t();
    }

    /* renamed from: k */
    private void m10050k() {
        C2236b.m10219a((TextView) findViewById(R.id.text_header), C2237a.LATO_BOLD);
    }

    /* renamed from: l */
    private void m10051l() {
        for (int findViewById : this.f6426j) {
            C2236b.m10219a((TextView) findViewById(findViewById), C2237a.LATO_BOLD);
        }
    }

    /* renamed from: m */
    private void m10052m() {
        SeekBar seekBar = (SeekBar) findViewById(R.id.volume_bar_ringing);
        seekBar.setProgress(((Integer) C2295b.m10458a(C2295b.f6692d)).intValue());
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                C2295b.m10461a(C2295b.f6692d, Integer.valueOf(i));
            }
        });
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.volume_bar_ticking);
        seekBar2.setProgress(((Integer) C2295b.m10458a(C2295b.f6693e)).intValue());
        seekBar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                C2295b.m10461a(C2295b.f6693e, Integer.valueOf(i));
                C2250f.m10263a().mo7962d().mo7972b(i);
            }
        });
    }

    /* renamed from: n */
    private void m10053n() {
        m10045a((int) R.id.checkbox_keep_screen_on, C2295b.f6695g);
        m10045a((int) R.id.checkbox_vibrate, C2295b.f6694f);
    }

    /* renamed from: a */
    private void m10045a(int i, final C2296a<Boolean> aVar) {
        CheckBox checkBox = (CheckBox) findViewById(i);
        C2236b.m10219a((TextView) checkBox, C2237a.LATO_BOLD);
        checkBox.setChecked(((Boolean) C2295b.m10458a(aVar)).booleanValue());
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C2295b.m10461a(aVar, Boolean.valueOf(z));
            }
        });
    }

    /* renamed from: o */
    private void m10054o() {
        m10043a((int) R.id.spinner_short_break_duration, (int) R.array.short_breaks, C2295b.f6696h);
        m10043a((int) R.id.spinner_long_break_duration, (int) R.array.long_breaks, C2295b.f6697i);
        m10043a((int) R.id.spinner_pomodoro_duration, (int) R.array.pomodoro_duration, C2295b.f6698j);
        int i = C2250f.m10263a().mo7966h().mo7937a() ? Integer.MAX_VALUE : 2;
        int i2 = C2250f.m10263a().mo7966h().mo7937a() ? Integer.MAX_VALUE : 2;
        m10042a(R.id.spinner_ringing_sound, R.array.ringing_sounds_array, i, C2295b.f6699k, new C2186a() {
            /* renamed from: a */
            public void mo7814a(int i) {
                C2295b.m10461a(C2295b.f6699k, Integer.valueOf(i));
            }
        });
        m10042a(R.id.spinner_ticking_sound, R.array.ticking_sounds_array, i2, C2295b.f6700l, new C2186a() {
            /* renamed from: a */
            public void mo7814a(int i) {
                if (i != ((Integer) C2295b.m10458a(C2295b.f6700l)).intValue()) {
                    C2232f d = C2232f.m10212d();
                    C2295b.m10461a(C2295b.f6700l, Integer.valueOf(i));
                    C2250f.m10263a().mo7962d().mo7968a(d, C2232f.m10212d());
                }
            }
        });
    }

    /* renamed from: a */
    private void m10043a(int i, int i2, final C2296a<Integer> aVar) {
        Spinner spinner = (Spinner) findViewById(i);
        C2188c cVar = new C2188c((Context) this, 17367048, i2);
        cVar.setDropDownViewResource(17367049);
        spinner.setAdapter(cVar);
        spinner.setSelection(((Integer) C2295b.m10458a(aVar)).intValue());
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                C2295b.m10461a(aVar, Integer.valueOf(i));
            }
        });
    }

    /* renamed from: a */
    @SuppressLint("ResourceType")
    private void m10042a(int i, int i2, int i3, C2296a<Integer> aVar, C2186a aVar2) {
        String string = getResources().getString(R.string.pro_in_brackets);
        String[] stringArray = getResources().getStringArray(i2);
        for (int i4 = i3; i4 < stringArray.length; i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(stringArray[i4]);
            sb.append(" ");
            sb.append(string);
            stringArray[i4] = sb.toString();
        }
        Spinner spinner = (Spinner) findViewById(i);
        C2188c cVar = new C2188c((Context) this, 17367048, stringArray);
        cVar.setDropDownViewResource(17367049);
        spinner.setAdapter(cVar);
        spinner.setSelection(((Integer) C2295b.m10458a(aVar)).intValue());
        final int i5 = i3;
        final C2186a aVar3 = aVar2;
        final Spinner spinner2 = spinner;
        final C2296a<Integer> aVar4 = aVar;
        C217313 r0 = new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < i5) {
                    aVar3.mo7814a(i);
                    return;
                }
                spinner2.setSelection(((Integer) C2295b.m10458a(aVar4)).intValue());
                SettingsActivity.this.m10057r();
            }
        };
        spinner.setOnItemSelectedListener(r0);
    }

    /* renamed from: p */
    private void m10055p() {
        final ImageView imageView = (ImageView) findViewById(R.id.play_ringing_sample_btn);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                imageView.setEnabled(false);
                SettingsActivity.this.m10044a(C2232f.m10213e().mo7931b(), (C2187b) new C2187b() {
                    /* renamed from: a */
                    public void mo7820a() {
                        imageView.setEnabled(true);
                    }
                });
            }
        });
        final ImageView imageView2 = (ImageView) findViewById(R.id.play_ticking_sample_btn);
        imageView2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                imageView2.setEnabled(false);
                SettingsActivity.this.m10048b(C2232f.m10212d().mo7931b(), new C2187b() {
                    /* renamed from: a */
                    public void mo7820a() {
                        imageView2.setEnabled(true);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10044a(int i, final C2187b bVar) {
        final MediaPlayer create = MediaPlayer.create(this, i);
        if (create != null) {
            float intValue = ((float) ((Integer) C2295b.m10458a(C2295b.f6692d)).intValue()) / 100.0f;
            create.setVolume(intValue, intValue);
            create.start();
            create.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    create.release();
                    bVar.mo7820a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10048b(int i, final C2187b bVar) {
        final MediaPlayer create = MediaPlayer.create(this, i);
        if (create != null) {
            float intValue = ((float) ((Integer) C2295b.m10458a(C2295b.f6693e)).intValue()) / 100.0f;
            create.setVolume(intValue, intValue);
            create.seekTo(create.getDuration() - 4000);
            create.start();
            create.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    create.release();
                    bVar.mo7820a();
                }
            });
        }
    }

    /* renamed from: q */
    private void m10056q() {
        if (!C2250f.m10263a().mo7966h().mo7937a()) {
            Button button = (Button) findViewById(R.id.button_upgrade_to_premium);
            C2236b.m10219a((TextView) button, C2237a.LATO_BOLD);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    SettingsActivity.this.m10057r();
                }
            });
            button.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m10057r() {
        startActivity(new Intent(this, UpgradeToProActivity.class));
    }

    /* renamed from: s */
    private void m10058s() {
        Button button = (Button) findViewById(R.id.language_button);
        button.setText(getResources().getString(C2238c.m10226c()));
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2238c.m10221a((Activity) SettingsActivity.this);
            }
        });
    }

    /* renamed from: t */
    private void m10059t() {
        findViewById(R.id.terms_of_use).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2240d.m10227a("http://www.relaxio.net/terms-of-use-pomodoro-timer.html", SettingsActivity.this);
            }
        });
        findViewById(R.id.privacy_policy).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2240d.m10227a("http://www.relaxio.net/privacy-policy-pomodoro-timer.html", SettingsActivity.this);
            }
        });
    }
}
