package com.tatkovlab.pomodoro;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p076b.TaskInfo;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskType;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskStatus;
import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p079e.C2258j;
import com.tatkovlab.pomodorolite.R;

public class AddTaskActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f6398j = 4;

    /* renamed from: k */
    private TextView tvHeader;

    /* renamed from: l */
    private EditText edTaskName;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextView tvExpectedPromodoros = null;

    /* renamed from: n */
    private SeekBar sbExpectedPodonoros;

    /* renamed from: o */
    private TaskInfo f6403o = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_task);
        m10009k();
        m10010l();
        m10011m();
        initSaveButton();
        getWindow().setSoftInputMode(4);
        this.f6403o = getIntent().getParcelableExtra("edit_task_key");
        if (this.f6403o != null) {
            this.edTaskName.setText(this.f6403o.mo7898c());
            this.sbExpectedPodonoros.setProgress(((int) this.f6403o.mo7900d()) - 1);
            this.f6398j = (int) this.f6403o.mo7900d();
            this.tvHeader.setText(R.string.header_edit_task);
        }
    }

    public void onResume() {
        super.onResume();
    }

    /* renamed from: k */
    private void m10009k() {
        this.tvHeader = findViewById(R.id.text_header);
        FontHelper.setTypeface(this.tvHeader, Fonts.LATO_BOLD);
    }

    /* renamed from: l */
    private void m10010l() {
        this.edTaskName = findViewById(R.id.edit_text_task_name);
        FontHelper.setTypeface((TextView) findViewById(R.id.task_name_label), Fonts.LATO_BOLD);
    }

    /* renamed from: m */
    private void m10011m() {
        this.tvExpectedPromodoros = findViewById(R.id.text_expected_pomodoros);
        this.tvExpectedPromodoros.setText(String.valueOf(this.f6398j));
        this.sbExpectedPodonoros = findViewById(R.id.seek_bar_expected_pomodoros);
        this.sbExpectedPodonoros.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AddTaskActivity.this.f6398j = i + 1;
                AddTaskActivity.this.tvExpectedPromodoros.setText(String.valueOf(AddTaskActivity.this.f6398j));
            }
        });
        FontHelper.setTypeface((TextView) findViewById(R.id.expected_pomodoros_label), Fonts.LATO_BOLD);
        FontHelper.setTypeface(this.tvExpectedPromodoros, Fonts.LATO_BOLD);
    }

    /* renamed from: n */
    private void initSaveButton() {
        Button button = findViewById(R.id.btn_save);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AddTaskActivity.this.m10013o();
                AddTaskActivity.this.onBackPressed();
            }
        });
        FontHelper.setTypeface(button, Fonts.LATO_BOLD);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m10013o() {
        String obj = this.edTaskName.getText().toString();
        if (this.f6403o == null) {
            m10005a(obj, this.f6398j);
        } else {
            m10007b(obj, this.f6398j);
        }
    }

    /* renamed from: a */
    private void m10005a(String str, int i) {
        TaskInfo fVar = new TaskInfo();
        fVar.mo7895a(str);
        fVar.mo7894a(TaskStatus.NEW);
        fVar.setTaskType(TaskType.TODAY);
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
