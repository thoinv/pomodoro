package com.tatkovlab.pomodoro.p075a;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.tatkovlab.pomodoro.p076b.TaskInfo;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskStatus;
import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodorolite.R;
import com.woxthebox.draglistview.DragItemAdapter;

import java.util.List;
import java.util.Locale;

public class TaskAdapter extends DragItemAdapter<TaskInfo, TaskAdapter.ViewHolder> {

    private int f6486a;

    private int f6487b;

    private List<TaskInfo> taskInfos;

    private C2208b f6489d;

    private C2207a f6490e;

    private C2207a f6491f;

    private boolean f6492g;

    public interface C2207a {
        void mo7851a(TaskInfo fVar);
    }

    public interface C2208b {
        void mo7852a(boolean z, int i);
    }

    public class ViewHolder extends DragItemAdapter.ViewHolder {

        private CheckBox ckDone;
        private TextView tvTaskName;
        private TextView tvDoneExpected;

        ViewHolder(View view) {
            super(view, TaskAdapter.this.f6486a, TaskAdapter.this.f6492g);
            this.ckDone = view.findViewById(R.id.isDone);
            this.tvTaskName = view.findViewById(R.id.taskName);
            this.tvDoneExpected = view.findViewById(R.id.doneExpectedTextBox);
        }

        @Override
        public void onItemClicked(View view) {
            if (TaskAdapter.this.f6490e != null) {
                TaskAdapter.this.f6490e.mo7851a(TaskAdapter.this.taskInfos.get(getAdapterPosition()));
            }
        }

        @Override
        public boolean onItemLongClicked(View view) {
            if (TaskAdapter.this.f6491f != null) {
                TaskAdapter.this.f6491f.mo7851a(TaskAdapter.this.taskInfos.get(getAdapterPosition()));
            }
            return false;
        }

        void bind(TaskInfo taskInfo) {
            tvTaskName.setText(taskInfo.getTaskName());
            TextView textView = tvDoneExpected;
            textView.setText(String.format(Locale.US, "%d/%d", taskInfo.getNumberOfDone(), taskInfo.getEstimated()));
            ckDone.setOnCheckedChangeListener(null);
            Resources resources = tvTaskName.getContext().getResources();
            FontHelper.setTypeface(tvTaskName, Fonts.PANGOLIN_REGULAR);
            FontHelper.setTypeface(tvDoneExpected, Fonts.PANGOLIN_REGULAR);
            if (taskInfo.getTaskStatus() == TaskStatus.FINISHED) {
                ckDone.setChecked(true);
                tvTaskName.setTextColor(resources.getColor(R.color.light_brown));
                tvTaskName.setBackground(ContextCompat.getDrawable(tvTaskName.getContext(), R.drawable.text_strikethrough));
                tvDoneExpected.setTextColor(resources.getColor(R.color.light_brown));
            } else {
                ckDone.setChecked(false);
                tvTaskName.setTextColor(resources.getColor(R.color.dark_brown));
                tvDoneExpected.setTextColor(resources.getColor(R.color.dark_brown));
                tvTaskName.setBackground(null);
            }
            ckDone.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (TaskAdapter.this.f6489d != null) {
                        TaskAdapter.this.f6489d.mo7852a(z, getAdapterPosition());
                    }
                }
            });
        }
    }

    public TaskAdapter(List<TaskInfo> taskInfos, int i, int i2, boolean z) {
        this.f6492g = z;
        this.f6487b = i;
        this.f6486a = i2;
        this.taskInfos = taskInfos;
        setItemList(taskInfos);
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.f6487b, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.bind(this.taskInfos.get(i));
    }

    public void mo7860a(C2208b bVar) {
        this.f6489d = bVar;
    }

    public void mo7859a(C2207a aVar) {
        this.f6490e = aVar;
    }

    public void mo7862b(C2207a aVar) {
        this.f6491f = aVar;
    }


    @Override
    public long getUniqueItemId(int position) {
        return System.currentTimeMillis();
    }
}
