package com.tatkovlab.pomodoro;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p076b.C2223f;
import com.tatkovlab.pomodoro.p076b.C2223f.C2225a;
import com.tatkovlab.pomodoro.p076b.C2223f.C2226b;
import com.tatkovlab.pomodoro.p078d.C2236b;
import com.tatkovlab.pomodoro.p078d.C2236b.C2237a;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p079e.C2258j;
import com.tatkovlab.pomodorolite.R;

public class AddTaskActivity extends C2204a {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f6398j = 4;

    /* renamed from: k */
    private TextView f6399k;

    /* renamed from: l */
    private EditText f6400l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextView f6401m = null;

    /* renamed from: n */
    private SeekBar f6402n;

    /* renamed from: o */
    private C2223f f6403o = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_task);
        m10009k();
        m10010l();
        m10011m();
        m10012n();
        getWindow().setSoftInputMode(4);
        this.f6403o = (C2223f) getIntent().getParcelableExtra("edit_task_key");
        if (this.f6403o != null) {
            this.f6400l.setText(this.f6403o.mo7898c());
            this.f6402n.setProgress(((int) this.f6403o.mo7900d()) - 1);
            this.f6398j = (int) this.f6403o.mo7900d();
            this.f6399k.setText(R.string.header_edit_task);
        }
    }

    public void onResume() {
        super.onResume();
    }

    /* renamed from: k */
    private void m10009k() {
        this.f6399k = (TextView) findViewById(R.id.text_header);
        C2236b.m10219a(this.f6399k, C2237a.LATO_BOLD);
    }

    /* renamed from: l */
    private void m10010l() {
        this.f6400l = (EditText) findViewById(R.id.edit_text_task_name);
        C2236b.m10219a((TextView) findViewById(R.id.task_name_label), C2237a.LATO_BOLD);
    }

    /* renamed from: m */
    private void m10011m() {
        this.f6401m = (TextView) findViewById(R.id.text_expected_pomodoros);
        this.f6401m.setText(String.valueOf(this.f6398j));
        this.f6402n = (SeekBar) findViewById(R.id.seek_bar_expected_pomodoros);
        this.f6402n.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AddTaskActivity.this.f6398j = i + 1;
                AddTaskActivity.this.f6401m.setText(String.valueOf(AddTaskActivity.this.f6398j));
            }
        });
        C2236b.m10219a((TextView) findViewById(R.id.expected_pomodoros_label), C2237a.LATO_BOLD);
        C2236b.m10219a(this.f6401m, C2237a.LATO_BOLD);
    }

    /* renamed from: n */
    private void m10012n() {
        Button button = (Button) findViewById(R.id.btn_save);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AddTaskActivity.this.m10013o();
                AddTaskActivity.this.onBackPressed();
            }
        });
        C2236b.m10219a((TextView) button, C2237a.LATO_BOLD);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m10013o() {
        String obj = this.f6400l.getText().toString();
        if (this.f6403o == null) {
            m10005a(obj, this.f6398j);
        } else {
            m10007b(obj, this.f6398j);
        }
    }

    /* renamed from: a */
    private void m10005a(String str, int i) {
        C2223f fVar = new C2223f();
        fVar.mo7895a(str);
        fVar.mo7894a(C2226b.NEW);
        fVar.mo7893a(C2225a.TODAY);
        fVar.mo7899c((long) i);
        fVar.mo7901d(0);
        fVar.mo7904e(0);
        fVar.mo7906f(System.currentTimeMillis());
        m10014p().mo7986b(fVar);
    }

    /* renamed from: b */
    private void m10007b(String str, int i) {
        this.f6403o.mo7895a(str);
        this.f6403o.mo7899c((long) i);
        m10014p().mo7989e(this.f6403o);
    }

    /* renamed from: p */
    private C2258j m10014p() {
        return C2250f.m10263a().mo7964f();
    }
}
