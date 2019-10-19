package com.tatkovlab.pomodoro.p076b;

import android.os.Parcel;
import android.os.Parcelable;

public class TaskInfo implements Parcelable {
    public static final Creator<TaskInfo> CREATOR = new Creator<TaskInfo>() {
        /* renamed from: a */
        public TaskInfo createFromParcel(Parcel parcel) {
            TaskInfo fVar = new TaskInfo();
            fVar.f6513a = parcel.readLong();
            fVar.f6514b = parcel.readLong();
            fVar.f6515c = parcel.readString();
            fVar.f6516d = parcel.readLong();
            fVar.f6517e = parcel.readLong();
            fVar.f6518f = parcel.readLong();
            fVar.taskStatus = TaskStatus.m10194a(parcel.readLong());
            fVar.taskType = TaskType.m10192a(parcel.readLong());
            fVar.f6521i = parcel.readLong();
            return fVar;
        }

        /* renamed from: a */
        public TaskInfo[] newArray(int i) {
            return new TaskInfo[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f6513a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f6514b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f6515c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f6516d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f6517e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f6518f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TaskStatus taskStatus;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TaskType taskType;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f6521i;

    public enum TaskType {
        TODAY(1),
        ARCHIVE(2);
        

        final long intValue;

        TaskType(long intValue) {
            this.intValue = intValue;
        }

        /* renamed from: a */
        public long intValue() {
            return this.intValue;
        }

        /* renamed from: a */
        public static TaskType m10192a(long j) {
            switch ((int) j) {
                case 1:
                    return TODAY;
                case 2:
                    return ARCHIVE;
                default:
                    return null;
            }
        }
    }

    public enum TaskStatus {
        NEW(1),
        IN_PROGRESS(2),
        FINISHED(3);
        

        final long intValue;

        TaskStatus(long j) {
            this.intValue = j;
        }

        public long intValue() {
            return this.intValue;
        }

        /* renamed from: a */
        public static TaskStatus m10194a(long j) {
            switch ((int) j) {
                case 1:
                    return NEW;
                case 2:
                    return IN_PROGRESS;
                case 3:
                    return FINISHED;
                default:
                    return null;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public long mo7891a() {
        return this.f6513a;
    }

    /* renamed from: a */
    public void mo7892a(long j) {
        this.f6513a = j;
    }

    /* renamed from: b */
    public long mo7896b() {
        return this.f6514b;
    }

    /* renamed from: b */
    public void mo7897b(long j) {
        this.f6514b = j;
    }

    /* renamed from: c */
    public String mo7898c() {
        return this.f6515c;
    }

    /* renamed from: a */
    public void mo7895a(String str) {
        this.f6515c = str;
    }

    /* renamed from: d */
    public long mo7900d() {
        return this.f6516d;
    }

    /* renamed from: c */
    public void mo7899c(long j) {
        this.f6516d = j;
    }

    /* renamed from: e */
    public long mo7903e() {
        return this.f6517e;
    }

    /* renamed from: d */
    public void mo7901d(long j) {
        this.f6517e = j;
    }

    /* renamed from: f */
    public long mo7905f() {
        return this.f6518f;
    }

    /* renamed from: e */
    public void mo7904e(long j) {
        this.f6518f = j;
    }

    /* renamed from: g */
    public TaskStatus getTaskStatus() {
        return this.taskStatus;
    }

    /* renamed from: a */
    public void mo7894a(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    /* renamed from: h */
    public long mo7908h() {
        return this.f6521i;
    }

    /* renamed from: f */
    public void mo7906f(long j) {
        this.f6521i = j;
    }

    /* renamed from: i */
    public TaskType getTaskType() {
        return this.taskType;
    }

    /* renamed from: a */
    public void setTaskType(TaskType aVar) {
        this.taskType = aVar;
    }

    public String toString() {
        return this.f6515c +
                " " +
                this.f6516d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6513a);
        parcel.writeLong(this.f6514b);
        parcel.writeString(this.f6515c);
        parcel.writeLong(this.f6516d);
        parcel.writeLong(this.f6517e);
        parcel.writeLong(this.f6518f);
        parcel.writeLong(this.taskStatus.intValue());
        parcel.writeLong(this.taskType.intValue());
        parcel.writeLong(this.f6521i);
    }
}
