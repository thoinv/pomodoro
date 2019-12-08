package com.tatkovlab.pomodoro;

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

import butterknife.BindView;
import butterknife.OnClick;

public class AddTaskActivity extends BaseActivity {

    @BindView(R.id.text_header)
    TextView tvHeader;

    @BindView(R.id.edit_text_task_name)
    EditText edTaskName;

    @BindView(R.id.text_expected_pomodoros)
    TextView tvExpectedPromodoros;

    @BindView(R.id.seek_bar_expected_pomodoros)
    SeekBar sbExpectedPodonoros;

    @BindView(R.id.expected_pomodoros_label)
    TextView tvExpectedPomodorosLabel;

    @BindView(R.id.task_name_label)
    TextView tvTaskNameLabel;

    @BindView(R.id.btn_save)
    Button btSave;

    public int f6398j = 4;
    TaskInfo f6403o = null;

    @Override
    protected void initViews() {
        initHeader();
        m10010l();
        m10011m();
        FontHelper.setTypeface(btSave, Fonts.LATO_BOLD);
        getWindow().setSoftInputMode(4);
        this.f6403o = getIntent().getParcelableExtra("edit_task_key");
        if (this.f6403o != null) {
            this.edTaskName.setText(this.f6403o.getTaskName());
            this.sbExpectedPodonoros.setProgress(((int) this.f6403o.getEstimated()) - 1);
            this.f6398j = (int) this.f6403o.getEstimated();
            this.tvHeader.setText(R.string.header_edit_task);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_task;
    }

    public void onResume() {
        super.onResume();
    }

    private void initHeader() {
        FontHelper.setTypeface(this.tvHeader, Fonts.LATO_BOLD);
    }

    private void m10010l() {
        FontHelper.setTypeface(tvTaskNameLabel, Fonts.LATO_BOLD);
    }

    private void m10011m() {
        this.tvExpectedPromodoros.setText(String.valueOf(this.f6398j));
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
        FontHelper.setTypeface(tvExpectedPomodorosLabel, Fonts.LATO_BOLD);
        FontHelper.setTypeface(this.tvExpectedPromodoros, Fonts.LATO_BOLD);
    }

    @OnClick(R.id.btn_save)
    void onButtonSaveClicked() {
        AddTaskActivity.this.m10013o();
        AddTaskActivity.this.onBackPressed();
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
