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

/* renamed from: com.tatkovlab.pomodoro.a.a */
public class C2205a extends DragItemAdapter<TaskInfo, C2205a.C2209c> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f6486a;

    /* renamed from: b */
    private int f6487b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<TaskInfo> f6488c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2208b f6489d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2207a f6490e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2207a f6491f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f6492g;

    /* renamed from: com.tatkovlab.pomodoro.a.a$a */
    public interface C2207a {
        /* renamed from: a */
        void mo7851a(TaskInfo fVar);
    }

    /* renamed from: com.tatkovlab.pomodoro.a.a$b */
    public interface C2208b {
        /* renamed from: a */
        void mo7852a(boolean z, int i);
    }

    /* renamed from: com.tatkovlab.pomodoro.a.a$c */
    public class C2209c extends DragItemAdapter.ViewHolder {

        /* renamed from: a */
        CheckBox ckDone;

        /* renamed from: b */
        TextView tvTaskName;

        /* renamed from: c */
        TextView tvDoneExpected;

        C2209c(View view) {
            super(view, C2205a.this.f6486a, C2205a.this.f6492g);
            this.ckDone = view.findViewById(R.id.isDone);
            this.tvTaskName = view.findViewById(R.id.taskName);
            this.tvDoneExpected = view.findViewById(R.id.doneExpectedTextBox);
        }

        public void onItemClicked(View view) {
            if (C2205a.this.f6490e != null) {
                C2205a.this.f6490e.mo7851a(C2205a.this.f6488c.get(getAdapterPosition()));
            }
        }

        public boolean onItemLongClicked(View view) {
            if (C2205a.this.f6491f != null) {
                C2205a.this.f6491f.mo7851a(C2205a.this.f6488c.get(getAdapterPosition()));
            }
            return false;
        }
    }

    public C2205a(List<TaskInfo> list, int i, int i2, boolean z) {
        this.f6492g = z;
        this.f6487b = i;
        this.f6486a = i2;
        this.f6488c = list;
        setItemList(list);
        setHasStableIds(true);
    }

    /* renamed from: a */
    @NonNull
    @Override
    public C2209c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C2209c(LayoutInflater.from(viewGroup.getContext()).inflate(this.f6487b, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(C2209c cVar, int i) {
        super.onBindViewHolder(cVar, i);
        m10123a(cVar, this.f6488c.get(i));
    }

    /* renamed from: a */
    public void mo7860a(C2208b bVar) {
        this.f6489d = bVar;
    }

    /* renamed from: a */
    public void mo7859a(C2207a aVar) {
        this.f6490e = aVar;
    }

    /* renamed from: b */
    public void mo7862b(C2207a aVar) {
        this.f6491f = aVar;
    }


    @Override
    public long getUniqueItemId(int position) {
        return System.currentTimeMillis();
    }

//    public long getItemId(int i) {
//        return ((C2223f) this.f6488c.getValue(i)).getId();
//    }

    /* renamed from: a */
    private void m10123a(final C2209c cVar, TaskInfo fVar) {
        cVar.tvTaskName.setText(fVar.getTaskName());
        TextView textView = cVar.tvDoneExpected;
        StringBuilder sb = new StringBuilder();
        sb.append(fVar.getNumberOfDone());
        sb.append("/");
        sb.append(fVar.getEstimated());
        textView.setText(sb.toString());
        cVar.ckDone.setOnCheckedChangeListener(null);
        Resources resources = cVar.tvTaskName.getContext().getResources();
        FontHelper.setTypeface(cVar.tvTaskName, Fonts.PANGOLIN_REGULAR);
        FontHelper.setTypeface(cVar.tvDoneExpected, Fonts.PANGOLIN_REGULAR);
        if (fVar.getTaskStatus() == TaskStatus.FINISHED) {
            cVar.ckDone.setChecked(true);
            cVar.tvTaskName.setTextColor(resources.getColor(R.color.light_brown));
            cVar.tvTaskName.setBackgroundDrawable(ContextCompat.getDrawable(cVar.tvTaskName.getContext(), R.drawable.text_strikethrough));
            cVar.tvDoneExpected.setTextColor(resources.getColor(R.color.light_brown));
        } else {
            cVar.ckDone.setChecked(false);
            cVar.tvTaskName.setTextColor(resources.getColor(R.color.dark_brown));
            cVar.tvDoneExpected.setTextColor(resources.getColor(R.color.dark_brown));
            cVar.tvTaskName.setBackgroundDrawable(null);
        }
        cVar.ckDone.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (C2205a.this.f6489d != null) {
                    C2205a.this.f6489d.mo7852a(z, cVar.getAdapterPosition());
                }
            }
        });
    }
}
