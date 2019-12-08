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

    public int f6398j = 4;

    private TextView tvHeader;

    private EditText edTaskName;

    public TextView tvExpectedPromodoros = null;

    private SeekBar sbExpectedPodonoros;

    private TaskInfo f6403o = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_task);
        initHeader();
        m10010l();
        m10011m();
        initSaveButton();
        getWindow().setSoftInputMode(4);
        this.f6403o = getIntent().getParcelableExtra("edit_task_key");
        if (this.f6403o != null) {
            this.edTaskName.setText(this.f6403o.getTaskName());
            this.sbExpectedPodonoros.setProgress(((int) this.f6403o.getEstimated()) - 1);
            this.f6398j = (int) this.f6403o.getEstimated();
            this.tvHeader.setText(R.string.header_edit_task);
        }
    }

    public void onResume() {
        super.onResume();
    }

    private void initHeader() {
        this.tvHeader = findViewById(R.id.text_header);
        FontHelper.setTypeface(this.tvHeader, Fonts.LATO_BOLD);
    }

    private void m10010l() {
        this.edTaskName = findViewById(R.id.edit_text_task_name);
        FontHelper.setTypeface((TextView) findViewById(R.id.task_name_label), Fonts.LATO_BOLD);
    }

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

    public void m10013o() {
        String taskName = this.edTaskName.getText().toString();
        if (this.f6403o == null) {
            m10005a(taskName, this.f6398j);
        } else {
            m10007b(taskName, this.f6398j);
        }
    }

    private void m10005a(String str, int i) {
        TaskInfo fVar = new TaskInfo();
        fVar.setTaskName(str);
        fVar.setTaskStatus(TaskStatus.NEW);
        fVar.setTaskType(TaskType.TODAY);
        fVar.setEstimated((long) i);
        fVar.setNumberOfDone(0);
        fVar.mo7904e(0);
        fVar.mo7906f(System.currentTimeMillis());
        m10014p().mo7986b(fVar);
    }

    private void m10007b(String str, int i) {
        this.f6403o.setTaskName(str);
        this.f6403o.setEstimated((long) i);
        m10014p().mo7989e(this.f6403o);
    }

    private C2258j m10014p() {
        return C2250f.m10263a().mo7964f();
    }
}
