package com.tatkovlab.pomodoro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.tatkovlab.pomodoro.p075a.TaskAdapter;
import com.tatkovlab.pomodoro.p075a.TaskAdapter.C2207a;
import com.tatkovlab.pomodoro.p075a.TaskAdapter.C2208b;
import com.tatkovlab.pomodoro.p076b.C2220c;
import com.tatkovlab.pomodoro.p076b.TaskInfo;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskStatus;
import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p079e.C2258j;
import com.tatkovlab.pomodorolite.R;
import com.woxthebox.draglistview.DragListView;
import com.woxthebox.draglistview.DragListView.DragListListener;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends BaseActivity {

    public DragListView f6465j;

    public TaskAdapter f6466k;

    private MaterialDialog f6467l;
    //
    private MaterialDialog f6468m;

    private View f6469n;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tasks);
        m10101k();
        m10102l();
        m10104n();
        m10105o();
    }

    public void onResume() {
        super.onResume();
        m10106p();
    }

    public void onStop() {
        super.onStop();
        if (this.f6467l != null && this.f6467l.isShowing()) {
            this.f6467l.dismiss();
        }
        if (this.f6468m != null && this.f6468m.isShowing()) {
            this.f6468m.dismiss();
        }
    }

    private void m10101k() {
        FontHelper.setTypeface((TextView) findViewById(R.id.text_header), Fonts.LATO_BOLD);
    }

    private void m10102l() {
        this.f6469n = findViewById(R.id.placeholder_no_tasks);
        FontHelper.setTypeface((TextView) findViewById(R.id.placeholder_no_tasks_text), Fonts.PANGOLIN_REGULAR);
    }

    public void m10103m() {
        int i = 0;
        boolean z = this.f6466k == null || this.f6466k.getItemCount() == 0;
        View view = this.f6469n;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void m10104n() {
        findViewById(R.id.add_task_btn).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TasksActivity.this.startActivity(new Intent(TasksActivity.this, AddTaskActivity.class));
            }
        });
    }

    private void m10105o() {
        this.f6465j = findViewById(R.id.tasks_list);
        this.f6465j.setLayoutManager(new LinearLayoutManager(this));
        this.f6465j.setCanDragHorizontally(false);
        this.f6466k = new TaskAdapter(new ArrayList(), R.layout.list_item_task, R.id.drag_handle, false);
        this.f6465j.setAdapter(this.f6466k, true);
        this.f6465j.setDragListListener(new DragListListener() {
            public void onItemDragStarted(int i) {
            }

            public void onItemDragging(int i, float f, float f2) {
            }

            public void onItemDragEnded(int i, int i2) {
                long currentTimeMillis = System.currentTimeMillis();
                List itemList = TasksActivity.this.f6466k.getItemList();
                for (int i3 = 0; i3 < itemList.size(); i3++) {
                    TaskInfo fVar = (TaskInfo) itemList.get(i3);
                    fVar.setListOrder(currentTimeMillis);
                    TasksActivity.this.m10107q().mo7989e(fVar);
                    currentTimeMillis--;
                }
            }
        });
    }

    public void m10091b(TaskInfo fVar) {
        m10107q().mo7985a(fVar);
        onBackPressed();
    }

    public void m10094c(final TaskInfo fVar) {
        this.f6467l = new MaterialDialog.Builder(this)
                .title(fVar.getTaskName())
                .theme(Theme.LIGHT)
                .items(R.array.task_long_press_options)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        switch (which) {
                            case 0:
                                TasksActivity.this.m10099e(fVar);
                                return;
                            case 1:
                                TasksActivity.this.m10100f(fVar);
                                return;
                            case 2:
                                TasksActivity.this.mo7845a(fVar);

                        }
                    }
                }).show();
    }

    public void mo7845a(final TaskInfo fVar) {
        this.f6468m = new MaterialDialog.Builder(this)
                .title(getString(R.string.delete_task_confirmation_header))
                .content(getString(R.string.delete_task_confirmation_body, fVar.getTaskName()))
                .icon(ContextCompat.getDrawable(this, R.drawable.dialog_delete)) // FIXME: 2019-10-25 check againF
                .positiveText(R.string.delete_task_confirmation_confirm)
                .negativeText(R.string.delete_task_confirmation_cancel)
                .theme(Theme.LIGHT).onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        TasksActivity.this.m10097d(fVar);
                    }
                }).show();
    }

    public void m10097d(TaskInfo fVar) {
        this.f6466k.getItemList().remove(fVar);
        this.f6466k.notifyDataSetChanged();
        m10107q().mo7988d(fVar);
        m10103m();
    }

    public void m10099e(TaskInfo fVar) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        intent.putExtra("edit_task_key", fVar);
        startActivity(intent);
    }

    public void m10100f(TaskInfo fVar) {
        m10107q().mo7987c(fVar);
        m10106p();
    }

    public void m10088a(boolean z, int i) {
        TaskInfo fVar = this.f6466k.getItemList().get(i);
        fVar.setTaskStatus(z ? TaskStatus.FINISHED : TaskStatus.NEW);
        m10107q().mo7989e(fVar);
        this.f6466k.notifyDataSetChanged();
    }

    private void m10106p() {
        m10107q().mo7984a(new C2220c<TaskInfo>() {
            public void mo7850a(List<TaskInfo> taskInfos) {
                TasksActivity.this.f6466k = new TaskAdapter(taskInfos, R.layout.list_item_task, R.id.drag_handle, false);
                TasksActivity.this.f6466k.mo7859a(new C2207a() {
                    public void mo7851a(TaskInfo fVar) {
                        TasksActivity.this.m10091b(fVar);
                    }
                });
                TasksActivity.this.f6466k.mo7862b(new C2207a() {
                    public void mo7851a(TaskInfo fVar) {
                        TasksActivity.this.m10094c(fVar);
                    }
                });
                TasksActivity.this.f6466k.mo7860a(new C2208b() {
                    public void mo7852a(boolean z, int i) {
                        TasksActivity.this.m10088a(z, i);
                    }
                });
                TasksActivity.this.f6465j.setAdapter(TasksActivity.this.f6466k, true);
                TasksActivity.this.m10103m();
            }
        });
    }

    public C2258j m10107q() {
        return C2250f.m10263a().mo7964f();
    }
}
