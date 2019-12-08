package com.tatkovlab.pomodoro.p079e;

import android.content.Context;
import com.tatkovlab.pomodoro.p076b.PomodoroDatabaseHelper;
import com.tatkovlab.pomodoro.p076b.C2220c;
import com.tatkovlab.pomodoro.p076b.C2221d;
import com.tatkovlab.pomodoro.p076b.TaskInfo;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskType;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskStatus;
import com.tatkovlab.pomodoro.p081g.C2271e.C2272a;

public class C2258j {

    private TaskInfo taskInfo = null;

    C2258j(Context context) {
        PomodoroDatabaseHelper.m10138a(context);
        C2250f.m10263a().mo7962d().mo7969a(new C2272a() {
            public void mo7946a() {
                if (C2258j.this.taskInfo != null) {
                    C2258j.this.taskInfo.setNumberOfDone(C2258j.this.taskInfo.getNumberOfDone() + 1);
                    PomodoroDatabaseHelper.m10144b(C2258j.this.taskInfo);
                    C2258j.this.m10335a();
                }
            }

            public void mo7947b() {
                if (C2258j.this.taskInfo != null) {
                    C2258j.this.taskInfo.mo7904e(C2258j.this.taskInfo.getNumberOfAbandoned() + 1);
                    PomodoroDatabaseHelper.m10144b(C2258j.this.taskInfo);
                    C2258j.this.m10335a();
                }
            }
        });
        PomodoroDatabaseHelper.m10140a(new C2221d<TaskInfo>() {
            public void mo7844a(TaskInfo fVar) {
                C2258j.this.taskInfo = fVar;
                C2258j.this.m10335a();
            }
        });
    }

    public void m10335a() {
        if (this.taskInfo != null) {
            C2250f.m10263a().mo7963e().mo7944a(this.taskInfo.getTaskName(), (int) this.taskInfo.getNumberOfDone());
        } else {
            C2250f.m10263a().mo7963e().mo7944a(null, 0);
        }
    }

    public void mo7985a(TaskInfo fVar) {
        this.taskInfo = fVar;
        PomodoroDatabaseHelper.m10146d(fVar);
        m10335a();
    }

    public void mo7986b(TaskInfo fVar) {
        PomodoroDatabaseHelper.m10141a(fVar);
    }

    public void mo7987c(TaskInfo fVar) {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTaskName(fVar.getTaskName());
        taskInfo.setTaskStatus(TaskStatus.NEW);
        taskInfo.setTaskType(TaskType.TODAY);
        taskInfo.setEstimated(fVar.getEstimated());
        taskInfo.setNumberOfDone(0);
        taskInfo.mo7904e(0);
        taskInfo.mo7906f(System.currentTimeMillis());
        mo7986b(taskInfo);
    }

    public void mo7988d(TaskInfo fVar) {
        if (this.taskInfo != null && this.taskInfo.getId() == fVar.getId()) {
            this.taskInfo = null;
            m10335a();
        }
        PomodoroDatabaseHelper.m10145c(fVar);
    }

    public void mo7989e(TaskInfo fVar) {
        if (this.taskInfo != null && this.taskInfo.getId() == fVar.getId()) {
            this.taskInfo = fVar;
            if (this.taskInfo.getTaskStatus() == TaskStatus.FINISHED) {
                this.taskInfo = null;
            }
            m10335a();
        }
        PomodoroDatabaseHelper.m10144b(fVar);
    }

    public void mo7984a(C2220c<TaskInfo> cVar) {
        PomodoroDatabaseHelper.m10139a(cVar);
    }
}
