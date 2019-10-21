package com.tatkovlab.pomodoro.p076b;

import android.os.Parcel;
import android.os.Parcelable;

public class TaskInfo implements Parcelable {
    public static final Creator<TaskInfo> CREATOR = new Creator<TaskInfo>() {
        /* renamed from: a */
        public TaskInfo createFromParcel(Parcel parcel) {
            TaskInfo fVar = new TaskInfo();
            fVar.id = parcel.readLong();
            fVar.listOrder = parcel.readLong();
            fVar.taskName = parcel.readString();
            fVar.estimated = parcel.readLong();
            fVar.numberOfDone = parcel.readLong();
            fVar.f6518f = parcel.readLong();
            fVar.taskStatus = TaskStatus.m10194a(parcel.readLong());
            fVar.taskType = TaskType.getTaskType(parcel.readLong());
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
    public long id;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long listOrder;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String taskName;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long estimated;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long numberOfDone;
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
        public static TaskType getTaskType(long intValue) {
            switch ((int) intValue) {
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
    public long getId() {
        return this.id;
    }

    /* renamed from: a */
    public void setId(long id) {
        this.id = id;
    }

    /* renamed from: b */
    public long getListOrder() {
        return this.listOrder;
    }

    /* renamed from: b */
    public void setListOrder(long j) {
        this.listOrder = j;
    }

    /* renamed from: c */
    public String getTaskName() {
        return this.taskName;
    }

    /* renamed from: a */
    public void setTaskName(String str) {
        this.taskName = str;
    }

    /* renamed from: d */
    public long getEstimated() {
        return this.estimated;
    }

    /* renamed from: c */
    public void setEstimated(long estimated) {
        this.estimated = estimated;
    }

    /* renamed from: e */
    public long getNumberOfDone() {
        return this.numberOfDone;
    }

    /* renamed from: d */
    public void setNumberOfDone(long j) {
        this.numberOfDone = j;
    }

    /* renamed from: f */
    public long getNumberOfAbandoned() {
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
    public void setTaskStatus(TaskStatus taskStatus) {
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
        return this.taskName +
                " " +
                this.estimated;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeLong(this.listOrder);
        parcel.writeString(this.taskName);
        parcel.writeLong(this.estimated);
        parcel.writeLong(this.numberOfDone);
        parcel.writeLong(this.f6518f);
        parcel.writeLong(this.taskStatus.intValue());
        parcel.writeLong(this.taskType.intValue());
        parcel.writeLong(this.f6521i);
    }
}
